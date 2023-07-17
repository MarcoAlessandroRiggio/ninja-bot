package org.pubcoding.command;

import picocli.CommandLine;
import picocli.CommandLine.Command;

import java.util.concurrent.Callable;

@Command
public class ExampleCommand implements Callable<Integer> {

    @Override
    public Integer call() {
        System.out.println("Command invoked");
        return 0;
    }

    public static void main(String... args) {
        var exitCode = new CommandLine(new ExampleCommand())
                .execute(args);
        System.exit(exitCode);
    }

}
