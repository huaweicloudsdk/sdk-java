package com.huawei.openstack4j.openstack.ecs.v1_1.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.huawei.openstack4j.openstack.ecs.v1.contants.PeriodType;
import com.huawei.openstack4j.openstack.ecs.v1_1.contants.ServerChargingMode;
@Getter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
//@JsonRootName("server")
public class ServerExtendParam {

	/**
	 * 计费模式：0：按需计费。
	 */
	@JsonProperty("chargingMode")
	ServerChargingMode chargingMode;

	/**
	 * 云服务器所在区域ID。
	 */
	@JsonProperty("regionID")
	String regionId;

	/**
	 * 是否配置虚拟机自动恢复的功能。
		“true”：配置该功能
		“false”：不配置该功能
	 */
	@JsonProperty("support_auto_recovery")
	Boolean autoRecovery;
	
	/**
	 * 订购周期类型。
		取值范围：
		month-月
		year-年
		说明：
		chargingMode为prePaid时生效且为必选值。
	 */
	PeriodType periodType;
	
	/**
	 * 订购周期数。
		取值范围：
		periodType=month（周期类型为月）时，取值为[1，9]。
		periodType=year（周期类型为年）时，取值为1。
		说明：
		chargingMode为prePaid时生效且为必选值。
	 */
	Integer periodNum;
	
	/**
	 * 是否自动续订。
		“true”：自动续订
		“false”：不自动续订
		说明：
		chargingMode为prePaid时生效，该值为空时默认为不自动续订。
	 */
	Boolean isAutoRenew;
	
	/**
	 * 下单订购后，是否自动从客户的账户中支付，而不需要客户手动去进行支付。
		“true”：是（自动支付）
		“false”：否（需要客户手动支付）
	 */
	Boolean isAutoPay;

}
