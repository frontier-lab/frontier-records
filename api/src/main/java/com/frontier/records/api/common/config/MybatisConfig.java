package com.frontier.records.api.common.config;

import javax.sql.DataSource;
import lombok.RequiredArgsConstructor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.boot.autoconfigure.MybatisProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
@EnableConfigurationProperties(MybatisProperties.class)
public class MybatisConfig {

    private final MybatisProperties mybatisProperties;

    @Bean
    public SqlSessionFactory sqlSessionFactory(final DataSource routingDataSource) throws Exception {
        final SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();

        sqlSessionFactoryBean.setDataSource(routingDataSource);
        sqlSessionFactoryBean.setConfiguration(mybatisProperties.getConfiguration());

        return sqlSessionFactoryBean.getObject();
    }
}
