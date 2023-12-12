import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UriProcessor {

    private final Map<String, String> patternMappings;

    public UriProcessor(Map<String, String> patternMappings) {
        this.patternMappings = patternMappings;
    }

    public List<String> extractVariableNames(String order, String uriTemplate) {
        List<String> variableNames = new ArrayList<>();
        for (String key : patternMappings.keySet()) {
            String regex = patternMappings.get(key);
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(order + " " + uriTemplate);
            if (matcher.matches()) {
                Pattern variablePattern = Pattern.compile("\\{([^}]+)}");
                Matcher variableMatcher = variablePattern.matcher(key);
                while (variableMatcher.find()) {
                    variableNames.add(variableMatcher.group(1));
                }
            }
        }
        return variableNames;
    }


    public List<String> extractVariableValues(String order, String uriTemplate) {
        for (String key : patternMappings.keySet()) {
            String regex = patternMappings.get(key);
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(order + " " + uriTemplate);
            List<String> variableValues = new ArrayList<>();
            if (matcher.matches()) {
                for (int i = 1; i <= matcher.groupCount(); i++) {
                    variableValues.add(matcher.group(i));
                }
            }
            return variableValues;
        }
        return Collections.emptyList();
    }

}
