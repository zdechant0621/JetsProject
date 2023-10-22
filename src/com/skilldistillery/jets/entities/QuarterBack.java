package com.skilldistillery.jets.entities;

public class QuarterBack extends Jet implements Pass {

	public QuarterBack(String name, double speedInMPH, int runningRangeinMiles, long price) {
		super(name, speedInMPH, runningRangeinMiles, price);

	}

	@Override
	public void passBall() {
		System.out.println("Interception!!");
	}

}
