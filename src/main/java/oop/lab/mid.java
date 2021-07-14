package oop.lab;


abstract class Vachile{
    void fual(){
        System.out.println("Must need vechile");
    }
    abstract void ac();
    abstract void powerWindow();
}
abstract class car extends Vachile{

    @Override
    void ac() {
        System.out.println("Car Must have ac");
    }
}
abstract class Swift extends Vachile
{
    @Override
    void powerWindow() {
        System.out.println("Swift Have power windows");
    }
}
public class mid extends Swift {
    public static void main(String[] args) {
       mid m=new mid();
       m.fual();
       m.powerWindow();
       m.ac();
     }

    @Override
    void ac() {
        System.out.println("Main AC");
    }
}
