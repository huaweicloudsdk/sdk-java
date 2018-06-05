package com.huawei.openstack4j.openstack.evs.v2_1.internal;

import com.google.common.base.Function;
import com.huawei.openstack4j.api.types.ServiceType;
import com.huawei.openstack4j.openstack.internal.BaseOpenStackService;

public class BaseElasticVolumeService extends BaseOpenStackService{
	
	 protected BaseElasticVolumeService() {
	    	super(ServiceType.EVS2_1);
	    }
	    
		public BaseElasticVolumeService(ServiceType serviceType, Function<String, String> endpointFunc) {
			super(serviceType, endpointFunc);
		}
}
