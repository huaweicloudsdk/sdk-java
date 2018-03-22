package com.huawei.openstack4j.openstack.compute.v1.internal;

import static com.google.common.base.Preconditions.*;

import java.util.List;

import com.google.common.base.Strings;
import com.google.common.collect.Lists;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.huawei.openstack4j.api.compute.ServerV1Service;
import com.huawei.openstack4j.model.ModelEntity;
import com.huawei.openstack4j.model.compute.RebootType;
import com.huawei.openstack4j.model.compute.StopType;
import com.huawei.openstack4j.openstack.common.AsyncJobEntity;
import com.huawei.openstack4j.openstack.common.IdResourceEntity;
import com.huawei.openstack4j.openstack.compute.v1.domain.ServerCreate;

public class ServerV1ServiceImpl extends BaseComputeServices implements ServerV1Service {

	/*
	 * {@inheritDoc}
	 */
	@Override
	public String create(ServerCreate creation) {
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
		return post(AsyncJobEntity.class, "/cloudservers").entity(creation).execute().getId();
	}

	/*
	 * {@inheritDoc}
	 */
	@Override
	public String delete(List<String> serverIds, boolean deletePublicIp, boolean deleteVolume) {
		checkArgument(serverIds != null && serverIds.size() > 0, "parameter `serverIds` should not be empty");
		DeleteServerRequest request = new DeleteServerRequest(serverIds, deletePublicIp, deleteVolume);
		return post(AsyncJobEntity.class, uri("/cloudservers/delete")).entity(request).execute().getId();
	}

	/*
	 * {@inheritDoc}
	 */
	@Override
	public String stop(List<String> serverIds, StopType type) {
		checkArgument(serverIds != null && serverIds.size() > 0, "parameter `serverIds` should not be empty");
		checkArgument(type != null, "parameter `type` should not be null");

		BatchStopAction action = new BatchStopAction(serverIds, type);
		return post(AsyncJobEntity.class, uri("/cloudservers/action")).entity(action).execute().getId();
	}

	/*
	 * {@inheritDoc}
	 */
	@Override
	public String reboot(List<String> serverIds, RebootType type) {
		checkArgument(serverIds != null && serverIds.size() > 0, "parameter `serverIds` should not be empty");
		checkArgument(type != null, "parameter `type` should not be null");

		BatchRebootAction action = new BatchRebootAction(serverIds, type);
		return post(AsyncJobEntity.class, uri("/cloudservers/action")).entity(action).execute().getId();
	}

	/*
	 * {@inheritDoc}
	 */
	@Override
	public String start(List<String> serverIds) {
		checkArgument(serverIds != null && serverIds.size() > 0, "parameter `serverIds` should not be empty");

		BatchStartAction action = new BatchStartAction(serverIds);
		return post(AsyncJobEntity.class, uri("/cloudservers/action")).entity(action).execute().getId();
	}

	public static class BatchAction implements ModelEntity {

		private static final long serialVersionUID = -3993352728410832732L;

		@JsonProperty("type")
		public String type;

		@JsonProperty("servers")
		List<IdResourceEntity> servers = Lists.newArrayList();

		public BatchAction(List<String> serverIds, String type) {
			for (String serverId : serverIds) {
				servers.add(new IdResourceEntity(serverId));
			}
			this.type = type;
		}
	}

	@JsonRootName("os-start")
	public static class BatchStartAction extends BatchAction {
		private static final long serialVersionUID = -8311243025930452903L;

		public BatchStartAction(List<String> serverIds) {
			super(serverIds, null);
		}
	}

	@JsonRootName("reboot")
	public static class BatchRebootAction extends BatchAction {
		private static final long serialVersionUID = 3151059333050510631L;

		public BatchRebootAction(List<String> serverIds, RebootType type) {
			super(serverIds, type.name().toLowerCase());
		}
	}

	@JsonRootName("os-stop")
	public static class BatchStopAction extends BatchAction {
		private static final long serialVersionUID = 9217647120271727241L;

		public BatchStopAction(List<String> serverIds, StopType type) {
			super(serverIds, type.name().toLowerCase());
		}
	}

	public static class DeleteServerRequest implements ModelEntity {

		private static final long serialVersionUID = -3993352728410832732L;

		@JsonProperty("delete_publicip")
		public boolean deletePublicIp;
		@JsonProperty("delete_volume")
		public boolean deleteVolume;

		@JsonProperty("servers")
		List<IdResourceEntity> servers = Lists.newArrayList();

		public DeleteServerRequest(List<String> serverIds, boolean deletePublicIp, boolean deleteVolume) {
			for (String serverId : serverIds) {
				servers.add(new IdResourceEntity(serverId));
			}

			this.deletePublicIp = deletePublicIp;
			this.deleteVolume = deleteVolume;
		}
	}

}
