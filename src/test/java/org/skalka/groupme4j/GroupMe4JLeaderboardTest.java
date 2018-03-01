package org.skalka.groupme4j;

import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.skalka.groupme4j.exception.GroupMeException;
import org.skalka.groupme4j.model.message.GroupMessage;

public class GroupMe4JLeaderboardTest extends GroupMe4JClientTest {
  
  protected GroupMessage message;
  
  @Before
  @Override
  public void setup() throws IOException {
    super.setup();
    
    try {      
      message = groupme.postMessage(createdGroup.getGroupId(), "Test");
      groupme.likeMessage(message.getGroupId(), message.getId());
    } catch (GroupMeException ex) {
      Logger.getLogger(GroupMe4JGroupMessagesTest.class.getName()).log(Level.SEVERE, null, ex);
    }
  }
  
  @Test
  public void testGroupLikes_Day() throws GroupMeException {
    testGroupLikes("day");
  }
  
  @Test
  public void testGroupLikes_Week() throws GroupMeException {
    testGroupLikes("week");
  }
  
  @Test
  public void testGroupLikes_Month() throws GroupMeException {
    testGroupLikes("month");
  }
  
  private void testGroupLikes(String parameter) throws GroupMeException {
    List<GroupMessage> messages = groupme.getGroupLikes(createdGroup.getGroupId(), parameter);
    
    Assert.assertNotNull(messages);
    Assert.assertEquals(1, messages.size());
    
    Assert.assertNotNull(messages.get(0));
    Assert.assertNotNull(messages.get(0).getId());
  }
  
  @Test
  public void testGetMyGroupLikes() throws GroupMeException {
    List<GroupMessage> messages = groupme.getMyGroupLikes(createdGroup.getGroupId());
    
    Assert.assertNotNull(messages);
    Assert.assertNotEquals(0, messages.size());
    
    Assert.assertNotNull(messages.get(0));
    Assert.assertNotNull(messages.get(0).getId());
  }

  @Test
  public void testGetMyGroupHits() throws GroupMeException {
    List<GroupMessage> messages = groupme.getMyGroupHits(createdGroup.getGroupId());
    
    Assert.assertNotNull(messages);
    Assert.assertNotEquals(0, messages.size());
    
    Assert.assertNotNull(messages.get(0));
    Assert.assertNotNull(messages.get(0).getId());
  }
}
