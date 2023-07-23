package org.pubcoding.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import mockit.MockUp;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.pubcoding.model.Configuration;
import org.pubcoding.model.Errors;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ConfigurationLoaderTest {
    @Mock private ObjectMapper mapper;
    @Mock private File file;
    private ConfigurationLoader sut;

    @BeforeEach
    void setup() {
        this.sut = new ConfigurationLoader(mapper, file);
    }

    @Test
    void loadConfigurationWrittenIntoUserHome() throws IOException {
        var configurationMocked = mock(Configuration.class);
        when(mapper.readValue(file, Configuration.class)).thenReturn(configurationMocked);
        var configuration = sut.getConfig();
        verify(mapper, times(1)).readValue(file, Configuration.class);
        assertEquals(configuration, configurationMocked);
    }

    @Test
    void stopExecutionIfConfigurationWasMotFound() throws IOException {
        mockSystem();
        when(mapper.readValue(file, Configuration.class)).thenThrow(JsonProcessingException.class);

        try {
            sut.getConfig();
        } catch (RuntimeException e) {
            assertEquals(Errors.FILE_NOT_FOUND.getCode().toString(), e.getMessage());
        }

    }

    @Test
    void stopExecutionIfConfigurationWasMalformed() throws IOException {
        mockSystem();
        var file = Path
                .of("src", "test", "resources", "malformed-configuration.yml")
                .toFile();
        var sutForThisTest = new ConfigurationLoader(new ObjectMapper(new YAMLFactory()), file);
        try {
            sutForThisTest.getConfig();
        } catch (RuntimeException e) {
            assertEquals(Errors.MALFORMED_CONFIGURATION.getCode().toString(), e.getMessage());
        }

    }

    private void mockSystem() {
        new MockUp<System>() {
            @mockit.Mock
            public void exit(int value) {
                throw new RuntimeException(String.valueOf(value));
            }
        };
    }

}
