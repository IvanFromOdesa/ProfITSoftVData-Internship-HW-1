package task_one;

import java.util.Arrays;
import java.util.Collections;
import java.util.Objects;

public class TaskOne {
    public static Integer[] descendingPositive(Integer[] input) {

        if(input.length == 0) throw new IllegalArgumentException("Input array can't be empty!");
        if(Arrays.stream(input).anyMatch(Objects::isNull))
            throw new IllegalArgumentException("All elements must be non-null!");

        Integer[] result = Arrays.stream(input).filter(num -> num >= 0)
                .sorted(Collections.reverseOrder()).toArray(Integer[]::new);

        if(result.length == 0) return null;

        return result;
    }
}
