package org.skalka.groupme4j;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.Assert;
import org.junit.Test;
import org.skalka.groupme4j.model.group.Group;

public class GroupMe4JTest {

    @Test
    public void testGroups() throws Exception {
        GroupMe4J groupme = new GroupMe4J(retrieveToken());
        List<Group> groups = groupme.getGroups(1, 10);

        Assert.assertNotNull(groups);
        Assert.assertNotEquals(groups.size(), 0);
    }

    @Test
    public void testFormerGroups() throws Exception {
        GroupMe4J groupme = new GroupMe4J(retrieveToken());
        List<Group> groups = groupme.getFormerGroups();

        Assert.assertNotNull(groups);
        Assert.assertNotEquals(groups.size(), 0);
    }

    @Test
    public void testCreateAndDestroyGroup() throws Exception {
        GroupMe4J groupme = new GroupMe4J(retrieveToken());
        Group g_created = groupme.createGroup("TESTER GROUP");
        boolean deleted = groupme.destoryGroup(g_created.getId());

        Assert.assertNotNull(g_created);
        Assert.assertNotNull(g_created.getGroupId());
        Assert.assertTrue(deleted);
    }

    private String retrieveToken() throws IOException {
        Path p = (new File("./access.token")).toPath();
        return Files.readAllLines(p).stream().map(n -> n.toString()).collect(Collectors.joining(""));
    }
}
