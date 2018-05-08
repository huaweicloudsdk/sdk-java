package com.huawei.openstack.sample;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.huawei.openstack4j.api.OSClient.OSClientV3;
import com.huawei.openstack4j.api.types.ServiceType;
import com.huawei.openstack4j.core.transport.Config;
import com.huawei.openstack4j.model.common.Identifier;
import com.huawei.openstack4j.model.compute.Flavor;
import com.huawei.openstack4j.model.dns.v2.Zone;
import com.huawei.openstack4j.openstack.OSFactory;
import com.huawei.openstack4j.openstack.cdn.v1.domain.DomainCreate;
import com.huawei.openstack4j.openstack.cdn.v1.domain.Source;
import com.huawei.openstack4j.openstack.cdn.v1.domain.Source.Origin;
import com.huawei.openstack4j.openstack.common.ServiceVersion;
import com.huawei.openstack4j.openstack.identity.internal.OverridableEndpointURLResolver;

/**
 * demo for huawei cdn sdk
 * @author ChangjunZhao
 * @date   2018-05-08 20:16:45
 */
public class HuaweiCdnSdkSample {

	private static final String LANGUAGE = "zh-cn";

	public static void main(String[] args) {

		                                                                                                 
		// step 1: add cloud service override endpoint
		OverridableEndpointURLResolver endpointResolver = new OverridableEndpointURLResolver();
		// "example" in the endpoint stands for "Region.Cloud"
		//endpointResolver.addOverrideEndpoint(ServiceType.DNS, "https://dns.example.com");
		
		// ========================================================================================== // 
		// those services's endpoint will be auto detected from V3 authentication token               // 
		//                                                                                            // 
		//       Nova         ->   ECS                                                                // 
		//       Cinder       ->   EVS                                                                // 
		//       Neutron      ->   VPC                                                                // 
		//       Keystone     ->   IAM                                                                // 
		//       Glance       ->   IMS                                                                // 
		//       Heat         ->   RTS                                                                // 
		//                                                                                            // 
		// so, we do not need to setup the endpoint override for them.                                // 
		// ========================================================================================== // 

		// endpoint override for the other service
		endpointResolver.addOverrideEndpoint(ServiceType.CDN, "https://cdn.myhwclouds.com");
		// step 2: setup the authentication credit
		String user = "replace-with-your-username";
		String password = "replace-with-your-password";
		String projectId = "replace-with-your-project-id";
		String userDomainId = "replace-with-your-user-domain-id";
		// "example" in the endpoint stands for "Region.Cloud"
		String authUrl = "https://iam.example.com/v3";

		// step 3: initial OpenStack4j Client
		OSFactory.enableHttpLoggingFilter(true);
		// config of the client
		// with language setting is required for RDS(trove&database) service
		// withSSLVerificationDisabled is required if the SSL certification of the cloud service is illegal
		Config config = Config.newConfig().withEndpointURLResolver(endpointResolver).withLanguage(LANGUAGE)
				.withSSLVerificationDisabled();

		// initial client
		OSClientV3 osclient = OSFactory.builderV3().withConfig(config).endpoint(authUrl)
				.credentials(user, password, Identifier.byId(userDomainId)).scopeToDomain(Identifier.byId(userDomainId))
				.scopeToProject(Identifier.byId(projectId)).authenticate();
		
		// step 4: use sdk
		Source source = Source.builder().activeStandby(1).ipOrDomain("1.2.3.4").originType("ipaddr").build();
		List<Source> sources = new ArrayList<Source>();
		sources.add(source);
		DomainCreate creation = DomainCreate.builder().businessType("web").domainName("cdn-9b236.cn-north-1.myhwclouds.com").sources(sources).build();
		// create
		System.out.println(osclient.cdn().domains().create(creation));
		
		// list domains
		Map<String,String> params = new HashMap<String,String>();
		params.put("page_size", "10");
		params.put("page_number", "1");
		System.out.println(osclient.cdn().domains().list(params));
		
	}

}
