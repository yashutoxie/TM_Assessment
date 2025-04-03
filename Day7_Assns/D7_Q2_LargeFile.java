import java.io.*;
import java.nio.file.*;
import java.util.*;
import java.util.concurrent.*;

class LargeFileProcessor {
    private static final String INPUT_FILE = "data.txt";
    private static final String OUTPUT_FILE = "output.txt";
    private static final int CHUNK_SIZE = 10_000;
    private static final int THREAD_POOL_SIZE = 4;
    private static final String TEMP_DIR = "temp_batches";

    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(THREAD_POOL_SIZE);

        File tempDir = new File(TEMP_DIR);
        if (!tempDir.exists()) tempDir.mkdir();

        try (BufferedReader reader = Files.newBufferedReader(Paths.get(INPUT_FILE))) {
            List<String> lines = new ArrayList<>();
            String line;
            int count = 0;
            int batch = 1;

            while ((line = reader.readLine()) != null) {
                lines.add(line);
                count++;

                if (count % CHUNK_SIZE == 0) {
                    List<String> batchLines = new ArrayList<>(lines);
                    String batchFile = TEMP_DIR + "/batch_" + batch++ + ".txt";
                    executor.submit(new FileProcessorTask(batchLines, batchFile));
                    lines.clear();
                }
            }

            if (!lines.isEmpty()) {
                String batchFile = TEMP_DIR + "/batch_" + batch + ".txt";
                executor.submit(new FileProcessorTask(lines, batchFile));
            }

        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }

        executor.shutdown();
        try {
            executor.awaitTermination(1, TimeUnit.MINUTES);
        } catch (InterruptedException e) {
            System.err.println("Thread execution interrupted!");
        }

        mergeBatchFiles();
        System.out.println("File processing complete!");
    }

    private static void mergeBatchFiles() {
        try (BufferedWriter writer = Files.newBufferedWriter(Paths.get(OUTPUT_FILE))) {
            File tempDir = new File(TEMP_DIR);
            File[] batchFiles = tempDir.listFiles((dir, name) -> name.startsWith("batch_"));

            if (batchFiles != null) {
                for (File batchFile : batchFiles) {
                    Files.lines(batchFile.toPath()).forEach(line -> {
                        try {
                            writer.write(line);
                            writer.newLine();
                        } catch (IOException e) {
                            System.err.println("Error writing to output: " + e.getMessage());
                        }
                    });
                    batchFile.delete();
                }
            }
        } catch (IOException e) {
            System.err.println("Error merging batch files: " + e.getMessage());
        }
    }
}

class FileProcessorTask implements Runnable {
    private final List<String> lines;
    private final String batchFile;

    public FileProcessorTask(List<String> lines, String batchFile) {
        this.lines = lines;
        this.batchFile = batchFile;
    }

    @Override
    public void run() {
        System.out.println("Processing batch file: " + batchFile);
        try (BufferedWriter writer = Files.newBufferedWriter(Paths.get(batchFile))) {
            for (String line : lines) {
                writer.write("Processed: " + line);
                writer.newLine();
            }
        } catch (IOException e) {
            System.err.println("Error processing file " + batchFile + ": " + e.getMessage());
        }
    }
}
