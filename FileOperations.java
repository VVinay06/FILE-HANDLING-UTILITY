import java.io.*;
import java.util.Scanner;

public class FileOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String fileName = "example.txt";

        try {
            // Create or write to a file
            System.out.println("Enter text to write to the file:");
            String inputText = scanner.nextLine();
            writeFile(fileName, inputText);

            // Read the content of the file
            System.out.println("\nReading file content:");
            readFile(fileName);

            // Modify the file content
            System.out.println("\nEnter new text to append to the file:");
            String additionalText = scanner.nextLine();
            modifyFile(fileName, additionalText);

            // Read the modified content
            System.out.println("\nFile content after modification:");
            readFile(fileName);

        } catch (IOException e) {
            System.err.println("An error occurred: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }

    // Method to write to a file
    private static void writeFile(String fileName, String content) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            writer.write(content);
            System.out.println("Text written to " + fileName);
        }
    }

    // Method to read from a file
    private static void readFile(String fileName) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        }
    }

    // Method to append to a file
    private static void modifyFile(String fileName, String additionalText) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true))) { // 'true' enables appending
            writer.newLine();
            writer.write(additionalText);
            System.out.println("Text appended to " + fileName);
        }
    }
}
