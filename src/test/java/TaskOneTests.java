import org.junit.jupiter.api.Test;
import task_one.TaskOne;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TaskOneTests {

    @Test
    void shouldReturnOnlyPositiveDescending_whenGivenAnyNumbers() {
        // given
        Integer[] array = {14, 0, -8, 74, -5, -10, -2, 8, 19, -1, 0};

        // whenT
        Integer[] result = TaskOne.descendingPositive(array);

        // then
        Integer[] expected = {74, 19, 14, 8, 0, 0};
        System.out.println("Actual: " + Arrays.toString(result));
        assertArrayEquals(expected, result);
    }

    @Test
    void shouldThrowException_whenGivenEmptyArray() {
        // given
        Integer[] array = {};

        // when
        IllegalArgumentException e = assertThrows(
                IllegalArgumentException.class,
                () -> TaskOne.descendingPositive(array),
                "Expected descendingPositive() to throw, but it didn't"
        );

        // then
        assertTrue(e.getMessage().contains("Input array "));
    }

    @Test
    void shouldThrowException_whenAnyElementIsNull() {
        // given
        Integer[] array = {1, -7, null, 21, 16, 5};

        // when
        IllegalArgumentException e = assertThrows(
                IllegalArgumentException.class,
                () -> TaskOne.descendingPositive(array),
                "Expected descendingPositive() to throw, but it didn't"
        );

        // then
        assertTrue(e.getMessage().contains("must be non-null"));
    }

    @Test
    void shouldReturnNull_whenGivenOnlyNegatives() {
        // given
        Integer[] array = {-4, -8, -5, -1, -10};

        // when
        Integer[] result = TaskOne.descendingPositive(array);

        // then
        assertNull(result);
    }
}
