package org.pubcoding.ninjacli.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackages = "org.pubcoding.ninjacli.repository")
public class PersistenceConfiguration {
}
