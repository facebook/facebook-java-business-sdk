/**
 * Copyright (c) 2015-present, Facebook, Inc. All rights reserved.
 * <p>
 * You are hereby granted a non-exclusive, worldwide, royalty-free license to use, copy, modify, and
 * distribute this software in source code or binary form for use in connection with the web
 * services and APIs provided by Facebook.
 * <p>
 * As with any software that integrates with the Facebook platform, your use of this software is
 * subject to the Facebook Developer Principles and Policies [http://developers.facebook.com/policy/].
 * This copyright notice shall be included in all copies or substantial portions of the software.
 * <p>
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT
 * NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 * NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM,
 * DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */
package com.facebook.ads.sdk.serverside.utils;

import com.facebook.ads.utils.ServerSideApiUtil;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.lang.reflect.Field;

public class Sha256StringAdaptor extends TypeAdapter<String> {

  @Override
  public String read(JsonReader reader) throws IOException {
    return reader.nextString();
  }

  @Override
  public void write(JsonWriter writer, String input) throws IOException {
    String hashedValue = null;
    if (input != null) {
      String fieldName = null;
      try {
        fieldName = this.getFieldName(writer);
      } catch (NoSuchFieldException ex) {
        ex.printStackTrace();
        throw new RuntimeException("Error while reading current serializing field's name", ex);
      }
      catch (IllegalAccessException ex) {
        ex.printStackTrace();
        throw new RuntimeException("Error while reading current serializing field's name", ex);
      }

      if(ServerSideApiUtil.isAlreadyHashed(input)) {
        hashedValue = input;
      }
      else {
        String normalizedString = ServerSideApiUtil.normalize(input, fieldName);
        if (normalizedString != null) {
          hashedValue = ServerSideApiUtil.hash(normalizedString);
        }
      }
    }

    writer.value(hashedValue);
  }

  protected String getFieldName(JsonWriter writer)
      throws NoSuchFieldException, IllegalAccessException {

    Field nameField = JsonWriter.class.getDeclaredField("deferredName");
    nameField.setAccessible(true);
    return (String) nameField.get(writer);
  }
}
