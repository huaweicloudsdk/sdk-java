package com.huawei.openstack4j.api.scaling;

import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.util.List;

import org.testng.annotations.Test;

import com.huawei.openstack4j.api.AbstractTest;
import com.huawei.openstack4j.model.common.ActionResponse;
import com.huawei.openstack4j.openstack.scaling.domain.ASAutoScalingDefaultResult;
import com.huawei.openstack4j.openstack.scaling.domain.ASAutoScalingLifecycleHook;
import com.huawei.openstack4j.openstack.scaling.domain.ASAutoScalingLifecycleHookType;
import com.huawei.openstack4j.openstack.scaling.domain.ASAutoScalingLifecycleInstanceCallback;
import com.huawei.openstack4j.openstack.scaling.domain.AutoScalingInstanceHangupInfo;

@Test(suiteName = "AutoScaling/AutoScalingLifecycleHookServiceV1", enabled = true)
public class AutoScalingLifecycleHookServiceV1Tests extends AbstractTest{
//	private static final String JSON_SCALING_LIFECYCLEHOOK_CREATE = "/scaling/as_scaling_lifecyclehook_create.json";
	private static final String JSON_SCALING_LIFECYCLEHOOK_LIST1 = "/scaling/as_scaling_lifecyclehook_list1.json";
	private static final String JSON_SCALING_LIFECYCLEHOOK_LIST2 = "/scaling/as_scaling_lifecyclehook_list2.json";
	private static final String JSON_SCALING_LIFECYCLEHOOK_MODIFY = "/scaling/as_scaling_lifecyclehook_modify.json";
	private static final String JSON_SCALING_INSTANCEHANGUP_LIST = "/scaling/as_scaling_instanceHangup_list.json";
	
//	public void testCreateLifecyclehook() throws IOException{
//		respondWith(JSON_SCALING_LIFECYCLEHOOK_CREATE);
//		String groupId = "70376a9b-2454-4483-bac8-8999dabe6929";
//		ASAutoScalingLifecycleHook lifecycleHook1 = ASAutoScalingLifecycleHook.builder().lifecycleHookName("test-hook2").lifecycleHookType(ASAutoScalingLifecycleHookType.INSTANCE_LAUNCHING).defaultResult(ASAutoScalingDefaultResult.ABANDON).build();
//		ASAutoScalingLifecycleHook lifecycleHook2 = osv3().autoScaling().lifecycleHook().create(lifecycleHook1,groupId);
//	}

	@Test
	public void testListLifecycleHookDetail() throws IOException{
		respondWith(JSON_SCALING_LIFECYCLEHOOK_LIST2);
		String groupId = "70376a9b-2454-4483-bac8-8999dabe6929";
		ASAutoScalingLifecycleHook lifecycleHook = osv3().autoScaling().lifecycleHook().list(groupId, "test-kakaka1");
		assertTrue(lifecycleHook != null);
	}
	
	@Test
	public void testListLifecycleHook() throws IOException{
		respondWith(JSON_SCALING_LIFECYCLEHOOK_LIST1);
		String groupId = "70376a9b-2454-4483-bac8-8999dabe6929";
		List<? extends ASAutoScalingLifecycleHook> lifecycleHookList = osv3().autoScaling().lifecycleHook().list(groupId);
		assertTrue(lifecycleHookList != null && lifecycleHookList.size() == 2);
	}
	
	@Test
	public void testInstanceLifecycleHook(){
		respondWith(204);
		String groupId = "70376a9b-2454-4483-bac8-8999dabe6929";
		ASAutoScalingLifecycleInstanceCallback lifecycleInstanceCallback = ASAutoScalingLifecycleInstanceCallback.builder().lifecycleActionKey("test").build();
		ActionResponse ac = osv3().autoScaling().lifecycleHook().scalingInstanceHookCallback(groupId,lifecycleInstanceCallback);
		assertTrue(ac != null);
	}
	
	@Test
	public void testDelete(){
		respondWith(204);
		String groupId = "70376a9b-2454-4483-bac8-8999dabe6929";
		ActionResponse ac = osv3().autoScaling().lifecycleHook().delete(groupId, "test");
		assertTrue(ac != null);
	}
	
	@Test
	public void testModify() throws IOException{
		respondWith(JSON_SCALING_LIFECYCLEHOOK_MODIFY);
		String groupId = "70376a9b-2454-4483-bac8-8999dabe6929";
		ASAutoScalingLifecycleHook lifecycleHook1 = ASAutoScalingLifecycleHook.builder().lifecycleHookType(ASAutoScalingLifecycleHookType.INSTANCE_LAUNCHING).defaultResult(ASAutoScalingDefaultResult.ABANDON).build();
		ASAutoScalingLifecycleHook lifecycleHook2 = osv3().autoScaling().lifecycleHook().update(groupId, "Test", lifecycleHook1);
		assertTrue(lifecycleHook2 != null);
	}
	
	@Test
	public void testListAutoScalingInstanceHangupInfo() throws IOException{
		respondWith(JSON_SCALING_INSTANCEHANGUP_LIST);
		String groupId = "70376a9b-2454-4483-bac8-8999dabe6929";
		List<? extends AutoScalingInstanceHangupInfo> hangupInfoList = osv3().autoScaling().lifecycleHook().scalingInstanceHangup(groupId);		
		assertTrue(hangupInfoList != null );
	}
	
	
	@Override
	protected Service service() {
		return Service.AUTO_SCALING;
	}
	
}
