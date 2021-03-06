package org.skalka.groupme4j;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.skalka.groupme4j.exception.GroupMeException;
import org.skalka.groupme4j.model.group.Group;

public class GroupMe4JClientTest {

  protected GroupMe4JClient groupme;
  protected Group createdGroup;

  @Before
  public void setup() throws IOException {
    groupme = new GroupMe4JClient(retrieveToken());
    
    Assert.assertNotNull(groupme);
    
    try {
      createdGroup = groupme.createGroup("TESTER GROUP");
    } catch (GroupMeException ex) {
      Logger.getLogger(GroupMe4JGroupMessagesTest.class.getName()).log(Level.SEVERE, null, ex);
    }
    
    Assert.assertNotNull(createdGroup);
    Assert.assertNotNull(createdGroup.getGroupId());
  }
  
  @After
  public void tearDown() {
    boolean deleted = groupme.destoryGroup(createdGroup.getGroupId());
    Assert.assertTrue(deleted);
  }

  private String retrieveToken() throws IOException {
    Path p = (new File("./access.token")).toPath();
    return Files.readAllLines(p).stream().map(n -> n.toString()).collect(Collectors.joining(""));
  }
}
