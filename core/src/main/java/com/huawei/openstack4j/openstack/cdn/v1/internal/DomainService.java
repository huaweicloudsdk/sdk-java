/*******************************************************************************
 * 	Copyright 2018 HuaWei and OTC                                       
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
package com.huawei.openstack4j.openstack.cdn.v1.internal;

import java.util.Map;

import com.google.common.base.Preconditions;
import com.huawei.openstack4j.openstack.cdn.v1.domain.CacheConfig;
import com.huawei.openstack4j.openstack.cdn.v1.domain.Domain;
import com.huawei.openstack4j.openstack.cdn.v1.domain.Domain.Domains;
import com.huawei.openstack4j.openstack.cdn.v1.domain.DomainCreate;
import com.huawei.openstack4j.openstack.cdn.v1.domain.HttpsInfo;
import com.huawei.openstack4j.openstack.cdn.v1.domain.OriginHost;
import com.huawei.openstack4j.openstack.cdn.v1.domain.PreheatingTask;
import com.huawei.openstack4j.openstack.cdn.v1.domain.PreheatingTaskCreate;
import com.huawei.openstack4j.openstack.cdn.v1.domain.Referer;
import com.huawei.openstack4j.openstack.cdn.v1.domain.RefreshTask;
import com.huawei.openstack4j.openstack.cdn.v1.domain.RefreshTaskCreate;
import com.huawei.openstack4j.openstack.cdn.v1.domain.Source.Origin;
import com.huawei.openstack4j.openstack.cdn.v1.domain.Task;
import com.huawei.openstack4j.openstack.cdn.v1.domain.Task.Tasks;
import com.huawei.openstack4j.openstack.cdn.v1.domain.TaskDetail;
import com.huawei.openstack4j.openstack.cdn.v1.exception.ServerCdnErrorResponseException;

/**
 * Domain Name Configuration Service
 * @author ChangjunZhao
 * @date   2018-05-06
 */
public class DomainService extends BaseCdnServices{
	
	/**
	 * Querying an Acceleration Domain Name
	 * @param params
	 * @return
	 */
	public Domains list(Map<String, String> params){
		Preconditions.checkNotNull(params.get("page_size"), "parameter `page_size` should not be null");
		Preconditions.checkNotNull(params.get("page_number"), "parameter `page_number` should not be null");
		Invocation<Domains> domainInvocation = get(Domains.class, uri("/domains"));
		if (params != null) {
            for (Map.Entry<String, String> entry : params.entrySet()) {
            	domainInvocation = domainInvocation.param(entry.getKey(), entry.getValue());
            }
        }
		return domainInvocation.execute(this.buildExecutionOptions(Domains.class));
	}
	
	/**
	 * Creating an Acceleration Domain Name
	 * @param creation
	 * @return
	 * @throws ServerCdnErrorResponseException
	 */
	public Domain create(DomainCreate creation) throws ServerCdnErrorResponseException{
		Preconditions.checkNotNull(creation, "parameter `creation` should not be null");
		Preconditions.checkNotNull(creation.getBusinessType(), "parameter `business_type` should not be null");
		Preconditions.checkNotNull(creation.getDomainName(), "parameter `domain_name` should not be null");
		Preconditions.checkNotNull(creation.getSources(),"parameter `creation.sources` should not be empty");
		Preconditions.checkNotNull(creation.getSources().get(0).getIpOrDomain(), "parameter `ip_or_domain` should not be empty");
		return post(Domain.class, uri("/domains")).entity(creation).execute(this.buildExecutionOptions(Domain.class));
	}
	
	/**
	 * Deleting an Acceleration Domain Name
	 * @param domainId
	 * @return
	 * @throws ServerCdnErrorResponseException
	 */
	public Domain delete(String domainId) throws ServerCdnErrorResponseException{
		Preconditions.checkNotNull(domainId, "parameter `domainId` should not be null");
		return delete(Domain.class, uri("/domains/%s",domainId)).execute(this.buildExecutionOptions(Domain.class));
	}
	
	/**
	 * Enabling an Acceleration Domain Name
	 * @param domainId
	 * @return
	 * @throws ServerCdnErrorResponseException
	 */
	public Domain enable(String domainId) throws ServerCdnErrorResponseException{
		Preconditions.checkNotNull(domainId, "parameter `domainId` should not be null");
		return put(Domain.class, uri("/domains/%s/enable",domainId)).execute(this.buildExecutionOptions(Domain.class));
	}
	
