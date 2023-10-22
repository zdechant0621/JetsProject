package com.skilldistillery.jets.entities;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Roster {
	private List<Jet> roster = new ArrayList<>();
	String fileName = "jets.txt";

	public Roster() {
		readRoster(fileName);
	}

	public void displayAllJets() {
		for (Jet jets : roster) {
			System.out.println(jets);

		}
	}

	public void flyAllJets() {
		System.out.println("Coach is mad the players lost. So he's making the Jets 'fly'(run) their max range.");
		for (Jet jets : roster) {
			jets.fly();
		}
	}

	private void readRoster(String fileName) {
		try (BufferedReader bufIn = new BufferedReader(new FileReader(fileName))) {
			String line;
			while ((line = bufIn.readLine()) != null) {
				Jet jets = null;
				String[] rosterRecord = line.split(", ");
				String position = rosterRecord[0];
				String name = rosterRecord[1];
				double speed = Double.parseDouble(rosterRecord[2]);
				int range = Integer.parseInt(rosterRecord[3]);
				long price = Long.parseLong(rosterRecord[4]);
				if (position.equals("Quarterback")) {
					jets = new QuarterBack(name, speed, range, price);
				}
				if (position.equals("Running Back")) {
					jets = new RunningBack(name, speed, range, price);
				}
				if (position.equals("Kicker")) {
					jets = new Kicker(name, speed, range, price);
				}

				roster.add(jets);
				
			}
		} catch (IOException e) {
			System.err.println(e);
		}

	}

	public void fastestJetsPlayer() {
		double topSpeed = 0.0;
		Jet fastestJetsPlayer = null;
		for (Jet jets : roster) {
			if (topSpeed < jets.getSpeedInMPH()) {
				topSpeed = jets.getSpeedInMPH();
				fastestJetsPlayer = jets;
			}

		}
		System.out.println(fastestJetsPlayer.getPosition() + " " + fastestJetsPlayer.getName()
				+ " is the fastest Jet at a top speed of " + fastestJetsPlayer.getSpeedInMPH() + " mph");
		System.out.println("for " + fastestJetsPlayer.getRunningRangeInMiles() + " miles. That's why he makes $"
				+ fastestJetsPlayer.getPrice());
	}

	public void longestRunningRange() {
		int runningRange = 0;
		Jet longestRunningRange = null;
		for (Jet jets : roster) {
			if (runningRange < jets.getRunningRangeInMiles()) {
				runningRange = jets.getRunningRangeInMiles();
				longestRunningRange = jets;
			}

		}
		System.out.println(longestRunningRange.getPosition() + " " + longestRunningRange.getName() + " can run for "
				+ longestRunningRange.getRunningRangeInMiles() + " miles");
		System.out.println("at a top speed of " + longestRunningRange.getSpeedInMPH() + " mph. That's why he makes $"
				+ longestRunningRange.getPrice());
	}

	public void passTheBall() {
		for (Jet jets : roster) {
			if (jets instanceof QuarterBack) {
				((QuarterBack) jets).passBall();
			}

		}

	}

	public void runTheBall() {
		for (Jet jets : roster) {
			if (jets instanceof RunningBack) {
				((RunningBack) jets).runBall();
			}
		}
	}

	public void addCustomJet(String name, double speedInMPH, int runningRangeInMiles, long price) {
		Jet newKicker = new Kicker(name, speedInMPH, runningRangeInMiles, price);
		roster.add(newKicker);
	}

	public void jetDisplayForCutting() {
		for (int i = 0; i < roster.size(); i++) {
			System.out.println(i+ ": "+roster.get(i));
		}

	}

	public void removeAJet(int userInput) {
		roster.remove(userInput);
	}
}
