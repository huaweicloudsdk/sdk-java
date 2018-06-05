package com.huawei.openstack4j.openstack.ecs.v1_1.internal;

import static com.google.common.base.Preconditions.*;

import com.google.common.base.Strings;
import com.huawei.openstack4j.openstack.common.AsyncRespEntity;
import com.huawei.openstack4j.openstack.ecs.v1_1.domain.ResizeServer;
import com.huawei.openstack4j.openstack.ecs.v1_1.domain.ServerCreate;

public class CloudServerService extends BaseElasticComputeServices {

	/**
	 * create one or multiple server
	 * 
	 * @param creation
	 * @return			job-id of the asynchronous create server task
	 */
	public AsyncRespEntity create(ServerCreate creation) {
		checkArgument(!Strings.isNullOrEmpty(creation.getImageRef()), "parameter `imageRef` should not be empty");
		checkArgument(!Strings.isNullOrEmpty(creation.getFlavorRef()), "parameter `flavorRef` should not be empty");
		checkArgument(!Strings.isNullOrEmpty(creation.getName()), "parameter `name` should not be empty");
		checkArgument(!Strings.isNullOrEmpty(creation.getVpcId()), "parameter `vpcid` should not be empty");
		checkArgument(!Strings.isNullOrEmpty(creation.getAvailabilityZone()), "parameter `availability_zone` should not be empty");
		checkArgument(!(creation.getPersonality() != null && creation.getPersonality().size() > 5),
				"size of parameter `personality` should not greate than 5");
		checkArgument(creation.getNetworks() != null && creation.getNetworks().size() > 0,
				"parameter `networks` should not be empty");
		checkArgument(creation.getRootVolume() != null, "parameter `root_volume` should not be empty");
		return post(AsyncRespEntity.class, "/cloudservers").entity(creation).execute();
	}

	/**
	 * Change cloud server specifications
	 * @param resize
	 * @param serverId
	 * @return
	 */
	public AsyncRespEntity resize(ResizeServer resize,String serverId){
		checkArgument(!Strings.isNullOrEmpty(resize.getFlavorRef()), "parameter `flavorRef` should not be empty");
		return post(AsyncRespEntity.class, "/cloudservers/"+serverId+"/resize").entity(resize).execute();
	}
}
