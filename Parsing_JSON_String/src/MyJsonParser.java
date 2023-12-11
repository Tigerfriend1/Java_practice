import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MyJsonParser {

    public static void main(String[] args) {


        String json = readJSONStringFromKeyboard();

        System.out.println(json);

        var map = parseJSONString(json);

        var jsonString = convertHashMapToJsonString(map);

        System.out.println(convertStringToPrettyJson(jsonString));

    }

    private static String readJSONStringFromKeyboard() {
        Scanner scanner = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        while (scanner.hasNext()) { //입력이 끝날때까지 받는다.
            sb.append(scanner.nextLine());
        }

        return sb.toString();
    }

    /*
    1. HashMap생성
    2. 양쪽 중괄호 제거
    3. splitJson을 통해 depth 1까지 나눔.
     */
    public static HashMap<String, Object> parseJSONString(String json) {
        HashMap<String, Object> parsedMap = new HashMap<>();

        json = json.substring(1, json.length() - 1);
        for (String keyValue : splitJson(json)) {
            String[] tokens = keyValue.split(":", 2); //key-value로 나눠줌.

            String key = tokens[0].trim();
            key = key.substring(1, key.length() - 1);
            Object value = stringToObject(tokens[1]);

            parsedMap.put(key, value);

        }
        return parsedMap;

    }

    private static ArrayList<String> splitJson(String json) {
        json = json.trim();
        ArrayList<String> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();

        int brackets = 0;
        int braces = 0;
        boolean isString = false;

        for (int i = 0; i < json.length(); i++) {
            char c = json.charAt(i);
            sb.append(c);

            switch (c) {
                case '{' -> brackets++;
                case '}' -> brackets--;
                case '[' -> braces++;
                case ']' -> braces--;
                case '"' -> isString = !isString;
            }
            if (brackets == 0 && braces == 0 && !isString && c == ',') {
                sb.deleteCharAt(sb.length() - 1);
                list.add(sb.toString());
                sb.setLength(0);
            }
        }
        list.add(sb.toString()); //마지막 json에는 쉽표가 없음. 그래서 여기서 더해줌.
        return list;

    }

    private static Object stringToObject(String value) {
        value = value.trim();
        char c = value.charAt(0);

        switch (c) {
            case '{' -> {
                return parseJSONString(value);
            }
            case '[' -> {
                ArrayList<Object> valueList = new ArrayList<>();
                value = value.substring(1, value.length() - 1); //대괄호 제거하고 재귀
                for (String token : splitJson(value)) {
                    valueList.add(stringToObject(token));
                }
                return valueList;
            }
            case '"' -> {
                return value.substring(1, value.length() - 1);
            }
            default -> {
                return parseString(value);
            }
        }
    }

    public static Object parseString(String str) {

        if (str == null) {

            return null;

        }

        try {

            return Integer.parseInt(str);

        } catch (NumberFormatException ignore) {

        }

        try {

            return Long.parseLong(str);

        } catch (NumberFormatException ignore) {

        }

        try {

            return Double.parseDouble(str);

        } catch (NumberFormatException ignore) {

        }

        if ("true".equalsIgnoreCase(str) || "false".equalsIgnoreCase(str)) {

            return Boolean.parseBoolean(str);

        }

        // If none of the above, return the string itself

        return str;

    }


    private static String convertStringToPrettyJson(String jsonString){


    }

    private static String convertHashMapToJsonString(HashMap<String, Object> map) {
        StringBuilder sb = new StringBuilder("{");
        for (String key : getTreeMap(map).keySet()){
            sb.append(String.format("\"%s\":%s", key, objectToString(map.get(key))));
        }
        sb.deleteCharAt(sb.length()-1);
        sb.append("}");

        return sb.toString();
    }

    private static Object objectToString(Object o) {
    }

    private static <K,V> Map<K, V> getTreeMap(Map<K,V> hashMap) {
    }


}

