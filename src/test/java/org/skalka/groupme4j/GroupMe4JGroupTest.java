package org.skalka.groupme4j;

import java.util.List;
import org.junit.Assert;
import org.junit.Test;
import org.skalka.groupme4j.model.group.Group;

public class GroupMe4JGroupTest extends GroupMe4JClientTest {

    @Test
    public void testGroups() throws Exception {
        List<Group> groups = groupme.getGroups(1, 1);

        Assert.assertNotNull(groups);
        Assert.assertEquals(1, groups.size());
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
        List<Group> groups = groupme.getGroups(1, 1);

        Assert.assertNotNull(groups);
        Assert.assertEquals(1, groups.size());
        Assert.assertNotNull(groups.get(0).getGroupId());

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

}
