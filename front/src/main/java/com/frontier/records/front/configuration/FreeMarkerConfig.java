package com.frontier.records.front.configuration;

import freemarker.template.TemplateModelException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(FreeMarkerVariables.class)
public class FreeMarkerConfig {

    public FreeMarkerConfig(
        @Autowired final FreeMarkerVariables freeMarkerVariables,
        final freemarker.template.Configuration configuration) throws TemplateModelException {
        configuration.setSharedVaribles(freeMarkerVariables.getVariables());
    }
}
