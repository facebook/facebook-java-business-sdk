/**
 * Copyright (c) 2015-present, Facebook, Inc. All rights reserved.
 *
 * <p>You are hereby granted a non-exclusive, worldwide, royalty-free license to use, copy, modify,
 * and distribute this software in source code or binary form for use in connection with the web
 * services and APIs provided by Facebook.
 *
 * <p>As with any software that integrates with the Facebook platform, your use of this software is
 * subject to the Facebook Developer Principles and Policies [http://developers.facebook.com/policy/].
 * This copyright notice shall be included in all copies or substantial portions of the software.
 *
 * <p>THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING
 * BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 * NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM,
 * DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */
package com.facebook.ads.sdk.serverside.utils;

import com.facebook.ads.utils.ServerSideApiConstants;
import com.facebook.ads.utils.ServerSideApiUtil;
import com.google.gson.stream.JsonWriter;
import org.junit.Test;
import org.mockito.Mockito;

import java.io.IOException;

import static org.mockito.Mockito.*;

public class Sha256StringAdaptorTest {
  @Test
  public void WriteWorksWhenNormalizeFunctionReturnsNull() throws IOException, NoSuchFieldException, IllegalAccessException {
    JsonWriter writer = mock(JsonWriter.class);
    Sha256StringAdaptor adaptor = spy(new Sha256StringAdaptor());
    Mockito.doReturn(ServerSideApiConstants.LAST_NAME).when(adaptor).getFieldName(writer);
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
