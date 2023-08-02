package org.pubcoding.ninjacli.command;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ExampleCommandTest {

    void oneCommandToExecute() {
        var command = new ExampleCommand();
        var result = command.call();
        assertEquals(0, result);
    }

}
