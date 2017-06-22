/*******************************************************************************
 * 	Copyright 2017 HuaWei Tld                                     
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
package org.openstack4j.openstack.loadbalance.domain;

import java.util.Date;

import org.openstack4j.model.loadbalance.ListenerUpdateResp;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class ELBListenerUpdateResp implements ListenerUpdateResp {

	private static final long serialVersionUID = 2402527926955142969L;

	@JsonProperty("update_time")
	private Date updateTime;

	@JsonProperty("backend_port")
	private Integer backendPort;

	private String id;

	@JsonProperty("backend_protocol")
	private String backendProtocol;

	@JsonProperty("sticky_session_type")
	private String stickySessionType;

	private String description;

	@JsonProperty("loadbalancer_id")
	private String loadBalancerId;

	@JsonProperty("create_time")
	private Date createTime;

	private String status;

	private String protocol;

	private Integer port;

	@JsonProperty("cookie_timeout")
	private Integer cookieTimeout;

	@JsonProperty("admin_state_up")
	private Boolean adminStateUp;

	@JsonProperty("healthcheck_id")
	private String healthCheckId;

	@JsonProperty("session_sticky")
	private Boolean sessionSticky;

	@JsonProperty("lb_algorithm")
	private String lbAlgorithm;

	private String name;

	@JsonProperty("tcp_draining")
	private Boolean tcpDraining;

	@JsonProperty("tcp_draining_timeout")
	private Integer tcpDrainingTimeout;

	@JsonProperty("certificate_id")
	private String certificateId;

}
