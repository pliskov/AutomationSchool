package taxi.factory;

import taxi.CreatingParkException;
import taxi.cars.Car;
import taxi.cars.Nissan;
import taxi.cars.Renault;
import taxi.cars.Volkswagen;

public class FactoryCars {
    public static Car createCar(String carBrand, int price, int consumption) throws CreatingParkException {
        if(price > 0 && consumption > 0) {
            switch (carBrand) {
                case "Nissan":
                    return new Nissan(price, consumption);
                case "Renault":
                    return new Renault(price, consumption);
                case "Volkswagen":
                    return new Volkswagen(price, consumption);
                default:
                    throw new CreatingParkException("Try to create a car with nonexistent car brand");
            }
        }
        else if (price <= 0) {
            throw new CreatingParkException("Try to create a car with negative price value");
        }
        else {
            throw new CreatingParkException("Try to create a car with negative consumption value");
        }
    }
}