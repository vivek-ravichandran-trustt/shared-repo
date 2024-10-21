package com.first.oops_abstract;

public class Bus extends Car{

	public Bus(String make, String model) {
		super(make, model);
		// TODO Auto-generated constructor stub
	}

	@Override
    public void drive() {
        System.out.println("Riding the bus: " + getMake() + " " + getModel());
    }
}
