package org.pubcoding.ninjacli.command;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.IOException;

@ExtendWith(MockitoExtension.class)
public class ShowSpellCommandTest {
    public static final String DARDO_INCANTATO = "dardo-incantato";
    private ShowSpellCommand sut;

    @BeforeEach
    void setup() {
        sut = new ShowSpellCommand(DARDO_INCANTATO);
    }

    @Test
    void printReferenceIfSpellExist() throws IOException {
        sut.call();
    }

}
