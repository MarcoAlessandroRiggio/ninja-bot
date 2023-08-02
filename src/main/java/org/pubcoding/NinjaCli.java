package org.pubcoding;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.hibernate.dialect.SQLServerDialect;


@SpringBootApplication
//@TypeHint(types = SQLServerDialect.class, typeNames = "org.hibernate.dialect.SQLServerDialect")
public class NinjaCli {
    public static void main(String[] args) {
        SpringApplication.run(NinjaCli.class, args);
    }
}
