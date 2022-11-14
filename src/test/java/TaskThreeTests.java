import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import task_three.TaskThree;
import task_three.figures.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertIterableEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TaskThreeTests {

    private Figure cone, cube, cylinder, sphere;

    @BeforeEach
    void setUp() {
        cone = new Cone("Cone 1", 6, 16.35);
        cube = new Cube("Cube 1", 8.9);
        cylinder = new Cylinder("Cylinder 1", 5.4, 17);
        sphere = new Sphere("Sphere 1", 9.2);
    }

    @Test
    void shouldReturnSortedCollectionByVolume_whenGivenFigures() {
        // given
        List<Figure> figures = Arrays.asList(sphere, cone, cube, cylinder);

        // when
        Collection<Figure> result = TaskThree.sortFiguresByVolume(figures);

        // then
        Collection<Figure> expected = Arrays.asList(cone, cube, cylinder, sphere);

        System.out.println("Expected: ");
        expected.forEach(System.out::println);

        System.out.println("Actual: ");
        result.forEach(System.out::println);

        assertIterableEquals(expected, result);
    }

    @Test
    void shouldThrowException_whenGivenEmptyCollection() {
        // given
        List<Figure> figures = new ArrayList<>();

        // when
        IllegalArgumentException e = assertThrows(
                IllegalArgumentException.class,
                () -> TaskThree.sortFiguresByVolume(figures),
                "Expected sortFiguresByVolume() to throw, but it didn't"
        );

        //then
        assertTrue(e.getMessage().contains("Collection can't "));
    }

    @Test
    void shouldThrowException_whenAnyElementIsNull() {
        // given
        List<Figure> figures = Arrays.asList(cone, cube, null, cylinder);

        // when
        IllegalArgumentException e = assertThrows(
                IllegalArgumentException.class,
                () -> TaskThree.sortFiguresByVolume(figures),
                "Expected sortFiguresByVolume() to throw, but it didn't"
        );

        // then
        assertTrue(e.getMessage().contains("must be non-null"));
    }
}
