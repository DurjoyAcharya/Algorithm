package Algorithms_ii;


public class fibonaccis {
   private static int[] fib(int n)
    {
        int temp[] = new int[n+1];
        int i;
        temp[0] = 0;
        temp[1] = 1;
        for (i = 2; i <= n; i++)
        {
            temp[i] = temp[i-1] + temp[i-2];
        }
        return temp;
    }
    public static void main(String[] args) {
        int n = 9;
        java.util.Arrays.stream(fib(n)).forEach(e->{
            System.out.println(e+" ");
        });
    }
}
