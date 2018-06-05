package com.huawei.openstack4j.openstack.evs.v2_1.internal;

import static com.google.common.base.Preconditions.checkArgument;

import com.google.common.base.Strings;
import com.huawei.openstack4j.openstack.common.AsyncRespEntity;
import com.huawei.openstack4j.openstack.evs.v2_1.domain.Extend;
import com.huawei.openstack4j.openstack.evs.v2_1.domain.Volumes;

public class VolumeService extends BaseElasticVolumeService{

	/**
	 * Create a Cloud Volume
	 * @param volume
	 * @return
	 */
	public AsyncRespEntity create(Volumes volume){
		checkArgument(!Strings.isNullOrEmpty(volume.getCloudVolumes().getAvailabilityZone()), "parameter `availabilityZone` should not be empty");
		checkArgument(!((volume.getCloudVolumes().getVolumeType()==null)), "parameter `volumeType` should not be empty");
		return post(AsyncRespEntity.class, "/cloudvolumes").entity(volume).execute();
	}
	
	/**
	 * Extended Cloud Drive
	 * @param extend
	 * @param volumeId
	 * @return
	 */
	public AsyncRespEntity extend(Extend extend,String volumeId){
		checkArgument(! (null == (extend.getOsExtend().getNewSize())), "parameter `newSize` should not be empty");
		return post(AsyncRespEntity.class, "/cloudvolumes/"+volumeId+"/action").entity(extend).execute();
	}
}
