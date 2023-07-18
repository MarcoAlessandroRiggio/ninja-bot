package org.pubcoding.command;

import picocli.CommandLine.Command;

@Command(name = "example-second")
public class ExampleSecondCommand implements Runnable {

    @Override
    public void run() {
            System.out.println("second example invoked");
    }

}
