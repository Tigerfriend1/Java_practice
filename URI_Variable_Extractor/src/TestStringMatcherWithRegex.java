import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestStringMatcherWithRegex {

    public static void main(String[] args) {

        Map<String, String> patternMappings = new HashMap<>();

        patternMappings.put("GET /students/{studentId}/course/{courseId}", "^GET \\/students\\/(\\w+)\\/course\\/(\\w+)$");

        UriProcessor processor = new UriProcessor(patternMappings);



        List<String> variableNames = processor.extractVariableNames("GET", "/students/123/course/456");

        List<String> variableValues = processor.extractVariableValues("GET", "/students/123/course/456");



        Map<String, String> pathVariables = new HashMap<>();

        for (int i = 0; i < variableNames.size(); i++) {

            pathVariables.put(variableNames.get(i), variableValues.get(i));

        }



        System.out.println("Extracted Path Variables:");

        pathVariables.forEach((key, value) -> System.out.println(key + " = " + value));



    }

}