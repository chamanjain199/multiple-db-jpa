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
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableTransactionManagement
@Configuration
@EnableJpaRepositories(
	entityManagerFactoryRef = "postgresEntityManager",
	transactionManagerRef = "postgresPlatformTransactionManager",
	basePackages = "com.example.jpa.repository.postgres"
)
public class PostgresConfig {

	@Bean
	@ConfigurationProperties(prefix = "postgres.datasource")
	@Primary
	public DataSource getPostgresDataSource() {
		return DataSourceBuilder.create().build();

	}

	@Bean
	@Primary
	public LocalContainerEntityManagerFactoryBean postgresEntityManager(EntityManagerFactoryBuilder emfb) {

		HashMap<String, Object> props = new HashMap<String, Object>();
		props.put("hibernate.hbm2ddl.auto", "create");
		props.put("hibernate.dialect", "org.hibernate.dialect.PostgreSQL95Dialect");
		return emfb.dataSource(getPostgresDataSource()).packages("com.example.jpa.entity.postgres").properties(props).build();

	}
	
	@Bean
	@Primary
	public PlatformTransactionManager postgresPlatformTransactionManager(@Qualifier("postgresEntityManager") EntityManagerFactory emf) {
		
		return new JpaTransactionManager(emf);
	}
}
