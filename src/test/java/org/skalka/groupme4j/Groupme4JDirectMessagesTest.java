package org.skalka.groupme4j;

import org.junit.Assert;
import org.junit.Test;

import org.skalka.groupme4j.exception.GroupMeException;
import org.skalka.groupme4j.model.chat.Chat;
import org.skalka.groupme4j.model.message.DirectMessage;
import org.skalka.groupme4j.model.message.DirectMessages;
import java.util.List;

public class Groupme4JDirectMessagesTest extends GroupMe4JClientTest {

    @Test
    public void testGetDirectMessages() throws GroupMeException {
        Chat chat = groupme.getChats(1, 1).get(0);
        DirectMessages messages = groupme.getDirectMessages(chat.getOtherUser().getId());

        Assert.assertNotNull(messages);
        Assert.assertNotNull(messages.getCount());
        Assert.assertNotEquals((Integer) 0, messages.getCount());

        Assert.assertNotNull(messages.getDirectMessages());

        DirectMessage message = messages.getDirectMessages().get(0);
        Assert.assertNotNull(message.getText());
    }

    @Test
    public void testSendDirectMessage_NoAttachment() throws GroupMeException {
        DirectMessage dm = groupme.postDirectMessage("51022126", "THIS IS A TEST");

        Assert.assertNotNull(dm);
        Assert.assertNotNull(dm.getText());
        Assert.assertEquals("THIS IS A TEST", dm.getText());
    }

}
