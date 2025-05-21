package ParkingLot.VehicleFactory.ConcreteVehicle;

import ParkingLot.FareStrategy.ParkingFareStrategy;
import ParkingLot.VehicleFactory.Vehicle;

public class BikeVehicle extends Vehicle {
    public BikeVehicle(String licensePlate, String vehicleType, ParkingFareStrategy feeStrategy) {
        super(licensePlate, vehicleType, feeStrategy);
    }
}
