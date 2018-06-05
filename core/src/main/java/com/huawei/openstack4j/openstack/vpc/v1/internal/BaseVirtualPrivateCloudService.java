package com.huawei.openstack4j.openstack.vpc.v1.internal;

import com.huawei.openstack4j.api.types.ServiceType;
import com.huawei.openstack4j.openstack.internal.BaseOpenStackService;

public class BaseVirtualPrivateCloudService extends BaseOpenStackService {
	
	protected BaseVirtualPrivateCloudService() {
		super(ServiceType.VPC);
	}
	
}
