import java.util.Arrays;
import java.util.List;

public class Maps {
    public static void main(String[] args) {
/**
 * The stream map operation is used to transform elements of a stream by applying a given function 
 * to each element. The transformed elements are then returned as a new stream without modifying 
 * the original source.
 *
 * Example:
 * List<String> names = Arrays.asList("alice", "bob", "charlie");
 * names.stream().map(name -> name.toUpperCase()).forEach(System.out::println);
 *
 * Output:
 * ALICE
 * BOB
 * CHARLIE
 */

        /*
         * stream map is used to transform each element in stream to another object value
         * */
        List<Integer> list = Arrays.asList(1, 2, 3, 4);
        list.stream().map(i -> i * 2).forEach(System.out::println);

        List<Employee> employees = Arrays.asList(new Employee("anvi", 1235),
                new Employee("chinmay", 43443),
                new Employee("abhyankar", 123123));

        // get name of employees
        employees.stream().map(i -> i.name
        ).forEach(System.out::println);

    }


}

class Employee {
    String name;
    int salary;

    public Employee(String name, int salary) {
        this.name = name;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", salary=" + salary +
                '}';
    }
}
