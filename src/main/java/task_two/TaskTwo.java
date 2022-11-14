package task_two;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class TaskTwo {

    public static Map<String, Long> topFiveHashTags(List<String> inputList) {

        if(inputList.isEmpty()) throw new IllegalArgumentException("Input list can't be null!");
        if(inputList.stream().anyMatch(Objects::isNull))
            throw new IllegalArgumentException("All elements must be non-null!");

        List<String> hashTags = new ArrayList<>();

        Matcher matcher;

        for (String str : inputList) {
            // Find hashtags and exclude non-unique ones from the same line
            matcher = Pattern.compile("(#\\w+)(?!.*\\1)").matcher(str);
            while (matcher.find()) hashTags.add(matcher.group());
        }

        if(hashTags.isEmpty()) return null;

        // Put the hashtags in the map with their frequency count as value
        Map<String, Long> resultMap = hashTags.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        // Sort descending (by value) top 5 hashtags
        return resultMap.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .limit(5)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                        (e1, e2) -> e1, LinkedHashMap::new));
    }
}
