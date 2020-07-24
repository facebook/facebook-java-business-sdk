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

package com.facebook.ads.utils;

import com.facebook.ads.sdk.serverside.CustomData;

import com.google.gson.annotations.SerializedName;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

import java.lang.reflect.Field;
import java.lang.reflect.Type;

public class CustomDataAdapter implements JsonSerializer<CustomData> {

    private Gson gson = new Gson();

    public Gson getGsonInstance() {
        if (gson == null) {
            gson = new Gson();
        }
        return gson;
    }

    @Override
    public JsonElement serialize(final CustomData src, Type typeOfSrc, final JsonSerializationContext context) {

        final JsonObject serializedObject = new JsonObject();

        for (Field field : src.getClass().getDeclaredFields()) {
            try {
                field.setAccessible(true);
                SerializedName serializedName = field.getAnnotation(SerializedName.class);

                // Serializing custom_data fields
                if (null != serializedName && null != field.get(src)) {

                    // Normalizing Currency Parameter
                    if (field.getName() == ServerSideApiConstants.CURRENCY) {
                        String normalizedCurrency = ServerSideApiUtil.normalize(String.valueOf(field.get(src)), ServerSideApiConstants.CURRENCY);
                        serializedObject.addProperty(serializedName.value(), normalizedCurrency);
                    } else {
                        serializedObject.add(serializedName.value(),this.getGsonInstance().toJsonTree(field.get(src)));
                    }
                }
            } catch (IllegalAccessException ex) {
                ex.printStackTrace();
            }
        }

        // Adding Custom Properties to serialized object
        if (null != src.getCustomProperties()) {
            for (final String key : src.getCustomProperties().keySet()) {
                serializedObject.addProperty(key, src.getCustomProperties().get(key));
            }
        }

        return serializedObject;
    }
}
