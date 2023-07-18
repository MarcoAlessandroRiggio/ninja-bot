package org.pubcoding.command;

import picocli.CommandLine.Command;

import java.util.concurrent.Callable;

@Command(name = "example")
public class ExampleCommand implements Callable<Integer> {

    @Override
    public Integer call() {
        System.out.println("example invoked");
        return 0;
    }

}
