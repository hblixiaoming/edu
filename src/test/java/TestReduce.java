import java.util.stream.Stream;

public class TestReduce {

    public static void main(String[] args) {

        System.out.println(Stream.of(1, 2, 3, 4).reduce((e1, e2) -> e2+e1).orElse(0));
    }
}
