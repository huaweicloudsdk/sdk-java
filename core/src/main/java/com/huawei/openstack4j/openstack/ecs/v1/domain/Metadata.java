package com.huawei.openstack4j.openstack.ecs.v1.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

@JsonRootName("server")
public class Metadata {

	/**
	 * Windows弹性云服务器Administrator用户的密码。
	 */
	@JsonProperty("admin_pass")
	String adminPass;

	@java.beans.ConstructorProperties({ "adminPass" })
	public Metadata(String adminPass) {
		this.adminPass = adminPass;
	}

	public Metadata() {
	}

	public static MetadataBuilder builder() {
		return new MetadataBuilder();
	}

	public String getAdminPass() {
		return this.adminPass;
	}

	@Override
	public String toString() {
		return "Metadata(adminPass=" + this.getAdminPass() + ")";
	}

	public MetadataBuilder toBuilder() {
		return new MetadataBuilder().adminPass(this.adminPass);
	}

	public static class MetadataBuilder {
		private String adminPass;

		MetadataBuilder() {
		}

		public Metadata.MetadataBuilder adminPass(String adminPass) {
			this.adminPass = adminPass;
			return this;
		}

		public Metadata build() {
			return new Metadata(adminPass);
		}

		@Override
		public String toString() {
			return "Metadata.MetadataBuilder(adminPass=" + this.adminPass + ")";
		}
	}
}
