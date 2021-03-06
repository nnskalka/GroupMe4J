package org.skalka.groupme4j;

import org.junit.Assert;
import org.junit.Test;

import org.skalka.groupme4j.exception.GroupMeException;
import org.skalka.groupme4j.model.user.User;

public class GroupMe4JUserTest extends GroupMe4JClientTest {

  @Test
  public void testGetMe() throws GroupMeException {
    User me = groupme.getMe();
    
    Assert.assertNotNull(me.getId());
    Assert.assertNotNull(me.getName());
    Assert.assertNotNull(me.getCreatedAt());
  }
  
  @Test
  public void testUpdateMe() throws GroupMeException {
    User me = groupme.getMe();
    groupme.updateUser(me.getName());

    User newMe = groupme.updateUser("Test Test");
    Assert.assertNotNull(newMe.getId());
    Assert.assertNotNull(newMe.getName());
    Assert.assertEquals("Test Test", newMe.getName());
    Assert.assertNotNull(newMe.getCreatedAt());
  }
}
