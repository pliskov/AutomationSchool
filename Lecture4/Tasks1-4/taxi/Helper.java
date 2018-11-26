package taxi;

import taxi.cars.Car;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Helper {

    public static void writeParkToFile(List<Car> list, String path) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(path))) {
            for (Car aCar : list) {
                bw.write(aCar.printCar() + "\n");
            }
        } catch (IOException e) {
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

    public static List filterByParametersRange(List<Car> list) {
        return list.stream().filter(i -> i.getConsumption() >= 7 &&
                i.getConsumption() <= 8).collect(Collectors.toList());
    }

    public static List sortCarsListByConsumption(List<Car> list) {
        Comparator<Car> byConsumption = Comparator.comparingInt(Car::getConsumption);
        return list.stream().sorted(byConsumption).collect(Collectors.toList());
    }
}