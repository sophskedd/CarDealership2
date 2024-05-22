package org.example;

import java.util.Objects;

public class Car extends Vehicle {
    public Car(String brand, String color, int price) {
        super(brand, color, price);
    }

    @Override
    public void displayDetails() {
        System.out.println("Car Details: Brand=" + brand + ", Color=" + color + ", Price=" + price);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return price == car.price && brand.equals(car.brand) && color.equals(car.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(brand, color, price);
    }
}
