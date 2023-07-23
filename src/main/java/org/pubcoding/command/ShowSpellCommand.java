package org.pubcoding.command;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;

import java.util.concurrent.Callable;

@Slf4j
@Component
@AllArgsConstructor
@RequiredArgsConstructor
@Command(name = "show-spell", description = "print spell text.")
public class ShowSpellCommand implements Callable<Integer> {

    @Option(names="spell", description = "Spell name to search.")
    private String spell;
    public Integer call() {
        log.info("show spell invoked");
        return 0;
    }
}

