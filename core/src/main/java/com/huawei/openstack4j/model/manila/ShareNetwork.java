/*******************************************************************************
 * 	Copyright 2016 ContainX and OpenStack4j                                          
 * 	                                                                                 
 * 	Licensed under the Apache License, Version 2.0 (the "License"); you may not      
 * 	use this file except in compliance with the License. You may obtain a copy of    
 * 	the License at                                                                   
 * 	                                                                                 
 * 	    http://www.apache.org/licenses/LICENSE-2.0                                   
 * 	                                                                                 
 * 	Unless required by applicable law or agreed to in writing, software              
 * 	distributed under the License is distributed on an "AS IS" BASIS, WITHOUT        
 * 	WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the         
 * 	License for the specific language governing permissions and limitations under    
 * 	the License.                                                                     
 *******************************************************************************/
package com.huawei.openstack4j.model.manila;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.huawei.openstack4j.model.ModelEntity;

/**
 * A share network stores network information that share servers can use where shares are hosted.
 * A share network has these attributes:
 * <ul>
 * <li>The IP block in Classless Inter-Domain Routing (CIDR) notation from which to allocate the network.</li>
 * <li>The IP version of the network.</li>
 * <li>The network type, which is {@code vlan}, {@code vxlan}, {@code gre}, or {@code flat}.</li>
 * <li>If the network uses segmentation, a segmentation identifier. For example, VLAN, VXLAN,
 * and GRE networks use segmentation.</li>
 * </ul>
 *
 * @author Daniel Gonzalez Nothnagel
 */
public interface ShareNetwork extends ModelEntity {
    enum NetworkType {
        VLAN, VXLAN, GRE, FLAT;

        @JsonCreator
        public static NetworkType value(String v) {
            return valueOf(v.toUpperCase());
        }

        @JsonValue
        public String value() {
            return name().toLowerCase();
        }
    }

    /**
     * @return the share network ID
     */
    String getId();

    /**
     * @return the UUID of the project where the share network was created
     */
    String getProjectId();

    /**
     * @return the neutron network ID
     */
    String getNeutronNetId();

    /**
     * @return the neutron subnet ID
     */
    String getNeutronSubnetId();

    /**
     * @return the nova network ID
     */
    String getNovaNetId();

    /**
     * @return the network type
     */
    NetworkType getNetworkType();

    /**
     * @return the segmentation ID
     */
    Integer getSegmentationId();

    /**
     * @return the CIDR
     */
    String getCidr();

    /**
     * @return the IP version of the network
     */
    Integer getIpVersion();

    /**
     * @return the share network name
     */
    String getName();

    /**
     * @return the share network description
     */
    String getDescription();

    /**
     * @return the date and time stamp when the share network was created
     */
    String getCreatedAt();

    /**
     * @return the date and time stamp when the share network was updated
     */
    String getUpdatedAt();
}
