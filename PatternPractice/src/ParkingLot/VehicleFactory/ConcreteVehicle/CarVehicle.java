package ParkingLot.VehicleFactory.ConcreteVehicle;

import ParkingLot.FareStrategy.ParkingFareStrategy;
import ParkingLot.VehicleFactory.Vehicle;

public class CarVehicle extends Vehicle {
    public CarVehicle(String licensePlate, String vehicleType, ParkingFareStrategy feeStrategy) {
        super(licensePlate, vehicleType, feeStrategy);
    }
}
