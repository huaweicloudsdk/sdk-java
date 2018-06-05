package com.huawei.openstack4j.api.evs.v2_1;

import static org.testng.Assert.assertEquals;
import okhttp3.mockwebserver.RecordedRequest;

import org.testng.annotations.Test;

import com.huawei.openstack4j.api.AbstractTest;
import com.huawei.openstack4j.openstack.common.AsyncRespEntity;
import com.huawei.openstack4j.openstack.ecs.v1.contants.VolumeType;
import com.huawei.openstack4j.openstack.evs.v2.contants.ChargingType;
import com.huawei.openstack4j.openstack.evs.v2.domain.CloudVolumes;
import com.huawei.openstack4j.openstack.evs.v2.domain.Metadata;
import com.huawei.openstack4j.openstack.evs.v2_1.contants.PeriodType;
import com.huawei.openstack4j.openstack.evs.v2_1.domain.BssParam;
import com.huawei.openstack4j.openstack.evs.v2_1.domain.Extend;
import com.huawei.openstack4j.openstack.evs.v2_1.domain.OSExtend;
import com.huawei.openstack4j.openstack.evs.v2_1.domain.Volumes;

@Test(suiteName = "EVS/Volumes")
public class VolumeTests extends AbstractTest{

	@Override
	protected Service service() {
		return Service.EVS2_1;
	}

	@Test
	public void createVolumeTest() throws Exception {
		respondWith(200, "{\"order_id\": \"this-is-a-order-id\"}");
		
		Metadata buildMetadata = Metadata.builder().systemEncrypted("0").hwPassthrough(true).build();
		CloudVolumes vo = CloudVolumes.builder().name("name").volumeType(VolumeType.SAS).metadata(buildMetadata)
				.size(120).availabilityZone("az").multiattach(true).count(1).build();
		BssParam bssParam = BssParam.builder().chargingMode(ChargingType.prePaid).periodType(PeriodType.year).periodNum(1).isAutoPay(true).isAutoRenew(true).build();
		Volumes volumes = Volumes.builder().cloudVolumes(vo).bssParam(bssParam).build();
		AsyncRespEntity espEntity =osv3().evsV2_1().volumes().create(volumes);
		RecordedRequest request = server.takeRequest();
		assertEquals(request.getPath(), "/v2.1/project-id/cloudvolumes");
		assertEquals(request.getMethod(), "POST");
		assertEquals(espEntity.getJobId(), "this-is-a-order-id");
	}
	
	@Test
	public void extendVolumeTest() throws InterruptedException{
		respondWith(200, "{\"order_id\": \"this-is-a-order-id\"}");
		
		Extend extend = Extend.builder().osExtend(OSExtend.builder().newSize(20).build()).build();
		
		AsyncRespEntity espEntity = osv3().evsV2_1().volumes().extend(extend,"volimeid");
		
		RecordedRequest request = server.takeRequest();
		assertEquals(request.getPath(), "/v2.1/project-id/cloudvolumes/volimeid/action");
		assertEquals(request.getMethod(), "POST");
		assertEquals(espEntity.getJobId(), "this-is-a-order-id");
	}
}
