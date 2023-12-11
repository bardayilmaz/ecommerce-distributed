package com.example.ecommercemongodb.configuration;

import com.example.ecommercemongodb.entity.Customer;
import com.example.ecommercemongodb.entity.Order;
import com.example.ecommercemongodb.entity.Product;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        basePackages = "com.example.ecommercemongodb.repository.write",
        entityManagerFactoryRef = "leaderEntityManagerFactory",
        transactionManagerRef = "leaderTransactionManager"
)
public class LeaderJpaConfiguration {

    @Bean
    public LocalContainerEntityManagerFactoryBean leaderEntityManagerFactory(
            @Qualifier("leaderDataSource") DataSource dataSource,
            EntityManagerFactoryBuilder builder) {
        Map<String, Object> properties = new HashMap<String, Object>();
        properties.put("hibernate.hbm2ddl.auto", "validate");
        return builder.dataSource(dataSource)
                .packages("com.example.ecommercemongodb.entity")
                .properties(properties)
                .build();
    }

    @Bean
    public PlatformTransactionManager leaderTransactionManager (
            @Qualifier("leaderEntityManagerFactory") LocalContainerEntityManagerFactoryBean leaderEntityManagerFactory) {
        return new JpaTransactionManager(Objects.requireNonNull(leaderEntityManagerFactory.getObject()));
    }
}
