package CodingChallenge;


import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class Behevior {

    public static Integer Sum(List<Integer> num, Predicate<Integer> p)
    {
        int total=0;
        for (int n:num)
        {
            if (p.test(n))
                total+=n;
        }
        return total;
    }
    public static void main(String[] args) {
//       var nums= List.of(1,2,3,4,5);
//       System.out.println(Sum(nums,n->true));
//       System.out.println(Sum(nums,n->n!=1&&n!=2));
        var lst=List.of(1,2,3,4,5,6,7,8,9,10);
        var list1=new ArrayList<Integer>();
        for (int n:lst)
        {
            if (isEven(n)) list1.add(n);
        }
        var list2=new ArrayList<Integer>();
        for (int n:lst)
        {
            if (isGT5(n))
                list2.add(n);
        }
    list1.stream().filter(Behevior::isEven)
            .findFirst().get();
    }


    //Lazy Code Section...................
    public static boolean isEven(int n)
    {
        System.out.println("isEven: "+n);
        return n%2==0;
    }
    public static Double DoubleIt(double x)
    {
        System.out.println("Double It: "+x);
        return 2*x;
    }
    public static boolean isGT5(int n)
    {
        System.out.println("is grater than: "+n);
        return n>5;
    }
}
