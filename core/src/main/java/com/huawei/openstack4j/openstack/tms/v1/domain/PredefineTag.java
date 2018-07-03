package com.huawei.openstack4j.openstack.tms.v1.domain;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.huawei.openstack4j.model.ModelEntity;
@Getter
@ToString
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class PredefineTag implements ModelEntity{
	/**
	 *  预定义标签
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 	键。最大长度36个字符。 字符集：A-Z, a-z , 0-9, ‘-‘, ‘_’, UNICODE字符（\u4E00-\u9FFF）。
	 */
	@JsonProperty("key")
	private String key;
	/**
	 *  值。每个值最大长度43个字符，可以为空字符串。 字符集：A-Z，a-z ， 0-9，‘.’，‘-’，‘_’，UNICODE字符（\u4E00-\u9FFF）
	 */
	@JsonProperty("value")
	private String value;
	/**
	 *  更新时间。
	 */
	@JsonProperty("update_time")
	private String updateTime;
	
}
