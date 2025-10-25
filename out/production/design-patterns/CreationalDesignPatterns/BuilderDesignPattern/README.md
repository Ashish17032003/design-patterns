# Builder Design Pattern

##### 🔧 Purpose:
- To construct complex objects step-by-step, especially when the object can have many optional fields or configurations.
In niormal flow when we are using a constructor
- Problem #1: Passing Unnecessary Values 🛑
  1. When you need to set optional attributes, such as sunroof or navigation system, you have to pass values for all parameters, even if they aren't necessary.
  2. If a car has many optional attributes, you end up with multiple constructors, each for different combinations of parameters. This results in code duplication and leads to messy and unmanageable code.
  3. Lack of readability
  
#### Why Builder
- The Builder Design Pattern is so named because it allows you to build an object step-by-step.
```Java
public class Car {
    private String brand;
    private String engine;
    private int wheels;
    private int seats;
    private String color;
    private boolean sunroof;
    private boolean navigationSystem;

    // 👇 Constructor is private so Car can only be built via CarBuilder
    private Car(CarBuilder builder) {
        this.brand = builder.brand;
        this.engine = builder.engine;
        this.wheels = builder.wheels;
        this.seats = builder.seats;
        this.color = builder.color;
        this.sunroof = builder.sunroof;
        this.navigationSystem = builder.navigationSystem;
    }

    // ✅ Getters
    public String getBrand() { return brand; }
    public String getEngine() { return engine; }
    public int getWheels() { return wheels; }
    public int getSeats() { return seats; }
    public String getColor() { return color; }
    public boolean hasSunroof() { return sunroof; }
    public boolean hasNavigationSystem() { return navigationSystem; }

    @Override
    public String toString() {
        return "Car [brand=" + brand + ", engine=" + engine + ", wheels=" + wheels +
                ", seats=" + seats + ", color=" + color + ", sunroof=" + sunroof +
                ", navigationSystem=" + navigationSystem + "]";
    }

    // ✅ Static nested CarBuilder class
    public static class CarBuilder {
        private String brand;
        private String engine;
        private int wheels = 4; // default
        private int seats = 5;  // default
        private String color = "Black"; // default
        private boolean sunroof = false;
        private boolean navigationSystem = false;

        // Builder methods
        public CarBuilder setBrand(String brand) {
            this.brand = brand;
            return this;
        }

        public CarBuilder setEngine(String engine) {
            this.engine = engine;
            return this;
        }

        public CarBuilder setWheels(int wheels) {
            this.wheels = wheels;
            return this;
        }

        public CarBuilder setSeats(int seats) {
            this.seats = seats;
            return this;
        }

        public CarBuilder setColor(String color) {
            this.color = color;
            return this;
        }

        public CarBuilder setSunroof(boolean sunroof) {
            this.sunroof = sunroof;
            return this;
        }

        public CarBuilder setNavigationSystem(boolean navigationSystem) {
            this.navigationSystem = navigationSystem;
            return this;
        }

        // ✅ Final step to build the Car
        public Car build() {
            return new Car(this);
        }
    }
}


public class Main {
    public static void main(String[] args) {
        Car car = new Car.CarBuilder()
                .setBrand("Toyota")
                .setEngine("V6")
                .setColor("White")
                .setSunroof(true)
                .setNavigationSystem(true)
                .build();

        System.out.println(car);
    }
}

```
```Java
public CarBuilder setBrand(String brand) {
  this.brand = brand;
  return this;
}
```
📌 What happens here?
- The builder sets the value of brand.
- Then it returns this — the current CarBuilder object — so the next method in the chain can be called on the same builder instance.


#### Why is the CarBuilder Static?
1. No Need for Car Instance:
   The CarBuilder doesn't need an instance of Car to create a new one, so it’s made static. You can use the builder without creating a Car object first.
2. Efficiency:
   It avoids unnecessary object creation. You don't need to instantiate Car just to use the builder.
   3.Simpler Usage:
   The static builder allows clients to create a Car object directly with Car.CarBuilder() without needing a separate builder instance.

