package com.huawei.openstack4j.openstack.vpc.v1.internal;

import static com.google.common.base.Preconditions.checkArgument;

import com.google.common.base.Strings;
import com.huawei.openstack4j.openstack.vpc.v1.domain.VirtualPublicIpsResp;
import com.huawei.openstack4j.openstack.vpc.v1.domain.VirtualPublicIps;
import com.huawei.openstack4j.openstack.vpc.v1.domain.VirtualPublicIp;

public class PublicIpService extends BaseVirtualPrivateCloudService{

	/**
	 * Apply for flexible public network IP
	 * @param virtualPublicIps
	 * @return
	 */
	public VirtualPublicIpsResp apply(VirtualPublicIps virtualPublicIps){
		checkArgument(!(null == (virtualPublicIps.getVirtualPublicIp().getType())), "parameter `type` should not be empty");
		checkArgument(!(null == (virtualPublicIps.getVirtualBandwidth().getShareType())), "parameter `share_type` should not be empty");
		return post(VirtualPublicIpsResp.class, "/publicips").entity(virtualPublicIps).execute();
	}
	
	/**
	 * list publicip
	 * @param publicipId
	 * @return
	 */
	public VirtualPublicIp get(String publicipId){
		checkArgument(!Strings.isNullOrEmpty(publicipId), "parameter `publicipId` should not be empty");
		return get(VirtualPublicIp.class,"/publicips/"+publicipId).execute();
	}
	
	
}
