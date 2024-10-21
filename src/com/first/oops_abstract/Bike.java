package com.first.oops_abstract;

public class Bike extends Car {

	public Bike(String make, String model) {
		super(make, model);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void drive() {
		System.out.println("Riding the bike: " + getMake() + " " + getModel());

	}

}
