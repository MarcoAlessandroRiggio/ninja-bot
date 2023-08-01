package org.pubcoding.ninjacli.configuration;

import org.hibernate.community.dialect.SQLiteDialect;
import org.springframework.aot.hint.MemberCategory;
import org.springframework.aot.hint.RuntimeHints;
import org.springframework.aot.hint.RuntimeHintsRegistrar;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PersistenceConfiguration implements RuntimeHintsRegistrar {

    @Override
    public void registerHints(RuntimeHints hints, ClassLoader classLoader) {
        hints.reflection().registerType(SQLiteDialect.class, MemberCategory.INVOKE_DECLARED_CONSTRUCTORS);
    }

}
