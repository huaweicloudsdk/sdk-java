package com.huawei.openstack4j.openstack.tms.v1.contants;

import com.fasterxml.jackson.annotation.JsonValue;

public enum OrderField {
	
	UpdateTime("update_time"),
	Key("key"),
	Value("value");
	
	String field;
	private OrderField(String field){
		this.field = field;
	}
	
	@JsonValue
	public String field() {
		return field;
	}
	
}
