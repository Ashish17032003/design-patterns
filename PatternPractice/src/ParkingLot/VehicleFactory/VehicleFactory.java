package ParkingLot.VehicleFactory;

import ParkingLot.FareStrategy.ParkingFareStrategy;
import ParkingLot.VehicleFactory.ConcreteVehicle.BikeVehicle;
import ParkingLot.VehicleFactory.ConcreteVehicle.CarVehicle;
import ParkingLot.VehicleFactory.ConcreteVehicle.OtherVehicle;

public class VehicleFactory {
    public static Vehicle createVehicle(String vehicleType, String licensePlate, ParkingFareStrategy feeStrategy) {
        if (vehicleType.equalsIgnoreCase("Car")) {
            return new CarVehicle(licensePlate, vehicleType, feeStrategy);
        } else if (vehicleType.equalsIgnoreCase("Bike")) {
            return new BikeVehicle(licensePlate, vehicleType, feeStrategy);
        }
        return new OtherVehicle(licensePlate, vehicleType, feeStrategy); // For unsupported vehicle types
    }
}
