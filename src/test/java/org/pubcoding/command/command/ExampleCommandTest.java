package org.pubcoding.command.command;

import org.junit.jupiter.api.Test;
import org.pubcoding.command.command.ExampleCommand;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ExampleCommandTest {

    @Test
    void oneCommandToExecute() {
        var command = new ExampleCommand();
        var result = command.call();
        assertEquals(0, result);
    }

}
