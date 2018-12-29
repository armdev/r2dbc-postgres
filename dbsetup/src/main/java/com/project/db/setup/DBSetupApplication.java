package com.project.db.setup;

import org.flywaydb.core.Flyway;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DBSetupApplication {
    public static void main(String[] args) {       
        Flyway flyway = Flyway.configure().dataSource("jdbc:postgresql://postgresnode:5432/socnet", "postgres", "socnet").load();        
        flyway.migrate();
    }
}
