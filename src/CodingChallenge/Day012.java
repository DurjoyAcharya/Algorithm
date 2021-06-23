package CodingChallenge;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Stream;

@FunctionalInterface
interface Coffee {
    List<String> ingredients();

    static Coffee withSaltedCaramelFudge(Coffee coffee) {
        return () -> coffee.add("Salted Caramel Fudge");
    }

    default List<String> add(String item) {
        return new ArrayList<>(ingredients()) {{
            add(item);
        }};
    }

    static Coffee withSweetenedMilk(Coffee coffee) {
        return () -> coffee.add("Sweetened Milk");
    }

    static Coffee withDarkCookieCrumb(Coffee coffee) {
        return () -> coffee.add("Dark Cookie Crumb");
    }
    static Coffee withVanillaAlmondExtract(Coffee coffee) {
        return () -> coffee.add("Vanilla/Almond Extract");
    }
    record CoffeeCup(List<String> initialIngredient) implements Coffee {
        @Override
        public List<String> ingredients() {
            return initialIngredient;
        }
    }
}
public class Day012 {
    public static void main(String[] args) {
        var ingredients=List.of("Durjoy Acharya");
        var coffeeCup=new Coffee.CoffeeCup(ingredients);
        var coffee=getCoffeeWithExtra(coffeeCup,
                Coffee::withSweetenedMilk,
                Coffee::withDarkCookieCrumb,
                Coffee::withVanillaAlmondExtract,
                Coffee::withSaltedCaramelFudge);
        System.out.println("Coffee with " + String.join(", ", coffee.ingredients()));
    }
    @SafeVarargs
    static Coffee getCoffeeWithExtra(Coffee coffee, Function<Coffee, Coffee>... ingredients) {
        var reduced = Stream.of(ingredients)
                .reduce(Function.identity(), Function::andThen);
        return reduced.apply(coffee);
    }
}
