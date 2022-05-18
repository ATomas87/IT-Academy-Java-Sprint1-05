package n1exercici2;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ListDirectoryRecursive {
    public static void main(String[] args) {
        listFilesFromDirectory(args[0], 0);
    }

    public static void listFilesFromDirectory(String directory, int tabs) {
        File currentDirectory = new File(directory);
        File[] filesAndFolders = currentDirectory.listFiles();
        if (filesAndFolders != null && filesAndFolders.length > 0) {
            Arrays.sort(filesAndFolders);
            for (File file : filesAndFolders) {
                for (int i = 0; i < tabs; i++) {
                    System.out.print("\t");
                }
                if (file.isDirectory()) {
                    System.out.println("D - " + file.getName() + " - " + new Date(file.lastModified()));
                    listFilesFromDirectory(file.getAbsolutePath(), tabs + 1);
                } else {
                    System.out.println("F - " + file.getName() + " - " + new Date(file.lastModified()));
                }
            }
        }
    }

}
