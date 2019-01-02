package com.example.demo;

import com.fasterxml.jackson.databind.Module;
import com.fasterxml.jackson.datatype.guava.GuavaModule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JacksonDataTypeConfiguration {

    @Bean
    public Module guavaModule() {
        return new GuavaModule();
    }
}
