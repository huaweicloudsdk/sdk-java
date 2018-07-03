package com.huawei.openstack4j.openstack.tms.v1.contants;

import com.fasterxml.jackson.annotation.JsonValue;

public enum OrderMethod {
	
	ASC("asc"),
	DESC("desc");
	
	String value;
	private OrderMethod(String value){
		this.value = value;
	}
	
	@JsonValue
	public String value() {
		return value;
	}
}
