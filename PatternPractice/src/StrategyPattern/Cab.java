package StrategyPattern;

public class Cab implements Transportation{

    @Override
    public void travel() {
        System.out.println("Taking a cab to the airport. It's fast but expensive.");
    }
}
