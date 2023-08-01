package org.pubcoding.ninjacli.command;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import picocli.CommandLine.Command;

import java.util.concurrent.Callable;

@Component
@Command(subcommands = {ExampleSecondCommand.class, ShowSpellCommand.class})
@Slf4j
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class ExampleCommand implements Callable<Integer> {

    @Override
    public Integer call() {
        log.info("example invoked");
        return 0;
    }

}
