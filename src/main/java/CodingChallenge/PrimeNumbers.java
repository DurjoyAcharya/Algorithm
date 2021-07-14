package CodingChallenge;


import java.util.Arrays;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

public class PrimeNumbers {
    private static final int size=20;

    public static void main(String[] args) {
        System.out.println(
                IntStream.rangeClosed(1,size)
                .boxed().flatMap(i->IntStream.rangeClosed(
                        1,i
                ).mapToObj(j->new int[]{i,j}))
                .peek(a-> System.out.println(Arrays.toString(a)))
                .filter(a->isPrime(a[0]+a[1]))
                .map(Arrays::toString)
                        .collect(toList()));
    }
    public static boolean isPrime(int n)
    {
        return IntStream.rangeClosed(2,(int)Math.sqrt(n)).noneMatch(i->n%i==0);
    }
}
