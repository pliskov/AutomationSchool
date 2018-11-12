package park.brand;

import park.Car;

public class Renault extends Car {
    private String model;
    private int price;
    private int consumption;

    public Renault(String model, int price, int consumption){
        this.model = model;
        this.price = price;
        this.consumption = consumption;
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
    public String getModel() {
        return model;
    }
}