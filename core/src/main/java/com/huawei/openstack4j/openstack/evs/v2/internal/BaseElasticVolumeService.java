package com.huawei.openstack4j.openstack.evs.v2.internal;

import com.google.common.base.Function;
import com.huawei.openstack4j.api.types.ServiceType;
import com.huawei.openstack4j.openstack.common.functions.ReplaceVersionOfURL;
import com.huawei.openstack4j.openstack.internal.BaseOpenStackService;

public class BaseElasticVolumeService extends BaseOpenStackService{
	
	 protected BaseElasticVolumeService() {
	    	super(ServiceType.EVS);
	    }
	    
		public BaseElasticVolumeService(ServiceType serviceType, Function<String, String> endpointFunc) {
			super(serviceType, endpointFunc);
		}
}
