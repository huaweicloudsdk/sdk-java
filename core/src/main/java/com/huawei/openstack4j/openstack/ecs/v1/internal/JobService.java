package com.huawei.openstack4j.openstack.ecs.v1.internal;

import com.huawei.openstack4j.openstack.ecs.v1.domain.Job;

public class JobService extends BaseElasticComputeServices{

	/**
	 * Query the execution status of the job.
	 * @param jobId
	 * @return
	 */
	public Job get(String jobId){
		return get(Job.class, uri("/jobs/")+jobId).execute();
	}
}
