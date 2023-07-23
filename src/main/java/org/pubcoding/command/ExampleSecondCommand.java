package org.pubcoding.command;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import picocli.CommandLine.Command;
@Component
@Command(name = "example-second")
@Slf4j
public class ExampleSecondCommand implements Runnable {

    @Override
    public void run() {
            log.info("second example invoked");
    }

}
