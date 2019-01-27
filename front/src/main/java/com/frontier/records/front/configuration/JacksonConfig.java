package com.frontier.records.front.configuration;

import java.util.List;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

@Configuration
public class JacksonConfig {

    @Bean
    public RestTemplate restTemplate(List<HttpMessageConverter<?>> converters) {
        return new RestTemplate(converters);
    }
}
