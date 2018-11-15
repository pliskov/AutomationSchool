package factory;

import cars.Car;
import cars.Nissan;
import cars.Renault;
import cars.Volkswagen;

public class FactoryCars {
    public static Car createCar(String carBrand, int price, int consumption) {
        switch (carBrand) {
            case "Nissan":
                return new Nissan(price, consumption);
            case "Renault":
                return new Renault(price, consumption);
            case "Volkswagen":
                return new Volkswagen(price, consumption);
            default:
                return null;
        }
    }
}