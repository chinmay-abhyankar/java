import java.util.Arrays;
import java.util.List;

public class Streams {
    public static void main(String[] args) {
        /*
            stream filter operation is used to process elements of stream and return
            ony those that meet specific criteria
         */


        List<String> list = Arrays.asList("anvi", "baba", "chinmay","nilesh");
        // get content whose length greater than 4
        list.stream().filter(name -> name.length() > 6)
                .forEach(System.out::println);

        // sort list contents
        list.stream().sorted().forEach(System.out::println);

        List<PersonM> persons = Arrays.asList(new PersonM("anvi", 27),
                new PersonM("baba", 56),
                new PersonM("chinmay", 31));
        // filter person greater than 30
        persons.stream().filter(person -> person.age > 30)
                .forEach(System.out::println);
        // filter person less than 30
        persons.stream().filter(person -> person.age < 30)
                .forEach(System.out::println);

    }
}

class Person {
    String name;
    int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
    public String toString() {
        return "Person [name=" + name + ", age=" + age + "]";
    }

}