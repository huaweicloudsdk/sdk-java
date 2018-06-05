package com.huawei.openstack4j.openstack.evs.v2_1.domain;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.huawei.openstack4j.openstack.evs.v2.domain.CloudVolumes;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Getter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Volumes {
	
	/**
	 * 待创建的云硬盘信息。
	 */
	@JsonProperty("volume")
	private CloudVolumes cloudVolumes;
	
	/**
	 * 按需和包周期的扩展参数。
	 */
	@JsonProperty("bssParam")
	private BssParam bssParam;
	
	
}
