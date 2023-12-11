package com.example.ecommercemongodb.configuration;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

import java.util.Random;

public class CustomRoutingDataSource extends AbstractRoutingDataSource {

    @Override
    protected Object determineCurrentLookupKey() {
        // Implement logic to determine the current data source key
        // (e.g., choose a follower randomly)
        // Return the name of the data source (follower)
        return determineDataSourceKeyRandomly();
    }

    private String determineDataSourceKeyRandomly() {
        System.out.println("SAKASJFAEIGKAEOGL");
        String[] array = {"follower", "leader"};
        Random random = new Random();
         String name = array[random.nextInt( 2)];
        System.out.println("name : "+ name);
        return name;
    }
}
