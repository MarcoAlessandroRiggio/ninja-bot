package org.pubcoding.ninjacli.util;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WordUtilsTest {

    private final String phrase = "Aiuto garantisce al soggetto un bonus morale di +1 ai tiri per colpire e ai tiri salvezza contro gli effetti della paura, in più guadagna punti ferita temporanei pari a 1d8 + il livello dell'incantatore (fino _aunmassimo di td8+10 punti ferita temporanei al10`_li: vello dell'incantatore).";
    private WordUtils sut;

    @BeforeEach
    void setup() {
        sut = new WordUtils();
    }

    @Test
    void checkSingleSplit() {
        var result = sut.extractLine(phrase, 80);
        assertEquals("Aiuto garantisce al soggetto un bonus morale di +1 ai tiri per colpire e ai tiri", result);
    }

    @Test
    void checkSingleSplitDefault() {
        var result = sut.extractLine(phrase, 80);
        var resultWithDefault = sut.extractLine(phrase);
        assertEquals(result, resultWithDefault);
    }

//    @Test
//    void checkMultipleSplit() {
//        var result = sut.truncateIntoList(phrase);
//        var expected = Arrays.asList("salvezza contro gli effetti della paura, in più guadagna punti ferita temporanei pari a 1d8 + il livello dell'incantatore (fino _aunmassimo di td8+10 punti ferita temporanei al10`_li: vello dell'incantatore).,  temporanei pari a 1d8 + il livello de")
//        assertEquals(result, Arrays.asList());
//    }

}
