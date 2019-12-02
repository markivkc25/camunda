package com.cognizant.eas.ipm.camunda.cc.app.configuration;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
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

import com.cognizant.eas.ipm.camunda.cc.app.data.CustomerData;
import com.cognizant.eas.ipm.camunda.cc.app.data.Promotion;

/*@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = "com.cognizant.eas.ipm.camunda.repository",
        entityManagerFactoryRef = "camundaEntityManagerFactory",
        transactionManagerRef= "camundaTransactionManager"
)*/
public class CamundaDataSource {
	/*@Bean
    @ConfigurationProperties("spring.datasource.camunda")
    public DataSourceProperties camundaDataSourceProperties() {
        return new DataSourceProperties();
    } 
	
	
	@Bean
    @ConfigurationProperties("spring.datasource.camunda.configuration")
    public DataSource camundaDataSource() {
        return camundaDataSourceProperties().initializeDataSourceBuilder()
                .type(BasicDataSource.class).build();
    }
	
	@Bean(name = "camundaEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean camundaEntityManagerFactory(
            EntityManagerFactoryBuilder builder) {
        return builder
                .dataSource(camundaDataSource())
                .build();
    }
	
	@Bean
    public PlatformTransactionManager camundaTransactionManager(
            final @Qualifier("camundaEntityManagerFactory") LocalContainerEntityManagerFactoryBean camundaEntityManagerFactory) {
        return new JpaTransactionManager(camundaEntityManagerFactory.getObject());
    }*/

}
