package com.huawei.openstack4j.openstack.scaling.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum ASAutoScalingLifecycleHookType {
	INSTANCE_TERMINATING, INSTANCE_LAUNCHING;

    @JsonValue
    public String value() {
        return name().toUpperCase();
    }

    @JsonCreator
    public static ASAutoScalingLifecycleHookType value(String v)
    {
        try {
            return valueOf(v.toUpperCase());
        } catch (IllegalArgumentException e) {
            return null;
        }
    }
}
