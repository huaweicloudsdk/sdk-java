package com.huawei.openstack4j.openstack.vpc.v1.internal;

import static com.google.common.base.Preconditions.checkArgument;

import com.huawei.openstack4j.openstack.vpc.v1.domain.VirtualBandWidthResp;
import com.huawei.openstack4j.openstack.vpc.v1.domain.VirtualBandWidthUpdate;


public class BandWidthService extends BaseVirtualPrivateCloudService {

	/**
	 * Update bandwidth
	 * @param bandWidth
	 * @param bandwidthId
	 * @return
	 */
	public VirtualBandWidthResp update(VirtualBandWidthUpdate bandWidtUpdate,String bandwidthId){
		checkArgument(!(null == bandWidtUpdate), "parameter `bandwidth` should not be empty");
		return put(VirtualBandWidthResp.class, "/bandwidths/"+bandwidthId).entity(bandWidtUpdate).execute();
	}
}
