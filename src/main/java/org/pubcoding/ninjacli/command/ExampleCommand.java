package org.pubcoding.ninjacli.command;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.pubcoding.ninjacli.model.Enchantment;
import org.pubcoding.ninjacli.repository.EnchantmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import picocli.CommandLine;
import picocli.CommandLine.Help.Ansi;
import picocli.CommandLine.Command;

import java.util.concurrent.Callable;

import static javax.swing.text.html.parser.DTDConstants.NUMBER;

@Component
@Command(usageHelpWidth = 55, subcommands = {ExampleSecondCommand.class, ShowSpellCommand.class})
@Slf4j
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class ExampleCommand implements Callable<Integer> {

    EnchantmentRepository enchantmentRepository;
    @Override
    public Integer call() {
        Enchantment enchantment = enchantmentRepository.findById(1).get();
        log.info(Ansi.AUTO.string(String.format("@|bold,Cyan Name: |@ %s", enchantment.getName())));
        System.out.println(Ansi.AUTO.string(String.format("@|bold,Cyan description: |@ %s", enchantment.getDescription())));
        log.info("example invoked");
        return 0;
    }

}
