package org.pubcoding;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "org.pubcoding")
public class NinjaCli {
    public static void main(String[] args) {
        SpringApplication.run(NinjaCli.class, args);
    }
}
