package org.pubcoding.command.command;

import lombok.extern.slf4j.Slf4j;
import picocli.CommandLine;
import picocli.CommandLine.Command;

import java.util.concurrent.Callable;

@Command
@Slf4j
public class ExampleCommand implements Callable<Integer> {

    @Override
    public Integer call() {
        log.info("Command invoked");
        return 0;
    }

    public static void main(String... args) {
        var exitCode = new CommandLine(new ExampleCommand())
                .execute(args);
        System.exit(exitCode);
    }

}
