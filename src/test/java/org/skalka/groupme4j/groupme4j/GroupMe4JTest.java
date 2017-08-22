package org.skalka.groupme4j.groupme4j;

import org.junit.Assert;
import org.junit.Test;
import org.skalka.groupme4j.GroupMe4J;
import org.skalka.groupme4j.exception.GroupMeAPIException;
import org.skalka.groupme4j.response.group.Group;

import com.mashape.unirest.http.exceptions.UnirestException;

public class GroupMe4JTest {
	@Test
	public void testGroups() throws GroupMeAPIException {
		/*GroupMe4J groupme = new GroupMe4J("");
		Assert.assertEquals(groupme.getGroupById("30998975").getMetadata().getCode(), 200);*/
	}
	
	@Test
	public void testFormerGroups() throws GroupMeAPIException {
		/*GroupMe4J groupme = new GroupMe4J("");
		Assert.assertEquals(groupme.getGroupById("30998975").getMetadata().getCode(), 200);*/
	}
	
	@Test
	public void testGroupById() throws GroupMeAPIException {
		/*GroupMe4J groupme = new GroupMe4J("");
		Assert.assertEquals(groupme.getGroupById("30998975").getMetadata().getCode(), 200);*/
	}
	
	@Test
	public void testCreateGroup() throws GroupMeAPIException {
		GroupMe4J groupme = new GroupMe4J("");
		Group g_created = groupme.createGroup("TESTER GROUP");
		Group g_deleted = groupme.destoryGroup(g_created.getId());
		
		Assert.assertNotNull(g_created);
		System.out.println(g_created.getGroupId());
	}
	
	@Test
	public void test() throws UnirestException {

	}
}
