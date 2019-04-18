import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ValidatorTest {

    private LuhnValidator luhnValidator;

    @Before
    public void init() {
        luhnValidator = new LuhnValidator();
    }

    @Test
    public void StringAsNumberEqualsValidatedNumber() throws Exception {
        assertEquals(luhnValidator.validateString("12"), "12");
        assertEquals(luhnValidator.validateString("012"), "12");
        assertEquals(luhnValidator.validateString("0001200000"), "1200000");
    }

    @Test
    public void StringAsNumberEqualsValidatedNumberWithConsecutiveNumbers() throws Exception {
        assertEquals(luhnValidator.validateString("314994711000000001113344445555"), "314994711000000001113344445555");
        assertEquals(luhnValidator.validateString("00000000314994711000000001113344445555"), "314994711000000001113344445555");
    }

    @Test
    public void ValidatorStripsTrailingZeros() throws Exception {
        assertEquals(luhnValidator.validateString("012"), "12");
        assertEquals(luhnValidator.validateString("0012"), "12");
        assertEquals(luhnValidator.validateString("000000012"), "12");
        assertEquals(luhnValidator.validateString("000000011111111111"), "11111111111");
    }

    @Test
    public void ValidatorStripsWhitespaces() throws Exception {
        assertEquals(luhnValidator.validateString("12 "), "12");
        assertEquals(luhnValidator.validateString(" 12"), "12");
        assertEquals(luhnValidator.validateString("1 2"), "12");
        assertEquals(luhnValidator.validateString("                                        1 2"), "12");
        assertEquals(luhnValidator.validateString("                                        1 2      "), "12");
        assertEquals(luhnValidator.validateString("                                        1           2      "), "12");
        assertEquals(luhnValidator.validateString("      314 99 47 1 1 000000 0011133 4444 5555"), "314994711000000001113344445555");
    }

}
