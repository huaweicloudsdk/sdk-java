package com.huawei.openstack4j.openstack.vpc.v1.internal;

import com.huawei.openstack4j.api.Apis;
import com.huawei.openstack4j.common.RestService;

public class VirtualPrivateCloudService extends BaseVirtualPrivateCloudService implements RestService{
	
	public PublicIpService publicips() {
		return Apis.get(PublicIpService.class);
	}
	
	public BandWidthService bandwidths() {
		return Apis.get(BandWidthService.class);
	}
}
