package org.skalka.groupme4j.groupme4j;

import org.junit.Assert;
import org.junit.Test;
import org.skalka.groupme4j.GroupMe4J;
import org.skalka.groupme4j.exception.GroupMeAPIException;
import org.skalka.groupme4j.response.group.Group;

import com.mashape.unirest.http.Unirest;
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
		/*GroupMe4J groupme = new GroupMe4J("");
		Group g = groupme.createGroup("TESTER GROUP");
		
		Assert.assertNotNull(g);
		System.out.println(g.getGroupId());*/
	}
	
	@Test
	public void test() throws UnirestException {
		String json = Unirest.put("https://api.groupme.com/v3/groups")
				.header("Content-Type", "application/json;charset=UTF-8")
				.header("accept", "application/json")
				.header("X-Access-Token", "")
//				.("name", "TESTGROUP")
				.body("{\"name\":\"TESTERGROUP\"}")
				.asString().getBody();
		
		System.out.println(json);
	}
}
