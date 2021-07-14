package oop.lab;



class Spring20{
    public void GPA()
    {
        System.out.println("I Got GPA-3.75");
    }
}
class Summer20 extends Spring20{
    @Override
    public void GPA()
    {
        System.out.println("I Got GPA-3.89");
    }
}
class Fall20 extends Summer20{
    @Override
    public void GPA()
    {
        System.out.println("I Got GPA-3.78");
    }

}

public class Answer2 extends Fall20{
    public static void main(String[] args) {
        Answer2 obj=new Answer2();
        obj.GPA();//Method Overriding GPA-3.78 From Fall20
        Summer20 obj1=new Summer20();
        obj1.GPA();//Method Overriding  GPA-3.89 From Summer20
        System.out.println("Thank you 🤍");
    }
}
