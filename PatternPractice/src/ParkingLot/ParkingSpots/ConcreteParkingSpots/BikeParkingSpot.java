package ParkingLot.ParkingSpots.ConcreteParkingSpots;

import ParkingLot.ParkingSpots.ParkingSpot;
import ParkingLot.VehicleFactory.Vehicle;

public class BikeParkingSpot extends ParkingSpot {
    public BikeParkingSpot(int spotNumber, String spotType) {
        super(spotNumber, spotType);
    }

    @Override
    public boolean canParkVehicle(Vehicle vehicle) {
        return "Bike".equalsIgnoreCase(vehicle.getVehicleType());
    }
}
