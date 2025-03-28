import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

public class MemoryLeakDetector {

    // Static list to simulate strong references causing memory leaks
    private static List<Object> leakList = new ArrayList<>();

    public static void main(String[] args) throws InterruptedException {
        System.out.println("Simulating memory leak...");
        simulateMemoryLeak();

        System.out.println("\nMonitoring memory usage...");
        monitorMemory();

        System.out.println("\nFixing memory leaks...");
        fixMemoryLeak();
    }

    // Simulate a memory leak scenario with unclosed resource
    private static void simulateMemoryLeak() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("test.txt"));
            // Simulating adding objects to a static list
            for (int i = 0; i < 10000; i++) {
                leakList.add(new Object());
            }
            // Unclosed reader intentionally (this is a bad practice)
            // Fix: Use try-with-resources or explicitly close resources
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Monitor heap memory usage
    private static void monitorMemory() {
        Runtime runtime = Runtime.getRuntime();
        System.out.println("Total Memory: " + runtime.totalMemory());
        System.out.println("Free Memory: " + runtime.freeMemory());
        System.out.println("Used Memory: " + (runtime.totalMemory() - runtime.freeMemory()));
    }

    // Fix memory leaks
    private static void fixMemoryLeak() throws InterruptedException {
        // Clear strong references to simulate garbage collection
        leakList = null;

        // Force garbage collection
        System.gc();
        Thread.sleep(1000); // Allow time for GC to complete

        System.out.println("Memory leak fixed. Monitoring memory again...");
        monitorMemory();

        System.out.println("Simulating proper resource handling...");
        properResourceHandling();
    }

    // Correctly handle resources to prevent memory leaks
    private static void properResourceHandling() {
        // Using WeakReference for cache-like data
        WeakReference<List<Object>> weakList = new WeakReference<>(new ArrayList<>());
        weakList.get().add(new Object());

        // Using try-with-resources for safe resource closing
        try (BufferedReader reader = new BufferedReader(new FileReader("test.txt"))) {
            // Process the file safely
            System.out.println("File processing completed successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
