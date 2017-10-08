package org.skalka.groupme4j;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Collectors;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.skalka.groupme4j.model.group.Group;
import org.skalka.groupme4j.model.message.Message;

public class GroupMe4jMessagesTest {

    GroupMe4JClient groupme;

    @Before
    public void setup() throws IOException {
        groupme = new GroupMe4JClient(retrieveToken());
    }

    @Test
    public void testPostMessage_Text() throws Exception {
        boolean failed = false;

        Group createdGroup = groupme.createGroup("TESTER GROUP");
        Assert.assertNotNull(createdGroup);
        Assert.assertNotNull(createdGroup.getGroupId());

        try {
            Message message = groupme.postMessage(createdGroup.getGroupId(), "Hello World");
            Assert.assertNotNull(message);
            Assert.assertNotNull(message.getText());
            Assert.assertEquals("Hello World", message.getText());
        } catch (Exception E) {
            System.out.println(E.getMessage());
            failed = true;
        } finally {
            boolean deleted = groupme.destoryGroup(createdGroup.getGroupId());
            Assert.assertTrue(deleted);
        }

        if (failed) {
            Assert.fail();
        }
    }

    private String retrieveToken() throws IOException {
        Path p = (new File("./access.token")).toPath();
        return Files.readAllLines(p).stream().map(n -> n.toString()).collect(Collectors.joining(""));
    }
}
