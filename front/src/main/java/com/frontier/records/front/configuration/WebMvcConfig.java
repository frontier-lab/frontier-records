package com.frontier.records.front.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.mobile.device.DeviceHandlerMethodArgumentResolver;
import org.springframework.mobile.device.DeviceResolverHandlerInterceptor;
import org.springframework.mobile.device.view.LiteDeviceDelegatingViewResolver;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.freemarker.FreeMarkerViewResolver;

import java.util.List;


@Configuration
@EnableWebMvc
@SuppressWarnings("CheckStyle")
public class WebMvcConfig implements WebMvcConfigurer {

    private static final String CLASSPATH_RESOURCE_LOCATIONS = "classpath:/static/";

    @Value("${spring.resources.static-locations}")
    private String staticResouceLocation;
    @Value("${spring.mvc.static-path-pattern}")
    private String staticResourcePathPattern;

    @Bean
    public DeviceResolverHandlerInterceptor deviceResolverHandlerInterceptor() {
        return new DeviceResolverHandlerInterceptor();
    }

    @Bean
    public DeviceHandlerMethodArgumentResolver deviceHandlerMethodArgumentResolver() {
        return new DeviceHandlerMethodArgumentResolver();
    }


    //TODO freemarker will be remove after apply react
    @Bean
    public LiteDeviceDelegatingViewResolver liteDeviceAwareViewResolver() {
        FreeMarkerViewResolver delegate = new FreeMarkerViewResolver();
        delegate.setPrefix("");
        delegate.setSuffix(".ftl");
        delegate.setCache(false);
        delegate.setContentType("text/html;charset=UTF-8");

        LiteDeviceDelegatingViewResolver resolver = new LiteDeviceDelegatingViewResolver(delegate);
        resolver.setMobilePrefix("");
        resolver.setMobileSuffix("/mobile");
        resolver.setNormalPrefix("");
        resolver.setNormalSuffix("/pc");
        resolver.setTabletPrefix("");
        resolver.setTabletSuffix("/mobile");
        return resolver;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(deviceResolverHandlerInterceptor());
    }

    @Override
    public void addArgumentResolvers(
        List<HandlerMethodArgumentResolver> argumentResolvers) {
        argumentResolvers.add(deviceHandlerMethodArgumentResolver());
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        //TODO path 'static' will be remove after apply react
        registry
                .addResourceHandler(staticResourcePathPattern, "/static/**")
                .addResourceLocations(staticResouceLocation, CLASSPATH_RESOURCE_LOCATIONS);
        registry.setOrder(Ordered.HIGHEST_PRECEDENCE);
    }
}
