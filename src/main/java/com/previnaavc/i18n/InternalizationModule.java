package com.previnaavc.i18n;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;

@Configuration
public class InternalizationModule {

    @Bean
    public MessageSource messageSource() {
        ResourceBundleMessageSource resource = new ResourceBundleMessageSource();
        resource.setDefaultEncoding("utf-8");
        resource.setFallbackToSystemLocale(false);
        resource.setBasename("locale/messages");
        return resource;
    }

}
