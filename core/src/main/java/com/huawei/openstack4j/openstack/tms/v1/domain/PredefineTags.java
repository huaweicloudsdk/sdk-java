package com.huawei.openstack4j.openstack.tms.v1.domain;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.huawei.openstack4j.model.ModelEntity;

public class PredefineTags implements ModelEntity{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 	标签列表。
	 */
	@JsonProperty("tags")
	private List<PredefineTag> tags;
	/**
	 * 总记录数。
	 */
	@JsonProperty("total_count")
	private String totalCount;
	/**
	 * 分页位置标识。当前查询最后一条数据的索引位置。
	 */
	private String marker;
	
	@java.beans.ConstructorProperties({ "tags", "totalCount", "marker" })
	public PredefineTags(List<PredefineTag> tags, String totalCount,
			String marker) {
		this.tags = tags;
		this.totalCount = totalCount;
		this.marker = marker;
	}

	public PredefineTags() {
	}

	public List<PredefineTag> getTags() {
		return tags;
	}

	public String getTotalCount() {
		return totalCount;
	}

	public String getMarker() {
		return marker;
	}

	@Override
	public String toString() {
		return "PredefineTags [tags=" + tags + ", totalCount=" + totalCount
				+ ", marker=" + marker + "]";
	}

	public static PredefineTagsBuilder builder(){
		return new PredefineTagsBuilder();
	}

	public PredefineTagsBuilder toBuilder(){
		return new PredefineTagsBuilder().tags(this.tags).totalCount(this.totalCount).marker(this.marker);
	}
	
	public static class PredefineTagsBuilder{
		
		private List<PredefineTag> tags;
		private String totalCount;
		private String marker;
		
		public PredefineTagsBuilder() {
		}
		
		public PredefineTags.PredefineTagsBuilder tags(List<PredefineTag> tags){
			this.tags = tags;
			return this;
		}
		
		public PredefineTags.PredefineTagsBuilder totalCount(String totalCount){
			this.totalCount = totalCount;
			return this;
		}
		
		public PredefineTags.PredefineTagsBuilder marker(String marker){
			this.marker = marker;
			return this;
		}
		
		public PredefineTags build(){
			return new PredefineTags(tags, totalCount,marker);
		}

		@Override
		public String toString() {
			return "PredefineTagsBuilder [tags=" + tags + ", totalCount="
					+ totalCount + ", marker=" + marker + "]";
		}
		
		
	}
	
	
	

} 
