package com.facebook.ads.utils;

import com.google.gson.stream.JsonWriter;
import org.junit.Test;

import java.io.IOException;

import static org.mockito.Mockito.*;

public class Sha256StringAdaptorTest {
  @Test
  public void WriteWorksWhenNormalizeFunctionReturnsNull() throws IOException, NoSuchFieldException, IllegalAccessException {
    JsonWriter writer = mock(JsonWriter.class);
    Sha256StringAdaptor adaptor = spy(new Sha256StringAdaptor());
    doReturn(ServerSideApiConstants.LAST_NAME).when(adaptor).getFieldName(writer);
    adaptor.write(writer, "   ");

    verify(writer).value((String) null);
  }

  @Test
  public void WriteWorksWhenNormalizeFunctionReturnsString() throws IOException, NoSuchFieldException, IllegalAccessException {
    JsonWriter writer = mock(JsonWriter.class);
    Sha256StringAdaptor adaptor = spy(new Sha256StringAdaptor());
    String fieldName = ServerSideApiConstants.LAST_NAME;
    doReturn(fieldName).when(adaptor).getFieldName(writer);
    String lastName = "LastName";
    String normalizedValue = ServerSideApiUtil.normalize(lastName, fieldName);
    String hashedValue = ServerSideApiUtil.hash(normalizedValue);
    adaptor.write(writer, lastName);

    verify(writer).value(hashedValue);
  }
}
