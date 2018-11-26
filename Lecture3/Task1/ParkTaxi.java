import cars.Car;
import factory.FactoryCars;
import factory.FactoryParks;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public final class ParkTaxi {
    public static void main(String[] args) {

        List<Car> myPark = FactoryParks.createPark();
        myPark.add(FactoryCars.createCar("Nissan", 10000, 8));
        myPark.add(FactoryCars.createCar("Renault", 9500, 10));
        myPark.add(FactoryCars.createCar("Volkswagen", 15000, 7));
        myPark.add(FactoryCars.createCar("Volkswagen", 21000, 7));

        System.out.println("Total park price: " + getParkPrice(myPark));

        Collections.sort(myPark, new ConsumptionComparator());
        System.out.println("All park sorted by consumption:\n" + myPark);

        System.out.println("\nFind cars by parameters range:\n" + filterByParametersRange(myPark));
    }

    public static double getParkPrice(List<Car> list) {
        double parkPrice = 0;
        for (Car aPark : list) {
            parkPrice += aPark.getPrice();
        }
        return parkPrice;
    }

    private static List filterByParametersRange(List<Car> list) {
        return list.stream().filter(i -> i.getConsumption() >= 7 &&
                i.getConsumption() <= 8).collect(Collectors.toList());
    }
}

class ConsumptionComparator implements Comparator<Car> {
    @Override
    public int compare(Car o1, Car o2) {
        return o1.getConsumption() - o2.getConsumption();
    }
}