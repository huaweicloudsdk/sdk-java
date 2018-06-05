package com.huawei.openstack4j.openstack.ecs.v1.contants;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum DiskConfig {
	MANUAL,AUTO;
	@JsonCreator
	public static DiskConfig forValue(String value) {
		if (value != null)
		{
			for (DiskConfig s : DiskConfig.values()) {
				if (s.name().equalsIgnoreCase(value))
					return s;
			}
		}
		return null;
	}
	
	@JsonValue
    public String value() {
        return name().toLowerCase();
    }
}
