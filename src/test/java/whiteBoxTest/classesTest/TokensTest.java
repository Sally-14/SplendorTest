package whiteBoxTest.classesTest;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.awt.Color;

import Classes.Tokens;

// The class Tokens is a bad name since tokens only contains 1 token
public class TokensTest{

    // Test Failed: constructor does not check for validity of color
    @Disabled
    @Test
    public void testTokensConstructWithEmptyString() {
        assertThrows(IllegalArgumentException.class, ()->{
            Tokens emptyToken = new Tokens("");
        });
    }

    @Test
    public void testTokensConstructorWithValidColorName() {
        // Valid colors names: Emerald, Diamond, Sapphire, Onyx, Ruby, Gold Joker
        Tokens emptyToken = new Tokens("Diamond");
    }


    // Test failed: constructor does not check for validity of color
    @Disabled
    @Test
    public void testTokensConstructorWithInvalidColorName() {
        // Valid colors names: Emerald, Diamond, Sapphire, Onyx, Ruby, Gold Joker
        assertThrows(IllegalArgumentException.class, ()->{
            Tokens invalidToken = new Tokens("Bronze");
        });
    }

    @Test
    public void testTokensConstructorWithValidColor() {
        // Valid colors: green, white, blue, black, red, yellow
        Tokens validToken = new Tokens("White");
    }

    // Test Failed: constructor does not check for validity of color
    @Disabled
    @Test
    public void testTokensConstructorWithInvalidColor() {
        // Valid colors: green, white, blue, black, red, yellow
        assertThrows(IllegalArgumentException.class, ()->{
            Tokens invalidToken = new Tokens("Gray");
        });
    }

    @Test
    public void testTokensGetColor() {
        Tokens diamondToken = new Tokens("Diamond");
        assertEquals("Diamond", diamondToken.getColor());
    }

    @Test
    public void testTokensSetColor() {
        Tokens emeraldToken = new Tokens("Diamond");
        emeraldToken.setColor("Emerald");
        assertEquals("Emerald", emeraldToken.getColor());
    }

    @Test
    public void testTokensReturnColorOnyx() {
        Tokens onyxToken = new Tokens("Onyx");
        Color onyxColor = Color.BLACK;
        assertEquals(onyxColor, onyxToken.returnColor());
    }

    @Test
    public void testTokensReturnColorEmerald() {
        Tokens emeraldToken = new Tokens("Emerald");
        Color emeraldColor = Color.GREEN;
        assertEquals(emeraldColor, emeraldToken.returnColor());
    }

    @Test
    public void testTokensReturnColorDiamond() {
        Tokens diamondToken = new Tokens("Diamond");
        Color diamondColor = Color.WHITE;
        assertEquals(diamondColor, diamondToken.returnColor());
    }

    // Test Failed: program only takes incorrect spelling of Ruby (program spells rubby)
    // Test Failed: always returns invalid color as yellow
    @Disabled
    @Test
    public void testTokensReturnColorRuby() {
        Tokens rubyToken = new Tokens("Ruby");
        Color rubyColor = Color.RED;
        assertEquals(rubyColor, rubyToken.returnColor());
    }

    // Test Failed: program only takes incorrect spelling of Ruby (program spells rubby)
    @Disabled
    @Test
    public void testTokensReturnColorRubyFailed() {
        Tokens rubyToken = new Tokens("Rubby");
        Color rubyColor = Color.RED;
        assertFalse(rubyToken.returnColor() == rubyColor);
    }

    @Test
    public void testTokensReturnColorSapphire() {
        Tokens sapphireToken = new Tokens("Sapphire");
        Color sapphireColor = Color.BLUE;
        assertEquals(sapphireColor, sapphireToken.returnColor());
    }

    @Test
    public void testTokensReturnColorGoldJoker() {
        Tokens goldToken = new Tokens("Gold Joker");
        Color goldColor = Color.YELLOW;
        assertEquals(goldColor, goldToken.returnColor());
    }

    // Test Failed: always returns invalid color as yellow
    @Disabled
    @Test
    public void testTokensReturnColorInvalidColor() {
        Tokens invalidToken = new Tokens("Bronze");
        assertTrue(invalidToken.returnColor() != Color.BLACK);
        assertTrue(invalidToken.returnColor() != Color.GREEN);
        assertTrue(invalidToken.returnColor() != Color.WHITE);
        assertTrue(invalidToken.returnColor() != Color.RED);
        assertTrue(invalidToken.returnColor() != Color.BLUE);
        assertTrue(invalidToken.returnColor() != Color.YELLOW);
    }

    @Test
    public void testToStringColor() {
        Tokens sapphireToken = new Tokens("Sapphire");
        assertEquals("Sapphire", sapphireToken.toString());
    }

    @Test
    public void testEqualsTwoSameColorTokens(){
        Tokens sapphireToken1 = new Tokens("Sapphire");
        Tokens sapphireToken2 = new Tokens("Sapphire");

        assertTrue(sapphireToken1.equals(sapphireToken2));
    }

    @Test
    public void testEqualsTwoSameColorTokensLowerUpperCase(){
        Tokens sapphireToken1 = new Tokens("Sapphire");
        Tokens sapphireToken2 = new Tokens("sapphire");

        assertTrue(sapphireToken1.equals(sapphireToken2));
    }

    @Test
    public void testEqualsTwoDiffColorTokens(){
        Tokens sapphireToken = new Tokens("Sapphire");
        Tokens onyxToken = new Tokens("Onyx");

        assertFalse(sapphireToken.equals(onyxToken));
    }

    @Test
    public void testCompareToTwoSameColorTokens(){
        Tokens sapphireToken1 = new Tokens("Sapphire");
        Tokens sapphireToken2 = new Tokens("Sapphire");

        assertTrue(sapphireToken1.compareTo(sapphireToken2) == 0);
    }

    // Test Failed: compareTo is color case sensitive (Sapphire vs. sapphire)
    @Disabled
    @Test
    public void testCompareToTwoSameColorTokensLowerUpperCase(){
        Tokens sapphireToken1 = new Tokens("Sapphire");
        Tokens sapphireToken2 = new Tokens("sapphire");

        assertTrue(sapphireToken1.compareTo(sapphireToken2) == 0);
    }

    @Test
    public void testCompareToTwoDiffColorTokens(){
        Tokens sapphireToken = new Tokens("Sapphire");
        Tokens rubyToken = new Tokens("Ruby");

        assertTrue(sapphireToken.compareTo(rubyToken) != 0);
    }


}