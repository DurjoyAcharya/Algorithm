package Algorithms_i;

public class BinarySearch {
    public int search(int[] nums, int target) {
            int left=0;
            int right= nums.length-1;
            return Binary(nums,left,right,target);
    }
    public int Binary(int[] nums,int left,int right,int target)
    {
       if (right>=left) {
           int mid = left + (right - left)/ 2;
           if (nums[mid] == target)
               return mid;
           if (nums[mid] > target)
               return Binary(nums, left, mid-1, target);
           return Binary(nums, mid + 1, right, target);
       }
        return -1;
    }
}
