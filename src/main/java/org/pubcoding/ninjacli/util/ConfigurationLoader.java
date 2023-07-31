package org.pubcoding.ninjacli.util;

import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.snakeyaml.error.MarkedYAMLException;
import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import org.pubcoding.ninjacli.model.Configuration;
import org.pubcoding.ninjacli.model.Errors;

import java.io.File;
import java.io.IOException;

@AllArgsConstructor
@Log
public class ConfigurationLoader {

    private final ObjectMapper mapper;
    private final File file;

    public Configuration getConfig() throws IOException {
        try {
            return mapper.readValue(file, Configuration.class);
        } catch (DatabindException | MarkedYAMLException e) {
            log.severe("config file is malformed.");
            System.exit(Errors.MALFORMED_CONFIGURATION.getCode());
            throw e;
        }catch (IOException e) {
            log.severe("config file not found.");
            System.exit(Errors.FILE_NOT_FOUND.getCode());
            throw e;
        }
    }


}
