package com.first.oops_abstract;

public class CarService {

	public void createObject(String car) {
		if (car.equals("bus") ){
			 new Bus("ABC", "EFG").drive();
		} else {
			 new Bike("Hero", "Honda").drive();
		}
	}
}
