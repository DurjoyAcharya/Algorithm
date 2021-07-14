package CodingChallenge;


import java.util.Scanner;

public class maping {
    private static final Scanner sc=new Scanner(System.in);
    public static void main(String[] args) {
        String s1=null;
        String s2=null;

        System.out.println("Enter First String: ");
        s1= sc.nextLine();
        System.out.println("Enter Second String: ");
        s2= sc.nextLine();
        System.out.println("Some String Operation are given bellow: ");
        System.out.println("Char At(2): "+s1.charAt(2));
        System.out.println("Length of S1: "+s1.length());
        System.out.println("Length of S2: "+s2.length());
        System.out.println("Sub-String StartWith: "+s1.substring(2));
        System.out.println("Sub String Specific: "+s2.substring(1,3));
        System.out.println("Contain Operation: "+s1.contains("D"));
        System.out.println("isEmpty Operation: "+s2.isEmpty());
        System.out.println("String Concrete operation: "+s1.concat(s2));
        System.out.println("Replace Operation:  "+s1.replace("a","b"));
        System.out.println("equalIgnoreCase: "+s1.equalsIgnoreCase(s2));
        System.out.println("intindexof: "+s1.indexOf('a'));
        System.out.println("to LowerCase: "+s1.toLowerCase());
        System.out.println("to UpperCase: "+s2.toUpperCase());
        System.out.println(".tream operation: "+s2.trim());
    }

}
