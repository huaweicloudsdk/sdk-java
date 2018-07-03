package com.huawei.openstack4j.openstack.tms.v1.contants;

import com.fasterxml.jackson.annotation.JsonValue;

public enum Action {
	
	Create("create"),
	Delete("delete");
	
	String action;
	private Action(String action){
		this.action = action;
	}
	
	@JsonValue
	public String action() {
		return action;
	}
	
}
