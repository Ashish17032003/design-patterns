package CreationalDesignPatterns.FactoryPattern;

public class MainClass {
    public static void main(String[] args) {
        ShapeFactory shapeFactory = new ShapeFactory();
        Shape shapeObj = shapeFactory.getShape("square");
        shapeObj.draw();
    }
}
