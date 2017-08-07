/*******************************************************************************
 *  Copyright 2017 Huawei TLD
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
/*******************************************************************************
 *******************************************************************************/
package org.openstack4j.sample.database;

import java.util.List;

import org.openstack4j.openstack.database.constants.DatastoreType;
import org.openstack4j.openstack.database.domain.DatabaseParam;
import org.openstack4j.openstack.database.domain.DatastoreVersion;
import org.openstack4j.sample.AbstractSample;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

@Test(suiteName = "Database/Param/Sample")
public class DatabaseParamSample extends AbstractSample {

	DatastoreVersion datastoreVersion = null;
	List<DatabaseParam> params = null;

	@BeforeClass
	public void prepare() {
		// get the first datastore version of MySQL for test
		List<DatastoreVersion> versions = osclient.database().datastores().listDatastoreVersions(DatastoreType.MySQL);
		datastoreVersion = versions.get(0);
	}

	@Test
	public void testListDatabaseParams() {
		params = osclient.database().params().list(datastoreVersion.getId());
		Assert.assertTrue(params.size() >= 1);
	}

	@Test(dependsOnMethods = { "testListDatabaseParams" })
	public void testGetDatabaseParam() {
		DatabaseParam databaseParam = params.get(0);
		DatabaseParam get = osclient.database().params().get(datastoreVersion.getId(), databaseParam.getName());
		Assert.assertEquals(get.getDatastoreVersionId(), databaseParam.getDatastoreVersionId());
		Assert.assertEquals(get.getDescription(), databaseParam.getDescription());
		Assert.assertEquals(get.getName(), databaseParam.getName());
		Assert.assertEquals(get.getValueRange(), databaseParam.getValueRange());
		Assert.assertEquals(get.getMax(), databaseParam.getMax());
		Assert.assertEquals(get.getMin(), databaseParam.getMin());
		Assert.assertEquals(get.getRestartRequired(), databaseParam.getRestartRequired());
		Assert.assertEquals(get.getType(), databaseParam.getType());
	}

}
