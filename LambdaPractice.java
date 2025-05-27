package utcn;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static java.util.Arrays.stream;

public class LambdaPractice {
    public static void main(String[] args) {

        List<Integer> nums = List.of(1,2,3,4,5,6,7,8);
        List<Integer> evens = nums.stream()   //numerele pare din lista
                .filter(n -> n%2==0)
                .collect(Collectors.toList());
        List<Integer> odds = nums.stream()   //numerele impare din lista
                        .filter(n->n%2==1)
                        .collect(Collectors.toList());
        System.out.println(evens);
        System.out.println(odds);


        List<String> words = List.of("apple","banana"); //lower case wors to upper case
        List<String> upWords = words.stream()
                    .map(String :: toUpperCase)
                    .toList();
        System.out.println(upWords);


        Person p1 = new Person(28,"Alex");
        Person p2 = new Person(24,"Bob");
        List<Person> people = new ArrayList<>(List.of(p1,p2));
        //List<Person> people = stream().of(p1,p2)
//                .sorted(Comparator.comparing(Person::getAge))
//                        .collect(Collectors.toCollection(ArrayList::new));
        //people.sort((a1,a2)->Integer.compare(p2.getAge(), p1.getAge()));
        people.sort(Comparator.comparing(Person::getAge));
        System.out.println(people);


//        interface TriFunction<A,B,C,R> {
//            R apply(A a, B b, C c);
//        }
        TriFunction<String,String,String,String> concat = (a,b,c) -> a+b+c;
        System.out.println(concat.apply("ana ","are ","mere."));


        List<String> ids = new ArrayList<>(List.of("1","2","44","23")); //convert String to int's
        List<Integer> iDs = ids.stream().map(Integer::valueOf).toList();

        Consumer<String> consumer1 = System.out::println; //afiseaza siru
        Consumer<String> consumer2 = s->System.out.println("len" + s.length()); //afiseaza lungimea sirului
        Consumer<String> both = consumer1.andThen(consumer2);
        words.forEach(both);

        Predicate<String> nonNull = Objects::nonNull;
        Predicate<String> nonEmpty = s->!s.isEmpty();
        Predicate<String> startsWithJ = s->s.startsWith("J");
        Predicate<String> combined = nonNull.and(nonEmpty).and(startsWithJ);
        System.out.println(combined.test("Java"));
        System.out.println(combined.test("Python"));
        System.out.println(combined.test(""));
        System.out.println(combined.test(null));

        Consumer<String> printer = s->System.out.println(s);
        List<String> words2 = List.of("Java", "", "Streams");
        List<String> nonEmptyWords = words.stream()
                .filter(nonEmpty)     // uses Predicate
                .collect(Collectors.toList());
        nonEmptyWords.forEach(printer);          // uses Consumer
    }
}
