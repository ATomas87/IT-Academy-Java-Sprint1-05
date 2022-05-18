package n1exercici1;

import java.io.File;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ListDirectory {
    public static void main(String[] args) {
        listFilesFromDirectory(args[0]);
    }

    public static void listFilesFromDirectory(String directory){
        Stream.of(new File(directory).listFiles())
                .map(File::getName)
                .forEach(System.out::println);
    }

}
