## Strategy
1. Choosing Behavior dynamically  
2. Interface that has common behavior for all strategies (Transportation Strategy)
3. Concrete Strategies ( Different Behaviors ) -> Implementation of the interface (Car, Bus, Cab, BiCycle)
4. Context class that uses the strategy
```Java
public class TransportContext {
    private Transportation strategy;
     
    // We Inject behavior ourself at runtime
    public void setStrategy(Transportation strategy) {
        this.strategy = strategy;
    }

    public void goToAirport() {
        strategy.travel();
    }
}
```
Holds a reference to a strategy
Calls the strategy’s method — doesn't care which one it is

5. Client chooses which strat to use