package com.huawei.openstack4j.openstack.internal;

import java.net.URI;
import java.net.URISyntaxException;

import org.slf4j.LoggerFactory;

import com.huawei.openstack4j.api.Apis;
import com.huawei.openstack4j.api.OSClient.OSClientAKSK;
import com.huawei.openstack4j.api.client.CloudProvider;
import com.huawei.openstack4j.api.exceptions.RegionEndpointNotFoundException;
import com.huawei.openstack4j.api.identity.EndpointURLResolver;
import com.huawei.openstack4j.api.identity.v3.IdentityService;
import com.huawei.openstack4j.api.types.ServiceType;
import com.huawei.openstack4j.model.identity.AuthVersion;
import com.huawei.openstack4j.model.identity.URLResolverParams;
import com.huawei.openstack4j.openstack.identity.internal.AKSKEndpointURLResolver;

public class OSClientSessionAKSK extends OSClientSession<OSClientSessionAKSK, OSClientAKSK> implements OSClientAKSK {

	private String accessKey;
	private String secretKey;
	private String serviceDomain;
	private String projectId;

	CloudProvider provider = CloudProvider.HUAWEI;

	protected EndpointURLResolver defaultEndpointURLResolver = AKSKEndpointURLResolver.instance();

	/*
	 * {@inheritDoc}
	 */
	@Override
	public String getEndpoint() {
		throw new RuntimeException("Token is not required by AKSK-authentication");
	}

	/*
	 * {@inheritDoc}
	 */
	@Override
	public String getEndpoint(ServiceType service) {
		/*final EndpointURLResolver endpointResolver = (config != null && config.getEndpointURLResolver() != null)
				? config.getEndpointURLResolver() : defaultEndpointURLResolver;		*/
		URLResolverParams params = URLResolverParams.create(service).perspective(perspective).region(region)
				.domain(serviceDomain).projectId(projectId);
		//如果有重写就先去重写匹配，重写匹配不到就去配置文件匹配
		String url = null;
		try{
			if(config != null && config.getEndpointURLResolver() != null){
				url = config.getEndpointURLResolver().resolve(params);
				if(url == null){
					url = defaultEndpointURLResolver.resolve(params);
				}
			}else{
				url = defaultEndpointURLResolver.resolve(params);
			}
		}catch(NullPointerException e){
			throw new RegionEndpointNotFoundException("region endpoint can not be found");
		}
		return addNATIfApplicable(url);
	}

	private String addNATIfApplicable(String url) {
		if (config != null && config.isBehindNAT()) {
			try {
				URI uri = new URI(url);
				return url.replace(uri.getHost(), config.getEndpointNATResolution());
			} catch (URISyntaxException e) {
				LoggerFactory.getLogger(OSClientSessionAKSK.class).error(e.getMessage(), e);
			}
		}
		return url;
	}

	/*
	 * {@inheritDoc}
	 */
	@Override
	public String getTokenId() {
		return null;
	}
	
	public AuthVersion getAuthVersion() {
		return AuthVersion.AKSK;
	}
	
	/* 
	 * {@inheritDoc}
	 */
	@Override
	public boolean supportsReAuthentication() {
		return false;
	}

	/*
	 * {@inheritDoc}
	 */
	@Override
	public com.huawei.openstack4j.api.OSClient.OSClientAKSK credentials(String accessKey, String secretKey, String region,
			String projectId, String serviceDomain) {
		this.accessKey = accessKey;
		this.secretKey = secretKey;
		this.serviceDomain = serviceDomain;
		this.projectId = projectId;
		this.useRegion(region);
		sessions.set(this);
		return this;
	}

	public String getAccessKey() {
		return accessKey;
	}

	public String getSecretKey() {
		return secretKey;
	}

	public String getServiceDomain() {
		return serviceDomain;
	}

	public String getProjectId() {
		return projectId;
	}
	
	
	public String getRegion() {
		return region;
	}

	@Override
	public IdentityService identity() {
		return Apis.getIdentityV3Services();
	}

}
