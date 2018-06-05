package com.huawei.openstack4j.api.vpc.v2;

import static org.testng.Assert.assertEquals;
import okhttp3.mockwebserver.RecordedRequest;

import org.testng.annotations.Test;

import com.huawei.openstack4j.api.AbstractTest;
import com.huawei.openstack4j.openstack.vpc.v2.domain.AsyncBandWidthRespEntity;
import com.huawei.openstack4j.openstack.vpc.v2.domain.VirtualBandWidthUpdate;
import com.huawei.openstack4j.openstack.vpc.v2.domain.VirtualBandWidths;
import com.huawei.openstack4j.openstack.vpc.v2.domain.VirtualExtendParamUpdate;

@Test(suiteName = "VPC/BandWidth")
public class BandWidthTest extends AbstractTest{
	
	@Override
	protected Service service() {
		return Service.VPC2;
	}
	
	public void updateTest() throws InterruptedException{
		respondWith(200, "{\"order_id\": \"this-is-a-order-id\"}");
		
		
		String bdId = "BandWidthTestId";
		VirtualBandWidths build = VirtualBandWidths.builder()
				.bandwidth(VirtualBandWidthUpdate.builder().size(20).name("bandwidth123").build())
				.extendParam(VirtualExtendParamUpdate.builder().isAutoPay(false).build()).build();
		AsyncBandWidthRespEntity respEntity =  osv3().vpcV2().bandwidths().update(build, bdId);
		
		RecordedRequest request = server.takeRequest();
		assertEquals(request.getPath(), "/v2.0/project-id/bandwidths/BandWidthTestId");
		assertEquals(request.getMethod(), "PUT");
		assertEquals(respEntity.getOrderId(), "this-is-a-order-id");
	}
	
	
}