	/**
	 * Disabling an Acceleration Domain Name
	 * @param domainId
	 * @return
	 * @throws ServerCdnErrorResponseException
	 */
	public Domain disable(String domainId) throws ServerCdnErrorResponseException{
		Preconditions.checkNotNull(domainId, "parameter `domainId` should not be null");
		return put(Domain.class, uri("/domains/%s/disable",domainId)).execute(this.buildExecutionOptions(Domain.class));
	}
	
	/**
	 * Querying Details About an Acceleration Domain Name
	 * @param domainId
	 * @return
	 * @throws ServerCdnErrorResponseException
	 */
	public Domain getDetail(String domainId) throws ServerCdnErrorResponseException{
		Preconditions.checkNotNull(domainId, "parameter `domainId` should not be null");
		return get(Domain.class, uri("/domains/%s/detail",domainId)).execute(this.buildExecutionOptions(Domain.class));
	}
	
	/**
	 * Modifying Information About the Origin Server
	 * @param domainId
	 * @param origin
	 * @return
	 * @throws ServerCdnErrorResponseException
	 */
	public Origin setOrigin(String domainId, Origin origin) throws ServerCdnErrorResponseException{
		Preconditions.checkNotNull(domainId, "parameter `domainId` should not be null");
		Preconditions.checkNotNull(origin, "parameter `origin` should not be null");
		return put(Origin.class, uri("/domains/%s/origin",domainId)).entity(origin).execute(this.buildExecutionOptions(Origin.class));
	}
	
	/**
	 * Querying a Retrieval Host
	 * @param domainId
	 * @return
	 * @throws ServerCdnErrorResponseException
	 */
	public OriginHost getOriginHost(String domainId) throws ServerCdnErrorResponseException{
		Preconditions.checkNotNull(domainId, "parameter `domainId` should not be null");
		return get(OriginHost.class, uri("/domains/%s/originhost",domainId)).execute(this.buildExecutionOptions(OriginHost.class));
	}
	
	/**
	 * Modifying the Configuration of the Retrieval Host
	 * @param domainId
	 * @param originHost
	 * @return
	 * @throws ServerCdnErrorResponseException
	 */
	public OriginHost setOriginHost(String domainId, OriginHost originHost) throws ServerCdnErrorResponseException{
		Preconditions.checkNotNull(domainId, "parameter `domainId` should not be null");
		Preconditions.checkNotNull(originHost, "parameter `originHost` should not be null");
		Preconditions.checkNotNull(originHost.getOriginHostType(), "parameter `origin_host_type` should not be null");
		return put(OriginHost.class, uri("/domains/%s/originhost",domainId)).entity(originHost).execute(this.buildExecutionOptions(OriginHost.class));
	}
	
	/**
	 * Configuring a Referrer List
	 * @param domainId
	 * @param referer
	 * @return
	 * @throws ServerCdnErrorResponseException
	 */
	public Referer setReferer(String domainId, Referer referer) throws ServerCdnErrorResponseException{
		Preconditions.checkNotNull(domainId, "parameter `domainId` should not be null");
		Preconditions.checkNotNull(referer, "parameter `referer` should not be null");
		Preconditions.checkNotNull(referer.getRefererType(), "parameter `referer_type` should not be null");
		return put(Referer.class, uri("/domains/%s/referer",domainId)).entity(referer).execute(this.buildExecutionOptions(Referer.class));
	}
	
	/**
	 * Querying a Referrer List
	 * @param domainId
	 * @return
	 * @throws ServerCdnErrorResponseException
	 */
	public Referer getReferer(String domainId) throws ServerCdnErrorResponseException{
		Preconditions.checkNotNull(domainId, "parameter `domainId` should not be null");
		return get(Referer.class, uri("/domains/%s/referer",domainId)).execute(this.buildExecutionOptions(Referer.class));
	}
	
	/**
	 * Configuring a Cache Rule
	 * @param domainId
	 * @param cacheConfig
	 * @return
	 * @throws ServerCdnErrorResponseException
	 */
	public CacheConfig setCacheConfig(String domainId, CacheConfig cacheConfig) throws ServerCdnErrorResponseException{
		Preconditions.checkNotNull(domainId, "parameter `domainId` should not be null");
		Preconditions.checkNotNull(cacheConfig, "parameter `cacheConfig` should not be null");
		return put(CacheConfig.class, uri("/domains/%s/cache",domainId)).entity(cacheConfig).execute(this.buildExecutionOptions(CacheConfig.class));
	}
	
