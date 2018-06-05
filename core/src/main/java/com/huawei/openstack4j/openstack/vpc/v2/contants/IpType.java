package com.huawei.openstack4j.openstack.vpc.v2.contants;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * 	
	1、取值范围：5_telcom，5_union，5_bgp，5_sbgp
	东北：5_telcom、5_union
	华南：5_sbgp
	华东：5_sbgp
	2、功能说明：弹性公网IP的类型
	3、约束：必须是系统具体支持的类型
 * @author wWX547855
 *
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