package CodingChallenge;

//avoid recursive invocation on computeIfAbsent in hash map

import java.math.BigInteger;
import java.util.Map;
import java.util.concurrent.ConcurrentSkipListMap;

public class Day002 {
    static Map<Integer,BigInteger> cache=new ConcurrentSkipListMap<>(
            Map.of(0,BigInteger.ZERO,1,BigInteger.ONE));
    static Map<Integer,Long> cache2=new ConcurrentSkipListMap<>(
            Map.of(0,0L,1,1L));
    public static BigInteger fibonacci(int n)
    {
        return cache.computeIfAbsent(n,key->fibonacci(key-1).add(fibonacci(key-2)));
    }

    public static Long Fibo(int n)
    {
        if (!cache2.containsKey(n))
        {
            Long compute=Fibo(n-1)+Fibo(n-2);
            cache2.put(n,compute);
        }
    return cache2.get(n);
    }
    public static void main(String[] args) {
        var n=10;
        System.out.println("Sum Of Nth Fibonacci: "+fibonacci(10));
//        for (int i = 0; i < n; i++) {
//            System.out.print(fibonacci(i)+" ");
//        }
        //System.out.println(Fibo(100));
        System.out.println("Ok Thank you 🙄");
    }
}
