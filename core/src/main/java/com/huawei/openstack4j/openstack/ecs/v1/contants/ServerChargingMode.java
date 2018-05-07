package com.huawei.openstack4j.openstack.ecs.v1.contants;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Model for Server Bandwidth Charging Mode 
 *
 * @author QianBiao.NG
 * @date   2017-07-18 09:07:40
 */
public enum ServerChargingMode {

	/**
	 * 按需付费
	 */
	ByUsed(0); 

	private Integer val;

	private ServerChargingMode(Integer val) {
		this.val = val;
	}

	@JsonValue
	public Integer getVal() {
		return this.val;
	}

	@JsonCreator
	public ServerChargingMode forValue(Integer value) {
		for (ServerChargingMode mode : ServerChargingMode.values()) {
			if (mode.getVal().equals(value)) {
				return mode;
			}
		}
		return null;
	}
}
