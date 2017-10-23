package org.skalka.groupme4j;

import org.junit.Assert;
import org.junit.Test;
import org.skalka.groupme4j.exception.GroupMeAPIException;
import org.skalka.groupme4j.model.group.Group;
import org.skalka.groupme4j.model.group.PreviewGroupMessage;

public class GroupMe4JLikeTest extends GroupMe4JClientTest {

    @Test
    public void testLikes() throws GroupMeAPIException {
        Group group = groupme.getGroups(1, 1).get(0);
        PreviewGroupMessage message = group.getPreviewMessage();
        
        Assert.assertTrue(groupme.likeMessage(group.getGroupId(), message.getLastMessageId()));
        Assert.assertTrue(groupme.unlikeMessage(group.getGroupId(), message.getLastMessageId()));
    }
    
}
