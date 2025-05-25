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
1  public class Car {
2  private String engine;
3  private int wheels;
4  private int seats;
5  private String color;
6  private boolean sunroof;
7  private boolean navigationSystem;
8  // Car constructor should be private, ensuring it's only created through the
9
10  // builder
11  private Car(CarBuilder builder) {
12    this.engine = builder.engine;
13    this.wheels = builder.wheels;
14    this.seats = builder.seats;
15    this.color = builder.color;
16    this.sunroof = builder.sunroof;
17    this.navigationSystem = builder.navigationSystem;
18  }
19
20  // Getter methods for the fields
21  public String getEngine() {
22    return engine;
23  }
24  public int getWheels() {
25    return wheels;
26  }
27  public int getSeats() {
28    return seats;
29  }
30  public String getColor() {
31    return color;
32  }
33  public boolean hasSunroof() {
34    return sunroof;
35  }
36  public boolean hasNavigationSystem() {
37    return navigationSystem;
38  }
39  @Override
40  public String toString() {
41    return "Car [engine=" + engine + ", wheels=" + wheels + ", seats=" + seats
42        + ", color=" + color + ", sunroof=" + sunroof
43        + ", navigationSystem=" + navigationSystem + "]";
44  }
45
46  // CarBuilder nested class
47  public static class CarBuilder {
48    private String engine;
49    private int wheels = 4; // Default value
50    private int seats = 5; // Default value
51    private String color = "Black"; // Default value
52    private boolean sunroof = false; // Default value
53    private boolean navigationSystem = false; // Default value
54
55    // Builder methods to set attributes
56    public CarBuilder setEngine(String engine) {
57      this.engine = engine;
58      return this;
59    }
60    public CarBuilder setWheels(int wheels) {
61      this.wheels = wheels;
62      return this;
63    }
64    public CarBuilder setSeats(int seats) {
65      this.seats = seats;
66      return this;
67    }
68    public CarBuilder setColor(String color) {
69      this.color = color;
70      return this;
71    }
72    public CarBuilder setSunroof(boolean sunroof) {
73      this.sunroof = sunroof;
74      return this;
75    }
76    public CarBuilder setNavigationSystem(boolean navigationSystem) {
77      this.navigationSystem = navigationSystem;
78      return this;
79    }
80
81    // Build method to create a Car object
82    public Car build() {
83      return new Car(
84          this); // Return a new Car created using the builder's values
85    }
86  }
87  }
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

