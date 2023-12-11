package com.example.ecommercemongodb.configuration;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@Configuration
@RequiredArgsConstructor
public class DataSourceConfig {

    private final LeaderDataSourceConfig leaderDataSource;
    private final FollowerDataSourceConfig followerDataSourceConfig;

    @Bean
//    @Primary
    public DataSource dataSource() {
        CustomRoutingDataSource routingDataSource = new CustomRoutingDataSource();
        Map<Object, Object> dataSourceMap = new HashMap<>();
        dataSourceMap.put("leaderDataSource", leaderDataSource.leaderDataSource());
        dataSourceMap.put("followerDataSource", followerDataSourceConfig.followerDataSource());
        routingDataSource.setTargetDataSources(dataSourceMap);
        routingDataSource.setDefaultTargetDataSource(leaderDataSource.leaderDataSource());
        System.out.println("0hahahahahahah");
        return routingDataSource;
    }
}
