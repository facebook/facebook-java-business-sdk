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

import com.facebook.ads.sdk.serverside.AppData;

import com.google.gson.annotations.SerializedName;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

import java.lang.reflect.Field;
import java.lang.reflect.Type;

public class AppDataAdapter implements JsonSerializer<AppData> {

    private Gson gson = new Gson();

    @Override
    public JsonElement serialize(final AppData src, Type typeOfSrc, final JsonSerializationContext context) {

        final JsonObject serializedObject = new JsonObject();

        for(Field field : src.getClass().getDeclaredFields()) {
            try {
                field.setAccessible(true);
                SerializedName serializedName = field.getAnnotation(SerializedName.class);

                //Serializing app_data fields
                if(null != serializedName && null != field.get(src)) {
                    if(field.getName() == "extinfo") {
                        serializedObject.addProperty(serializedName.value(), this.gson.toJson(src.getExtinfo().getExtendedDeviceInfoArray()));
                    } else {
                        serializedObject.add(serializedName.value(),this.gson.toJsonTree(field.get(src)));
                    }
                }

            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }

        }

        return serializedObject;

    }

}
