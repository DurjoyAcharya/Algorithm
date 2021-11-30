package Algorithms_i;

public class LinearSearch {
    public final int find(int value, int[] array)
    {
        for (int i = 0; i < array.length; i++) {
            int ivalue=array[i];
            if (value==ivalue)
            {
                return i;
            }
        }
        return Integer.MAX_VALUE;
    }
}
