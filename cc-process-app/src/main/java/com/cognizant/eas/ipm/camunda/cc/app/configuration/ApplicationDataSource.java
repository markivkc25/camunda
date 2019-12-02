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
@EnableJpaRepositories(basePackages = "com.cognizant.eas.ipm.camunda.cc.app.repository",
        entityManagerFactoryRef = "ccvalidationEntityManagerFactory",
        transactionManagerRef= "ccvalidationTransactionManager"
)*/
public class ApplicationDataSource {
	/*@Bean
    @ConfigurationProperties("spring.datasource.ccvalidation")
    public DataSourceProperties ccvalidationDataSourceProperties() {
        return new DataSourceProperties();
    } 
	
	
	@Bean
    @ConfigurationProperties("spring.datasource.ccvalidation.configuration")
    public DataSource ccvalidationDataSource() {
        return ccvalidationDataSourceProperties().initializeDataSourceBuilder()
                .type(BasicDataSource.class).build();
    }
	
	@Bean(name = "ccvalidationEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean ccvalidationEntityManagerFactory(
            EntityManagerFactoryBuilder builder) {
        return builder
                .dataSource(ccvalidationDataSource())
                .packages(Promotion.class,CustomerData.class)
                .build();
    }
	
	@Bean
    public PlatformTransactionManager ccvalidationTransactionManager(
            final @Qualifier("ccvalidationEntityManagerFactory") LocalContainerEntityManagerFactoryBean ccvalidationEntityManagerFactory) {
        return new JpaTransactionManager(ccvalidationEntityManagerFactory.getObject());
    }*/

}
