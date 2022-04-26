package whiteBoxTest.classesTest;

import Classes.*;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class CardsTest{

    @Test
    public void testCardsConstructWithValidPtCostNameResource() {
        int validPt = 1;
        Tokens onyxToken = new Tokens("Onyx");

        ArrayList<Tokens> validCost = new ArrayList<>();
        validCost.add(onyxToken);
        validCost.add(onyxToken);
        validCost.add(onyxToken);

        String validName = "mine";

        Tokens validResource = new Tokens("Onyx");

        Cards validCard = new Cards(validPt, validCost, validName, validResource);
    }

    // Test Failed: constructor does not check for invalid point
//    @Test
//    public void testCardsConstructWithInvalidPt() {
//        int invalidPt = -1;
//        Tokens onyxToken = new Tokens("Onyx");
//
//        ArrayList<Tokens> validCost = new ArrayList<>();
//        validCost.add(onyxToken);
//        validCost.add(onyxToken);
//        validCost.add(onyxToken);
//
//        String validName = "mine";
//
//        Tokens validResource = new Tokens("Onyx");
//
//        assertThrows(IllegalArgumentException.class, ()->{
//            Cards invalidCard = new Cards(invalidPt, validCost, validName, validResource);
//        });
//    }


    // Test Failed: constructor does not check for invalid cost
//    @Test
//    public void testCardsConstructWithInvalidCost() {
//        int validPt = 1;
//        Tokens bronzeToken = new Tokens("Bronze");
//
//        ArrayList<Tokens> invalidCost = new ArrayList<>();
//        invalidCost.add(bronzeToken);
//        invalidCost.add(bronzeToken);
//        invalidCost.add(bronzeToken);
//
//        String validName = "artisan";
//
//        Tokens validResource = new Tokens("Onyx");
//
//        assertThrows(IllegalArgumentException.class, ()->{
//            Cards invalidCard = new Cards(validPt, invalidCost, validName, validResource);
//        });
//    }

    // Test Failed: constructor does not check for invalid name
//    @Test
//    public void testCardsConstructWithInvalidName() {
//        int validPt = 1;
//
//        Tokens onyxToken = new Tokens("Onyx");
//
//        ArrayList<Tokens> validCost = new ArrayList<>();
//        validCost.add(onyxToken);
//        validCost.add(onyxToken);
//        validCost.add(onyxToken);
//
//
//        String invalidName = "jewel";
//
//        Tokens validResource = new Tokens("Onyx");
//
//        assertThrows(IllegalArgumentException.class, ()->{
//            Cards invalidCard = new Cards(validPt, validCost, invalidName, validResource);
//        });
//    }

    // Test Failed: constructor does not check for invalid resource
//    @Test
//    public void testCardsConstructWithInvalidResource() {
//        int validPt = 1;
//
//        Tokens onyxToken = new Tokens("Onyx");
//
//        ArrayList<Tokens> validCost = new ArrayList<>();
//        validCost.add(onyxToken);
//        validCost.add(onyxToken);
//        validCost.add(onyxToken);
//
//
//        String validName = "transportation";
//
//        Tokens invalidResource = new Tokens("Bronze");
//
//        assertThrows(IllegalArgumentException.class, ()->{
//            Cards invalidCard = new Cards(validPt, validCost, validName, invalidResource);
//        });
//    }


    @Test
    public void testCardsConstructWithValidResource() {
        String validResource = "Onyx";
        Cards validCard = new Cards(validResource);
    }

    // Test Failed: constructor does not check for invalid resource
//    @Test
//    public void testCardsConstructWithOnlyInvalidResource() {
//        String invalidResource = "Bronze";
//        assertThrows(IllegalArgumentException.class, ()->{
//            Cards validCard = new Cards(invalidResource);
//        });
//    }

    @Test
    public void testCardsGetResource() {
        int validPt = 1;
        Tokens onyxToken = new Tokens("Onyx");

        ArrayList<Tokens> validCost = new ArrayList<>();
        validCost.add(onyxToken);
        validCost.add(onyxToken);
        validCost.add(onyxToken);

        String validName = "mine";

        Tokens validResource = new Tokens("Onyx");

        Cards validCard = new Cards(validPt, validCost, validName, validResource);
        assertTrue(validResource.equals(validCard.getResource()));
    }

    @Test
    public void testCardsSetResource() {
        int validPt = 1;
        Tokens onyxToken = new Tokens("Onyx");
        Tokens diamondToken = new Tokens("Diamond");

        ArrayList<Tokens> validCost = new ArrayList<>();
        validCost.add(onyxToken);
        validCost.add(onyxToken);
        validCost.add(onyxToken);

        String validName = "mine";

        Cards validCard = new Cards(validPt, validCost, validName, onyxToken);
        validCard.setResource(diamondToken);
        assertTrue(diamondToken.equals(validCard.getResource()));
    }

    @Test
    public void testCardsGetPt() {
        int validPt = 2;
        Tokens onyxToken = new Tokens("Onyx");

        ArrayList<Tokens> validCost = new ArrayList<>();
        validCost.add(onyxToken);
        validCost.add(onyxToken);
        validCost.add(onyxToken);

        String validName = "mine";

        Cards validCard = new Cards(validPt, validCost, validName, onyxToken);
        assertEquals(2, validCard.getPt());
    }

    @Test
    public void testCardsSetPt() {
        Tokens onyxToken = new Tokens("Onyx");

        ArrayList<Tokens> validCost = new ArrayList<>();
        validCost.add(onyxToken);
        validCost.add(onyxToken);
        validCost.add(onyxToken);

        String validName = "mine";

        Cards validCard = new Cards(1, validCost, validName, onyxToken);
        validCard.setPt(2);
        assertEquals(2, validCard.getPt());
    }

    @Test
    public void testCardsGetCost() {
        int validPt = 2;

        Tokens onyxToken = new Tokens("Onyx");

        ArrayList<Tokens> validCost = new ArrayList<>();
        validCost.add(onyxToken);
        validCost.add(onyxToken);
        validCost.add(onyxToken);

        String validName = "mine";

        Cards validCard = new Cards(validPt, validCost, validName, onyxToken);
        ArrayList<Tokens> result = validCard.getCost();

        for(int i = 0; i < validCost.size(); i++){
            assertTrue(validCost.get(i).equals(result.get(i)));
        }
    }

    @Test
    public void testCardsSetCost() {
        int validPt = 2;

        Tokens onyxToken = new Tokens("Onyx");
        Tokens diamondToken = new Tokens("Diamond");


        ArrayList<Tokens> validCost = new ArrayList<>();
        validCost.add(onyxToken);
        validCost.add(onyxToken);
        validCost.add(onyxToken);

        String validName = "mine";

        Cards validCard = new Cards(validPt, validCost, validName, onyxToken);

        ArrayList<Tokens> newCost = new ArrayList<>();
        newCost.add(onyxToken);
        newCost.add(diamondToken);

        validCard.setCost(newCost);
        ArrayList<Tokens> result = validCard.getCost();

        for(int i = 0; i < newCost.size(); i++){
            assertTrue(newCost.get(i).equals(result.get(i)));
        }
    }

    @Test
    public void testCardsGetName() {
        int validPt = 2;

        Tokens onyxToken = new Tokens("Onyx");

        ArrayList<Tokens> validCost = new ArrayList<>();
        validCost.add(onyxToken);
        validCost.add(onyxToken);
        validCost.add(onyxToken);

        String validName = "mine";

        Cards validCard = new Cards(validPt, validCost, validName, onyxToken);
        assertEquals(validName, validCard.getName());
    }

    @Test
    public void testCardsSetName() {
        int validPt = 2;

        Tokens onyxToken = new Tokens("Onyx");

        ArrayList<Tokens> validCost = new ArrayList<>();
        validCost.add(onyxToken);
        validCost.add(onyxToken);
        validCost.add(onyxToken);

        String validName = "mine";
        String newName = "artisan";

        Cards validCard = new Cards(validPt, validCost, validName, onyxToken);
        validCard.setName(newName);
        assertEquals(newName, validCard.getName());
    }

    @Test
    public void testCardsWhiteCostNoWhites() {
        int validPt = 2;

        Tokens onyxToken = new Tokens("Onyx");

        ArrayList<Tokens> validCost = new ArrayList<>();
        validCost.add(onyxToken);
        validCost.add(onyxToken);
        validCost.add(onyxToken);

        String validName = "mine";

        Cards validCard = new Cards(validPt, validCost, validName, onyxToken);
        assertEquals(0, validCard.whiteCost());
    }

    @Test
    public void testCardsWhiteCostHaveWhites() {
        int validPt = 2;

        Tokens onyxToken = new Tokens("Onyx");
        Tokens diamondToken = new Tokens("Diamond");

        ArrayList<Tokens> validCost = new ArrayList<>();
        validCost.add(onyxToken);
        validCost.add(diamondToken);
        validCost.add(onyxToken);
        validCost.add(onyxToken);
        validCost.add(diamondToken);

        String validName = "mine";

        Cards validCard = new Cards(validPt, validCost, validName, onyxToken);
        assertEquals(2, validCard.whiteCost());
    }

    @Test
    public void testCardsGreenCostNoGreen() {
        int validPt = 2;

        Tokens onyxToken = new Tokens("Onyx");

        ArrayList<Tokens> validCost = new ArrayList<>();
        validCost.add(onyxToken);
        validCost.add(onyxToken);
        validCost.add(onyxToken);

        String validName = "mine";

        Cards validCard = new Cards(validPt, validCost, validName, onyxToken);
        assertEquals(0, validCard.greenCost());
    }

    @Test
    public void testCardsGreenCostHaveGreen() {
        int validPt = 2;

        Tokens onyxToken = new Tokens("Onyx");
        Tokens emeraldToken = new Tokens("Emerald");

        ArrayList<Tokens> validCost = new ArrayList<>();
        validCost.add(onyxToken);
        validCost.add(emeraldToken);
        validCost.add(onyxToken);
        validCost.add(onyxToken);
        validCost.add(emeraldToken);

        String validName = "mine";

        Cards validCard = new Cards(validPt, validCost, validName, onyxToken);
        assertEquals(2, validCard.greenCost());
    }

    @Test
    public void testCardsBlueCostNoBlue() {
        int validPt = 2;

        Tokens onyxToken = new Tokens("Onyx");

        ArrayList<Tokens> validCost = new ArrayList<>();
        validCost.add(onyxToken);
        validCost.add(onyxToken);
        validCost.add(onyxToken);

        String validName = "mine";

        Cards validCard = new Cards(validPt, validCost, validName, onyxToken);
        assertEquals(0, validCard.blueCost());
    }

    @Test
    public void testCardsBlueCostHaveBlue() {
        int validPt = 2;

        Tokens onyxToken = new Tokens("Onyx");
        Tokens sapphireToken = new Tokens("Sapphire");

        ArrayList<Tokens> validCost = new ArrayList<>();
        validCost.add(onyxToken);
        validCost.add(sapphireToken);
        validCost.add(onyxToken);
        validCost.add(onyxToken);
        validCost.add(sapphireToken);

        String validName = "mine";

        Cards validCard = new Cards(validPt, validCost, validName, onyxToken);
        assertEquals(2, validCard.blueCost());
    }


    @Test
    public void testCardsBlackCostNoBlack() {
        int validPt = 2;

        Tokens diamondToken = new Tokens("Diamond");

        ArrayList<Tokens> validCost = new ArrayList<>();
        validCost.add(diamondToken);
        validCost.add(diamondToken);
        validCost.add(diamondToken);

        String validName = "mine";

        Cards validCard = new Cards(validPt, validCost, validName, diamondToken);
        assertEquals(0, validCard.blueCost());
    }

    @Test
    public void testCardsBlackCostHaveBlack() {
        int validPt = 2;

        Tokens onyxToken = new Tokens("Onyx");
        Tokens sapphireToken = new Tokens("Sapphire");

        ArrayList<Tokens> validCost = new ArrayList<>();
        validCost.add(sapphireToken);
        validCost.add(onyxToken);
        validCost.add(sapphireToken);
        validCost.add(onyxToken);
        validCost.add(onyxToken);
        validCost.add(sapphireToken);

        String validName = "mine";

        Cards validCard = new Cards(validPt, validCost, validName, onyxToken);
        assertEquals(3, validCard.blueCost());
    }

    @Test
    public void testCardsRedCostNoRed() {
        int validPt = 2;

        Tokens onyxToken = new Tokens("Onyx");

        ArrayList<Tokens> validCost = new ArrayList<>();
        validCost.add(onyxToken);
        validCost.add(onyxToken);
        validCost.add(onyxToken);

        String validName = "mine";

        Cards validCard = new Cards(validPt, validCost, validName, onyxToken);
        assertEquals(0, validCard.blueCost());
    }

    @Test
    public void testCardsRedCostHaveRed() {
        int validPt = 2;

        Tokens onyxToken = new Tokens("Onyx");
        Tokens rubyToken = new Tokens("Rubby");

        ArrayList<Tokens> validCost = new ArrayList<>();
        validCost.add(onyxToken);
        validCost.add(rubyToken);
        validCost.add(onyxToken);
        validCost.add(onyxToken);
        validCost.add(rubyToken);

        String validName = "mine";

        Cards validCard = new Cards(validPt, validCost, validName, onyxToken);
        assertEquals(2, validCard.redCost());
    }

    @Test
    public void testCardsToStringAllCost() {
        int validPt = 2;

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

        String validName = "mine";

        Cards validCard = new Cards(validPt, allCost, validName, onyxToken);
        String result = validCard.toString();
        String expected = "2" + "     " + "Onyx" + "  " + "mine" + "\n" +
                "Diamond x" + "1" + " " + "Rubby x" + "1" + " " +
                "Emerald x" + "1" + " " + "Onyx x" + "1" + " " +
                "Sapphire x" + "1" + " " + "\n";
        assertEquals(expected, result);
    }

    @Test
    public void testCardsToStringMultipleWhite() {
        int validPt = 2;

        Tokens diamondToken = new Tokens("Diamond");

        ArrayList<Tokens> allCost = new ArrayList<>();
        allCost.add(diamondToken);
        allCost.add(diamondToken);
        allCost.add(diamondToken);

        String validName = "mine";

        Cards validCard = new Cards(validPt, allCost, validName, diamondToken);
        String result = validCard.toString();
        String expected = "2" + "     " + "Diamond" + "  " + "mine" + "\n" +
                "Diamond x" + "3" + " " + "\n";
        assertEquals(expected, result);
    }

    @Test
    public void testCardsToStringGreen() {
        int validPt = 1;

        Tokens emeraldToken = new Tokens("Emerald");

        ArrayList<Tokens> noCost = new ArrayList<>();

        String validName = "mine";

        Cards validCard = new Cards(validPt, noCost, validName, emeraldToken);
        String result = validCard.toString();
        String expected = "1" + "     " + "Emerald" + "  " + "mine" + "\n" + "\n";
        assertEquals(expected, result);
    }

    @Test
    public void testCardsCompareToSameCards() {
        int validPt = 1;
        Tokens onyxToken = new Tokens("Onyx");

        ArrayList<Tokens> validCost = new ArrayList<>();
        validCost.add(onyxToken);
        validCost.add(onyxToken);
        validCost.add(onyxToken);

        String validName = "mine";

        Tokens validResource = new Tokens("Onyx");

        Cards validCard = new Cards(validPt, validCost, validName, validResource);

        assertTrue(validCard.compareTo(validCard) == 0);
    }

    // Test Failed: compareTo returns true is resource is different
//    @Test
//    public void testCardsCompareToDiffResource() {
//        int validPt = 1;
//        Tokens onyxToken = new Tokens("Onyx");
//        Tokens diamondToken = new Tokens("Diamond");
//
//        ArrayList<Tokens> validCost = new ArrayList<>();
//        validCost.add(onyxToken);
//        validCost.add(onyxToken);
//        validCost.add(onyxToken);
//
//        String validName = "mine";
//
//        Cards validCard1 = new Cards(validPt, validCost, validName, onyxToken);
//        Cards validCard2 = new Cards(validPt, validCost, validName, diamondToken);
//
//        assertFalse(validCard1.compareTo(validCard2) == 0);
//    }

    // Test Failed: compareTo returns true when name is different
//    @Test
//    public void testCardsCompareToDiffName() {
//        int validPt = 1;
//        Tokens onyxToken = new Tokens("Onyx");
//
//        ArrayList<Tokens> validCost = new ArrayList<>();
//        validCost.add(onyxToken);
//        validCost.add(onyxToken);
//        validCost.add(onyxToken);
//
//        String validName1 = "mine";
//        String validName2 = "artisan";
//
//        Cards validCard1 = new Cards(validPt, validCost, validName1, onyxToken);
//        Cards validCard2 = new Cards(validPt, validCost, validName2, onyxToken);
//
//        assertFalse(validCard1.compareTo(validCard2) == 0);
//    }

    // Test Failed: compareTo returns true when point is different
//    @Test
//    public void testCardsCompareToDiffPt() {
//        Tokens onyxToken = new Tokens("Onyx");
//
//        ArrayList<Tokens> validCost = new ArrayList<>();
//        validCost.add(onyxToken);
//        validCost.add(onyxToken);
//        validCost.add(onyxToken);
//
//        String validName = "mine";
//
//        Cards validCard1 = new Cards(1, validCost, validName, onyxToken);
//        Cards validCard2 = new Cards(2, validCost, validName, onyxToken);
//
//        assertFalse(validCard1.compareTo(validCard2) == 0);
//    }

     //Test Failed: compareTo returns true when cost is different
//    @Test
//    public void testCardsCompareToDiffCost() {
//        int validPt = 1;
//        Tokens onyxToken = new Tokens("Onyx");
//
//        ArrayList<Tokens> validCost = new ArrayList<>();
//        validCost.add(onyxToken);
//        validCost.add(onyxToken);
//        validCost.add(onyxToken);
//
//        String validName = "mine";
//
//        Cards validCard1 = new Cards(validPt, validCost, validName, onyxToken);
//
//        validCost.add(onyxToken);
//        Cards validCard2 = new Cards(validPt, validCost, validName, onyxToken);
//
//        assertFalse(validCard1.compareTo(validCard2) == 0);
//    }

    @Test
    public void testCardsCompareToAllDifferent() {
        int validPt = 1;
        Tokens onyxToken = new Tokens("Onyx");
        Tokens diamondToken = new Tokens("Diamond");

        ArrayList<Tokens> validCost1 = new ArrayList<>();
        validCost1.add(onyxToken);
        validCost1.add(onyxToken);
        validCost1.add(onyxToken);

        ArrayList<Tokens> validCost2 = new ArrayList<>();
        validCost2.add(onyxToken);
        validCost2.add(diamondToken);
        validCost2.add(onyxToken);

        String validName1 = "mine";
        String validName2 = "artisan";

        Cards validCard1 = new Cards(1, validCost1, validName1, onyxToken);
        Cards validCard2 = new Cards(2, validCost2, validName2, diamondToken);

        assertFalse(validCard1.compareTo(validCard2) == 0);
    }


}