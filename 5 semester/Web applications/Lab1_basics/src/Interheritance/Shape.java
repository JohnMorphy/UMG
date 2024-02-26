package Interheritance;

public abstract class Shape {

    protected String description;

    abstract double getArea();
    abstract double getCircumference();

    public Shape(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return description + ", area: " + getArea()
                + ", circumference" + getCircumference();
    }
}
