package com.frontier.records.front.configuration;

import com.google.common.collect.Maps;
import java.util.Map;
import lombok.Getter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Getter
@ConfigurationProperties(prefix = "freemarker")
public class FreeMarkerVariables {

    private final Map<String, Object> variables = Maps.newHashMap();
}

