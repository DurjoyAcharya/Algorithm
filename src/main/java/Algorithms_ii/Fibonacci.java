package Algorithms_ii;

public class Fibonacci {
    private static long fib(int n)
    {
        if (n <= 1) return n;
        else return fib(n-1) + fib(n-2);
    }
    public static void main(String[] args) {

        var sc=new java.util.Scanner(System.in);
        int N= sc.nextInt();

        for (int i = 1; i <= N; i++)
            System.out.print(fib(i)+" ");
    }
}
