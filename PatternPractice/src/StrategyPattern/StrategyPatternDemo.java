package StrategyPattern;

public class StrategyPatternDemo {
    public static void main(String[] args) {
        TransportContext context = new TransportContext();

        // Choosing a bus
        context.setStrategy(new Bus());
        context.goToAirport();

        // Choosing a cab
        context.setStrategy(new Cab());
        context.goToAirport();

        // Choosing a bicycle
        context.setStrategy(new Bicycle());
        context.goToAirport();
    }
}
