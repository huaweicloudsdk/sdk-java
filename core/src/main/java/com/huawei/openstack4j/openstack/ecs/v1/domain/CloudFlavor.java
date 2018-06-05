package com.huawei.openstack4j.openstack.ecs.v1.domain;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.huawei.openstack4j.model.ModelEntity;
import com.huawei.openstack4j.openstack.common.GenericLink;
@Getter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CloudFlavor implements ModelEntity{
	/**
	 * 
	 */
	private static final long serialVersionUID = 7232798451746859453L;
	@JsonProperty("id")
	private String id;
	@JsonProperty("links")
	private List<GenericLink> links;
	
}
