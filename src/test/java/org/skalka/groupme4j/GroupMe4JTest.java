package org.skalka.groupme4j;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Collectors;

import org.junit.Assert;
import org.junit.Test;
import org.skalka.groupme4j.exception.GroupMeAPIException;
import org.skalka.groupme4j.response.group.Group;

public class GroupMe4JTest {
	@Test
	public void testGroupById() throws GroupMeAPIException {
		/*GroupMe4J groupme = new GroupMe4J("");
		Assert.assertEquals(groupme.getGroupById("30998975").getMetadata().getCode(), 200);*/
	}
	
	@Test
	public void testCreateGroup() throws Exception {
		GroupMe4J groupme = new GroupMe4J(retrieveToken());
		Group g_created = groupme.createGroup("TESTER GROUP");
		boolean deleted = groupme.destoryGroup(g_created.getId());
		
		Assert.assertNotNull(g_created);
		Assert.assertTrue(deleted);
	}
	
	private String retrieveToken() throws IOException {
		Path p = (new File("./access.token")).toPath();
		return Files.readAllLines(p).stream().map(n -> n.toString()).collect(Collectors.joining(""));
	}
}
