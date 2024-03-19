package Classwork;

import java.util.Date;

public class GeometricObject {
    private String color = "white";
    private boolean filled = false;
    private Date dateCreated = new Date();

    GeometricObject() {
    }

    GeometricObject(String color, boolean filled) {
        this.color = color;
        this.filled = filled;
    }

    public String getColor() {
        return color;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public boolean isFilled() {
        return filled;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String toString() {

        return "The shape was created on " + dateCreated.toString() + ", has the color " + color + ", and "
                + (filled ? "is" : "isn't") + " filled";

    }
}

class Circle extends GeometricObject {
    private double radius;

    Circle() {
        super();
    }

    Circle(double radius) {
        super();
        this.radius = radius;
    }

    Circle(double radius, String color, boolean filled) {
        super(color, filled);
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double getDiameter() {
        return radius * 2;
    }

    public double getArea() {
        return radius * radius * Math.PI;
    }

    public double getPerimeter() {
        return 2 * radius * Math.PI;
    }

    public void printCircle() {
        System.out.println(super.toString());
        System.out.println(
                "The circle has a radius of " + radius + ", a diameter of," + getDiameter() + " an area of " + getArea()
                        + ", and a circumference of " + getPerimeter());
    }
}

class Rectangle extends GeometricObject {
    private double width;
    private double height;

    Rectangle() {
        super();
    }

    Rectangle(double width, double height) {
        super();
        this.width = width;
        this.height = height;
    }

    Rectangle(double width, double height, String color, boolean filled) {
        super(color, filled);
        this.width = width;
        this.height = height;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getArea() {
        return width * height;
    }

    public double getPerimeter() {
        return width * 2 + height * 2;
    }
}

class testGeometricObject {
    public static void main(String[] args) {
        Circle c = new Circle(3);
        Rectangle r = new Rectangle(3, 2);
        displayObject(c);
        displayObject(r);
    }

    public static void displayObject(Object object) {
        if (object instanceof Circle) {
            System.out.println("The circle area is " + ((Circle) object).getArea());
            System.out.println("The diameter is " + ((Circle) object).getDiameter() * 2);
        } else if (object instanceof Rectangle) {
            System.out.println("The rectangle area is " + ((Rectangle) object).getArea());
            System.out.println("The perimeter size is " + ((Rectangle) object).getPerimeter());
        }

    }
}