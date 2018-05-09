package com.huawei.openstack4j.openstack.scaling.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum ASAutoScalingLifecycleActionResult {
	ABANDON, CONTINUE,EXTEND;

    @JsonValue
    public String value() {
        return name().toUpperCase();
    }

    @JsonCreator
    public static ASAutoScalingLifecycleActionResult value(String v)
    {
        try {
            return valueOf(v.toUpperCase());
        } catch (IllegalArgumentException e) {
            return null;
        }
    }
}
