package org.zero.lamda;

import java.util.List;

public class Iteration {

    public static void main(String[] args) {
            var list= List.of(1,2,3,4,5,6,7,8,9,10);
            list.forEach(System.out::println);
            System.out.println(isEven(7));
        System.out.println(aDoubleIt(4.0));
    }

    //Lazy Code
    public static boolean isEven(int n)
    {
        System.out.println("is Even: "+n);
        return n%2==0;
    }
    public static Double aDoubleIt(double x){
        System.out.println("Double It: "+ x);
        return 2*x;
    }
}
