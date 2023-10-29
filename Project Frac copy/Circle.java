import java.awt.*;
import java.lang.Math;
public class Circle {
    public double x;
    public double y;
    public double radius;
    public Color color;
    public Circle(double x, double y, double radius, Color c) { //constructor
        this.x = x;
        this.y = y;
        this.radius = radius;
        this.color = c;
    }


    public void setColor(Color colorVar) {
        this.color = colorVar;
    }

    public void setRadius(double radius){
        this.radius= radius;
    }

    public Color getColor(){
        return this.color;
    }

    public void setPos(double xPos, double yPos){
        this.x = xPos;
        this.y = yPos;
    }

    public double getXPos(){
        return this.x;
    }

    public double getYPos(){
        return this.y;
    }

    public double getRadius(){
        return this.radius;
    }

    public double calculateArea(){
        return  Math.PI* this.radius * this.radius;
    }
    public double calculatePerimeter(){
        return 2.0 * Math.PI * this.radius;
    }
}
