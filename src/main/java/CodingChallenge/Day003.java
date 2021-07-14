package CodingChallenge;

import java.util.List;
import java.util.stream.Collectors;

public class Day003
{
    public static void main(String[] args) {
        var list= List.of(new Books("Java Programming",2018,"xx-dd-33ee"),
                new Books("Python Programming",2020,"js-bsko-998j"),
                new Books("JavaScript",2021,"iskldc-9954-fkoxx"),
                new Books("Cloud Computing",2020,"xx00o-dd_dddse"));
            var booksCountByReleaseYear=list.stream().collect(Collectors.groupingBy(Books::releaseYear
            ,Collectors.counting()));
        System.out.println(booksCountByReleaseYear);
    }
    record Books(String name,int releaseYear,String isBN){}
}
