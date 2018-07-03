package com.huawei.openstack4j.openstack.vpc.v1.domain;

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
public class VirtualProfile {
	
	/**
	 * 1、功能说明：额外参数，包括订单id、产品id等信息
		如果profile不为空，说明是包周期的弹性公网IP
	 */
	@JsonProperty("order_id")
	private String orderId;
	@JsonProperty("product_id")
	private String productId;
	@JsonProperty("region_id")
	private String regionId;
	@JsonProperty("user_id")
	private String userId;
	
}
