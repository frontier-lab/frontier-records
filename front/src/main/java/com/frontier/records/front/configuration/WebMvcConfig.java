package com.frontier.records.front.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.mobile.device.DeviceHandlerMethodArgumentResolver;
import org.springframework.mobile.device.DeviceResolverHandlerInterceptor;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;


@Configuration
@EnableWebMvc
@SuppressWarnings("CheckStyle")
public class WebMvcConfig implements WebMvcConfigurer {

    @Bean
    public DeviceResolverHandlerInterceptor deviceResolverHandlerInterceptor() {
        return new DeviceResolverHandlerInterceptor();
    }

    @Bean
    public DeviceHandlerMethodArgumentResolver deviceHandlerMethodArgumentResolver() {
        return new DeviceHandlerMethodArgumentResolver();
    }


//    @Bean
//    public LiteDeviceDelegatingViewResolver liteDeviceAwareViewResolver() {
//        FreeMarkerViewResolver delegate = new FreeMarkerViewResolver();
//        delegate.setPrefix("");
//        delegate.setSuffix(".ftl");
//
//        LiteDeviceDelegatingViewResolver resolver = new LiteDeviceDelegatingViewResolver(delegate);
//        resolver.setMobilePrefix("");
//        resolver.setMobileSuffix("/mobile");
//        resolver.setNormalPrefix("");
//        resolver.setNormalSuffix("/pc");
//        resolver.setTabletPrefix("");
//        resolver.setTabletSuffix("/mobile");
//
//        return resolver;
//    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(deviceResolverHandlerInterceptor());
    }

    @Override
    public void addArgumentResolvers(
        List<HandlerMethodArgumentResolver> argumentResolvers) {
        argumentResolvers.add(deviceHandlerMethodArgumentResolver());
    }

    @Value("${spring.resources.static-locations}")
    private String staticResouceLocation;
    @Value("${spring.mvc.static-path-pattern}")
    private String staticResourcePathPattern;

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler(staticResourcePathPattern).addResourceLocations(staticResouceLocation);
        registry.setOrder(Ordered.HIGHEST_PRECEDENCE);
    }
}
