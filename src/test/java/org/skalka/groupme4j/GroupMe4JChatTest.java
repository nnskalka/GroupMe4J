package org.skalka.groupme4j;

import java.util.List;
import org.junit.Assert;
import org.junit.Test;
import org.skalka.groupme4j.exception.GroupMeAPIException;
import org.skalka.groupme4j.model.chat.Chat;

public class GroupMe4JChatTest extends GroupMe4JClientTest {
    
    @Test
    public void testGetChats() throws GroupMeAPIException {
        List<Chat> chats = groupme.getChats(1, 10);
        
        Assert.assertEquals(10, chats.size());
        Assert.assertNotNull(chats.get(0));
        
        Chat chat = chats.get(0);
        Assert.assertNotNull(chat.getOtherUser());
    }
    
}
