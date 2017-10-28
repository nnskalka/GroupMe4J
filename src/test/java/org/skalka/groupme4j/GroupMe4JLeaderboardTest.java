package org.skalka.groupme4j;

import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.skalka.groupme4j.exception.GroupMeAPIException;
import org.skalka.groupme4j.model.message.GroupMessage;

public class GroupMe4JLeaderboardTest extends GroupMe4JClientTest {
    
    protected GroupMessage message;
    
    @Before
    @Override
    public void setup() throws IOException {
        super.setup();
        
        try {            
            message = groupme.postMessage(cGroup.getGroupId(), "Test");
            groupme.likeMessage(message.getGroupId(), message.getId());
        } catch (GroupMeAPIException ex) {
            Logger.getLogger(GroupMe4JGroupMessagesTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Test
    public void testGroupLikes_Day() throws GroupMeAPIException {
        testGroupLikes("day");
    }
    
    @Test
    public void testGroupLikes_Week() throws GroupMeAPIException {
        testGroupLikes("week");
    }
    
    @Test
    public void testGroupLikes_Month() throws GroupMeAPIException {
        testGroupLikes("month");
    }
    
    private void testGroupLikes(String parameter) throws GroupMeAPIException {
        List<GroupMessage> messages = groupme.getGroupLikes(cGroup.getGroupId(), parameter);
        
        Assert.assertNotNull(messages);
        Assert.assertEquals(1, messages.size());
        
        Assert.assertNotNull(messages.get(0));
        Assert.assertNotNull(messages.get(0).getId());
    }
    
    @Test
    public void testGetMyGroupLikes() throws GroupMeAPIException {
        List<GroupMessage> messages = groupme.getMyGroupLikes(cGroup.getGroupId());
        
        Assert.assertNotNull(messages);
        Assert.assertNotEquals(0, messages.size());
        
        Assert.assertNotNull(messages.get(0));
        Assert.assertNotNull(messages.get(0).getId());
    }

    @Test
    public void testGetMyGroupHits() throws GroupMeAPIException {
        List<GroupMessage> messages = groupme.getMyGroupHits(cGroup.getGroupId());
        
        Assert.assertNotNull(messages);
        Assert.assertNotEquals(0, messages.size());
        
        Assert.assertNotNull(messages.get(0));
        Assert.assertNotNull(messages.get(0).getId());
    }
}
