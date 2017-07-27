package com.mostipan.hibernate.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Created by anton
 */
@Configuration
@EnableTransactionManagement
@ComponentScan({
        "com.mostipan.hibernate.*"
})
@PropertySource("classpath:hibernate.properties")
public class ApplicationHibernateContext {
}
