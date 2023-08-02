package org.pubcoding.ninjacli.command;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.pubcoding.ninjacli.repository.EnchantmentRepository;
import org.pubcoding.ninjacli.service.EnchantmentPrinter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import picocli.CommandLine.Command;
import picocli.CommandLine.Help.Ansi;
import picocli.CommandLine.Option;

import java.util.concurrent.Callable;

@Slf4j
@Component
@Command(name = "show-spell", description = "print a spell taken from the DB.")
@RequiredArgsConstructor
public class ShowSpellCommand implements Callable<Integer> {

    @Autowired
    private final EnchantmentRepository enchantmentRepository;

    @Autowired
    private final EnchantmentPrinter printer;

    @Option(names = "--spell", description = "Spell name to search.", required = true)
    String spell;

    @Option(names = {"--verbose", "-v"}, description = "include all information.")
    boolean verbose;

    public Integer call() {
        var eventuallyEnchantment = enchantmentRepository.findByName(spell);
        eventuallyEnchantment.ifPresentOrElse(
                enchantment -> {
                    if (verbose)
                        printer.printVerboseEnchantment(enchantment);
                    else
                        printer.printEnchantment(enchantment);
                },
                () -> log.info(Ansi.AUTO.string("@|bold,Red No spell with name {} found |@"), spell)
        );
        return 0;
    }
}

