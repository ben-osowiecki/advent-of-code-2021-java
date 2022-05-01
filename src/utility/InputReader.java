package utility;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;

public class InputReader {

    private static final String RESOURCE_PATH = "resources/";
    private static final String DAY = "day";
    private final int dayNumber;

    public InputReader(int dayNumber) {
        this.dayNumber = dayNumber;
    }

    public List<String> readLinesToStringList(String fileName) {
        try {
            return Files.readAllLines(getPath(fileName));
        } catch (IOException ioException) {
            return Collections.emptyList();
        }
    }

    public List<Integer> readLinesToIntegerList(String fileName) {
        return readLinesToStringList(fileName).stream().map(Integer::valueOf).toList();
    }

    private Path getPath(String fileName) {
        return Paths.get(RESOURCE_PATH, DAY+dayNumber, fileName);
    }
}
