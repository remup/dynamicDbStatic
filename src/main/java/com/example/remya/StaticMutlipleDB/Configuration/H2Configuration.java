package com.example.remya.StaticMutlipleDB.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.example.remya.StaticMutlipleDB.Entity.EmployeeH2;
import com.zaxxer.hikari.HikariDataSource;

@Configuration
@EnableConfigurationProperties({ JpaProperties.class })
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = "com.example.remya.StaticMutlipleDB.RepoH2",
        entityManagerFactoryRef = "h2EntityManagerFactory",
        transactionManagerRef= "h2TransactionManager"
)
public class H2Configuration {
	
	
	 @Bean
	    //@Primary
	    @ConfigurationProperties("app.datasource.h2")
	    public DataSourceProperties h2DataSourceProperties() {
	        return new DataSourceProperties();
	    }

	    @Bean
	    //@Primary
	    @ConfigurationProperties("app.datasource.h2.configuration")
	    public DataSource h2DataSource() {
	        return h2DataSourceProperties().initializeDataSourceBuilder()
	                .type(HikariDataSource.class).build();
	    }

	   // @Primary
	    @Bean(name = "h2EntityManagerFactory")
	    public LocalContainerEntityManagerFactoryBean h2EntityManagerFactory(EntityManagerFactoryBuilder builder) {
	    	
	    	//Map<String, Object> jpaProperties = new LinkedHashMap<>();
		   // jpaProperties.put("hibernate.default_schema", "dbo");
	        return builder
	                .dataSource(h2DataSource())
	                .packages(EmployeeH2.class)
	                .build();
//	    	LocalContainerEntityManagerFactoryBean lfb = builder
//	                .dataSource(h2DataSource())
//	                .packages(EmployeeH2.class)
//	                .build();
//	    	lfb.setJpaPropertyMap(jpaProperties);
//	    	return lfb;
	    }

	    //@Primary
	    @Bean
	    public PlatformTransactionManager h2TransactionManager(
	            final @Qualifier("h2EntityManagerFactory") LocalContainerEntityManagerFactoryBean h2EntityManagerFactory) {
	        return new JpaTransactionManager(h2EntityManagerFactory.getObject());
	    }
	

}
