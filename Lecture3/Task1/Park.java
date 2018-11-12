import park.Car;
import park.brand.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Park {
    public static void main(String[] args) {

        List<Car> park = new ArrayList<>();

        park.add(new Renault("Sandero", 10000, 8));
        park.add(new Renault("Duster", 11000, 9));
        park.add(new Renault("Kaptur", 13000, 8));
        park.add(new Renault("Stepway", 12000, 7));
        park.add(new Nissan("Almera", 9000, 8));
        park.add(new Nissan("Juke", 17500, 10));
        park.add(new Nissan("Almera", 9500, 8));
        park.add(new Volkswagen("Polo", 11000, 7));
        park.add(new Volkswagen("Polo", 11500, 7));
        park.add(new Volkswagen("Polo", 11500, 7));
        park.add(new Volkswagen("Polo", 11000, 8));

        double parkPrice = 0;
        for(int i = 0; i < park.size(); i++){
            parkPrice += park.get(i).getPrice();
        }
        System.out.println("Total park price: " + parkPrice);

        Collections.sort(park, new ConsumptionComparator());
        getCurrentList(park);

        park = filterByParametersRange(park);
        System.out.println("\nFind car by parameters range:");
        getCurrentList(park);
    }

    public static void getCurrentList(List<Car> list){
        for(int i = 0; i < list.size(); i++){
            System.out.println(list.get(i).getModel() + ": " + list.get(i).getConsumption());
        }
    }

    public static List filterByParametersRange(List<Car> list){
        list = list.stream().filter(i -> i.getConsumption() >= 7 &&
                i.getConsumption() <= 8).collect(Collectors.toList());
        return list;
    }
}

class ConsumptionComparator implements Comparator<Car>{
    @Override
    public int compare(Car o1, Car o2){
        return o1.getConsumption() - o2.getConsumption();
    }
}