package com.utfpr.backendcategoriamusicasi.config;

import com.zaxxer.hikari.HikariDataSource;
import jakarta.persistence.EntityManagerFactory;
import org.hibernate.Hibernate;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaDialect;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@Configuration
@EnableJpaRepositories("com.utfpr.backendcategoriamusicasi.repository")
@EnableTransactionManagement
public class SpringDataConfig {

    public DataSource dataSource(){
        HikariDataSource ds = new HikariDataSource();
        //DataSourceBuilder ds = DataSourceBuilder.create();
        ds.setUsername("root");

        ds.setPassword("123");
        ds.setJdbcUrl("jdbc:mariadb://localhost:3306/dml");
        ds.setDriverClassName("org.mariadb.jdbc.Driver");

/*
        ds.setPassword("senharoot");
        ds.setJdbcUrl("jdbc:h2:mem:testdb");
        ds.setDriverClassName("org.h2.Driver");

 */

        return ds;
    }

    public EntityManagerFactory entityManagerFactory(){
        LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        vendorAdapter.setGenerateDdl(true);
        vendorAdapter.setShowSql(false);

        factory.setDataSource(dataSource());
        factory.setJpaVendorAdapter(vendorAdapter);
        factory.setPackagesToScan("com.utfpr.backendcategoriamusicasi.entity");
        factory.afterPropertiesSet();

        return factory.getObject();
    }

    public PlatformTransactionManager transactionManager(){

        JpaTransactionManager manager = new JpaTransactionManager();
        manager.setEntityManagerFactory(entityManagerFactory());
        manager.setJpaDialect(new HibernateJpaDialect());

        return manager;
    }


}
