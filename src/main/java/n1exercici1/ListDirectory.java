package n1exercici1;

import java.io.File;
import java.util.stream.Stream;

public class ListDirectory {
    public static void main(String[] args) {
        if (args.length > 0) {
            listFilesFromDirectory(args[0]);
        } else {
            System.out.println("Introduce la ruta de un directorio.");
        }
    }

    public static void listFilesFromDirectory(String directory) {
        Stream.of(new File(directory).listFiles())
                .map(File::getName)
                .forEach(System.out::println);
    }

}
