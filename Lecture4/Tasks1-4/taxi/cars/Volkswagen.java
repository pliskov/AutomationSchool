package taxi.cars;

import taxi.cars.Car;

public class Volkswagen extends Car {

    public Volkswagen(int price, int consumption) {
        super(price, consumption);
    }

    @Override
    public int getPrice() {
        return price;
    }

    @Override
    public int getConsumption() {
        return consumption;
    }

    @Override
    public String toString() {
        return "Volkswagen{" +
                "price=" + price +
                ", consumption=" + consumption +
                '}';
    }

    @Override
    public String printCar() {
        return "Volkswagen," + price + "," + consumption;
    }
}