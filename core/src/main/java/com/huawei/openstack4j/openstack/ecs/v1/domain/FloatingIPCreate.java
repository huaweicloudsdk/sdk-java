package com.huawei.openstack4j.openstack.ecs.v1.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.huawei.openstack4j.model.ModelEntity;

/**
 * A model represent Network properties for Server creation
 */
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
	String ipType;

	/**
	 * 弹性IP地址带宽参数
	 */
	@JsonProperty("bandwidth")
	Bandwidth bandwidth;

	@java.beans.ConstructorProperties({ "ipType", "bandwidth" })
	public FloatingIPCreate(String ipType, Bandwidth bandwidth) {
		this.ipType = ipType;
		this.bandwidth = bandwidth;
	}

	public FloatingIPCreate() {
	}

	public static FloatingIPCreateBuilder builder() {
		return new FloatingIPCreateBuilder();
	}

	public String getIpType() {
		return this.ipType;
	}

	public Bandwidth getBandwidth() {
		return this.bandwidth;
	}

	@Override
	public String toString() {
		return "FloatingIPCreate(ipType=" + this.getIpType() + ", bandwidth=" + this.getBandwidth() + ")";
	}

	public FloatingIPCreateBuilder toBuilder() {
		return new FloatingIPCreateBuilder().ipType(this.ipType).bandwidth(this.bandwidth);
	}

	public static class FloatingIPCreateBuilder {
		private String ipType;
		private Bandwidth bandwidth;

		FloatingIPCreateBuilder() {
		}

		public FloatingIPCreate.FloatingIPCreateBuilder ipType(String ipType) {
			this.ipType = ipType;
			return this;
		}

		public FloatingIPCreate.FloatingIPCreateBuilder bandwidth(Bandwidth bandwidth) {
			this.bandwidth = bandwidth;
			return this;
		}

		public FloatingIPCreate build() {
			return new FloatingIPCreate(ipType, bandwidth);
		}

		@Override
		public String toString() {
			return "FloatingIPCreate.FloatingIPCreateBuilder(ipType=" + this.ipType + ", bandwidth=" + this.bandwidth
					+ ")";
		}
	}
}
