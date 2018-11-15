package cars;

public class Car {
    public int price;
    public int consumption;

    public Car(int price, int consumption) {
        this.price = price;
        this.consumption = consumption;
    }

    public int getPrice() {
        return price;
    }

    public int getConsumption() {
        return consumption;
    }
}