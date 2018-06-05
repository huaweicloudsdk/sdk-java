package com.huawei.openstack4j.openstack.evs.v2.internal;

import static com.google.common.base.Preconditions.checkArgument;

import com.google.common.base.Strings;
import com.huawei.openstack4j.openstack.common.AsyncJobEntity;
import com.huawei.openstack4j.openstack.evs.v2.domain.CloudVolumes;
import com.huawei.openstack4j.openstack.evs.v2.domain.Extend;

public class VolumeService extends BaseElasticVolumeService{

	/**
	 * Create a Cloud Volume
	 * @param volume
	 * @return
	 */
	public String create(CloudVolumes volume){
		checkArgument(!Strings.isNullOrEmpty(volume.getAvailabilityZone()), "parameter `availabilityZone` should not be empty");
		checkArgument(!((volume.getVolumeType()==null)), "parameter `volumeType` should not be empty");
		return post(AsyncJobEntity.class, "/cloudvolumes").entity(volume).execute().getId();
	}
	
	/**
	 * Extended Cloud Drive
	 * @param extend
	 * @param volumeId
	 * @return
	 */
	public String extend(Extend extend,String volumeId){
		checkArgument(! (null == (extend.getOsExtend().getNewSize())), "parameter `newSize` should not be empty");
		return post(AsyncJobEntity.class, "/cloudvolumes/"+volumeId+"/action").entity(extend).execute().getId();
	}
}
