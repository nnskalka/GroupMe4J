package org.skalka.groupme4j;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.skalka.groupme4j.exception.GroupMeAPIException;
import org.skalka.groupme4j.model.group.Group;
import org.skalka.groupme4j.model.group.PreviewGroupMessage;
import org.skalka.groupme4j.model.message.GroupMessage;

public class GroupMe4JLikeTest extends GroupMe4JClientTest {

    protected GroupMessage message;
    
    @Before
    @Override
    public void setup() throws IOException {
        super.setup();
        
        try {            
            message = groupme.postMessage(cGroup.getGroupId(), "Test");
        } catch (GroupMeAPIException ex) {
            Logger.getLogger(GroupMe4JGroupMessagesTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Test
    public void testLikes() throws GroupMeAPIException {
        Assert.assertTrue(groupme.likeMessage(message.getGroupId(), message.getId()));
        Assert.assertTrue(groupme.unlikeMessage(message.getGroupId(), message.getId()));
    }
    
}
