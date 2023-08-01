package org.pubcoding.ninjacli.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.pubcoding.ninjacli.model.Enchantment;
import org.pubcoding.ninjacli.util.WordUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import picocli.CommandLine.Help.Ansi;

@Slf4j
@Component
@RequiredArgsConstructor
public class EnchantmentPrinter {

    @Autowired
    private final WordUtils wordUtils;

    private final static String cyanPattern = "@|bold,Cyan %s: |@ {}";

    private String formatPattern(final String value) {
        return Ansi.AUTO.string(String.format(cyanPattern, value));
    }

    public void printEnchantment(final Enchantment enchantment) {
        log.info(formatPattern("Name"), enchantment.getName());
        printDescription(enchantment);
    }

    public void printVerboseEnchantment(final Enchantment enchantment) {
        log.info(formatPattern("Name"), enchantment.getName());
        log.info(formatPattern("School"), enchantment.getSchool());
        log.info(formatPattern("Level"), enchantment.getLevel());
        log.info(formatPattern("Components"), enchantment.getComponents());
        log.info(formatPattern("Casting Time"), enchantment.getCastingTime());
        log.info(formatPattern("Range"), enchantment.getRange());
        log.info(formatPattern("Target"), enchantment.getTarget());
        log.info(formatPattern("Duration"), enchantment.getDuration());
        log.info(formatPattern("Saving Throw"), enchantment.getSavingThrow());
        log.info(formatPattern("Spell Resistance"), enchantment.getSpellResistance());
        printDescription(enchantment);
    }

    private void printDescription(final Enchantment enchantment) {
        log.info(System.lineSeparator());
        wordUtils.truncateIntoList(enchantment.getDescription())
                .forEach(log::info);
    }

}
