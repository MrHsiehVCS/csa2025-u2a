package u2a;

public class FastFoodPriceCalculator {
// In this part, you will write the body of a method that takes in three strings (an entree, side, and drink) then prints out the price of the order. There are discounts for getting certain combos, or for eating healthier. There is also tax. 

    public double calculatePrice(String entree, String side, String drink) {

        entree = entree.toUpperCase();
        side = side.toUpperCase();
        drink = drink.toUpperCase();

        if ( !(entree.equals("BURGER") || entree.equals("PIZZA SLICE") || entree.equals("SALAD")) ) {
            return -1.0;
        }
        if ( !(side.equals("FRIES") || side.equals("ONION RINGS") || side.equals("NONE")) ) {
            return -1.0;
        }
        if ( !(drink.equals("SODA") || drink.equals("WATER") || drink.equals("NONE")) ) {
            return -1.0;
        }
        double price = 0.0;
        if (entree.equals("BURGER")) {
            price += 6.99;
        } else if (entree.equals("PIZZA SLICE")) {
            price += 4.99;
        } else if (entree.equals("SALAD")) {
            price += 5.99;
        }       

        if (side.equals("FRIES")) {
            price += 2.25;
        } else if (side.equals("ONION RINGS")) {
            price += 2.75;
        }   

        if (drink.equals("SODA")) {
            price += 0.99;
        } else if (drink.equals("WATER")) {
            price += 0.0;
        }
        // Combos
        if ( (entree.equals("BURGER") && side.equals("FRIES") && drink.equals("SODA")) || (entree.equals("BURGER") && side.equals("ONION RINGS") && drink.equals("SODA")) ) {
            price = price * 0.85;
        } else if ( (entree.equals("BURGER") && side.equals("FRIES")) || (entree.equals("BURGER") && side.equals("ONION RINGS")) ) {
            price = price * 0.9;
        } else if ( (entree.equals("SALAD") && side.equals("NONE") && drink.equals("NONE")) || (entree.equals("SALAD") && side.equals("NONE") && drink.equals("WATER")) ) {
            price = price * 0.8;
        }

        price = price * 1.1; // tax
        price = Math.round(price * 100.0) / 100.0;

// The method should NOT be case-sensitive. If any input is incorrect, it should return a price of -1.00 

// Entrees: Burger, Pizza Slice, Salad
// Side: Fries, Onion Rings, NONE
// Drink: Soda, Water, NONE

// Prices: 
// - Burger: $6.99
// - Pizza Slice: $4.99
// - Salad: $5.99
// - Fries: $2.25
// - Onion Rings: $2.75
// - Soda: $0.99
// - Water: Free

// Combos: (10% off)
// - burger & fries
// -  burger & onion rings 
// Megacombo: (15% off) 
// - burger fries soda 
// - burger onion rings soda 
// Healthy (20% off)
// - just a salad
// - a salad with water. 

// Tax: 10% (applied after discount)

// All output should be rounded to the nearest cent. Use `Math.round(x * 100.0) / 100.0`. 

// Hint: To make it not case sensitive, you probably want to use `toUpperCase()` or `toLowerCase()` from Java's `String` class. 
        return price;
    }

}