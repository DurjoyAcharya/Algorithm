package CodingChallenge;
//new keyword
//auto boxing
//deserialization
//factory method
//clone method

class Data{
    String name;
    int id;
}
public class Tast {

    public static void main(String[] args) {
        Data[] d;
        d=new Data[2];
        d[0]=new Data();
        d[0].id=1020;


        System.out.println(d[0].id);
    }
}
