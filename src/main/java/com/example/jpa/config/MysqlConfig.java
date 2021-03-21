package com.example.jpa.config;

import java.util.HashMap;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
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

@EnableTransactionManagement
@Configuration
@EnableJpaRepositories(
	entityManagerFactoryRef = "mysqlEntityManager",
	transactionManagerRef = "mysqlPlatformTransactionManager",
	basePackages = "com.example.jpa.repository.mysql"
)
public class MysqlConfig {


	@Bean
	@ConfigurationProperties(prefix = "mysql.datasource")
	public DataSource getMysqlDataSource() {
		return DataSourceBuilder.create().build();

	}

	@Bean
	public LocalContainerEntityManagerFactoryBean mysqlEntityManager(EntityManagerFactoryBuilder emfb) {

		HashMap<String, Object> props = new HashMap<String, Object>();
		props.put("hibernate.hbm2ddl.auto", "create");
		props.put("hibernate.dialect", "org.hibernate.dialect.MySQL8Dialect");
		return emfb.dataSource(getMysqlDataSource()).packages("com.example.jpa.entity.mysql").properties(props).build();

	}
	
	@Bean
	public PlatformTransactionManager mysqlPlatformTransactionManager(@Qualifier("mysqlEntityManager") EntityManagerFactory emf) {
		
		return new JpaTransactionManager(emf);
	}
}
