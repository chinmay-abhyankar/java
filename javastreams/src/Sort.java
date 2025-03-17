import java.util.Arrays;
import java.util.List;

public class Sort {
    public static void main(String[] args) {
        /*
        * sorted is used to sort elements of stream
        * */
        List<Integer> list = Arrays.asList(0,0,1, 1, 2, 4,1,5,3,667,21,2,1,1,1,0,1);

        //sort in ascending
        list.stream().sorted().forEach(System.out::println);

        //sort in descending
        list.stream().sorted((a,b)->b.compareTo(a))
                .forEach(System.out::println);

    }
}
