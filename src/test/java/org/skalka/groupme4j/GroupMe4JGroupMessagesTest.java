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

    Group cGroup = null;
    
    @Before
    @Override
    public void setup() throws IOException {
        super.setup();
        
        try {
            cGroup = groupme.createGroup("TESTER GROUP");
        } catch (GroupMeAPIException ex) {
            Logger.getLogger(GroupMe4JGroupMessagesTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        Assert.assertNotNull(cGroup);
        Assert.assertNotNull(cGroup.getGroupId());
    }
    
    @After
    public void tearDown() {
        boolean deleted = groupme.destoryGroup(cGroup.getGroupId());
        Assert.assertTrue(deleted);
    }
    
    @Test
    public void testGetMessageForGroup() throws GroupMeAPIException {
        // Getting a group chat that was not just created
        Group group = groupme.getGroups(1, 2).get(1);
        GroupMessages messages = groupme.getMessagesForGroup(group.getGroupId());

        Assert.assertNotNull(messages);
        Assert.assertNotNull(messages.getCount());
        Assert.assertNotEquals(0, messages.getMessages().size());

        Assert.assertNotNull(messages.getMessages());

        GroupMessage message = messages.getMessages().get(0);
        Assert.assertNotNull(message.getId());
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
