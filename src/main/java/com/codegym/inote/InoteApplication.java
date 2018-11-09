package com.codegym.inote;

import com.codegym.inote.service.iNoteImpl;
import com.codegym.inote.service.iNoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@SpringBootApplication
public class InoteApplication extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder applicationBuilder) {
        return applicationBuilder.sources(InoteApplication.class);
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(InoteApplication.class, args);
    }

    @Bean
    public iNoteService iNoteService() {
        return new iNoteImpl();
    }
}
