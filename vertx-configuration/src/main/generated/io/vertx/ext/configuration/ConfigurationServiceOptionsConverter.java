/*
 * Copyright 2014 Red Hat, Inc.
 *
 * Red Hat licenses this file to you under the Apache License, version 2.0
 * (the "License"); you may not use this file except in compliance with the
 * License.  You may obtain a copy of the License at:
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.  See the
 * License for the specific language governing permissions and limitations
 * under the License.
 */

package io.vertx.ext.configuration;

import io.vertx.core.json.JsonObject;
import io.vertx.core.json.JsonArray;

/**
 * Converter for {@link io.vertx.ext.configuration.ConfigurationServiceOptions}.
 *
 * NOTE: This class has been automatically generated from the {@link io.vertx.ext.configuration.ConfigurationServiceOptions} original class using Vert.x codegen.
 */
public class ConfigurationServiceOptionsConverter {

  public static void fromJson(JsonObject json, ConfigurationServiceOptions obj) {
    if (json.getValue("scanPeriod") instanceof Number) {
      obj.setScanPeriod(((Number)json.getValue("scanPeriod")).longValue());
    }
    if (json.getValue("stores") instanceof JsonArray) {
      json.getJsonArray("stores").forEach(item -> {
        if (item instanceof JsonObject)
          obj.addStore(new io.vertx.ext.configuration.ConfigurationStoreOptions((JsonObject)item));
      });
    }
  }

  public static void toJson(ConfigurationServiceOptions obj, JsonObject json) {
    json.put("scanPeriod", obj.getScanPeriod());
    if (obj.getStores() != null) {
      json.put("stores", new JsonArray(
          obj.getStores().
              stream().
              map(item -> item.toJson()).
              collect(java.util.stream.Collectors.toList())));
    }
  }
}