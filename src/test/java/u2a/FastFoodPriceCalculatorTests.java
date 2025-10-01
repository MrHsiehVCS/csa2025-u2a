package u2a;



import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.assertEquals;



public class FastFoodPriceCalculatorTests {

    private FastFoodPriceCalculator ffpc;
    private final double EPSILON = 0.0001;

    @BeforeEach
    private void before() {
        ffpc = new FastFoodPriceCalculator();
    }

    @Test
    public void calculatePrice_invalidInput_returnsCorrectValue() {
        Double output = ffpc.calculatePrice("ASDF", "ASDF", "WATER");
        assertEquals(-1.0, output, EPSILON);

        output = ffpc.calculatePrice("BURGER", "ASDF", "NONE");
        assertEquals(-1.0, output, EPSILON);

        output = ffpc.calculatePrice("BURGER", "FRIES", "ASDF");
        assertEquals(-1.0, output, EPSILON);
    }

    @Test
    public void calculatePrice_justFastFoodEntree_returnsCorrectValue() {
        Double output = ffpc.calculatePrice("BURGER", "NONE", "NONE");
        Double expectedPrice = 6.99;
        expectedPrice = expectedPrice * 1.1; // tax
        expectedPrice = Math.round(expectedPrice * 100.0) / 100.0;
        assertEquals(expectedPrice, output, EPSILON);

        output = ffpc.calculatePrice("PIZZA SLICE", "NONE", "NONE");
        expectedPrice = 4.99;
        expectedPrice = expectedPrice * 1.1; // tax
        expectedPrice = Math.round(expectedPrice * 100.0) / 100.0;
        assertEquals(expectedPrice, output, EPSILON);
    }

    @Test
    public void calculatePrice_justFastFoodEntreeCaseInsensitive_returnsCorrectValue() {
        Double output = ffpc.calculatePrice("burger", "NONE", "none");
        Double expectedPrice = 6.99;
        expectedPrice = expectedPrice * 1.1; // tax
        expectedPrice = Math.round(expectedPrice * 100.0) / 100.0;
        assertEquals(expectedPrice, output, EPSILON);

        output = ffpc.calculatePrice("PizZa SlIcE", "noNE", "NoNe");
        expectedPrice = 4.99;
        expectedPrice = expectedPrice * 1.1; // tax
        expectedPrice = Math.round(expectedPrice * 100.0) / 100.0;
        assertEquals(expectedPrice, output, EPSILON);
    }

    @Test
    public void calculatePrice_entreePlusSidesNoCombo_returnsCorrectValue() {
        Double output = ffpc.calculatePrice("PIZZA SLICE", "FRIES", "none");
        Double expectedPrice = 4.99 + 2.25;
        expectedPrice = expectedPrice * 1.1; // tax
        expectedPrice = Math.round(expectedPrice * 100.0) / 100.0;
        assertEquals(expectedPrice, output, EPSILON);

        output = ffpc.calculatePrice("PizZa SlIcE", "onion rings", "NoNe");
        expectedPrice = 4.99 + 2.75;
        expectedPrice = expectedPrice * 1.1; // tax
        expectedPrice = Math.round(expectedPrice * 100.0) / 100.0;
        assertEquals(expectedPrice, output, EPSILON);

        output = ffpc.calculatePrice("Salad", "fries", "NoNe");
        expectedPrice = 5.99 + 2.25;
        expectedPrice = expectedPrice * 1.1; // tax
        expectedPrice = Math.round(expectedPrice * 100.0) / 100.0;
        assertEquals(expectedPrice, output, EPSILON);
    }

