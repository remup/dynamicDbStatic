package com.example.remya.StaticMutlipleDB.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

import javax.persistence.PersistenceContext;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.example.remya.StaticMutlipleDB.Entity.Employee;
import com.zaxxer.hikari.HikariDataSource;

@Lazy
@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = "com.example.remya.StaticMutlipleDB.Repo",
        entityManagerFactoryRef = "sqlEntityManagerFactory",
        transactionManagerRef= "sqlTransactionManager"
)
public class SQLConfiguration {

	 @Bean
	    @Primary
	    @ConfigurationProperties("app.datasource.one")
	    public DataSourceProperties sqlDataSourceProperties() {
		 System.out.println("sql databasourceProperties");
	        return new DataSourceProperties();
	    }

	    @Bean
	    @Primary
	    @ConfigurationProperties("app.datasource.one.configuration")
	    public DataSource sqlDataSource() {
	    	System.out.println("sql databasource");
	        return sqlDataSourceProperties().initializeDataSourceBuilder()
	                .type(HikariDataSource.class).build();
	    }
	   
	    @Primary
	    @Bean(name = "sqlEntityManagerFactory")
	    public LocalContainerEntityManagerFactoryBean sqlEntityManagerFactory(EntityManagerFactoryBuilder builder) {
	    	System.out.println("sql LocalContainerEntityManagerFactoryBean");
	    	Map<String, Object> jpaProperties = new LinkedHashMap<>();
			    //jpaProperties.put("hibernate.default_schema", "remya");
			    jpaProperties.put("hibernate.default_schema", "dbo");
	    	LocalContainerEntityManagerFactoryBean lfb = builder
	                .dataSource(sqlDataSource())
	                .packages(Employee.class)
	                .build();
	    	lfb.setJpaPropertyMap(jpaProperties);
	    	return lfb;
//	        return builder
//	                .dataSource(sqlDataSource())
//	                .packages(Employee.class)
//	                .build();
	    }

	    @Primary
	    @Bean
	    public PlatformTransactionManager sqlTransactionManager(
	            final @Qualifier("sqlEntityManagerFactory") LocalContainerEntityManagerFactoryBean sqlEntityManagerFactory) {
	    	System.out.println("sql PlatformTransactionManager");
	    	return new JpaTransactionManager(sqlEntityManagerFactory.getObject());
	    }
	


}
