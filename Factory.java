import java.util.Scanner;

interface Shape{
    public void draw();
}

class Square implements Shape{

    @Override
    public void draw() {
        // TODO Auto-generated method stub
        System.out.println("Square is drawn");
    }

}

class Circle implements Shape{

    @Override
    public void draw() {
        // TODO Auto-generated method stub
        System.out.println("Circle is drawn");
    }

}

class ShapeFactory{
    public Shape createShape(String shape){
        if(shape.equals("S")){
            return new Square();
        }else if(shape.equals("C")){
            return new Circle();
        }else{
            return null;
        }
    }
}

public class Factory {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        ShapeFactory factory = new ShapeFactory();
        Shape createdShape = null;
        System.out.println("Choose a shape to create? S/C");
        while(input.hasNextLine()){
            String userInput = input.nextLine();
            createdShape = factory.createShape(userInput);
            if(createdShape != null){
                createdShape.draw();
            }
        }
    }
}
