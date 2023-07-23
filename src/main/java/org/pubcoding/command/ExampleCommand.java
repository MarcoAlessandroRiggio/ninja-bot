package org.pubcoding.command;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import picocli.CommandLine.Command;

import java.util.concurrent.Callable;
@Component
@Command(subcommands = {ExampleSecondCommand.class, ShowSpellCommand.class})
@Slf4j
public class ExampleCommand implements Callable<Integer> {

    @Override
    public Integer call() {
        log.info("example invoked");
        return 0;
    }

}
