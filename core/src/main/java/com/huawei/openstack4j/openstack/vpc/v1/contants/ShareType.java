package com.huawei.openstack4j.openstack.vpc.v1.contants;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Server Bandwidth share type
 *
 * @author QianBiao.NG
 * @date   2017-07-18 09:07:40
 */
public enum ShareType {

	PER("PER"),// 独享
	WHOLE("WHOLE");	// 独享

	String value;

	ShareType(String value) {
		this.value = value;
	}

	@JsonValue
	public String value() {
		return value;
	}

	@JsonCreator
	public static ShareType forValue(String value) {
		if (value != null) {
			for (ShareType state : ShareType.values()) {
				if (value.equals(state.value)) {
					return state;
				}
			}
		}
		return null;
	}
}