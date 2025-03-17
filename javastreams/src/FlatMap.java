import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FlatMap {
    public static void main(String[] args) {
        /*
        * used to flatten stream of collections to a single stream
        *
        * mainly used for nested collections
        * */
        List<List<String>> fruits = Arrays.asList(
                Arrays.asList("apple","banana","apricot"),
                Arrays.asList("chikoo","pineapple"),
                Arrays.asList("watermelon","orange")
        );

        // flatten list of list into a single list of fruits

        List<String> fruitlist = fruits.stream().flatMap(List::stream).toList();

        //fruitlist.forEach(System.out::println);


        // flatten list and filter fruits starting with 'A'
        List<String> a = fruits.stream().flatMap(List::stream).
                filter(name -> name.startsWith("a"))
                .toList();
        a.forEach(System.out::println);

    }
}


