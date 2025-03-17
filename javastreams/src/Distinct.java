import java.util.Arrays;
import java.util.List;

public class Distinct {
    public static void main(String[] args) {
       List<String> list = Arrays.asList("chi","chi","chi","chi","anvi");
       list.stream().distinct().forEach(System.out::println);

       List<PersonM> persons= Arrays.asList(new PersonM("chi",4),
               new PersonM("ds",2),
               new PersonM("chi",4));

       persons.stream().distinct().forEach(System.out::println);
    }
}

class PersonM {
    String name;
    int age;

    public PersonM(String name, int age) {this.name = name; this.age = age;}

    @Override
    public String toString() {
        return "PersonM{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
