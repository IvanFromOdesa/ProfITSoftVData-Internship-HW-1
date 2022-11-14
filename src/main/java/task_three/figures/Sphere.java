package task_three.figures;

public class Sphere extends Figure {

    private final double radius;

    public Sphere(String name, double radius) {
        this.name = name;
        this.radius = radius;

        volume = round((4.0/3.0) * Math.PI * Math.pow(radius, 3));
    }
}
