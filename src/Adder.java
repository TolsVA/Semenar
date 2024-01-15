import java.util.Arrays;
import java.util.function.UnaryOperator;

interface Adder {

    <T> T add(T[] arr);

    String multiply(UnaryOperator<String> method, String str);
}
