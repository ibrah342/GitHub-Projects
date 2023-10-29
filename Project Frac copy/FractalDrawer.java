// FractalDrawer class draws a fractal of a shape indicated by user input
import java.awt.Color;
import java.util.Scanner;

public class FractalDrawer {
    private double totalArea=0;  // member variable for tracking the total area

    public FractalDrawer() {

    }  // constructor




    // drawFractal: Function creates a new Canvas object, determines which shapes to draw a fractal by calling the
    //              specific helper functions (drawTriangleFractal,drawCircleFractal,drawRectangleFractal), and also
    //              returns the area
    public double drawFractal(String type) {
        Canvas newCanvas = new Canvas();
        if (type.equals("Rectangle")) {
            drawRectangleFractal(50, 100, 370, 250, Color.pink, newCanvas, 7);
        } else if (type.equals("Circle")) {
            drawCircleFractal(100, 400, 350, Color.pink, newCanvas, 7);
        } else if (type.equals("Triangle")) {
            drawTriangleFractal(150, 200, 300, 500, Color.cyan, newCanvas, 7);
        }

        else{
            System.out.println("Invalid, try again with a capitalized first letter");
        }


        return totalArea;
    }

    // drawTriangleFractal: draws a triangle fractal using recursive techniques, changes the color for each level.
    public void drawTriangleFractal(double width, double height, double x, double y, Color c, Canvas can, int level){
        Triangle myTriangle= new Triangle(x,y,c,height,width);
        if (level == 0) {

        }

        else {
            Color nextColor = c;

            if(c == (Color.yellow)){
                nextColor = Color.cyan;
            }
            if(c==(Color.cyan)){
                nextColor = Color.green;
            }
            if(c==(Color.green)){
                nextColor = Color.pink;}

            if(c==Color.pink){
                nextColor = Color.yellow;}
            totalArea += myTriangle.calculateArea();
            can.drawShape(myTriangle);
            drawTriangleFractal(width/2,height/2,x -(width/2), y, nextColor, can, level - 1);
            drawTriangleFractal(width/2, height/2, x+= width,y, nextColor, can, level - 1);
            drawTriangleFractal(width/2, height/2,x - height + width/2, y - height, nextColor, can, level - 1);

        }

    }

    // drawCircleFractal draws a circle fractal using recursive techniques, changes the color for each level.
    public void drawCircleFractal(double radius, double x, double y, Color c, Canvas can, int level) {
        Circle myCircle = new Circle(x,y, radius,c);
        if(level == 0) {
        }

        else {
            Color nextColor = c;

            if(c == (Color.yellow)){
                nextColor = Color.cyan;
            }
            if(c==(Color.cyan)){
                nextColor = Color.green;
            }
            if(c==(Color.green)){
                nextColor = Color.pink;}

            if(c==Color.pink){
                nextColor = Color.yellow;}

            totalArea += myCircle.calculateArea();
            can.drawShape(myCircle);
            drawCircleFractal(radius * 0.5, x - (radius * 1.5), y + radius, nextColor, can, level - 1);
            drawCircleFractal(radius * 0.5, x + (radius * 1.5), y + radius, nextColor, can, level - 1);
            drawCircleFractal(radius * 0.5, x - (radius * 1.5), y - radius, nextColor, can, level - 1);
            drawCircleFractal(radius * 0.5, x + (radius * 1.5), y - radius, nextColor, can, level - 1);

        }
    }

    // drawRectangleFractal draws a rectangle fractal using recursive techniques, changes the color for each level.
    public void drawRectangleFractal(double width, double height, double x, double y, Color c, Canvas can, int level) {
        Rectangle myRectangle = new Rectangle(x,y,c,height,width);
        if(level == 0) {
        }
        else {
            Color nextColor = c;

            if(c == (Color.yellow)){
                nextColor = Color.cyan;
            }
            if(c==(Color.cyan)){
                nextColor = Color.green;
            }
            if(c==(Color.green)){
                nextColor = Color.pink;}

            if(c==Color.pink){
                nextColor = Color.yellow;}
            totalArea += myRectangle.calculateArea();

            can.drawShape(myRectangle);
            drawRectangleFractal(width/2,height/2,x - width/2 , y - height/2, nextColor, can, level - 1);
            drawRectangleFractal(width/2, height/2, x + width,y - height/2, nextColor, can, level - 1);
            drawRectangleFractal(width/2, height/2,x - width/2, y + height, nextColor, can, level - 1);
            drawRectangleFractal(width/2, height/2,x + width, y+ height,nextColor, can, level -1);

        }
    }
    // main function: Will ask user to enter a shape, and then draw the corresponding fractal, and also will
    // print area of fractal
    public static void main(String[] args){
        System.out.println("Enter your shape:");
        System.out.println("1: Rectangle");
        System.out.println("2: Triangle");
        System.out.println("3: Circle");
        Scanner myScanner = new Scanner(System.in);
        String response = myScanner.nextLine();
        FractalDrawer newFractal = new FractalDrawer();
        double totalArea = newFractal.drawFractal(response);
        System.out.println(totalArea);
    }
}

