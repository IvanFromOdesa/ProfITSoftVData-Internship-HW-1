package task_three.figures;

public class Cube extends Figure {

    private final double a;

    public Cube(String name, double a) {
        this.name = name;
        this.a = a;

        volume = round(Math.pow(a, 3));
    }
}
