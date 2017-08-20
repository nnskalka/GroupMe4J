package org.skalka.groupme4j.exception;

import java.util.List;
import java.util.stream.Collectors;

public class GroupMeException extends Exception {

  private static final long serialVersionUID = 2766010237929504268L;
  
  public GroupMeException(List<String> errors) {
    super(errors.stream().collect(Collectors.joining(";")));
  }
  
}
