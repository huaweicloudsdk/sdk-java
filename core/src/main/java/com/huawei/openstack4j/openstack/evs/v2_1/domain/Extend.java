package com.huawei.openstack4j.openstack.evs.v2_1.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

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
public class Extend {
	
	/**
	 * 标记扩容云硬盘操作。
	 */
	@JsonProperty("os-extend")
	private OSExtend osExtend;
	
	/**
	 * 按需和包周期的扩展参数。
	 */
	@JsonProperty("bssParam")
	private BssParamExtend bssParam;
	
}
