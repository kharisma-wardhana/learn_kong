package com.learn.user.datasource.mysql.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Objects;

@Configuration
@EnableJpaRepositories(
        basePackages = "com.learn.user.datasource.mysql.repo",
        entityManagerFactoryRef = "masterEntityManagerFactory",
        transactionManagerRef = "masterTransactionManager"
)
@EnableTransactionManagement
public class MysqlConfig {
    @Bean
    @Primary
    @ConfigurationProperties("spring.datasource.master")
    public DataSourceProperties masterProperties() {
        return new DataSourceProperties();
    }

    @Bean
    @Primary
    @ConfigurationProperties("spring.datasource.master.configuration")
    public DataSource masterDataSource() {
        return masterProperties().initializeDataSourceBuilder().build();
    }

    @Primary
    @Bean(name = "masterEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean masterManagerFactory(EntityManagerFactoryBuilder builder) {
        LocalContainerEntityManagerFactoryBean entityManagerFactory = builder
                .dataSource(masterDataSource())
                .packages("com.learn.user.datasource.mysql.entity")
                .build();

        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        vendorAdapter.setGenerateDdl(true);
        entityManagerFactory.setJpaVendorAdapter(vendorAdapter);

        return entityManagerFactory;
    }

    @Primary
    @Bean
    public PlatformTransactionManager masterTransactionManager(
            final @Qualifier("masterEntityManagerFactory") LocalContainerEntityManagerFactoryBean masterManagerFactory) {
        return new JpaTransactionManager(Objects.requireNonNull(masterManagerFactory.getObject()));
    }

}
