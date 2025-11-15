package controller;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import doa.Dao;
import exception.StudentProjectException;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;
import model.Student;
import utils.DBWapper;

@WebListener
public class AppInitializer implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("🌐 Starting web application... checking DB connection...");
        try {
            Connection con = DBWapper.getConnection();
            if (con != null) {
                System.out.println("✅ Database successfully connected!");
                con.close();
            } else {
                System.out.println("❌ Failed to connect to the database!");
            }
        } catch (Exception e) {
            System.out.println("⚠️ Error connecting to database: " + e.getMessage());
            e.printStackTrace();
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("🧹 Shutting down web application...");
    }
}
