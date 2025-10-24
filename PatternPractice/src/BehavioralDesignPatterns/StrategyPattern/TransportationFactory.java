package BehavioralDesignPatterns.StrategyPattern;

public class TransportationFactory {
    public static Transportation getTransportation(String type) {
        if (type.equalsIgnoreCase("BUS")) {
            return new Bus();
        } else if (type.equalsIgnoreCase("CAB")) {
            return new Cab();
        } else if (type.equalsIgnoreCase("BICYCLE")) {
            return new Bicycle();
        }
        throw new IllegalArgumentException("Invalid transportation type.");
    }
}
