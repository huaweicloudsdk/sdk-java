package com.huawei.openstack4j.openstack.vpc.v1.internal;

import static com.google.common.base.Preconditions.checkArgument;

import com.huawei.openstack4j.openstack.vpc.v1.domain.VirtualPublicIp;
import com.huawei.openstack4j.openstack.vpc.v1.domain.VirtualPublicIps;

public class PublicIpService extends BaseVirtualPrivateCloudService{

	/**
	 * Apply for flexible public network IP
	 * @param virtualPublicIps
	 * @return
	 */
	public VirtualPublicIp apply(VirtualPublicIps virtualPublicIps){
		checkArgument(!(null == (virtualPublicIps.getVirtualPublicIp().getType())), "parameter `type` should not be empty");
		checkArgument(!(null == (virtualPublicIps.getVirtualBandwidth().getShareType())), "parameter `share_type` should not be empty");
		return post(VirtualPublicIp.class, "/publicips").entity(virtualPublicIps).execute();
	}
}
