package controller;

import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;

public class AppInitializer implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        // Your initialization code goes here
        System.out.println("Server application started. Initializing resources...");
        // Example: Initialize a database connection pool or load configuration
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        // Your cleanup code goes here
        System.out.println("Server application is shutting down. Cleaning up resources...");
    }
}