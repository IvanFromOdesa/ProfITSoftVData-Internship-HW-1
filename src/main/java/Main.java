import task_one.TaskOne;
import task_three.TaskThree;
import task_three.figures.*;
import task_two.TaskTwo;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Main {
    public static void main(String[] args) {
        Integer[] arr = {1, 2, 8, 5, -1, -9, -6, 13};
        arr = TaskOne.descendingPositive(arr);
        System.out.println(Arrays.toString(arr));

        List<String> hashTagsList = Arrays.asList("#darkness#helloWorld#java#java Just a Word",
                "#weAreTheFamily", "#hapiness#boredom#java #invincible # ",
                "#darkness#hapiness", "#me#me#me # ", "#invincible#helloWorld # ", "#helloWorld",
                "#helloWorld#invincible");

        Objects.requireNonNull(TaskTwo.topFiveHashTags(hashTagsList))
                .forEach((key, value) -> System.out.println(key + ":" + value));

        Figure sphere = new Sphere("Sphere 1", 8.5);
        Figure cube = new Cube("Cube 1", 13.21);
        Figure cylinder = new Cylinder("Cylinder 1", 4.5, 16);
        Figure cube2 = new Cube("Cube 2", 8.9);
        Figure cone = new Cone("Cone 1", 5, 15);

        List<Figure> figureList = Arrays.asList(cube, cone, sphere, cylinder, cube2);

        TaskThree.sortFiguresByVolume(figureList).forEach(System.out::println);
    }
}