package com.huawei.openstack4j.openstack.vpc.v2.internal;

import static com.google.common.base.Preconditions.checkArgument;

import com.huawei.openstack4j.openstack.vpc.v2.domain.AsyncBandWidthRespEntity;
import com.huawei.openstack4j.openstack.vpc.v2.domain.VirtualBandWidths;

public class BandWidthService extends BaseVirtualPrivateCloudService {

	/**
	 * Update bandwidth
	 * @param bandWidth
	 * @param bandwidthId
	 * @return
	 */
	public AsyncBandWidthRespEntity update(VirtualBandWidths bandWidth,String bandwidthId){
		checkArgument(!(null == (bandWidth.getBandwidth())), "parameter `bandwidth` should not be empty");
		return put(AsyncBandWidthRespEntity.class, "/bandwidths/"+bandwidthId).entity(bandWidth).execute();
	}
}
