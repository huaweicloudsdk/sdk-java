package com.huawei.openstack4j.openstack.tms.v1.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PredefineTagRequest {
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
	
	
	@java.beans.ConstructorProperties({ "key", "value" })
	public PredefineTagRequest(String key, String value) {
		this.key = key;
		this.value = value;
	}
	public PredefineTagRequest() {
	}

	public String getKey() {
		return key;
	}

	public String getValue() {
		return value;
	}

	public static  PredefineTagRequestBuilder builder(){
		return new PredefineTagRequestBuilder();
	}
	
	public PredefineTagRequestBuilder toBuilder(){
		return new PredefineTagRequestBuilder().key(this.key).value(this.value);
	}
	
	@Override
	public String toString() {
		return "PredefineTagRequest [key=" + key + ", value=" + value + "]";
	}

	public static class PredefineTagRequestBuilder{
		private String key;
		private String value;
		
		public PredefineTagRequest.PredefineTagRequestBuilder key(String key){
			this.key = key;
			return this;
		}
		
		public PredefineTagRequest.PredefineTagRequestBuilder value(String value){
			this.value = value;
			return this;
		}

		public PredefineTagRequestBuilder() {
		}
		
		public PredefineTagRequest build(){
			return new PredefineTagRequest(key,value);
		}

		@Override
		public String toString() {
			return "PredefineTagRequestBuilder [key=" + key + ", value="
					+ value + "]";
		}
		
	}
	
}
