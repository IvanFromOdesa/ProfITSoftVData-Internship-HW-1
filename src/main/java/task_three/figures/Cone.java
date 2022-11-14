package task_three.figures;

public class Cone extends Figure{

    private final double radius;
    private final double height;

    public Cone(String name, double radius, double height) {
        this.name = name;
        this.radius = radius;
        this.height = height;

        volume = round(Math.PI * Math.pow(radius, 2) * (height / 3));
    }
}
