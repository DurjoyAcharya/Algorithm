package CodingChallenge;

public class DeSerial {

    public static void main(String[] args) {
      A a= A.getInstance();
        System.out.println(a.x);
        System.out.println(a.fuck);
    }
}

//===============Object Creation via factory method==========================
class A {
    final  int x=555;
    int fuck;
    private A()
    {
        fuck=4156;
    }
    static A getInstance()
    {
        return new A();
    }
}