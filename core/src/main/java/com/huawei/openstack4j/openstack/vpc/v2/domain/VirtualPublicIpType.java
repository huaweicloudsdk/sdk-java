package com.huawei.openstack4j.openstack.vpc.v2.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import com.huawei.openstack4j.openstack.vpc.v2.contants.IpType;
@Getter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class VirtualPublicIpType {

	private IpType type;
	
}
