package n1exercici3;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

public class ListDirectoryRecursiveToFile {
    public static void main(String[] args) {

        if (args.length > 0) {
            String fileToStore = System.getProperty("user.home") + File.separator + "filesList.txt";
            try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileToStore))) {
                listFilesFromDirectory(args[0], bufferedWriter, 0);
            } catch (IOException e) {
                System.out.println("Error escribiendo el archivo.");
            }
        } else {
            System.out.println("Por favor, introduce la ruta de un directorio.");
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
