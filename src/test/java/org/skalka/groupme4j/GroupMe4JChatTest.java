package org.skalka.groupme4j;

import java.util.List;
import org.junit.Assert;
import org.junit.Test;
import org.skalka.groupme4j.exception.GroupMeAPIException;
import org.skalka.groupme4j.model.chat.Chat;

public class GroupMe4JChatTest extends GroupMe4JClientTest {
    
    @Test
    public void testGetChats() throws GroupMeAPIException, InterruptedException {
        List<Chat> chats = groupme.getChats(1, 4);
        
        Assert.assertEquals(3, chats.size());
        Assert.assertNotNull(chats.get(0));
        
        chats = groupme.getChats(1, 3);
        
        Assert.assertEquals(3, chats.size());
        Assert.assertNotNull(chats.get(0));
        
        chats = groupme.getChats(1, 2);
        
        Assert.assertEquals(2, chats.size());
        Assert.assertNotNull(chats.get(0));
        
        chats = groupme.getChats(1, 1);
        
        Assert.assertEquals(1, chats.size());
        Assert.assertNotNull(chats.get(0));
        
        Chat chat = chats.get(0);
        Assert.assertNotNull(chat.getOtherUser());
    }
    
}
