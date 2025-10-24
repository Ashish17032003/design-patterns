package BehavioralDesignPatterns.StrategyPattern;

public class Bus implements Transportation{

    @Override
    public void travel() {
        System.out.println("Taking the bus to the airport. It's cheap but slow.");
    }
}
