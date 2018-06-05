package com.huawei.openstack4j.openstack.ecs.v1_1.domain;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import com.fasterxml.jackson.annotation.JsonProperty;
@Getter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SchedulerHints {
	
	/**
	 * 云服务器组ID，UUID格式。
	 */
	@JsonProperty("group")
	private String group;
	
	/**
	 * 专属主机的ID。
	 */
	@JsonProperty("dedicated_host_id")
	private String dedicatedHostId;
	
	/**
	 * 在指定的专属主机或者共享主机上创建弹性云服务器。
	 */
	@JsonProperty("tenancy")
	private List<String> tenancy;
	
}
