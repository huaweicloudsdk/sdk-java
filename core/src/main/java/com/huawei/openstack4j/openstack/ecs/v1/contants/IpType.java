package com.huawei.openstack4j.openstack.ecs.v1.contants;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Server Bandwidth share type
 *
 * @author QianBiao.NG
 * @date   2017-07-18 09:07:40
 */
public enum IpType {
	
	BGP("5_bgp"),		// 全动态BGP
	SBGP("5_sbgp"),		// 静态BGP
	Telcom("5_telcom"),	// 中国电信
	Union("5_union");	// 中国联通

	String value;

	IpType(String value) {
		this.value = value;
	}

	@JsonValue
	public String value() {
		return value;
	}

	@JsonCreator
	public static IpType forValue(String value) {
		if (value != null) {
			for (IpType state : IpType.values()) {
				if (value.equals(state.value)) {
					return state;
				}
			}
		}
		return null;
	}
}