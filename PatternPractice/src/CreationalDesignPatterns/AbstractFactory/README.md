# What's different than Factory
Let’s say you’re building different types of cars:
   -  ElectricCar
   -  PetrolCar

Each car can come with a different interior and engine, based on the car brand:
   - Tesla makes Electric Cars
   - Toyota makes Petrol Cars

## Factory ( Normal flow )
```Java
interface Car {
    void drive();
}

class ElectricCar implements Car {
    public void drive() {
        System.out.println("Driving Electric Car");
    }
}

class PetrolCar implements Car {
    public void drive() {
        System.out.println("Driving Petrol Car");
    }
}

class CarFactory {
    public static Car getCar(String type) {
        return switch (type) {
            case "electric" -> new ElectricCar();
            case "petrol" -> new PetrolCar();
            default -> throw new IllegalArgumentException("Invalid car type");
        };
    }
}

Car car = CarFactory.getCar("electric");
car.drive();
```

### Limitation
You can only create one object type (just Car). What if you want to create multiple related objects (Car + Engine + Interior)? That’s where...
1. You’d end up creating separate factories for each of those object types:
``` Java
EngineFactory.getEngine("electric");
InteriorFactory.getInterior("luxury");
```

-  ❌ You risk mixing incompatible types (e.g., TeslaCar + ToyotaEngine)
-  ❌ No central point to guarantee compatibility
-  ❌ Client must know how to build and match everything

## Abstract Factory
- 🔧 Purpose:
  Provides a way to create families of related objects (e.g., Car + Engine + Interior), without specifying their concrete classes.

Let’s say both TeslaFactory and ToyotaFactory create:
- A Car (Car)
- An Engine (Engine)
- An Interior (Interior)

### Interfaces for families of products
```Java
interface Car {
    void drive();
}

interface Engine {
    void start();
}

interface Interior {
    void showFeatures();
}
```

#### Tesla and Toyota Product Implementation
```Java
class TeslaCar implements Car {
    public void drive() {
        System.out.println("Driving Tesla Car");
    }
}

class TeslaEngine implements Engine {
    public void start() {
        System.out.println("Starting Tesla Electric Engine");
    }
}

class TeslaInterior implements Interior {
    public void showFeatures() {
        System.out.println("Tesla Interior with Autopilot");
    }
}
```


```Java
class ToyotaCar implements Car {
    public void drive() {
        System.out.println("Driving Toyota Car");
    }
}

class ToyotaEngine implements Engine {
    public void start() {
        System.out.println("Starting Toyota Petrol Engine");
    }
}

class ToyotaInterior implements Interior {
    public void showFeatures() {
        System.out.println("Toyota Interior with Touchscreen");
    }
}
```

#### Abstract Factory
```Java
interface CarFactory {
    Car createCar();
    Engine createEngine();
    Interior createInterior();
}
```

#### Concrete Factory
```Java
class TeslaFactory implements CarFactory {
    public Car createCar() {
        return new TeslaCar();
    }

    public Engine createEngine() {
        return new TeslaEngine();
    }

    public Interior createInterior() {
        return new TeslaInterior();
    }
}

class ToyotaFactory implements CarFactory {
    public Car createCar() {
        return new ToyotaCar();
    }

    public Engine createEngine() {
        return new ToyotaEngine();
    }

    public Interior createInterior() {
        return new ToyotaInterior();
    }
}
```

#### Main
```Java
public class FactoryDemo {
    public static void main(String[] args) {
        CarFactory factory = new TeslaFactory(); // or new ToyotaFactory()

        Car car = factory.createCar();
        Engine engine = factory.createEngine();
        Interior interior = factory.createInterior();

        car.drive();
        engine.start();
        interior.showFeatures();
    }
}
```


#### Why is the CarBuilder Static?
1. No Need for Car Instance:
   The CarBuilder doesn't need an instance of Car to create a new one, so it’s made static. You can use the builder without creating a Car object first.
2. Efficiency:
   It avoids unnecessary object creation. You don't need to instantiate Car just to use the builder.
   3.Simpler Usage:
   The static builder allows clients to create a Car object directly with Car.CarBuilder() without needing a separate builder instance.

