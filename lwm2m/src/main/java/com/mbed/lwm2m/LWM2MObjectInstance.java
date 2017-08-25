/**
 * Copyright (C) 2011-2017 Arm Limited. All rights reserved.
 * SPDX-License-Identifier: Apache-2.0
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
package com.mbed.lwm2m;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LWM2MObjectInstance {

    private final LWM2MID id;
    private final List<LWM2MResource> resources;

    public LWM2MObjectInstance(LWM2MID id, List<LWM2MResource> resources) {
        if (id != null) {
            this.id = id;
            this.resources = new ArrayList<>(resources);
        } else {
            throw new NullPointerException("LWM2MID");
        }
    }

    public LWM2MObjectInstance(LWM2MID id, LWM2MResource... resources) {
        this(id, Arrays.asList(resources));
    }

    public LWM2MObjectInstance(List<LWM2MResource> resources) {
        this(new LWM2MID(null), resources);
    }

    public LWM2MObjectInstance(LWM2MResource... resources) {
        this(Arrays.asList(resources));
    }

    public LWM2MID getId() {
        return id;
    }

    public List<LWM2MResource> getResources() {
        return resources;
    }

    public LWM2MResource getResource(LWM2MID id) {
        for (LWM2MResource resource : resources) {
            if (resource.getId().equals(id)) {
                return resource;
            }
        }
        return null;
    }

    public void addResource(LWM2MResource newResource) {
        resources.add(newResource);
    }

    public void addResources(List<LWM2MResource> newResources) {
        resources.addAll(newResources);
    }

    @Override
    public String toString() {
        return "ObjectInstance [id:" + id + ", value: " + resources.toString() + "]";
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((resources == null) ? 0 : resources.hashCode());
        return result;
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        LWM2MObjectInstance other = (LWM2MObjectInstance) obj;
        if (id == null) {
            if (other.id != null) {
                return false;
            }
        } else if (!id.equals(other.id)) {
            return false;
        }
        if (resources == null) {
            if (other.resources != null) {
                return false;
            }
        } else if (!Arrays.deepEquals(resources.toArray(), other.resources.toArray())) {
            return false;
        }
        return true;
    }

}
