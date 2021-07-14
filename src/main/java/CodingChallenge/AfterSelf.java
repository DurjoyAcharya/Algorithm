package CodingChallenge;

import java.util.ArrayList;
import java.util.List;

public class AfterSelf {
    public List<Integer> countSmaller(int[] nums) {
        List ls=new ArrayList();
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                if (nums[i]>nums[j])
                {
                    if (nums.length>j)
                        ls.add(0);
                    else
                     ls.add(nums[j]);
                }
            }
        }
        return ls;
    }
    public static void main(String[] args) {
        int[] arr={5,2,6,1};
        new AfterSelf().countSmaller(arr).stream()
                .forEach(e->{
                    System.out.println(e);
                });
    }

}
