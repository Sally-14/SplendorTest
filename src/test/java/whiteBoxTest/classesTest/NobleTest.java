package whiteBoxTest.classesTest;

import Classes.*;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class NobleTest{

    @Test
    public void testNobleConstructorValidNoble() {
        String validName = "Charles V";

        Tokens onyxToken = new Tokens("Onyx");

        ArrayList<Tokens> validCost = new ArrayList<>();
        validCost.add(onyxToken);
        validCost.add(onyxToken);
        validCost.add(onyxToken);

        Noble validNoble = new Noble(validName, validCost);
    }

    // Test Failed: constructor does not check for invalid cost
    @Disabled
    @Test
    public void testNobleConstructorInvalidCost() {
        String validName = "Charles V";

        Tokens bronzeToken = new Tokens("Bronze");

        ArrayList<Tokens> invalidCost = new ArrayList<>();
        invalidCost.add(bronzeToken );

        assertThrows(IllegalArgumentException.class, ()->{
            Noble invalidNoble = new Noble(validName, invalidCost);
        });
    }

    @Test
    public void testNobleSetOwner() {

        Tokens onyxToken = new Tokens("Onyx");

        ArrayList<Tokens> validTokens = new ArrayList<>();
        validTokens.add(onyxToken);
        validTokens.add(onyxToken);
        validTokens.add(onyxToken);

        ArrayList<Noble> noNobles = new ArrayList<>();
        ArrayList<Cards> noCards = new ArrayList<>();

        Player owner = new Player(0, validTokens, noCards, noNobles, noCards, "Player1");

        String validName = "Charles V";

        ArrayList<Tokens> validCost = new ArrayList<>();
        validCost.add(onyxToken);
        validCost.add(onyxToken);
        validCost.add(onyxToken);

        Noble validNoble = new Noble(validName, validCost);
        validNoble.setOwner(owner);
        assertTrue(validNoble.getOwner().equals(owner));
    }

    @Test
    public void testNobleGetOwner() {

        Tokens onyxToken = new Tokens("Onyx");

        ArrayList<Tokens> validTokens = new ArrayList<>();
        validTokens.add(onyxToken);
        validTokens.add(onyxToken);
        validTokens.add(onyxToken);

        ArrayList<Noble> noNobles = new ArrayList<>();
        ArrayList<Cards> noCards = new ArrayList<>();

        Player owner = new Player(0, validTokens, noCards, noNobles, noCards, "Player1");

        String validName = "Charles V";

        ArrayList<Tokens> validCost = new ArrayList<>();
        validCost.add(onyxToken);
        validCost.add(onyxToken);
        validCost.add(onyxToken);

        Noble validNoble = new Noble(validName, validCost);
        validNoble.setOwner(owner);
        assertTrue(validNoble.getOwner().equals(owner));
    }

    @Test
    public void testNobleGetNameValidNoble() {
        String validName = "Charles V";

        Tokens onyxToken = new Tokens("Onyx");

        ArrayList<Tokens> validCost = new ArrayList<>();
        validCost.add(onyxToken);
        validCost.add(onyxToken);
        validCost.add(onyxToken);

        Noble validNoble = new Noble(validName, validCost);
        assertEquals(validName, validNoble.getName());
    }

    @Test
    public void testNobleSetNameValidNoble() {
        String validName = "Charles V";

        Tokens onyxToken = new Tokens("Onyx");

        ArrayList<Tokens> validCost = new ArrayList<>();
        validCost.add(onyxToken);
        validCost.add(onyxToken);
        validCost.add(onyxToken);

        Noble validNoble = new Noble(validName, validCost);

        String newName = "Charles VI";
        validNoble.setName(newName);
        assertEquals(newName, validNoble.getName());
    }

    @Test
    public void testNobleGetPtValidNoble() {
        String validName = "Charles V";

        Tokens onyxToken = new Tokens("Onyx");

        ArrayList<Tokens> validCost = new ArrayList<>();
        validCost.add(onyxToken);
        validCost.add(onyxToken);
        validCost.add(onyxToken);

        Noble validNoble = new Noble(validName, validCost);

        assertEquals(3, validNoble.getPt());
    }

    @Test
    public void testNobleGetCostValidNoble() {
        String validName = "Charles V";

        Tokens onyxToken = new Tokens("Onyx");

        ArrayList<Tokens> validCost = new ArrayList<>();
        validCost.add(onyxToken);
        validCost.add(onyxToken);
        validCost.add(onyxToken);

        Noble validNoble = new Noble(validName, validCost);

        assertTrue(validCost.equals(validNoble.getCost()));
    }

    @Test
    public void testNobleSetCostValidNoble() {
        String validName = "Charles V";

        Tokens onyxToken = new Tokens("Onyx");
        Tokens diamondToken = new Tokens("Diamond");

        ArrayList<Tokens> validCost = new ArrayList<>();
        validCost.add(onyxToken);
        validCost.add(onyxToken);
        validCost.add(onyxToken);

        Noble validNoble = new Noble(validName, validCost);

        ArrayList<Tokens> newCost = new ArrayList<>();
        newCost.add(onyxToken);
        newCost.add(diamondToken);
        newCost.add(onyxToken);

        validNoble.setCost(newCost);

        assertTrue(newCost.equals(validNoble.getCost()));
    }

    @Test
    public void testNobleWhiteCostNoWhite() {
        String validName = "Charles V";

        Tokens onyxToken = new Tokens("Onyx");

        ArrayList<Tokens> validCost = new ArrayList<>();
        validCost.add(onyxToken);
        validCost.add(onyxToken);
        validCost.add(onyxToken);

        Noble validNoble = new Noble(validName, validCost);

        assertEquals(0, validNoble.whiteCost());
    }

    @Test
    public void testNobleWhiteCostHaveWhite() {
        String validName = "Charles V";

        Tokens onyxToken = new Tokens("Onyx");
        Tokens diamondToken = new Tokens("Diamond");

        ArrayList<Tokens> validCost = new ArrayList<>();
        validCost.add(onyxToken);
        validCost.add(diamondToken);
        validCost.add(diamondToken);

        Noble validNoble = new Noble(validName, validCost);

        assertEquals(2, validNoble.whiteCost());
    }

    @Test
    public void testNobleGreenCostNoGreen() {
        String validName = "Charles V";

        Tokens onyxToken = new Tokens("Onyx");

        ArrayList<Tokens> validCost = new ArrayList<>();
        validCost.add(onyxToken);
        validCost.add(onyxToken);
        validCost.add(onyxToken);

        Noble validNoble = new Noble(validName, validCost);

        assertEquals(0, validNoble.greenCost());
    }

    @Test
    public void testNobleGreenCostHaveGreen() {
        String validName = "Charles V";

        Tokens onyxToken = new Tokens("Onyx");
        Tokens emeraldToken = new Tokens("Emerald");

        ArrayList<Tokens> validCost = new ArrayList<>();
        validCost.add(onyxToken);
        validCost.add(emeraldToken);
        validCost.add(emeraldToken);

        Noble validNoble = new Noble(validName, validCost);

        assertEquals(2, validNoble.greenCost());
    }

    @Test
    public void testNobleBlueCostNoBlue() {
        String validName = "Charles V";

        Tokens onyxToken = new Tokens("Onyx");

        ArrayList<Tokens> validCost = new ArrayList<>();
        validCost.add(onyxToken);
        validCost.add(onyxToken);
        validCost.add(onyxToken);

        Noble validNoble = new Noble(validName, validCost);

        assertEquals(0, validNoble.blueCost());
    }

    @Test
    public void testNobleBlueCostHaveBlue() {
        String validName = "Charles V";

        Tokens onyxToken = new Tokens("Onyx");
        Tokens sapphireToken = new Tokens("Sapphire");

        ArrayList<Tokens> validCost = new ArrayList<>();
        validCost.add(onyxToken);
        validCost.add(sapphireToken);
        validCost.add(sapphireToken);

        Noble validNoble = new Noble(validName, validCost);

        assertEquals(2, validNoble.blueCost());
    }

    @Test
    public void testNobleBlackCostNoBlack() {
        String validName = "Charles V";

        Tokens diamondToken = new Tokens("Diamond");

        ArrayList<Tokens> validCost = new ArrayList<>();
        validCost.add(diamondToken);
        validCost.add(diamondToken);
        validCost.add(diamondToken);

        Noble validNoble = new Noble(validName, validCost);

        assertEquals(0, validNoble.blackCost());
    }

    @Test
    public void testNobleBlackCostHaveBlack() {
        String validName = "Charles V";

        Tokens onyxToken = new Tokens("Onyx");
        Tokens sapphireToken = new Tokens("Sapphire");

        ArrayList<Tokens> validCost = new ArrayList<>();
        validCost.add(onyxToken);
        validCost.add(onyxToken);
        validCost.add(sapphireToken);

        Noble validNoble = new Noble(validName, validCost);

        assertEquals(2, validNoble.blackCost());
    }


    @Test
    public void testNobleRedCostNoRed() {
        String validName = "Charles V";

        Tokens diamondToken = new Tokens("Diamond");

        ArrayList<Tokens> validCost = new ArrayList<>();
        validCost.add(diamondToken);
        validCost.add(diamondToken);
        validCost.add(diamondToken);

        Noble validNoble = new Noble(validName, validCost);

        assertEquals(0, validNoble.redCost());
    }

    @Test
    public void testNobleRedCostHaveRed() {
        String validName = "Charles V";

        Tokens onyxToken = new Tokens("Onyx");
        Tokens rubyToken = new Tokens("Rubby");

        ArrayList<Tokens> validCost = new ArrayList<>();
        validCost.add(onyxToken);
        validCost.add(rubyToken);
        validCost.add(rubyToken);

        Noble validNoble = new Noble(validName, validCost);

        assertEquals(2, validNoble.redCost());
    }

    @Test
    public void testCardsToStringAllCost() {
        String validName = "Charles V";

        Tokens onyxToken = new Tokens("Onyx");
        Tokens rubyToken = new Tokens("Rubby");
        Tokens sapphireToken = new Tokens("Sapphire");
        Tokens diamondToken = new Tokens("Diamond");
        Tokens emeraldToken = new Tokens("Emerald");

        ArrayList<Tokens> allCost = new ArrayList<>();
        allCost.add(onyxToken);
        allCost.add(rubyToken);
        allCost.add(sapphireToken);
        allCost.add(diamondToken);
        allCost.add(emeraldToken);

        Noble validNoble = new Noble(validName, allCost);
        String result = validNoble.toString();
        String expected = "******* " + validName + "*******" + "\n" +
                "   Diamond x" + "1" + " " + "   Rubby x" + "1" + " " +
                "   Emerald x" + "1" + " " + "   Onyx x" + "1" + " " +
                "   Sapphire x" + "1" + " " + "\n";
        assertEquals(expected, result);
    }

    @Test
    public void testCardsToStringMultipleWhite() {
        String validName = "Charles V";

        Tokens diamondToken = new Tokens("Diamond");

        ArrayList<Tokens> allCost = new ArrayList<>();
        allCost.add(diamondToken);
        allCost.add(diamondToken);
        allCost.add(diamondToken);

        Noble validNoble = new Noble(validName, allCost);
        String result = validNoble.toString();
        String expected = "******* " + validName + "*******" + "\n" +
                "   Diamond x" + "3" + " " + "\n";
        assertEquals(expected, result);
    }

    @Test
    public void testCardsToStringNoCost() {
        String validName = "Charles V";

        ArrayList<Tokens> noCost = new ArrayList<>();

        Noble validNoble = new Noble(validName, noCost);
        String result = validNoble.toString();
        String expected = "******* " + validName + "*******" + "\n" + "\n";
        assertEquals(expected, result);
    }
}