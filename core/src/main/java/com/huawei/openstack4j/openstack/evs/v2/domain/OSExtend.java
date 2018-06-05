package com.huawei.openstack4j.openstack.evs.v2.domain;

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
public class OSExtend {
	
	/**
	 * 	
		扩容后的云硬盘大小，单位为GB。
		扩容后的云硬盘容量范围：大于原有云硬盘容量~云硬盘最大容量（32768GB）
		说明：
		如果发送请求时，将参数值设置为小数，则默认取小数点前的整数
	 */
	@JsonProperty("new_size")
	private Integer newSize;
	
}
