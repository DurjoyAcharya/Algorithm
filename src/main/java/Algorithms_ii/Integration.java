package Algorithms_ii;

import java.util.Scanner;

public class Integration {
    private static final Scanner sc=new Scanner(System.in);
    private static double Fn(double x)
    {
        return Math.sqrt(x);
    }

    public static void main(String[] args) {
        double a=0,b=0,s=0,y=0;
        System.out.println("Enter the interval: ");
        int n=sc.nextInt();
        System.out.println("Enter the lower limit: ");
        a=sc.nextDouble();
        System.out.println("Enter upper limit: ");
        b=sc.nextDouble();
        sc.close();
        double h=(b-a)/n;
        for (int i = 1; i <=n-1; i++) {
            s=s+Fn(a+i*h);
        }
        y=(Fn(a)+Fn(b)+2*s)*h/2;
        System.out.println("The value of Y is: "+y);

    }
}
