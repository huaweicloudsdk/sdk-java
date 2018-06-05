/*******************************************************************************
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
package com.huawei.openstack4j.openstack.identity.internal;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.type.TypeFactory;
import com.huawei.openstack4j.api.ServiceEndpointProvider;
import com.huawei.openstack4j.api.types.Facing;
import com.huawei.openstack4j.api.types.ServiceType;
import com.huawei.openstack4j.core.transport.ObjectMapperSingleton;
import com.huawei.openstack4j.model.identity.URLResolverParams;

/**
 * Resolves an Endpoint URL based on the Service Type and Facing perspective
 *
 * @author Jeremy Unruh
 */
public class AKSKEndpointURLResolver extends AbstractEndpointURLResolver {

	static String defaultServiceEndpointFile = "service_endpoint.json";

	
	 ServiceEndpointProvider endpointProvider;
	
	
	/**
	 * default implementation 
	 * 
	 * @return
	 */
	public static AKSKEndpointURLResolver instance() {
		InputStream is = AKSKEndpointURLResolver.class.getClassLoader().getResourceAsStream(defaultServiceEndpointFile);
		ServiceEndpointProvider defaultEndpointProvider = new LocalFileServiceEndpointProvider(is);
		return new AKSKEndpointURLResolver().withEndpointProvider(defaultEndpointProvider);
	}

	/*
	 * {@inheritDoc}
	 */
	@Override
	public String resolve(URLResolverParams p) {
		String endpoint = this.getEndpointProvider().getEndpoint(p.type, p.perspective);
		// filter placeholder parameters
		endpoint = endpoint.replace("%(domain)s", p.domain);
		endpoint = endpoint.replace("%(region)s", p.region);
		endpoint = endpoint.replace("%(projectId)s", p.projectId);
		return endpoint;
	}
	

	public ServiceEndpointProvider getEndpointProvider() {
		return endpointProvider;
	}

	public AKSKEndpointURLResolver withEndpointProvider(ServiceEndpointProvider endpointProvider) {
		this.endpointProvider = endpointProvider;
		return this;
	}



	/**
	 * Fetch all endpoint from local file storage
	 *
	 * @author QianBiao.NG
	 * @date   2018-03-13 11:52:24
	 */
	public static class LocalFileServiceEndpointProvider implements ServiceEndpointProvider {

		private HashMap<ServiceType, ServiceEndpoint> serviceEndpoints;

		public LocalFileServiceEndpointProvider(InputStream inputStream) {
			JavaType typeRef = TypeFactory.defaultInstance().constructMapType(HashMap.class, ServiceType.class,
					ServiceEndpoint.class);
			try {
				this.serviceEndpoints = ObjectMapperSingleton.getContext(ServiceEndpoint.class)
						.readValue(inputStream, typeRef);
			} catch (Exception e) {
				throw new RuntimeException("Could not parse service endpoint from input-stream", e);
			} finally {
				try {
					inputStream.close();
				} catch (IOException e) {
				}
			}
		}

		/*
		 * {@inheritDoc}
		 */
		@Override
		public String getEndpoint(ServiceType service) {
			return this.getEndpoint(service, Facing.PUBLIC);
		}

		/*
		 * {@inheritDoc}
		 */
		@Override
		public String getEndpoint(ServiceType serviceType, Facing perspective) {
			return serviceEndpoints.get(serviceType).getEndpointFor(perspective);
		}

	}



	@Override
	public String findURLV2(URLResolverParams params) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String findURLV3(URLResolverParams params) {
		// TODO Auto-generated method stub
		return null;
	}

}