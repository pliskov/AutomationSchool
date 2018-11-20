package taxi;

import taxi.cars.Car;
import taxi.factory.FactoryCars;
import taxi.factory.FactoryParks;

import java.io.*;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public final class ParkTaxi {
    public static void main(String[] args) {

        List<Car> myPark = FactoryParks.createPark();
        getCarsFromFile(myPark);

        System.out.println("\nTotal park price: " + getParkPrice(myPark));

        Collections.sort(myPark, new ConsumptionComparator());
        System.out.println("\nAll park sorted by consumption:\n" + myPark);

        System.out.println("\nFind cars by parameters range:\n" + filterByParametersRange(myPark));
        writeParkToFile(filterByParametersRange(myPark));
    }

    public static List getCarsFromFile(List<Car> list) {
        String inputFile = "Lecture4/Tasks1-4/taxi/cars.csv";
        String line;
        String splitBy = "\\s*(\\s|,|!|\\.)\\s*";

        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(inputFile)));
            while ((line = br.readLine()) != null) {
                String[] inputCarsArray = line.split(splitBy);
                if (inputCarsArray[1].matches("\\d*") && inputCarsArray[2].matches("\\d*")) {
                    try {
                        list.add(FactoryCars.createCar(inputCarsArray[0], Integer.parseInt(inputCarsArray[1]),
                                Integer.parseInt(inputCarsArray[2])));
                    } catch (CreatingParkException e) {
                        e.printStackTrace();
                    }
                }
                else System.out.println("Some numeric car parameter is incorrect");
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            System.out.println("..reading of initialization file has been finished");
        }
        return list;
    }

    public static void writeParkToFile(List<Car> list) {
        final String outFname = "Lecture4/Tasks1-4/taxi/out.txt";
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(outFname)))
        {
            for (Car aCar : list) {
                bw.write(aCar.printCar() + "\n");
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
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