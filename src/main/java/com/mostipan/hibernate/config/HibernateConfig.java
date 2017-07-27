package com.mostipan.hibernate.config;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;

import javax.sql.DataSource;
import java.util.Properties;

/**
 * Created by anton
 */
@Configuration
public class HibernateConfig {

    private final Environment environment;

    @Autowired
    public HibernateConfig(Environment environment) {
        this.environment = environment;
    }

    @Bean
    public LocalSessionFactoryBean localSessionFactoryBean() {
        LocalSessionFactoryBean localSessionFactoryBean = new LocalSessionFactoryBean();
        localSessionFactoryBean.setDataSource(dataSource());
        localSessionFactoryBean.setPackagesToScan(environment.getProperty("scan.classes"));
        localSessionFactoryBean.setHibernateProperties(propertiesHibernate());
        return localSessionFactoryBean;
    }


    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(environment.getProperty("db.driver.class.name"));
        dataSource.setUrl(environment.getProperty("db.url"));
        dataSource.setUsername(environment.getProperty("db.userName"));
        dataSource.setPassword(environment.getProperty("db.password"));
        return dataSource;
    }

    private Properties propertiesHibernate() {
        Properties properties = new Properties();

        if (environment.getProperty("hibernate.dialect") != null)
            properties.setProperty("hibernate.dialect", environment.getProperty("hibernate.dialect"));
        if (environment.getProperty("hibernate.show_sql") != null)
            properties.setProperty("hibernate.show_sql", environment.getProperty("hibernate.show_sql"));
        if (environment.getProperty("hibernate.format_sql") != null)
            properties.setProperty("hibernate.format_sql", environment.getProperty("hibernate.format_sql"));
        if (environment.getProperty("hibernate.connection.pool_size") != null)
            properties.setProperty("hibernate.connection.pool_size", environment.getProperty("hibernate.connection.pool_size"));

        if (environment.getProperty("hibernate.connection.pool_size") != null)
            properties.setProperty("hibernate.connection.pool_size", environment.getProperty("hibernate.connection.pool_size"));
        if (environment.getProperty("hibernate.cache.use_structured_entries") != null)
            properties.setProperty("hibernate.cache.use_structured_entries", environment.getProperty("hibernate.cache.use_structured_entries"));
        if (environment.getProperty("hibernate.cache.use_second_level_cache") != null)
            properties.setProperty("hibernate.cache.use_second_level_cache", environment.getProperty("hibernate.cache.use_second_level_cache"));
        if (environment.getProperty("hibernate.cache.use_query_cache") != null)
            properties.setProperty("hibernate.cache.use_query_cache", environment.getProperty("hibernate.cache.use_query_cache"));
        if (environment.getProperty("hibernate.cache.provider_class") != null)
            properties.setProperty("hibernate.cache.provider_class", environment.getProperty("hibernate.cache.provider_class"));
        if (environment.getProperty("hibernate.cache.region.factory_class") != null)
            properties.setProperty("hibernate.cache.region.factory_class", environment.getProperty("hibernate.cache.region.factory_class"));
        if (environment.getProperty("hibernate.hbm2ddl.auto") != null)
            properties.setProperty("hibernate.hbm2ddl.auto", environment.getProperty("hibernate.hbm2ddl.auto"));

        return properties;
    }

    @Bean
    @Autowired
    public HibernateTransactionManager hibernateTransactionManager(SessionFactory s) {
        HibernateTransactionManager hibernateTransactionManager = new HibernateTransactionManager();
        hibernateTransactionManager.setSessionFactory(s);
        return hibernateTransactionManager;
    }
}
