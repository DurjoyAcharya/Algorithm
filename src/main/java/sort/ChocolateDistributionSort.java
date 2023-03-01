package sort;

import java.util.Arrays;

/**
 * Given an array of N integers where each value represents the number of chocolates in a packet.
 * Each packet can have a variable number of chocolates. T
 * Here are m students, the task is to distribute chocolate packets such that:
 * Each student gets one packet.
 * The difference between the number of chocolates in the packet with maximum chocolates and the packet with minimum chocolates given to the students is minimum.
 */
public class ChocolateDistributionSort {
    static int mindiff(int[] arr,int m){
        int n= arr.length;
        if (m==0||n==0)
            return 0;

        Arrays.sort(arr);
        if (n<m)
            return -1;
        int min_diff=Integer.MAX_VALUE;
        for (int i = 0; i+m -1< n; i++) {
            int diff=arr[i+m-1]-arr[i];
            if (diff<min_diff)
                min_diff=diff;
        }
       return min_diff;
    }

    public static void main(String[] args) {
        var arr=new int[]{12, 4,  7,  9,  2,  23, 25, 41, 30,
                40, 28, 42, 30, 44, 48, 43, 50};
        System.out.println(mindiff(arr,7));
    }
}
