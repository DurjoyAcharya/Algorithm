package oop.lab;


public class Answer1 {
    public static void main(String[] args) {
        boolean bool=true;
        do {
            System.out.println("Enter The Options Given Bellow: ");
            System.out.println("1. CSE 307");
            System.out.println("2. MAT 103");
            System.out.println("3. CSE 115");
            System.out.println("4. CSE 116");
            System.out.println("5. EEE 201");
            java.util.Scanner sc=new java.util.Scanner(System.in);
            int option=sc.nextInt();
            switch (option){
                case 1:
                    System.out.println("Discrete Mathematices\n");
                    break;
                case 2:
                    System.out.println("Analytical & Vector Geomtry\n");
                    break;
                case 3:
                    System.out.println("Object Oriented Programming \n");
                    break;
                case 4:
                    System.out.println("Object Oriented Programming Laboratory\n");
                    break;
                case 5:
                    System.out.println("Electrical Engineering ");
                    break;
                default:
                    System.out.println("Please Enter Valid Keyword");
                    bool=false;
            }
        }while (bool);
        System.out.println("Thank you ❤");
    }
}
