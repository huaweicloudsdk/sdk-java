/*******************************************************************************
 *  Copyright 2017 Huawei TLD
 * 	Copyright 2016 ContainX and OpenStack4j                                          
 * 	                                                                                 
 * 	Licensed under the Apache License, Version 2.0 (the "License"); you may not      
 * 	use this file except in compliance with the License. You may obtain a copy of    
 * 	the License at                                                                   
 * 	                                                                                 
 * 	    http://www.apache.org/licenses/LICENSE-2.0                                   
 * 	                                                                                 
 * 	Unless required by applicable law or agreed to in writing, software              
 * 	distributed under the License is distributed on an "AS IS" BASIS, WITHOUT        
 * 	WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the         
 * 	License for the specific language governing permissions and limitations under    
 * 	the License.                                                                     
 *******************************************************************************/
package org.openstack4j.openstack.provider;

import java.util.Map;

import org.openstack4j.api.APIProvider;
import org.openstack4j.api.artifact.ArtifactService;
import org.openstack4j.api.artifact.ToscaTemplatesArtifactService;
import org.openstack4j.api.barbican.BarbicanService;
import org.openstack4j.api.barbican.ContainerService;
import org.openstack4j.api.cloudeye.CloudEyeService;
import org.openstack4j.api.cloudeye.MetricDataService;
import org.openstack4j.api.cloudeye.MetricService;
import org.openstack4j.api.cloudeye.QuotaService;
import org.openstack4j.api.compute.ComputeFloatingIPService;
import org.openstack4j.api.compute.ComputeImageService;
import org.openstack4j.api.compute.ComputeSecurityGroupService;
import org.openstack4j.api.compute.ComputeService;
import org.openstack4j.api.compute.FlavorService;
import org.openstack4j.api.compute.HostAggregateService;
import org.openstack4j.api.compute.HostService;
import org.openstack4j.api.compute.KeypairService;
import org.openstack4j.api.compute.QuotaSetService;
import org.openstack4j.api.compute.ServerGroupService;
import org.openstack4j.api.compute.ServerService;
import org.openstack4j.api.compute.ServerTagService;
import org.openstack4j.api.compute.ext.FloatingIPDNSDomainService;
import org.openstack4j.api.compute.ext.FloatingIPDNSEntryService;
import org.openstack4j.api.compute.ext.FloatingIPDNSService;
import org.openstack4j.api.compute.ext.HypervisorService;
import org.openstack4j.api.compute.ext.InstanceActionsService;
import org.openstack4j.api.compute.ext.InterfaceService;
import org.openstack4j.api.compute.ext.MigrationService;
import org.openstack4j.api.compute.ext.ServicesService;
import org.openstack4j.api.compute.ext.ZoneService;
import org.openstack4j.api.dns.v2.DNSService;
import org.openstack4j.api.dns.v2.PTRService;
import org.openstack4j.api.dns.v2.RecordsetService;
import org.openstack4j.api.exceptions.ApiNotFoundException;
import org.openstack4j.api.gbp.ExternalPolicyService;
import org.openstack4j.api.gbp.ExternalSegmentService;
import org.openstack4j.api.gbp.GbpService;
import org.openstack4j.api.gbp.L2policyService;
import org.openstack4j.api.gbp.L3policyService;
import org.openstack4j.api.gbp.NatPoolService;
import org.openstack4j.api.gbp.NetworkPolicyService;
import org.openstack4j.api.gbp.PolicyActionService;
import org.openstack4j.api.gbp.PolicyClassifierService;
import org.openstack4j.api.gbp.PolicyRuleService;
import org.openstack4j.api.gbp.PolicyRuleSetService;
import org.openstack4j.api.gbp.PolicyTargetService;
import org.openstack4j.api.gbp.ServiceProfileService;
import org.openstack4j.api.gbp.ServicechainService;
import org.openstack4j.api.heat.EventsService;
import org.openstack4j.api.heat.HeatService;
import org.openstack4j.api.heat.ResourcesService;
import org.openstack4j.api.heat.SoftwareConfigService;
import org.openstack4j.api.heat.StackService;
import org.openstack4j.api.heat.TemplateService;
import org.openstack4j.api.identity.v2.ServiceManagerService;
import org.openstack4j.api.identity.v2.TenantService;
import org.openstack4j.api.identity.v3.CredentialService;
import org.openstack4j.api.identity.v3.DomainService;
import org.openstack4j.api.identity.v3.GroupService;
import org.openstack4j.api.identity.v3.PolicyService;
import org.openstack4j.api.identity.v3.ProjectService;
import org.openstack4j.api.identity.v3.RegionService;
import org.openstack4j.api.identity.v3.RoleService;
import org.openstack4j.api.identity.v3.ServiceEndpointService;
import org.openstack4j.api.identity.v3.TokenService;
import org.openstack4j.api.identity.v3.UserService;
import org.openstack4j.api.image.ImageService;
import org.openstack4j.api.image.v2.TaskService;
import org.openstack4j.api.loadbalance.AsyncJobService;
import org.openstack4j.api.loadbalance.ELBCertificateService;
import org.openstack4j.api.loadbalance.ELBHealthCheckService;
import org.openstack4j.api.loadbalance.ELBListenerService;
import org.openstack4j.api.loadbalance.ELBLoadBalancerService;
import org.openstack4j.api.loadbalance.ELBQuotaService;
import org.openstack4j.api.loadbalance.ELBServerService;
import org.openstack4j.api.loadbalance.ELBService;
import org.openstack4j.api.magnum.MagnumService;
import org.openstack4j.api.manila.SchedulerStatsService;
import org.openstack4j.api.manila.SecurityServiceService;
import org.openstack4j.api.manila.ShareInstanceService;
import org.openstack4j.api.manila.ShareNetworkService;
import org.openstack4j.api.manila.ShareServerService;
import org.openstack4j.api.manila.ShareService;
import org.openstack4j.api.manila.ShareSnapshotService;
import org.openstack4j.api.manila.ShareTypeService;
import org.openstack4j.api.manila.SharesService;
import org.openstack4j.api.murano.v1.AppCatalogService;
import org.openstack4j.api.murano.v1.MuranoActionService;
import org.openstack4j.api.murano.v1.MuranoApplicationService;
import org.openstack4j.api.murano.v1.MuranoDeploymentService;
import org.openstack4j.api.murano.v1.MuranoEnvironmentService;
import org.openstack4j.api.murano.v1.MuranoSessionService;
import org.openstack4j.api.networking.NetFloatingIPService;
import org.openstack4j.api.networking.NetworkService;
import org.openstack4j.api.networking.NetworkingService;
import org.openstack4j.api.networking.PortService;
import org.openstack4j.api.networking.RouterService;
import org.openstack4j.api.networking.SecurityGroupRuleService;
import org.openstack4j.api.networking.SecurityGroupService;
import org.openstack4j.api.networking.SubnetService;
import org.openstack4j.api.networking.ext.AgentService;
import org.openstack4j.api.networking.ext.FirewallAsService;
import org.openstack4j.api.networking.ext.FirewallPolicyService;
import org.openstack4j.api.networking.ext.FirewallRuleService;
import org.openstack4j.api.networking.ext.FirewallService;
import org.openstack4j.api.networking.ext.HealthMonitorService;
import org.openstack4j.api.networking.ext.HealthMonitorV2Service;
import org.openstack4j.api.networking.ext.LbPoolService;
import org.openstack4j.api.networking.ext.LbPoolV2Service;
import org.openstack4j.api.networking.ext.LbaasV2Service;
import org.openstack4j.api.networking.ext.ListenerV2Service;
import org.openstack4j.api.networking.ext.LoadBalancerService;
import org.openstack4j.api.networking.ext.LoadBalancerV2Service;
import org.openstack4j.api.networking.ext.MemberService;
import org.openstack4j.api.networking.ext.NetQuotaService;
import org.openstack4j.api.networking.ext.VipService;
import org.openstack4j.api.sahara.ClusterService;
import org.openstack4j.api.sahara.ClusterTemplateService;
import org.openstack4j.api.sahara.DataSourceService;
import org.openstack4j.api.sahara.JobBinaryInternalService;
import org.openstack4j.api.sahara.JobBinaryService;
import org.openstack4j.api.sahara.JobExecutionService;
import org.openstack4j.api.sahara.JobService;
import org.openstack4j.api.sahara.NodeGroupTemplateService;
import org.openstack4j.api.sahara.SaharaImageService;
import org.openstack4j.api.sahara.SaharaPluginService;
import org.openstack4j.api.sahara.SaharaService;
import org.openstack4j.api.scaling.AutoScalingActivityLogService;
import org.openstack4j.api.scaling.AutoScalingConfigService;
import org.openstack4j.api.scaling.AutoScalingGroupInstanceService;
import org.openstack4j.api.scaling.AutoScalingGroupService;
import org.openstack4j.api.scaling.AutoScalingPolicyService;
import org.openstack4j.api.scaling.AutoScalingQuotaService;
import org.openstack4j.api.scaling.AutoScalingService;
import org.openstack4j.api.senlin.SenlinActionService;
import org.openstack4j.api.senlin.SenlinBuildInfoService;
import org.openstack4j.api.senlin.SenlinClusterPolicyService;
import org.openstack4j.api.senlin.SenlinClusterService;
import org.openstack4j.api.senlin.SenlinEventService;
import org.openstack4j.api.senlin.SenlinNodeService;
import org.openstack4j.api.senlin.SenlinPolicyService;
import org.openstack4j.api.senlin.SenlinPolicyTypeService;
import org.openstack4j.api.senlin.SenlinProfileService;
import org.openstack4j.api.senlin.SenlinProfileTypeService;
import org.openstack4j.api.senlin.SenlinReceiverService;
import org.openstack4j.api.senlin.SenlinService;
import org.openstack4j.api.senlin.SenlinVersionService;
import org.openstack4j.api.senlin.SenlinWebHookService;
import org.openstack4j.api.storage.AsyncVolumeBackupJobService;
import org.openstack4j.api.storage.AsyncVolumeBackupService;
import org.openstack4j.api.storage.BlockQuotaSetService;
import org.openstack4j.api.storage.BlockStorageService;
import org.openstack4j.api.storage.BlockVolumeBackupPolicyService;
import org.openstack4j.api.storage.BlockVolumeBackupService;
import org.openstack4j.api.storage.BlockVolumeService;
import org.openstack4j.api.storage.BlockVolumeSnapshotService;
import org.openstack4j.api.storage.BlockVolumeTransferService;
import org.openstack4j.api.storage.CinderZoneService;
import org.openstack4j.api.storage.ObjectStorageAccountService;
import org.openstack4j.api.storage.ObjectStorageContainerService;
import org.openstack4j.api.storage.ObjectStorageObjectService;
import org.openstack4j.api.storage.ObjectStorageService;
import org.openstack4j.api.storage.SchedulerStatsGetPoolService;
import org.openstack4j.api.storage.ext.BlockStorageServiceService;
import org.openstack4j.api.tacker.TackerService;
import org.openstack4j.api.tacker.TackerServiceImpl;
import org.openstack4j.api.tacker.VimService;
import org.openstack4j.api.tacker.VnfService;
import org.openstack4j.api.tacker.VnfdService;
import org.openstack4j.api.telemetry.AlarmAodhService;
import org.openstack4j.api.telemetry.AlarmService;
import org.openstack4j.api.telemetry.CapabilitiesService;
import org.openstack4j.api.telemetry.EventService;
import org.openstack4j.api.telemetry.MeterService;
import org.openstack4j.api.telemetry.ResourceService;
import org.openstack4j.api.telemetry.SampleService;
import org.openstack4j.api.telemetry.TelemetryAodhService;
import org.openstack4j.api.telemetry.TelemetryService;
import org.openstack4j.api.workflow.ActionDefinitionService;
import org.openstack4j.api.workflow.WorkbookDefinitionService;
import org.openstack4j.api.workflow.WorkflowDefinitionService;
import org.openstack4j.api.workflow.WorkflowService;
import org.openstack4j.openstack.antiddos.internal.AntiDDoSService;
import org.openstack4j.openstack.antiddos.internal.AntiDDoSServices;
import org.openstack4j.openstack.antiddos.internal.AntiDDoSWarnService;
import org.openstack4j.openstack.artifact.internal.ArtifactServiceImpl;
import org.openstack4j.openstack.artifact.internal.ToscaTemplatesArtifactServiceImpl;
import org.openstack4j.openstack.barbican.internal.BarbicanServiceImpl;
import org.openstack4j.openstack.barbican.internal.ContainerServiceImpl;
import org.openstack4j.openstack.cloud.trace.v1.internal.CloudTraceV1Service;
import org.openstack4j.openstack.cloud.trace.v1.internal.TraceService;
import org.openstack4j.openstack.cloud.trace.v1.internal.TrackerService;
import org.openstack4j.openstack.cloud.trace.v2.internal.CloudTraceV2Service;
import org.openstack4j.openstack.cloudeye.internal.CloudEyeAlarmServiceImpl;
import org.openstack4j.openstack.cloudeye.internal.CloudEyeMetricDataServiceImpl;
import org.openstack4j.openstack.cloudeye.internal.CloudEyeMetricServiceImpl;
import org.openstack4j.openstack.cloudeye.internal.CloudEyeQuotaServiceImpl;
import org.openstack4j.openstack.cloudeye.internal.CloudEyeServiceImpl;
import org.openstack4j.openstack.compute.internal.ComputeFloatingIPServiceImpl;
import org.openstack4j.openstack.compute.internal.ComputeImageServiceImpl;
import org.openstack4j.openstack.compute.internal.ComputeSecurityGroupServiceImpl;
import org.openstack4j.openstack.compute.internal.ComputeServiceImpl;
import org.openstack4j.openstack.compute.internal.FlavorServiceImpl;
import org.openstack4j.openstack.compute.internal.HostAggregateServiceImpl;
import org.openstack4j.openstack.compute.internal.HostServiceImpl;
import org.openstack4j.openstack.compute.internal.KeypairServiceImpl;
import org.openstack4j.openstack.compute.internal.QuotaSetServiceImpl;
import org.openstack4j.openstack.compute.internal.ServerGroupServiceImpl;
import org.openstack4j.openstack.compute.internal.ServerServiceImpl;
import org.openstack4j.openstack.compute.internal.ServerTagServiceImpl;
import org.openstack4j.openstack.compute.internal.ServicesServiceImpl;
import org.openstack4j.openstack.compute.internal.ext.FloatingIPDNSDomainServiceImpl;
import org.openstack4j.openstack.compute.internal.ext.FloatingIPDNSEntryServiceImpl;
import org.openstack4j.openstack.compute.internal.ext.FloatingIPDNSServiceImpl;
import org.openstack4j.openstack.compute.internal.ext.HypervisorServiceImpl;
import org.openstack4j.openstack.compute.internal.ext.InstanceActionsServiceImpl;
import org.openstack4j.openstack.compute.internal.ext.InterfaceServiceImpl;
import org.openstack4j.openstack.compute.internal.ext.MigrationServiceImpl;
import org.openstack4j.openstack.compute.internal.ext.ZoneServiceImpl;
import org.openstack4j.openstack.dns.v2.internal.DNSServiceImpl;
import org.openstack4j.openstack.dns.v2.internal.PTRServiceImpl;
import org.openstack4j.openstack.dns.v2.internal.RecordsetServiceImpl;
import org.openstack4j.openstack.gbp.internal.ExternalPolicyServiceImpl;
import org.openstack4j.openstack.gbp.internal.ExternalSegmentServiceImpl;
import org.openstack4j.openstack.gbp.internal.GbpServiceImpl;
import org.openstack4j.openstack.gbp.internal.L2policyServiceImpl;
import org.openstack4j.openstack.gbp.internal.L3policyServiceImpl;
import org.openstack4j.openstack.gbp.internal.NatPoolServiceImpl;
import org.openstack4j.openstack.gbp.internal.NetworkPolicyServiceImpl;
import org.openstack4j.openstack.gbp.internal.PolicyActionServiceImpl;
import org.openstack4j.openstack.gbp.internal.PolicyClassifierServiceImpl;
import org.openstack4j.openstack.gbp.internal.PolicyRuleServiceImpl;
import org.openstack4j.openstack.gbp.internal.PolicyRuleSetServiceImpl;
import org.openstack4j.openstack.gbp.internal.PolicyTargetServiceImpl;
import org.openstack4j.openstack.gbp.internal.ServiceProfileServiceImpl;
import org.openstack4j.openstack.gbp.internal.ServicechainServiceImpl;
import org.openstack4j.openstack.heat.internal.EventsServiceImpl;
import org.openstack4j.openstack.heat.internal.HeatServiceImpl;
import org.openstack4j.openstack.heat.internal.ResourcesServiceImpl;
import org.openstack4j.openstack.heat.internal.SoftwareConfigServiceImpl;
import org.openstack4j.openstack.heat.internal.StackServiceImpl;
import org.openstack4j.openstack.heat.internal.TemplateServiceImpl;
import org.openstack4j.openstack.identity.v2.internal.ServiceManagerServiceImpl;
import org.openstack4j.openstack.identity.v2.internal.TenantServiceImpl;
import org.openstack4j.openstack.identity.v3.internal.CredentialServiceImpl;
import org.openstack4j.openstack.identity.v3.internal.DomainServiceImpl;
import org.openstack4j.openstack.identity.v3.internal.GroupServiceImpl;
import org.openstack4j.openstack.identity.v3.internal.PolicyServiceImpl;
import org.openstack4j.openstack.identity.v3.internal.ProjectServiceImpl;
import org.openstack4j.openstack.identity.v3.internal.RegionServiceImpl;
import org.openstack4j.openstack.identity.v3.internal.RoleServiceImpl;
import org.openstack4j.openstack.identity.v3.internal.ServiceEndpointServiceImpl;
import org.openstack4j.openstack.identity.v3.internal.TokenServiceImpl;
import org.openstack4j.openstack.identity.v3.internal.UserServiceImpl;
import org.openstack4j.openstack.image.internal.ImageServiceImpl;
import org.openstack4j.openstack.image.v2.internal.TaskServiceImpl;
import org.openstack4j.openstack.key.management.internal.CryptoService;
import org.openstack4j.openstack.key.management.internal.KeyManagementService;
import org.openstack4j.openstack.key.management.internal.KeyService;
import org.openstack4j.openstack.loadbalance.internal.AsyncJobServiceImpl;
import org.openstack4j.openstack.loadbalance.internal.ELBCertificateSeviceImpl;
import org.openstack4j.openstack.loadbalance.internal.ELBHealthCheckServiceImpl;
import org.openstack4j.openstack.loadbalance.internal.ELBListenerServiceImpl;
import org.openstack4j.openstack.loadbalance.internal.ELBLoadBalancerServiceImpl;
import org.openstack4j.openstack.loadbalance.internal.ELBQuotaServiceImpl;
import org.openstack4j.openstack.loadbalance.internal.ELBServerServiceImpl;
import org.openstack4j.openstack.loadbalance.internal.ELBServiceImpl;
import org.openstack4j.openstack.maas.internal.MaaSService;
import org.openstack4j.openstack.maas.internal.VersionService;
import org.openstack4j.openstack.magnum.internal.MagnumServiceImpl;
import org.openstack4j.openstack.manila.internal.SchedulerStatsServiceImpl;
import org.openstack4j.openstack.manila.internal.SecurityServiceServiceImpl;
import org.openstack4j.openstack.manila.internal.ShareInstanceServiceImpl;
import org.openstack4j.openstack.manila.internal.ShareNetworkServiceImpl;
import org.openstack4j.openstack.manila.internal.ShareServerServiceImpl;
import org.openstack4j.openstack.manila.internal.ShareServiceImpl;
import org.openstack4j.openstack.manila.internal.ShareSnapshotServiceImpl;
import org.openstack4j.openstack.manila.internal.ShareTypeServiceImpl;
import org.openstack4j.openstack.manila.internal.SharesServiceImpl;
import org.openstack4j.openstack.message.notification.internal.MessageService;
import org.openstack4j.openstack.message.notification.internal.MessageTemplateService;
import org.openstack4j.openstack.message.notification.internal.NotificationService;
import org.openstack4j.openstack.message.notification.internal.SmsService;
import org.openstack4j.openstack.message.notification.internal.SubscriptionService;
import org.openstack4j.openstack.message.notification.internal.TopicService;
import org.openstack4j.openstack.message.queue.internal.ConsumerGroupService;
import org.openstack4j.openstack.message.queue.internal.MessageQueueQuotaService;
import org.openstack4j.openstack.message.queue.internal.MessageQueueService;
import org.openstack4j.openstack.message.queue.internal.QueueMessageService;
import org.openstack4j.openstack.message.queue.internal.QueueService;
import org.openstack4j.openstack.murano.v1.internal.MuranoActionServiceImpl;
import org.openstack4j.openstack.murano.v1.internal.MuranoApplicationServiceImpl;
import org.openstack4j.openstack.murano.v1.internal.MuranoDeploymentServiceImpl;
import org.openstack4j.openstack.murano.v1.internal.MuranoEnvironmentServiceImpl;
import org.openstack4j.openstack.murano.v1.internal.MuranoService;
import org.openstack4j.openstack.murano.v1.internal.MuranoSessionServiceImpl;
import org.openstack4j.openstack.networking.internal.FloatingIPServiceImpl;
import org.openstack4j.openstack.networking.internal.NetworkServiceImpl;
import org.openstack4j.openstack.networking.internal.NetworkingServiceImpl;
import org.openstack4j.openstack.networking.internal.PortServiceImpl;
import org.openstack4j.openstack.networking.internal.RouterServiceImpl;
import org.openstack4j.openstack.networking.internal.SecurityGroupRuleServiceImpl;
import org.openstack4j.openstack.networking.internal.SecurityGroupServiceImpl;
import org.openstack4j.openstack.networking.internal.SubnetServiceImpl;
import org.openstack4j.openstack.networking.internal.ext.AgentServiceImpl;
import org.openstack4j.openstack.networking.internal.ext.FirewallAsServiceImpl;
import org.openstack4j.openstack.networking.internal.ext.FirewallPolicyServiceImpl;
import org.openstack4j.openstack.networking.internal.ext.FirewallRuleServiceImpl;
import org.openstack4j.openstack.networking.internal.ext.FirewallServiceImpl;
import org.openstack4j.openstack.networking.internal.ext.HealthMonitorServiceImpl;
import org.openstack4j.openstack.networking.internal.ext.HealthMonitorV2ServiceImpl;
import org.openstack4j.openstack.networking.internal.ext.LbPoolServiceImpl;
import org.openstack4j.openstack.networking.internal.ext.LbPoolV2ServiceImpl;
import org.openstack4j.openstack.networking.internal.ext.LbaasV2ServiceImpl;
import org.openstack4j.openstack.networking.internal.ext.ListenerV2ServiceImpl;
import org.openstack4j.openstack.networking.internal.ext.LoadBalancerServiceImpl;
import org.openstack4j.openstack.networking.internal.ext.LoadBalancerV2ServiceImpl;
import org.openstack4j.openstack.networking.internal.ext.MemberServiceImpl;
import org.openstack4j.openstack.networking.internal.ext.NetQuotaServiceImpl;
import org.openstack4j.openstack.networking.internal.ext.VipServiceImpl;
import org.openstack4j.openstack.sahara.internal.ClusterServiceImpl;
import org.openstack4j.openstack.sahara.internal.ClusterServiceImpl2;
import org.openstack4j.openstack.sahara.internal.ClusterTemplateServiceImpl;
import org.openstack4j.openstack.sahara.internal.DataSourceServiceImpl;
import org.openstack4j.openstack.sahara.internal.JobBinaryInternalServiceImpl;
import org.openstack4j.openstack.sahara.internal.JobBinaryServiceImpl;
import org.openstack4j.openstack.sahara.internal.JobExeServiceImpl;
import org.openstack4j.openstack.sahara.internal.JobExecutionServiceImpl;
import org.openstack4j.openstack.sahara.internal.JobServiceImpl;
import org.openstack4j.openstack.sahara.internal.NodeGroupTemplateServiceImpl;
import org.openstack4j.openstack.sahara.internal.SaharaImageServiceImpl;
import org.openstack4j.openstack.sahara.internal.SaharaPluginServiceImpl;
import org.openstack4j.openstack.sahara.internal.SaharaServiceImpl;
import org.openstack4j.openstack.scaling.internal.AutoScalingActivityLogServiceImpl;
import org.openstack4j.openstack.scaling.internal.AutoScalingConfigServiceImpl;
import org.openstack4j.openstack.scaling.internal.AutoScalingGroupInstanceServiceImpl;
import org.openstack4j.openstack.scaling.internal.AutoScalingGroupServiceImpl;
import org.openstack4j.openstack.scaling.internal.AutoScalingPolicyServiceImpl;
import org.openstack4j.openstack.scaling.internal.AutoScalingQuotaServiceImpl;
import org.openstack4j.openstack.scaling.internal.AutoScalingServiceImpl;
import org.openstack4j.openstack.senlin.internal.SenlinActionServiceImpl;
import org.openstack4j.openstack.senlin.internal.SenlinBuildInfoServiceImpl;
import org.openstack4j.openstack.senlin.internal.SenlinClusterPolicyServiceImpl;
import org.openstack4j.openstack.senlin.internal.SenlinClusterServiceImpl;
import org.openstack4j.openstack.senlin.internal.SenlinEventServiceImpl;
import org.openstack4j.openstack.senlin.internal.SenlinNodeServiceImpl;
import org.openstack4j.openstack.senlin.internal.SenlinPolicyServiceImpl;
import org.openstack4j.openstack.senlin.internal.SenlinPolicyTypeServiceImpl;
import org.openstack4j.openstack.senlin.internal.SenlinProfileServiceImpl;
import org.openstack4j.openstack.senlin.internal.SenlinProfileTypeServiceImpl;
import org.openstack4j.openstack.senlin.internal.SenlinReceiverServiceImpl;
import org.openstack4j.openstack.senlin.internal.SenlinServiceImpl;
import org.openstack4j.openstack.senlin.internal.SenlinVersionServiceImpl;
import org.openstack4j.openstack.senlin.internal.SenlinWebHookServiceImpl;
import org.openstack4j.openstack.storage.block.internal.BlockQuotaSetServiceImpl;
import org.openstack4j.openstack.storage.block.internal.BlockStorageServiceImpl;
import org.openstack4j.openstack.storage.block.internal.BlockStorageServiceServiceImpl;
import org.openstack4j.openstack.storage.block.internal.BlockVolumeBackupServiceImpl;
import org.openstack4j.openstack.storage.block.internal.BlockVolumeServiceImpl;
import org.openstack4j.openstack.storage.block.internal.BlockVolumeSnapshotServiceImpl;
import org.openstack4j.openstack.storage.block.internal.BlockVolumeTransferServiceImpl;
import org.openstack4j.openstack.storage.block.internal.CinderZoneServiceImpl;
import org.openstack4j.openstack.storage.block.internal.SchedulerStatsGetPoolServiceImpl;
import org.openstack4j.openstack.storage.block.internal.VBSVolumeBackupJobServiceImpl;
import org.openstack4j.openstack.storage.block.internal.VBSVolumeBackupPolicyService;
import org.openstack4j.openstack.storage.block.internal.VBSVolumeBackupServiceImpl;
import org.openstack4j.openstack.storage.object.internal.ObjectStorageAccountServiceImpl;
import org.openstack4j.openstack.storage.object.internal.ObjectStorageContainerServiceImpl;
import org.openstack4j.openstack.storage.object.internal.ObjectStorageObjectServiceImpl;
import org.openstack4j.openstack.storage.object.internal.ObjectStorageServiceImpl;
import org.openstack4j.openstack.tacker.internal.VimServiceImpl;
import org.openstack4j.openstack.tacker.internal.VnfServiceImpl;
import org.openstack4j.openstack.tacker.internal.VnfdServiceImpl;
import org.openstack4j.openstack.telemetry.internal.AlarmAodhServiceImpl;
import org.openstack4j.openstack.telemetry.internal.AlarmServiceImpl;
import org.openstack4j.openstack.telemetry.internal.CapabilitiesServiceImpl;
import org.openstack4j.openstack.telemetry.internal.EventServiceImpl;
import org.openstack4j.openstack.telemetry.internal.MeterServiceImpl;
import org.openstack4j.openstack.telemetry.internal.ResourceServiceImpl;
import org.openstack4j.openstack.telemetry.internal.SampleServiceImpl;
import org.openstack4j.openstack.telemetry.internal.TelemetryAodhServiceImpl;
import org.openstack4j.openstack.telemetry.internal.TelemetryServiceImpl;
import org.openstack4j.openstack.trove.internal.TroveDatabaseParamService;
import org.openstack4j.openstack.trove.internal.TroveDatabaseConfigService;
import org.openstack4j.openstack.trove.internal.TroveDatabaseInstanceService;
import org.openstack4j.openstack.trove.internal.TroveDatabaseService;
import org.openstack4j.openstack.trove.internal.TroveInstanceFlavorService;
import org.openstack4j.openstack.trove.internal.TroveService;
import org.openstack4j.openstack.trove.internal.TroveVersionService;
import org.openstack4j.openstack.workflow.internal.ActionDefinitionServiceImpl;
import org.openstack4j.openstack.workflow.internal.WorkbookDefinitionServiceImpl;
import org.openstack4j.openstack.workflow.internal.WorkflowDefinitionServiceImpl;
import org.openstack4j.openstack.workflow.internal.WorkflowServiceImpl;

