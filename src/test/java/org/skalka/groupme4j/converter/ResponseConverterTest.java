package org.skalka.groupme4j.converter;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Collectors;

import org.junit.Assert;
import org.junit.Test;
import org.skalka.groupme4j.model.group.Group;
import org.skalka.groupme4j.response.GroupMeResponse;

public class ResponseConverterTest {

    @Test
    public void testMultipleEntryConverter_GetGroups() throws IOException {
        String json = readFile("./src/test/resources/responses/get-groups-response.txt");

        ResponseConverter<GroupMeResponse<Group[]>> converter
                    = new GroupMeResponseConverter<Group[]>(Group[].class);
        GroupMeResponse<Group[]> response = converter.parse(json);

        Assert.assertNotNull(response);
        Assert.assertNotEquals(response.getResponse().length, 0);
        Assert.assertEquals(response.getMetadata().getCode(), 200);
    }

    @Test
    public void testMultipleEntryConverter_GetFormerGroups() throws IOException {
        String json = readFile("./src/test/resources/responses/get-former-groups-response.txt");

        ResponseConverter<GroupMeResponse<Group[]>> converter
                    = new GroupMeResponseConverter<Group[]>(Group[].class);
        GroupMeResponse<Group[]> response = converter.parse(json);

        Assert.assertNotNull(response);
        Assert.assertNotEquals(response.getResponse().length, 0);
        Assert.assertEquals(response.getMetadata().getCode(), 200);
    }

    //@Test
    public void testSingleEntryConverter_GetGroupById() throws IOException {
        String json = readFile("./src/test/resources/responses/get-group-by-id-response.txt");

        ResponseConverter<GroupMeResponse<Group>> converter
                    = new GroupMeResponseConverter<Group>(Group.class);
        GroupMeResponse<Group> response = converter.parse(json);

        Assert.assertNotNull(response);
        Assert.assertNotNull(response.getResponse());
        Assert.assertEquals(response.getMetadata().getCode(), 200);
    }
    
    private String readFile(String path) throws IOException {
        Path p = (new File("./src/test/resources/responses/get-groups-response.txt")).toPath();
        return Files.readAllLines(p).stream().map(n -> n).collect(Collectors.joining(""));
    }
}
