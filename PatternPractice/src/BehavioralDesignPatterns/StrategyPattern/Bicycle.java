package BehavioralDesignPatterns.StrategyPattern;

public class Bicycle implements Transportation {

    @Override
    public void travel() {
        System.out.println("Riding a bicycle to the airport. It's free but tiring.");
    }
}
