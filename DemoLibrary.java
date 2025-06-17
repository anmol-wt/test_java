package com.example.demo.library;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Value;
import jakarta.annotation.PostConstruct;
import java.util.List;
import java.util.ArrayList;

// Annotation
@Service
public class DemoLibrary extends AbstractProcessor implements ProcessorInterface<String> {

    // Static block
    static {
        System.out.println("Static block executed in DemoLibrary");
    }

    // Enum
    public enum Status {
        ACTIVE, INACTIVE
    }

    // Inner Class
    public class InnerWorker {
        public void doWork() {
            System.out.println("InnerWorker working...");
        }
    }

    // Static Nested Class
    public static class StaticHelper {
        public static void help() {
            System.out.println("StaticHelper helping...");
        }
    }

    // Field with Spring value injection
    @Value("${demo.message:Default Hello}")
    private String message;

    // Record (Java 16+)
    public record UserRecord(String name, int age) {}

    // Generic Method
    public <T> void printGeneric(T data) {
        System.out.println("Generic data: " + data);
    }

    // Public method
    public String getMessage() {
        return message;
    }

    // Lifecycle Hook
    @PostConstruct
    public void init() {
        System.out.println("DemoLibrary initialized");
    }

    // Interface method implementation
    @Override
    public void process(String input) {
        System.out.println("Processing: " + input);
    }

    // Overloaded method
    public void process(String input, int count) {
        System.out.println("Processing: " + input + " x" + count);
    }
}

// Interface
interface ProcessorInterface<T> {
    void process(T input);
}

// Abstract class
abstract class AbstractProcessor {
    public void log(String msg) {
        System.out.println("LOG: " + msg);
    }
}
