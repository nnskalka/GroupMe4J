package org.skalka.groupme4j;

import org.junit.Assert;
import org.junit.Test;
import org.skalka.groupme4j.exception.GroupMeAPIException;
import org.skalka.groupme4j.model.user.User;

public class GroupMe4JUserTest extends GroupMe4JClientTest {

    @Test
    public void testGetMe() throws GroupMeAPIException {
        User me = groupme.getMe();
        
        Assert.assertNotNull(me.getId());
        Assert.assertNotNull(me.getName());
        Assert.assertNotNull(me.getCreatedAt());
    }
    
    @Test
    public void testUpdateMe() throws GroupMeAPIException {
        User me = groupme.updateUser("Test Test");
        
        Assert.assertNotNull(me.getId());
        Assert.assertNotNull(me.getName());
        Assert.assertNotNull(me.getCreatedAt());
    }
    
}
