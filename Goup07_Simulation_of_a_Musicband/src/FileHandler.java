import java.io.File;
import java.io.IOException;

public class FileHandler {
    public static void main(String[] args) {
        String fileName = "exampleFile.txt";
        
        try {
            if (!fileExists(fileName)) {
                createFile(fileName);
                System.out.println("File created successfully!");
            } else {
                System.out.println("File already exists!");
            }
        } catch (IOException e) {
            System.out.println("An error occurred while handling the file: " + e.getMessage());
        }
    }

    public static boolean fileExists(String fileName) {
        File file = new File(fileName);
        return file.exists();
    }

    public static void createFile(String fileName) throws IOException {
        File file = new File(fileName);
        if (file.createNewFile()) {
            System.out.println("File created: " + file.getName());
        } else {
            System.out.println("File already exists.");
        }
    }
}
