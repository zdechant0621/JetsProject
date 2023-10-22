package com.skilldistillery.jets.entities;

public class RunningBack extends Jet implements Run {

	public RunningBack(String name, double speedInMPH, int runningRangeinMiles, long price) {
		super(name, speedInMPH, runningRangeinMiles, price);
	}

	@Override
	public void runBall() {
		System.out.println("Fumble!!");

	}

}
