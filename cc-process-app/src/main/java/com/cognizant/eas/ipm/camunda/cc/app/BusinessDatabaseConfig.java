package com.cognizant.eas.ipm.camunda.cc.app;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.zaxxer.hikari.HikariDataSource;

public class BusinessDatabaseConfig {
/*@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(entityManagerFactoryRef = "businessEntityManagerFactory", transactionManagerRef = "businessTransactionManager", basePackages = {
		"com.cognizant.eas.ipm.camunda.cc.app.data" })
public class BusinessDatabaseConfig {

	@Bean(name = "businessDataSource")
	@ConfigurationProperties(prefix = "st.cc.datasource")
	public DataSource dataSource() {
		return DataSourceBuilder.create().build();
	}

	@Bean
	@ConfigurationProperties(prefix = "st.cc.datasource")
	public HikariDataSource dataSource(DataSourceProperties properties) {
		return properties.initializeDataSourceBuilder().type(HikariDataSource.class).build();
	}

	@Bean(name = "businessEntityManagerFactory")
	public LocalContainerEntityManagerFactoryBean businessEntityManagerFactory(EntityManagerFactoryBuilder builder,
			@Qualifier("businessDataSource") DataSource dataSource) {
		return builder.dataSource(dataSource).packages("com.cognizant.eas.ipm.camunda.cc.app.data")
				.persistenceUnit("cc-app-process-api").build();
	}

	@Bean(name = "businessTransactionManager")
	public PlatformTransactionManager businessTransactionManager(
			@Qualifier("businessEntityManagerFactory") EntityManagerFactory businessEntityManagerFactory) {
		return new JpaTransactionManager(businessEntityManagerFactory);
	}*/

}
