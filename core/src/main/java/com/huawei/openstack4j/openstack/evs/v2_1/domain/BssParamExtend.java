package com.huawei.openstack4j.openstack.evs.v2_1.domain;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import com.fasterxml.jackson.annotation.JsonRootName;

@Getter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonRootName("bssParam")
public class BssParamExtend {

	
	/**
	 * 功能说明：是否立即支付。chargingMode为PrePaid时该参数会生效。默认值为false。
		取值范围
		false：不立即支付，创建订单暂不支付
		true：立即支付，从帐户余额中自动扣费
	 */
	private Boolean isAutoPay;
	
	
	
}
