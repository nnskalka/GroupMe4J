package org.skalka.groupme4j;

import java.util.List;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.skalka.groupme4j.exception.GroupMeAPIException;
import org.skalka.groupme4j.model.bot.Bot;
import org.skalka.groupme4j.model.group.Group;

public class GroupMe4JBotTest extends GroupMe4JClientTest {
    
    @Test
    public void testGetBots() throws GroupMeAPIException {
        List<Bot> bots = groupme.getBots();
        
        Assert.assertNotNull(bots);
        Assert.assertNotNull(bots.get(0));
    }
    
    @Ignore
    @Test
    public void testCreateAndDestroyBot() throws GroupMeAPIException {
        Group group = groupme.getGroups(1, 1).get(0);
        Bot bot = groupme.createBot("James", group.getGroupId());
        
        Assert.assertNotNull(bot);
        Assert.assertNotNull(bot.getBotId());
        
        Assert.assertTrue(groupme.deleteBot(bot.getBotId()));
    }
    
}
