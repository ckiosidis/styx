/*-
 * -\-\-
 * Spotify Styx Common
 * --
 * Copyright (C) 2017 Spotify AB
 * --
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * -/-/-
 */

package com.spotify.styx.model;

import io.norberg.automatter.AutoMatter;
import java.util.StringJoiner;

@AutoMatter
public interface FlyteIdentifier {
  String resourceType();
  String project();
  String domain();
  String name();
  String version();

  @AutoMatter.ToString
  default String urn() {
    return new StringJoiner(":")
        .add(resourceType())
        .add(project())
        .add(domain())
        .add(name())
        .add(version())
        .toString();
  }

  static FlyteIdentifierBuilder builder() {
    return new FlyteIdentifierBuilder();
  }
}
