package com.huawei.openstack4j.openstack.vpc.v1.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.huawei.openstack4j.model.ModelEntity;
import com.huawei.openstack4j.openstack.vpc.v1.contants.IpType;
@Getter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonRootName("publicip")
public class VirtualPublicIpType implements ModelEntity{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6776710501544914385L;
	/**
	 * 
	 * 
	 * "publicip": {
        "type": "5_bgp"
    	}
	 */
	@JsonProperty("type")
	private IpType type;
	@JsonProperty("ip_address")
	private String ipAddress;
	
}
