package org.skalka.groupme4j;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Collectors;
import org.junit.Before;

public class GroupMe4jClientTest {

    protected GroupMe4JClient groupme;

    @Before
    public void setup() throws IOException {
        groupme = new GroupMe4JClient(retrieveToken());
    }

    private String retrieveToken() throws IOException {
        Path p = (new File("./access.token")).toPath();
        return Files.readAllLines(p).stream().map(n -> n.toString()).collect(Collectors.joining(""));
    }
}
