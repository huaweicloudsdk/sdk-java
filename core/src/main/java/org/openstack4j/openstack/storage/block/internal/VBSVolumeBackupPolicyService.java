package org.openstack4j.openstack.storage.block.internal;

import static com.google.common.base.Preconditions.*;

import java.util.List;

import org.openstack4j.api.storage.BlockVolumeBackupPolicyService;
import org.openstack4j.core.transport.ClientConstants;
import org.openstack4j.model.common.ActionResponse;
import org.openstack4j.model.storage.block.VolumeBackupPolicy;
import org.openstack4j.model.storage.block.VolumeBackupPolicy.VolumeBackupPolicyStatus;
import org.openstack4j.model.storage.block.VolumeBackupPolicy.VolumeBackupScheduledPolicy;
import org.openstack4j.model.storage.block.VolumeBackupPolicyResource.VolumeBackupPolicyResourceActionResult;
import org.openstack4j.openstack.storage.block.domain.VBSVolumeBackupPolicy;
import org.openstack4j.openstack.storage.block.domain.VBSVolumeBackupPolicy.VolumeBackupPolicies;
import org.openstack4j.openstack.storage.block.domain.VBSVolumeBackupPolicyResource;
import org.openstack4j.openstack.storage.block.domain.VBSVolumeBackupPolicyResourceActionResult;
import org.openstack4j.openstack.storage.block.domain.VBSVolumeBackupScheduledPolicy;
import org.testng.Assert;
import org.testng.collections.Lists;
import org.testng.util.Strings;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

/**
 *
 * @author QianBiao.NG
 * @date   2017-06-29 21:15:20
 */
public class VBSVolumeBackupPolicyService extends BaseVolumeBackupServices implements BlockVolumeBackupPolicyService {

	/*
	 * {@inheritDoc}
	 */
	@Override
	public VolumeBackupPolicy create(VolumeBackupPolicy policy) {
		checkNotNull(policy);
		Assert.assertFalse(Strings.isNullOrEmpty(policy.getName()));
		VolumeBackupScheduledPolicy scheduledPolicy = policy.getScheduledPolicy();
		checkScheduledPolicy(scheduledPolicy);
		return post(VBSVolumeBackupPolicy.class, ClientConstants.PATH_VOLUME_BACKUP_POLICY).entity(policy).execute();
	}

	/**
	 * @param scheduledPolicy
	 */
	public void checkScheduledPolicy(VolumeBackupScheduledPolicy scheduledPolicy) {
		checkNotNull(scheduledPolicy);
		checkNotNull(scheduledPolicy.getFrequency());
		checkNotNull(scheduledPolicy.getMaxBackupAmount());
		checkNotNull(scheduledPolicy.getRetainFirstBackupOfCurrentMonth());
		Assert.assertFalse(Strings.isNullOrEmpty(scheduledPolicy.getStartTime()));
		checkNotNull(scheduledPolicy.getStatus());
	}

	/*
	 * {@inheritDoc}
	 */
	@Override
	public List<? extends VolumeBackupPolicy> list() {
		return get(VolumeBackupPolicies.class, ClientConstants.PATH_VOLUME_BACKUP_POLICY).execute().getList();
	}

	/*
	 * {@inheritDoc}
	 */
	@Override
	public VolumeBackupPolicy update(VolumeBackupPolicy updated) {
		Assert.assertFalse(Strings.isNullOrEmpty(updated.getId()));
		return put(VBSVolumeBackupPolicy.class, ClientConstants.PATH_VOLUME_BACKUP_POLICY, "/", updated.getId())
				.execute();
	}

	/*
	 * {@inheritDoc}
	 */
	@Override
	public ActionResponse delete(String backupPolicyId) {
		Assert.assertFalse(Strings.isNullOrEmpty(backupPolicyId));
		return deleteWithResponse(ClientConstants.PATH_VOLUME_BACKUP_POLICY, "/", backupPolicyId).execute();
	}

	/*
	 * {@inheritDoc}
	 */
	@Override
	public ActionResponse execute(String backupPolicyId) {
		Assert.assertFalse(Strings.isNullOrEmpty(backupPolicyId));
		return postWithResponse(ClientConstants.PATH_VOLUME_BACKUP_POLICY, "/", backupPolicyId, "/action").execute();
	}

