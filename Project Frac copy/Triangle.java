import java.awt.*;

public class Triangle {
    public double x,y,height,width;
    public Color color;
    public Triangle(double x, double y, Color color, double height, double width) {
        this.x = x;
        this.y = y;
        this.color = color;
        this.height = height;
        this.width = width;
    }
    public double calculatePerimeter(){
        return  2 * this.height + this.width;
    }

    public double calculateArea(){
        return  0.5 * this.width * this.height;
    }

    public void setColor(Color colorVar) {
        this.color = colorVar;
    }
    public void setPos(double x, double y){
        this.x = x;
        this.y = y;
    }
    public void setHeight(double height){
        this.height = height;
    }

    public void setWidth(double width){
        this.width = width;
    }

    public Color getColor(){
        return this.color;
    }

    public double getXPos(){
        return this.x;
    }

    public double getYPos(){
        return this.y;
    }

    public double getHeight(){
        return this.height;
    }

    public double getWidth(){
        return this.width;
    }
}
