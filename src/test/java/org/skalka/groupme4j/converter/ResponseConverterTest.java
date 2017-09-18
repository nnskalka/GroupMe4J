package org.skalka.groupme4j.converter;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.Assert;
import org.junit.Test;
import org.skalka.groupme4j.model.group.Group;
import org.skalka.groupme4j.response.RestfulResponse;

public class ResponseConverterTest {
	@Test
	public void testMultipleEntryConverter_GetGroups() throws IOException {
		Path p = (new File("./src/test/resources/responses/get-groups-response.txt")).toPath();
		String json = Files.readAllLines(p).stream().map(n -> n.toString()).collect(Collectors.joining(""));

		MultipleEntryResponseConverter<Group> mec = new MultipleEntryResponseConverter<Group>(Group.class);
		RestfulResponse<List<Group>> response = mec.parse(json);
		
		Assert.assertNotNull(response);
		Assert.assertNotEquals(response.getResponse().size(), 0);
		Assert.assertEquals(response.getMetadata().getCode(), 200);
	}
	
	@Test
	public void testMultipleEntryConverter_GetFormerGroups() throws IOException {
		Path p = (new File("./src/test/resources/responses/get-former-groups-response.txt")).toPath();
		String json = Files.readAllLines(p).stream().map(n -> n.toString()).collect(Collectors.joining(""));
		
		MultipleEntryResponseConverter<Group> mec = new MultipleEntryResponseConverter<Group>(Group.class);
		RestfulResponse<List<Group>> response = mec.parse(json);
		
		Assert.assertNotNull(response);
		Assert.assertNotEquals(response.getResponse().size(), 0);
		Assert.assertEquals(response.getMetadata().getCode(), 200);
	}
	
	@Test
	public void testSingleEntryConverter_GetGroupById() throws IOException {
		Path p = (new File("./src/test/resources/responses/get-group-by-id-response.txt")).toPath();
		String json = Files.readAllLines(p).stream().map(n -> n.toString()).collect(Collectors.joining(""));
		
		SingleEntryResponseConverter<Group> sec = new SingleEntryResponseConverter<Group>(Group.class);
		RestfulResponse<Group> response = sec.parse(json);
		
		Assert.assertNotNull(response);
		Assert.assertNotNull(response.getResponse());
		Assert.assertEquals(response.getMetadata().getCode(), 200);
	}
}
