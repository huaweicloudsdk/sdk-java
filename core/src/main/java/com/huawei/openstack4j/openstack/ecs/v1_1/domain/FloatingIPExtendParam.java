package com.huawei.openstack4j.openstack.ecs.v1_1.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.huawei.openstack4j.openstack.ecs.v1_1.contants.ServerChargingMode;
@Getter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FloatingIPExtendParam {

	@JsonProperty("chargingMode")
	private ServerChargingMode chargingMode;
}
