package org.pubcoding;

import org.pubcoding.command.ExampleCommand;
import org.pubcoding.command.ExampleSecondCommand;
import picocli.CommandLine;
import picocli.CommandLine.Command;

import java.util.concurrent.Callable;

@Command(subcommands = {ExampleCommand.class, ExampleSecondCommand.class})
public class NinjaCli implements Callable<Integer> {

    @Override
    public Integer call() {
        System.out.println("Hi");
        return 0;
    }

    public static void main(String... args) {
        var exitCode = new CommandLine(new NinjaCli()).execute(args);
        System.exit(exitCode);
    }

}
