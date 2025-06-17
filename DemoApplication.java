package com.example.demo;

import com.example.demo.library.DemoLibrary;
import com.example.demo.library.DemoLibrary.Status;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// Main Spring Boot App
@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

    private final DemoLibrary demoLibrary;

    // Constructor injection
    public DemoApplication(DemoLibrary demoLibrary) {
        this.demoLibrary = demoLibrary;
    }

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    // Startup logic
    @Override
    public void run(String... args) throws Exception {
        System.out.println("Spring Boot App Started");

        // Use methods
        demoLibrary.process("Hello");
        demoLibrary.process("World", 3);

        // Use generic
        demoLibrary.printGeneric(123);
        demoLibrary.printGeneric("Generic String");

        // Use enum
        Status currentStatus = Status.ACTIVE;
        System.out.println("Status: " + currentStatus);

        // Use record
        DemoLibrary.UserRecord user = new DemoLibrary.UserRecord("Anmol", 25);
        System.out.println("UserRecord: " + user);

        // Use inner class
        DemoLibrary.InnerWorker worker = demoLibrary.new InnerWorker();
        worker.doWork();

        // Use static nested class
        DemoLibrary.StaticHelper.help();
    }
}