	/*
	 * {@inheritDoc}
	 */
	@Override
	public VolumeBackupPolicy enable(String backupPolicyId) {
		Assert.assertFalse(Strings.isNullOrEmpty(backupPolicyId));
		VBSVolumeBackupScheduledPolicy scheduledPolicy = VBSVolumeBackupScheduledPolicy.builder()
				.status(VolumeBackupPolicyStatus.ON).build();
		VBSVolumeBackupPolicy policy = VBSVolumeBackupPolicy.builder().id(backupPolicyId)
				.scheduledPolicy(scheduledPolicy).build();
		return update(policy);
	}

	/*
	 * {@inheritDoc}
	 */
	@Override
	public VolumeBackupPolicy disable(String backupPolicyId) {
		Assert.assertFalse(Strings.isNullOrEmpty(backupPolicyId));
		VBSVolumeBackupScheduledPolicy scheduledPolicy = VBSVolumeBackupScheduledPolicy.builder()
				.status(VolumeBackupPolicyStatus.OFF).build();
		VBSVolumeBackupPolicy policy = VBSVolumeBackupPolicy.builder().id(backupPolicyId)
				.scheduledPolicy(scheduledPolicy).build();
		return update(policy);
	}

	/*
	 * {@inheritDoc}
	 */
	@Override
	public VolumeBackupPolicyResourceActionResult linkResources(String backupPolicyId, List<String> resourceIds) {
		Assert.assertFalse(Strings.isNullOrEmpty(backupPolicyId), "Parameter `backupPolicyId` should not be empty");
		Assert.assertNotNull(resourceIds, "Parameter `resourceIds` should not be null");
		Assert.assertTrue(resourceIds.size() > 0, "Parameter `resourceIds` should not be empty");

		_VBSVolumeBackupPolicyResources resources = new _VBSVolumeBackupPolicyResources();
		resources.setBackupPolicyId(backupPolicyId);
		for (String resourceId : resourceIds) {
			VBSVolumeBackupPolicyResource resource = VBSVolumeBackupPolicyResource.builder().id(resourceId)
					.type("volume").build();
			resources.addResource(resource);
		}

		return post(VBSVolumeBackupPolicyResourceActionResult.class, "/backuppolicyresources").entity(resources)
				.execute();
	}

	/*
	 * {@inheritDoc}
	 */
	@Override
	public VolumeBackupPolicyResourceActionResult unlinkResources(String backupPolicyId, List<String> resourceIds) {
		Assert.assertFalse(Strings.isNullOrEmpty(backupPolicyId), "Parameter `backupPolicyId` should not be empty");
		Assert.assertNotNull(resourceIds, "Parameter `resourceIds` should not be null");
		Assert.assertTrue(resourceIds.size() > 0, "Parameter `resourceIds` should not be empty");

		_VBSVolumeBackupPolicyResources resources = new _VBSVolumeBackupPolicyResources();
		for (String resourceId : resourceIds) {
			VBSVolumeBackupPolicyResource resource = VBSVolumeBackupPolicyResource.builder().id(resourceId).build();
			resources.addResource(resource);
		}
		return post(VBSVolumeBackupPolicyResourceActionResult.class, "/backuppolicyresources/", backupPolicyId,
				"/deleted_resources").entity(resources).execute();
	}

	@JsonRootName("resources")
	@SuppressWarnings("unused")
	private static class _VBSVolumeBackupPolicyResources {

		@JsonProperty("backup_policy_id")
		String backupPolicyId;

		@JsonProperty("resources")
		private List<VBSVolumeBackupPolicyResource> resources = Lists.newArrayList();

		public String getBackupPolicyId() {
			return backupPolicyId;
		}

		/**
		 * @param resource
		 */
		public void addResource(VBSVolumeBackupPolicyResource resource) {
			resources.add(resource);
		}

		public void setBackupPolicyId(String backupPolicyId) {
			this.backupPolicyId = backupPolicyId;
		}

		public List<VBSVolumeBackupPolicyResource> getResources() {
			return resources;
		}

		public void setResources(List<VBSVolumeBackupPolicyResource> resources) {
			this.resources = resources;
		}

	}
}
