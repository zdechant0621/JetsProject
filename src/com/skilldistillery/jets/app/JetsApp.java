package com.skilldistillery.jets.app;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.skilldistillery.jets.entities.Jet;
import com.skilldistillery.jets.entities.Roster;

public class JetsApp {

	Scanner sc = new Scanner(System.in);
	public boolean quit = false;
	Roster roster = new Roster();

	public static void main(String[] args) {
		JetsApp app = new JetsApp();
		app.launch();

	}

	public void launch() {
		while (!quit) {
			displayUserMenu();
		}

	}

	public void displayUserMenu() {
		System.out.println("Please enter a number to access the options below");
		System.out.println("1. List All Jets");
		System.out.println("2. Fly All Jets");
		System.out.println("3. Showcase The Fastest Jet");
		System.out.println("4. Showcase The Jet That Can Run The Furthest");
		System.out.println("5. Pass The Ball");
		System.out.println("6. Run The Ball");
		System.out.println("7. Add A Custom Jet To The Roster");
		System.out.println("8. Remove a Jet From The Roster");
		System.out.println("9. Quit");
		int userInput = sc.nextInt();
		menuOptions(userInput);
	}

	public void menuOptions(int userInput) {

		switch (userInput) {
		case 1:
			roster.displayAllJets();
			break;
		case 2:
		roster.flyAllJets();
			break;
		case 3:
			roster.fastestJetsPlayer();
			break;
		case 4:
			roster.longestRunningRange();
			break;
		case 5:
			roster.passTheBall();
			break;
		case 6:
			roster.runTheBall();
			break;
		case 7:

			customJet();
			break;
		case 8:
			cutJet();
			break;
			
		case 9:
			quit = true;
			System.out.println("Have a good day!!");
			break;
		default:
			System.err.println("Must be a Patriots fan. Try putting in a correct option 1-9.");
			break;

		}
	}

	public void customJet() {
		try {
			sc.nextLine();
			System.out.println("Please add a first and last name");
			String name = sc.nextLine();
			System.out.println("Please enter the kicker's top speed");
			double speedInMPH = sc.nextDouble();
			sc.nextLine();
			System.out.println("Please enter the number of miles your kicker can run");
			int runningRangeInMiles = sc.nextInt();
			sc.nextLine();
			System.out.println("Please enter the contract price for your kicker");
			long price = sc.nextLong();
			System.out.println("Your Jet has been added!");
			sc.nextLine();

			roster.addCustomJet(name, speedInMPH, runningRangeInMiles, price);
		} catch (IndexOutOfBoundsException e) {
			System.err.println("Try again");
		}
	}

	public void cutJet() {
		try {
			System.out.println("Which Jet are you cutting from the roster?");
			System.out.println("Enter a number: ");
			roster.jetDisplayForCutting();
			int userInput = sc.nextInt();
			sc.nextLine();
			roster.removeAJet(userInput);

		} catch (IndexOutOfBoundsException e) {
			System.err.println("Try again");
		}
	}
}
