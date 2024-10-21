package com.first.stream;

import java.util.List;

public class StreamAPI {

	public static void main(String[] args) {
		List.of(15, 20, 48, 63, 49, 27, 56, 32, 9)
		       .stream()
		       //.sorted()
		       .forEach(val -> System.out.println(val));
	}

}
