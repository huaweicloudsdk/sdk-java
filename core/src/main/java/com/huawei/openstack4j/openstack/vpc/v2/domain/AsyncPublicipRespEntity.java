package com.huawei.openstack4j.openstack.vpc.v2.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.huawei.openstack4j.model.ModelEntity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 *
 * @author QianBiao.NG
 * @date   2017-07-14 14:16:37
 */
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
@JsonIgnoreProperties(ignoreUnknown = true)
public class AsyncPublicipRespEntity implements ModelEntity  {

	private static final long serialVersionUID = -8479016593614559914L;
	
	@JsonProperty("order_id")
	String orderId;
	@JsonProperty("publicip")
	VirtualPublicIp virtualPublicIp;
	
}
