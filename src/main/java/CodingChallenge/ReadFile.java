package CodingChallenge;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;

public class ReadFile {
    public static void main(String[] args) {
        long uniqueWord=CalculateUniqueWord("Example.txt");
        System.out.println(uniqueWord);
        System.out.println(cool(4));
    }
    private static long CalculateUniqueWord(String fileName)
    {
        try
        {
            return Files.lines(Path.of(fileName))
                    .flatMap(lines-> Arrays.stream((lines.split(" "))))
                            .distinct()
                            .count();
        }catch (IOException e)
        {
        throw new RuntimeException(e);
        }
    }
    static int cool(int n)
    {
        if (n>=5) return n;
        throw new RuntimeException("404 Not Found");
    }
}
