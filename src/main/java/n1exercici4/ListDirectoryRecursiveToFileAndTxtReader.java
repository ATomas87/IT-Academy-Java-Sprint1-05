package n1exercici4;

import java.io.*;
import java.util.Date;

public class ListDirectoryRecursiveToFileAndTxtReader {
    public static void main(String[] args) {

        if (args.length > 0 && !args[0].contains(".txt")) {
            String fileToStore = System.getProperty("user.home") + File.separator + "filesList.txt";
            try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileToStore))) {
                listFilesFromDirectory(args[0], bufferedWriter, 0);
            } catch (IOException e) {
                System.out.println("Error creando el archivo.");
            }
        } else if (args.length > 0 && args[0].contains(".txt")) {
            try {
                readTxtFile(args[0]);
            } catch (IOException e) {
                System.out.println("Error leyendo el archivo.");
            }
        } else {
            System.out.println("Por favor, introduce la ruta de un directorio o de un archivo .txt.");
        }
    }

    private static void readTxtFile(String arg) throws IOException {
        File txtFile = new File(arg);
        FileReader fileReader = new FileReader(txtFile);
        int character;
        while ((character = fileReader.read()) != -1) {
            System.out.print((char) character);
        }
        fileReader.close();
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
