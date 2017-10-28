package org.skalka.groupme4j;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.skalka.groupme4j.exception.GroupMeAPIException;
import org.skalka.groupme4j.model.group.Group;
import org.skalka.groupme4j.model.message.GroupMessage;
import org.skalka.groupme4j.model.message.GroupMessages;
import org.skalka.groupme4j.model.message.attachment.Attachment;
import org.skalka.groupme4j.model.message.attachment.LocationAttachment;

public class GroupMe4JGroupMessagesTest extends GroupMe4JClientTest {
    
    @Test
    public void testGetMessageForGroup() throws GroupMeAPIException {
        final int NUMBER_OF_GROUPS = 15;

        // Getting a group chat that was not just created
        List<Group> groups = groupme.getGroups(1, NUMBER_OF_GROUPS);
        
        Assert.assertNotNull(groups);
        Assert.assertEquals(NUMBER_OF_GROUPS, groups.size());
        
        for (int i = 1; i < groups.size(); i++) {
            Group group = groups.get(i);
            
            Assert.assertNotNull(group);
            Assert.assertNotNull(group.getGroupId());
            
            GroupMessages messages = groupme.getMessagesForGroup(group.getGroupId(), 50);

            Assert.assertNotNull(messages);
            Assert.assertNotNull(messages.getCount());
            Assert.assertNotEquals(0, messages.getMessages().size());

            Assert.assertNotNull(messages.getMessages());

            GroupMessage message = messages.getMessages().get(0);
            Assert.assertNotNull(message.getId());
        }
    }

    @Test
    public void testPostGroupMessage_NoAttachments() throws GroupMeAPIException {
        GroupMessage message = groupme.postMessage(cGroup.getGroupId(), "Hello World");
        
        Assert.assertNotNull(message);
        Assert.assertNotNull(message.getText());
        Assert.assertEquals("Hello World", message.getText());
    }
    
    @Test
    public void testPostGroupMessage_LocationAttachment() throws GroupMeAPIException {
        List<Attachment> attachments = new LinkedList<Attachment>();
        attachments.add(new LocationAttachment() {{
            setLatitude("0.0");
            setLongitude("0.0");
            setName("TEST");
        }}); 

        GroupMessage message = groupme.postMessage(cGroup.getGroupId(), attachments);
        
        Assert.assertNotNull(message);
        Assert.assertNotNull(message.getAttachments());
        Assert.assertEquals(1, message.getAttachments().size());
    }
    
}
