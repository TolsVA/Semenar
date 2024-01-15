import java.util.function.UnaryOperator;

public class ImplAdder implements Adder {
    @SafeVarargs
    @Override
    public final <T> T add(T... arr) {
        if (arr[0] instanceof Integer) {
            int t = 0;
            for (T item : arr) {
                t += Integer.parseInt(item.toString());
            }
            return (T)(Object)t;
        }

        if (arr[0] instanceof String) {
            StringBuilder stringBuilder = new StringBuilder();
            for (T item : arr) {
                stringBuilder.append(item.toString());
            }
            Object t = stringBuilder.toString();
            return (T)t;
        }
        return null;
    }

    @Override
    public  String multiply(UnaryOperator<String> method, String str) {
        return method.apply(str);
    }
}
