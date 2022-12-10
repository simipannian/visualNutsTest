import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

public class UnitTestPrintIntegerMain {


    @Test
    public void testPassingIntegerPrinted() {
        String resourcePath = "printerIntTestConfig.properties";
        String expectedMessage = "printed";
        PrintInteger p = new PrintInteger();
        assertEquals(expectedMessage, p.printInt(resourcePath));
    }

    @Test
    public void testIntegerNotPrinted() {
        String resourcePath = "wrongConfig.properties";
        String expectedErrorMessage = "Not printed";
        PrintInteger p = new PrintInteger();
        assertEquals(expectedErrorMessage, p.printInt(resourcePath));
    }
}
