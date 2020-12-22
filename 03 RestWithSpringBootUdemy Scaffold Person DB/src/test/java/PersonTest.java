import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class Fixture {
    static int getApiVersion() {
        return 10;
    }
}

class Shape {
    private int numberOfSides;
    private String description;

    public String getDescription() {
        return description;
    }

    public Shape(int numberOfSides) {
        if ( numberOfSides >= 6)
            throw new IllegalArgumentException( "number of sides must be <=5 but was " + numberOfSides);
        this.numberOfSides = numberOfSides;
        this.description = "";
    }

    public Shape( int numberOfSides, String description) {
        this(numberOfSides);
        this.description = description;
    }

    public int getNumberOfSides() {
        return numberOfSides;
    }
}

public class PersonTest {
    @Test
    @Disabled("Not implemented yet!")
    @DisplayName("Shall display a simple assertion")
    void name() {
        assertEquals( 1, 1);
    }

    @Test
    @DisplayName("Should check all items in the list")
    void shouldCheckAllItemsInTheList() {
        List<Integer> numbers = List.of(1,2,3,4,5);

        Assertions.assertAll(
                () -> assertEquals( 0, numbers.get(0)),
                () -> assertEquals( 0, numbers.get(1)),
                () -> assertEquals( 0, numbers.get(2)),
                () -> assertEquals( 0, numbers.get(3)),
                () -> assertEquals( 0, numbers.get(4))
        );
    }

    @Test
    @DisplayName("Should only run the test if some criteria is met")
    void shouldOnlyRunTheTestIfSomeCriteriaIsMet() {
        Assumptions.assumeTrue( Fixture.getApiVersion() > 10);
        Assertions.assertEquals( 1, 1);
    }

    @ParameterizedTest
    @DisplayName("Should create shapes with different numbers of sides")
    @ValueSource(ints = {1,2,3,4,5})
    void testName( int expectedNumberOfSides) {
        Shape shape = new Shape( expectedNumberOfSides);
        Assertions.assertEquals( expectedNumberOfSides, shape.getNumberOfSides());
    }

    @Test
    @DisplayName("Should throw an exception")
    void shouldThrowAnException() {
        assertThrows( IllegalArgumentException.class, () -> new Shape( 37));
    }

    @Nested
    @DisplayName( "Nested tests")
    class WhenShapeExists {
        private final Shape shape = new Shape(4, "Square");

        // eine eingebettete Klasse für alle Positivfälle
        @Nested
        @DisplayName( "Nested inside nested")
        class ShouldAllow {

            @Test
            @DisplayName("seeing the number of sides")
            void seeingTheNumberOfSides() {
                assertEquals( 4, shape.getNumberOfSides());
            }

            @Test
            @DisplayName("test if correct description")
            void testIfCorrectDescription() {
                assertEquals( "Square", shape.getDescription());
            }
        }

        // hier können wir die negativen Tests unterbringen.
        class ShouldNot {

        }
    }
}
