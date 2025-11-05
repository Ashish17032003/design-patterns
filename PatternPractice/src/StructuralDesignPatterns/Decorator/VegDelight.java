package StructuralDesignPatterns.Decorator;

import StructuralDesignPatterns.Decorator.BasePizza;

public class VegDelight extends BasePizza {
    @Override
    public int cost() {
        return 120;
    }
}
