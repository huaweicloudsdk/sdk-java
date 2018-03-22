package com.huawei.openstack4j.openstack.compute.v1.contants;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum VolumeType {

	SATA("SATA"), 	// 普通IO磁盘类型。
	SAS("SAS"),		// 高IO磁盘类型。
	SSD("SSD"),		// 超高IO磁盘类型。
	CO_PL("co-pl"),	// 高IO (性能优化Ⅰ型)
	UH_L1("uh-l1"),	// 超高IO (时延优化)
	;	
	

	String value;

	VolumeType(String value) {
		this.value = value;
	}

	@JsonValue
	public String value() {
		return value;
	}

	@JsonCreator
	public static VolumeType forValue(String value) {
		if (value != null) {
			for (VolumeType state : VolumeType.values()) {
				if (value.equals(state.value)) {
					return state;
				}
			}
		}
		return null;
	}
}