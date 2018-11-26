package taxi.cars;

public class Renault extends Car {

    public Renault(int price, int consumption) {
        super(price, consumption);
    }

    @Override
    public String toString() {
        return "Renault{" +
                "price=" + price +
                ", consumption=" + consumption +
                '}';
    }

    @Override
    public String printCar() {
        return "Renault," + price + "," + consumption;
    }
}