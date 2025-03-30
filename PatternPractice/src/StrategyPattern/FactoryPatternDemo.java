package StrategyPattern;

public class FactoryPatternDemo {
    public static void main(String[] args) {
        // No TravelContext, client calls factory directly
        Transportation transport1 = TransportationFactory.getTransportation("BUS");
        transport1.travel();

        Transportation transport2 = TransportationFactory.getTransportation("CAB");
        transport2.travel();

        Transportation transport3 = TransportationFactory.getTransportation("BICYCLE");
        transport3.travel();
    }
}