    @Test
    public void calculatePrice_entreePlusDrinksNoCombo_returnsCorrectValue() {
        Double output = ffpc.calculatePrice("PIZZA SLICE", "None", "SODA");
        Double expectedPrice = 4.99 + 0.99;
        expectedPrice = expectedPrice * 1.1; // tax
        expectedPrice = Math.round(expectedPrice * 100.0) / 100.0;
        assertEquals(expectedPrice, output, EPSILON);

        output = ffpc.calculatePrice("PizZa SlIcE", "none", "WATER");
        expectedPrice = 4.99;
        expectedPrice = expectedPrice * 1.1; // tax
        expectedPrice = Math.round(expectedPrice * 100.0) / 100.0;
        assertEquals(expectedPrice, output, EPSILON);

        // TODO: Salad + Soda
    }


    @Test
    public void calculatePrice_pizzePlusSidesAndDrinks_returnsCorrectValue() {
        Double output = ffpc.calculatePrice("PIZZA SLICE", "Fries", "SODA");
        Double expectedPrice = 4.99 + 2.25 + 0.99;
        expectedPrice = expectedPrice * 1.1; // tax
        expectedPrice = Math.round(expectedPrice * 100.0) / 100.0;
        assertEquals(expectedPrice, output, EPSILON);

        output = ffpc.calculatePrice("PizZa SlIcE", "Onion Rings", "WATER");
        expectedPrice = 4.99 + 2.75;
        expectedPrice = expectedPrice * 1.1; // tax
        expectedPrice = Math.round(expectedPrice * 100.0) / 100.0;
        assertEquals(expectedPrice, output, EPSILON);
    }

    // Combos: burger & fries, or burger & onion rings (10% off)
    @Test
    public void calculatePrice_combos_returnsCorrectValue() {
        Double output = ffpc.calculatePrice("Burger", "Fries", "none");
        Double expectedPrice = (6.99 + 2.25) * 0.9;
        expectedPrice = expectedPrice * 1.1; // tax
        expectedPrice = Math.round(expectedPrice * 100.0) / 100.0;
        assertEquals(expectedPrice, output, EPSILON);

        output = ffpc.calculatePrice("Burger", "onion rings", "none");
        expectedPrice = (6.99 + 2.75) * 0.9;
        expectedPrice = expectedPrice * 1.1; // tax
        expectedPrice = Math.round(expectedPrice * 100.0) / 100.0;
        assertEquals(expectedPrice, output, EPSILON);
    }

    //   - correct output all megacombos
    // Megacombo: burger with either fries or onion rings, and a soda (15% off)
    @Test
    public void calculatePrice_megacombos_returnsCorrectValue() {
        Double output = ffpc.calculatePrice("Burger", "Fries", "Soda");
        Double expectedPrice = (6.99 + 2.25 + 0.99) * 0.85;
        expectedPrice = expectedPrice * 1.1; // tax
        expectedPrice = Math.round(expectedPrice * 100.0) / 100.0;
        assertEquals(expectedPrice, output, EPSILON);

        output = ffpc.calculatePrice("Burger", "Onion Rings", "soda");
        expectedPrice = (6.99 + 2.75 + 0.99) * 0.85;
        expectedPrice = expectedPrice * 1.1; // tax
        expectedPrice = Math.round(expectedPrice * 100.0) / 100.0;
        assertEquals(expectedPrice, output, EPSILON);
    }

    //   - correct output all healthy combos
        @Test
    public void calculatePrice_healthycombos_returnsCorrectValue() {
        Double output = ffpc.calculatePrice("Salad", "None", "None");
        Double expectedPrice = (5.99) * 0.8;
        expectedPrice = expectedPrice * 1.1; // tax
        expectedPrice = Math.round(expectedPrice * 100.0) / 100.0;
        assertEquals(expectedPrice, output, EPSILON);

        output = ffpc.calculatePrice("Salad", "None", "Water");
        expectedPrice = (5.99) * 0.8;
        expectedPrice = expectedPrice * 1.1; // tax
        expectedPrice = Math.round(expectedPrice * 100.0) / 100.0;
        assertEquals(expectedPrice, output, EPSILON);
    }

}
