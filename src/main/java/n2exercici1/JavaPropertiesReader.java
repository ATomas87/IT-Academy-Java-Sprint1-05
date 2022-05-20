package n2exercici1;

import java.io.*;
import java.util.Date;
import java.util.Properties;

public class JavaPropertiesReader {
    public static void main(String[] args) {


        Properties properties = new Properties();
        try {
            properties.load(new FileInputStream("n2exercici1/config.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        String directoryToRead = properties.getProperty("directory");
        String destinationDir = properties.getProperty("destinationDir");
        String fileName = properties.getProperty("fileName");
        File fileToStore = new File(destinationDir, fileName);

        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileToStore))) {
            listFilesFromDirectory(directoryToRead, bufferedWriter, 0);
        } catch (IOException e) {
            System.out.println("Error escribiendo el archivo.");
            throw new RuntimeException(e);
        }

    }

    public static void listFilesFromDirectory(String directory, BufferedWriter bufferedWriter, int tabs) throws IOException {
        File currentDirectory = new File(directory);
        if (currentDirectory.exists() && currentDirectory.isDirectory()) {
            File[] filesInCurrentDirectory = currentDirectory.listFiles();
            for (File currentFile : filesInCurrentDirectory) {
                for (int i = 0; i < tabs; i++) {
                    bufferedWriter.write("\t");
                }
                if (currentFile.isDirectory()) {
                    bufferedWriter.write("D - " + currentFile.getName() + " - " + new Date(currentFile.lastModified()));
                    bufferedWriter.newLine();
                    listFilesFromDirectory(currentFile.getAbsolutePath(), bufferedWriter, tabs + 1);
                } else {
                    bufferedWriter.write("F - " + currentFile.getName() + " - " + new Date(currentFile.lastModified()));
                    bufferedWriter.newLine();
                }
            }
        } else {
            System.out.println("El directorio no existe.");
        }
    }

}
