package com.huawei.openstack4j.openstack.ecs.v1.contants;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum Status {
	ACTIVE,REBOOT,HARD_REBOOT,REBUILD,MIGRATING,BUILD,SHUTOFF,RESIZE,VERIFY_RESIZE,ERROR,DELETED;
		@JsonCreator
		public static Status forValue(String value) {
			if (value != null)
			{
				for (Status s : Status.values()) {
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