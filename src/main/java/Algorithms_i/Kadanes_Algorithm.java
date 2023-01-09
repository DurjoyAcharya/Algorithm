package Algorithms_i;

import java.util.Arrays;

/**
 * Kadane’s Algorithm — (Dynamic Programming) — How and Why does it Work?
 * https://medium.com/@rsinghal757/kadanes-algorithm-dynamic-programming-how-and-why-does-it-work-3fd8849ed73d
 */
public class Kadanes_Algorithm {

    //general approches
    public int SubarraySum(int[] arr)
    {
        int max_far_array=Integer.MIN_VALUE;
        int max_ending_here=0;
        for (int i = 0; i < arr.length; i++) {
            max_ending_here+=arr[i];
            if (max_far_array<max_ending_here)
                max_far_array=max_ending_here;
            if (max_ending_here<0)
                max_ending_here=0;
        }
        return  max_far_array;
    }

    public static void main(String[] args) {
        System.out.println(new Kadanes_Algorithm()
                .SubarraySum(new int[]{-2,-3,4,-1,-2,1,5,-3}));

    }
}
