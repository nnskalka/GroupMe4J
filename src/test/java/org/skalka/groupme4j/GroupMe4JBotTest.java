package org.skalka.groupme4j;

import java.util.List;
import org.junit.Assert;
import org.junit.Test;
import org.skalka.groupme4j.exception.GroupMeException;
import org.skalka.groupme4j.model.bot.Bot;

public class GroupMe4JBotTest extends GroupMe4JClientTest {
  
  @Test
  public void testGetBots() throws GroupMeException {
    List<Bot> bots = groupme.getBots();
    
    Assert.assertNotNull(bots);
    Assert.assertNotNull(bots.get(0));
  }
  
  @Test
  public void testCreateAndDestroyBot() throws GroupMeException {
    Bot bot = groupme.createBot("James", createdGroup.getGroupId());
    
    Assert.assertNotNull(bot);
    Assert.assertNotNull(bot.getBotId());
    
    Assert.assertTrue(groupme.deleteBot(bot.getBotId()));
  }
  
  @Test
  public void testPostMessage() throws GroupMeException {
    Bot bot = groupme.createBot("James", createdGroup.getGroupId());
    
    Assert.assertNotNull(bot);
    Assert.assertNotNull(bot.getBotId());
    
    groupme.postBotMessage(bot.getBotId(), "Hello, World!");
    
    Assert.assertTrue(groupme.deleteBot(bot.getBotId()));
  }
}
