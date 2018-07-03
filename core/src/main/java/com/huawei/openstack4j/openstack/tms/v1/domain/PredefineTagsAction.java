package com.huawei.openstack4j.openstack.tms.v1.domain;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.huawei.openstack4j.model.ModelEntity;
import com.huawei.openstack4j.openstack.tms.v1.contants.Action;

@Getter
@ToString
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class PredefineTagsAction implements ModelEntity{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 操作标识（区分大小写）：create（创建）、delete（删除）。
	 */
	private Action action;
	/**
	 * 标签列表。
	 */
	@JsonProperty("tags")
	private List<PredefineTagRequest> tagList;
}

