package com.jarvis.mds.config;

import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

@Configuration
public class PostGreMdaConfig {
  @ConfigurationProperties(prefix = "spring.datasource.mda")
  @Bean
  DataSourceProperties prepareDataSourceProperties() {
    return new DataSourceProperties();
  }

//  @Primary
  @Bean(name = "mdaDataSource")
  DataSource getDataSourceForMda() {
    return prepareDataSourceProperties().initializeDataSourceBuilder().build();
  }


}
