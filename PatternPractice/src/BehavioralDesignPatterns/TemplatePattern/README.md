```Java
// Abstract template defining the skeleton of beverage preparation
abstract class Beverage {

    // Template method — defines the algorithm steps (cannot be overridden)
    final void prepareRecipe() {
        boilWater();
        brew();
        pourInCup();
        addCondiments();
    }

    // Common methods (shared steps)
    void boilWater() {
        System.out.println("Boiling water...");
    }

    void pourInCup() {
        System.out.println("Pouring into cup...");
    }

    // Steps to be customized by subclasses
    abstract void brew();
    abstract void addCondiments();
}

// Concrete implementation for Coffee
class CoffeeBeverage extends Beverage {

    @Override
    void brew() {
        System.out.println("Brewing coffee...");
    }

    @Override
    void addCondiments() {
        System.out.println("Adding sugar and milk...");
    }
}

// Concrete implementation for Tea
class TeaBeverage extends Beverage {

    @Override
    void brew() {
        System.out.println("Steeping tea bag...");
    }

    @Override
    void addCondiments() {
        System.out.println("Adding lemon...");
    }
}

// Demo class
public class BeverageTemplateDemo {
    public static void main(String[] args) {
        Beverage coffee = new CoffeeBeverage();
        Beverage tea = new TeaBeverage();

        System.out.println("Making coffee...");
        coffee.prepareRecipe();

        System.out.println("\nMaking tea...");
        tea.prepareRecipe();
    }
}
```

Define a fixed algorithm skeleton, but let subclasses fill in the variable steps.
💡 Think of it like a recipe —
Everyone must boil water → brew → pour → add condiments,
but how you “brew” or “add condiments” depends on the drink.