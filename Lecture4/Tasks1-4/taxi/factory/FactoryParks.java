package taxi.factory;

import taxi.cars.Car;

import java.util.ArrayList;
import java.util.List;

public class FactoryParks {
    public static List<Car> createPark() {
        return new ArrayList<>();
    }
}