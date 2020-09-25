package com.facebook.ads.sdk.serverside;

import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.ArgumentMatchers;
import org.mockito.Captor;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class BatchProcessorTest {
  @Before
  public void init() {
    MockitoAnnotations.initMocks(this);
  }

  @Captor
  private ArgumentCaptor<List<Event>> eventsCaptor;

  @Test
  public void ProcessEventRequestsIteratorTest() throws Exception {
    List<EventRequest> eventRequests = new ArrayList<EventRequest>();
    eventRequests.add(mock(EventRequest.class));
    eventRequests.add(mock(EventRequest.class));
    eventRequests.add(mock(EventRequest.class));
    BatchProcessor batchProcessor = new BatchProcessor(2, 2);
    int iterations = 0;
    Iterator<List<ListenableFuture<EventResponse>>> it = batchProcessor.processEventRequestsIterator(eventRequests);
    while (it.hasNext()) {
      it.next();
      iterations += 1;
    }

    assertEquals(iterations, 2);
    for (EventRequest eventRequest : eventRequests) {
      verify(eventRequest).executeAsync();
    }
  }

  @Test
  public void ProcessEventRequestsTest() throws Exception {
    List<EventRequest> eventRequests = new ArrayList<EventRequest>();
    EventRequest mock1 = mock(EventRequest.class);
    EventRequest mock2 = mock(EventRequest.class);
    doReturn(Futures.immediateFuture(mock(EventResponse.class))).when(mock1).executeAsync();
    doReturn(Futures.immediateFuture(mock(EventResponse.class))).when(mock2).executeAsync();
    eventRequests.add(mock1);
    eventRequests.add(mock2);
    BatchProcessor batchProcessor = new BatchProcessor(2, 2);
    batchProcessor.processEventRequests(eventRequests);

    for (EventRequest eventRequest : eventRequests) {
      verify(eventRequest).executeAsync();
    }
  }

  @Test
  public void ProcessEventsIteratorTest() throws Exception {
    List<Event> events = new ArrayList<Event>();
    events.add(mock(Event.class));
    events.add(mock(Event.class));
    events.add(mock(Event.class));
    events.add(mock(Event.class));
    events.add(mock(Event.class));
    events.add(mock(Event.class));
    events.add(mock(Event.class));
    EventRequest eventRequestMock1 = mock(EventRequest.class);
    EventRequest eventRequestMock2 = mock(EventRequest.class);
    when(eventRequestMock1.cloneWithoutData()).thenReturn(eventRequestMock2);
    doReturn(Futures.immediateFuture(mock(EventResponse.class))).when(eventRequestMock2).executeAsync();
    BatchProcessor batchProcessor = new BatchProcessor(2, 3);
    int iterations = 0;
    Iterator<List<ListenableFuture<EventResponse>>> it = batchProcessor.processEventsIterator(eventRequestMock1, events);
    while (it.hasNext()) {
      List<ListenableFuture<EventResponse>> next = it.next();
      iterations += 1;
    }

    assertEquals(2, iterations);
    verify(eventRequestMock1, times(4)).cloneWithoutData();
    verify(eventRequestMock2, times(4)).executeAsync();
    verify(eventRequestMock2, times(4)).setData(eventsCaptor.capture());
    assertEquals(
        eventsCaptor.getAllValues(),
        Arrays.asList(
            events.subList(0, 2),
            events.subList(2, 4),
            events.subList(4, 6),
            events.subList(6, 7)
        )
    );
  }

  @Test
  public void ProcessEventsTest() throws Exception {
    List<Event> events = new ArrayList<Event>();
    events.add(mock(Event.class));
    events.add(mock(Event.class));
    events.add(mock(Event.class));
    events.add(mock(Event.class));
    events.add(mock(Event.class));
    EventRequest eventRequestMock1 = mock(EventRequest.class);
    EventRequest eventRequestMock2 = mock(EventRequest.class);
    when(eventRequestMock1.cloneWithoutData()).thenReturn(eventRequestMock2);
    doReturn(Futures.immediateFuture(mock(EventResponse.class))).when(eventRequestMock2).executeAsync();
    BatchProcessor batchProcessor = new BatchProcessor(2, 2);
    batchProcessor.processEvents(eventRequestMock1, events);

    verify(eventRequestMock1, times(3)).cloneWithoutData();
    verify(eventRequestMock2, times(3)).executeAsync();
    verify(eventRequestMock2, times(3)).setData(ArgumentMatchers.<Event>anyList());
  }
}
