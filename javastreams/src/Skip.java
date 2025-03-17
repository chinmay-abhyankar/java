import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Skip {
    public static void main(String[] args) {
        /**
         * skip is used to skip first n elements of stream and process remaining elements
         *
         */

        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

       // list.stream().skip(3).forEach(System.out::println);

        // filter even number and skip first 3
        list.stream().filter(e -> e % 2 == 0).skip(3).forEach(System.out::println);

    }
}
