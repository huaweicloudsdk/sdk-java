package com.huawei.openstack4j.api.vpc.v1;

import static org.testng.Assert.assertNotNull;

import org.testng.annotations.Test;

import com.huawei.openstack4j.api.AbstractTest;
import com.huawei.openstack4j.openstack.vpc.v1.domain.VirtualBandWidths;


@Test(suiteName = "VPC/BandWidth")
public class BandWidthTest extends AbstractTest{
	
	
	private static final String JSON_BANDWIDTH = "/vpc/v1/bandwidth.json";
	
	@Override
	protected Service service() {
		return Service.VPC;
	}
	
	
	public void getBandWidthTest() throws Exception{
		respondWith(JSON_BANDWIDTH);
		VirtualBandWidths resp = osv3().vpc().bandwidths().get("TestId");
		assertNotNull(resp);
	}
	
}
