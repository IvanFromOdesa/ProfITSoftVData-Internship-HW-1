package task_three;

import task_three.figures.Figure;

import java.util.Collection;
import java.util.Comparator;
import java.util.Objects;
import java.util.stream.Collectors;

public class TaskThree {

    // Sorts the figures by their volume ascending
    public static Collection<Figure> sortFiguresByVolume(Collection<Figure> unsortedFigures) {

        if(unsortedFigures.isEmpty())
            throw new IllegalArgumentException("Collection can't be empty!");

        if(unsortedFigures.stream().anyMatch(Objects::isNull))
            throw new IllegalArgumentException("All elements must be non-null!");

        return unsortedFigures.stream().sorted(Comparator.comparingDouble(Figure::getVolume))
                .collect(Collectors.toList());
    }
}
