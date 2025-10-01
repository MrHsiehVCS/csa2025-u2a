package u2a;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static com.github.stefanbirkner.systemlambda.SystemLambda.tapSystemOut;
import static com.github.stefanbirkner.systemlambda.SystemLambda.withTextFromSystemIn;

/**
 * Unit Tests for Unit 3 Programming Project
 */
public class MainTests {

    //   - invalid input 1

    @Test
    void main_invalidInputEntree_correctOutput() throws Exception {
        String EOL = System.getProperty("line.separator");
        String expectedText = "Entrees: Burger, Pizza Slice, Salad" + EOL
            + "What entree would you want?" + EOL
            + "> "
            + "Side: Fries, Onion Rings, NONE" + EOL
            + "What side would you want?" + EOL
            + "> "
            + "Drink: Soda, Water, NONE" + EOL
            + "> "
            + "Invalid Input, no price can be given" + EOL;
        String studentText = tapSystemOut(() -> {
            withTextFromSystemIn("ASDFASDF", "fries", "None").execute(() -> Main.main(null));
        });

        assertEquals(expectedText, studentText);
    }

    @Test
    void main_invalidInputSide_correctOutput() throws Exception {
        String EOL = System.getProperty("line.separator");
        String expectedText = "Entrees: Burger, Pizza Slice, Salad" + EOL
            + "What entree would you want?" + EOL
            + "> "
            + "Side: Fries, Onion Rings, NONE" + EOL
            + "What side would you want?" + EOL
            + "> "
            + "Drink: Soda, Water, NONE" + EOL
            + "> "
            + "Invalid Input, no price can be given" + EOL;
        String studentText = tapSystemOut(() -> {
            withTextFromSystemIn("Burger", "qwertylol", "Soda").execute(() -> Main.main(null));
        });

        assertEquals(expectedText, studentText);
    }


    //.  - happy path 1 - pizza with stuff

    @Test
    void main_pizzaSideDrink_correctOutput() throws Exception {
        String EOL = System.getProperty("line.separator");
        String expectedText = "Entrees: Burger, Pizza Slice, Salad" + EOL
            + "What entree would you want?" + EOL
            + "> "
            + "Side: Fries, Onion Rings, NONE" + EOL
            + "What side would you want?" + EOL
            + "> "
            + "Drink: Soda, Water, NONE" + EOL
            + "> "
            + "Your total price is $9.05" + EOL;
        String studentText = tapSystemOut(() -> {
            withTextFromSystemIn("Pizza slice", "fries", "Soda").execute(() -> Main.main(null));
        });

        assertEquals(expectedText, studentText);
    }

        @Test
    void main_megacombo_correctOutput() throws Exception {
        String EOL = System.getProperty("line.separator");
        String expectedText = "Entrees: Burger, Pizza Slice, Salad" + EOL
            + "What entree would you want?" + EOL
            + "> "
            + "Side: Fries, Onion Rings, NONE" + EOL
            + "What side would you want?" + EOL
            + "> "
            + "Drink: Soda, Water, NONE" + EOL
            + "> "
            + "Your total price is $9.57" + EOL;
        String studentText = tapSystemOut(() -> {
            withTextFromSystemIn("burger", "fries", "Soda").execute(() -> Main.main(null));
        });

        assertEquals(expectedText, studentText);
    }

    @Test
    void main_healthy_correctOutput() throws Exception {
        String EOL = System.getProperty("line.separator");
        String expectedText = "Entrees: Burger, Pizza Slice, Salad" + EOL
            + "What entree would you want?" + EOL
            + "> "
            + "Side: Fries, Onion Rings, NONE" + EOL
            + "What side would you want?" + EOL
            + "> "
            + "Drink: Soda, Water, NONE" + EOL
            + "> "
            + "Your total price is $5.27" + EOL;
        String studentText = tapSystemOut(() -> {
            withTextFromSystemIn("salad", "none", "water").execute(() -> Main.main(null));
        });

        assertEquals(expectedText, studentText);
    }

}
