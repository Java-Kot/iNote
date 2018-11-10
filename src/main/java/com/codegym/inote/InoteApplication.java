package com.codegym.inote;

import com.codegym.inote.formatter.NotetypeFormatter;
import com.codegym.inote.service.NotetypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class InoteApplication extends SpringBootServletInitializer {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(InoteApplication.class, args);
    }

    @Configuration
    static class MyConfig implements WebMvcConfigurer {

        @Autowired
        NotetypeService notetypeService;

        @Override
        public void addFormatters(FormatterRegistry registry) {
            registry.addFormatter(new NotetypeFormatter(notetypeService));
        }
    }
}
