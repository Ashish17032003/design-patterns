package StructuralDesignPatterns.Decorator;

import StructuralDesignPatterns.Decorator.BasePizza;

public class Farmhouse extends BasePizza {
    @Override
    public int cost() {
        return 200;
    }
}
