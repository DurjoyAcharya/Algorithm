package Internet;

public class Solution {
    public static String intToRoman(int num)
    {
      int[] arr={1,4,5,9,10,40,50,90,100,400,500,900,1000};
      String[] str={"I","IV","V","IX","X","XL","L","XC","C","CD","D","CM","M"};
      int i= 12;
      String ans="";
      while (num>0)
      {
          int div=num/arr[i];
          num=num % arr[i];
          while (div>0)
          {
              ans+=str[i];
              div--;
          }
          i--;
      }
      return ans;
    }
    public static void main(String[] args) {
        System.out.println(intToRoman(4));
    }
}