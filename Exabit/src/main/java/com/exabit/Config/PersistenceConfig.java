package main.java.com.exabit.Config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.instrument.classloading.InstrumentationLoadTimeWeaver;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.Properties;

/**
 * Created by Casperinous on 14/1/2016.
 */

@Configuration
@EnableTransactionManagement
public class PersistenceConfig {


    @Autowired
    private Environment env;


    @Bean(name = "dataSource")
    DataSource dataSource(Environment env) {

        HikariConfig dataSourceConfig = new HikariConfig();
        dataSourceConfig.setDriverClassName("com.mysql.jdbc.Driver");
        dataSourceConfig.setJdbcUrl("jdbc:mysql://localhost:3306/Exabit?tinyInt1isBit=false&requireSSL=false&useUnicode=true&characterEncoding=UTF-8");
        dataSourceConfig.setUsername("root");
        dataSourceConfig.setPassword("ροοτ");
        dataSourceConfig.setConnectionTimeout(1000*60*60*4);
        dataSourceConfig.setMaximumPoolSize(15);
        dataSourceConfig.setMinimumIdle(2);
        dataSourceConfig.setConnectionTestQuery("select 1");
        dataSourceConfig.setInitializationFailFast(false);

        return new HikariDataSource(dataSourceConfig);
    }

    @Bean
    LocalContainerEntityManagerFactoryBean entityManagerFactory(
            DataSource dataSource, Environment env) {
        LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();

        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        vendorAdapter.setGenerateDdl(Boolean.TRUE);
        vendorAdapter.setShowSql(Boolean.TRUE);

        factory.setPersistenceUnitName("jpaData");
        factory.setDataSource(dataSource);
        factory.setJpaVendorAdapter(vendorAdapter);
        factory.setPackagesToScan("main.java.com.exabit.Entities");

        Properties jpaProperties = new Properties();
        jpaProperties.put("hibernate.dialect",	"org.hibernate.dialect.MySQL5Dialect");
        jpaProperties.put("hibernate.show_sql",	"true");
        jpaProperties.put("hibernate.format_sql","true");
        jpaProperties.put("hibernate.event.merge.entity_copy_observer",	"allow");
        jpaProperties.put("hibernate.connection.release_mode","after_transaction");
        jpaProperties.put("hibernate.hbm2ddl.auto", "validate");

        factory.setJpaProperties(jpaProperties);

        factory.afterPropertiesSet();
        factory.setLoadTimeWeaver(new InstrumentationLoadTimeWeaver());
        return factory;
    }

    @Bean
    JpaTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(entityManagerFactory);
        return transactionManager;
    }
}
