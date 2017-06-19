/*******************************************************************************
 * 	Copyright 2017 HuaWei Tld                                     
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
package org.openstack4j.openstack.scaling.internal;

import static com.google.common.base.Preconditions.checkArgument;

import java.util.List;

import com.google.common.base.Strings;
import org.openstack4j.api.scaling.AutoScalingQuotaService;
import org.openstack4j.model.scaling.ScalingQuota;
import org.openstack4j.openstack.scaling.domain.ASAutoScalingQuota.ASAutoScalingQuotas;

public class AutoScalingQuotaServiceImpl extends BaseAutoScalingServices implements AutoScalingQuotaService {

	@Override
	public List<? extends ScalingQuota> list() {
		return get(ASAutoScalingQuotas.class, uri("/quotas")).execute().getList();
	}

	@Override
	public List<? extends ScalingQuota> list(String groupId) {
		checkArgument(!Strings.isNullOrEmpty(groupId), "groupId required");
		return get(ASAutoScalingQuotas.class, uri("/quotas/%s", groupId)).execute().getList();
	}
}
