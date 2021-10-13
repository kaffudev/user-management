package com.jfka.um.spring;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import({
        UmContextConfig.class,
        UmPersistenceJpaConfig.class,
        UmServiceConfig.class,
        UmWebConfig.class
})
public class UmApp extends SpringBootServletInitializer {

    public static void main(final String... args) {
        new SpringApplicationBuilder(UmApp.class).listeners()
            .run(args);
    }
}
