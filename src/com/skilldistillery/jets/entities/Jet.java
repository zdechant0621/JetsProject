package com.skilldistillery.jets.entities;

public abstract class Jet {
	private String position = this.getClass().getSimpleName();
	private String name;
	private double speedInMPH;
	private int runningRangeInMiles;
	private long price;

	public Jet(String name, double speedInMPH, int runningRangeInMiles, long price) {
		this.name = name;
		this.speedInMPH = speedInMPH;
		this.runningRangeInMiles = runningRangeInMiles;
		this.price = price;

	}

	public void fly() {
		System.out.println(this.position + " " + this.name + " is running for ");
		System.out.println(getrunningTimeinMinutes(speedInMPH, runningRangeInMiles) + " minutes for "
				+ runningRangeInMiles + " miles.");
	}

	@Override
	public String toString() {
		return "Jets " + position + " Name: " + name + ", Top Speed: " + speedInMPH + ", Running Range: "
				+ runningRangeInMiles + ", Contract Price: " + price;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public double getrunningTimeinMinutes(double speedInMPH, double runningRangeinMiles) {
		double runningTimeinMinutes = (runningRangeinMiles / speedInMPH) * 60;
		return runningTimeinMinutes;

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getSpeedInMPH() {
		return speedInMPH;
	}

	public void setSpeedInMPH(double speedInMPH) {
		this.speedInMPH = speedInMPH;
	}

	public long getPrice() {
		return price;
	}

	public int getRunningRangeInMiles() {
		return runningRangeInMiles;
	}

	public void setRunningRangeInMiles(int runningRangeInMiles) {
		this.runningRangeInMiles = runningRangeInMiles;
	}

	public void setPrice(long price) {
		this.price = price;
	}

}
