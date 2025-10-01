package u2a;

import java.util.Scanner;

/**
 * YOUR COMMENTS HERE
 * 
 * @author YOUR NAME HERE
 */

class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		FastFoodPriceCalculator ffpc = new FastFoodPriceCalculator();

		System.out.println("Entrees: Burger, Pizza Slice, Salad");
		System.out.print("What entree would you want?" + System.lineSeparator() + "> ");
		String entree = scanner.nextLine().trim();

		System.out.println("Side: Fries, Onion Rings, NONE");
		System.out.print("What side would you want?" + System.lineSeparator() + "> ");
		String side = scanner.nextLine().trim();

		System.out.println("Drink: Soda, Water, NONE");
		System.out.print("> ");
		String drink = scanner.nextLine().trim();

		Double price = ffpc.calculatePrice(entree, side, drink);
		if (price < 0) {
			System.out.println("Invalid Input, no price can be given");
		} else {
			System.out.printf("Your total price is $%.2f%n", price);
		}

		scanner.close();
	}
}