import com.google.common.collect.Maps;

/**
 * Simple API Provider which keeps internally Maps interface implementations as singletons
 *
 * @author Jeremy Unruh
 */
public class DefaultAPIProvider implements APIProvider {

	private static final Map<Class<?>, Class<?>> bindings = Maps.newHashMap();
	private static final Map<Class<?>, Object> instances = Maps.newConcurrentMap();

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void initialize() {
		bind(org.openstack4j.api.identity.v2.IdentityService.class,
				org.openstack4j.openstack.identity.v2.internal.IdentityServiceImpl.class);
		bind(TenantService.class, TenantServiceImpl.class);
		bind(ServiceManagerService.class, ServiceManagerServiceImpl.class);
		bind(org.openstack4j.api.identity.v2.UserService.class,
				org.openstack4j.openstack.identity.v2.internal.UserServiceImpl.class);
		bind(org.openstack4j.api.identity.v2.RoleService.class,
				org.openstack4j.openstack.identity.v2.internal.RoleServiceImpl.class);
		bind(org.openstack4j.api.identity.v3.IdentityService.class,
				org.openstack4j.openstack.identity.v3.internal.IdentityServiceImpl.class);
		bind(ServiceEndpointService.class, ServiceEndpointServiceImpl.class);
		bind(CredentialService.class, CredentialServiceImpl.class);
		bind(UserService.class, UserServiceImpl.class);
		bind(ProjectService.class, ProjectServiceImpl.class);
		bind(RoleService.class, RoleServiceImpl.class);
		bind(DomainService.class, DomainServiceImpl.class);
		bind(GroupService.class, GroupServiceImpl.class);
		bind(PolicyService.class, PolicyServiceImpl.class);
		bind(RegionService.class, RegionServiceImpl.class);
		bind(TokenService.class, TokenServiceImpl.class);
		bind(ComputeService.class, ComputeServiceImpl.class);
		bind(FlavorService.class, FlavorServiceImpl.class);
		bind(ComputeImageService.class, ComputeImageServiceImpl.class);
		bind(ServerService.class, ServerServiceImpl.class);
		bind(QuotaSetService.class, QuotaSetServiceImpl.class);
		bind(HostService.class, HostServiceImpl.class);
		bind(NetworkingService.class, NetworkingServiceImpl.class);
		bind(NetworkService.class, NetworkServiceImpl.class);
		bind(ArtifactService.class, ArtifactServiceImpl.class);
		bind(ToscaTemplatesArtifactService.class, ToscaTemplatesArtifactServiceImpl.class);
		bind(SubnetService.class, SubnetServiceImpl.class);
		bind(PortService.class, PortServiceImpl.class);
		bind(RouterService.class, RouterServiceImpl.class);
		bind(ImageService.class, ImageServiceImpl.class);
		bind(BlockStorageService.class, BlockStorageServiceImpl.class);
		bind(BlockVolumeService.class, BlockVolumeServiceImpl.class);
		bind(BlockVolumeSnapshotService.class, BlockVolumeSnapshotServiceImpl.class);
		bind(BlockVolumeBackupService.class, BlockVolumeBackupServiceImpl.class);
		bind(ComputeSecurityGroupService.class, ComputeSecurityGroupServiceImpl.class);
		bind(KeypairService.class, KeypairServiceImpl.class);
		bind(NetFloatingIPService.class, FloatingIPServiceImpl.class);
		bind(ComputeFloatingIPService.class, ComputeFloatingIPServiceImpl.class);
		bind(SecurityGroupService.class, SecurityGroupServiceImpl.class);
		bind(SecurityGroupRuleService.class, SecurityGroupRuleServiceImpl.class);
		bind(TelemetryService.class, TelemetryServiceImpl.class);
		bind(MeterService.class, MeterServiceImpl.class);
		bind(SampleService.class, SampleServiceImpl.class);
		bind(AlarmService.class, AlarmServiceImpl.class);
		bind(EventService.class, EventServiceImpl.class);
		bind(CapabilitiesService.class, CapabilitiesServiceImpl.class);
		bind(ResourceService.class, ResourceServiceImpl.class);
		bind(HypervisorService.class, HypervisorServiceImpl.class);
		bind(ZoneService.class, ZoneServiceImpl.class);
		bind(CinderZoneService.class, CinderZoneServiceImpl.class);
		bind(HeatService.class, HeatServiceImpl.class);
		bind(SenlinService.class, SenlinServiceImpl.class);
		bind(SenlinPolicyService.class, SenlinPolicyServiceImpl.class);
		bind(SenlinVersionService.class, SenlinVersionServiceImpl.class);
		bind(SenlinActionService.class, SenlinActionServiceImpl.class);
		bind(SenlinBuildInfoService.class, SenlinBuildInfoServiceImpl.class);
		bind(SenlinClusterService.class, SenlinClusterServiceImpl.class);
		bind(SenlinClusterPolicyService.class, SenlinClusterPolicyServiceImpl.class);
		bind(SenlinEventService.class, SenlinEventServiceImpl.class);
		bind(SenlinNodeService.class, SenlinNodeServiceImpl.class);
		bind(SenlinProfileService.class, SenlinProfileServiceImpl.class);
		bind(SenlinProfileTypeService.class, SenlinProfileTypeServiceImpl.class);
		bind(SenlinPolicyTypeService.class, SenlinPolicyTypeServiceImpl.class);
		bind(SenlinReceiverService.class, SenlinReceiverServiceImpl.class);
		bind(SenlinWebHookService.class, SenlinWebHookServiceImpl.class);
		bind(StackService.class, StackServiceImpl.class);
		bind(TemplateService.class, TemplateServiceImpl.class);
		bind(EventsService.class, EventsServiceImpl.class);
		bind(ResourcesService.class, ResourcesServiceImpl.class);
		bind(MigrationService.class, MigrationServiceImpl.class);
		bind(SoftwareConfigService.class, SoftwareConfigServiceImpl.class);
		bind(ObjectStorageService.class, ObjectStorageServiceImpl.class);
		bind(ObjectStorageAccountService.class, ObjectStorageAccountServiceImpl.class);
		bind(ObjectStorageContainerService.class, ObjectStorageContainerServiceImpl.class);
		bind(ServerGroupService.class, ServerGroupServiceImpl.class);
		bind(ObjectStorageObjectService.class, ObjectStorageObjectServiceImpl.class);
		bind(NetQuotaService.class, NetQuotaServiceImpl.class);
		bind(InterfaceService.class, InterfaceServiceImpl.class);
		bind(InstanceActionsService.class, InstanceActionsServiceImpl.class);
		bind(FloatingIPDNSService.class, FloatingIPDNSServiceImpl.class);
		bind(FloatingIPDNSDomainService.class, FloatingIPDNSDomainServiceImpl.class);
		bind(FloatingIPDNSEntryService.class, FloatingIPDNSEntryServiceImpl.class);
		bind(HostAggregateService.class, HostAggregateServiceImpl.class);
		bind(MemberService.class, MemberServiceImpl.class);
		bind(VipService.class, VipServiceImpl.class);
		bind(HealthMonitorService.class, HealthMonitorServiceImpl.class);
		bind(LbPoolService.class, LbPoolServiceImpl.class);
		bind(LoadBalancerService.class, LoadBalancerServiceImpl.class);
		bind(BlockVolumeTransferService.class, BlockVolumeTransferServiceImpl.class);

		bind(SaharaPluginService.class, SaharaPluginServiceImpl.class);
		bind(SaharaImageService.class, SaharaImageServiceImpl.class);
		bind(SaharaService.class, SaharaServiceImpl.class);
		bind(ClusterService.class, ClusterServiceImpl.class);
		bind(ClusterServiceImpl2.class, ClusterServiceImpl2.class);
		bind(AppCatalogService.class, MuranoService.class);
		bind(MuranoEnvironmentService.class, MuranoEnvironmentServiceImpl.class);
		bind(MuranoSessionService.class, MuranoSessionServiceImpl.class);
		bind(MuranoApplicationService.class, MuranoApplicationServiceImpl.class);
		bind(MuranoDeploymentService.class, MuranoDeploymentServiceImpl.class);
		bind(MuranoActionService.class, MuranoActionServiceImpl.class);
		bind(ClusterTemplateService.class, ClusterTemplateServiceImpl.class);
		bind(NodeGroupTemplateService.class, NodeGroupTemplateServiceImpl.class);
		bind(DataSourceService.class, DataSourceServiceImpl.class);
		bind(JobBinaryInternalService.class, JobBinaryInternalServiceImpl.class);
		bind(JobBinaryService.class, JobBinaryServiceImpl.class);
		bind(JobService.class, JobServiceImpl.class);
		bind(JobExecutionService.class, JobExecutionServiceImpl.class);
		bind(JobExeServiceImpl.class, JobExeServiceImpl.class);
		bind(ShareService.class, ShareServiceImpl.class);
		bind(SecurityServiceService.class, SecurityServiceServiceImpl.class);
		bind(ShareSnapshotService.class, ShareSnapshotServiceImpl.class);
		bind(ShareNetworkService.class, ShareNetworkServiceImpl.class);
		bind(SharesService.class, SharesServiceImpl.class);
		bind(ShareServerService.class, ShareServerServiceImpl.class);
		bind(ShareInstanceService.class, ShareInstanceServiceImpl.class);
		bind(ShareTypeService.class, ShareTypeServiceImpl.class);
		bind(SchedulerStatsService.class, SchedulerStatsServiceImpl.class);
		bind(org.openstack4j.api.manila.QuotaSetService.class,
				org.openstack4j.openstack.manila.internal.QuotaSetServiceImpl.class);
		bind(GbpService.class, GbpServiceImpl.class);
		bind(ExternalPolicyService.class, ExternalPolicyServiceImpl.class);
		bind(ExternalSegmentService.class, ExternalSegmentServiceImpl.class);
		bind(org.openstack4j.api.gbp.GroupService.class, org.openstack4j.openstack.gbp.internal.GroupServiceImpl.class);
		bind(L2policyService.class, L2policyServiceImpl.class);
		bind(L3policyService.class, L3policyServiceImpl.class);
		bind(NatPoolService.class, NatPoolServiceImpl.class);
		bind(NetworkService.class, NetworkServiceImpl.class);
		bind(PolicyActionService.class, PolicyActionServiceImpl.class);
		bind(PolicyRuleService.class, PolicyRuleServiceImpl.class);
		bind(PolicyRuleSetService.class, PolicyRuleSetServiceImpl.class);
		bind(PolicyTargetService.class, PolicyTargetServiceImpl.class);
		bind(PolicyClassifierService.class, PolicyClassifierServiceImpl.class);
		bind(ServicechainService.class, ServicechainServiceImpl.class);
		bind(ServiceProfileService.class, ServiceProfileServiceImpl.class);
		bind(BlockQuotaSetService.class, BlockQuotaSetServiceImpl.class);
		bind(FirewallAsService.class, FirewallAsServiceImpl.class);
		bind(FirewallService.class, FirewallServiceImpl.class);
		bind(FirewallRuleService.class, FirewallRuleServiceImpl.class);
		bind(FirewallPolicyService.class, FirewallPolicyServiceImpl.class);
		bind(NetworkPolicyService.class, NetworkPolicyServiceImpl.class);
		bind(LbaasV2Service.class, LbaasV2ServiceImpl.class);
		bind(LoadBalancerV2Service.class, LoadBalancerV2ServiceImpl.class);
		bind(ListenerV2Service.class, ListenerV2ServiceImpl.class);
		bind(HealthMonitorV2Service.class, HealthMonitorV2ServiceImpl.class);
		bind(LbPoolV2Service.class, LbPoolV2ServiceImpl.class);

		// trove
		bind(TroveService.class, TroveService.class);
		bind(TroveInstanceFlavorService.class, TroveInstanceFlavorService.class);
		bind(TroveDatabaseService.class, TroveDatabaseService.class);
		bind(TroveDatabaseInstanceService.class, TroveDatabaseInstanceService.class);
		bind(TroveVersionService.class, TroveVersionService.class);
		bind(TroveDatabaseConfigService.class, TroveDatabaseConfigService.class);
		bind(TroveDatabaseParamService.class, TroveDatabaseParamService.class);

		bind(SchedulerStatsGetPoolService.class, SchedulerStatsGetPoolServiceImpl.class);
		bind(BarbicanService.class, BarbicanServiceImpl.class);
		bind(ContainerService.class, ContainerServiceImpl.class);
		bind(TackerService.class, TackerServiceImpl.class);
		bind(VnfdService.class, VnfdServiceImpl.class);
		bind(VnfService.class, VnfServiceImpl.class);
		bind(VimService.class, VimServiceImpl.class);
		bind(AgentService.class, AgentServiceImpl.class);
		bind(org.openstack4j.api.image.v2.ImageService.class,
				org.openstack4j.openstack.image.v2.internal.ImageServiceImpl.class);
		bind(TaskService.class, TaskServiceImpl.class);
		bind(TaskService.class, TaskServiceImpl.class);
		bind(ServerTagService.class, ServerTagServiceImpl.class);
		bind(TelemetryAodhService.class, TelemetryAodhServiceImpl.class);
		bind(AlarmAodhService.class, AlarmAodhServiceImpl.class);
		bind(ServicesService.class, ServicesServiceImpl.class);
		bind(BlockStorageServiceService.class, BlockStorageServiceServiceImpl.class);
		bind(MagnumService.class, MagnumServiceImpl.class);
		bind(WorkflowService.class, WorkflowServiceImpl.class);
		bind(WorkflowDefinitionService.class, WorkflowDefinitionServiceImpl.class);
		bind(DNSService.class, DNSServiceImpl.class);
		bind(org.openstack4j.api.dns.v2.ZoneService.class,
				org.openstack4j.openstack.dns.v2.internal.ZoneServiceImpl.class);
		bind(RecordsetService.class, RecordsetServiceImpl.class);
		bind(WorkflowService.class, WorkflowServiceImpl.class);
		bind(WorkflowDefinitionService.class, WorkflowDefinitionServiceImpl.class);
		bind(WorkbookDefinitionService.class, WorkbookDefinitionServiceImpl.class);
		bind(ActionDefinitionService.class, ActionDefinitionServiceImpl.class);

		// huawei openstack services binding
		// Volume Backup
		bind(AsyncVolumeBackupService.class, VBSVolumeBackupServiceImpl.class);
		bind(AsyncVolumeBackupJobService.class, VBSVolumeBackupJobServiceImpl.class);
		bind(BlockVolumeBackupPolicyService.class, VBSVolumeBackupPolicyService.class);

		// DNS
		bind(PTRService.class, PTRServiceImpl.class);

		// Cloud Eye
		bind(CloudEyeService.class, CloudEyeServiceImpl.class);
		bind(MetricService.class, CloudEyeMetricServiceImpl.class);
		bind(org.openstack4j.api.cloudeye.AlarmService.class, CloudEyeAlarmServiceImpl.class);
		bind(MetricDataService.class, CloudEyeMetricDataServiceImpl.class);
		bind(QuotaService.class, CloudEyeQuotaServiceImpl.class);

		// auto-scaling
		bind(AutoScalingService.class, AutoScalingServiceImpl.class);
		bind(AutoScalingGroupService.class, AutoScalingGroupServiceImpl.class);
		bind(AutoScalingConfigService.class, AutoScalingConfigServiceImpl.class);
		bind(AutoScalingGroupInstanceService.class, AutoScalingGroupInstanceServiceImpl.class);
		bind(AutoScalingPolicyService.class, AutoScalingPolicyServiceImpl.class);
		bind(AutoScalingActivityLogService.class, AutoScalingActivityLogServiceImpl.class);
		bind(AutoScalingQuotaService.class, AutoScalingQuotaServiceImpl.class);

		// load balance
		bind(ELBService.class, ELBServiceImpl.class);
		bind(ELBLoadBalancerService.class, ELBLoadBalancerServiceImpl.class);
		bind(ELBListenerService.class, ELBListenerServiceImpl.class);
		bind(ELBHealthCheckService.class, ELBHealthCheckServiceImpl.class);
		bind(ELBServerService.class, ELBServerServiceImpl.class);
		bind(ELBQuotaService.class, ELBQuotaServiceImpl.class);
		bind(ELBCertificateService.class, ELBCertificateSeviceImpl.class);
		bind(AsyncJobService.class, AsyncJobServiceImpl.class);

		// key management
		bind(KeyService.class, KeyService.class);
		bind(CryptoService.class, CryptoService.class);
		bind(KeyManagementService.class, KeyManagementService.class);

		// cloud trace
		bind(TraceService.class, TraceService.class);
		bind(TrackerService.class, TrackerService.class);
		bind(CloudTraceV1Service.class, CloudTraceV1Service.class);

		bind(org.openstack4j.openstack.cloud.trace.v2.internal.TraceService.class,
				org.openstack4j.openstack.cloud.trace.v2.internal.TraceService.class);
		bind(CloudTraceV2Service.class, CloudTraceV2Service.class);

		// anti-ddos
		bind(AntiDDoSServices.class, AntiDDoSServices.class);
		bind(AntiDDoSService.class, AntiDDoSService.class);
		bind(AntiDDoSWarnService.class, AntiDDoSWarnService.class);

		// simple message notification
		bind(NotificationService.class, NotificationService.class);
		bind(TopicService.class, TopicService.class);
		bind(SubscriptionService.class, SubscriptionService.class);
		bind(MessageTemplateService.class, MessageTemplateService.class);
		bind(MessageService.class, MessageService.class);
		bind(SmsService.class, SmsService.class);

		// distributed message
		bind(MessageQueueService.class, MessageQueueService.class);
		bind(QueueMessageService.class, QueueMessageService.class);
		bind(QueueService.class, QueueService.class);
		bind(ConsumerGroupService.class, ConsumerGroupService.class);
		bind(MessageQueueQuotaService.class, MessageQueueQuotaService.class);

		// maas
		bind(MaaSService.class, MaaSService.class);
		bind(VersionService.class, VersionService.class);
		bind(org.openstack4j.openstack.maas.internal.TaskService.class,
				org.openstack4j.openstack.maas.internal.TaskService.class);

	}

	/**
	 * {@inheritDoc}
	 */
	@SuppressWarnings("unchecked")
	@Override
	public <T> T get(Class<T> api) {
		if (instances.containsKey(api))
			return (T) instances.get(api);

		if (bindings.containsKey(api)) {
			try {
				T impl = (T) bindings.get(api).newInstance();
				instances.put(api, impl);
				return impl;
			} catch (Exception e) {
				throw new ApiNotFoundException("API Not found for: " + api.getName(), e);
			}
		}
		throw new ApiNotFoundException("API Not found for: " + api.getName());
	}

	private void bind(Class<?> api, Class<?> impl) {
		bindings.put(api, impl);
	}
}
