package com.first.oops_abstract;

abstract class Car {
    private String make;
    private String model;

    public Car(String make, String model) {
        this.make = make;
        this.model = model;
    }

    public abstract void drive();

    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }
}

