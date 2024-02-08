package homework_2;

import java.util.HashMap;
import java.util.Map;

class Answer {
    public static StringBuilder answer(String QUERY, String PARAMS) {
        // Напишите свое решение ниже
        // Регулярное выражение например такое -> "{"
        PARAMS = PARAMS.replace("{", "")
                .replace("}", "")
                .replace(" ", "");
        String[] strings = PARAMS.split(",");

        String[] ss = new String[strings.length];
        Map<String, String> map = new HashMap<>();
        int index = 0;
        for (String s : strings) {
            String[] isNull = s.split(":");
            if (!isNull[1].equals("\"null\"")) {
                ss[index] = isNull[0].replace("\"", "");
                index++;
                map.put(
                        isNull[0].replace("\"", ""),
                        isNull[1].replace("\"", "'")
                );
            } else {
                ss[index] = "null";
            }
        }

        StringBuilder result = new StringBuilder();
        for (String s : ss){
            if (!result.isEmpty() & !s.equals("null")) result.append(" and ");
            if (!s.equals("null")) result.append(s).append("=").append(map.get(s));
        }

        return new StringBuilder(QUERY).append(result);
    }

    public static StringBuilder answer2(String QUERY, String PARAMS) {
        // Регулярное выражение например такое -> "{"
        PARAMS = PARAMS.replace("{", "")
                .replace("}", "")
                .replace(" ", "");
        String[] strings = PARAMS.split(",");
        StringBuilder result = new StringBuilder();
        for (String s : strings) {
            String[] elements  = s.split(":");
            if (!elements[1].equals("\"null\"")) {
                if (!result.isEmpty()) result.append(" and ");
                result.append(elements[0].replace("\"", ""))
                        .append("=")
                        .append(elements[1].replace("\"", "'"));
            }
        }
        return new StringBuilder(QUERY).append(result);
    }
}


// Не удаляйте этот класс - он нужен для вывода результатов на экран и проверки
public class Printer {
    public static void main(String[] args) {
        String QUERY = "";
        String PARAMS = "";

        if (args.length == 0) {
            // При отправке кода на Выполнение, вы можете варьировать эти параметры
            QUERY = "select * from students where ";
            PARAMS = "{\"name\":\"Ivanov\", \"country\":\"Russia\", \"city\":\"Moscow\", \"age\":\"null\"} ";
        } else {
            QUERY = args[0];
            PARAMS = args[1];
        }

        System.out.println(Answer.answer(QUERY, PARAMS));
        System.out.println(Answer.answer2(QUERY, PARAMS));
    }
}
