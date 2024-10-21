package com.first.oops_abstract;

import java.util.Scanner;

public class CarUser {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		
		CarService car = new CarService();
		car.createObject(str);
		
		
	}

}
