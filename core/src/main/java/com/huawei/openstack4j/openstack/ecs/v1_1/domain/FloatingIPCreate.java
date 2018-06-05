package com.huawei.openstack4j.openstack.ecs.v1_1.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.huawei.openstack4j.model.ModelEntity;
import com.huawei.openstack4j.openstack.ecs.v1.contants.IpType;

/**
 * A model represent Network properties for Server creation
 */
@Getter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FloatingIPCreate implements ModelEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5207360450262608294L;

	/**
	 * 弹性IP地址类型。
		类型枚举值：
		5_bgp：全动态BGP
		5_sbgp：静态BGP
		5_telcom：中国电信
		5_union：中国联通
	 */
	@JsonProperty("iptype")
	IpType ipType;

	/**
	 * 弹性IP地址带宽参数
	 */
	@JsonProperty("bandwidth")
	Bandwidth bandwidth;
	
	/**
	 * 创建弹性IP的附加信息。
	 */
	@JsonProperty("extendparam")
	FloatingIPExtendParam extendparam;
	
}
