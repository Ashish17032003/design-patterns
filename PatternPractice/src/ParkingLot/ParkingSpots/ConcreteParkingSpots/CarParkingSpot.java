package ParkingLot.ParkingSpots.ConcreteParkingSpots;

import ParkingLot.ParkingSpots.ParkingSpot;
import ParkingLot.VehicleFactory.Vehicle;

public class CarParkingSpot extends ParkingSpot {
    public CarParkingSpot(int spotNumber, String spotType) {
        super(spotNumber, spotType);
    }

    @Override
    public boolean canParkVehicle(Vehicle vehicle) {
        return "Car".equalsIgnoreCase(vehicle.getVehicleType());
    }
}
