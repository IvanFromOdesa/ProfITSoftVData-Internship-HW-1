import org.junit.jupiter.api.Test;
import task_two.TaskTwo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TaskTwoTests {

    @Test
    void shouldReturnTop5HashTags_whenGivenListOfText_ifPresent() {
        // given
        List<String> hashTagsList = Arrays.asList("#ball#basketball#Japan#Norret Dark a#ball GF",
                "#weAreTheFamily#Alex #movie   #girls#love   458 @99 FR #code #happiness",
                "#happiness#something#java#code #code #code #js #USA",
                "#darkness#happiness   Miguel#love", "#me#me#me", "#invincible#weAreTheFamily",
                "#helloWorld  #USA #helloWorld #  !! #movie #code 678 How is this",
                "#helloWorld#invincible #USA #happiness #code #USA #movie", "#code");

        // when
        Map<String, Long> result = TaskTwo.topFiveHashTags(hashTagsList);

        // then
        Map<String, Long> expected = new LinkedHashMap<String, Long>() {{
            put("#code", 5L);
            put("#happiness", 4L);
            put("#movie", 3L);
            put("#USA", 3L);
            put("#helloWorld", 2L);
        }};

        System.out.println("Result: ");
        expected.forEach((key, value) -> System.out.println(key + ":" + value));

        assertEquals(expected, result);
    }

    @Test
    void shouldReturnLessThanTopFive_whenLessThanFiveHashtagsPresent() {
        // given
        List<String> hashTagsList = Arrays.asList("#newHashtag#hello",
                "456 back #hello#coding#coding",
                "#hello We are going",
                "just text#coding");

        // when
        Map<String, Long> result = TaskTwo.topFiveHashTags(hashTagsList);

        // then
        Map<String, Long> expected = new LinkedHashMap<String, Long>() {{
            put("#hello", 3L);
            put("#coding", 2L);
            put("#newHashtag", 1L);
        }};

        System.out.println("Result: ");
        expected.forEach((key, value) -> System.out.println(key + ":" + value));

        assertEquals(expected, result);
    }

    @Test
    void shouldThrowException_whenGivenEmptyList() {
        // given
        List<String> hashTagsList = new ArrayList<>();

        // when
        IllegalArgumentException e = assertThrows(
                IllegalArgumentException.class,
                () -> TaskTwo.topFiveHashTags(hashTagsList),
                "Expected topFiveHashTags() to throw, but it didn't"
        );

        // then
        assertTrue(e.getMessage().contains("Input list can't"));
    }

    @Test
    void shouldThrowException_whenAnyElementIsNull() {
        // given
        List<String> hashTagsList = Arrays.asList("#dark#brawl#snow",
                "fightback#no #dark", null, "#good");

        // when
        IllegalArgumentException e = assertThrows(
                IllegalArgumentException.class,
                () -> TaskTwo.topFiveHashTags(hashTagsList),
                "Expected topFiveHashTags() to throw, but it didn't"
        );

        // then
        assertTrue(e.getMessage().contains("must be non-null"));
    }

    @Test
    void shouldReturnNull_whenNoHashTagsPresent() {
        // given
        List<String> hashTagsList = Arrays.asList("\"Lorem ipsum dolor sit amet," +
                        " consectetur adipiscing elit, sed do eiusmod tempor" +
                        " incididunt ut labore et dolore magna aliqua. ",
                "Ut enim ad minim veniam,", "quis nostrud exercitation " +
                        "ullamco laboris nisi ut aliquip",
                "ex ea commodo consequat.");

        // when
        Map<String, Long> result = TaskTwo.topFiveHashTags(hashTagsList);

        // then
        assertNull(result);
    }
}
