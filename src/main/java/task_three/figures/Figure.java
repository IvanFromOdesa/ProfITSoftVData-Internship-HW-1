package task_three.figures;

import java.math.BigDecimal;
import java.math.RoundingMode;

public abstract class Figure {

    protected double volume;
    protected String name;

    public double getVolume() {
        return volume;
    }

    // Reducing the amount of decimal places in volume numbers
    protected static double round(double value) {
        return new BigDecimal(value).setScale(2, RoundingMode.HALF_UP).doubleValue();
    }

    @Override
    public String toString() {
        return "Name: " + name + "; Volume: " + volume;
    }
}
