package com.huawei.openstack4j.openstack.ecs.v1.domain;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import com.fasterxml.jackson.annotation.JsonProperty;
@Getter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class JobEntities {
	
	@JsonProperty("sub_jobs_total")
	private Integer subJobsTotal;
	
	@JsonProperty("sub_jobs")
	private List<SubJob> subJobs;
}
