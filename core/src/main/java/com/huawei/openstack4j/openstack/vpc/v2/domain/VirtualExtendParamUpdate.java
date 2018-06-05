package com.huawei.openstack4j.openstack.vpc.v2.domain;

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
public class VirtualExtendParamUpdate implements ModelEntity{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7084270775989831470L;
	
	/**
	 * 下单订购后，是否自动从客户的账户中支付；默认是“不自动支付”
	 */
	@JsonProperty("is_auto_pay")
	private Boolean isAutoPay;

	
}
