package Stream;
import java.util.*;

class Stream {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = {4, 5, 2, 7, 1, 9, 3};
        Arrays.sort(arr);
        Arrays.stream(arr).forEach(System.out::println);
        sc.close();
    }
}