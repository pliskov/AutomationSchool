package taxi.cars;

public class Nissan extends Car {

    public Nissan(int price, int consumption) {
        super(price, consumption);
    }

    @Override
    public String toString() {
        return "Nissan{" +
                "price=" + price +
                ", consumption=" + consumption +
                '}';
    }

    @Override
    public String printCar() {
        return "Nissan," + price + "," + consumption;
    }
}