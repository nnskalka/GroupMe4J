package org.skalka.groupme4j;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.skalka.groupme4j.model.group.Group;

public class GroupMe4JGroupTest {

    GroupMe4JClient groupme;

    @Before
    public void setup() throws IOException {
        groupme = new GroupMe4JClient(retrieveToken());
    }

    @Test
    public void testGroups() throws Exception {
        List<Group> groups = groupme.getGroups(1, 10);

        Assert.assertNotNull(groups);
        Assert.assertNotEquals(groups.size(), 0);
    }

    @Test
    public void testFormerGroups() throws Exception {
        List<Group> groups = groupme.getFormerGroups();

        Assert.assertNotNull(groups);
        Assert.assertNotEquals(0, groups.size());
    }

    @Test
    public void testGetGroupById() throws Exception {
        // Grabbing list of groups to pick one to load individually
        List<Group> groups = groupme.getGroups(null, null);

        Assert.assertNotNull(groups);
        Assert.assertNotEquals(0, groups.size());
        Assert.assertNotNull(groups.get(0).getId());

        // Getting individual group
        Group group = groupme.getGroupById(groups.get(0).getGroupId());

        Assert.assertNotNull(group);
        Assert.assertNotNull(group.getGroupId());
        Assert.assertEquals(groups.get(0).getGroupId(), group.getGroupId());
    }

    @Test
    public void testCreateAndDestroyGroup() throws Exception {
        Group createdGroup = groupme.createGroup("TESTER GROUP");
        Assert.assertNotNull(createdGroup);
        Assert.assertNotNull(createdGroup.getGroupId());

        boolean deleted = groupme.destoryGroup(createdGroup.getGroupId());
        Assert.assertTrue(deleted);
    }

    private String retrieveToken() throws IOException {
        Path p = (new File("./access.token")).toPath();
        return Files.readAllLines(p).stream().map(n -> n.toString()).collect(Collectors.joining(""));
    }
}
