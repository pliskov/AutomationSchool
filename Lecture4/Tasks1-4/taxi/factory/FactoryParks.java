package taxi.factory;

import taxi.CreatingParkException;
import taxi.cars.Car;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FactoryParks {
    public static List<Car> createPark() {
        String inputFile = "Lecture4/Tasks1-4/taxi/cars.csv";
        String line;
        String splitBy = "\\s*(\\s|,|!|\\.)\\s*";

        List<Car> list = new ArrayList<>();
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
                } else System.out.println("Some numeric car parameter is incorrect");
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
}