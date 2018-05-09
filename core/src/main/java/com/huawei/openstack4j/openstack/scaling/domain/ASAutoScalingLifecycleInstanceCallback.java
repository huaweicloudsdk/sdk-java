package com.huawei.openstack4j.openstack.scaling.domain;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.huawei.openstack4j.model.ModelEntity;

@Getter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ASAutoScalingLifecycleInstanceCallback implements ModelEntity{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7635315613194755810L;
/**
 * { 
    "lifecycle_action_result": "ABANDON", 
    "lifecycle_action_key":"23880867-6288-4470-98a8-f8bda096b6c4" 
}

 */
	@JsonProperty("lifecycle_action_key")
	private String lifecycleActionKey;
	
	@JsonProperty("instance_id")
	private String instanceId;
	
	@JsonProperty("lifecycle_hook_name")
	private String lifecycleHookName;
	
	@JsonProperty("lifecycle_action_result")
	private ASAutoScalingLifecycleActionResult lifecycleActionResult;
	
}
