package com.nk.functionalinterface.bifunction;

import java.util.function.BiFunction;
import java.util.function.Function;

public class BiFunctionExample {

	public static void main(String[] args) {

		// BiFunction
		BiFunction<String, String, Integer> bf = (x, y) -> (x + y).length();
		Integer bool = bf.apply("krishna", "krishna");
		System.out.println("bool : " + bool);

		// chain Function
		Function<Integer, String> bf1 = (x) -> (x + "");
		String length = bf.andThen(bf1).apply("krishna", "krishna");
		System.out.println("length : " + length);

		// BiFunction to create an object, acts as a factory pattern

		GPS biGps = factory(12.4354f, 23.243f, GPS::new);
		System.out.println("bigps :: " + biGps);

	}

	public static GPS factory(Float lat, Float longitude, BiFunction<Float, Float, GPS> func) {

		return func.apply(lat, longitude);

	}
}

class GPS {
	private float latitude;
	private float longitude;

	public GPS(float latitude, float longitude) {
		this.latitude = latitude;
		this.longitude = longitude;
	}

	@Override
	public String toString() {
		return "GPS [latitude=" + latitude + ", longitude=" + longitude + "]";
	}

}
