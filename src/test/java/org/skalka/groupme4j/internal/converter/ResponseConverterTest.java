package org.skalka.groupme4j.internal.converter;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Collectors;

import org.junit.Assert;
import org.junit.Test;
import org.skalka.groupme4j.model.group.Group;
import org.skalka.groupme4j.internal.response.GroupMeResponse;

public class ResponseConverterTest {

    @Test
    public void testMultipleEntryConverter_GetGroups() throws IOException {
        String json = readFile("./src/test/resources/responses/get-groups-response.txt");

        ResponseConverter<Group[]> converter
                    = new ResponseConverter<Group[]>(Group[].class);
        GroupMeResponse<Group[]> response = converter.parse(json);

        Assert.assertNotNull(response);
        Assert.assertNotEquals(0, response.getResponse().length);
        Assert.assertEquals(200, response.getMetadata().getCode());
    }

    @Test
    public void testMultipleEntryConverter_GetFormerGroups() throws IOException {
        String json = readFile("./src/test/resources/responses/get-former-groups-response.txt");

        ResponseConverter<Group[]> converter
                    = new ResponseConverter<Group[]>(Group[].class);
        GroupMeResponse<Group[]> response = converter.parse(json);

        Assert.assertNotNull(response);
        Assert.assertNotEquals(0, response.getResponse().length);
        Assert.assertEquals(200, response.getMetadata().getCode());
    }

    //@Test
    public void testSingleEntryConverter_GetGroupById() throws IOException {
        String json = readFile("./src/test/resources/responses/get-group-by-id-response.txt");

        ResponseConverter<Group> converter
                    = new ResponseConverter<Group>(Group.class);
        GroupMeResponse<Group> response = converter.parse(json);

        Assert.assertNotNull(response);
        Assert.assertNotNull(response.getResponse());
        Assert.assertEquals(200, response.getMetadata().getCode());
    }
    
    private String readFile(String path) throws IOException {
        Path p = (new File("./src/test/resources/responses/get-groups-response.txt")).toPath();
        return Files.readAllLines(p).stream().map(n -> n).collect(Collectors.joining(""));
    }
}
