package ParkingLot.VehicleFactory.ConcreteVehicle;

import ParkingLot.FareStrategy.ParkingFareStrategy;
import ParkingLot.VehicleFactory.Vehicle;

public class OtherVehicle extends Vehicle {
    public OtherVehicle(String licensePlate, String vehicleType, ParkingFareStrategy feeStrategy) {
        super(licensePlate, vehicleType, feeStrategy);
    }
}
