package com.huawei.openstack4j.openstack.tms.v1.internal;

import com.huawei.openstack4j.api.Apis;
import com.huawei.openstack4j.common.RestService;
import com.huawei.openstack4j.openstack.ecs.v1_1.internal.CloudServerService;

public class TagManagementService extends BaseTagManagementService implements RestService{

	
	/**
	 * ECS compute Service 
	 * 
	 * @return SMN Topic Service instance
	 */
	public TagService tags() {
		return Apis.get(TagService.class);
	}
	
}
