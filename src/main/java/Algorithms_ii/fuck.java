package Algorithms_ii;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class fuck {
    public List<Integer> number=null;


    public  void setNumber(Integer...nums)
    {
        this.number=Arrays.stream(nums).collect(Collectors.toList());

       }
    public static void main(String... args) {
            int[] arr=new int[]{1,2,3,4,5};
           var obj=new fuck();
           Integer[] ir=new Integer[5];
           ir[0]=12;ir[1]=13;ir[2]=14;
           obj.setNumber(ir);
           print(obj.number);

            //print(arr);
    }
    private static void print(List<Integer> arr)
    {
        arr.forEach(e-> {System.out.println(e);});
    }

}
