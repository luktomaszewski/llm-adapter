package com.github.lomasz.llm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties
public class LlmAdapterApplication {

    public static void main(String[] args) {
        SpringApplication.run(LlmAdapterApplication.class, args);
    }
}
