package Decorator;


public class Main {
    public static void main(String[] args) {
        BasePizza pizza = new ExtraCheese( new Farmhouse());
        BasePizza pizza1 = new Mushroom( new ExtraCheese( new Margherita()));
        System.out.println(pizza.cost());
        System.out.println(pizza1.cost());
    }
}
