package com.fisi.inventario.configuration

import java.util.Properties
import javax.persistence.EntityManagerFactory
import javax.sql.DataSource
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.PropertySource
import org.springframework.core.env.Environment
import org.springframework.data.jpa.repository.config.EnableJpaRepositories
import org.springframework.jdbc.datasource.DriverManagerDataSource
import org.springframework.orm.jpa.JpaTransactionManager
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter
import org.springframework.transaction.PlatformTransactionManager
import org.springframework.transaction.annotation.EnableTransactionManagement

@Configuration
@PropertySource("classpath:application.properties")
@EnableJpaRepositories(basePackages = arrayOf("com.fisi.inventario.repository"))
@EnableTransactionManagement
open class RepositoryConfiguration {
	@Bean
	open fun dataSource(environment: Environment): DataSource {
		val dataSource = DriverManagerDataSource()
        dataSource.setDriverClassName(environment.getProperty("spring.datasource.driver-class-name") as String)
		dataSource.setUrl(environment.getProperty("spring.datasource.url"))
		dataSource.setUsername(environment.getProperty("spring.datasource.username"))
		dataSource.setPassword(environment.getProperty("spring.datasource.password"))
		return dataSource
	}

	@Bean
	open fun entityManagerFactory(dataSource: DataSource): EntityManagerFactory {
		val adapter = HibernateJpaVendorAdapter()
		adapter.setShowSql(true)
		val factory = LocalContainerEntityManagerFactoryBean()
		val properties = Properties()
		properties.put("hibernate.format_sql", true)
		factory.setJpaProperties(properties)
		factory.setJpaVendorAdapter(adapter)
		factory.setPackagesToScan("com.fisi.inventario.entity")
		factory.setDataSource(dataSource)
		factory.afterPropertiesSet()
		return factory.getObject() as EntityManagerFactory
	}

	@Bean
	open fun transactionManager(entityManagerFactory: EntityManagerFactory): PlatformTransactionManager {
		val transactionManager = JpaTransactionManager()
		transactionManager.setEntityManagerFactory(entityManagerFactory)
		return transactionManager
	}
}