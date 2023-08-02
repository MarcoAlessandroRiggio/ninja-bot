package org.pubcoding.ninjacli.runner;

import org.pubcoding.ninjacli.command.ExampleCommand;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.ExitCodeGenerator;
import org.springframework.stereotype.Component;
import picocli.CommandLine;
import picocli.CommandLine.IFactory;

@Component
public class Runner implements CommandLineRunner, ExitCodeGenerator {
    private final IFactory factory;
    private final ExampleCommand myCommand;
    private int exitCode;

    public Runner(IFactory factory, ExampleCommand myCommand) {
        this.factory = factory;
        this.myCommand = myCommand;
    }
    @Override
    public void run(String... args) {
        exitCode = new CommandLine(myCommand, factory).execute(args);
    }
    @Override
    public int getExitCode() {
        return exitCode;
    }
}
