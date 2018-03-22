package com.huawei.openstack4j.openstack.compute.v1.contants;

import com.google.common.base.Strings;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Model for Server Bandwidth Charging Mode 
 *
 * @author QianBiao.NG
 * @date   2017-07-18 09:07:40
 */
public enum NetworkChargingMode {
	
	TRAFFIC("traffic"), BANDWIDTH("bandwidth");

	private String val;

	private NetworkChargingMode(String val) {
		this.val = val;
	}

	@JsonValue
	public String getVal() {
		return this.val;
	}

	@JsonCreator
	public NetworkChargingMode forValue(String value) {
		if (!Strings.isNullOrEmpty(value)) {
			for (NetworkChargingMode mode : NetworkChargingMode.values()) {
				if (mode.getVal().equalsIgnoreCase(value)) {
					return mode;
				}
			}
		}
		return null;
	}
}
