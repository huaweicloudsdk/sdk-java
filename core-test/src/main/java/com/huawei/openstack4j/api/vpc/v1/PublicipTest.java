package com.huawei.openstack4j.api.vpc.v1;

import static org.testng.Assert.assertNotNull;

import org.testng.annotations.Test;

import com.huawei.openstack4j.api.AbstractTest;
import com.huawei.openstack4j.openstack.vpc.v1.domain.VirtualPublicIp;

@Test(suiteName = "VPC/Publicip")
public class PublicipTest  extends AbstractTest{

	private static final String JSON_PUBLICIP = "/vpc/v1/publicip.json";
	@Override
	protected Service service() {
		return Service.VPC;
	}
	
	
	public void getPublicIpTest() throws Exception{
		respondWith(JSON_PUBLICIP);
		VirtualPublicIp resp = osv3().vpc().publicips().get("TestId");
		assertNotNull(resp);
	}

	
}
