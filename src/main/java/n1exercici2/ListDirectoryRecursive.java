package n1exercici2;

import java.io.File;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ListDirectory {
    public static void main(String[] args) {
        List<String> files = listFilesFromDirectory(args[0]);

        for (String file : files){
            System.out.println(file);
        }
    }

    public static List<String> listFilesFromDirectory(String directory){
        return Stream.of(new File(directory).listFiles())
                .map(File::getName)
                .collect(Collectors.toList());
    }

}
