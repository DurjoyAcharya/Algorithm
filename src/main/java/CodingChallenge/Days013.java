package CodingChallenge;


//enormous known prime number using java

import java.io.IOException;
import java.math.BigInteger;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.Duration;
import java.time.Instant;
import java.util.function.Supplier;

public class Days013 {
    public static void main(String[] args) throws IOException {
        var theLargestKnownPrimeNumber=withElapsedTime(()->{
           var two= BigInteger.TWO;
           var large=two.pow(82_589_933);
           return large.subtract(BigInteger.ONE);
        });
        Files.writeString(Path.of("largeKnownPrime.txt"),theLargestKnownPrimeNumber.toString());

    }
    private static <T> T withElapsedTime(Supplier<T> supplier)
    {
        var start= Instant.now();
        var result=supplier.get();
        var duration= Duration.between(start,Instant.now());
        System.out.println("Time elapsed: "+duration.toMillis()+" ms");
        return result;
    }
    private static void getExecutionTime()
    {
        var start=Instant.now();
       // var result=supplier.get();
        for (int i = 0; i < 100; i++) {
            System.out.print(i);
        }
        var duration=Duration.between(start,Instant.now());
        System.out.println("Time elapsed: "+duration.toMillis()+" ms");
    }
}
