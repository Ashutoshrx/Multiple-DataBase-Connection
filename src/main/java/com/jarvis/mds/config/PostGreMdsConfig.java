package com.jarvis.mds.config;

import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class PostGreMdsConfig {
  @Bean(name = "mdsConfig")
  @ConfigurationProperties(prefix = "spring.datasource.mds")
  public DataSourceProperties prepareDataSourceProperties() {
    return new DataSourceProperties();
  }

  @Bean("mdsDataSource")
  public DataSource getDataSourceForMds() {
    return prepareDataSourceProperties().initializeDataSourceBuilder().build();
  }
}
