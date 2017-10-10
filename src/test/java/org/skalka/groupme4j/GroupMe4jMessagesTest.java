package org.skalka.groupme4j;

import org.junit.Assert;
import org.junit.Test;
import org.skalka.groupme4j.model.group.Group;
import org.skalka.groupme4j.model.message.GroupMessage;
import org.skalka.groupme4j.model.message.GroupMessages;

public class GroupMe4jMessagesTest extends GroupMe4jClientTest {

    @Test
    public void testGetMessageForGroup() {
        Group group = groupme.getGroups(1, 1).get(0);
        GroupMessages messages = groupme.getMessagesForGroup(group.getGroupId(), 1);

        Assert.assertNotNull(messages);
        Assert.assertNotNull(messages.getCount());
        Assert.assertNotEquals((Integer)0, messages.getCount());

        Assert.assertNotNull(messages.getMessages());

        GroupMessage message = messages.getMessages().get(0);
        Assert.assertNotNull(message.getText());
    }

    @Test
    public void testPostGroupMessage_NoAttachments() throws Exception {
        boolean failed = false;

        Group createdGroup = groupme.createGroup("TESTER GROUP");
        Assert.assertNotNull(createdGroup);
        Assert.assertNotNull(createdGroup.getGroupId());

        try {
            GroupMessage message = groupme.postMessage(createdGroup.getGroupId(), "Hello World");
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

}
