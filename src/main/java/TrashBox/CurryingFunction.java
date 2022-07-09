package TrashBox;

import java.util.function.Function;

public class CurryingFunction {
    public static void FunOfFun()
    {
        Function<Integer,Function<Integer,Integer>> curryingAdder
                = u->v->u+v;
        System.out.println(curryingAdder.apply(10).apply(40));

        //Function of Function triple
        Function<Integer,Function<Integer,Function<Integer,Integer>>>
                triple=a->b->c->a*b*c;
        System.out.println(triple.apply(10).apply(10).apply(20));
    }
    public static void main(String[] args) {
        FunOfFun();


    }
}
