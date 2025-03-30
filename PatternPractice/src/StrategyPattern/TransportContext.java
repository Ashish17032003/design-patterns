package StrategyPattern;

public class TransportContext {
    private Transportation strategy;

    public void setStrategy(Transportation strategy) {
        this.strategy = strategy;
    }

    public void goToAirport() {
        strategy.travel();
    }
}