	/**
	 * Querying a Cache Rule
	 * @param domainId
	 * @return
	 * @throws ServerCdnErrorResponseException
	 */
	public CacheConfig getCacheConfig(String domainId) throws ServerCdnErrorResponseException{
		Preconditions.checkNotNull(domainId, "parameter `domainId` should not be null");
		return get(CacheConfig.class, uri("/domains/%s/cache",domainId)).execute(this.buildExecutionOptions(CacheConfig.class));
	}
	
	/**
	 * Configuring HTTPS
	 * @param domainId
	 * @param httpsInfo
	 * @return
	 * @throws ServerCdnErrorResponseException
	 */
	public HttpsInfo setHttpsInfo(String domainId, HttpsInfo httpsInfo) throws ServerCdnErrorResponseException{
		Preconditions.checkNotNull(domainId, "parameter `domainId` should not be null");
		Preconditions.checkNotNull(httpsInfo, "parameter `httpsInfo` should not be null");
		Preconditions.checkNotNull(httpsInfo.getCertName(), "parameter `cert_name` should not be null");
		Preconditions.checkNotNull(httpsInfo.getHttpsStatus(), "parameter `https_status` should not be null");
		return put(HttpsInfo.class, uri("/domains/%s/https-info",domainId)).entity(httpsInfo).execute(this.buildExecutionOptions(HttpsInfo.class));
	}
	
	/**
	 * Querying HTTPS Configurations
	 * @param domainId
	 * @return
	 * @throws ServerCdnErrorResponseException
	 */
	public HttpsInfo getHttpsInfo(String domainId) throws ServerCdnErrorResponseException{
		Preconditions.checkNotNull(domainId, "parameter `domainId` should not be null");
		return get(HttpsInfo.class, uri("/domains/%s/https-info",domainId)).execute(this.buildExecutionOptions(HttpsInfo.class));
	}
	
	/**
	 * Creating a Cache Refreshing Task
	 * @param creation
	 * @return
	 * @throws ServerCdnErrorResponseException
	 */
	public RefreshTask createRefreshTask(RefreshTaskCreate creation) throws ServerCdnErrorResponseException{
		Preconditions.checkNotNull(creation, "parameter `creation` should not be null");
		Preconditions.checkNotNull(creation.getUrls(), "parameter `urls` should not be null");
		return post(RefreshTask.class, uri("/refreshtasks")).entity(creation).execute(this.buildExecutionOptions(RefreshTask.class));
	}
	
	/**
	 * Creating a Preheating Task
	 * @param creation
	 * @return
	 * @throws ServerCdnErrorResponseException
	 */
	public PreheatingTask createPreheatingTask(PreheatingTaskCreate creation) throws ServerCdnErrorResponseException{
		Preconditions.checkNotNull(creation, "parameter `creation` should not be null");
		Preconditions.checkNotNull(creation.getUrls(), "parameter `urls` should not be null");
		return post(PreheatingTask.class, uri("/preheatingtasks")).entity(creation).execute(this.buildExecutionOptions(PreheatingTask.class));
	}
	
	/**
	 * Querying a Cache Refreshing or Preheating Task
	 * @param params
	 * @return
	 * @throws ServerCdnErrorResponseException
	 */
	public Tasks queryTasks(Map<String, String> params) throws ServerCdnErrorResponseException{
		Preconditions.checkNotNull(params.get("page_size"), "parameter `page_size` should not be null");
		Preconditions.checkNotNull(params.get("page_number"), "parameter `page_number` should not be null");
		Invocation<Tasks> taskInvocation = get(Tasks.class, uri("/historytasks"));
		if (params != null) {
            for (Map.Entry<String, String> entry : params.entrySet()) {
            	taskInvocation = taskInvocation.param(entry.getKey(), entry.getValue());
            }
        }
		return taskInvocation.execute(this.buildExecutionOptions(Tasks.class));
	}
	
	/**
	 * Querying Details About a Cache Refreshing or Preheating Task
	 * @param taskId
	 * @return
	 * @throws ServerCdnErrorResponseException
	 */
	public TaskDetail getTaskDetail(String taskId, int pageSize, int pageNumber) throws ServerCdnErrorResponseException{
		Preconditions.checkNotNull(taskId, "parameter `taskId` should not be null");
		Preconditions.checkNotNull(pageSize, "parameter `pageSize` should not be null");
		Preconditions.checkNotNull(pageNumber, "parameter `pageNumber` should not be null");
		Invocation<TaskDetail> taskDetailInvocation = get(TaskDetail.class, uri("/historytasks/%s/detail",taskId)).param("page_size", pageSize).param("page_number", pageNumber);
		return taskDetailInvocation.execute(this.buildExecutionOptions(TaskDetail.class));
	}
	
}
