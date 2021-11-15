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

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public abstract class HashedListAdaptor<T> extends TypeAdapter<List<T>> {

    @Override
    public List<T> read(JsonReader reader) throws IOException {
        if (reader.peek() == JsonToken.NULL) {
            reader.nextNull();
            return null;
        }

        List<T> list = new ArrayList();
        reader.beginArray();
        while (reader.hasNext()) {
            list.add(readFromJson(reader));
        }
        reader.endArray();
        return list;
    }

    /**
     * Type specific method on how to read from Json String.
     */
    protected abstract T readFromJson(JsonReader reader) throws IOException;

    @Override
    public void write(JsonWriter writer, List<T> input) throws IOException {
        if (input == null) {
            writer.nullValue();
            return;
        }

        Set<String> hashedValues = new HashSet();
        for (T value : input) {
            String fieldName = null;
            try {
                fieldName = this.getFieldName(writer);
            } catch (NoSuchFieldException ex) {
                ex.printStackTrace();
                throw new RuntimeException("Error while reading current serializing field's name", ex);
            } catch (IllegalAccessException ex) {
                ex.printStackTrace();
                throw new RuntimeException("Error while reading current serializing field's name", ex);
            }
            String hashedValue = normalizeAndHash(value, fieldName);
            if (hashedValue != null) {
                hashedValues.add(hashedValue);
            }
        }

        if(hashedValues.isEmpty()){
            writer.nullValue();
            return;
        }
        // Now actually write to Gson
        writer.beginArray();
        for (String hashedVal : hashedValues) {
            writer.value(hashedVal);
        }
        writer.endArray();
    }

    /**
     * Method to normalize and hash the given field and its value.
     * Each type may introduce its own implementation.
     */
    protected abstract String normalizeAndHash(T value, String fieldName);

    protected String getFieldName(JsonWriter writer)
            throws NoSuchFieldException, IllegalAccessException {

        Field nameField = JsonWriter.class.getDeclaredField("deferredName");
        nameField.setAccessible(true);
        return (String) nameField.get(writer);
    }
}

