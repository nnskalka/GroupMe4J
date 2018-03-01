package org.skalka.groupme4j;

import java.util.List;
import org.junit.Assert;
import org.junit.Test;
import org.skalka.groupme4j.exception.GroupMeException;
import org.skalka.groupme4j.model.block.Block;
import org.skalka.groupme4j.model.block.BlockBetween;

public class GroupMe4JBlockTest extends GroupMe4JClientTest {

  @Test
  public void testBlocking() throws GroupMeException {
    List<Block> blocks = groupme.getBlocks();
    
    Assert.assertNotNull(blocks);
    Assert.assertNotEquals(0, blocks.size());
    
    BlockBetween block = groupme.getBlockBetween(blocks.get(0).getBlockedUserId());
    
    Assert.assertTrue(block.getBetween());
  }
  
}
