package com.jarvis.mds.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.HashMap;

//@EnableTransactionManagement
@Configuration
@EnableJpaRepositories(basePackages = "com.jarvis.mds.repository.orders", entityManagerFactoryRef =
        "getCustomEntityManagerFactoryForMds", transactionManagerRef = "getTransactionManagerForMds")
public class MdsEntityManagerFactory {

  @Bean
  public EntityManagerFactoryBuilder entityManagerFactoryBuilderForMds() {
    return new EntityManagerFactoryBuilder(new HibernateJpaVendorAdapter(), new HashMap<>(), null);
  }

  @Bean
  LocalContainerEntityManagerFactoryBean getCustomEntityManagerFactoryForMds(@Qualifier("mdsDataSource") DataSource dataSource) {
    return entityManagerFactoryBuilderForMds().dataSource(dataSource).packages("com.jarvis.mds.entity.orders").build();
  }

  @Bean
  PlatformTransactionManager getTransactionManagerForMds(@Qualifier("getCustomEntityManagerFactoryForMds") LocalContainerEntityManagerFactoryBean getCustomEntityManagerFactoryForMds) {
    return new JpaTransactionManager(getCustomEntityManagerFactoryForMds.getObject());
  }
}
