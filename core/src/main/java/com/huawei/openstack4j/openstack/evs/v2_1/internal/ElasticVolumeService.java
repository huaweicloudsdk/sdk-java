package com.huawei.openstack4j.openstack.evs.v2_1.internal;

import com.huawei.openstack4j.api.Apis;
import com.huawei.openstack4j.common.RestService;
import com.huawei.openstack4j.openstack.ecs.v1.internal.BaseElasticComputeServices;

public class ElasticVolumeService extends BaseElasticVolumeService implements RestService{
	
	public VolumeService volumes() {
		return Apis.get(VolumeService.class);
	}
}
