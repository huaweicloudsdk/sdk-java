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
package com.huawei.openstack4j.openstack.compute.domain.actions;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

/**
 * Floating IP based Actions
 * 
 * @author Jeremy Unruh
 */
public class FloatingIpActions implements ServerAction {

    private static final long serialVersionUID = 1L;
    
    @JsonProperty
    private String address;

    protected FloatingIpActions(String address) {
        this.address = address;
    }
    
    public String getAddress() {
        return address;
    }
    
    @JsonRootName("addFloatingIp")
    public static class Add extends FloatingIpActions {

        private static final long serialVersionUID = 1L;
        
        @JsonProperty("fixed_address")
        private String fixedAddress;
        
        private Add(String address, String fixedAddress) {
            super(address);
            this.fixedAddress = fixedAddress;
        }
        
        public static Add create(String address, String fixedAddress) {
            return new Add(address, fixedAddress);
        }
        
        @JsonIgnore
        public String getFixedAddress() {
            return fixedAddress;
        }
    }

    @JsonRootName("removeFloatingIp")
    public static class Remove extends FloatingIpActions {

        private static final long serialVersionUID = 1L;

        private Remove(String address) {
            super(address);
        }
        
        public static Remove create(String address) {
            return new Remove(address);
        }
        
    }
    
}
