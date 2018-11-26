package taxi;

import taxi.factory.FactoryParks;

import java.util.List;

public final class ParkTaxi {
    public static void main(String[] args) {

        List myPark = FactoryParks.createPark();

        System.out.println("\nTotal park price: " + Helper.getParkPrice(myPark));

        System.out.println("\nAll park sorted by consumption:\n" + Helper.sortCarsListByConsumption(myPark));

        System.out.println("\nFind cars by parameters range:\n" + Helper.filterByParametersRange(myPark));

        Helper.writeParkToFile(Helper.filterByParametersRange(myPark), "Lecture4/Tasks1-4/taxi/out.txt");
    }
}