package whiteBoxTest;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.awt.Color;

import Classes.Tokens;

public class TokensTest{

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
        validToken.setColor("Emerald");
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
        Color emeraldColor = Color.Green;
        assertEquals(emeraldColor, emeraldToken.returnColor());
    }

    @Test
    public void testTokensReturnColorDiamond() {
        Tokens diamondToken = new Tokens("Diamond");
        Color diamondColor = Color.WHITE;
        assertEquals(diamondColor, diamondToken.returnColor());
    }




}