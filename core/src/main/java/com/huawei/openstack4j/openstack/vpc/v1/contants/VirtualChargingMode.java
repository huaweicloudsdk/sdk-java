package com.huawei.openstack4j.openstack.vpc.v1.contants;

import com.google.common.base.Strings;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Model for Server Bandwidth Charging Mode 
 *
 * @author QianBiao.NG
 * @date   2017-07-18 09:07:40
 */
public enum VirtualChargingMode {
	
	TRAFFIC("traffic"), BANDWIDTH("bandwidth");

	private String val;

	private VirtualChargingMode(String val) {
		this.val = val;
	}

	@JsonValue
	public String getVal() {
		return this.val;
	}

	@JsonCreator
	public VirtualChargingMode forValue(String value) {
		if (!Strings.isNullOrEmpty(value)) {
			for (VirtualChargingMode mode : VirtualChargingMode.values()) {
				if (mode.getVal().equalsIgnoreCase(value)) {
					return mode;
				}
			}
		}
		return null;
	}
}
