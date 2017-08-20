package org.skalka.groupme4j;

import org.junit.Assert;
import org.junit.Test;

public class GroupMe4JSmsModeTest extends GroupMe4JClientTest {

    @Test
    public void testSmsMode() {
        Assert.assertTrue(groupme.enableSmsMode(1));
        Assert.assertTrue(groupme.disableSmsMode());
    }
    
}
