import java.awt.*;

public class Rectangle {

    public double x,y,height,width;
    public Color color;
    public Rectangle(double x, double y, Color color, double height, double width){
        this.x = x;
        this.y = y;
        this.color = color;
        this.height = height;
        this.width = width;

    }
    public double calculatePerimeter(){
        return  2 * (height + width);
    }

    public double calculateArea(){
        return  height * width;
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
