package com.huawei.openstack4j.openstack.scaling.options;

import java.util.Map;

import com.google.common.collect.Maps;

public class ScalingInstanceOptions {
	
	private Map<String, Object> queryParams = Maps.newHashMap();

	private ScalingInstanceOptions() {
	}

	public static ScalingInstanceOptions create() {
		return new ScalingInstanceOptions();
	}

	public ScalingInstanceOptions instanceId(String instanceId) {
		return add("instance_id", instanceId);
	}
	
	private ScalingInstanceOptions add(String param, Object value) {
		if (value != null)
			this.queryParams.put(param, value);
		return this;
	}

	public Map<String, Object> getOptions() {
		return queryParams;
	}
}
