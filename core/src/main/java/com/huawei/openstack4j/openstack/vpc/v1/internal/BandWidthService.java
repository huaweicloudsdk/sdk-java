package com.huawei.openstack4j.openstack.vpc.v1.internal;

import static com.google.common.base.Preconditions.checkArgument;

import java.util.List;
import java.util.Map;

import com.huawei.openstack4j.openstack.vpc.v1.domain.VirtualBandWidthUpdate;
import com.huawei.openstack4j.openstack.vpc.v1.domain.VirtualBandWidths;
import com.huawei.openstack4j.openstack.vpc.v1.domain.VirtualBandWidths.VirtualBandWidthResps;


public class BandWidthService extends BaseVirtualPrivateCloudService {

	/**
	 * Update bandwidth
	 * @param bandWidth
	 * @param bandwidthId
	 * @return
	 */
	public VirtualBandWidths update(VirtualBandWidthUpdate bandWidtUpdate,String bandwidthId){
		checkArgument(!(null == bandWidtUpdate), "parameter `bandwidth` should not be empty");
		return put(VirtualBandWidths.class, "/bandwidths/"+bandwidthId).entity(bandWidtUpdate).execute();
	}
	/**
	 * 查询带宽列表
	 * @param limit
	 * @param marker
	 * @return
	 */
	public List<VirtualBandWidths> list(Map<String, String> filteringParams){
		Invocation<VirtualBandWidthResps> serverInvocation = get(VirtualBandWidthResps.class,"/bandwidths");
		if (filteringParams != null) {
			for (Map.Entry<String, String> entry : filteringParams.entrySet()) {
				serverInvocation = serverInvocation.param(entry.getKey(), entry.getValue());
			}
		}
		return serverInvocation.execute().getList();
	}
	
	/**
	 * 查询带宽列表
	 * @param limit
	 * @param marker
	 * @return
	 */
	public List<VirtualBandWidths> list(){
		return get(VirtualBandWidthResps.class,"/bandwidths").execute().getList();
	}
	
	/**
	 * 查询带宽
	 * @param bandwidthId
	 * @return
	 */
	public VirtualBandWidths get(String bandwidthId){
		return get(VirtualBandWidths.class,"/bandwidths/"+bandwidthId).execute();
	}
	
}
