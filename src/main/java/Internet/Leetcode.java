package Internet;

import java.util.HashMap;

public class Leetcode {
    public static int RomanToInt(String s)
    {
        HashMap<Character,Integer> map=new HashMap<>();
        map.put('I' , 1);
        map.put('V' , 5);
        map.put('X' , 10);
        map.put('L' , 50);
        map.put('C' , 100);
        map.put('D' , 500);
        map.put('M' , 1000);
        int ans=0;
        for (int i = 0; i < s.length(); i++) {
            char ch=s.charAt(i);
            if (i+1<s.length() && map.get(ch) < map.get(s.charAt(i+1))) {
                ans -= map.get(ch);
            }
            else {
                ans += map.get(ch);
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        System.out.println(RomanToInt("II"));
    }
}
