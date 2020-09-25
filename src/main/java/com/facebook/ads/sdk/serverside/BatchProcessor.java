package com.facebook.ads.sdk.serverside;

import com.facebook.ads.sdk.APIException;

import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class BatchProcessor {
  private int batchSize;
  private int concurrentRequests;

  public BatchProcessor(int batchSize, int concurrentRequests) {
    this.batchSize = batchSize;
    this.concurrentRequests = concurrentRequests;
  }

  public void processEventRequests(List<EventRequest> eventRequests) throws ExecutionException, InterruptedException {
    Iterator<List<ListenableFuture<EventResponse>>> it = processEventRequestsIterator(eventRequests);
    while (it.hasNext()) {
      List<ListenableFuture<EventResponse>> futures = it.next();
      Futures
          .allAsList(futures)
          .get();
    }
  }

  public Iterator<List<ListenableFuture<EventResponse>>> processEventsIterator(EventRequest eventRequestToClone, List<Event> events) {
    return new EventIterator(eventRequestToClone, events, this.batchSize, this.concurrentRequests);
  }

  public void processEvents(EventRequest eventRequestToClone, List<Event> events) throws ExecutionException, InterruptedException {
    Iterator<List<ListenableFuture<EventResponse>>> it = processEventsIterator(eventRequestToClone, events);
    while (it.hasNext()) {
      List<ListenableFuture<EventResponse>> futures = it.next();
      Futures
          .allAsList(futures)
          .get();
    }
  }

  public Iterator<List<ListenableFuture<EventResponse>>> processEventRequestsIterator(List<EventRequest> eventRequests) {
    return new EventRequestIterator(eventRequests, this.concurrentRequests);
  }

  protected static class EventIterator implements Iterator<List<ListenableFuture<EventResponse>>> {
    private final EventRequest eventRequestToClone;
    private final List<Event> events;
    int concurrentRequests;
    int batchSize;
    int index;

    public EventIterator(EventRequest eventRequestToClone, List<Event> events, int batchSize, int concurrentRequests) {
      this.eventRequestToClone = eventRequestToClone;
      this.events = events;
      this.batchSize = batchSize;
      this.concurrentRequests = concurrentRequests;
      this.index = 0;
    }

    public boolean hasNext() {
      return index < events.size();
    }

    public List<ListenableFuture<EventResponse>> next() {
      List<ListenableFuture<EventResponse>> responses = new ArrayList<ListenableFuture<EventResponse>>();
      int i = index;
      while (i < events.size() && responses.size() < concurrentRequests) {
        EventRequest eventRequest = eventRequestToClone.cloneWithoutData();
        int maxIndex = Math.min(i + batchSize, events.size());
        eventRequest.setData(events.subList(i, maxIndex));
        try {
          responses.add(
              eventRequest.executeAsync()
          );
        } catch (APIException e) {
          e.printStackTrace();
        }
        i += batchSize;
      }
      this.index = i;
      return responses;
    }

    public void remove() {
    }
  }

  protected static class EventRequestIterator implements Iterator<List<ListenableFuture<EventResponse>>> {
    private final List<EventRequest> eventRequests;
    int concurrentRequests;
    int index;

    public EventRequestIterator(List<EventRequest> eventRequests, int concurrentRequests) {
      this.eventRequests = eventRequests;
      this.concurrentRequests = concurrentRequests;
      this.index = 0;
    }

    public boolean hasNext() {
      return index < eventRequests.size();
    }

    public List<ListenableFuture<EventResponse>> next() {
      List<ListenableFuture<EventResponse>> responses = new ArrayList<ListenableFuture<EventResponse>>();
      int i = index;
      while (i < (index + concurrentRequests) && i < eventRequests.size()) {
        try {
          responses.add(
              eventRequests.get(i).executeAsync()
          );
        } catch (APIException e) {
          e.printStackTrace();
        }
        i++;
      }
      this.index = i;
      return responses;
    }

    public void remove() {

    }
  }
}
