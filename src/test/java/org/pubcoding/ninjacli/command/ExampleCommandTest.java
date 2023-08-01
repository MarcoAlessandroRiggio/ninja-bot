package org.pubcoding.ninjacli.command;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ExampleCommandTest {

    void oneCommandToExecute() {
        var command = new ExampleCommand(null);
        var result = command.call();
        assertEquals(0, result);
    }

}
