# Unit 2a Programming Project

For this project, you will be completing parts of the `Main` and `LeapYear` classes in order to fulfill the specs of each part below.

## PART A - LeapYear.java

For **PART A**, you need to complete the method `boolean isLeapYear(int year)` in the `LeapYear` class. A `year` is a leap year based on the following rules:

1. Everything before 1582 is not a leap year
2. Every year between 1582 and now that is exactly divisible by four is a leap year.
   - Years that are evenly divisble by 100 are not leap years unless they are evenly divisible by 400
     - Example: 1700, 1800, and 1900 are not leap years
     - Example: 1600 and 2000 are leap years

Your function should `return true` if the `year` is a leap year and `false` if the year is not a leap year.

## PART B - FastFoodPriceCalculator.java

In this part, you will write the body of a method that takes in three strings (an entree, side, and drink) then prints out the price of the order. There are discounts for getting certain combos, or for eating healthier. There is also tax. 

The method should NOT be case-sensitive. If any input is incorrect, it should return a price of -1.00 

Entrees: Burger, Pizza Slice, Salad
Side: Fries, Onion Rings, NONE
Drink: Soda, Water, NONE

Prices: 
- Burger: $6.99
- Pizza Slice: $4.99
- Salad: $5.99
- Fries: $2.25
- Onion Rings: $2.75
- Soda: $0.99
- Water: Free

Combo: burger & fries, or burger & onion rings (10% off)
Megacombo: burger with e ither fries or onion rings, and a soda (15% off)
Healthy: just a salad, or a salad with water. (20% off)

Tax: 10% (applied after discount)

All output should be rounded to the nearest cent. Use `Math.round(x * 100.0) / 100.0`. 

Hint: To make it not case sensitive, you probably want to use `toUpperCase()` or `toLowerCase()` from Java's `String` class. 

## PART C - Main.java

You will fill out the main method of this class. It will take in user input and use the method you created in Part B, with a prettier user interface.

You will need to create a `Scanner`, and an object of type `FastFoodPriceCalculator`. 

See the sample runs below for what the output should look like. 

Hint: To display the final price with exactly 2 decimal places every time, use `System.out.printf("%.2f", value)`. 

### Sample Runs

```
Entrees: Burger, Pizza Slice, Salad
What entree would you want?
> BURGER
Side: Fries, Onion Rings, NONE
What side would you want? 
> fries
Drink: Soda, Water, NONE
> NoNe
Your total price is $9.15
```

```
Entrees: Burger, Pizza Slice, Salad
What entree would you want?
> ASDASDFASDFASDFASDF
Side: Fries, Onion Rings, NONE
What side would you want? 
> fries
Drink: Soda, Water, NONE
> NoNe
Invalid Input, no price can be given
```

## Grading Breakdown

- Code compiles & runs without errors: 2 pts
- Formatting/indentation: 2 points
- All code commented: 2 points
- No public methods/attributes besides the ones specified: 2 point
- All code is DRY (Don't repeat yourself): 2 points
- Passes all 20 test cases: 20 points (1 per unit test)

*Total: 30 points*

## Extra Credit - Text Adventure Game

You now have all you need (variables, if statements, Scanner) to make a choose your own text-based adventure game!
Make one for Mr. Hsieh and your friends to play. 

Make a new file with a class that has it's own main function, and have the game run from there.

### Text Adventure Game - Simple Example
Something like this would be 1 point of extra credit. 

```
You want to go to the bathroom. 
You are currently in class. 
What would you like to do?
(1) Go to the bathroom
(2) Raise your hand
(3) wait
Your choice: 3

You wait for a long time. You can't hold it anymore. It's explosive. 
GAME OVER. 
```

### Text Adventure Game - Complex Example
Something like this would be 2 points of extra credit. 3 points if it's a 20+ minute game. 
```
You wake up in a wagon, your arms are shackled together. 
A man in rags, probably a fellow prisoner, speaks to you. 
"Hey you, you're finally awake."
What do you do? (type 'help' for a list of options)
> help
---------
Help
---------
look - see what is around you
use <item> - use an item
go <direction> - move in a particular direction
Other words might exist based on context! 
---------
What do you do? (type 'help' for a list of options)
> look
You see the green scenery passing by. You see a man sitting near you.
What do you do? (type 'help' for a list of options)
> talk 
Please specify a target to talk to.
What do you do? (type 'help' for a list of options)
> talk man
What would you like to ask the man? 
(1) Where are we?
(2) Who are you? 
(3) What are you in for? 
...
etc
```

