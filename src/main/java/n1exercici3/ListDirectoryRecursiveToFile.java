package n1exercici3;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class ListDirectoryRecursiveToFile {
    public static void main(String[] args) throws IOException {

        String fileToStore = System.getProperty("user.home")+ File.separator + "filesList.txt";
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileToStore))) {
            listFilesFromDirectory(args[0], fileToStore, bufferedWriter, 0);
        }
    }

    public static void listFilesFromDirectory(String directory, String fileToStore, BufferedWriter bufferedWriter, int tabs) throws IOException {
        File currentDirectory = new File(directory);
        if (currentDirectory.exists()) {
            File[] filesInCurrentDirectory = currentDirectory.listFiles();
            for (File currentFile : filesInCurrentDirectory) {
                for (int i = 0; i < tabs; i++){
                    bufferedWriter.write("\t");
                }
                if (currentFile.isDirectory()) {
                    bufferedWriter.write("D - " + currentFile.getName() + " - " + new Date(currentFile.lastModified()));
                    bufferedWriter.newLine();
                    listFilesFromDirectory(currentFile.getAbsolutePath(), fileToStore, bufferedWriter, tabs + 1);
                } else {
                    bufferedWriter.write("F - " + currentFile.getName() + " - " + new Date(currentFile.lastModified()));
                    bufferedWriter.newLine();
                }
            }
        }
    }

}
