import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class MainTest {

    private LuhnValidator luhnValidator;

    @Before
    public void init() {
        luhnValidator = new LuhnValidator();
    }

    @Test
    public void evaluateAmericanExpress() throws Exception {
        assertTrue("American Express", luhnValidator.isLuhnNumber("374533452546649"));
        assertTrue("American Express", luhnValidator.isLuhnNumber("377975153255581"));
        assertTrue("American Express", luhnValidator.isLuhnNumber("376825023463090"));
        assertTrue("American Express", luhnValidator.isLuhnNumber("376581147923689"));
        assertTrue("American Express", luhnValidator.isLuhnNumber("375188086346145"));
        assertTrue("American Express", luhnValidator.isLuhnNumber("376317211232966"));
        assertTrue("American Express", luhnValidator.isLuhnNumber("349482160218079"));
        assertTrue("American Express", luhnValidator.isLuhnNumber("346915201062777"));
    }

    @Test
    public void evaluateMasterCard() throws Exception {
        assertTrue("Master Card", luhnValidator.isLuhnNumber("5491791248436775"));
        assertTrue("Master Card", luhnValidator.isLuhnNumber("5330148539216298"));
        assertTrue("Master Card", luhnValidator.isLuhnNumber("5285759484333139"));
        assertTrue("Master Card", luhnValidator.isLuhnNumber("5559131177432397"));
    }

    @Test
    public void evaluatesVISA() throws Exception {
        assertTrue("VISA", luhnValidator.isLuhnNumber("4208960703390"));
        assertTrue("VISA", luhnValidator.isLuhnNumber("4041257978122"));
        assertTrue("VISA", luhnValidator.isLuhnNumber("4925027743966"));
        assertTrue("VISA", luhnValidator.isLuhnNumber("4855555130288"));
    }

    @Test
    public void wrongNumbers() throws Exception {
        assertFalse("No Luhn Number", luhnValidator.isLuhnNumber("549179124843675"));
        assertFalse("No Luhn Number", luhnValidator.isLuhnNumber("1"));
        assertFalse("No Luhn Number", luhnValidator.isLuhnNumber("0000010000"));
    }

    @Test
    public void longNumbers() throws Exception {
        assertTrue("Master Card", luhnValidator.isLuhnNumber("5491791248436775000000000000"));
        assertFalse("No Luhn Number", luhnValidator.isLuhnNumber("549179124843675549179124843675549179124843675549179124843675549179124843675549179124843675549179124843675"));
    }

    @Test
    public void LuhnButMaybeEdgeCases() throws Exception {
        assertTrue("No Luhn Number", luhnValidator.isLuhnNumber("0"));
        assertTrue("No Luhn Number", luhnValidator.isLuhnNumber("0000"));
        assertTrue("No Luhn Number", luhnValidator.isLuhnNumber("00000"));
        assertTrue("No Luhn Number", luhnValidator.isLuhnNumber("0 0 0 0 0"));
        assertTrue("No Luhn Number", luhnValidator.isLuhnNumber("000 0 0 0 0"));
        assertTrue("No Luhn Number", luhnValidator.isLuhnNumber("     000 0 0 0 0"));
        assertTrue("No Luhn Number", luhnValidator.isLuhnNumber("000 0 0 0 0     "));
        assertTrue("No Luhn Number", luhnValidator.isLuhnNumber("     000 0 0 0 0     "));
        assertTrue("No Luhn Number", luhnValidator.isLuhnNumber("         0 0     0 0 0 0 0     "));
    }

    @Test(expected = Exception.class)
    public void NoStrings() throws Exception {
        luhnValidator.isLuhnNumber("hello world!");
    }

    @Test(expected = Exception.class)
    public void NoScriptInString() throws Exception {
        luhnValidator.isLuhnNumber("55<script>");
    }

    @Test(expected = Exception.class)
    public void NoScriptInString2() throws Exception {
        luhnValidator.isLuhnNumber("     ");
    }

    @Test(expected = Exception.class)
    public void NoZeroLengthStrings() throws Exception {
        luhnValidator.isLuhnNumber("");
    }

    @Test(expected = Exception.class)
    public void SQLInjection() throws Exception {
        luhnValidator.isLuhnNumber("DROP sampletable;--");
    }

    @Test(expected = Exception.class)
    public void JavaScriptInjection() throws Exception {
        luhnValidator.isLuhnNumber("'<scrip>eval()'");
    }

}
