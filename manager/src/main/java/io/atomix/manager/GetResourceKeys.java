/*
 * Copyright 2015 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.atomix.manager;

import io.atomix.catalyst.buffer.BufferInput;
import io.atomix.catalyst.buffer.BufferOutput;
import io.atomix.catalyst.serializer.CatalystSerializable;
import io.atomix.catalyst.serializer.SerializeWith;
import io.atomix.catalyst.serializer.Serializer;
import io.atomix.copycat.client.Query;

import java.util.Set;

/**
 * Get resource keys query.
 */
@SerializeWith(id=41)
public class GetResourceKeys implements Query<Set<String>>, CatalystSerializable {
  private int type;

  public GetResourceKeys() {
    type = 0;
  }

  public GetResourceKeys(int type) {
    this.type = type;
  }

  /**
   * Returns the resource state machine class.
   *
   * @return The resource state machine class
   */
  public int type() {
    return type;
  }

  @Override
  public void writeObject(BufferOutput<?> buffer, Serializer serializer) {
    buffer.writeShort((short) type);
  }

  @Override
  public void readObject(BufferInput<?> buffer, Serializer serializer) {
    type = buffer.readShort();
  }

}
