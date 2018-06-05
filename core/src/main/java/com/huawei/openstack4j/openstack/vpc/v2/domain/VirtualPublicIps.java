package com.huawei.openstack4j.openstack.vpc.v2.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import com.fasterxml.jackson.annotation.JsonProperty;

@Getter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class VirtualPublicIps {
	
	@JsonProperty("publicip")
	private VirtualPublicIpType virtualPublicIp;
	@JsonProperty("bandwidth")
	private VirtualBandWidth virtualBandwidth;
	@JsonProperty("extendParam")
	private VirtualExtendParam virtualExtendParam;
	
}
