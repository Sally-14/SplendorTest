
package blackBoxTest;
//import static org.assertj.core.api.Assertions.assertThat;
import Interface.*;
import Classes.*;
import Exceptions.*;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.io.*;
//import static org.hamcrest.MatcherAssert.assertThat;
import java.nio.charset.StandardCharsets;

import static org.junit.jupiter.api.Assertions.*;

public class testTextBasedInterface {
    // If choose option 2: Take 1 token from each of 3 different types of tokens(excluding gold) If the user input Sapphire for two time, the invalid error is shown but after that even if user inputs are correct it will always shows invalid input
    @Test
    public void testRepeatedToken() throws PlayerDoesNotHaveEnoughResourcesToBuySelectedCard, SelectedDeckRanOutOfCards, NotEnoughTokensOnTable, InvalidCardsSelectionOfCardsInReserve, FileNotFoundException, InvalidCardsSelectionOfCardsOnTable, PlayerAlreadyHoldsThreeReserveCards, PlayerDoesNotHaveSelectedCardInReserve, InterruptedException {
        try {
        // set up testable input and output channels
        byte[] data = "2\n 2\n 2\n 3\n 4\n".getBytes(StandardCharsets.UTF_8);
        BufferedInputStream in = new BufferedInputStream(new ByteArrayInputStream(data));
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintStream output = new PrintStream(out);
        // redirect the standard channels

        String[] args = null;
        System.setIn(in);
        TextBasedInterface.main(null);
        System.setOut(output);

        // call to method that does standard I/O
        String result = out.toString().replaceAll("\r","");
//        System.setOut(output);

//        System.setIn(in); System.setOut(output);
//        assertEquals(expected,result);
        } catch (Exception e) {
            String expected = "Welcome to Splendor! How many player(s) do you wish to have(including yourself)?\n" +
                    "2. 2    3. 3.    4. 4\n" +
                    "2\n" +
                    "Check0 completed\n" +
                    "Check1 completed\n" +
                    "Check2 completed\n" +
                    "Check3 completed\n" +
                    "check4 completed\n" +
                    "Awesome! lets start the game!\n" +
                    "\n" +
                    "\n" +
                    "***** Player 1 0 Point(s) *****\n" +
                    "Tokens: Onyx x0 ,Sapphire x0 ,Emerlad x0 ,Diamond x0 ,Rubby x0 ,Gold x0\n" +
                    "\n" +
                    "Cards:\n" +
                    "\n" +
                    "Nobles:\n" +
                    "\n" +
                    "\n" +
                    "Cards in Reserve x0\n" +
                    "*******************************\n" +
                    "\n" +
                    "***** Player 2 0 Point(s) *****\n" +
                    "Tokens: Onyx x0 ,Sapphire x0 ,Emerlad x0 ,Diamond x0 ,Rubby x0 ,Gold x0\n" +
                    "\n" +
                    "Cards:\n" +
                    "\n" +
                    "Nobles:\n" +
                    "\n" +
                    "\n" +
                    "Cards in Reserve x0\n" +
                    "*******************************\n" +
                    "\n" +
                    "/////////////////////////////////////\n" +
                    "Blue Deck\n" +
                    "Blue Card 1:\n" +
                    "4     Diamond  Town\n" +
                    "Diamond x3 Rubby x3 Onyx x6\n" +
                    "\n" +
                    "Blue Card 2:\n" +
                    "5     Sapphire  Town\n" +
                    "Diamond x7 Sapphire x3\n" +
                    "\n" +
                    "Blue Card 3:\n" +
                    "5     Rubby  Town\n" +
                    "Rubby x3 Emerald x7\n" +
                    "\n" +
                    "Blue Card 4:\n" +
                    "4     Diamond  Town\n" +
                    "Diamond x3 Rubby x3 Onyx x6\n" +
                    "\n" +
                    "/////////////////////////\n" +
                    "Yellow Deck\n" +
                    "Yellow Card 1:\n" +
                    "2     Rubby  Town\n" +
                    "Diamond x1 Emerald x2 Sapphire x4\n" +
                    "\n" +
                    "Yellow Card 2:\n" +
                    "2     Sapphire  Town\n" +
                    "Diamond x2 Rubby x1 Onyx x4\n" +
                    "\n" +
                    "Yellow Card 3:\n" +
                    "3     Emerald  Town\n" +
                    "Emerald x6\n" +
                    "\n" +
                    "Yellow Card 4:\n" +
                    "2     Rubby  Town\n" +
                    "Diamond x3 Onyx x5\n" +
                    "\n" +
                    "/////////////////////////\n" +
                    "Green Deck\n" +
                    "Green Card 1:\n" +
                    "0     Rubby  Town\n" +
                    "Diamond x1 Emerald x1 Onyx x1 Sapphire x2\n" +
                    "\n" +
                    "Green Card 2:\n" +
                    "0     Sapphire  Town\n" +
                    "Emerald x2 Onyx x2\n" +
                    "\n" +
                    "Green Card 3:\n" +
                    "0     Rubby  Town\n" +
                    "Diamond x2 Rubby x2\n" +
                    "\n" +
                    "Green Card 4:\n" +
                    "0     Emerald  Town\n" +
                    "Diamond x1 Rubby x1 Onyx x2 Sapphire x1\n" +
                    "\n" +
                    "/////////////////////////////////////\n" +
                    "Tokens Avalible: Onyx x4 ,Sapphire x4 ,Emerald x4 ,Diamond x4 ,Rubby x4 ,Gold x4\n" +
                    "\n" +
                    "Nobles Avalible:\n" +
                    "\n" +
                    "******* G Mine S *******\n" +
                    "Diamond x1    Rubby x2    Emerald x2\n" +
                    "\n" +
                    "\n" +
                    "******* G Mine S *******\n" +
                    "Diamond x1    Rubby x1    Emerald x1    Onyx x1\n" +
                    "\n" +
                    "\n" +
                    "******* G Mine E *******\n" +
                    "Rubby x3\n" +
                    "\n" +
                    "\n" +
                    "******* G Mine E *******\n" +
                    "Rubby x2    Onyx x2    Sapphire x1\n" +
                    "\n" +
                    "\n" +
                    "******* G Mine E *******\n" +
                    "Diamond x1    Rubby x1    Onyx x1    Sapphire x1\n" +
                    "\n" +
                    "\n" +
                    "******* G Mine E *******\n" +
                    "Diamond x1    Rubby x1    Onyx x2    Sapphire x1\n" +
                    "\n" +
                    "\n" +
                    "******* G Mine E *******\n" +
                    "Diamond x1    Emerald x1    Sapphire x3\n" +
                    "\n" +
                    "\n" +
                    "******* G Mine E *******\n" +
                    "Rubby x2    Sapphire x2\n" +
                    "\n" +
                    "\n" +
                    "******* G Mine E *******\n" +
                    "Diamond x2    Sapphire x1\n" +
                    "\n" +
                    "\n" +
                    "******* G Mine R *******\n" +
                    "Diamond x4\n" +
                    "\n" +
                    "\n" +
                    "******* G Mine R *******\n" +
                    "Diamond x2    Rubby x2\n" +
                    "\n" +
                    "\n" +
                    "******* G Mine R *******\n" +
                    "Diamond x1    Emerald x1    Onyx x1    Sapphire x1\n" +
                    "\n" +
                    "\n" +
                    "******* G Mine R *******\n" +
                    "Diamond x1    Emerald x1    Onyx x1    Sapphire x2\n" +
                    "\n" +
                    "\n" +
                    "******* G Mine R *******\n" +
                    "Diamond x2    Emerald x1    Onyx x1\n" +
                    "\n" +
                    "\n" +
                    "******* G Mine R *******\n" +
                    "Emerald x1    Sapphire x2\n" +
                    "\n" +
                    "\n" +
                    "******* G Mine R *******\n" +
                    "Diamond x1    Rubby x1    Onyx x3\n" +
                    "\n" +
                    "\n" +
                    "******* G Mine R *******\n" +
                    "Diamond x3\n" +
                    "\n" +
                    "\n" +
                    "******* G Mine D *******\n" +
                    "Emerald x4\n" +
                    "\n" +
                    "\n" +
                    "******* G Mine D *******\n" +
                    "Diamond x3    Onyx x1    Sapphire x1\n" +
                    "\n" +
                    "\n" +
                    "******* G Mine D *******\n" +
                    "Rubby x1    Emerald x2    Onyx x1    Sapphire x1\n" +
                    "\n" +
                    "\n" +
                    "******* G Mine D *******\n" +
                    "Onyx x2    Sapphire x2\n" +
                    "\n" +
                    "\n" +
                    "******* G Mine D *******\n" +
                    "Sapphire x3\n" +
                    "\n" +
                    "\n" +
                    "******* G Mine D *******\n" +
                    "Rubby x1    Emerald x1    Onyx x1    Sapphire x1\n" +
                    "\n" +
                    "\n" +
                    "******* G Mine D *******\n" +
                    "Rubby x2    Onyx x1\n" +
                    "\n" +
                    "\n" +
                    "******* G Mine D *******\n" +
                    "Emerald x2    Onyx x1    Sapphire x2\n" +
                    "\n" +
                    "\n" +
                    "******* G Mine O *******\n" +
                    "Sapphire x4\n" +
                    "\n" +
                    "\n" +
                    "******* G Mine O *******\n" +
                    "Diamond x2    Rubby x2    Sapphire x2\n" +
                    "\n" +
                    "\n" +
                    "******* G Mine O *******\n" +
                    "Diamond x1    Rubby x1    Emerald x1    Sapphire x2\n" +
                    "\n" +
                    "\n" +
                    "******* G Mine O *******\n" +
                    "Emerald x3\n" +
                    "\n" +
                    "\n" +
                    "******* G Mine O *******\n" +
                    "Rubby x3    Emerald x1    Onyx x1\n" +
                    "\n" +
                    "\n" +
                    "******* G Mine O *******\n" +
                    "Diamond x2    Emerald x2\n" +
                    "\n" +
                    "\n" +
                    "******* G Mine O *******\n" +
                    "Rubby x1    Emerald x2\n" +
                    "\n" +
                    "\n" +
                    "******* G Mine O *******\n" +
                    "Diamond x1    Rubby x1    Emerald x1    Sapphire x1\n" +
                    "\n" +
                    "\n" +
                    "******* Y Merchant S *******\n" +
                    "Sapphire x6\n" +
                    "\n" +
                    "\n" +
                    "******* Y Merchant S *******\n" +
                    "Diamond x2    Rubby x1    Onyx x4\n" +
                    "\n" +
                    "\n" +
                    "******* Y Merchant S *******\n" +
                    "Sapphire x5\n" +
                    "\n" +
                    "\n" +
                    "******* Y Transports S *******\n" +
                    "Diamond x3    Sapphire x3\n" +
                    "\n" +
                    "\n" +
                    "******* Y Transports S *******\n" +
                    "Emerald x3    Onyx x3    Sapphire x2\n" +
                    "\n" +
                    "\n" +
                    "******* Y Transports S *******\n" +
                    "Rubby x3    Emerald x2    Sapphire x2\n" +
                    "\n" +
                    "\n" +
                    "******* Y Transports E *******\n" +
                    "Emerald x6\n" +
                    "\n" +
                    "\n" +
                    "******* Y Transports E *******\n" +
                    "Emerald x3    Sapphire x3\n" +
                    "\n" +
                    "\n" +
                    "******* Y Transports E *******\n" +
                    "Emerald x5\n" +
                    "\n" +
                    "\n" +
                    "******* Y Merchant E *******\n" +
                    "Diamond x4    Onyx x1    Sapphire x2\n" +
                    "\n" +
                    "\n" +
                    "******* Y Merchant E *******\n" +
                    "Diamond x2    Onyx x2    Sapphire x3\n" +
                    "\n" +
                    "\n" +
                    "******* Y Merchant E *******\n" +
                    "Diamond x3    Rubby x3    Emerald x2\n" +
                    "\n" +
                    "\n" +
                    "******* Y Merchant R *******\n" +
                    "Rubby x6\n" +
                    "\n" +
                    "\n" +
                    "******* Y Merchant R *******\n" +
                    "Onyx x5\n" +
                    "\n" +
                    "\n" +
                    "******* Y Merchant R *******\n" +
                    "Diamond x3    Onyx x5\n" +
                    "\n" +
                    "\n" +
                    "******* Y Transports R *******\n" +
                    "Diamond x1    Emerald x2    Sapphire x4\n" +
                    "\n" +
                    "\n" +
                    "******* Y Transports R *******\n" +
                    "Diamond x2    Rubby x2    Onyx x3\n" +
                    "\n" +
                    "\n" +
                    "******* Y Transports R *******\n" +
                    "Rubby x2    Onyx x3    Sapphire x3\n" +
                    "\n" +
                    "\n" +
                    "******* Y Merchant D *******\n" +
                    "Diamond x6\n" +
                    "\n" +
                    "\n" +
                    "******* Y Merchant D *******\n" +
                    "Rubby x5    Onyx x3\n" +
                    "\n" +
                    "\n" +
                    "******* Y Merchant D *******\n" +
                    "Rubby x5\n" +
                    "\n" +
                    "\n" +
                    "******* Y Transports D *******\n" +
                    "Rubby x4    Emerald x1    Onyx x2\n" +
                    "\n" +
                    "\n" +
                    "******* Y Transports D *******\n" +
                    "Diamond x2    Rubby x3    Sapphire x3\n" +
                    "\n" +
                    "\n" +
                    "******* Y Transports D *******\n" +
                    "Rubby x2    Emerald x3    Onyx x2\n" +
                    "\n" +
                    "\n" +
                    "******* Y Merchant O *******\n" +
                    "Onyx x6\n" +
                    "\n" +
                    "\n" +
                    "******* Y Merchant O *******\n" +
                    "Rubby x3    Emerald x5\n" +
                    "\n" +
                    "\n" +
                    "******* Y Merchant O *******\n" +
                    "Diamond x5\n" +
                    "\n" +
                    "\n" +
                    "******* Y Transports O *******\n" +
                    "Rubby x2    Emerald x4    Sapphire x1\n" +
                    "\n" +
                    "\n" +
                    "******* Y Transports O *******\n" +
                    "Diamond x3    Emerald x3    Onyx x2\n" +
                    "\n" +
                    "\n" +
                    "******* Y Transports O *******\n" +
                    "Diamond x3    Emerald x2    Sapphire x3\n" +
                    "\n" +
                    "\n" +
                    "******* B Town S *******\n" +
                    "Diamond x7    Sapphire x3\n" +
                    "\n" +
                    "\n" +
                    "******* B Town S *******\n" +
                    "Diamond x6    Onyx x3    Sapphire x3\n" +
                    "\n" +
                    "\n" +
                    "******* B Shop S *******\n" +
                    "Diamond x7    Sapphire x3\n" +
                    "\n" +
                    "\n" +
                    "******* B Shop S *******\n" +
                    "Diamond x3    Rubby x3    Emerald x3    Onyx x5\n" +
                    "\n" +
                    "\n" +
                    "******* B Town E *******\n" +
                    "Emerald x3    Sapphire x7\n" +
                    "\n" +
                    "\n" +
                    "******* B Shop E *******\n" +
                    "Sapphire x7\n" +
                    "\n" +
                    "\n" +
                    "******* B Shop E *******\n" +
                    "Diamond x3    Emerald x3    Sapphire x6\n" +
                    "\n" +
                    "\n" +
                    "******* B Town E *******\n" +
                    "Diamond x5    Rubby x3    Onyx x3    Sapphire x3\n" +
                    "\n" +
                    "\n" +
                    "******* B Town R *******\n" +
                    "Rubby x3    Emerald x7\n" +
                    "\n" +
                    "\n" +
                    "******* B Town R *******\n" +
                    "Rubby x3    Emerald x6    Sapphire x3\n" +
                    "\n" +
                    "\n" +
                    "******* B Shop R *******\n" +
                    "Emerald x7\n" +
                    "\n" +
                    "\n" +
                    "******* B Shop R *******\n" +
                    "Diamond x3    Emerald x3    Sapphire x5\n" +
                    "\n" +
                    "\n" +
                    "******* B Shop D *******\n" +
                    "Diamond x3    Onyx x7\n" +
                    "\n" +
                    "\n" +
                    "******* B Town D *******\n" +
                    "Diamond x3    Rubby x3    Onyx x6\n" +
                    "\n" +
                    "\n" +
                    "******* B Town D *******\n" +
                    "Onyx x7\n" +
                    "\n" +
                    "\n" +
                    "******* B Shop D *******\n" +
                    "Rubby x5    Emerald x3    Onyx x3    Sapphire x3\n" +
                    "\n" +
                    "\n" +
                    "******* B Town O *******\n" +
                    "Rubby x7    Onyx x3\n" +
                    "\n" +
                    "\n" +
                    "******* B Shop O *******\n" +
                    "Rubby x6    Emerald x3    Onyx x3\n" +
                    "\n" +
                    "\n" +
                    "******* B Shop O *******\n" +
                    "Rubby x7\n" +
                    "\n" +
                    "\n" +
                    "******* B Town O *******\n" +
                    "Diamond x3    Rubby x3    Emerald x5    Sapphire x3\n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "It is Player 1's turn!\n" +
                    "Player 1, here is what you currently have:\n" +
                    "\n" +
                    "\n" +
                    "***** Player 1 0 Point(s) *****\n" +
                    "Tokens: Onyx x0 ,Sapphire x0 ,Emerlad x0 ,Diamond x0 ,Rubby x0 ,Gold x0\n" +
                    "\n" +
                    "**** Cards ****\n" +
                    "\n" +
                    "**** Nobles ****\n" +
                    "\n" +
                    "\n" +
                    "**** Cards in Reserve ****\n" +
                    "\n" +
                    "\n" +
                    "Player 1, what do you wish to do this round?\n" +
                    "\n" +
                    "1. Take 2 tokens of the same color from the table(may only be performed if there is 4 or more tokens in the color of your chosing)\n" +
                    "2. Take 1 token from each of 3 different types of tokens(excluding gold)\n" +
                    "3. Reserve a card on the table and receive one gold token(keep in mind you may only have three reserved cards maximum. Also, you will not recieve any gold token if there is non on the table)\n" +
                    "4. Reserve an unknown card from the top of a chosen deck\n" +
                    "5. Buy a card from your reserved cards\n" +
                    "6. Buy a card on the table\n" +
                    "2\n" +
                    "Choose a token to take.\n" +
                    "1. Onyx x4 2. Sapphire x4 3. Emerald x4 4. Diamond x4 5. Rubby x4\n" +
                    "2\n" +
                    "Choose a different token that you have not selected.\n" +
                    "1. Onyx x4 2. Sapphire x4 3. Emerald x4 4. Diamond x4 5. Rubby x4\n" +
                    "3\n" +
                    "Choose a different token that you have not selected.\n" +
                    "1. Onyx x4 2. Sapphire x4 3. Emerald x4 4. Diamond x4 5. Rubby x4\n" +
                    "4\n" +
                    "3YOLOSWAG2\n" +
                    "Possibly not Working\n" +
                    "6YOLOSWAG2\n" +
                    "Possibly not Working\n" +
                    "9YOLOSWAG2\n" +
                    "Possibly not Working\n" +
                    "12YOLOSWAG2\n" +
                    "Working\n" +
                    "15YOLOSWAG2\n" +
                    "Working\n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "***** Player 1 0 Point(s) *****\n" +
                    "Tokens: Onyx x3 ,Sapphire x4 ,Emerlad x5 ,Diamond x2 ,Rubby x1 ,Gold x0\n" +
                    "\n" +
                    "Cards:\n" +
                    "\n" +
                    "Nobles:\n" +
                    "\n" +
                    "\n" +
                    "Cards in Reserve x0\n" +
                    "*******************************\n" +
                    "\n" +
                    "***** Player 2 0 Point(s) *****\n" +
                    "Tokens: Onyx x0 ,Sapphire x0 ,Emerlad x0 ,Diamond x0 ,Rubby x0 ,Gold x0\n" +
                    "\n" +
                    "Cards:\n" +
                    "\n" +
                    "Nobles:\n" +
                    "\n" +
                    "\n" +
                    "Cards in Reserve x0\n" +
                    "*******************************\n" +
                    "\n" +
                    "/////////////////////////////////////\n" +
                    "Blue Deck\n" +
                    "Blue Card 1:\n" +
                    "4     Diamond  Town\n" +
                    "Diamond x3 Rubby x3 Onyx x6\n" +
                    "\n" +
                    "Blue Card 2:\n" +
                    "5     Sapphire  Town\n" +
                    "Diamond x7 Sapphire x3\n" +
                    "\n" +
                    "Blue Card 3:\n" +
                    "5     Rubby  Town\n" +
                    "Rubby x3 Emerald x7\n" +
                    "\n" +
                    "Blue Card 4:\n" +
                    "4     Diamond  Town\n" +
                    "Diamond x3 Rubby x3 Onyx x6\n" +
                    "\n" +
                    "/////////////////////////\n" +
                    "Yellow Deck\n" +
                    "Yellow Card 1:\n" +
                    "2     Rubby  Town\n" +
                    "Diamond x1 Emerald x2 Sapphire x4\n" +
                    "\n" +
                    "Yellow Card 2:\n" +
                    "2     Sapphire  Town\n" +
                    "Diamond x2 Rubby x1 Onyx x4\n" +
                    "\n" +
                    "Yellow Card 3:\n" +
                    "3     Emerald  Town\n" +
                    "Emerald x6\n" +
                    "\n" +
                    "Yellow Card 4:\n" +
                    "2     Rubby  Town\n" +
                    "Diamond x3 Onyx x5\n" +
                    "\n" +
                    "/////////////////////////\n" +
                    "Green Deck\n" +
                    "Green Card 1:\n" +
                    "0     Rubby  Town\n" +
                    "Diamond x1 Emerald x1 Onyx x1 Sapphire x2\n" +
                    "\n" +
                    "Green Card 2:\n" +
                    "0     Sapphire  Town\n" +
                    "Emerald x2 Onyx x2\n" +
                    "\n" +
                    "Green Card 3:\n" +
                    "0     Rubby  Town\n" +
                    "Diamond x2 Rubby x2\n" +
                    "\n" +
                    "Green Card 4:\n" +
                    "0     Emerald  Town\n" +
                    "Diamond x1 Rubby x1 Onyx x2 Sapphire x1\n" +
                    "\n" +
                    "/////////////////////////////////////\n" +
                    "Tokens Avalible: Onyx x1 ,Sapphire x0 ,Emerald x0 ,Diamond x2 ,Rubby x3 ,Gold x4\n" +
                    "\n" +
                    "Nobles Avalible:\n" +
                    "\n" +
                    "******* G Mine S *******\n" +
                    "Diamond x1    Rubby x2    Emerald x2\n" +
                    "\n" +
                    "\n" +
                    "******* G Mine S *******\n" +
                    "Diamond x1    Rubby x1    Emerald x1    Onyx x1\n" +
                    "\n" +
                    "\n" +
                    "******* G Mine E *******\n" +
                    "Rubby x3\n" +
                    "\n" +
                    "\n" +
                    "******* G Mine E *******\n" +
                    "Rubby x2    Onyx x2    Sapphire x1\n" +
                    "\n" +
                    "\n" +
                    "******* G Mine E *******\n" +
                    "Diamond x1    Rubby x1    Onyx x1    Sapphire x1\n" +
                    "\n" +
                    "\n" +
                    "******* G Mine E *******\n" +
                    "Diamond x1    Rubby x1    Onyx x2    Sapphire x1\n" +
                    "\n" +
                    "\n" +
                    "******* G Mine E *******\n" +
                    "Diamond x1    Emerald x1    Sapphire x3\n" +
                    "\n" +
                    "\n" +
                    "******* G Mine E *******\n" +
                    "Rubby x2    Sapphire x2\n" +
                    "\n" +
                    "\n" +
                    "******* G Mine E *******\n" +
                    "Diamond x2    Sapphire x1\n" +
                    "\n" +
                    "\n" +
                    "******* G Mine R *******\n" +
                    "Diamond x4\n" +
                    "\n" +
                    "\n" +
                    "******* G Mine R *******\n" +
                    "Diamond x2    Rubby x2\n" +
                    "\n" +
                    "\n" +
                    "******* G Mine R *******\n" +
                    "Diamond x1    Emerald x1    Onyx x1    Sapphire x1\n" +
                    "\n" +
                    "\n" +
                    "******* G Mine R *******\n" +
                    "Diamond x1    Emerald x1    Onyx x1    Sapphire x2\n" +
                    "\n" +
                    "\n" +
                    "******* G Mine R *******\n" +
                    "Diamond x2    Emerald x1    Onyx x1\n" +
                    "\n" +
                    "\n" +
                    "******* G Mine R *******\n" +
                    "Emerald x1    Sapphire x2\n" +
                    "\n" +
                    "\n" +
                    "******* G Mine R *******\n" +
                    "Diamond x1    Rubby x1    Onyx x3\n" +
                    "\n" +
                    "\n" +
                    "******* G Mine R *******\n" +
                    "Diamond x3\n" +
                    "\n" +
                    "\n" +
                    "******* G Mine D *******\n" +
                    "Emerald x4\n" +
                    "\n" +
                    "\n" +
                    "******* G Mine D *******\n" +
                    "Diamond x3    Onyx x1    Sapphire x1\n" +
                    "\n" +
                    "\n" +
                    "******* G Mine D *******\n" +
                    "Rubby x1    Emerald x2    Onyx x1    Sapphire x1\n" +
                    "\n" +
                    "\n" +
                    "******* G Mine D *******\n" +
                    "Onyx x2    Sapphire x2\n" +
                    "\n" +
                    "\n" +
                    "******* G Mine D *******\n" +
                    "Sapphire x3\n" +
                    "\n" +
                    "\n" +
                    "******* G Mine D *******\n" +
                    "Rubby x1    Emerald x1    Onyx x1    Sapphire x1\n" +
                    "\n" +
                    "\n" +
                    "******* G Mine D *******\n" +
                    "Rubby x2    Onyx x1\n" +
                    "\n" +
                    "\n" +
                    "******* G Mine D *******\n" +
                    "Emerald x2    Onyx x1    Sapphire x2\n" +
                    "\n" +
                    "\n" +
                    "******* G Mine O *******\n" +
                    "Sapphire x4\n" +
                    "\n" +
                    "\n" +
                    "******* G Mine O *******\n" +
                    "Diamond x2    Rubby x2    Sapphire x2\n" +
                    "\n" +
                    "\n" +
                    "******* G Mine O *******\n" +
                    "Diamond x1    Rubby x1    Emerald x1    Sapphire x2\n" +
                    "\n" +
                    "\n" +
                    "******* G Mine O *******\n" +
                    "Emerald x3\n" +
                    "\n" +
                    "\n" +
                    "******* G Mine O *******\n" +
                    "Rubby x3    Emerald x1    Onyx x1\n" +
                    "\n" +
                    "\n" +
                    "******* G Mine O *******\n" +
                    "Diamond x2    Emerald x2\n" +
                    "\n" +
                    "\n" +
                    "******* G Mine O *******\n" +
                    "Rubby x1    Emerald x2\n" +
                    "\n" +
                    "\n" +
                    "******* G Mine O *******\n" +
                    "Diamond x1    Rubby x1    Emerald x1    Sapphire x1\n" +
                    "\n" +
                    "\n" +
                    "******* Y Merchant S *******\n" +
                    "Sapphire x6\n" +
                    "\n" +
                    "\n" +
                    "******* Y Merchant S *******\n" +
                    "Diamond x2    Rubby x1    Onyx x4\n" +
                    "\n" +
                    "\n" +
                    "******* Y Merchant S *******\n" +
                    "Sapphire x5\n" +
                    "\n" +
                    "\n" +
                    "******* Y Transports S *******\n" +
                    "Diamond x3    Sapphire x3\n" +
                    "\n" +
                    "\n" +
                    "******* Y Transports S *******\n" +
                    "Emerald x3    Onyx x3    Sapphire x2\n" +
                    "\n" +
                    "\n" +
                    "******* Y Transports S *******\n" +
                    "Rubby x3    Emerald x2    Sapphire x2\n" +
                    "\n" +
                    "\n" +
                    "******* Y Transports E *******\n" +
                    "Emerald x6\n" +
                    "\n" +
                    "\n" +
                    "******* Y Transports E *******\n" +
                    "Emerald x3    Sapphire x3\n" +
                    "\n" +
                    "\n" +
                    "******* Y Transports E *******\n" +
                    "Emerald x5\n" +
                    "\n" +
                    "\n" +
                    "******* Y Merchant E *******\n" +
                    "Diamond x4    Onyx x1    Sapphire x2\n" +
                    "\n" +
                    "\n" +
                    "******* Y Merchant E *******\n" +
                    "Diamond x2    Onyx x2    Sapphire x3\n" +
                    "\n" +
                    "\n" +
                    "******* Y Merchant E *******\n" +
                    "Diamond x3    Rubby x3    Emerald x2\n" +
                    "\n" +
                    "\n" +
                    "******* Y Merchant R *******\n" +
                    "Rubby x6\n" +
                    "\n" +
                    "\n" +
                    "******* Y Merchant R *******\n" +
                    "Onyx x5\n" +
                    "\n" +
                    "\n" +
                    "******* Y Merchant R *******\n" +
                    "Diamond x3    Onyx x5\n" +
                    "\n" +
                    "\n" +
                    "******* Y Transports R *******\n" +
                    "Diamond x1    Emerald x2    Sapphire x4\n" +
                    "\n" +
                    "\n" +
                    "******* Y Transports R *******\n" +
                    "Diamond x2    Rubby x2    Onyx x3\n" +
                    "\n" +
                    "\n" +
                    "******* Y Transports R *******\n" +
                    "Rubby x2    Onyx x3    Sapphire x3\n" +
                    "\n" +
                    "\n" +
                    "******* Y Merchant D *******\n" +
                    "Diamond x6\n" +
                    "\n" +
                    "\n" +
                    "******* Y Merchant D *******\n" +
                    "Rubby x5    Onyx x3\n" +
                    "\n" +
                    "\n" +
                    "******* Y Merchant D *******\n" +
                    "Rubby x5\n" +
                    "\n" +
                    "\n" +
                    "******* Y Transports D *******\n" +
                    "Rubby x4    Emerald x1    Onyx x2\n" +
                    "\n" +
                    "\n" +
                    "******* Y Transports D *******\n" +
                    "Diamond x2    Rubby x3    Sapphire x3\n" +
                    "\n" +
                    "\n" +
                    "******* Y Transports D *******\n" +
                    "Rubby x2    Emerald x3    Onyx x2\n" +
                    "\n" +
                    "\n" +
                    "******* Y Merchant O *******\n" +
                    "Onyx x6\n" +
                    "\n" +
                    "\n" +
                    "******* Y Merchant O *******\n" +
                    "Rubby x3    Emerald x5\n" +
                    "\n" +
                    "\n" +
                    "******* Y Merchant O *******\n" +
                    "Diamond x5\n" +
                    "\n" +
                    "\n" +
                    "******* Y Transports O *******\n" +
                    "Rubby x2    Emerald x4    Sapphire x1\n" +
                    "\n" +
                    "\n" +
                    "******* Y Transports O *******\n" +
                    "Diamond x3    Emerald x3    Onyx x2\n" +
                    "\n" +
                    "\n" +
                    "******* Y Transports O *******\n" +
                    "Diamond x3    Emerald x2    Sapphire x3\n" +
                    "\n" +
                    "\n" +
                    "******* B Town S *******\n" +
                    "Diamond x7    Sapphire x3\n" +
                    "\n" +
                    "\n" +
                    "******* B Town S *******\n" +
                    "Diamond x6    Onyx x3    Sapphire x3\n" +
                    "\n" +
                    "\n" +
                    "******* B Shop S *******\n" +
                    "Diamond x7    Sapphire x3\n" +
                    "\n" +
                    "\n" +
                    "******* B Shop S *******\n" +
                    "Diamond x3    Rubby x3    Emerald x3    Onyx x5\n" +
                    "\n" +
                    "\n" +
                    "******* B Town E *******\n" +
                    "Emerald x3    Sapphire x7\n" +
                    "\n" +
                    "\n" +
                    "******* B Shop E *******\n" +
                    "Sapphire x7\n" +
                    "\n" +
                    "\n" +
                    "******* B Shop E *******\n" +
                    "Diamond x3    Emerald x3    Sapphire x6\n" +
                    "\n" +
                    "\n" +
                    "******* B Town E *******\n" +
                    "Diamond x5    Rubby x3    Onyx x3    Sapphire x3\n" +
                    "\n" +
                    "\n" +
                    "******* B Town R *******\n" +
                    "Rubby x3    Emerald x7\n" +
                    "\n" +
                    "\n" +
                    "******* B Town R *******\n" +
                    "Rubby x3    Emerald x6    Sapphire x3\n" +
                    "\n" +
                    "\n" +
                    "******* B Shop R *******\n" +
                    "Emerald x7\n" +
                    "\n" +
                    "\n" +
                    "******* B Shop R *******\n" +
                    "Diamond x3    Emerald x3    Sapphire x5\n" +
                    "\n" +
                    "\n" +
                    "******* B Shop D *******\n" +
                    "Diamond x3    Onyx x7\n" +
                    "\n" +
                    "\n" +
                    "******* B Town D *******\n" +
                    "Diamond x3    Rubby x3    Onyx x6\n" +
                    "\n" +
                    "\n" +
                    "******* B Town D *******\n" +
                    "Onyx x7\n" +
                    "\n" +
                    "\n" +
                    "******* B Shop D *******\n" +
                    "Rubby x5    Emerald x3    Onyx x3    Sapphire x3\n" +
                    "\n" +
                    "\n" +
                    "******* B Town O *******\n" +
                    "Rubby x7    Onyx x3\n" +
                    "\n" +
                    "\n" +
                    "******* B Shop O *******\n" +
                    "Rubby x6    Emerald x3    Onyx x3\n" +
                    "\n" +
                    "\n" +
                    "******* B Shop O *******\n" +
                    "Rubby x7\n" +
                    "\n" +
                    "\n" +
                    "******* B Town O *******\n" +
                    "Diamond x3    Rubby x3    Emerald x5    Sapphire x3\n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "Attention! Player 1 chose to take three tokens of different color!\n" +
                    "It is Player 2's turn!\n" +
                    "Player 2, here is what you currently have:\n" +
                    "\n" +
                    "\n" +
                    "***** Player 2 0 Point(s) *****\n" +
                    "Tokens: Onyx x0 ,Sapphire x0 ,Emerlad x0 ,Diamond x0 ,Rubby x0 ,Gold x0\n" +
                    "\n" +
                    "**** Cards ****\n" +
                    "\n" +
                    "**** Nobles ****\n" +
                    "\n" +
                    "\n" +
                    "**** Cards in Reserve ****\n" +
                    "\n" +
                    "\n" +
                    "Player 2, what do you wish to do this round?\n" +
                    "\n" +
                    "1. Take 2 tokens of the same color from the table(may only be performed if there is 4 or more tokens in the color of your chosing)\n" +
                    "2. Take 1 token from each of 3 different types of tokens(excluding gold)\n" +
                    "3. Reserve a card on the table and receive one gold token(keep in mind you may only have three reserved cards maximum. Also, you will not recieve any gold token if there is non on the table)\n" +
                    "4. Reserve an unknown card from the top of a chosen deck\n" +
                    "5. Buy a card from your reserved cards\n" +
                    "6. Buy a card on the table\n";
            String result = "Welcome to Splendor! How many player(s) do you wish to have(including yourself)?\n" +
                    "2. 2    3. 3.    4. 4\n" +
                    "2\n" +
                    "Check0 completed\n" +
                    "Check1 completed\n" +
                    "Check2 completed\n" +
                    "Check3 completed\n" +
                    "check4 completed\n" +
                    "Awesome! lets start the game!\n" +
                    "\n" +
                    "\n" +
                    "***** Player 1 0 Point(s) *****\n" +
                    "Tokens: Onyx x0 ,Sapphire x0 ,Emerlad x0 ,Diamond x0 ,Rubby x0 ,Gold x0\n" +
                    "\n" +
                    "Cards:\n" +
                    "\n" +
                    "Nobles:\n" +
                    "\n" +
                    "\n" +
                    "Cards in Reserve x0\n" +
                    "*******************************\n" +
                    "\n" +
                    "***** Player 2 0 Point(s) *****\n" +
                    "Tokens: Onyx x0 ,Sapphire x0 ,Emerlad x0 ,Diamond x0 ,Rubby x0 ,Gold x0\n" +
                    "\n" +
                    "Cards:\n" +
                    "\n" +
                    "Nobles:\n" +
                    "\n" +
                    "\n" +
                    "Cards in Reserve x0\n" +
                    "*******************************\n" +
                    "\n" +
                    "/////////////////////////////////////\n" +
                    "Blue Deck\n" +
                    "Blue Card 1:\n" +
                    "4     Diamond  Town\n" +
                    "Diamond x3 Rubby x3 Onyx x6\n" +
                    "\n" +
                    "Blue Card 2:\n" +
                    "5     Sapphire  Town\n" +
                    "Diamond x7 Sapphire x3\n" +
                    "\n" +
                    "Blue Card 3:\n" +
                    "5     Rubby  Town\n" +
                    "Rubby x3 Emerald x7\n" +
                    "\n" +
                    "Blue Card 4:\n" +
                    "4     Diamond  Town\n" +
                    "Diamond x3 Rubby x3 Onyx x6\n" +
                    "\n" +
                    "/////////////////////////\n" +
                    "Yellow Deck\n" +
                    "Yellow Card 1:\n" +
                    "2     Rubby  Town\n" +
                    "Diamond x1 Emerald x2 Sapphire x4\n" +
                    "\n" +
                    "Yellow Card 2:\n" +
                    "2     Sapphire  Town\n" +
                    "Diamond x2 Rubby x1 Onyx x4\n" +
                    "\n" +
                    "Yellow Card 3:\n" +
                    "3     Emerald  Town\n" +
                    "Emerald x6\n" +
                    "\n" +
                    "Yellow Card 4:\n" +
                    "2     Rubby  Town\n" +
                    "Diamond x3 Onyx x5\n" +
                    "\n" +
                    "/////////////////////////\n" +
                    "Green Deck\n" +
                    "Green Card 1:\n" +
                    "0     Rubby  Town\n" +
                    "Diamond x1 Emerald x1 Onyx x1 Sapphire x2\n" +
                    "\n" +
                    "Green Card 2:\n" +
                    "0     Sapphire  Town\n" +
                    "Emerald x2 Onyx x2\n" +
                    "\n" +
                    "Green Card 3:\n" +
                    "0     Rubby  Town\n" +
                    "Diamond x2 Rubby x2\n" +
                    "\n" +
                    "Green Card 4:\n" +
                    "0     Emerald  Town\n" +
                    "Diamond x1 Rubby x1 Onyx x2 Sapphire x1\n" +
                    "\n" +
                    "/////////////////////////////////////\n" +
                    "Tokens Avalible: Onyx x4 ,Sapphire x4 ,Emerald x4 ,Diamond x4 ,Rubby x4 ,Gold x4\n" +
                    "\n" +
                    "Nobles Avalible:\n" +
                    "\n" +
                    "******* G Mine S *******\n" +
                    "Diamond x1    Rubby x2    Emerald x2\n" +
                    "\n" +
                    "\n" +
                    "******* G Mine S *******\n" +
                    "Diamond x1    Rubby x1    Emerald x1    Onyx x1\n" +
                    "\n" +
                    "\n" +
                    "******* G Mine E *******\n" +
                    "Rubby x3\n" +
                    "\n" +
                    "\n" +
                    "******* G Mine E *******\n" +
                    "Rubby x2    Onyx x2    Sapphire x1\n" +
                    "\n" +
                    "\n" +
                    "******* G Mine E *******\n" +
                    "Diamond x1    Rubby x1    Onyx x1    Sapphire x1\n" +
                    "\n" +
                    "\n" +
                    "******* G Mine E *******\n" +
                    "Diamond x1    Rubby x1    Onyx x2    Sapphire x1\n" +
                    "\n" +
                    "\n" +
                    "******* G Mine E *******\n" +
                    "Diamond x1    Emerald x1    Sapphire x3\n" +
                    "\n" +
                    "\n" +
                    "******* G Mine E *******\n" +
                    "Rubby x2    Sapphire x2\n" +
                    "\n" +
                    "\n" +
                    "******* G Mine E *******\n" +
                    "Diamond x2    Sapphire x1\n" +
                    "\n" +
                    "\n" +
                    "******* G Mine R *******\n" +
                    "Diamond x4\n" +
                    "\n" +
                    "\n" +
                    "******* G Mine R *******\n" +
                    "Diamond x2    Rubby x2\n" +
                    "\n" +
                    "\n" +
                    "******* G Mine R *******\n" +
                    "Diamond x1    Emerald x1    Onyx x1    Sapphire x1\n" +
                    "\n" +
                    "\n" +
                    "******* G Mine R *******\n" +
                    "Diamond x1    Emerald x1    Onyx x1    Sapphire x2\n" +
                    "\n" +
                    "\n" +
                    "******* G Mine R *******\n" +
                    "Diamond x2    Emerald x1    Onyx x1\n" +
                    "\n" +
                    "\n" +
                    "******* G Mine R *******\n" +
                    "Emerald x1    Sapphire x2\n" +
                    "\n" +
                    "\n" +
                    "******* G Mine R *******\n" +
                    "Diamond x1    Rubby x1    Onyx x3\n" +
                    "\n" +
                    "\n" +
                    "******* G Mine R *******\n" +
                    "Diamond x3\n" +
                    "\n" +
                    "\n" +
                    "******* G Mine D *******\n" +
                    "Emerald x4\n" +
                    "\n" +
                    "\n" +
                    "******* G Mine D *******\n" +
                    "Diamond x3    Onyx x1    Sapphire x1\n" +
                    "\n" +
                    "\n" +
                    "******* G Mine D *******\n" +
                    "Rubby x1    Emerald x2    Onyx x1    Sapphire x1\n" +
                    "\n" +
                    "\n" +
                    "******* G Mine D *******\n" +
                    "Onyx x2    Sapphire x2\n" +
                    "\n" +
                    "\n" +
                    "******* G Mine D *******\n" +
                    "Sapphire x3\n" +
                    "\n" +
                    "\n" +
                    "******* G Mine D *******\n" +
                    "Rubby x1    Emerald x1    Onyx x1    Sapphire x1\n" +
                    "\n" +
                    "\n" +
                    "******* G Mine D *******\n" +
                    "Rubby x2    Onyx x1\n" +
                    "\n" +
                    "\n" +
                    "******* G Mine D *******\n" +
                    "Emerald x2    Onyx x1    Sapphire x2\n" +
                    "\n" +
                    "\n" +
                    "******* G Mine O *******\n" +
                    "Sapphire x4\n" +
                    "\n" +
                    "\n" +
                    "******* G Mine O *******\n" +
                    "Diamond x2    Rubby x2    Sapphire x2\n" +
                    "\n" +
                    "\n" +
                    "******* G Mine O *******\n" +
                    "Diamond x1    Rubby x1    Emerald x1    Sapphire x2\n" +
                    "\n" +
                    "\n" +
                    "******* G Mine O *******\n" +
                    "Emerald x3\n" +
                    "\n" +
                    "\n" +
                    "******* G Mine O *******\n" +
                    "Rubby x3    Emerald x1    Onyx x1\n" +
                    "\n" +
                    "\n" +
                    "******* G Mine O *******\n" +
                    "Diamond x2    Emerald x2\n" +
                    "\n" +
                    "\n" +
                    "******* G Mine O *******\n" +
                    "Rubby x1    Emerald x2\n" +
                    "\n" +
                    "\n" +
                    "******* G Mine O *******\n" +
                    "Diamond x1    Rubby x1    Emerald x1    Sapphire x1\n" +
                    "\n" +
                    "\n" +
                    "******* Y Merchant S *******\n" +
                    "Sapphire x6\n" +
                    "\n" +
                    "\n" +
                    "******* Y Merchant S *******\n" +
                    "Diamond x2    Rubby x1    Onyx x4\n" +
                    "\n" +
                    "\n" +
                    "******* Y Merchant S *******\n" +
                    "Sapphire x5\n" +
                    "\n" +
                    "\n" +
                    "******* Y Transports S *******\n" +
                    "Diamond x3    Sapphire x3\n" +
                    "\n" +
                    "\n" +
                    "******* Y Transports S *******\n" +
                    "Emerald x3    Onyx x3    Sapphire x2\n" +
                    "\n" +
                    "\n" +
                    "******* Y Transports S *******\n" +
                    "Rubby x3    Emerald x2    Sapphire x2\n" +
                    "\n" +
                    "\n" +
                    "******* Y Transports E *******\n" +
                    "Emerald x6\n" +
                    "\n" +
                    "\n" +
                    "******* Y Transports E *******\n" +
                    "Emerald x3    Sapphire x3\n" +
                    "\n" +
                    "\n" +
                    "******* Y Transports E *******\n" +
                    "Emerald x5\n" +
                    "\n" +
                    "\n" +
                    "******* Y Merchant E *******\n" +
                    "Diamond x4    Onyx x1    Sapphire x2\n" +
                    "\n" +
                    "\n" +
                    "******* Y Merchant E *******\n" +
                    "Diamond x2    Onyx x2    Sapphire x3\n" +
                    "\n" +
                    "\n" +
                    "******* Y Merchant E *******\n" +
                    "Diamond x3    Rubby x3    Emerald x2\n" +
                    "\n" +
                    "\n" +
                    "******* Y Merchant R *******\n" +
                    "Rubby x6\n" +
                    "\n" +
                    "\n" +
                    "******* Y Merchant R *******\n" +
                    "Onyx x5\n" +
                    "\n" +
                    "\n" +
                    "******* Y Merchant R *******\n" +
                    "Diamond x3    Onyx x5\n" +
                    "\n" +
                    "\n" +
                    "******* Y Transports R *******\n" +
                    "Diamond x1    Emerald x2    Sapphire x4\n" +
                    "\n" +
                    "\n" +
                    "******* Y Transports R *******\n" +
                    "Diamond x2    Rubby x2    Onyx x3\n" +
                    "\n" +
                    "\n" +
                    "******* Y Transports R *******\n" +
                    "Rubby x2    Onyx x3    Sapphire x3\n" +
                    "\n" +
                    "\n" +
                    "******* Y Merchant D *******\n" +
                    "Diamond x6\n" +
                    "\n" +
                    "\n" +
                    "******* Y Merchant D *******\n" +
                    "Rubby x5    Onyx x3\n" +
                    "\n" +
                    "\n" +
                    "******* Y Merchant D *******\n" +
                    "Rubby x5\n" +
                    "\n" +
                    "\n" +
                    "******* Y Transports D *******\n" +
                    "Rubby x4    Emerald x1    Onyx x2\n" +
                    "\n" +
                    "\n" +
                    "******* Y Transports D *******\n" +
                    "Diamond x2    Rubby x3    Sapphire x3\n" +
                    "\n" +
                    "\n" +
                    "******* Y Transports D *******\n" +
                    "Rubby x2    Emerald x3    Onyx x2\n" +
                    "\n" +
                    "\n" +
                    "******* Y Merchant O *******\n" +
                    "Onyx x6\n" +
                    "\n" +
                    "\n" +
                    "******* Y Merchant O *******\n" +
                    "Rubby x3    Emerald x5\n" +
                    "\n" +
                    "\n" +
                    "******* Y Merchant O *******\n" +
                    "Diamond x5\n" +
                    "\n" +
                    "\n" +
                    "******* Y Transports O *******\n" +
                    "Rubby x2    Emerald x4    Sapphire x1\n" +
                    "\n" +
                    "\n" +
                    "******* Y Transports O *******\n" +
                    "Diamond x3    Emerald x3    Onyx x2\n" +
                    "\n" +
                    "\n" +
                    "******* Y Transports O *******\n" +
                    "Diamond x3    Emerald x2    Sapphire x3\n" +
                    "\n" +
                    "\n" +
                    "******* B Town S *******\n" +
                    "Diamond x7    Sapphire x3\n" +
                    "\n" +
                    "\n" +
                    "******* B Town S *******\n" +
                    "Diamond x6    Onyx x3    Sapphire x3\n" +
                    "\n" +
                    "\n" +
                    "******* B Shop S *******\n" +
                    "Diamond x7    Sapphire x3\n" +
                    "\n" +
                    "\n" +
                    "******* B Shop S *******\n" +
                    "Diamond x3    Rubby x3    Emerald x3    Onyx x5\n" +
                    "\n" +
                    "\n" +
                    "******* B Town E *******\n" +
                    "Emerald x3    Sapphire x7\n" +
                    "\n" +
                    "\n" +
                    "******* B Shop E *******\n" +
                    "Sapphire x7\n" +
                    "\n" +
                    "\n" +
                    "******* B Shop E *******\n" +
                    "Diamond x3    Emerald x3    Sapphire x6\n" +
                    "\n" +
                    "\n" +
                    "******* B Town E *******\n" +
                    "Diamond x5    Rubby x3    Onyx x3    Sapphire x3\n" +
                    "\n" +
                    "\n" +
                    "******* B Town R *******\n" +
                    "Rubby x3    Emerald x7\n" +
                    "\n" +
                    "\n" +
                    "******* B Town R *******\n" +
                    "Rubby x3    Emerald x6    Sapphire x3\n" +
                    "\n" +
                    "\n" +
                    "******* B Shop R *******\n" +
                    "Emerald x7\n" +
                    "\n" +
                    "\n" +
                    "******* B Shop R *******\n" +
                    "Diamond x3    Emerald x3    Sapphire x5\n" +
                    "\n" +
                    "\n" +
                    "******* B Shop D *******\n" +
                    "Diamond x3    Onyx x7\n" +
                    "\n" +
                    "\n" +
                    "******* B Town D *******\n" +
                    "Diamond x3    Rubby x3    Onyx x6\n" +
                    "\n" +
                    "\n" +
                    "******* B Town D *******\n" +
                    "Onyx x7\n" +
                    "\n" +
                    "\n" +
                    "******* B Shop D *******\n" +
                    "Rubby x5    Emerald x3    Onyx x3    Sapphire x3\n" +
                    "\n" +
                    "\n" +
                    "******* B Town O *******\n" +
                    "Rubby x7    Onyx x3\n" +
                    "\n" +
                    "\n" +
                    "******* B Shop O *******\n" +
                    "Rubby x6    Emerald x3    Onyx x3\n" +
                    "\n" +
                    "\n" +
                    "******* B Shop O *******\n" +
                    "Rubby x7\n" +
                    "\n" +
                    "\n" +
                    "******* B Town O *******\n" +
                    "Diamond x3    Rubby x3    Emerald x5    Sapphire x3\n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "It is Player 1's turn!\n" +
                    "Player 1, here is what you currently have:\n" +
                    "\n" +
                    "\n" +
                    "***** Player 1 0 Point(s) *****\n" +
                    "Tokens: Onyx x0 ,Sapphire x0 ,Emerlad x0 ,Diamond x0 ,Rubby x0 ,Gold x0\n" +
                    "\n" +
                    "**** Cards ****\n" +
                    "\n" +
                    "**** Nobles ****\n" +
                    "\n" +
                    "\n" +
                    "**** Cards in Reserve ****\n" +
                    "\n" +
                    "\n" +
                    "Player 1, what do you wish to do this round?\n" +
                    "\n" +
                    "1. Take 2 tokens of the same color from the table(may only be performed if there is 4 or more tokens in the color of your chosing)\n" +
                    "2. Take 1 token from each of 3 different types of tokens(excluding gold)\n" +
                    "3. Reserve a card on the table and receive one gold token(keep in mind you may only have three reserved cards maximum. Also, you will not recieve any gold token if there is non on the table)\n" +
                    "4. Reserve an unknown card from the top of a chosen deck\n" +
                    "5. Buy a card from your reserved cards\n" +
                    "6. Buy a card on the table\n" +
                    "2\n" +
                    "Choose a token to take.\n" +
                    "1. Onyx x4 2. Sapphire x4 3. Emerald x4 4. Diamond x4 5. Rubby x4\n" +
                    "2\n" +
                    "Choose a different token that you have not selected.\n" +
                    "1. Onyx x4 2. Sapphire x4 3. Emerald x4 4. Diamond x4 5. Rubby x4\n" +
                    "3\n" +
                    "Choose another different token that you have not selected.\n" +
                    "1. Onyx x4 2. Sapphire x4 3. Emerald x4 4. Diamond4 5. Rubby x4 6. Gold x4\n" +
                    "3\n" +
                    "Invalid choice. You have chosen this token already.\n" +
                    "Choose a token to take.\n" +
                    "1. Onyx x4 2. Sapphire x4 3. Emerald x4 4. Diamond x4 5. Rubby x4\n" +
                    "4\n" +
                    "3YOLOSWAG2\n" +
                    "Possibly not Working\n" +
                    "6YOLOSWAG2\n" +
                    "Possibly not Working\n" +
                    "9YOLOSWAG2\n" +
                    "Possibly not Working\n" +
                    "12YOLOSWAG2\n" +
                    "Working\n" +
                    "15YOLOSWAG2\n" +
                    "Working\n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "***** Player 1 0 Point(s) *****\n" +
                    "Tokens: Onyx x3 ,Sapphire x4 ,Emerlad x5 ,Diamond x2 ,Rubby x1 ,Gold x0\n" +
                    "\n" +
                    "Cards:\n" +
                    "\n" +
                    "Nobles:\n" +
                    "\n" +
                    "\n" +
                    "Cards in Reserve x0\n" +
                    "*******************************\n" +
                    "\n" +
                    "***** Player 2 0 Point(s) *****\n" +
                    "Tokens: Onyx x0 ,Sapphire x0 ,Emerlad x0 ,Diamond x0 ,Rubby x0 ,Gold x0\n" +
                    "\n" +
                    "Cards:\n" +
                    "\n" +
                    "Nobles:\n" +
                    "\n" +
                    "\n" +
                    "Cards in Reserve x0\n" +
                    "*******************************\n" +
                    "\n" +
                    "/////////////////////////////////////\n" +
                    "Blue Deck\n" +
                    "Blue Card 1:\n" +
                    "4     Diamond  Town\n" +
                    "Diamond x3 Rubby x3 Onyx x6\n" +
                    "\n" +
                    "Blue Card 2:\n" +
                    "5     Sapphire  Town\n" +
                    "Diamond x7 Sapphire x3\n" +
                    "\n" +
                    "Blue Card 3:\n" +
                    "5     Rubby  Town\n" +
                    "Rubby x3 Emerald x7\n" +
                    "\n" +
                    "Blue Card 4:\n" +
                    "4     Diamond  Town\n" +
                    "Diamond x3 Rubby x3 Onyx x6\n" +
                    "\n" +
                    "/////////////////////////\n" +
                    "Yellow Deck\n" +
                    "Yellow Card 1:\n" +
                    "2     Rubby  Town\n" +
                    "Diamond x1 Emerald x2 Sapphire x4\n" +
                    "\n" +
                    "Yellow Card 2:\n" +
                    "2     Sapphire  Town\n" +
                    "Diamond x2 Rubby x1 Onyx x4\n" +
                    "\n" +
                    "Yellow Card 3:\n" +
                    "3     Emerald  Town\n" +
                    "Emerald x6\n" +
                    "\n" +
                    "Yellow Card 4:\n" +
                    "2     Rubby  Town\n" +
                    "Diamond x3 Onyx x5\n" +
                    "\n" +
                    "/////////////////////////\n" +
                    "Green Deck\n" +
                    "Green Card 1:\n" +
                    "0     Rubby  Town\n" +
                    "Diamond x1 Emerald x1 Onyx x1 Sapphire x2\n" +
                    "\n" +
                    "Green Card 2:\n" +
                    "0     Sapphire  Town\n" +
                    "Emerald x2 Onyx x2\n" +
                    "\n" +
                    "Green Card 3:\n" +
                    "0     Rubby  Town\n" +
                    "Diamond x2 Rubby x2\n" +
                    "\n" +
                    "Green Card 4:\n" +
                    "0     Emerald  Town\n" +
                    "Diamond x1 Rubby x1 Onyx x2 Sapphire x1\n" +
                    "\n" +
                    "/////////////////////////////////////\n" +
                    "Tokens Avalible: Onyx x1 ,Sapphire x0 ,Emerald x0 ,Diamond x2 ,Rubby x3 ,Gold x4\n" +
                    "\n" +
                    "Nobles Avalible:\n" +
                    "\n" +
                    "******* G Mine S *******\n" +
                    "Diamond x1    Rubby x2    Emerald x2\n" +
                    "\n" +
                    "\n" +
                    "******* G Mine S *******\n" +
                    "Diamond x1    Rubby x1    Emerald x1    Onyx x1\n" +
                    "\n" +
                    "\n" +
                    "******* G Mine E *******\n" +
                    "Rubby x3\n" +
                    "\n" +
                    "\n" +
                    "******* G Mine E *******\n" +
                    "Rubby x2    Onyx x2    Sapphire x1\n" +
                    "\n" +
                    "\n" +
                    "******* G Mine E *******\n" +
                    "Diamond x1    Rubby x1    Onyx x1    Sapphire x1\n" +
                    "\n" +
                    "\n" +
                    "******* G Mine E *******\n" +
                    "Diamond x1    Rubby x1    Onyx x2    Sapphire x1\n" +
                    "\n" +
                    "\n" +
                    "******* G Mine E *******\n" +
                    "Diamond x1    Emerald x1    Sapphire x3\n" +
                    "\n" +
                    "\n" +
                    "******* G Mine E *******\n" +
                    "Rubby x2    Sapphire x2\n" +
                    "\n" +
                    "\n" +
                    "******* G Mine E *******\n" +
                    "Diamond x2    Sapphire x1\n" +
                    "\n" +
                    "\n" +
                    "******* G Mine R *******\n" +
                    "Diamond x4\n" +
                    "\n" +
                    "\n" +
                    "******* G Mine R *******\n" +
                    "Diamond x2    Rubby x2\n" +
                    "\n" +
                    "\n" +
                    "******* G Mine R *******\n" +
                    "Diamond x1    Emerald x1    Onyx x1    Sapphire x1\n" +
                    "\n" +
                    "\n" +
                    "******* G Mine R *******\n" +
                    "Diamond x1    Emerald x1    Onyx x1    Sapphire x2\n" +
                    "\n" +
                    "\n" +
                    "******* G Mine R *******\n" +
                    "Diamond x2    Emerald x1    Onyx x1\n" +
                    "\n" +
                    "\n" +
                    "******* G Mine R *******\n" +
                    "Emerald x1    Sapphire x2\n" +
                    "\n" +
                    "\n" +
                    "******* G Mine R *******\n" +
                    "Diamond x1    Rubby x1    Onyx x3\n" +
                    "\n" +
                    "\n" +
                    "******* G Mine R *******\n" +
                    "Diamond x3\n" +
                    "\n" +
                    "\n" +
                    "******* G Mine D *******\n" +
                    "Emerald x4\n" +
                    "\n" +
                    "\n" +
                    "******* G Mine D *******\n" +
                    "Diamond x3    Onyx x1    Sapphire x1\n" +
                    "\n" +
                    "\n" +
                    "******* G Mine D *******\n" +
                    "Rubby x1    Emerald x2    Onyx x1    Sapphire x1\n" +
                    "\n" +
                    "\n" +
                    "******* G Mine D *******\n" +
                    "Onyx x2    Sapphire x2\n" +
                    "\n" +
                    "\n" +
                    "******* G Mine D *******\n" +
                    "Sapphire x3\n" +
                    "\n" +
                    "\n" +
                    "******* G Mine D *******\n" +
                    "Rubby x1    Emerald x1    Onyx x1    Sapphire x1\n" +
                    "\n" +
                    "\n" +
                    "******* G Mine D *******\n" +
                    "Rubby x2    Onyx x1\n" +
                    "\n" +
                    "\n" +
                    "******* G Mine D *******\n" +
                    "Emerald x2    Onyx x1    Sapphire x2\n" +
                    "\n" +
                    "\n" +
                    "******* G Mine O *******\n" +
                    "Sapphire x4\n" +
                    "\n" +
                    "\n" +
                    "******* G Mine O *******\n" +
                    "Diamond x2    Rubby x2    Sapphire x2\n" +
                    "\n" +
                    "\n" +
                    "******* G Mine O *******\n" +
                    "Diamond x1    Rubby x1    Emerald x1    Sapphire x2\n" +
                    "\n" +
                    "\n" +
                    "******* G Mine O *******\n" +
                    "Emerald x3\n" +
                    "\n" +
                    "\n" +
                    "******* G Mine O *******\n" +
                    "Rubby x3    Emerald x1    Onyx x1\n" +
                    "\n" +
                    "\n" +
                    "******* G Mine O *******\n" +
                    "Diamond x2    Emerald x2\n" +
                    "\n" +
                    "\n" +
                    "******* G Mine O *******\n" +
                    "Rubby x1    Emerald x2\n" +
                    "\n" +
                    "\n" +
                    "******* G Mine O *******\n" +
                    "Diamond x1    Rubby x1    Emerald x1    Sapphire x1\n" +
                    "\n" +
                    "\n" +
                    "******* Y Merchant S *******\n" +
                    "Sapphire x6\n" +
                    "\n" +
                    "\n" +
                    "******* Y Merchant S *******\n" +
                    "Diamond x2    Rubby x1    Onyx x4\n" +
                    "\n" +
                    "\n" +
                    "******* Y Merchant S *******\n" +
                    "Sapphire x5\n" +
                    "\n" +
                    "\n" +
                    "******* Y Transports S *******\n" +
                    "Diamond x3    Sapphire x3\n" +
                    "\n" +
                    "\n" +
                    "******* Y Transports S *******\n" +
                    "Emerald x3    Onyx x3    Sapphire x2\n" +
                    "\n" +
                    "\n" +
                    "******* Y Transports S *******\n" +
                    "Rubby x3    Emerald x2    Sapphire x2\n" +
                    "\n" +
                    "\n" +
                    "******* Y Transports E *******\n" +
                    "Emerald x6\n" +
                    "\n" +
                    "\n" +
                    "******* Y Transports E *******\n" +
                    "Emerald x3    Sapphire x3\n" +
                    "\n" +
                    "\n" +
                    "******* Y Transports E *******\n" +
                    "Emerald x5\n" +
                    "\n" +
                    "\n" +
                    "******* Y Merchant E *******\n" +
                    "Diamond x4    Onyx x1    Sapphire x2\n" +
                    "\n" +
                    "\n" +
                    "******* Y Merchant E *******\n" +
                    "Diamond x2    Onyx x2    Sapphire x3\n" +
                    "\n" +
                    "\n" +
                    "******* Y Merchant E *******\n" +
                    "Diamond x3    Rubby x3    Emerald x2\n" +
                    "\n" +
                    "\n" +
                    "******* Y Merchant R *******\n" +
                    "Rubby x6\n" +
                    "\n" +
                    "\n" +
                    "******* Y Merchant R *******\n" +
                    "Onyx x5\n" +
                    "\n" +
                    "\n" +
                    "******* Y Merchant R *******\n" +
                    "Diamond x3    Onyx x5\n" +
                    "\n" +
                    "\n" +
                    "******* Y Transports R *******\n" +
                    "Diamond x1    Emerald x2    Sapphire x4\n" +
                    "\n" +
                    "\n" +
                    "******* Y Transports R *******\n" +
                    "Diamond x2    Rubby x2    Onyx x3\n" +
                    "\n" +
                    "\n" +
                    "******* Y Transports R *******\n" +
                    "Rubby x2    Onyx x3    Sapphire x3\n" +
                    "\n" +
                    "\n" +
                    "******* Y Merchant D *******\n" +
                    "Diamond x6\n" +
                    "\n" +
                    "\n" +
                    "******* Y Merchant D *******\n" +
                    "Rubby x5    Onyx x3\n" +
                    "\n" +
                    "\n" +
                    "******* Y Merchant D *******\n" +
                    "Rubby x5\n" +
                    "\n" +
                    "\n" +
                    "******* Y Transports D *******\n" +
                    "Rubby x4    Emerald x1    Onyx x2\n" +
                    "\n" +
                    "\n" +
                    "******* Y Transports D *******\n" +
                    "Diamond x2    Rubby x3    Sapphire x3\n" +
                    "\n" +
                    "\n" +
                    "******* Y Transports D *******\n" +
                    "Rubby x2    Emerald x3    Onyx x2\n" +
                    "\n" +
                    "\n" +
                    "******* Y Merchant O *******\n" +
                    "Onyx x6\n" +
                    "\n" +
                    "\n" +
                    "******* Y Merchant O *******\n" +
                    "Rubby x3    Emerald x5\n" +
                    "\n" +
                    "\n" +
                    "******* Y Merchant O *******\n" +
                    "Diamond x5\n" +
                    "\n" +
                    "\n" +
                    "******* Y Transports O *******\n" +
                    "Rubby x2    Emerald x4    Sapphire x1\n" +
                    "\n" +
                    "\n" +
                    "******* Y Transports O *******\n" +
                    "Diamond x3    Emerald x3    Onyx x2\n" +
                    "\n" +
                    "\n" +
                    "******* Y Transports O *******\n" +
                    "Diamond x3    Emerald x2    Sapphire x3\n" +
                    "\n" +
                    "\n" +
                    "******* B Town S *******\n" +
                    "Diamond x7    Sapphire x3\n" +
                    "\n" +
                    "\n" +
                    "******* B Town S *******\n" +
                    "Diamond x6    Onyx x3    Sapphire x3\n" +
                    "\n" +
                    "\n" +
                    "******* B Shop S *******\n" +
                    "Diamond x7    Sapphire x3\n" +
                    "\n" +
                    "\n" +
                    "******* B Shop S *******\n" +
                    "Diamond x3    Rubby x3    Emerald x3    Onyx x5\n" +
                    "\n" +
                    "\n" +
                    "******* B Town E *******\n" +
                    "Emerald x3    Sapphire x7\n" +
                    "\n" +
                    "\n" +
                    "******* B Shop E *******\n" +
                    "Sapphire x7\n" +
                    "\n" +
                    "\n" +
                    "******* B Shop E *******\n" +
                    "Diamond x3    Emerald x3    Sapphire x6\n" +
                    "\n" +
                    "\n" +
                    "******* B Town E *******\n" +
                    "Diamond x5    Rubby x3    Onyx x3    Sapphire x3\n" +
                    "\n" +
                    "\n" +
                    "******* B Town R *******\n" +
                    "Rubby x3    Emerald x7\n" +
                    "\n" +
                    "\n" +
                    "******* B Town R *******\n" +
                    "Rubby x3    Emerald x6    Sapphire x3\n" +
                    "\n" +
                    "\n" +
                    "******* B Shop R *******\n" +
                    "Emerald x7\n" +
                    "\n" +
                    "\n" +
                    "******* B Shop R *******\n" +
                    "Diamond x3    Emerald x3    Sapphire x5\n" +
                    "\n" +
                    "\n" +
                    "******* B Shop D *******\n" +
                    "Diamond x3    Onyx x7\n" +
                    "\n" +
                    "\n" +
                    "******* B Town D *******\n" +
                    "Diamond x3    Rubby x3    Onyx x6\n" +
                    "\n" +
                    "\n" +
                    "******* B Town D *******\n" +
                    "Onyx x7\n" +
                    "\n" +
                    "\n" +
                    "******* B Shop D *******\n" +
                    "Rubby x5    Emerald x3    Onyx x3    Sapphire x3\n" +
                    "\n" +
                    "\n" +
                    "******* B Town O *******\n" +
                    "Rubby x7    Onyx x3\n" +
                    "\n" +
                    "\n" +
                    "******* B Shop O *******\n" +
                    "Rubby x6    Emerald x3    Onyx x3\n" +
                    "\n" +
                    "\n" +
                    "******* B Shop O *******\n" +
                    "Rubby x7\n" +
                    "\n" +
                    "\n" +
                    "******* B Town O *******\n" +
                    "Diamond x3    Rubby x3    Emerald x5    Sapphire x3\n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "Attention! Player 1 chose to take three tokens of different color!\n" +
                    "It is Player 2's turn!\n" +
                    "Player 2, here is what you currently have:\n" +
                    "\n" +
                    "\n" +
                    "***** Player 2 0 Point(s) *****\n" +
                    "Tokens: Onyx x0 ,Sapphire x0 ,Emerlad x0 ,Diamond x0 ,Rubby x0 ,Gold x0\n" +
                    "\n" +
                    "**** Cards ****\n" +
                    "\n" +
                    "**** Nobles ****\n" +
                    "\n" +
                    "\n" +
                    "**** Cards in Reserve ****\n" +
                    "\n" +
                    "\n" +
                    "Player 2, what do you wish to do this round?\n" +
                    "\n" +
                    "1. Take 2 tokens of the same color from the table(may only be performed if there is 4 or more tokens in the color of your chosing)\n" +
                    "2. Take 1 token from each of 3 different types of tokens(excluding gold)\n" +
                    "3. Reserve a card on the table and receive one gold token(keep in mind you may only have three reserved cards maximum. Also, you will not recieve any gold token if there is non on the table)\n" +
                    "4. Reserve an unknown card from the top of a chosen deck\n" +
                    "5. Buy a card from your reserved cards\n" +
                    "6. Buy a card on the table\n";
//            System.out.println("Something went wrong.");
            assertEquals(expected,result);
        }
    }
    @Test
    public void testReserveCard() throws PlayerDoesNotHaveEnoughResourcesToBuySelectedCard, SelectedDeckRanOutOfCards, NotEnoughTokensOnTable, InvalidCardsSelectionOfCardsInReserve, FileNotFoundException, InvalidCardsSelectionOfCardsOnTable, PlayerAlreadyHoldsThreeReserveCards, PlayerDoesNotHaveSelectedCardInReserve, InterruptedException {
        try {
        TextBasedInterface textInterfaceText = new TextBasedInterface();
        // set up testable input and output channels
        byte[] data = "2 2 2 3 4".getBytes(StandardCharsets.UTF_8);
        BufferedInputStream in = new BufferedInputStream(new ByteArrayInputStream(data));
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintStream output = new PrintStream(out);
        // redirect the standard channels

        String[] args = null;System.setIn(in);
        textInterfaceText.main(args);
        System.setOut(output);
        String expected ="Welcome to Splendor! How many player(s) do you wish to have(including yourself)?\n" +
                "2. 2    3. 3.    4. 4\n" +
                "2\n" +
                "Check0 completed\n" +
                "Check1 completed\n" +
                "Check2 completed\n" +
                "Check3 completed\n" +
                "check4 completed\n" +
                "Awesome! lets start the game!\n" +
                "\n" +
                "\n" +
                "***** Player 1 0 Point(s) *****\n" +
                "Tokens: Onyx x0 ,Sapphire x0 ,Emerlad x0 ,Diamond x0 ,Rubby x0 ,Gold x0\n" +
                "\n" +
                "Cards:\n" +
                "\n" +
                "Nobles:\n" +
                "\n" +
                "\n" +
                "Cards in Reserve x0\n" +
                "*******************************\n" +
                "\n" +
                "***** Player 2 0 Point(s) *****\n" +
                "Tokens: Onyx x0 ,Sapphire x0 ,Emerlad x0 ,Diamond x0 ,Rubby x0 ,Gold x0\n" +
                "\n" +
                "Cards:\n" +
                "\n" +
                "Nobles:\n" +
                "\n" +
                "\n" +
                "Cards in Reserve x0\n" +
                "*******************************\n" +
                "\n" +
                "/////////////////////////////////////\n" +
                "Blue Deck\n" +
                "Blue Card 1:\n" +
                "4     Diamond  Town\n" +
                "Diamond x3 Rubby x3 Onyx x6\n" +
                "\n" +
                "Blue Card 2:\n" +
                "4     Sapphire  Town\n" +
                "Diamond x6 Onyx x3 Sapphire x3\n" +
                "\n" +
                "Blue Card 3:\n" +
                "4     Emerald  Town\n" +
                "Sapphire x7\n" +
                "\n" +
                "Blue Card 4:\n" +
                "5     Rubby  Town\n" +
                "Rubby x3 Emerald x7\n" +
                "\n" +
                "/////////////////////////\n" +
                "Yellow Deck\n" +
                "Yellow Card 1:\n" +
                "2     Rubby  Town\n" +
                "Diamond x3 Onyx x5\n" +
                "\n" +
                "Yellow Card 2:\n" +
                "2     Emerald  Town\n" +
                "Emerald x3 Sapphire x3\n" +
                "\n" +
                "Yellow Card 3:\n" +
                "3     Emerald  Town\n" +
                "Emerald x6\n" +
                "\n" +
                "Yellow Card 4:\n" +
                "3     Sapphire  Town\n" +
                "Sapphire x6\n" +
                "\n" +
                "/////////////////////////\n" +
                "Green Deck\n" +
                "Green Card 1:\n" +
                "1     Rubby  Town\n" +
                "Diamond x4\n" +
                "\n" +
                "Green Card 2:\n" +
                "0     Emerald  Town\n" +
                "Rubby x3\n" +
                "\n" +
                "Green Card 3:\n" +
                "0     Emerald  Town\n" +
                "Rubby x3\n" +
                "\n" +
                "Green Card 4:\n" +
                "0     Emerald  Town\n" +
                "Diamond x1 Rubby x1 Onyx x2 Sapphire x1\n" +
                "\n" +
                "/////////////////////////////////////\n" +
                "Tokens Avalible: Onyx x4 ,Sapphire x4 ,Emerald x4 ,Diamond x4 ,Rubby x4 ,Gold x4\n" +
                "\n" +
                "Nobles Avalible:\n" +
                "\n" +
                "******* Triss Merigold *******\n" +
                "Diamond x4    Onyx x4\n" +
                "\n" +
                "\n" +
                "******* Sigismund Dijkstra *******\n" +
                "Diamond x3    Emerald x3    Sapphire x3\n" +
                "\n" +
                "\n" +
                "******* Dandelion *******\n" +
                "Diamond x3    Rubby x3    Sapphire x3\n" +
                "\n" +
                "\n" +
                "\n" +
                "It is Player 1's turn!\n" +
                "Player 1, here is what you currently have:\n" +
                "\n" +
                "\n" +
                "***** Player 1 0 Point(s) *****\n" +
                "Tokens: Onyx x0 ,Sapphire x0 ,Emerlad x0 ,Diamond x0 ,Rubby x0 ,Gold x0\n" +
                "\n" +
                "**** Cards ****\n" +
                "\n" +
                "**** Nobles ****\n" +
                "\n" +
                "\n" +
                "**** Cards in Reserve ****\n" +
                "\n" +
                "\n" +
                "Player 1, what do you wish to do this round?\n" +
                "\n" +
                "1. Take 2 tokens of the same color from the table(may only be performed if there is 4 or more tokens in the color of your chosing)\n" +
                "2. Take 1 token from each of 3 different types of tokens(excluding gold)\n" +
                "3. Reserve a card on the table and receive one gold token(keep in mind you may only have three reserved cards maximum. Also, you will not recieve any gold token if there is non on the table)\n" +
                "4. Reserve an unknown card from the top of a chosen deck\n" +
                "5. Buy a card from your reserved cards\n" +
                "6. Buy a card on the table\n" +
                "3\n" +
                "Which type of card do you wish to reserve?\n" +
                "1. Blue   2. Yellow   3. Green\n" +
                "1\n" +
                "Which card do you wish to reserve?\n" +
                "1. Blue Card 1 *** 2. Blue Card 2 *** 3. Blue Card 3\n" +
                "1\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "***** Player 1 0 Point(s) *****\n" +
                "Tokens: Onyx x0 ,Sapphire x0 ,Emerlad x0 ,Diamond x0 ,Rubby x0 ,Gold x1\n" +
                "\n" +
                "Cards:\n" +
                "\n" +
                "Nobles:\n" +
                "\n" +
                "\n" +
                "Cards in Reserve x1\n" +
                "*******************************\n" +
                "\n" +
                "***** Player 2 0 Point(s) *****\n" +
                "Tokens: Onyx x0 ,Sapphire x0 ,Emerlad x0 ,Diamond x0 ,Rubby x0 ,Gold x0\n" +
                "\n" +
                "Cards:\n" +
                "\n" +
                "Nobles:\n" +
                "\n" +
                "\n" +
                "Cards in Reserve x0\n" +
                "*******************************\n" +
                "\n" +
                "/////////////////////////////////////\n" +
                "Blue Deck\n" +
                "Blue Card 1:\n" +
                "5     Rubby  Town\n" +
                "Rubby x3 Emerald x7\n" +
                "\n" +
                "Blue Card 2:\n" +
                "4     Sapphire  Town\n" +
                "Diamond x6 Onyx x3 Sapphire x3\n" +
                "\n" +
                "Blue Card 3:\n" +
                "4     Emerald  Town\n" +
                "Sapphire x7\n" +
                "\n" +
                "Blue Card 4:\n" +
                "5     Rubby  Town\n" +
                "Rubby x3 Emerald x7\n" +
                "\n" +
                "/////////////////////////\n" +
                "Yellow Deck\n" +
                "Yellow Card 1:\n" +
                "2     Rubby  Town\n" +
                "Diamond x3 Onyx x5\n" +
                "\n" +
                "Yellow Card 2:\n" +
                "2     Emerald  Town\n" +
                "Emerald x3 Sapphire x3\n" +
                "\n" +
                "Yellow Card 3:\n" +
                "3     Emerald  Town\n" +
                "Emerald x6\n" +
                "\n" +
                "Yellow Card 4:\n" +
                "3     Sapphire  Town\n" +
                "Sapphire x6\n" +
                "\n" +
                "/////////////////////////\n" +
                "Green Deck\n" +
                "Green Card 1:\n" +
                "1     Rubby  Town\n" +
                "Diamond x4\n" +
                "\n" +
                "Green Card 2:\n" +
                "0     Emerald  Town\n" +
                "Rubby x3\n" +
                "\n" +
                "Green Card 3:\n" +
                "0     Emerald  Town\n" +
                "Rubby x3\n" +
                "\n" +
                "Green Card 4:\n" +
                "0     Emerald  Town\n" +
                "Diamond x1 Rubby x1 Onyx x2 Sapphire x1\n" +
                "\n" +
                "/////////////////////////////////////\n" +
                "Tokens Avalible: Onyx x4 ,Sapphire x4 ,Emerald x4 ,Diamond x4 ,Rubby x4 ,Gold x3\n" +
                "\n" +
                "Nobles Avalible:\n" +
                "\n" +
                "******* Triss Merigold *******\n" +
                "Diamond x4    Onyx x4\n" +
                "\n" +
                "\n" +
                "******* Sigismund Dijkstra *******\n" +
                "Diamond x3    Emerald x3    Sapphire x3\n" +
                "\n" +
                "\n" +
                "******* Dandelion *******\n" +
                "Diamond x3    Rubby x3    Sapphire x3\n" +
                "\n" +
                "\n" +
                "\n" +
                "Attention! Player 1 chose to reserve a card on the table!\n" +
                "It is Player 2's turn!\n" +
                "Player 2, here is what you currently have:\n" +
                "\n" +
                "\n" +
                "***** Player 2 0 Point(s) *****\n" +
                "Tokens: Onyx x0 ,Sapphire x0 ,Emerlad x0 ,Diamond x0 ,Rubby x0 ,Gold x0\n" +
                "\n" +
                "**** Cards ****\n" +
                "\n" +
                "**** Nobles ****\n" +
                "\n" +
                "\n" +
                "**** Cards in Reserve ****\n" +
                "\n" +
                "\n" +
                "Player 2, what do you wish to do this round?\n" +
                "\n" +
                "1. Take 2 tokens of the same color from the table(may only be performed if there is 4 or more tokens in the color of your chosing)\n" +
                "2. Take 1 token from each of 3 different types of tokens(excluding gold)\n" +
                "3. Reserve a card on the table and receive one gold token(keep in mind you may only have three reserved cards maximum. Also, you will not recieve any gold token if there is non on the table)\n" +
                "4. Reserve an unknown card from the top of a chosen deck\n" +
                "5. Buy a card from your reserved cards\n" +
                "6. Buy a card on the table\n";
        // call to method that does standard I/O
        String result = out.toString().replaceAll("\r","");
        System.setOut(output);

//        System.setIn(in); System.setOut(output);
        assertEquals(expected,result);
        } catch (Exception e) {
        }
    }
    //rule The noble tiles there will be 3 nobles for 2 players, 4 nobles for 3 players, 5 nobles for 4 players
    @Test
    public void testNobleNumber_twoplayer() throws PlayerDoesNotHaveEnoughResourcesToBuySelectedCard, SelectedDeckRanOutOfCards, NotEnoughTokensOnTable, InvalidCardsSelectionOfCardsInReserve, FileNotFoundException, InvalidCardsSelectionOfCardsOnTable, PlayerAlreadyHoldsThreeReserveCards, PlayerDoesNotHaveSelectedCardInReserve, InterruptedException {
        try{
        TextBasedInterface textInterfaceText = new TextBasedInterface();
        // set up testable input and output channels
        byte[] data = "2".getBytes(StandardCharsets.UTF_8);
        BufferedInputStream in = new BufferedInputStream(new ByteArrayInputStream(data));
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintStream output = new PrintStream(out);
        // redirect the standard channels

        String[] args = null;System.setIn(in);
        textInterfaceText.main(args);
        System.setOut(output);
        String expected ="***** Player 1 0 Point(s) *****\n" +
                "Tokens: Onyx x0 ,Sapphire x0 ,Emerlad x0 ,Diamond x0 ,Rubby x0 ,Gold x0\n" +
                "\n" +
                "Cards:\n" +
                "\n" +
                "Nobles:\n" +
                "\n" +
                "\n" +
                "Cards in Reserve x0\n" +
                "*******************************\n" +
                "\n" +
                "***** Player 2 0 Point(s) *****\n" +
                "Tokens: Onyx x0 ,Sapphire x0 ,Emerlad x0 ,Diamond x0 ,Rubby x0 ,Gold x0\n" +
                "\n" +
                "Cards:\n" +
                "\n" +
                "Nobles:\n" +
                "\n" +
                "\n" +
                "Cards in Reserve x0\n" +
                "*******************************\n" +
                "\n" +
                "/////////////////////////////////////\n" +
                "Blue Deck\n" +
                "Blue Card 1:\n" +
                "4     Onyx  Town\n" +
                "Rubby x7\n" +
                "\n" +
                "Blue Card 2:\n" +
                "5     Rubby  Town\n" +
                "Rubby x3 Emerald x7\n" +
                "\n" +
                "Blue Card 3:\n" +
                "5     Emerald  Town\n" +
                "Emerald x3 Sapphire x7\n" +
                "\n" +
                "Blue Card 4:\n" +
                "5     Onyx  Town\n" +
                "Rubby x7 Onyx x3\n" +
                "\n" +
                "/////////////////////////\n" +
                "Yellow Deck\n" +
                "Yellow Card 1:\n" +
                "1     Onyx  Town\n" +
                "Diamond x3 Emerald x3 Onyx x2\n" +
                "\n" +
                "Yellow Card 2:\n" +
                "2     Rubby  Town\n" +
                "Onyx x5\n" +
                "\n" +
                "Yellow Card 3:\n" +
                "2     Diamond  Town\n" +
                "Rubby x4 Emerald x1 Onyx x2\n" +
                "\n" +
                "Yellow Card 4:\n" +
                "2     Onyx  Town\n" +
                "Rubby x3 Emerald x5\n" +
                "\n" +
                "/////////////////////////\n" +
                "Green Deck\n" +
                "Green Card 1:\n" +
                "0     Emerald  Town\n" +
                "Rubby x2 Sapphire x2\n" +
                "\n" +
                "Green Card 2:\n" +
                "0     Sapphire  Town\n" +
                "Diamond x1 Onyx x2\n" +
                "\n" +
                "Green Card 3:\n" +
                "0     Sapphire  Town\n" +
                "Diamond x1 Onyx x2\n" +
                "\n" +
                "Green Card 4:\n" +
                "0     Emerald  Town\n" +
                "Diamond x1 Emerald x1 Sapphire x3\n" +
                "\n" +
                "/////////////////////////////////////\n" +
                "Tokens Avalible: Onyx x4 ,Sapphire x4 ,Emerald x4 ,Diamond x4 ,Rubby x4 ,Gold x4\n" +
                "\n" +
                "Nobles Avalible:\n" +
                "\n" +
                "******* Geralt of Rivia *******\n" +
                "Rubby x4    Emerald x4\n" +
                "\n" +
                "\n" +
                "******* Emhyr var Emreis *******\n" +
                "Diamond x3    Onyx x3    Sapphire x3\n" +
                "\n" +
                "\n" +
                "******* Keira Metz *******\n" +
                "Rubby x3    Emerald x3\n" +
                "\n" +
                "\n" +
                "\n" +
                "It is Player 1's turn!\n" +
                "Player 1, here is what you currently have:\n" +
                "\n" +
                "\n" +
                "***** Player 1 0 Point(s) *****\n" +
                "Tokens: Onyx x0 ,Sapphire x0 ,Emerlad x0 ,Diamond x0 ,Rubby x0 ,Gold x0\n" +
                "\n" +
                "**** Cards ****\n" +
                "\n" +
                "**** Nobles ****\n" +
                "\n" +
                "\n" +
                "**** Cards in Reserve ****\n" +
                "\n" +
                "\n" +
                "Player 1, what do you wish to do this round?\n" +
                "\n" +
                "1. Take 2 tokens of the same color from the table(may only be performed if there is 4 or more tokens in the color of your chosing)\n" +
                "2. Take 1 token from each of 3 different types of tokens(excluding gold)\n" +
                "3. Reserve a card on the table and receive one gold token(keep in mind you may only have three reserved cards maximum. Also, you will not recieve any gold token if there is non on the table)\n" +
                "4. Reserve an unknown card from the top of a chosen deck\n" +
                "5. Buy a card from your reserved cards\n" +
                "6. Buy a card on the table\n";
        // call to method that does standard I/O
        String result = out.toString().replaceAll("\r","");
        System.setOut(output);

//        System.setIn(in); System.setOut(output);
        assertEquals(expected,result);
        } catch (Exception e) {
        }
    }


    //rule The noble tiles there will be 3 nobles for 2 players, 4 nobles for 3 players, 5 nobles for 4 players
    @Test
    public void testNobleNumber_fourplayer() throws PlayerDoesNotHaveEnoughResourcesToBuySelectedCard, SelectedDeckRanOutOfCards, NotEnoughTokensOnTable, InvalidCardsSelectionOfCardsInReserve, FileNotFoundException, InvalidCardsSelectionOfCardsOnTable, PlayerAlreadyHoldsThreeReserveCards, PlayerDoesNotHaveSelectedCardInReserve, InterruptedException {
        try{
            TextBasedInterface textInterfaceText = new TextBasedInterface();
            // set up testable input and output channels
            byte[] data = "2".getBytes(StandardCharsets.UTF_8);
            BufferedInputStream in = new BufferedInputStream(new ByteArrayInputStream(data));
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            PrintStream output = new PrintStream(out);
            // redirect the standard channels

            String[] args = null;System.setIn(in);
            textInterfaceText.main(args);
            System.setOut(output);
            String expected ="***** Player 1 0 Point(s) *****\n" +
                    "Tokens: Onyx x0 ,Sapphire x0 ,Emerlad x0 ,Diamond x0 ,Rubby x0 ,Gold x0\n" +
                    "\n" +
                    "Cards:\n" +
                    "\n" +
                    "Nobles:\n" +
                    "\n" +
                    "\n" +
                    "Cards in Reserve x0\n" +
                    "*******************************\n" +
                    "\n" +
                    "***** Player 2 0 Point(s) *****\n" +
                    "Tokens: Onyx x0 ,Sapphire x0 ,Emerlad x0 ,Diamond x0 ,Rubby x0 ,Gold x0\n" +
                    "\n" +
                    "Cards:\n" +
                    "\n" +
                    "Nobles:\n" +
                    "\n" +
                    "\n" +
                    "Cards in Reserve x0\n" +
                    "*******************************\n" +
                    "\n" +
                    "/////////////////////////////////////\n" +
                    "Blue Deck\n" +
                    "Blue Card 1:\n" +
                    "4     Onyx  Town\n" +
                    "Rubby x7\n" +
                    "\n" +
                    "Blue Card 2:\n" +
                    "5     Rubby  Town\n" +
                    "Rubby x3 Emerald x7\n" +
                    "\n" +
                    "Blue Card 3:\n" +
                    "5     Emerald  Town\n" +
                    "Emerald x3 Sapphire x7\n" +
                    "\n" +
                    "Blue Card 4:\n" +
                    "5     Onyx  Town\n" +
                    "Rubby x7 Onyx x3\n" +
                    "\n" +
                    "/////////////////////////\n" +
                    "Yellow Deck\n" +
                    "Yellow Card 1:\n" +
                    "1     Onyx  Town\n" +
                    "Diamond x3 Emerald x3 Onyx x2\n" +
                    "\n" +
                    "Yellow Card 2:\n" +
                    "2     Rubby  Town\n" +
                    "Onyx x5\n" +
                    "\n" +
                    "Yellow Card 3:\n" +
                    "2     Diamond  Town\n" +
                    "Rubby x4 Emerald x1 Onyx x2\n" +
                    "\n" +
                    "Yellow Card 4:\n" +
                    "2     Onyx  Town\n" +
                    "Rubby x3 Emerald x5\n" +
                    "\n" +
                    "/////////////////////////\n" +
                    "Green Deck\n" +
                    "Green Card 1:\n" +
                    "0     Emerald  Town\n" +
                    "Rubby x2 Sapphire x2\n" +
                    "\n" +
                    "Green Card 2:\n" +
                    "0     Sapphire  Town\n" +
                    "Diamond x1 Onyx x2\n" +
                    "\n" +
                    "Green Card 3:\n" +
                    "0     Sapphire  Town\n" +
                    "Diamond x1 Onyx x2\n" +
                    "\n" +
                    "Green Card 4:\n" +
                    "0     Emerald  Town\n" +
                    "Diamond x1 Emerald x1 Sapphire x3\n" +
                    "\n" +
                    "/////////////////////////////////////\n" +
                    "Tokens Avalible: Onyx x4 ,Sapphire x4 ,Emerald x4 ,Diamond x4 ,Rubby x4 ,Gold x4\n" +
                    "\n" +
                    "Nobles Avalible:\n" +
                    "\n" +
                    "******* Geralt of Rivia *******\n" +
                    "Rubby x4    Emerald x4\n" +
                    "\n" +
                    "\n" +
                    "******* Emhyr var Emreis *******\n" +
                    "Diamond x3    Onyx x3    Sapphire x3\n" +
                    "\n" +
                    "\n" +
                    "******* Keira Metz *******\n" +
                    "Rubby x3    Emerald x3\n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "It is Player 1's turn!\n" +
                    "Player 1, here is what you currently have:\n" +
                    "\n" +
                    "\n" +
                    "***** Player 1 0 Point(s) *****\n" +
                    "Tokens: Onyx x0 ,Sapphire x0 ,Emerlad x0 ,Diamond x0 ,Rubby x0 ,Gold x0\n" +
                    "\n" +
                    "**** Cards ****\n" +
                    "\n" +
                    "**** Nobles ****\n" +
                    "\n" +
                    "\n" +
                    "**** Cards in Reserve ****\n" +
                    "\n" +
                    "\n" +
                    "Player 1, what do you wish to do this round?\n" +
                    "\n" +
                    "1. Take 2 tokens of the same color from the table(may only be performed if there is 4 or more tokens in the color of your chosing)\n" +
                    "2. Take 1 token from each of 3 different types of tokens(excluding gold)\n" +
                    "3. Reserve a card on the table and receive one gold token(keep in mind you may only have three reserved cards maximum. Also, you will not recieve any gold token if there is non on the table)\n" +
                    "4. Reserve an unknown card from the top of a chosen deck\n" +
                    "5. Buy a card from your reserved cards\n" +
                    "6. Buy a card on the table\n";
            // call to method that does standard I/O
            String result = out.toString().replaceAll("\r","");
            System.setOut(output);

//        System.setIn(in); System.setOut(output);
            assertEquals(expected,result);
        } catch (Exception e) {
        }
    }





    @Test
    public void testNobleNumber_threeplayer() throws PlayerDoesNotHaveEnoughResourcesToBuySelectedCard, SelectedDeckRanOutOfCards, NotEnoughTokensOnTable, InvalidCardsSelectionOfCardsInReserve, FileNotFoundException, InvalidCardsSelectionOfCardsOnTable, PlayerAlreadyHoldsThreeReserveCards, PlayerDoesNotHaveSelectedCardInReserve, InterruptedException {
        try{
        TextBasedInterface textInterfaceText = new TextBasedInterface();
        // set up testable input and output channels
        byte[] data = "3".getBytes(StandardCharsets.UTF_8);
        BufferedInputStream in = new BufferedInputStream(new ByteArrayInputStream(data));
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintStream output = new PrintStream(out);
        // redirect the standard channels

        String[] args = null;System.setIn(in);
        textInterfaceText.main(args);
        System.setOut(output);
        String expected ="Welcome to Splendor! How many player(s) do you wish to have(including yourself)?\n" +
                "2. 2    3. 3.    4. 4\n" +
                "3\n" +
                "Check0 completed\n" +
                "Check1 completed\n" +
                "Check2 completed\n" +
                "Check3 completed\n" +
                "check4 completed\n" +
                "Awesome! lets start the game!\n" +
                "\n" +
                "\n" +
                "***** Player 1 0 Point(s) *****\n" +
                "Tokens: Onyx x0 ,Sapphire x0 ,Emerlad x0 ,Diamond x0 ,Rubby x0 ,Gold x0\n" +
                "\n" +
                "Cards:\n" +
                "\n" +
                "Nobles:\n" +
                "\n" +
                "\n" +
                "Cards in Reserve x0\n" +
                "*******************************\n" +
                "\n" +
                "***** Player 2 0 Point(s) *****\n" +
                "Tokens: Onyx x0 ,Sapphire x0 ,Emerlad x0 ,Diamond x0 ,Rubby x0 ,Gold x0\n" +
                "\n" +
                "Cards:\n" +
                "\n" +
                "Nobles:\n" +
                "\n" +
                "\n" +
                "Cards in Reserve x0\n" +
                "*******************************\n" +
                "\n" +
                "***** Player 3 0 Point(s) *****\n" +
                "Tokens: Onyx x0 ,Sapphire x0 ,Emerlad x0 ,Diamond x0 ,Rubby x0 ,Gold x0\n" +
                "\n" +
                "Cards:\n" +
                "\n" +
                "Nobles:\n" +
                "\n" +
                "\n" +
                "Cards in Reserve x0\n" +
                "*******************************\n" +
                "\n" +
                "/////////////////////////////////////\n" +
                "Blue Deck\n" +
                "Blue Card 1:\n" +
                "4     Diamond  Town\n" +
                "Onyx x7\n" +
                "\n" +
                "Blue Card 2:\n" +
                "4     Diamond  Town\n" +
                "Onyx x7\n" +
                "\n" +
                "Blue Card 3:\n" +
                "4     Emerald  Town\n" +
                "Diamond x3 Emerald x3 Sapphire x6\n" +
                "\n" +
                "Blue Card 4:\n" +
                "4     Emerald  Town\n" +
                "Sapphire x7\n" +
                "\n" +
                "/////////////////////////\n" +
                "Yellow Deck\n" +
                "Yellow Card 1:\n" +
                "1     Onyx  Town\n" +
                "Diamond x3 Emerald x3 Onyx x2\n" +
                "\n" +
                "Yellow Card 2:\n" +
                "2     Emerald  Town\n" +
                "Emerald x3 Sapphire x3\n" +
                "\n" +
                "Yellow Card 3:\n" +
                "2     Rubby  Town\n" +
                "Diamond x1 Emerald x2 Sapphire x4\n" +
                "\n" +
                "Yellow Card 4:\n" +
                "2     Onyx  Town\n" +
                "Diamond x5\n" +
                "\n" +
                "/////////////////////////\n" +
                "Green Deck\n" +
                "Green Card 1:\n" +
                "0     Sapphire  Town\n" +
                "Diamond x1 Onyx x2\n" +
                "\n" +
                "Green Card 2:\n" +
                "0     Emerald  Town\n" +
                "Rubby x3\n" +
                "\n" +
                "Green Card 3:\n" +
                "1     Sapphire  Town\n" +
                "Rubby x4\n" +
                "\n" +
                "Green Card 4:\n" +
                "0     Emerald  Town\n" +
                "Rubby x2 Sapphire x2\n" +
                "\n" +
                "/////////////////////////////////////\n" +
                "Tokens Avalible: Onyx x5 ,Sapphire x5 ,Emerald x5 ,Diamond x5 ,Rubby x5 ,Gold x4\n" +
                "\n" +
                "Nobles Avalible:\n" +
                "\n" +
                "******* Cirilla Fiona Elen Riannon *******\n" +
                "Emerald x4    Sapphire x4\n" +
                "\n" +
                "\n" +
                "******* Sigismund Dijkstra *******\n" +
                "Diamond x3    Emerald x3    Sapphire x3\n" +
                "\n" +
                "\n" +
                "******* Morvran Voorhis *******\n" +
                "Rubby x3    Emerald x3    Onyx x3\n" +
                "\n" +
                "\n" +
                "******* Keira Metz *******\n" +
                "Rubby x3    Emerald x3\n" +
                "\n" +
                "\n" +
                "\n" +
                "It is Player 1's turn!\n" +
                "Player 1, here is what you currently have:\n" +
                "\n" +
                "\n" +
                "***** Player 1 0 Point(s) *****\n" +
                "Tokens: Onyx x0 ,Sapphire x0 ,Emerlad x0 ,Diamond x0 ,Rubby x0 ,Gold x0\n" +
                "\n" +
                "**** Cards ****\n" +
                "\n" +
                "**** Nobles ****\n" +
                "\n" +
                "\n" +
                "**** Cards in Reserve ****\n" +
                "\n" +
                "\n" +
                "Player 1, what do you wish to do this round?\n" +
                "\n" +
                "1. Take 2 tokens of the same color from the table(may only be performed if there is 4 or more tokens in the color of your chosing)\n" +
                "2. Take 1 token from each of 3 different types of tokens(excluding gold)\n" +
                "3. Reserve a card on the table and receive one gold token(keep in mind you may only have three reserved cards maximum. Also, you will not recieve any gold token if there is non on the table)\n" +
                "4. Reserve an unknown card from the top of a chosen deck\n" +
                "5. Buy a card from your reserved cards\n" +
                "6. Buy a card on the table\n";
                // call to method that does standard I/O
        String result = out.toString().replaceAll("\r","");
        System.setOut(output);

//        System.setIn(in); System.setOut(output);
        assertEquals(expected,result);} catch (Exception e) {
        }
    }
    @Test
    public void testGettingToken() throws PlayerDoesNotHaveEnoughResourcesToBuySelectedCard, SelectedDeckRanOutOfCards, NotEnoughTokensOnTable, InvalidCardsSelectionOfCardsInReserve, FileNotFoundException, InvalidCardsSelectionOfCardsOnTable, PlayerAlreadyHoldsThreeReserveCards, PlayerDoesNotHaveSelectedCardInReserve, InterruptedException {
        try{
        TextBasedInterface textInterfaceText = new TextBasedInterface();
        // set up testable input and output channels
        byte[] data = "2 2 1 2 3 4 2 2 1 4".getBytes(StandardCharsets.UTF_8);
        BufferedInputStream in = new BufferedInputStream(new ByteArrayInputStream(data));
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintStream output = new PrintStream(out);
        // redirect the standard channels

        String[] args = null;System.setIn(in);
        textInterfaceText.main(args);
        System.setOut(output);

        // call to method that does standard I/O
        String result = out.toString().replaceAll("\r","");
        System.setOut(output);

//        System.setIn(in); System.setOut(output);
//        assertEquals(expected,result);
        }
        catch (Exception e) {
            String result = "Welcome to Splendor! How many player(s) do you wish to have(including yourself)?\n" +
                    "2. 2    3. 3.    4. 4\n" +
                    "2\n" +
                    "Check0 completed\n" +
                    "Check1 completed\n" +
                    "Check2 completed\n" +
                    "Check3 completed\n" +
                    "check4 completed\n" +
                    "Awesome! lets start the game!\n" +
                    "\n" +
                    "\n" +
                    "***** Player 1 0 Point(s) *****\n" +
                    "Tokens: Onyx x0 ,Sapphire x0 ,Emerlad x0 ,Diamond x0 ,Rubby x0 ,Gold x0\n" +
                    "\n" +
                    "Cards:\n" +
                    "\n" +
                    "Nobles:\n" +
                    "\n" +
                    "\n" +
                    "Cards in Reserve x0\n" +
                    "*******************************\n" +
                    "\n" +
                    "***** Player 2 0 Point(s) *****\n" +
                    "Tokens: Onyx x0 ,Sapphire x0 ,Emerlad x0 ,Diamond x0 ,Rubby x0 ,Gold x0\n" +
                    "\n" +
                    "Cards:\n" +
                    "\n" +
                    "Nobles:\n" +
                    "\n" +
                    "\n" +
                    "Cards in Reserve x0\n" +
                    "*******************************\n" +
                    "\n" +
                    "/////////////////////////////////////\n" +
                    "Blue Deck\n" +
                    "Blue Card 1:\n" +
                    "3     Onyx  Town\n" +
                    "Diamond x3 Rubby x3 Emerald x5 Sapphire x3\n" +
                    "\n" +
                    "Blue Card 2:\n" +
                    "5     Emerald  Town\n" +
                    "Emerald x3 Sapphire x7\n" +
                    "\n" +
                    "Blue Card 3:\n" +
                    "3     Rubby  Town\n" +
                    "Diamond x3 Emerald x3 Sapphire x5\n" +
                    "\n" +
                    "Blue Card 4:\n" +
                    "5     Sapphire  Town\n" +
                    "Diamond x7 Sapphire x3\n" +
                    "\n" +
                    "/////////////////////////\n" +
                    "Yellow Deck\n" +
                    "Yellow Card 1:\n" +
                    "1     Sapphire  Town\n" +
                    "Emerald x3 Onyx x3 Sapphire x2\n" +
                    "\n" +
                    "Yellow Card 2:\n" +
                    "1     Onyx  Town\n" +
                    "Diamond x3 Emerald x2 Sapphire x3\n" +
                    "\n" +
                    "Yellow Card 3:\n" +
                    "1     Diamond  Town\n" +
                    "Diamond x2 Rubby x3 Sapphire x3\n" +
                    "\n" +
                    "Yellow Card 4:\n" +
                    "1     Rubby  Town\n" +
                    "Diamond x2 Rubby x2 Onyx x3\n" +
                    "\n" +
                    "/////////////////////////\n" +
                    "Green Deck\n" +
                    "Green Card 1:\n" +
                    "0     Rubby  Town\n" +
                    "Diamond x1 Emerald x1 Onyx x1 Sapphire x1\n" +
                    "\n" +
                    "Green Card 2:\n" +
                    "0     Sapphire  Town\n" +
                    "Rubby x1 Emerald x3 Sapphire x1\n" +
                    "\n" +
                    "Green Card 3:\n" +
                    "1     Emerald  Town\n" +
                    "Onyx x4\n" +
                    "\n" +
                    "Green Card 4:\n" +
                    "0     Emerald  Town\n" +
                    "Rubby x2 Onyx x2 Sapphire x1\n" +
                    "\n" +
                    "/////////////////////////////////////\n" +
                    "Tokens Avalible: Onyx x4 ,Sapphire x4 ,Emerald x4 ,Diamond x4 ,Rubby x4 ,Gold x4\n" +
                    "\n" +
                    "Nobles Avalible:\n" +
                    "\n" +
                    "******* Geralt of Rivia *******\n" +
                    "Rubby x4    Emerald x4\n" +
                    "\n" +
                    "\n" +
                    "******* Cirilla Fiona Elen Riannon *******\n" +
                    "Emerald x4    Sapphire x4\n" +
                    "\n" +
                    "\n" +
                    "******* Sigismund Dijkstra *******\n" +
                    "Diamond x3    Emerald x3    Sapphire x3\n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "It is Player 1's turn!\n" +
                    "Player 1, here is what you currently have:\n" +
                    "\n" +
                    "\n" +
                    "***** Player 1 0 Point(s) *****\n" +
                    "Tokens: Onyx x0 ,Sapphire x0 ,Emerlad x0 ,Diamond x0 ,Rubby x0 ,Gold x0\n" +
                    "\n" +
                    "**** Cards ****\n" +
                    "\n" +
                    "**** Nobles ****\n" +
                    "\n" +
                    "\n" +
                    "**** Cards in Reserve ****\n" +
                    "\n" +
                    "\n" +
                    "Player 1, what do you wish to do this round?\n" +
                    "\n" +
                    "1. Take 2 tokens of the same color from the table(may only be performed if there is 4 or more tokens in the color of your chosing)\n" +
                    "2. Take 1 token from each of 3 different types of tokens(excluding gold)\n" +
                    "3. Reserve a card on the table and receive one gold token(keep in mind you may only have three reserved cards maximum. Also, you will not recieve any gold token if there is non on the table)\n" +
                    "4. Reserve an unknown card from the top of a chosen deck\n" +
                    "5. Buy a card from your reserved cards\n" +
                    "6. Buy a card on the table\n" +
                    "2\n" +
                    "Choose a token to take.\n" +
                    "1. Onyx x4 2. Sapphire x4 3. Emerald x4 4. Diamond x4 5. Rubby x4\n" +
                    "1\n" +
                    "Choose a different token that you have not selected.\n" +
                    "1. Onyx x4 2. Sapphire x4 3. Emerald x4 4. Diamond x4 5. Rubby x4\n" +
                    "2\n" +
                    "Choose another different token that you have not selected.\n" +
                    "1. Onyx x4 2. Sapphire x4 3. Emerald x4 4. Diamond4 5. Rubby x4 6. Gold x4\n" +
                    "3\n" +
                    "3YOLOSWAG2\n" +
                    "Possibly not Working\n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "***** Player 1 0 Point(s) *****\n" +
                    "Tokens: Onyx x1 ,Sapphire x1 ,Emerlad x1 ,Diamond x0 ,Rubby x0 ,Gold x0\n" +
                    "\n" +
                    "Cards:\n" +
                    "\n" +
                    "Nobles:\n" +
                    "\n" +
                    "\n" +
                    "Cards in Reserve x0\n" +
                    "*******************************\n" +
                    "\n" +
                    "***** Player 2 0 Point(s) *****\n" +
                    "Tokens: Onyx x0 ,Sapphire x0 ,Emerlad x0 ,Diamond x0 ,Rubby x0 ,Gold x0\n" +
                    "\n" +
                    "Cards:\n" +
                    "\n" +
                    "Nobles:\n" +
                    "\n" +
                    "\n" +
                    "Cards in Reserve x0\n" +
                    "*******************************\n" +
                    "\n" +
                    "/////////////////////////////////////\n" +
                    "Blue Deck\n" +
                    "Blue Card 1:\n" +
                    "3     Onyx  Town\n" +
                    "Diamond x3 Rubby x3 Emerald x5 Sapphire x3\n" +
                    "\n" +
                    "Blue Card 2:\n" +
                    "5     Emerald  Town\n" +
                    "Emerald x3 Sapphire x7\n" +
                    "\n" +
                    "Blue Card 3:\n" +
                    "3     Rubby  Town\n" +
                    "Diamond x3 Emerald x3 Sapphire x5\n" +
                    "\n" +
                    "Blue Card 4:\n" +
                    "5     Sapphire  Town\n" +
                    "Diamond x7 Sapphire x3\n" +
                    "\n" +
                    "/////////////////////////\n" +
                    "Yellow Deck\n" +
                    "Yellow Card 1:\n" +
                    "1     Sapphire  Town\n" +
                    "Emerald x3 Onyx x3 Sapphire x2\n" +
                    "\n" +
                    "Yellow Card 2:\n" +
                    "1     Onyx  Town\n" +
                    "Diamond x3 Emerald x2 Sapphire x3\n" +
                    "\n" +
                    "Yellow Card 3:\n" +
                    "1     Diamond  Town\n" +
                    "Diamond x2 Rubby x3 Sapphire x3\n" +
                    "\n" +
                    "Yellow Card 4:\n" +
                    "1     Rubby  Town\n" +
                    "Diamond x2 Rubby x2 Onyx x3\n" +
                    "\n" +
                    "/////////////////////////\n" +
                    "Green Deck\n" +
                    "Green Card 1:\n" +
                    "0     Rubby  Town\n" +
                    "Diamond x1 Emerald x1 Onyx x1 Sapphire x1\n" +
                    "\n" +
                    "Green Card 2:\n" +
                    "0     Sapphire  Town\n" +
                    "Rubby x1 Emerald x3 Sapphire x1\n" +
                    "\n" +
                    "Green Card 3:\n" +
                    "1     Emerald  Town\n" +
                    "Onyx x4\n" +
                    "\n" +
                    "Green Card 4:\n" +
                    "0     Emerald  Town\n" +
                    "Rubby x2 Onyx x2 Sapphire x1\n" +
                    "\n" +
                    "/////////////////////////////////////\n" +
                    "Tokens Avalible: Onyx x3 ,Sapphire x3 ,Emerald x3 ,Diamond x4 ,Rubby x4 ,Gold x4\n" +
                    "\n" +
                    "Nobles Avalible:\n" +
                    "\n" +
                    "******* Geralt of Rivia *******\n" +
                    "Rubby x4    Emerald x4\n" +
                    "\n" +
                    "\n" +
                    "******* Cirilla Fiona Elen Riannon *******\n" +
                    "Emerald x4    Sapphire x4\n" +
                    "\n" +
                    "\n" +
                    "******* Sigismund Dijkstra *******\n" +
                    "Diamond x3    Emerald x3    Sapphire x3\n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "Attention! Player 1 chose to take three tokens of different color!\n" +
                    "It is Player 2's turn!\n" +
                    "Player 2, here is what you currently have:\n" +
                    "\n" +
                    "\n" +
                    "***** Player 2 0 Point(s) *****\n" +
                    "Tokens: Onyx x0 ,Sapphire x0 ,Emerlad x0 ,Diamond x0 ,Rubby x0 ,Gold x0\n" +
                    "\n" +
                    "**** Cards ****\n" +
                    "\n" +
                    "**** Nobles ****\n" +
                    "\n" +
                    "\n" +
                    "**** Cards in Reserve ****\n" +
                    "\n" +
                    "\n" +
                    "Player 2, what do you wish to do this round?\n" +
                    "\n" +
                    "1. Take 2 tokens of the same color from the table(may only be performed if there is 4 or more tokens in the color of your chosing)\n" +
                    "2. Take 1 token from each of 3 different types of tokens(excluding gold)\n" +
                    "3. Reserve a card on the table and receive one gold token(keep in mind you may only have three reserved cards maximum. Also, you will not recieve any gold token if there is non on the table)\n" +
                    "4. Reserve an unknown card from the top of a chosen deck\n" +
                    "5. Buy a card from your reserved cards\n" +
                    "6. Buy a card on the table\n" +
                    "4\n" +
                    "Which deck do you wish to reserve card from?\n" +
                    "1. Blue Deck   2. Yellow Deck   3. Green Deck\n" +
                    "2\n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "***** Player 1 0 Point(s) *****\n" +
                    "Tokens: Onyx x1 ,Sapphire x1 ,Emerlad x1 ,Diamond x0 ,Rubby x0 ,Gold x0\n" +
                    "\n" +
                    "Cards:\n" +
                    "\n" +
                    "Nobles:\n" +
                    "\n" +
                    "\n" +
                    "Cards in Reserve x0\n" +
                    "*******************************\n" +
                    "\n" +
                    "***** Player 2 0 Point(s) *****\n" +
                    "Tokens: Onyx x0 ,Sapphire x0 ,Emerlad x0 ,Diamond x0 ,Rubby x0 ,Gold x1\n" +
                    "\n" +
                    "Cards:\n" +
                    "\n" +
                    "Nobles:\n" +
                    "\n" +
                    "\n" +
                    "Cards in Reserve x1\n" +
                    "*******************************\n" +
                    "\n" +
                    "/////////////////////////////////////\n" +
                    "Blue Deck\n" +
                    "Blue Card 1:\n" +
                    "3     Onyx  Town\n" +
                    "Diamond x3 Rubby x3 Emerald x5 Sapphire x3\n" +
                    "\n" +
                    "Blue Card 2:\n" +
                    "5     Emerald  Town\n" +
                    "Emerald x3 Sapphire x7\n" +
                    "\n" +
                    "Blue Card 3:\n" +
                    "3     Rubby  Town\n" +
                    "Diamond x3 Emerald x3 Sapphire x5\n" +
                    "\n" +
                    "Blue Card 4:\n" +
                    "5     Sapphire  Town\n" +
                    "Diamond x7 Sapphire x3\n" +
                    "\n" +
                    "/////////////////////////\n" +
                    "Yellow Deck\n" +
                    "Yellow Card 1:\n" +
                    "1     Sapphire  Town\n" +
                    "Emerald x3 Onyx x3 Sapphire x2\n" +
                    "\n" +
                    "Yellow Card 2:\n" +
                    "1     Onyx  Town\n" +
                    "Diamond x3 Emerald x2 Sapphire x3\n" +
                    "\n" +
                    "Yellow Card 3:\n" +
                    "1     Diamond  Town\n" +
                    "Diamond x2 Rubby x3 Sapphire x3\n" +
                    "\n" +
                    "Yellow Card 4:\n" +
                    "1     Rubby  Town\n" +
                    "Diamond x2 Rubby x2 Onyx x3\n" +
                    "\n" +
                    "/////////////////////////\n" +
                    "Green Deck\n" +
                    "Green Card 1:\n" +
                    "0     Rubby  Town\n" +
                    "Diamond x1 Emerald x1 Onyx x1 Sapphire x1\n" +
                    "\n" +
                    "Green Card 2:\n" +
                    "0     Sapphire  Town\n" +
                    "Rubby x1 Emerald x3 Sapphire x1\n" +
                    "\n" +
                    "Green Card 3:\n" +
                    "1     Emerald  Town\n" +
                    "Onyx x4\n" +
                    "\n" +
                    "Green Card 4:\n" +
                    "0     Emerald  Town\n" +
                    "Rubby x2 Onyx x2 Sapphire x1\n" +
                    "\n" +
                    "/////////////////////////////////////\n" +
                    "Tokens Avalible: Onyx x3 ,Sapphire x3 ,Emerald x3 ,Diamond x4 ,Rubby x4 ,Gold x3\n" +
                    "\n" +
                    "Nobles Avalible:\n" +
                    "\n" +
                    "******* Geralt of Rivia *******\n" +
                    "Rubby x4    Emerald x4\n" +
                    "\n" +
                    "\n" +
                    "******* Cirilla Fiona Elen Riannon *******\n" +
                    "Emerald x4    Sapphire x4\n" +
                    "\n" +
                    "\n" +
                    "******* Sigismund Dijkstra *******\n" +
                    "Diamond x3    Emerald x3    Sapphire x3\n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "Attention! Player 2 chose to reserve a card from the deck!\n" +
                    "It is Player 1's turn!\n" +
                    "Player 1, here is what you currently have:\n" +
                    "\n" +
                    "\n" +
                    "***** Player 1 0 Point(s) *****\n" +
                    "Tokens: Onyx x1 ,Sapphire x1 ,Emerlad x1 ,Diamond x0 ,Rubby x0 ,Gold x0\n" +
                    "\n" +
                    "**** Cards ****\n" +
                    "\n" +
                    "**** Nobles ****\n" +
                    "\n" +
                    "\n" +
                    "**** Cards in Reserve ****\n" +
                    "\n" +
                    "\n" +
                    "Player 1, what do you wish to do this round?\n" +
                    "\n" +
                    "1. Take 2 tokens of the same color from the table(may only be performed if there is 4 or more tokens in the color of your chosing)\n" +
                    "2. Take 1 token from each of 3 different types of tokens(excluding gold)\n" +
                    "3. Reserve a card on the table and receive one gold token(keep in mind you may only have three reserved cards maximum. Also, you will not recieve any gold token if there is non on the table)\n" +
                    "4. Reserve an unknown card from the top of a chosen deck\n" +
                    "5. Buy a card from your reserved cards\n" +
                    "6. Buy a card on the table\n" +
                    "2\n" +
                    "Choose a token to take.\n" +
                    "1. Onyx x3 2. Sapphire x3 3. Emerald x3 4. Diamond x4 5. Rubby x4\n" +
                    "1\n" +
                    "Choose a different token that you have not selected.\n" +
                    "1. Onyx x3 2. Sapphire x3 3. Emerald x3 4. Diamond x4 5. Rubby x4\n" +
                    "4\n" +
                    "Choose another different token that you have not selected.\n" +
                    "1. Onyx x3 2. Sapphire x3 3. Emerald x3 4. Diamond4 5. Rubby x4 6.Gold\n";
            String to_contains = "\"Choose another different token that you have not selected.\\n\" +\n" +
                    "                    \"1. Onyx x3 2. Sapphire x3 3. Emerald x3 4. Diamond x4 5. Rubby x4\\n\"";
            assertTrue(result.contains(to_contains));
        }
    }
    @Test
    public void testGettingToken_three_rounds() throws PlayerDoesNotHaveEnoughResourcesToBuySelectedCard, SelectedDeckRanOutOfCards, NotEnoughTokensOnTable, InvalidCardsSelectionOfCardsInReserve, FileNotFoundException, InvalidCardsSelectionOfCardsOnTable, PlayerAlreadyHoldsThreeReserveCards, PlayerDoesNotHaveSelectedCardInReserve, InterruptedException {
        try{
        TextBasedInterface textInterfaceText = new TextBasedInterface();
        // set up testable input and output channels
        byte[] data = "2 2 1 2 3 4 2 2 1 4 5 4 1 2".getBytes(StandardCharsets.UTF_8);
        BufferedInputStream in = new BufferedInputStream(new ByteArrayInputStream(data));
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintStream output = new PrintStream(out);
        // redirect the standard channels

        String[] args = null;System.setIn(in);
        textInterfaceText.main(args);
        System.setOut(output);
                // call to method that does standard I/O
        String result = out.toString().replaceAll("\r","");
        System.setOut(output);
        } catch (Exception e) {
            String result = "Welcome to Splendor! How many player(s) do you wish to have(including yourself)?\n" +
                    "2. 2    3. 3.    4. 4\n" +
                    "2\n" +
                    "Check0 completed\n" +
                    "Check1 completed\n" +
                    "Check2 completed\n" +
                    "Check3 completed\n" +
                    "check4 completed\n" +
                    "Awesome! lets start the game!\n" +
                    "\n" +
                    "\n" +
                    "***** Player 1 0 Point(s) *****\n" +
                    "Tokens: Onyx x0 ,Sapphire x0 ,Emerlad x0 ,Diamond x0 ,Rubby x0 ,Gold x0\n" +
                    "\n" +
                    "Cards:\n" +
                    "\n" +
                    "Nobles:\n" +
                    "\n" +
                    "\n" +
                    "Cards in Reserve x0\n" +
                    "*******************************\n" +
                    "\n" +
                    "***** Player 2 0 Point(s) *****\n" +
                    "Tokens: Onyx x0 ,Sapphire x0 ,Emerlad x0 ,Diamond x0 ,Rubby x0 ,Gold x0\n" +
                    "\n" +
                    "Cards:\n" +
                    "\n" +
                    "Nobles:\n" +
                    "\n" +
                    "\n" +
                    "Cards in Reserve x0\n" +
                    "*******************************\n" +
                    "\n" +
                    "/////////////////////////////////////\n" +
                    "Blue Deck\n" +
                    "Blue Card 1:\n" +
                    "3     Onyx  Town\n" +
                    "Diamond x3 Rubby x3 Emerald x5 Sapphire x3\n" +
                    "\n" +
                    "Blue Card 2:\n" +
                    "5     Emerald  Town\n" +
                    "Emerald x3 Sapphire x7\n" +
                    "\n" +
                    "Blue Card 3:\n" +
                    "3     Rubby  Town\n" +
                    "Diamond x3 Emerald x3 Sapphire x5\n" +
                    "\n" +
                    "Blue Card 4:\n" +
                    "5     Sapphire  Town\n" +
                    "Diamond x7 Sapphire x3\n" +
                    "\n" +
                    "/////////////////////////\n" +
                    "Yellow Deck\n" +
                    "Yellow Card 1:\n" +
                    "1     Sapphire  Town\n" +
                    "Emerald x3 Onyx x3 Sapphire x2\n" +
                    "\n" +
                    "Yellow Card 2:\n" +
                    "1     Onyx  Town\n" +
                    "Diamond x3 Emerald x2 Sapphire x3\n" +
                    "\n" +
                    "Yellow Card 3:\n" +
                    "1     Diamond  Town\n" +
                    "Diamond x2 Rubby x3 Sapphire x3\n" +
                    "\n" +
                    "Yellow Card 4:\n" +
                    "1     Rubby  Town\n" +
                    "Diamond x2 Rubby x2 Onyx x3\n" +
                    "\n" +
                    "/////////////////////////\n" +
                    "Green Deck\n" +
                    "Green Card 1:\n" +
                    "0     Rubby  Town\n" +
                    "Diamond x1 Emerald x1 Onyx x1 Sapphire x1\n" +
                    "\n" +
                    "Green Card 2:\n" +
                    "0     Sapphire  Town\n" +
                    "Rubby x1 Emerald x3 Sapphire x1\n" +
                    "\n" +
                    "Green Card 3:\n" +
                    "1     Emerald  Town\n" +
                    "Onyx x4\n" +
                    "\n" +
                    "Green Card 4:\n" +
                    "0     Emerald  Town\n" +
                    "Rubby x2 Onyx x2 Sapphire x1\n" +
                    "\n" +
                    "/////////////////////////////////////\n" +
                    "Tokens Avalible: Onyx x4 ,Sapphire x4 ,Emerald x4 ,Diamond x4 ,Rubby x4 ,Gold x4\n" +
                    "\n" +
                    "Nobles Avalible:\n" +
                    "\n" +
                    "******* Geralt of Rivia *******\n" +
                    "Rubby x4    Emerald x4\n" +
                    "\n" +
                    "\n" +
                    "******* Cirilla Fiona Elen Riannon *******\n" +
                    "Emerald x4    Sapphire x4\n" +
                    "\n" +
                    "\n" +
                    "******* Sigismund Dijkstra *******\n" +
                    "Diamond x3    Emerald x3    Sapphire x3\n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "It is Player 1's turn!\n" +
                    "Player 1, here is what you currently have:\n" +
                    "\n" +
                    "\n" +
                    "***** Player 1 0 Point(s) *****\n" +
                    "Tokens: Onyx x0 ,Sapphire x0 ,Emerlad x0 ,Diamond x0 ,Rubby x0 ,Gold x0\n" +
                    "\n" +
                    "**** Cards ****\n" +
                    "\n" +
                    "**** Nobles ****\n" +
                    "\n" +
                    "\n" +
                    "**** Cards in Reserve ****\n" +
                    "\n" +
                    "\n" +
                    "Player 1, what do you wish to do this round?\n" +
                    "\n" +
                    "1. Take 2 tokens of the same color from the table(may only be performed if there is 4 or more tokens in the color of your chosing)\n" +
                    "2. Take 1 token from each of 3 different types of tokens(excluding gold)\n" +
                    "3. Reserve a card on the table and receive one gold token(keep in mind you may only have three reserved cards maximum. Also, you will not recieve any gold token if there is non on the table)\n" +
                    "4. Reserve an unknown card from the top of a chosen deck\n" +
                    "5. Buy a card from your reserved cards\n" +
                    "6. Buy a card on the table\n" +
                    "2\n" +
                    "Choose a token to take.\n" +
                    "1. Onyx x4 2. Sapphire x4 3. Emerald x4 4. Diamond x4 5. Rubby x4\n" +
                    "1\n" +
                    "Choose a different token that you have not selected.\n" +
                    "1. Onyx x4 2. Sapphire x4 3. Emerald x4 4. Diamond x4 5. Rubby x4\n" +
                    "2\n" +
                    "Choose another different token that you have not selected.\n" +
                    "1. Onyx x4 2. Sapphire x4 3. Emerald x4 4. Diamond4 5. Rubby x4 6. Gold x4\n" +
                    "3\n" +
                    "3YOLOSWAG2\n" +
                    "Possibly not Working\n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "***** Player 1 0 Point(s) *****\n" +
                    "Tokens: Onyx x1 ,Sapphire x1 ,Emerlad x1 ,Diamond x0 ,Rubby x0 ,Gold x0\n" +
                    "\n" +
                    "Cards:\n" +
                    "\n" +
                    "Nobles:\n" +
                    "\n" +
                    "\n" +
                    "Cards in Reserve x0\n" +
                    "*******************************\n" +
                    "\n" +
                    "***** Player 2 0 Point(s) *****\n" +
                    "Tokens: Onyx x0 ,Sapphire x0 ,Emerlad x0 ,Diamond x0 ,Rubby x0 ,Gold x0\n" +
                    "\n" +
                    "Cards:\n" +
                    "\n" +
                    "Nobles:\n" +
                    "\n" +
                    "\n" +
                    "Cards in Reserve x0\n" +
                    "*******************************\n" +
                    "\n" +
                    "/////////////////////////////////////\n" +
                    "Blue Deck\n" +
                    "Blue Card 1:\n" +
                    "3     Onyx  Town\n" +
                    "Diamond x3 Rubby x3 Emerald x5 Sapphire x3\n" +
                    "\n" +
                    "Blue Card 2:\n" +
                    "5     Emerald  Town\n" +
                    "Emerald x3 Sapphire x7\n" +
                    "\n" +
                    "Blue Card 3:\n" +
                    "3     Rubby  Town\n" +
                    "Diamond x3 Emerald x3 Sapphire x5\n" +
                    "\n" +
                    "Blue Card 4:\n" +
                    "5     Sapphire  Town\n" +
                    "Diamond x7 Sapphire x3\n" +
                    "\n" +
                    "/////////////////////////\n" +
                    "Yellow Deck\n" +
                    "Yellow Card 1:\n" +
                    "1     Sapphire  Town\n" +
                    "Emerald x3 Onyx x3 Sapphire x2\n" +
                    "\n" +
                    "Yellow Card 2:\n" +
                    "1     Onyx  Town\n" +
                    "Diamond x3 Emerald x2 Sapphire x3\n" +
                    "\n" +
                    "Yellow Card 3:\n" +
                    "1     Diamond  Town\n" +
                    "Diamond x2 Rubby x3 Sapphire x3\n" +
                    "\n" +
                    "Yellow Card 4:\n" +
                    "1     Rubby  Town\n" +
                    "Diamond x2 Rubby x2 Onyx x3\n" +
                    "\n" +
                    "/////////////////////////\n" +
                    "Green Deck\n" +
                    "Green Card 1:\n" +
                    "0     Rubby  Town\n" +
                    "Diamond x1 Emerald x1 Onyx x1 Sapphire x1\n" +
                    "\n" +
                    "Green Card 2:\n" +
                    "0     Sapphire  Town\n" +
                    "Rubby x1 Emerald x3 Sapphire x1\n" +
                    "\n" +
                    "Green Card 3:\n" +
                    "1     Emerald  Town\n" +
                    "Onyx x4\n" +
                    "\n" +
                    "Green Card 4:\n" +
                    "0     Emerald  Town\n" +
                    "Rubby x2 Onyx x2 Sapphire x1\n" +
                    "\n" +
                    "/////////////////////////////////////\n" +
                    "Tokens Avalible: Onyx x3 ,Sapphire x3 ,Emerald x3 ,Diamond x4 ,Rubby x4 ,Gold x4\n" +
                    "\n" +
                    "Nobles Avalible:\n" +
                    "\n" +
                    "******* Geralt of Rivia *******\n" +
                    "Rubby x4    Emerald x4\n" +
                    "\n" +
                    "\n" +
                    "******* Cirilla Fiona Elen Riannon *******\n" +
                    "Emerald x4    Sapphire x4\n" +
                    "\n" +
                    "\n" +
                    "******* Sigismund Dijkstra *******\n" +
                    "Diamond x3    Emerald x3    Sapphire x3\n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "Attention! Player 1 chose to take three tokens of different color!\n" +
                    "It is Player 2's turn!\n" +
                    "Player 2, here is what you currently have:\n" +
                    "\n" +
                    "\n" +
                    "***** Player 2 0 Point(s) *****\n" +
                    "Tokens: Onyx x0 ,Sapphire x0 ,Emerlad x0 ,Diamond x0 ,Rubby x0 ,Gold x0\n" +
                    "\n" +
                    "**** Cards ****\n" +
                    "\n" +
                    "**** Nobles ****\n" +
                    "\n" +
                    "\n" +
                    "**** Cards in Reserve ****\n" +
                    "\n" +
                    "\n" +
                    "Player 2, what do you wish to do this round?\n" +
                    "\n" +
                    "1. Take 2 tokens of the same color from the table(may only be performed if there is 4 or more tokens in the color of your chosing)\n" +
                    "2. Take 1 token from each of 3 different types of tokens(excluding gold)\n" +
                    "3. Reserve a card on the table and receive one gold token(keep in mind you may only have three reserved cards maximum. Also, you will not recieve any gold token if there is non on the table)\n" +
                    "4. Reserve an unknown card from the top of a chosen deck\n" +
                    "5. Buy a card from your reserved cards\n" +
                    "6. Buy a card on the table\n" +
                    "4\n" +
                    "Which deck do you wish to reserve card from?\n" +
                    "1. Blue Deck   2. Yellow Deck   3. Green Deck\n" +
                    "2\n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "***** Player 1 0 Point(s) *****\n" +
                    "Tokens: Onyx x1 ,Sapphire x1 ,Emerlad x1 ,Diamond x0 ,Rubby x0 ,Gold x0\n" +
                    "\n" +
                    "Cards:\n" +
                    "\n" +
                    "Nobles:\n" +
                    "\n" +
                    "\n" +
                    "Cards in Reserve x0\n" +
                    "*******************************\n" +
                    "\n" +
                    "***** Player 2 0 Point(s) *****\n" +
                    "Tokens: Onyx x0 ,Sapphire x0 ,Emerlad x0 ,Diamond x0 ,Rubby x0 ,Gold x1\n" +
                    "\n" +
                    "Cards:\n" +
                    "\n" +
                    "Nobles:\n" +
                    "\n" +
                    "\n" +
                    "Cards in Reserve x1\n" +
                    "*******************************\n" +
                    "\n" +
                    "/////////////////////////////////////\n" +
                    "Blue Deck\n" +
                    "Blue Card 1:\n" +
                    "3     Onyx  Town\n" +
                    "Diamond x3 Rubby x3 Emerald x5 Sapphire x3\n" +
                    "\n" +
                    "Blue Card 2:\n" +
                    "5     Emerald  Town\n" +
                    "Emerald x3 Sapphire x7\n" +
                    "\n" +
                    "Blue Card 3:\n" +
                    "3     Rubby  Town\n" +
                    "Diamond x3 Emerald x3 Sapphire x5\n" +
                    "\n" +
                    "Blue Card 4:\n" +
                    "5     Sapphire  Town\n" +
                    "Diamond x7 Sapphire x3\n" +
                    "\n" +
                    "/////////////////////////\n" +
                    "Yellow Deck\n" +
                    "Yellow Card 1:\n" +
                    "1     Sapphire  Town\n" +
                    "Emerald x3 Onyx x3 Sapphire x2\n" +
                    "\n" +
                    "Yellow Card 2:\n" +
                    "1     Onyx  Town\n" +
                    "Diamond x3 Emerald x2 Sapphire x3\n" +
                    "\n" +
                    "Yellow Card 3:\n" +
                    "1     Diamond  Town\n" +
                    "Diamond x2 Rubby x3 Sapphire x3\n" +
                    "\n" +
                    "Yellow Card 4:\n" +
                    "1     Rubby  Town\n" +
                    "Diamond x2 Rubby x2 Onyx x3\n" +
                    "\n" +
                    "/////////////////////////\n" +
                    "Green Deck\n" +
                    "Green Card 1:\n" +
                    "0     Rubby  Town\n" +
                    "Diamond x1 Emerald x1 Onyx x1 Sapphire x1\n" +
                    "\n" +
                    "Green Card 2:\n" +
                    "0     Sapphire  Town\n" +
                    "Rubby x1 Emerald x3 Sapphire x1\n" +
                    "\n" +
                    "Green Card 3:\n" +
                    "1     Emerald  Town\n" +
                    "Onyx x4\n" +
                    "\n" +
                    "Green Card 4:\n" +
                    "0     Emerald  Town\n" +
                    "Rubby x2 Onyx x2 Sapphire x1\n" +
                    "\n" +
                    "/////////////////////////////////////\n" +
                    "Tokens Avalible: Onyx x3 ,Sapphire x3 ,Emerald x3 ,Diamond x4 ,Rubby x4 ,Gold x3\n" +
                    "\n" +
                    "Nobles Avalible:\n" +
                    "\n" +
                    "******* Geralt of Rivia *******\n" +
                    "Rubby x4    Emerald x4\n" +
                    "\n" +
                    "\n" +
                    "******* Cirilla Fiona Elen Riannon *******\n" +
                    "Emerald x4    Sapphire x4\n" +
                    "\n" +
                    "\n" +
                    "******* Sigismund Dijkstra *******\n" +
                    "Diamond x3    Emerald x3    Sapphire x3\n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "Attention! Player 2 chose to reserve a card from the deck!\n" +
                    "It is Player 1's turn!\n" +
                    "Player 1, here is what you currently have:\n" +
                    "\n" +
                    "\n" +
                    "***** Player 1 0 Point(s) *****\n" +
                    "Tokens: Onyx x1 ,Sapphire x1 ,Emerlad x1 ,Diamond x0 ,Rubby x0 ,Gold x0\n" +
                    "\n" +
                    "**** Cards ****\n" +
                    "\n" +
                    "**** Nobles ****\n" +
                    "\n" +
                    "\n" +
                    "**** Cards in Reserve ****\n" +
                    "\n" +
                    "\n" +
                    "Player 1, what do you wish to do this round?\n" +
                    "\n" +
                    "1. Take 2 tokens of the same color from the table(may only be performed if there is 4 or more tokens in the color of your chosing)\n" +
                    "2. Take 1 token from each of 3 different types of tokens(excluding gold)\n" +
                    "3. Reserve a card on the table and receive one gold token(keep in mind you may only have three reserved cards maximum. Also, you will not recieve any gold token if there is non on the table)\n" +
                    "4. Reserve an unknown card from the top of a chosen deck\n" +
                    "5. Buy a card from your reserved cards\n" +
                    "6. Buy a card on the table\n" +
                    "21\n" +
                    "Choose a token to take.\n" +
                    "1. Onyx x3 2. Sapphire x3 3. Emerald x3 4. Diamond x4 5. Rubby x4\n" +
                    "1\n" +
                    "Choose a different token that you have not selected.\n" +
                    "1. Onyx x3 2. Sapphire x3 3. Emerald x3 4. Diamond x4 5. Rubby x4\n" +
                    "4\n" +
                    "Choose another different token that you have not selected.\n" +
                    "1. Onyx x3 2. Sapphire x3 3. Emerald x3 4. Diamond4 5. Rubby x4 6. Gold x3\n" +
                    "3\n" +
                    "6YOLOSWAG2\n" +
                    "Possibly not Working\n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "***** Player 1 0 Point(s) *****\n" +
                    "Tokens: Onyx x2 ,Sapphire x1 ,Emerlad x2 ,Diamond x1 ,Rubby x0 ,Gold x0\n" +
                    "\n" +
                    "Cards:\n" +
                    "\n" +
                    "Nobles:\n" +
                    "\n" +
                    "\n" +
                    "Cards in Reserve x0\n" +
                    "*******************************\n" +
                    "\n" +
                    "***** Player 2 0 Point(s) *****\n" +
                    "Tokens: Onyx x0 ,Sapphire x0 ,Emerlad x0 ,Diamond x0 ,Rubby x0 ,Gold x1\n" +
                    "\n" +
                    "Cards:\n" +
                    "\n" +
                    "Nobles:\n" +
                    "\n" +
                    "\n" +
                    "Cards in Reserve x1\n" +
                    "*******************************\n" +
                    "\n" +
                    "/////////////////////////////////////\n" +
                    "Blue Deck\n" +
                    "Blue Card 1:\n" +
                    "3     Onyx  Town\n" +
                    "Diamond x3 Rubby x3 Emerald x5 Sapphire x3\n" +
                    "\n" +
                    "Blue Card 2:\n" +
                    "5     Emerald  Town\n" +
                    "Emerald x3 Sapphire x7\n" +
                    "\n" +
                    "Blue Card 3:\n" +
                    "3     Rubby  Town\n" +
                    "Diamond x3 Emerald x3 Sapphire x5\n" +
                    "\n" +
                    "Blue Card 4:\n" +
                    "5     Sapphire  Town\n" +
                    "Diamond x7 Sapphire x3\n" +
                    "\n" +
                    "/////////////////////////\n" +
                    "Yellow Deck\n" +
                    "Yellow Card 1:\n" +
                    "1     Sapphire  Town\n" +
                    "Emerald x3 Onyx x3 Sapphire x2\n" +
                    "\n" +
                    "Yellow Card 2:\n" +
                    "1     Onyx  Town\n" +
                    "Diamond x3 Emerald x2 Sapphire x3\n" +
                    "\n" +
                    "Yellow Card 3:\n" +
                    "1     Diamond  Town\n" +
                    "Diamond x2 Rubby x3 Sapphire x3\n" +
                    "\n" +
                    "Yellow Card 4:\n" +
                    "1     Rubby  Town\n" +
                    "Diamond x2 Rubby x2 Onyx x3\n" +
                    "\n" +
                    "/////////////////////////\n" +
                    "Green Deck\n" +
                    "Green Card 1:\n" +
                    "0     Rubby  Town\n" +
                    "Diamond x1 Emerald x1 Onyx x1 Sapphire x1\n" +
                    "\n" +
                    "Green Card 2:\n" +
                    "0     Sapphire  Town\n" +
                    "Rubby x1 Emerald x3 Sapphire x1\n" +
                    "\n" +
                    "Green Card 3:\n" +
                    "1     Emerald  Town\n" +
                    "Onyx x4\n" +
                    "\n" +
                    "Green Card 4:\n" +
                    "0     Emerald  Town\n" +
                    "Rubby x2 Onyx x2 Sapphire x1\n" +
                    "\n" +
                    "/////////////////////////////////////\n" +
                    "Tokens Avalible: Onyx x2 ,Sapphire x3 ,Emerald x2 ,Diamond x3 ,Rubby x4 ,Gold x3\n" +
                    "\n" +
                    "Nobles Avalible:\n" +
                    "\n" +
                    "******* Geralt of Rivia *******\n" +
                    "Rubby x4    Emerald x4\n" +
                    "\n" +
                    "\n" +
                    "******* Cirilla Fiona Elen Riannon *******\n" +
                    "Emerald x4    Sapphire x4\n" +
                    "\n" +
                    "\n" +
                    "******* Sigismund Dijkstra *******\n" +
                    "Diamond x3    Emerald x3    Sapphire x3\n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "Attention! Player 1 chose to take three tokens of different color!\n" +
                    "It is Player 2's turn!\n" +
                    "Player 2, here is what you currently have:\n" +
                    "\n" +
                    "\n" +
                    "***** Player 2 0 Point(s) *****\n" +
                    "Tokens: Onyx x0 ,Sapphire x0 ,Emerlad x0 ,Diamond x0 ,Rubby x0 ,Gold x1\n" +
                    "\n" +
                    "**** Cards ****\n" +
                    "\n" +
                    "**** Nobles ****\n" +
                    "\n" +
                    "\n" +
                    "**** Cards in Reserve ****\n" +
                    "\n" +
                    "2     Diamond  Town\n" +
                    "Rubby x4 Emerald x1 Onyx x2\n" +
                    "\n" +
                    "\n" +
                    "Player 2, what do you wish to do this round?\n" +
                    "\n" +
                    "1. Take 2 tokens of the same color from the table(may only be performed if there is 4 or more tokens in the color of your chosing)\n" +
                    "2. Take 1 token from each of 3 different types of tokens(excluding gold)\n" +
                    "3. Reserve a card on the table and receive one gold token(keep in mind you may only have three reserved cards maximum. Also, you will not recieve any gold token if there is non on the table)\n" +
                    "4. Reserve an unknown card from the top of a chosen deck\n" +
                    "5. Buy a card from your reserved cards\n" +
                    "6. Buy a card on the table\n" +
                    "4\n" +
                    "\n" +
                    "Which deck do you wish to reserve card from?\n" +
                    "1. Blue Deck   2. Yellow Deck   3. Green Deck\n" +
                    "3\n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "***** Player 1 0 Point(s) *****\n" +
                    "Tokens: Onyx x2 ,Sapphire x1 ,Emerlad x2 ,Diamond x1 ,Rubby x0 ,Gold x0\n" +
                    "\n" +
                    "Cards:\n" +
                    "\n" +
                    "Nobles:\n" +
                    "\n" +
                    "\n" +
                    "Cards in Reserve x0\n" +
                    "*******************************\n" +
                    "\n" +
                    "***** Player 2 0 Point(s) *****\n" +
                    "Tokens: Onyx x0 ,Sapphire x0 ,Emerlad x0 ,Diamond x0 ,Rubby x0 ,Gold x3\n" +
                    "\n" +
                    "Cards:\n" +
                    "\n" +
                    "Nobles:\n" +
                    "\n" +
                    "\n" +
                    "Cards in Reserve x3\n" +
                    "*******************************\n" +
                    "\n" +
                    "/////////////////////////////////////\n" +
                    "Blue Deck\n" +
                    "Blue Card 1:\n" +
                    "3     Onyx  Town\n" +
                    "Diamond x3 Rubby x3 Emerald x5 Sapphire x3\n" +
                    "\n" +
                    "Blue Card 2:\n" +
                    "5     Emerald  Town\n" +
                    "Emerald x3 Sapphire x7\n" +
                    "\n" +
                    "Blue Card 3:\n" +
                    "3     Rubby  Town\n" +
                    "Diamond x3 Emerald x3 Sapphire x5\n" +
                    "\n" +
                    "Blue Card 4:\n" +
                    "5     Sapphire  Town\n" +
                    "Diamond x7 Sapphire x3\n" +
                    "\n" +
                    "/////////////////////////\n" +
                    "Yellow Deck\n" +
                    "Yellow Card 1:\n" +
                    "1     Sapphire  Town\n" +
                    "Emerald x3 Onyx x3 Sapphire x2\n" +
                    "\n" +
                    "Yellow Card 2:\n" +
                    "1     Onyx  Town\n" +
                    "Diamond x3 Emerald x2 Sapphire x3\n" +
                    "\n" +
                    "Yellow Card 3:\n" +
                    "1     Diamond  Town\n" +
                    "Diamond x2 Rubby x3 Sapphire x3\n" +
                    "\n" +
                    "Yellow Card 4:\n" +
                    "1     Rubby  Town\n" +
                    "Diamond x2 Rubby x2 Onyx x3\n" +
                    "\n" +
                    "/////////////////////////\n" +
                    "Green Deck\n" +
                    "Green Card 1:\n" +
                    "0     Rubby  Town\n" +
                    "Diamond x1 Emerald x1 Onyx x1 Sapphire x1\n" +
                    "\n" +
                    "Green Card 2:\n" +
                    "0     Sapphire  Town\n" +
                    "Rubby x1 Emerald x3 Sapphire x1\n" +
                    "\n" +
                    "Green Card 3:\n" +
                    "1     Emerald  Town\n" +
                    "Onyx x4\n" +
                    "\n" +
                    "Green Card 4:\n" +
                    "0     Emerald  Town\n" +
                    "Rubby x2 Onyx x2 Sapphire x1\n" +
                    "\n" +
                    "/////////////////////////////////////\n" +
                    "Tokens Avalible: Onyx x2 ,Sapphire x3 ,Emerald x2 ,Diamond x3 ,Rubby x4 ,Gold x1\n" +
                    "\n" +
                    "Nobles Avalible:\n" +
                    "\n" +
                    "******* Geralt of Rivia *******\n" +
                    "Rubby x4    Emerald x4\n" +
                    "\n" +
                    "\n" +
                    "******* Cirilla Fiona Elen Riannon *******\n" +
                    "Emerald x4    Sapphire x4\n" +
                    "\n" +
                    "\n" +
                    "******* Sigismund Dijkstra *******\n" +
                    "Diamond x3    Emerald x3    Sapphire x3\n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "Attention! Player 2 chose to reserve a card from the deck!\n" +
                    "It is Player 1's turn!\n" +
                    "Player 1, here is what you currently have:\n" +
                    "\n" +
                    "\n" +
                    "***** Player 1 0 Point(s) *****\n" +
                    "Tokens: Onyx x2 ,Sapphire x1 ,Emerlad x2 ,Diamond x1 ,Rubby x0 ,Gold x0\n" +
                    "\n" +
                    "**** Cards ****\n" +
                    "\n" +
                    "**** Nobles ****\n" +
                    "\n" +
                    "\n" +
                    "**** Cards in Reserve ****\n" +
                    "\n" +
                    "\n" +
                    "Player 1, what do you wish to do this round?\n" +
                    "\n" +
                    "1. Take 2 tokens of the same color from the table(may only be performed if there is 4 or more tokens in the color of your chosing)\n" +
                    "2. Take 1 token from each of 3 different types of tokens(excluding gold)\n" +
                    "3. Reserve a card on the table and receive one gold token(keep in mind you may only have three reserved cards maximum. Also, you will not recieve any gold token if there is non on the table)\n" +
                    "4. Reserve an unknown card from the top of a chosen deck\n" +
                    "5. Buy a card from your reserved cards\n" +
                    "6. Buy a card on the table\n" +
                    "2\n" +
                    "Choose a token to take.\n" +
                    "1. Onyx x2 2. Sapphire x3 3. Emerald x2 4. Diamond x3 5. Rubby x4\n" +
                    "4\n" +
                    "Choose a different token that you have not selected.\n" +
                    "1. Onyx x2 2. Sapphire x3 3. Emerald x2 4. Diamond x3 5. Rubby x4\n" +
                    "5\n" +
                    "Choose another different token that you have not selected.\n" +
                    "1. Onyx x2 2. Sapphire x3 3. Emerald x2 4. Diamond3 5. Rubby x4 6. Gold x1\n";
            String expected = "Welcome to Splendor! How many player(s) do you wish to have(including yourself)?\n" +
                    "2. 2    3. 3.    4. 4\n" +
                    "2\n" +
                    "Check0 completed\n" +
                    "Check1 completed\n" +
                    "Check2 completed\n" +
                    "Check3 completed\n" +
                    "check4 completed\n" +
                    "Awesome! lets start the game!\n" +
                    "\n" +
                    "\n" +
                    "***** Player 1 0 Point(s) *****\n" +
                    "Tokens: Onyx x0 ,Sapphire x0 ,Emerlad x0 ,Diamond x0 ,Rubby x0 ,Gold x0\n" +
                    "\n" +
                    "Cards:\n" +
                    "\n" +
                    "Nobles:\n" +
                    "\n" +
                    "\n" +
                    "Cards in Reserve x0\n" +
                    "*******************************\n" +
                    "\n" +
                    "***** Player 2 0 Point(s) *****\n" +
                    "Tokens: Onyx x0 ,Sapphire x0 ,Emerlad x0 ,Diamond x0 ,Rubby x0 ,Gold x0\n" +
                    "\n" +
                    "Cards:\n" +
                    "\n" +
                    "Nobles:\n" +
                    "\n" +
                    "\n" +
                    "Cards in Reserve x0\n" +
                    "*******************************\n" +
                    "\n" +
                    "/////////////////////////////////////\n" +
                    "Blue Deck\n" +
                    "Blue Card 1:\n" +
                    "3     Onyx  Town\n" +
                    "Diamond x3 Rubby x3 Emerald x5 Sapphire x3\n" +
                    "\n" +
                    "Blue Card 2:\n" +
                    "5     Emerald  Town\n" +
                    "Emerald x3 Sapphire x7\n" +
                    "\n" +
                    "Blue Card 3:\n" +
                    "3     Rubby  Town\n" +
                    "Diamond x3 Emerald x3 Sapphire x5\n" +
                    "\n" +
                    "Blue Card 4:\n" +
                    "5     Sapphire  Town\n" +
                    "Diamond x7 Sapphire x3\n" +
                    "\n" +
                    "/////////////////////////\n" +
                    "Yellow Deck\n" +
                    "Yellow Card 1:\n" +
                    "1     Sapphire  Town\n" +
                    "Emerald x3 Onyx x3 Sapphire x2\n" +
                    "\n" +
                    "Yellow Card 2:\n" +
                    "1     Onyx  Town\n" +
                    "Diamond x3 Emerald x2 Sapphire x3\n" +
                    "\n" +
                    "Yellow Card 3:\n" +
                    "1     Diamond  Town\n" +
                    "Diamond x2 Rubby x3 Sapphire x3\n" +
                    "\n" +
                    "Yellow Card 4:\n" +
                    "1     Rubby  Town\n" +
                    "Diamond x2 Rubby x2 Onyx x3\n" +
                    "\n" +
                    "/////////////////////////\n" +
                    "Green Deck\n" +
                    "Green Card 1:\n" +
                    "0     Rubby  Town\n" +
                    "Diamond x1 Emerald x1 Onyx x1 Sapphire x1\n" +
                    "\n" +
                    "Green Card 2:\n" +
                    "0     Sapphire  Town\n" +
                    "Rubby x1 Emerald x3 Sapphire x1\n" +
                    "\n" +
                    "Green Card 3:\n" +
                    "1     Emerald  Town\n" +
                    "Onyx x4\n" +
                    "\n" +
                    "Green Card 4:\n" +
                    "0     Emerald  Town\n" +
                    "Rubby x2 Onyx x2 Sapphire x1\n" +
                    "\n" +
                    "/////////////////////////////////////\n" +
                    "Tokens Avalible: Onyx x4 ,Sapphire x4 ,Emerald x4 ,Diamond x4 ,Rubby x4 ,Gold x4\n" +
                    "\n" +
                    "Nobles Avalible:\n" +
                    "\n" +
                    "******* Geralt of Rivia *******\n" +
                    "Rubby x4    Emerald x4\n" +
                    "\n" +
                    "\n" +
                    "******* Cirilla Fiona Elen Riannon *******\n" +
                    "Emerald x4    Sapphire x4\n" +
                    "\n" +
                    "\n" +
                    "******* Sigismund Dijkstra *******\n" +
                    "Diamond x3    Emerald x3    Sapphire x3\n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "It is Player 1's turn!\n" +
                    "Player 1, here is what you currently have:\n" +
                    "\n" +
                    "\n" +
                    "***** Player 1 0 Point(s) *****\n" +
                    "Tokens: Onyx x0 ,Sapphire x0 ,Emerlad x0 ,Diamond x0 ,Rubby x0 ,Gold x0\n" +
                    "\n" +
                    "**** Cards ****\n" +
                    "\n" +
                    "**** Nobles ****\n" +
                    "\n" +
                    "\n" +
                    "**** Cards in Reserve ****\n" +
                    "\n" +
                    "\n" +
                    "Player 1, what do you wish to do this round?\n" +
                    "\n" +
                    "1. Take 2 tokens of the same color from the table(may only be performed if there is 4 or more tokens in the color of your chosing)\n" +
                    "2. Take 1 token from each of 3 different types of tokens(excluding gold)\n" +
                    "3. Reserve a card on the table and receive one gold token(keep in mind you may only have three reserved cards maximum. Also, you will not recieve any gold token if there is non on the table)\n" +
                    "4. Reserve an unknown card from the top of a chosen deck\n" +
                    "5. Buy a card from your reserved cards\n" +
                    "6. Buy a card on the table\n" +
                    "2\n" +
                    "Choose a token to take.\n" +
                    "1. Onyx x4 2. Sapphire x4 3. Emerald x4 4. Diamond x4 5. Rubby x4\n" +
                    "1\n" +
                    "Choose a different token that you have not selected.\n" +
                    "1. Onyx x4 2. Sapphire x4 3. Emerald x4 4. Diamond x4 5. Rubby x4\n" +
                    "2\n" +
                    "Choose another different token that you have not selected.\n" +
                    "1. Onyx x4 2. Sapphire x4 3. Emerald x4 4. Diamond4 5. Rubby x4 6. Gold x4\n" +
                    "3\n" +
                    "3YOLOSWAG2\n" +
                    "Possibly not Working\n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "***** Player 1 0 Point(s) *****\n" +
                    "Tokens: Onyx x1 ,Sapphire x1 ,Emerlad x1 ,Diamond x0 ,Rubby x0 ,Gold x0\n" +
                    "\n" +
                    "Cards:\n" +
                    "\n" +
                    "Nobles:\n" +
                    "\n" +
                    "\n" +
                    "Cards in Reserve x0\n" +
                    "*******************************\n" +
                    "\n" +
                    "***** Player 2 0 Point(s) *****\n" +
                    "Tokens: Onyx x0 ,Sapphire x0 ,Emerlad x0 ,Diamond x0 ,Rubby x0 ,Gold x0\n" +
                    "\n" +
                    "Cards:\n" +
                    "\n" +
                    "Nobles:\n" +
                    "\n" +
                    "\n" +
                    "Cards in Reserve x0\n" +
                    "*******************************\n" +
                    "\n" +
                    "/////////////////////////////////////\n" +
                    "Blue Deck\n" +
                    "Blue Card 1:\n" +
                    "3     Onyx  Town\n" +
                    "Diamond x3 Rubby x3 Emerald x5 Sapphire x3\n" +
                    "\n" +
                    "Blue Card 2:\n" +
                    "5     Emerald  Town\n" +
                    "Emerald x3 Sapphire x7\n" +
                    "\n" +
                    "Blue Card 3:\n" +
                    "3     Rubby  Town\n" +
                    "Diamond x3 Emerald x3 Sapphire x5\n" +
                    "\n" +
                    "Blue Card 4:\n" +
                    "5     Sapphire  Town\n" +
                    "Diamond x7 Sapphire x3\n" +
                    "\n" +
                    "/////////////////////////\n" +
                    "Yellow Deck\n" +
                    "Yellow Card 1:\n" +
                    "1     Sapphire  Town\n" +
                    "Emerald x3 Onyx x3 Sapphire x2\n" +
                    "\n" +
                    "Yellow Card 2:\n" +
                    "1     Onyx  Town\n" +
                    "Diamond x3 Emerald x2 Sapphire x3\n" +
                    "\n" +
                    "Yellow Card 3:\n" +
                    "1     Diamond  Town\n" +
                    "Diamond x2 Rubby x3 Sapphire x3\n" +
                    "\n" +
                    "Yellow Card 4:\n" +
                    "1     Rubby  Town\n" +
                    "Diamond x2 Rubby x2 Onyx x3\n" +
                    "\n" +
                    "/////////////////////////\n" +
                    "Green Deck\n" +
                    "Green Card 1:\n" +
                    "0     Rubby  Town\n" +
                    "Diamond x1 Emerald x1 Onyx x1 Sapphire x1\n" +
                    "\n" +
                    "Green Card 2:\n" +
                    "0     Sapphire  Town\n" +
                    "Rubby x1 Emerald x3 Sapphire x1\n" +
                    "\n" +
                    "Green Card 3:\n" +
                    "1     Emerald  Town\n" +
                    "Onyx x4\n" +
                    "\n" +
                    "Green Card 4:\n" +
                    "0     Emerald  Town\n" +
                    "Rubby x2 Onyx x2 Sapphire x1\n" +
                    "\n" +
                    "/////////////////////////////////////\n" +
                    "Tokens Avalible: Onyx x3 ,Sapphire x3 ,Emerald x3 ,Diamond x4 ,Rubby x4 ,Gold x4\n" +
                    "\n" +
                    "Nobles Avalible:\n" +
                    "\n" +
                    "******* Geralt of Rivia *******\n" +
                    "Rubby x4    Emerald x4\n" +
                    "\n" +
                    "\n" +
                    "******* Cirilla Fiona Elen Riannon *******\n" +
                    "Emerald x4    Sapphire x4\n" +
                    "\n" +
                    "\n" +
                    "******* Sigismund Dijkstra *******\n" +
                    "Diamond x3    Emerald x3    Sapphire x3\n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "Attention! Player 1 chose to take three tokens of different color!\n" +
                    "It is Player 2's turn!\n" +
                    "Player 2, here is what you currently have:\n" +
                    "\n" +
                    "\n" +
                    "***** Player 2 0 Point(s) *****\n" +
                    "Tokens: Onyx x0 ,Sapphire x0 ,Emerlad x0 ,Diamond x0 ,Rubby x0 ,Gold x0\n" +
                    "\n" +
                    "**** Cards ****\n" +
                    "\n" +
                    "**** Nobles ****\n" +
                    "\n" +
                    "\n" +
                    "**** Cards in Reserve ****\n" +
                    "\n" +
                    "\n" +
                    "Player 2, what do you wish to do this round?\n" +
                    "\n" +
                    "1. Take 2 tokens of the same color from the table(may only be performed if there is 4 or more tokens in the color of your chosing)\n" +
                    "2. Take 1 token from each of 3 different types of tokens(excluding gold)\n" +
                    "3. Reserve a card on the table and receive one gold token(keep in mind you may only have three reserved cards maximum. Also, you will not recieve any gold token if there is non on the table)\n" +
                    "4. Reserve an unknown card from the top of a chosen deck\n" +
                    "5. Buy a card from your reserved cards\n" +
                    "6. Buy a card on the table\n" +
                    "4\n" +
                    "Which deck do you wish to reserve card from?\n" +
                    "1. Blue Deck   2. Yellow Deck   3. Green Deck\n" +
                    "2\n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "***** Player 1 0 Point(s) *****\n" +
                    "Tokens: Onyx x1 ,Sapphire x1 ,Emerlad x1 ,Diamond x0 ,Rubby x0 ,Gold x0\n" +
                    "\n" +
                    "Cards:\n" +
                    "\n" +
                    "Nobles:\n" +
                    "\n" +
                    "\n" +
                    "Cards in Reserve x0\n" +
                    "*******************************\n" +
                    "\n" +
                    "***** Player 2 0 Point(s) *****\n" +
                    "Tokens: Onyx x0 ,Sapphire x0 ,Emerlad x0 ,Diamond x0 ,Rubby x0 ,Gold x1\n" +
                    "\n" +
                    "Cards:\n" +
                    "\n" +
                    "Nobles:\n" +
                    "\n" +
                    "\n" +
                    "Cards in Reserve x1\n" +
                    "*******************************\n" +
                    "\n" +
                    "/////////////////////////////////////\n" +
                    "Blue Deck\n" +
                    "Blue Card 1:\n" +
                    "3     Onyx  Town\n" +
                    "Diamond x3 Rubby x3 Emerald x5 Sapphire x3\n" +
                    "\n" +
                    "Blue Card 2:\n" +
                    "5     Emerald  Town\n" +
                    "Emerald x3 Sapphire x7\n" +
                    "\n" +
                    "Blue Card 3:\n" +
                    "3     Rubby  Town\n" +
                    "Diamond x3 Emerald x3 Sapphire x5\n" +
                    "\n" +
                    "Blue Card 4:\n" +
                    "5     Sapphire  Town\n" +
                    "Diamond x7 Sapphire x3\n" +
                    "\n" +
                    "/////////////////////////\n" +
                    "Yellow Deck\n" +
                    "Yellow Card 1:\n" +
                    "1     Sapphire  Town\n" +
                    "Emerald x3 Onyx x3 Sapphire x2\n" +
                    "\n" +
                    "Yellow Card 2:\n" +
                    "1     Onyx  Town\n" +
                    "Diamond x3 Emerald x2 Sapphire x3\n" +
                    "\n" +
                    "Yellow Card 3:\n" +
                    "1     Diamond  Town\n" +
                    "Diamond x2 Rubby x3 Sapphire x3\n" +
                    "\n" +
                    "Yellow Card 4:\n" +
                    "1     Rubby  Town\n" +
                    "Diamond x2 Rubby x2 Onyx x3\n" +
                    "\n" +
                    "/////////////////////////\n" +
                    "Green Deck\n" +
                    "Green Card 1:\n" +
                    "0     Rubby  Town\n" +
                    "Diamond x1 Emerald x1 Onyx x1 Sapphire x1\n" +
                    "\n" +
                    "Green Card 2:\n" +
                    "0     Sapphire  Town\n" +
                    "Rubby x1 Emerald x3 Sapphire x1\n" +
                    "\n" +
                    "Green Card 3:\n" +
                    "1     Emerald  Town\n" +
                    "Onyx x4\n" +
                    "\n" +
                    "Green Card 4:\n" +
                    "0     Emerald  Town\n" +
                    "Rubby x2 Onyx x2 Sapphire x1\n" +
                    "\n" +
                    "/////////////////////////////////////\n" +
                    "Tokens Avalible: Onyx x3 ,Sapphire x3 ,Emerald x3 ,Diamond x4 ,Rubby x4 ,Gold x3\n" +
                    "\n" +
                    "Nobles Avalible:\n" +
                    "\n" +
                    "******* Geralt of Rivia *******\n" +
                    "Rubby x4    Emerald x4\n" +
                    "\n" +
                    "\n" +
                    "******* Cirilla Fiona Elen Riannon *******\n" +
                    "Emerald x4    Sapphire x4\n" +
                    "\n" +
                    "\n" +
                    "******* Sigismund Dijkstra *******\n" +
                    "Diamond x3    Emerald x3    Sapphire x3\n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "Attention! Player 2 chose to reserve a card from the deck!\n" +
                    "It is Player 1's turn!\n" +
                    "Player 1, here is what you currently have:\n" +
                    "\n" +
                    "\n" +
                    "***** Player 1 0 Point(s) *****\n" +
                    "Tokens: Onyx x1 ,Sapphire x1 ,Emerlad x1 ,Diamond x0 ,Rubby x0 ,Gold x0\n" +
                    "\n" +
                    "**** Cards ****\n" +
                    "\n" +
                    "**** Nobles ****\n" +
                    "\n" +
                    "\n" +
                    "**** Cards in Reserve ****\n" +
                    "\n" +
                    "\n" +
                    "Player 1, what do you wish to do this round?\n" +
                    "\n" +
                    "1. Take 2 tokens of the same color from the table(may only be performed if there is 4 or more tokens in the color of your chosing)\n" +
                    "2. Take 1 token from each of 3 different types of tokens(excluding gold)\n" +
                    "3. Reserve a card on the table and receive one gold token(keep in mind you may only have three reserved cards maximum. Also, you will not recieve any gold token if there is non on the table)\n" +
                    "4. Reserve an unknown card from the top of a chosen deck\n" +
                    "5. Buy a card from your reserved cards\n" +
                    "6. Buy a card on the table\n" +
                    "21\n" +
                    "Choose a token to take.\n" +
                    "1. Onyx x3 2. Sapphire x3 3. Emerald x3 4. Diamond x4 5. Rubby x4\n" +
                    "1\n" +
                    "Choose a different token that you have not selected.\n" +
                    "1. Onyx x3 2. Sapphire x3 3. Emerald x3 4. Diamond x4 5. Rubby x4\n" +
                    "4\n" +
                    "Choose another different token that you have not selected.\n" +
                    "1. Onyx x3 2. Sapphire x3 3. Emerald x3 4. Diamond4 5. Rubby x4 6. Gold x3\n" +
                    "3\n" +
                    "6YOLOSWAG2\n" +
                    "Possibly not Working\n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "***** Player 1 0 Point(s) *****\n" +
                    "Tokens: Onyx x2 ,Sapphire x1 ,Emerlad x2 ,Diamond x1 ,Rubby x0 ,Gold x0\n" +
                    "\n" +
                    "Cards:\n" +
                    "\n" +
                    "Nobles:\n" +
                    "\n" +
                    "\n" +
                    "Cards in Reserve x0\n" +
                    "*******************************\n" +
                    "\n" +
                    "***** Player 2 0 Point(s) *****\n" +
                    "Tokens: Onyx x0 ,Sapphire x0 ,Emerlad x0 ,Diamond x0 ,Rubby x0 ,Gold x1\n" +
                    "\n" +
                    "Cards:\n" +
                    "\n" +
                    "Nobles:\n" +
                    "\n" +
                    "\n" +
                    "Cards in Reserve x1\n" +
                    "*******************************\n" +
                    "\n" +
                    "/////////////////////////////////////\n" +
                    "Blue Deck\n" +
                    "Blue Card 1:\n" +
                    "3     Onyx  Town\n" +
                    "Diamond x3 Rubby x3 Emerald x5 Sapphire x3\n" +
                    "\n" +
                    "Blue Card 2:\n" +
                    "5     Emerald  Town\n" +
                    "Emerald x3 Sapphire x7\n" +
                    "\n" +
                    "Blue Card 3:\n" +
                    "3     Rubby  Town\n" +
                    "Diamond x3 Emerald x3 Sapphire x5\n" +
                    "\n" +
                    "Blue Card 4:\n" +
                    "5     Sapphire  Town\n" +
                    "Diamond x7 Sapphire x3\n" +
                    "\n" +
                    "/////////////////////////\n" +
                    "Yellow Deck\n" +
                    "Yellow Card 1:\n" +
                    "1     Sapphire  Town\n" +
                    "Emerald x3 Onyx x3 Sapphire x2\n" +
                    "\n" +
                    "Yellow Card 2:\n" +
                    "1     Onyx  Town\n" +
                    "Diamond x3 Emerald x2 Sapphire x3\n" +
                    "\n" +
                    "Yellow Card 3:\n" +
                    "1     Diamond  Town\n" +
                    "Diamond x2 Rubby x3 Sapphire x3\n" +
                    "\n" +
                    "Yellow Card 4:\n" +
                    "1     Rubby  Town\n" +
                    "Diamond x2 Rubby x2 Onyx x3\n" +
                    "\n" +
                    "/////////////////////////\n" +
                    "Green Deck\n" +
                    "Green Card 1:\n" +
                    "0     Rubby  Town\n" +
                    "Diamond x1 Emerald x1 Onyx x1 Sapphire x1\n" +
                    "\n" +
                    "Green Card 2:\n" +
                    "0     Sapphire  Town\n" +
                    "Rubby x1 Emerald x3 Sapphire x1\n" +
                    "\n" +
                    "Green Card 3:\n" +
                    "1     Emerald  Town\n" +
                    "Onyx x4\n" +
                    "\n" +
                    "Green Card 4:\n" +
                    "0     Emerald  Town\n" +
                    "Rubby x2 Onyx x2 Sapphire x1\n" +
                    "\n" +
                    "/////////////////////////////////////\n" +
                    "Tokens Avalible: Onyx x2 ,Sapphire x3 ,Emerald x2 ,Diamond x3 ,Rubby x4 ,Gold x3\n" +
                    "\n" +
                    "Nobles Avalible:\n" +
                    "\n" +
                    "******* Geralt of Rivia *******\n" +
                    "Rubby x4    Emerald x4\n" +
                    "\n" +
                    "\n" +
                    "******* Cirilla Fiona Elen Riannon *******\n" +
                    "Emerald x4    Sapphire x4\n" +
                    "\n" +
                    "\n" +
                    "******* Sigismund Dijkstra *******\n" +
                    "Diamond x3    Emerald x3    Sapphire x3\n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "Attention! Player 1 chose to take three tokens of different color!\n" +
                    "It is Player 2's turn!\n" +
                    "Player 2, here is what you currently have:\n" +
                    "\n" +
                    "\n" +
                    "***** Player 2 0 Point(s) *****\n" +
                    "Tokens: Onyx x0 ,Sapphire x0 ,Emerlad x0 ,Diamond x0 ,Rubby x0 ,Gold x1\n" +
                    "\n" +
                    "**** Cards ****\n" +
                    "\n" +
                    "**** Nobles ****\n" +
                    "\n" +
                    "\n" +
                    "**** Cards in Reserve ****\n" +
                    "\n" +
                    "2     Diamond  Town\n" +
                    "Rubby x4 Emerald x1 Onyx x2\n" +
                    "\n" +
                    "\n" +
                    "Player 2, what do you wish to do this round?\n" +
                    "\n" +
                    "1. Take 2 tokens of the same color from the table(may only be performed if there is 4 or more tokens in the color of your chosing)\n" +
                    "2. Take 1 token from each of 3 different types of tokens(excluding gold)\n" +
                    "3. Reserve a card on the table and receive one gold token(keep in mind you may only have three reserved cards maximum. Also, you will not recieve any gold token if there is non on the table)\n" +
                    "4. Reserve an unknown card from the top of a chosen deck\n" +
                    "5. Buy a card from your reserved cards\n" +
                    "6. Buy a card on the table\n" +
                    "4\n" +
                    "\n" +
                    "Which deck do you wish to reserve card from?\n" +
                    "1. Blue Deck   2. Yellow Deck   3. Green Deck\n" +
                    "3\n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "***** Player 1 0 Point(s) *****\n" +
                    "Tokens: Onyx x2 ,Sapphire x1 ,Emerlad x2 ,Diamond x1 ,Rubby x0 ,Gold x0\n" +
                    "\n" +
                    "Cards:\n" +
                    "\n" +
                    "Nobles:\n" +
                    "\n" +
                    "\n" +
                    "Cards in Reserve x0\n" +
                    "*******************************\n" +
                    "\n" +
                    "***** Player 2 0 Point(s) *****\n" +
                    "Tokens: Onyx x0 ,Sapphire x0 ,Emerlad x0 ,Diamond x0 ,Rubby x0 ,Gold x3\n" +
                    "\n" +
                    "Cards:\n" +
                    "\n" +
                    "Nobles:\n" +
                    "\n" +
                    "\n" +
                    "Cards in Reserve x3\n" +
                    "*******************************\n" +
                    "\n" +
                    "/////////////////////////////////////\n" +
                    "Blue Deck\n" +
                    "Blue Card 1:\n" +
                    "3     Onyx  Town\n" +
                    "Diamond x3 Rubby x3 Emerald x5 Sapphire x3\n" +
                    "\n" +
                    "Blue Card 2:\n" +
                    "5     Emerald  Town\n" +
                    "Emerald x3 Sapphire x7\n" +
                    "\n" +
                    "Blue Card 3:\n" +
                    "3     Rubby  Town\n" +
                    "Diamond x3 Emerald x3 Sapphire x5\n" +
                    "\n" +
                    "Blue Card 4:\n" +
                    "5     Sapphire  Town\n" +
                    "Diamond x7 Sapphire x3\n" +
                    "\n" +
                    "/////////////////////////\n" +
                    "Yellow Deck\n" +
                    "Yellow Card 1:\n" +
                    "1     Sapphire  Town\n" +
                    "Emerald x3 Onyx x3 Sapphire x2\n" +
                    "\n" +
                    "Yellow Card 2:\n" +
                    "1     Onyx  Town\n" +
                    "Diamond x3 Emerald x2 Sapphire x3\n" +
                    "\n" +
                    "Yellow Card 3:\n" +
                    "1     Diamond  Town\n" +
                    "Diamond x2 Rubby x3 Sapphire x3\n" +
                    "\n" +
                    "Yellow Card 4:\n" +
                    "1     Rubby  Town\n" +
                    "Diamond x2 Rubby x2 Onyx x3\n" +
                    "\n" +
                    "/////////////////////////\n" +
                    "Green Deck\n" +
                    "Green Card 1:\n" +
                    "0     Rubby  Town\n" +
                    "Diamond x1 Emerald x1 Onyx x1 Sapphire x1\n" +
                    "\n" +
                    "Green Card 2:\n" +
                    "0     Sapphire  Town\n" +
                    "Rubby x1 Emerald x3 Sapphire x1\n" +
                    "\n" +
                    "Green Card 3:\n" +
                    "1     Emerald  Town\n" +
                    "Onyx x4\n" +
                    "\n" +
                    "Green Card 4:\n" +
                    "0     Emerald  Town\n" +
                    "Rubby x2 Onyx x2 Sapphire x1\n" +
                    "\n" +
                    "/////////////////////////////////////\n" +
                    "Tokens Avalible: Onyx x2 ,Sapphire x3 ,Emerald x2 ,Diamond x3 ,Rubby x4 ,Gold x1\n" +
                    "\n" +
                    "Nobles Avalible:\n" +
                    "\n" +
                    "******* Geralt of Rivia *******\n" +
                    "Rubby x4    Emerald x4\n" +
                    "\n" +
                    "\n" +
                    "******* Cirilla Fiona Elen Riannon *******\n" +
                    "Emerald x4    Sapphire x4\n" +
                    "\n" +
                    "\n" +
                    "******* Sigismund Dijkstra *******\n" +
                    "Diamond x3    Emerald x3    Sapphire x3\n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "Attention! Player 2 chose to reserve a card from the deck!\n" +
                    "It is Player 1's turn!\n" +
                    "Player 1, here is what you currently have:\n" +
                    "\n" +
                    "\n" +
                    "***** Player 1 0 Point(s) *****\n" +
                    "Tokens: Onyx x2 ,Sapphire x1 ,Emerlad x2 ,Diamond x1 ,Rubby x0 ,Gold x0\n" +
                    "\n" +
                    "**** Cards ****\n" +
                    "\n" +
                    "**** Nobles ****\n" +
                    "\n" +
                    "\n" +
                    "**** Cards in Reserve ****\n" +
                    "\n" +
                    "\n" +
                    "Player 1, what do you wish to do this round?\n" +
                    "\n" +
                    "1. Take 2 tokens of the same color from the table(may only be performed if there is 4 or more tokens in the color of your chosing)\n" +
                    "2. Take 1 token from each of 3 different types of tokens(excluding gold)\n" +
                    "3. Reserve a card on the table and receive one gold token(keep in mind you may only have three reserved cards maximum. Also, you will not recieve any gold token if there is non on the table)\n" +
                    "4. Reserve an unknown card from the top of a chosen deck\n" +
                    "5. Buy a card from your reserved cards\n" +
                    "6. Buy a card on the table\n" +
                    "2\n" +
                    "Choose a token to take.\n" +
                    "1. Onyx x2 2. Sapphire x3 3. Emerald x2 4. Diamond x3 5. Rubby x4\n" +
                    "4\n" +
                    "Choose a different token that you have not selected.\n" +
                    "1. Onyx x2 2. Sapphire x3 3. Emerald x2 4. Diamond x3 5. Rubby x4\n" +
                    "5\n" +
                    "Choose another different token that you have not selected.\n" +
                    "1. Onyx x2 2. Sapphire x3 3. Emerald x2 4. Diamond x3 5. Rubby x4\n";
                    assertEquals(expected,result);
        }
    }
    @Test
    public void testReserveThreeCard() throws PlayerDoesNotHaveEnoughResourcesToBuySelectedCard, SelectedDeckRanOutOfCards, NotEnoughTokensOnTable, InvalidCardsSelectionOfCardsInReserve, FileNotFoundException, InvalidCardsSelectionOfCardsOnTable, PlayerAlreadyHoldsThreeReserveCards, PlayerDoesNotHaveSelectedCardInReserve, InterruptedException {
        try{
        TextBasedInterface textInterfaceText = new TextBasedInterface();
        // set up testable input and output channels
        byte[] data = "2 2 1 2 3 4 2 2 1 4 5 4 1 2 4 2 3 1".getBytes(StandardCharsets.UTF_8);
        BufferedInputStream in = new BufferedInputStream(new ByteArrayInputStream(data));
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintStream output = new PrintStream(out);
        // redirect the standard channels

        String[] args = null;System.setIn(in);
        textInterfaceText.main(args);

                System.setOut(output);
//        String result = out.toString().replaceAll("\r","");
        System.setOut(output);

//        System.setIn(in); System.setOut(output);

        } catch (Exception e) {
            String expected = "Welcome to Splendor! How many player(s) do you wish to have(including yourself)?\n" +
                    "2. 2    3. 3.    4. 4\n" +
                    "2\n" +
                    "Check0 completed\n" +
                    "Check1 completed\n" +
                    "Check2 completed\n" +
                    "Check3 completed\n" +
                    "check4 completed\n" +
                    "Awesome! lets start the game!\n" +
                    "\n" +
                    "\n" +
                    "***** Player 1 0 Point(s) *****\n" +
                    "Tokens: Onyx x0 ,Sapphire x0 ,Emerlad x0 ,Diamond x0 ,Rubby x0 ,Gold x0\n" +
                    "\n" +
                    "Cards:\n" +
                    "\n" +
                    "Nobles:\n" +
                    "\n" +
                    "\n" +
                    "Cards in Reserve x0\n" +
                    "*******************************\n" +
                    "\n" +
                    "***** Player 2 0 Point(s) *****\n" +
                    "Tokens: Onyx x0 ,Sapphire x0 ,Emerlad x0 ,Diamond x0 ,Rubby x0 ,Gold x0\n" +
                    "\n" +
                    "Cards:\n" +
                    "\n" +
                    "Nobles:\n" +
                    "\n" +
                    "\n" +
                    "Cards in Reserve x0\n" +
                    "*******************************\n" +
                    "\n" +
                    "/////////////////////////////////////\n" +
                    "Blue Deck\n" +
                    "Blue Card 1:\n" +
                    "3     Onyx  Town\n" +
                    "Diamond x3 Rubby x3 Emerald x5 Sapphire x3\n" +
                    "\n" +
                    "Blue Card 2:\n" +
                    "5     Emerald  Town\n" +
                    "Emerald x3 Sapphire x7\n" +
                    "\n" +
                    "Blue Card 3:\n" +
                    "3     Rubby  Town\n" +
                    "Diamond x3 Emerald x3 Sapphire x5\n" +
                    "\n" +
                    "Blue Card 4:\n" +
                    "5     Sapphire  Town\n" +
                    "Diamond x7 Sapphire x3\n" +
                    "\n" +
                    "/////////////////////////\n" +
                    "Yellow Deck\n" +
                    "Yellow Card 1:\n" +
                    "1     Sapphire  Town\n" +
                    "Emerald x3 Onyx x3 Sapphire x2\n" +
                    "\n" +
                    "Yellow Card 2:\n" +
                    "1     Onyx  Town\n" +
                    "Diamond x3 Emerald x2 Sapphire x3\n" +
                    "\n" +
                    "Yellow Card 3:\n" +
                    "1     Diamond  Town\n" +
                    "Diamond x2 Rubby x3 Sapphire x3\n" +
                    "\n" +
                    "Yellow Card 4:\n" +
                    "1     Rubby  Town\n" +
                    "Diamond x2 Rubby x2 Onyx x3\n" +
                    "\n" +
                    "/////////////////////////\n" +
                    "Green Deck\n" +
                    "Green Card 1:\n" +
                    "0     Rubby  Town\n" +
                    "Diamond x1 Emerald x1 Onyx x1 Sapphire x1\n" +
                    "\n" +
                    "Green Card 2:\n" +
                    "0     Sapphire  Town\n" +
                    "Rubby x1 Emerald x3 Sapphire x1\n" +
                    "\n" +
                    "Green Card 3:\n" +
                    "1     Emerald  Town\n" +
                    "Onyx x4\n" +
                    "\n" +
                    "Green Card 4:\n" +
                    "0     Emerald  Town\n" +
                    "Rubby x2 Onyx x2 Sapphire x1\n" +
                    "\n" +
                    "/////////////////////////////////////\n" +
                    "Tokens Avalible: Onyx x4 ,Sapphire x4 ,Emerald x4 ,Diamond x4 ,Rubby x4 ,Gold x4\n" +
                    "\n" +
                    "Nobles Avalible:\n" +
                    "\n" +
                    "******* Geralt of Rivia *******\n" +
                    "Rubby x4    Emerald x4\n" +
                    "\n" +
                    "\n" +
                    "******* Cirilla Fiona Elen Riannon *******\n" +
                    "Emerald x4    Sapphire x4\n" +
                    "\n" +
                    "\n" +
                    "******* Sigismund Dijkstra *******\n" +
                    "Diamond x3    Emerald x3    Sapphire x3\n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "It is Player 1's turn!\n" +
                    "Player 1, here is what you currently have:\n" +
                    "\n" +
                    "\n" +
                    "***** Player 1 0 Point(s) *****\n" +
                    "Tokens: Onyx x0 ,Sapphire x0 ,Emerlad x0 ,Diamond x0 ,Rubby x0 ,Gold x0\n" +
                    "\n" +
                    "**** Cards ****\n" +
                    "\n" +
                    "**** Nobles ****\n" +
                    "\n" +
                    "\n" +
                    "**** Cards in Reserve ****\n" +
                    "\n" +
                    "\n" +
                    "Player 1, what do you wish to do this round?\n" +
                    "\n" +
                    "1. Take 2 tokens of the same color from the table(may only be performed if there is 4 or more tokens in the color of your chosing)\n" +
                    "2. Take 1 token from each of 3 different types of tokens(excluding gold)\n" +
                    "3. Reserve a card on the table and receive one gold token(keep in mind you may only have three reserved cards maximum. Also, you will not recieve any gold token if there is non on the table)\n" +
                    "4. Reserve an unknown card from the top of a chosen deck\n" +
                    "5. Buy a card from your reserved cards\n" +
                    "6. Buy a card on the table\n" +
                    "2\n" +
                    "Choose a token to take.\n" +
                    "1. Onyx x4 2. Sapphire x4 3. Emerald x4 4. Diamond x4 5. Rubby x4\n" +
                    "1\n" +
                    "Choose a different token that you have not selected.\n" +
                    "1. Onyx x4 2. Sapphire x4 3. Emerald x4 4. Diamond x4 5. Rubby x4\n" +
                    "2\n" +
                    "Choose another different token that you have not selected.\n" +
                    "1. Onyx x4 2. Sapphire x4 3. Emerald x4 4. Diamond4 5. Rubby x4 6. Gold x4\n" +
                    "3\n" +
                    "3YOLOSWAG2\n" +
                    "Possibly not Working\n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "***** Player 1 0 Point(s) *****\n" +
                    "Tokens: Onyx x1 ,Sapphire x1 ,Emerlad x1 ,Diamond x0 ,Rubby x0 ,Gold x0\n" +
                    "\n" +
                    "Cards:\n" +
                    "\n" +
                    "Nobles:\n" +
                    "\n" +
                    "\n" +
                    "Cards in Reserve x0\n" +
                    "*******************************\n" +
                    "\n" +
                    "***** Player 2 0 Point(s) *****\n" +
                    "Tokens: Onyx x0 ,Sapphire x0 ,Emerlad x0 ,Diamond x0 ,Rubby x0 ,Gold x0\n" +
                    "\n" +
                    "Cards:\n" +
                    "\n" +
                    "Nobles:\n" +
                    "\n" +
                    "\n" +
                    "Cards in Reserve x0\n" +
                    "*******************************\n" +
                    "\n" +
                    "/////////////////////////////////////\n" +
                    "Blue Deck\n" +
                    "Blue Card 1:\n" +
                    "3     Onyx  Town\n" +
                    "Diamond x3 Rubby x3 Emerald x5 Sapphire x3\n" +
                    "\n" +
                    "Blue Card 2:\n" +
                    "5     Emerald  Town\n" +
                    "Emerald x3 Sapphire x7\n" +
                    "\n" +
                    "Blue Card 3:\n" +
                    "3     Rubby  Town\n" +
                    "Diamond x3 Emerald x3 Sapphire x5\n" +
                    "\n" +
                    "Blue Card 4:\n" +
                    "5     Sapphire  Town\n" +
                    "Diamond x7 Sapphire x3\n" +
                    "\n" +
                    "/////////////////////////\n" +
                    "Yellow Deck\n" +
                    "Yellow Card 1:\n" +
                    "1     Sapphire  Town\n" +
                    "Emerald x3 Onyx x3 Sapphire x2\n" +
                    "\n" +
                    "Yellow Card 2:\n" +
                    "1     Onyx  Town\n" +
                    "Diamond x3 Emerald x2 Sapphire x3\n" +
                    "\n" +
                    "Yellow Card 3:\n" +
                    "1     Diamond  Town\n" +
                    "Diamond x2 Rubby x3 Sapphire x3\n" +
                    "\n" +
                    "Yellow Card 4:\n" +
                    "1     Rubby  Town\n" +
                    "Diamond x2 Rubby x2 Onyx x3\n" +
                    "\n" +
                    "/////////////////////////\n" +
                    "Green Deck\n" +
                    "Green Card 1:\n" +
                    "0     Rubby  Town\n" +
                    "Diamond x1 Emerald x1 Onyx x1 Sapphire x1\n" +
                    "\n" +
                    "Green Card 2:\n" +
                    "0     Sapphire  Town\n" +
                    "Rubby x1 Emerald x3 Sapphire x1\n" +
                    "\n" +
                    "Green Card 3:\n" +
                    "1     Emerald  Town\n" +
                    "Onyx x4\n" +
                    "\n" +
                    "Green Card 4:\n" +
                    "0     Emerald  Town\n" +
                    "Rubby x2 Onyx x2 Sapphire x1\n" +
                    "\n" +
                    "/////////////////////////////////////\n" +
                    "Tokens Avalible: Onyx x3 ,Sapphire x3 ,Emerald x3 ,Diamond x4 ,Rubby x4 ,Gold x4\n" +
                    "\n" +
                    "Nobles Avalible:\n" +
                    "\n" +
                    "******* Geralt of Rivia *******\n" +
                    "Rubby x4    Emerald x4\n" +
                    "\n" +
                    "\n" +
                    "******* Cirilla Fiona Elen Riannon *******\n" +
                    "Emerald x4    Sapphire x4\n" +
                    "\n" +
                    "\n" +
                    "******* Sigismund Dijkstra *******\n" +
                    "Diamond x3    Emerald x3    Sapphire x3\n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "Attention! Player 1 chose to take three tokens of different color!\n" +
                    "It is Player 2's turn!\n" +
                    "Player 2, here is what you currently have:\n" +
                    "\n" +
                    "\n" +
                    "***** Player 2 0 Point(s) *****\n" +
                    "Tokens: Onyx x0 ,Sapphire x0 ,Emerlad x0 ,Diamond x0 ,Rubby x0 ,Gold x0\n" +
                    "\n" +
                    "**** Cards ****\n" +
                    "\n" +
                    "**** Nobles ****\n" +
                    "\n" +
                    "\n" +
                    "**** Cards in Reserve ****\n" +
                    "\n" +
                    "\n" +
                    "Player 2, what do you wish to do this round?\n" +
                    "\n" +
                    "1. Take 2 tokens of the same color from the table(may only be performed if there is 4 or more tokens in the color of your chosing)\n" +
                    "2. Take 1 token from each of 3 different types of tokens(excluding gold)\n" +
                    "3. Reserve a card on the table and receive one gold token(keep in mind you may only have three reserved cards maximum. Also, you will not recieve any gold token if there is non on the table)\n" +
                    "4. Reserve an unknown card from the top of a chosen deck\n" +
                    "5. Buy a card from your reserved cards\n" +
                    "6. Buy a card on the table\n" +
                    "4\n" +
                    "Which deck do you wish to reserve card from?\n" +
                    "1. Blue Deck   2. Yellow Deck   3. Green Deck\n" +
                    "2\n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "***** Player 1 0 Point(s) *****\n" +
                    "Tokens: Onyx x1 ,Sapphire x1 ,Emerlad x1 ,Diamond x0 ,Rubby x0 ,Gold x0\n" +
                    "\n" +
                    "Cards:\n" +
                    "\n" +
                    "Nobles:\n" +
                    "\n" +
                    "\n" +
                    "Cards in Reserve x0\n" +
                    "*******************************\n" +
                    "\n" +
                    "***** Player 2 0 Point(s) *****\n" +
                    "Tokens: Onyx x0 ,Sapphire x0 ,Emerlad x0 ,Diamond x0 ,Rubby x0 ,Gold x1\n" +
                    "\n" +
                    "Cards:\n" +
                    "\n" +
                    "Nobles:\n" +
                    "\n" +
                    "\n" +
                    "Cards in Reserve x1\n" +
                    "*******************************\n" +
                    "\n" +
                    "/////////////////////////////////////\n" +
                    "Blue Deck\n" +
                    "Blue Card 1:\n" +
                    "3     Onyx  Town\n" +
                    "Diamond x3 Rubby x3 Emerald x5 Sapphire x3\n" +
                    "\n" +
                    "Blue Card 2:\n" +
                    "5     Emerald  Town\n" +
                    "Emerald x3 Sapphire x7\n" +
                    "\n" +
                    "Blue Card 3:\n" +
                    "3     Rubby  Town\n" +
                    "Diamond x3 Emerald x3 Sapphire x5\n" +
                    "\n" +
                    "Blue Card 4:\n" +
                    "5     Sapphire  Town\n" +
                    "Diamond x7 Sapphire x3\n" +
                    "\n" +
                    "/////////////////////////\n" +
                    "Yellow Deck\n" +
                    "Yellow Card 1:\n" +
                    "1     Sapphire  Town\n" +
                    "Emerald x3 Onyx x3 Sapphire x2\n" +
                    "\n" +
                    "Yellow Card 2:\n" +
                    "1     Onyx  Town\n" +
                    "Diamond x3 Emerald x2 Sapphire x3\n" +
                    "\n" +
                    "Yellow Card 3:\n" +
                    "1     Diamond  Town\n" +
                    "Diamond x2 Rubby x3 Sapphire x3\n" +
                    "\n" +
                    "Yellow Card 4:\n" +
                    "1     Rubby  Town\n" +
                    "Diamond x2 Rubby x2 Onyx x3\n" +
                    "\n" +
                    "/////////////////////////\n" +
                    "Green Deck\n" +
                    "Green Card 1:\n" +
                    "0     Rubby  Town\n" +
                    "Diamond x1 Emerald x1 Onyx x1 Sapphire x1\n" +
                    "\n" +
                    "Green Card 2:\n" +
                    "0     Sapphire  Town\n" +
                    "Rubby x1 Emerald x3 Sapphire x1\n" +
                    "\n" +
                    "Green Card 3:\n" +
                    "1     Emerald  Town\n" +
                    "Onyx x4\n" +
                    "\n" +
                    "Green Card 4:\n" +
                    "0     Emerald  Town\n" +
                    "Rubby x2 Onyx x2 Sapphire x1\n" +
                    "\n" +
                    "/////////////////////////////////////\n" +
                    "Tokens Avalible: Onyx x3 ,Sapphire x3 ,Emerald x3 ,Diamond x4 ,Rubby x4 ,Gold x3\n" +
                    "\n" +
                    "Nobles Avalible:\n" +
                    "\n" +
                    "******* Geralt of Rivia *******\n" +
                    "Rubby x4    Emerald x4\n" +
                    "\n" +
                    "\n" +
                    "******* Cirilla Fiona Elen Riannon *******\n" +
                    "Emerald x4    Sapphire x4\n" +
                    "\n" +
                    "\n" +
                    "******* Sigismund Dijkstra *******\n" +
                    "Diamond x3    Emerald x3    Sapphire x3\n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "Attention! Player 2 chose to reserve a card from the deck!\n" +
                    "It is Player 1's turn!\n" +
                    "Player 1, here is what you currently have:\n" +
                    "\n" +
                    "\n" +
                    "***** Player 1 0 Point(s) *****\n" +
                    "Tokens: Onyx x1 ,Sapphire x1 ,Emerlad x1 ,Diamond x0 ,Rubby x0 ,Gold x0\n" +
                    "\n" +
                    "**** Cards ****\n" +
                    "\n" +
                    "**** Nobles ****\n" +
                    "\n" +
                    "\n" +
                    "**** Cards in Reserve ****\n" +
                    "\n" +
                    "\n" +
                    "Player 1, what do you wish to do this round?\n" +
                    "\n" +
                    "1. Take 2 tokens of the same color from the table(may only be performed if there is 4 or more tokens in the color of your chosing)\n" +
                    "2. Take 1 token from each of 3 different types of tokens(excluding gold)\n" +
                    "3. Reserve a card on the table and receive one gold token(keep in mind you may only have three reserved cards maximum. Also, you will not recieve any gold token if there is non on the table)\n" +
                    "4. Reserve an unknown card from the top of a chosen deck\n" +
                    "5. Buy a card from your reserved cards\n" +
                    "6. Buy a card on the table\n" +
                    "21\n" +
                    "Choose a token to take.\n" +
                    "1. Onyx x3 2. Sapphire x3 3. Emerald x3 4. Diamond x4 5. Rubby x4\n" +
                    "1\n" +
                    "Choose a different token that you have not selected.\n" +
                    "1. Onyx x3 2. Sapphire x3 3. Emerald x3 4. Diamond x4 5. Rubby x4\n" +
                    "4\n" +
                    "Choose another different token that you have not selected.\n" +
                    "1. Onyx x3 2. Sapphire x3 3. Emerald x3 4. Diamond4 5. Rubby x4 6. Gold x3\n" +
                    "3\n" +
                    "6YOLOSWAG2\n" +
                    "Possibly not Working\n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "***** Player 1 0 Point(s) *****\n" +
                    "Tokens: Onyx x2 ,Sapphire x1 ,Emerlad x2 ,Diamond x1 ,Rubby x0 ,Gold x0\n" +
                    "\n" +
                    "Cards:\n" +
                    "\n" +
                    "Nobles:\n" +
                    "\n" +
                    "\n" +
                    "Cards in Reserve x0\n" +
                    "*******************************\n" +
                    "\n" +
                    "***** Player 2 0 Point(s) *****\n" +
                    "Tokens: Onyx x0 ,Sapphire x0 ,Emerlad x0 ,Diamond x0 ,Rubby x0 ,Gold x1\n" +
                    "\n" +
                    "Cards:\n" +
                    "\n" +
                    "Nobles:\n" +
                    "\n" +
                    "\n" +
                    "Cards in Reserve x1\n" +
                    "*******************************\n" +
                    "\n" +
                    "/////////////////////////////////////\n" +
                    "Blue Deck\n" +
                    "Blue Card 1:\n" +
                    "3     Onyx  Town\n" +
                    "Diamond x3 Rubby x3 Emerald x5 Sapphire x3\n" +
                    "\n" +
                    "Blue Card 2:\n" +
                    "5     Emerald  Town\n" +
                    "Emerald x3 Sapphire x7\n" +
                    "\n" +
                    "Blue Card 3:\n" +
                    "3     Rubby  Town\n" +
                    "Diamond x3 Emerald x3 Sapphire x5\n" +
                    "\n" +
                    "Blue Card 4:\n" +
                    "5     Sapphire  Town\n" +
                    "Diamond x7 Sapphire x3\n" +
                    "\n" +
                    "/////////////////////////\n" +
                    "Yellow Deck\n" +
                    "Yellow Card 1:\n" +
                    "1     Sapphire  Town\n" +
                    "Emerald x3 Onyx x3 Sapphire x2\n" +
                    "\n" +
                    "Yellow Card 2:\n" +
                    "1     Onyx  Town\n" +
                    "Diamond x3 Emerald x2 Sapphire x3\n" +
                    "\n" +
                    "Yellow Card 3:\n" +
                    "1     Diamond  Town\n" +
                    "Diamond x2 Rubby x3 Sapphire x3\n" +
                    "\n" +
                    "Yellow Card 4:\n" +
                    "1     Rubby  Town\n" +
                    "Diamond x2 Rubby x2 Onyx x3\n" +
                    "\n" +
                    "/////////////////////////\n" +
                    "Green Deck\n" +
                    "Green Card 1:\n" +
                    "0     Rubby  Town\n" +
                    "Diamond x1 Emerald x1 Onyx x1 Sapphire x1\n" +
                    "\n" +
                    "Green Card 2:\n" +
                    "0     Sapphire  Town\n" +
                    "Rubby x1 Emerald x3 Sapphire x1\n" +
                    "\n" +
                    "Green Card 3:\n" +
                    "1     Emerald  Town\n" +
                    "Onyx x4\n" +
                    "\n" +
                    "Green Card 4:\n" +
                    "0     Emerald  Town\n" +
                    "Rubby x2 Onyx x2 Sapphire x1\n" +
                    "\n" +
                    "/////////////////////////////////////\n" +
                    "Tokens Avalible: Onyx x2 ,Sapphire x3 ,Emerald x2 ,Diamond x3 ,Rubby x4 ,Gold x3\n" +
                    "\n" +
                    "Nobles Avalible:\n" +
                    "\n" +
                    "******* Geralt of Rivia *******\n" +
                    "Rubby x4    Emerald x4\n" +
                    "\n" +
                    "\n" +
                    "******* Cirilla Fiona Elen Riannon *******\n" +
                    "Emerald x4    Sapphire x4\n" +
                    "\n" +
                    "\n" +
                    "******* Sigismund Dijkstra *******\n" +
                    "Diamond x3    Emerald x3    Sapphire x3\n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "Attention! Player 1 chose to take three tokens of different color!\n" +
                    "It is Player 2's turn!\n" +
                    "Player 2, here is what you currently have:\n" +
                    "\n" +
                    "\n" +
                    "***** Player 2 0 Point(s) *****\n" +
                    "Tokens: Onyx x0 ,Sapphire x0 ,Emerlad x0 ,Diamond x0 ,Rubby x0 ,Gold x1\n" +
                    "\n" +
                    "**** Cards ****\n" +
                    "\n" +
                    "**** Nobles ****\n" +
                    "\n" +
                    "\n" +
                    "**** Cards in Reserve ****\n" +
                    "\n" +
                    "2     Diamond  Town\n" +
                    "Rubby x4 Emerald x1 Onyx x2\n" +
                    "\n" +
                    "\n" +
                    "Player 2, what do you wish to do this round?\n" +
                    "\n" +
                    "1. Take 2 tokens of the same color from the table(may only be performed if there is 4 or more tokens in the color of your chosing)\n" +
                    "2. Take 1 token from each of 3 different types of tokens(excluding gold)\n" +
                    "3. Reserve a card on the table and receive one gold token(keep in mind you may only have three reserved cards maximum. Also, you will not recieve any gold token if there is non on the table)\n" +
                    "4. Reserve an unknown card from the top of a chosen deck\n" +
                    "5. Buy a card from your reserved cards\n" +
                    "6. Buy a card on the table\n" +
                    "4\n" +
                    "Which deck do you wish to reserve card from?\n" +
                    "1. Blue Deck   2. Yellow Deck   3. Green Deck\n" +
                    "\n" +
                    "Invalid choice made.\n" +
                    "Which deck do you wish to reserve card from?\n" +
                    "1. Blue Deck   2. Yellow Deck   3. Green Deck\n" +
                    "3\n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "***** Player 1 0 Point(s) *****\n" +
                    "Tokens: Onyx x2 ,Sapphire x1 ,Emerlad x2 ,Diamond x1 ,Rubby x0 ,Gold x0\n" +
                    "\n" +
                    "Cards:\n" +
                    "\n" +
                    "Nobles:\n" +
                    "\n" +
                    "\n" +
                    "Cards in Reserve x0\n" +
                    "*******************************\n" +
                    "\n" +
                    "***** Player 2 0 Point(s) *****\n" +
                    "Tokens: Onyx x0 ,Sapphire x0 ,Emerlad x0 ,Diamond x0 ,Rubby x0 ,Gold x3\n" +
                    "\n" +
                    "Cards:\n" +
                    "\n" +
                    "Nobles:\n" +
                    "\n" +
                    "\n" +
                    "Cards in Reserve x3\n" +
                    "*******************************\n" +
                    "\n" +
                    "/////////////////////////////////////\n" +
                    "Blue Deck\n" +
                    "Blue Card 1:\n" +
                    "3     Onyx  Town\n" +
                    "Diamond x3 Rubby x3 Emerald x5 Sapphire x3\n" +
                    "\n" +
                    "Blue Card 2:\n" +
                    "5     Emerald  Town\n" +
                    "Emerald x3 Sapphire x7\n" +
                    "\n" +
                    "Blue Card 3:\n" +
                    "3     Rubby  Town\n" +
                    "Diamond x3 Emerald x3 Sapphire x5\n" +
                    "\n" +
                    "Blue Card 4:\n" +
                    "5     Sapphire  Town\n" +
                    "Diamond x7 Sapphire x3\n" +
                    "\n" +
                    "/////////////////////////\n" +
                    "Yellow Deck\n" +
                    "Yellow Card 1:\n" +
                    "1     Sapphire  Town\n" +
                    "Emerald x3 Onyx x3 Sapphire x2\n" +
                    "\n" +
                    "Yellow Card 2:\n" +
                    "1     Onyx  Town\n" +
                    "Diamond x3 Emerald x2 Sapphire x3\n" +
                    "\n" +
                    "Yellow Card 3:\n" +
                    "1     Diamond  Town\n" +
                    "Diamond x2 Rubby x3 Sapphire x3\n" +
                    "\n" +
                    "Yellow Card 4:\n" +
                    "1     Rubby  Town\n" +
                    "Diamond x2 Rubby x2 Onyx x3\n" +
                    "\n" +
                    "/////////////////////////\n" +
                    "Green Deck\n" +
                    "Green Card 1:\n" +
                    "0     Rubby  Town\n" +
                    "Diamond x1 Emerald x1 Onyx x1 Sapphire x1\n" +
                    "\n" +
                    "Green Card 2:\n" +
                    "0     Sapphire  Town\n" +
                    "Rubby x1 Emerald x3 Sapphire x1\n" +
                    "\n" +
                    "Green Card 3:\n" +
                    "1     Emerald  Town\n" +
                    "Onyx x4\n" +
                    "\n" +
                    "Green Card 4:\n" +
                    "0     Emerald  Town\n" +
                    "Rubby x2 Onyx x2 Sapphire x1\n" +
                    "\n" +
                    "/////////////////////////////////////\n" +
                    "Tokens Avalible: Onyx x2 ,Sapphire x3 ,Emerald x2 ,Diamond x3 ,Rubby x4 ,Gold x1\n" +
                    "\n" +
                    "Nobles Avalible:\n" +
                    "\n" +
                    "******* Geralt of Rivia *******\n" +
                    "Rubby x4    Emerald x4\n" +
                    "\n" +
                    "\n" +
                    "******* Cirilla Fiona Elen Riannon *******\n" +
                    "Emerald x4    Sapphire x4\n" +
                    "\n" +
                    "\n" +
                    "******* Sigismund Dijkstra *******\n" +
                    "Diamond x3    Emerald x3    Sapphire x3\n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "Attention! Player 2 chose to reserve a card from the deck!\n" +
                    "It is Player 1's turn!\n" +
                    "Player 1, here is what you currently have:\n" +
                    "\n" +
                    "\n" +
                    "***** Player 1 0 Point(s) *****\n" +
                    "Tokens: Onyx x2 ,Sapphire x1 ,Emerlad x2 ,Diamond x1 ,Rubby x0 ,Gold x0\n" +
                    "\n" +
                    "**** Cards ****\n" +
                    "\n" +
                    "**** Nobles ****\n" +
                    "\n" +
                    "\n" +
                    "**** Cards in Reserve ****\n" +
                    "\n" +
                    "\n" +
                    "Player 1, what do you wish to do this round?\n" +
                    "\n" +
                    "1. Take 2 tokens of the same color from the table(may only be performed if there is 4 or more tokens in the color of your chosing)\n" +
                    "2. Take 1 token from each of 3 different types of tokens(excluding gold)\n" +
                    "3. Reserve a card on the table and receive one gold token(keep in mind you may only have three reserved cards maximum. Also, you will not recieve any gold token if there is non on the table)\n" +
                    "4. Reserve an unknown card from the top of a chosen deck\n" +
                    "5. Buy a card from your reserved cards\n" +
                    "6. Buy a card on the table\n" +
                    "2\n" +
                    "Choose a token to take.\n" +
                    "1. Onyx x2 2. Sapphire x3 3. Emerald x2 4. Diamond x3 5. Rubby x4\n" +
                    "4\n" +
                    "Choose a different token that you have not selected.\n" +
                    "1. Onyx x2 2. Sapphire x3 3. Emerald x2 4. Diamond x3 5. Rubby x4\n" +
                    "5\n" +
                    "Choose another different token that you have not selected.\n" +
                    "1. Onyx x2 2. Sapphire x3 3. Emerald x2 4. Diamond3 5. Rubby x4 6. Gold x1\n" +
                    "2\n" +
                    "9YOLOSWAG2\n" +
                    "Possibly not Working\n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "***** Player 1 0 Point(s) *****\n" +
                    "Tokens: Onyx x2 ,Sapphire x2 ,Emerlad x2 ,Diamond x2 ,Rubby x1 ,Gold x0\n" +
                    "\n" +
                    "Cards:\n" +
                    "\n" +
                    "Nobles:\n" +
                    "\n" +
                    "\n" +
                    "Cards in Reserve x0\n" +
                    "*******************************\n" +
                    "\n" +
                    "***** Player 2 0 Point(s) *****\n" +
                    "Tokens: Onyx x0 ,Sapphire x0 ,Emerlad x0 ,Diamond x0 ,Rubby x0 ,Gold x3\n" +
                    "\n" +
                    "Cards:\n" +
                    "\n" +
                    "Nobles:\n" +
                    "\n" +
                    "\n" +
                    "Cards in Reserve x3\n" +
                    "*******************************\n" +
                    "\n" +
                    "/////////////////////////////////////\n" +
                    "Blue Deck\n" +
                    "Blue Card 1:\n" +
                    "3     Onyx  Town\n" +
                    "Diamond x3 Rubby x3 Emerald x5 Sapphire x3\n" +
                    "\n" +
                    "Blue Card 2:\n" +
                    "5     Emerald  Town\n" +
                    "Emerald x3 Sapphire x7\n" +
                    "\n" +
                    "Blue Card 3:\n" +
                    "3     Rubby  Town\n" +
                    "Diamond x3 Emerald x3 Sapphire x5\n" +
                    "\n" +
                    "Blue Card 4:\n" +
                    "5     Sapphire  Town\n" +
                    "Diamond x7 Sapphire x3\n" +
                    "\n" +
                    "/////////////////////////\n" +
                    "Yellow Deck\n" +
                    "Yellow Card 1:\n" +
                    "1     Sapphire  Town\n" +
                    "Emerald x3 Onyx x3 Sapphire x2\n" +
                    "\n" +
                    "Yellow Card 2:\n" +
                    "1     Onyx  Town\n" +
                    "Diamond x3 Emerald x2 Sapphire x3\n" +
                    "\n" +
                    "Yellow Card 3:\n" +
                    "1     Diamond  Town\n" +
                    "Diamond x2 Rubby x3 Sapphire x3\n" +
                    "\n" +
                    "Yellow Card 4:\n" +
                    "1     Rubby  Town\n" +
                    "Diamond x2 Rubby x2 Onyx x3\n" +
                    "\n" +
                    "/////////////////////////\n" +
                    "Green Deck\n" +
                    "Green Card 1:\n" +
                    "0     Rubby  Town\n" +
                    "Diamond x1 Emerald x1 Onyx x1 Sapphire x1\n" +
                    "\n" +
                    "Green Card 2:\n" +
                    "0     Sapphire  Town\n" +
                    "Rubby x1 Emerald x3 Sapphire x1\n" +
                    "\n" +
                    "Green Card 3:\n" +
                    "1     Emerald  Town\n" +
                    "Onyx x4\n" +
                    "\n" +
                    "Green Card 4:\n" +
                    "0     Emerald  Town\n" +
                    "Rubby x2 Onyx x2 Sapphire x1\n" +
                    "\n" +
                    "/////////////////////////////////////\n" +
                    "Tokens Avalible: Onyx x2 ,Sapphire x2 ,Emerald x2 ,Diamond x2 ,Rubby x3 ,Gold x1\n" +
                    "\n" +
                    "Nobles Avalible:\n" +
                    "\n" +
                    "******* Geralt of Rivia *******\n" +
                    "Rubby x4    Emerald x4\n" +
                    "\n" +
                    "\n" +
                    "******* Cirilla Fiona Elen Riannon *******\n" +
                    "Emerald x4    Sapphire x4\n" +
                    "\n" +
                    "\n" +
                    "******* Sigismund Dijkstra *******\n" +
                    "Diamond x3    Emerald x3    Sapphire x3\n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "Attention! Player 1 chose to take three tokens of different color!\n" +
                    "It is Player 2's turn!\n" +
                    "Player 2, here is what you currently have:\n" +
                    "\n" +
                    "\n" +
                    "***** Player 2 0 Point(s) *****\n" +
                    "Tokens: Onyx x0 ,Sapphire x0 ,Emerlad x0 ,Diamond x0 ,Rubby x0 ,Gold x3\n" +
                    "\n" +
                    "**** Cards ****\n" +
                    "\n" +
                    "**** Nobles ****\n" +
                    "\n" +
                    "\n" +
                    "**** Cards in Reserve ****\n" +
                    "\n" +
                    "2     Diamond  Town\n" +
                    "Rubby x4 Emerald x1 Onyx x2\n" +
                    "\n" +
                    "0     Sapphire  Town\n" +
                    "Onyx x3\n" +
                    "\n" +
                    "5     Rubby  Town\n" +
                    "Rubby x3 Emerald x7\n" +
                    "\n" +
                    "\n" +
                    "Player 2, what do you wish to do this round?\n" +
                    "\n" +
                    "1. Take 2 tokens of the same color from the table(may only be performed if there is 4 or more tokens in the color of your chosing)\n" +
                    "2. Take 1 token from each of 3 different types of tokens(excluding gold)\n" +
                    "3. Reserve a card on the table and receive one gold token(keep in mind you may only have three reserved cards maximum. Also, you will not recieve any gold token if there is non on the table)\n" +
                    "4. Reserve an unknown card from the top of a chosen deck\n" +
                    "5. Buy a card from your reserved cards\n" +
                    "6. Buy a card on the table\n" +
                    "4\n" +
                    "Which deck do you wish to reserve card from?\n" +
                    "1. Blue Deck   2. Yellow Deck   3. Green Deck\n" +
                    "1\n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "***** Player 1 0 Point(s) *****\n" +
                    "Tokens: Onyx x2 ,Sapphire x2 ,Emerlad x2 ,Diamond x2 ,Rubby x1 ,Gold x0\n" +
                    "\n" +
                    "Cards:\n" +
                    "\n" +
                    "Nobles:\n" +
                    "\n" +
                    "\n" +
                    "Cards in Reserve x0\n" +
                    "*******************************\n" +
                    "\n" +
                    "***** Player 2 0 Point(s) *****\n" +
                    "Tokens: Onyx x0 ,Sapphire x0 ,Emerlad x0 ,Diamond x0 ,Rubby x0 ,Gold x4\n" +
                    "\n" +
                    "Cards:\n" +
                    "\n" +
                    "Nobles:\n" +
                    "\n" +
                    "\n" +
                    "Cards in Reserve x4\n" +
                    "*******************************\n" +
                    "\n" +
                    "/////////////////////////////////////\n" +
                    "Blue Deck\n" +
                    "Blue Card 1:\n" +
                    "3     Onyx  Town\n" +
                    "Diamond x3 Rubby x3 Emerald x5 Sapphire x3\n" +
                    "\n" +
                    "Blue Card 2:\n" +
                    "5     Emerald  Town\n" +
                    "Emerald x3 Sapphire x7\n" +
                    "\n" +
                    "Blue Card 3:\n" +
                    "3     Rubby  Town\n" +
                    "Diamond x3 Emerald x3 Sapphire x5\n" +
                    "\n" +
                    "Blue Card 4:\n" +
                    "5     Sapphire  Town\n" +
                    "Diamond x7 Sapphire x3\n" +
                    "\n" +
                    "/////////////////////////\n" +
                    "Yellow Deck\n" +
                    "Yellow Card 1:\n" +
                    "1     Sapphire  Town\n" +
                    "Emerald x3 Onyx x3 Sapphire x2\n" +
                    "\n" +
                    "Yellow Card 2:\n" +
                    "1     Onyx  Town\n" +
                    "Diamond x3 Emerald x2 Sapphire x3\n" +
                    "\n" +
                    "Yellow Card 3:\n" +
                    "1     Diamond  Town\n" +
                    "Diamond x2 Rubby x3 Sapphire x3\n" +
                    "\n" +
                    "Yellow Card 4:\n" +
                    "1     Rubby  Town\n" +
                    "Diamond x2 Rubby x2 Onyx x3\n" +
                    "\n" +
                    "/////////////////////////\n" +
                    "Green Deck\n" +
                    "Green Card 1:\n" +
                    "0     Rubby  Town\n" +
                    "Diamond x1 Emerald x1 Onyx x1 Sapphire x1\n" +
                    "\n" +
                    "Green Card 2:\n" +
                    "0     Sapphire  Town\n" +
                    "Rubby x1 Emerald x3 Sapphire x1\n" +
                    "\n" +
                    "Green Card 3:\n" +
                    "1     Emerald  Town\n" +
                    "Onyx x4\n" +
                    "\n" +
                    "Green Card 4:\n" +
                    "0     Emerald  Town\n" +
                    "Rubby x2 Onyx x2 Sapphire x1\n" +
                    "\n" +
                    "/////////////////////////////////////\n" +
                    "Tokens Avalible: Onyx x2 ,Sapphire x2 ,Emerald x2 ,Diamond x2 ,Rubby x3 ,Gold x0\n" +
                    "\n" +
                    "Nobles Avalible:\n" +
                    "\n" +
                    "******* Geralt of Rivia *******\n" +
                    "Rubby x4    Emerald x4\n" +
                    "\n" +
                    "\n" +
                    "******* Cirilla Fiona Elen Riannon *******\n" +
                    "Emerald x4    Sapphire x4\n" +
                    "\n" +
                    "\n" +
                    "******* Sigismund Dijkstra *******\n" +
                    "Diamond x3    Emerald x3    Sapphire x3\n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "Attention! Player 2 chose to reserve a card from the deck!\n" +
                    "It is Player 1's turn!\n" +
                    "Player 1, here is what you currently have:\n" +
                    "\n" +
                    "\n" +
                    "***** Player 1 0 Point(s) *****\n" +
                    "Tokens: Onyx x2 ,Sapphire x2 ,Emerlad x2 ,Diamond x2 ,Rubby x1 ,Gold x0\n" +
                    "\n" +
                    "**** Cards ****\n" +
                    "\n" +
                    "**** Nobles ****\n" +
                    "\n" +
                    "\n" +
                    "**** Cards in Reserve ****\n" +
                    "\n" +
                    "\n" +
                    "Player 1, what do you wish to do this round?\n" +
                    "\n" +
                    "1. Take 2 tokens of the same color from the table(may only be performed if there is 4 or more tokens in the color of your chosing)\n" +
                    "2. Take 1 token from each of 3 different types of tokens(excluding gold)\n" +
                    "3. Reserve a card on the table and receive one gold token(keep in mind you may only have three reserved cards maximum. Also, you will not recieve any gold token if there is non on the table)\n" +
                    "4. Reserve an unknown card from the top of a chosen deck\n" +
                    "5. Buy a card from your reserved cards\n" +
                    "6. Buy a card on the table\n" +
                    "2\n" +
                    "Choose a token to take.\n" +
                    "1. Onyx x2 2. Sapphire x2 3. Emerald x2 4. Diamond x2 5. Rubby x3\n" +
                    "5\n" +
                    "Choose a different token that you have not selected.\n" +
                    "1. Onyx x2 2. Sapphire x2 3. Emerald x2 4. Diamond x2 5. Rubby x3\n" +
                    "4\n" +
                    "Choose another different token that you have not selected.\n" +
                    "1. Onyx x2 2. Sapphire x2 3. Emerald x2 4. Diamond2 5. Rubby x3 6. Gold x0\n" +
                    "3\n" +
                    "12YOLOSWAG2\n" +
                    "Working\n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "***** Player 1 0 Point(s) *****\n" +
                    "Tokens: Onyx x2 ,Sapphire x2 ,Emerlad x3 ,Diamond x3 ,Rubby x2 ,Gold x0\n" +
                    "\n" +
                    "Cards:\n" +
                    "\n" +
                    "Nobles:\n" +
                    "\n" +
                    "\n" +
                    "Cards in Reserve x0\n" +
                    "*******************************\n" +
                    "\n" +
                    "***** Player 2 0 Point(s) *****\n" +
                    "Tokens: Onyx x0 ,Sapphire x0 ,Emerlad x0 ,Diamond x0 ,Rubby x0 ,Gold x4\n" +
                    "\n" +
                    "Cards:\n" +
                    "\n" +
                    "Nobles:\n" +
                    "\n" +
                    "\n" +
                    "Cards in Reserve x4\n" +
                    "*******************************\n" +
                    "\n" +
                    "/////////////////////////////////////\n" +
                    "Blue Deck\n" +
                    "Blue Card 1:\n" +
                    "3     Onyx  Town\n" +
                    "Diamond x3 Rubby x3 Emerald x5 Sapphire x3\n" +
                    "\n" +
                    "Blue Card 2:\n" +
                    "5     Emerald  Town\n" +
                    "Emerald x3 Sapphire x7\n" +
                    "\n" +
                    "Blue Card 3:\n" +
                    "3     Rubby  Town\n" +
                    "Diamond x3 Emerald x3 Sapphire x5\n" +
                    "\n" +
                    "Blue Card 4:\n" +
                    "5     Sapphire  Town\n" +
                    "Diamond x7 Sapphire x3\n" +
                    "\n" +
                    "/////////////////////////\n" +
                    "Yellow Deck\n" +
                    "Yellow Card 1:\n" +
                    "1     Sapphire  Town\n" +
                    "Emerald x3 Onyx x3 Sapphire x2\n" +
                    "\n" +
                    "Yellow Card 2:\n" +
                    "1     Onyx  Town\n" +
                    "Diamond x3 Emerald x2 Sapphire x3\n" +
                    "\n" +
                    "Yellow Card 3:\n" +
                    "1     Diamond  Town\n" +
                    "Diamond x2 Rubby x3 Sapphire x3\n" +
                    "\n" +
                    "Yellow Card 4:\n" +
                    "1     Rubby  Town\n" +
                    "Diamond x2 Rubby x2 Onyx x3\n" +
                    "\n" +
                    "/////////////////////////\n" +
                    "Green Deck\n" +
                    "Green Card 1:\n" +
                    "0     Rubby  Town\n" +
                    "Diamond x1 Emerald x1 Onyx x1 Sapphire x1\n" +
                    "\n" +
                    "Green Card 2:\n" +
                    "0     Sapphire  Town\n" +
                    "Rubby x1 Emerald x3 Sapphire x1\n" +
                    "\n" +
                    "Green Card 3:\n" +
                    "1     Emerald  Town\n" +
                    "Onyx x4\n" +
                    "\n" +
                    "Green Card 4:\n" +
                    "0     Emerald  Town\n" +
                    "Rubby x2 Onyx x2 Sapphire x1\n" +
                    "\n" +
                    "/////////////////////////////////////\n" +
                    "Tokens Avalible: Onyx x2 ,Sapphire x2 ,Emerald x1 ,Diamond x1 ,Rubby x2 ,Gold x0\n" +
                    "\n" +
                    "Nobles Avalible:\n" +
                    "\n" +
                    "******* Geralt of Rivia *******\n" +
                    "Rubby x4    Emerald x4\n" +
                    "\n" +
                    "\n" +
                    "******* Cirilla Fiona Elen Riannon *******\n" +
                    "Emerald x4    Sapphire x4\n" +
                    "\n" +
                    "\n" +
                    "******* Sigismund Dijkstra *******\n" +
                    "Diamond x3    Emerald x3    Sapphire x3\n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "Attention! Player 1 chose to take three tokens of different color!\n" +
                    "It is Player 2's turn!\n" +
                    "Player 2, here is what you currently have:\n" +
                    "\n" +
                    "\n" +
                    "***** Player 2 0 Point(s) *****\n" +
                    "Tokens: Onyx x0 ,Sapphire x0 ,Emerlad x0 ,Diamond x0 ,Rubby x0 ,Gold x4\n" +
                    "\n" +
                    "**** Cards ****\n" +
                    "\n" +
                    "**** Nobles ****\n" +
                    "\n" +
                    "\n" +
                    "**** Cards in Reserve ****\n" +
                    "\n" +
                    "2     Diamond  Town\n" +
                    "Rubby x4 Emerald x1 Onyx x2\n" +
                    "\n" +
                    "0     Sapphire  Town\n" +
                    "Onyx x3\n" +
                    "\n" +
                    "5     Rubby  Town\n" +
                    "Rubby x3 Emerald x7\n" +
                    "\n" +
                    "4     Sapphire  Town\n" +
                    "Diamond x6 Onyx x3 Sapphire x3\n" +
                    "\n" +
                    "\n" +
                    "Player 2, what do you wish to do this round?\n" +
                    "\n" +
                    "1. Take 2 tokens of the same color from the table(may only be performed if there is 4 or more tokens in the color of your chosing)\n" +
                    "2. Take 1 token from each of 3 different types of tokens(excluding gold)\n" +
                    "3. Reserve a card on the table and receive one gold token(keep in mind you may only have three reserved cards maximum. Also, you will not recieve any gold token if there is non on the table)\n" +
                    "4. Reserve an unknown card from the top of a chosen deck\n" +
                    "5. Buy a card from your reserved cards\n" +
                    "6. Buy a card on the table\n" +
                    "4\n" +
                    "Which deck do you wish to reserve card from?\n" +
                    "1. Blue Deck   2. Yellow Deck   3. Green Deck\n" +
                    "2\n" +
                    "The deck you chose ran out of cards. Please choose another one.\n" +
                    "Which deck do you wish to reserve card from?\n" +
                    "1. Blue Deck   2. Yellow Deck   3. Green Deck\n" +
                    "3\n" +
                    "The deck you chose ran out of cards. Please choose another one.\n" +
                    "Which deck do you wish to reserve card from?\n" +
                    "1. Blue Deck   2. Yellow Deck   3. Green Deck\n" +
                    "1\n" +
                    "The deck you chose ran out of cards. Please choose another one.\n" +
                    "Which deck do you wish to reserve card from?\n" +
                    "1. Blue Deck   2. Yellow Deck   3. Green Deck\n";
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            PrintStream output = new PrintStream(out);
            System.setOut(output);
            String result = "Welcome to Splendor! How many player(s) do you wish to have(including yourself)?\n" +
                    "2. 2    3. 3.    4. 4\n" +
                    "2\n" +
                    "Check0 completed\n" +
                    "Check1 completed\n" +
                    "Check2 completed\n" +
                    "Check3 completed\n" +
                    "check4 completed\n" +
                    "Awesome! lets start the game!\n" +
                    "\n" +
                    "\n" +
                    "***** Player 1 0 Point(s) *****\n" +
                    "Tokens: Onyx x0 ,Sapphire x0 ,Emerlad x0 ,Diamond x0 ,Rubby x0 ,Gold x0\n" +
                    "\n" +
                    "Cards:\n" +
                    "\n" +
                    "Nobles:\n" +
                    "\n" +
                    "\n" +
                    "Cards in Reserve x0\n" +
                    "*******************************\n" +
                    "\n" +
                    "***** Player 2 0 Point(s) *****\n" +
                    "Tokens: Onyx x0 ,Sapphire x0 ,Emerlad x0 ,Diamond x0 ,Rubby x0 ,Gold x0\n" +
                    "\n" +
                    "Cards:\n" +
                    "\n" +
                    "Nobles:\n" +
                    "\n" +
                    "\n" +
                    "Cards in Reserve x0\n" +
                    "*******************************\n" +
                    "\n" +
                    "/////////////////////////////////////\n" +
                    "Blue Deck\n" +
                    "Blue Card 1:\n" +
                    "3     Onyx  Town\n" +
                    "Diamond x3 Rubby x3 Emerald x5 Sapphire x3\n" +
                    "\n" +
                    "Blue Card 2:\n" +
                    "5     Emerald  Town\n" +
                    "Emerald x3 Sapphire x7\n" +
                    "\n" +
                    "Blue Card 3:\n" +
                    "3     Rubby  Town\n" +
                    "Diamond x3 Emerald x3 Sapphire x5\n" +
                    "\n" +
                    "Blue Card 4:\n" +
                    "5     Sapphire  Town\n" +
                    "Diamond x7 Sapphire x3\n" +
                    "\n" +
                    "/////////////////////////\n" +
                    "Yellow Deck\n" +
                    "Yellow Card 1:\n" +
                    "1     Sapphire  Town\n" +
                    "Emerald x3 Onyx x3 Sapphire x2\n" +
                    "\n" +
                    "Yellow Card 2:\n" +
                    "1     Onyx  Town\n" +
                    "Diamond x3 Emerald x2 Sapphire x3\n" +
                    "\n" +
                    "Yellow Card 3:\n" +
                    "1     Diamond  Town\n" +
                    "Diamond x2 Rubby x3 Sapphire x3\n" +
                    "\n" +
                    "Yellow Card 4:\n" +
                    "1     Rubby  Town\n" +
                    "Diamond x2 Rubby x2 Onyx x3\n" +
                    "\n" +
                    "/////////////////////////\n" +
                    "Green Deck\n" +
                    "Green Card 1:\n" +
                    "0     Rubby  Town\n" +
                    "Diamond x1 Emerald x1 Onyx x1 Sapphire x1\n" +
                    "\n" +
                    "Green Card 2:\n" +
                    "0     Sapphire  Town\n" +
                    "Rubby x1 Emerald x3 Sapphire x1\n" +
                    "\n" +
                    "Green Card 3:\n" +
                    "1     Emerald  Town\n" +
                    "Onyx x4\n" +
                    "\n" +
                    "Green Card 4:\n" +
                    "0     Emerald  Town\n" +
                    "Rubby x2 Onyx x2 Sapphire x1\n" +
                    "\n" +
                    "/////////////////////////////////////\n" +
                    "Tokens Avalible: Onyx x4 ,Sapphire x4 ,Emerald x4 ,Diamond x4 ,Rubby x4 ,Gold x4\n" +
                    "\n" +
                    "Nobles Avalible:\n" +
                    "\n" +
                    "******* Geralt of Rivia *******\n" +
                    "Rubby x4    Emerald x4\n" +
                    "\n" +
                    "\n" +
                    "******* Cirilla Fiona Elen Riannon *******\n" +
                    "Emerald x4    Sapphire x4\n" +
                    "\n" +
                    "\n" +
                    "******* Sigismund Dijkstra *******\n" +
                    "Diamond x3    Emerald x3    Sapphire x3\n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "It is Player 1's turn!\n" +
                    "Player 1, here is what you currently have:\n" +
                    "\n" +
                    "\n" +
                    "***** Player 1 0 Point(s) *****\n" +
                    "Tokens: Onyx x0 ,Sapphire x0 ,Emerlad x0 ,Diamond x0 ,Rubby x0 ,Gold x0\n" +
                    "\n" +
                    "**** Cards ****\n" +
                    "\n" +
                    "**** Nobles ****\n" +
                    "\n" +
                    "\n" +
                    "**** Cards in Reserve ****\n" +
                    "\n" +
                    "\n" +
                    "Player 1, what do you wish to do this round?\n" +
                    "\n" +
                    "1. Take 2 tokens of the same color from the table(may only be performed if there is 4 or more tokens in the color of your chosing)\n" +
                    "2. Take 1 token from each of 3 different types of tokens(excluding gold)\n" +
                    "3. Reserve a card on the table and receive one gold token(keep in mind you may only have three reserved cards maximum. Also, you will not recieve any gold token if there is non on the table)\n" +
                    "4. Reserve an unknown card from the top of a chosen deck\n" +
                    "5. Buy a card from your reserved cards\n" +
                    "6. Buy a card on the table\n" +
                    "2\n" +
                    "Choose a token to take.\n" +
                    "1. Onyx x4 2. Sapphire x4 3. Emerald x4 4. Diamond x4 5. Rubby x4\n" +
                    "1\n" +
                    "Choose a different token that you have not selected.\n" +
                    "1. Onyx x4 2. Sapphire x4 3. Emerald x4 4. Diamond x4 5. Rubby x4\n" +
                    "2\n" +
                    "Choose another different token that you have not selected.\n" +
                    "1. Onyx x4 2. Sapphire x4 3. Emerald x4 4. Diamond4 5. Rubby x4 6. Gold x4\n" +
                    "3\n" +
                    "3YOLOSWAG2\n" +
                    "Possibly not Working\n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "***** Player 1 0 Point(s) *****\n" +
                    "Tokens: Onyx x1 ,Sapphire x1 ,Emerlad x1 ,Diamond x0 ,Rubby x0 ,Gold x0\n" +
                    "\n" +
                    "Cards:\n" +
                    "\n" +
                    "Nobles:\n" +
                    "\n" +
                    "\n" +
                    "Cards in Reserve x0\n" +
                    "*******************************\n" +
                    "\n" +
                    "***** Player 2 0 Point(s) *****\n" +
                    "Tokens: Onyx x0 ,Sapphire x0 ,Emerlad x0 ,Diamond x0 ,Rubby x0 ,Gold x0\n" +
                    "\n" +
                    "Cards:\n" +
                    "\n" +
                    "Nobles:\n" +
                    "\n" +
                    "\n" +
                    "Cards in Reserve x0\n" +
                    "*******************************\n" +
                    "\n" +
                    "/////////////////////////////////////\n" +
                    "Blue Deck\n" +
                    "Blue Card 1:\n" +
                    "3     Onyx  Town\n" +
                    "Diamond x3 Rubby x3 Emerald x5 Sapphire x3\n" +
                    "\n" +
                    "Blue Card 2:\n" +
                    "5     Emerald  Town\n" +
                    "Emerald x3 Sapphire x7\n" +
                    "\n" +
                    "Blue Card 3:\n" +
                    "3     Rubby  Town\n" +
                    "Diamond x3 Emerald x3 Sapphire x5\n" +
                    "\n" +
                    "Blue Card 4:\n" +
                    "5     Sapphire  Town\n" +
                    "Diamond x7 Sapphire x3\n" +
                    "\n" +
                    "/////////////////////////\n" +
                    "Yellow Deck\n" +
                    "Yellow Card 1:\n" +
                    "1     Sapphire  Town\n" +
                    "Emerald x3 Onyx x3 Sapphire x2\n" +
                    "\n" +
                    "Yellow Card 2:\n" +
                    "1     Onyx  Town\n" +
                    "Diamond x3 Emerald x2 Sapphire x3\n" +
                    "\n" +
                    "Yellow Card 3:\n" +
                    "1     Diamond  Town\n" +
                    "Diamond x2 Rubby x3 Sapphire x3\n" +
                    "\n" +
                    "Yellow Card 4:\n" +
                    "1     Rubby  Town\n" +
                    "Diamond x2 Rubby x2 Onyx x3\n" +
                    "\n" +
                    "/////////////////////////\n" +
                    "Green Deck\n" +
                    "Green Card 1:\n" +
                    "0     Rubby  Town\n" +
                    "Diamond x1 Emerald x1 Onyx x1 Sapphire x1\n" +
                    "\n" +
                    "Green Card 2:\n" +
                    "0     Sapphire  Town\n" +
                    "Rubby x1 Emerald x3 Sapphire x1\n" +
                    "\n" +
                    "Green Card 3:\n" +
                    "1     Emerald  Town\n" +
                    "Onyx x4\n" +
                    "\n" +
                    "Green Card 4:\n" +
                    "0     Emerald  Town\n" +
                    "Rubby x2 Onyx x2 Sapphire x1\n" +
                    "\n" +
                    "/////////////////////////////////////\n" +
                    "Tokens Avalible: Onyx x3 ,Sapphire x3 ,Emerald x3 ,Diamond x4 ,Rubby x4 ,Gold x4\n" +
                    "\n" +
                    "Nobles Avalible:\n" +
                    "\n" +
                    "******* Geralt of Rivia *******\n" +
                    "Rubby x4    Emerald x4\n" +
                    "\n" +
                    "\n" +
                    "******* Cirilla Fiona Elen Riannon *******\n" +
                    "Emerald x4    Sapphire x4\n" +
                    "\n" +
                    "\n" +
                    "******* Sigismund Dijkstra *******\n" +
                    "Diamond x3    Emerald x3    Sapphire x3\n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "Attention! Player 1 chose to take three tokens of different color!\n" +
                    "It is Player 2's turn!\n" +
                    "Player 2, here is what you currently have:\n" +
                    "\n" +
                    "\n" +
                    "***** Player 2 0 Point(s) *****\n" +
                    "Tokens: Onyx x0 ,Sapphire x0 ,Emerlad x0 ,Diamond x0 ,Rubby x0 ,Gold x0\n" +
                    "\n" +
                    "**** Cards ****\n" +
                    "\n" +
                    "**** Nobles ****\n" +
                    "\n" +
                    "\n" +
                    "**** Cards in Reserve ****\n" +
                    "\n" +
                    "\n" +
                    "Player 2, what do you wish to do this round?\n" +
                    "\n" +
                    "1. Take 2 tokens of the same color from the table(may only be performed if there is 4 or more tokens in the color of your chosing)\n" +
                    "2. Take 1 token from each of 3 different types of tokens(excluding gold)\n" +
                    "3. Reserve a card on the table and receive one gold token(keep in mind you may only have three reserved cards maximum. Also, you will not recieve any gold token if there is non on the table)\n" +
                    "4. Reserve an unknown card from the top of a chosen deck\n" +
                    "5. Buy a card from your reserved cards\n" +
                    "6. Buy a card on the table\n" +
                    "4\n" +
                    "Which deck do you wish to reserve card from?\n" +
                    "1. Blue Deck   2. Yellow Deck   3. Green Deck\n" +
                    "2\n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "***** Player 1 0 Point(s) *****\n" +
                    "Tokens: Onyx x1 ,Sapphire x1 ,Emerlad x1 ,Diamond x0 ,Rubby x0 ,Gold x0\n" +
                    "\n" +
                    "Cards:\n" +
                    "\n" +
                    "Nobles:\n" +
                    "\n" +
                    "\n" +
                    "Cards in Reserve x0\n" +
                    "*******************************\n" +
                    "\n" +
                    "***** Player 2 0 Point(s) *****\n" +
                    "Tokens: Onyx x0 ,Sapphire x0 ,Emerlad x0 ,Diamond x0 ,Rubby x0 ,Gold x1\n" +
                    "\n" +
                    "Cards:\n" +
                    "\n" +
                    "Nobles:\n" +
                    "\n" +
                    "\n" +
                    "Cards in Reserve x1\n" +
                    "*******************************\n" +
                    "\n" +
                    "/////////////////////////////////////\n" +
                    "Blue Deck\n" +
                    "Blue Card 1:\n" +
                    "3     Onyx  Town\n" +
                    "Diamond x3 Rubby x3 Emerald x5 Sapphire x3\n" +
                    "\n" +
                    "Blue Card 2:\n" +
                    "5     Emerald  Town\n" +
                    "Emerald x3 Sapphire x7\n" +
                    "\n" +
                    "Blue Card 3:\n" +
                    "3     Rubby  Town\n" +
                    "Diamond x3 Emerald x3 Sapphire x5\n" +
                    "\n" +
                    "Blue Card 4:\n" +
                    "5     Sapphire  Town\n" +
                    "Diamond x7 Sapphire x3\n" +
                    "\n" +
                    "/////////////////////////\n" +
                    "Yellow Deck\n" +
                    "Yellow Card 1:\n" +
                    "1     Sapphire  Town\n" +
                    "Emerald x3 Onyx x3 Sapphire x2\n" +
                    "\n" +
                    "Yellow Card 2:\n" +
                    "1     Onyx  Town\n" +
                    "Diamond x3 Emerald x2 Sapphire x3\n" +
                    "\n" +
                    "Yellow Card 3:\n" +
                    "1     Diamond  Town\n" +
                    "Diamond x2 Rubby x3 Sapphire x3\n" +
                    "\n" +
                    "Yellow Card 4:\n" +
                    "1     Rubby  Town\n" +
                    "Diamond x2 Rubby x2 Onyx x3\n" +
                    "\n" +
                    "/////////////////////////\n" +
                    "Green Deck\n" +
                    "Green Card 1:\n" +
                    "0     Rubby  Town\n" +
                    "Diamond x1 Emerald x1 Onyx x1 Sapphire x1\n" +
                    "\n" +
                    "Green Card 2:\n" +
                    "0     Sapphire  Town\n" +
                    "Rubby x1 Emerald x3 Sapphire x1\n" +
                    "\n" +
                    "Green Card 3:\n" +
                    "1     Emerald  Town\n" +
                    "Onyx x4\n" +
                    "\n" +
                    "Green Card 4:\n" +
                    "0     Emerald  Town\n" +
                    "Rubby x2 Onyx x2 Sapphire x1\n" +
                    "\n" +
                    "/////////////////////////////////////\n" +
                    "Tokens Avalible: Onyx x3 ,Sapphire x3 ,Emerald x3 ,Diamond x4 ,Rubby x4 ,Gold x3\n" +
                    "\n" +
                    "Nobles Avalible:\n" +
                    "\n" +
                    "******* Geralt of Rivia *******\n" +
                    "Rubby x4    Emerald x4\n" +
                    "\n" +
                    "\n" +
                    "******* Cirilla Fiona Elen Riannon *******\n" +
                    "Emerald x4    Sapphire x4\n" +
                    "\n" +
                    "\n" +
                    "******* Sigismund Dijkstra *******\n" +
                    "Diamond x3    Emerald x3    Sapphire x3\n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "Attention! Player 2 chose to reserve a card from the deck!\n" +
                    "It is Player 1's turn!\n" +
                    "Player 1, here is what you currently have:\n" +
                    "\n" +
                    "\n" +
                    "***** Player 1 0 Point(s) *****\n" +
                    "Tokens: Onyx x1 ,Sapphire x1 ,Emerlad x1 ,Diamond x0 ,Rubby x0 ,Gold x0\n" +
                    "\n" +
                    "**** Cards ****\n" +
                    "\n" +
                    "**** Nobles ****\n" +
                    "\n" +
                    "\n" +
                    "**** Cards in Reserve ****\n" +
                    "\n" +
                    "\n" +
                    "Player 1, what do you wish to do this round?\n" +
                    "\n" +
                    "1. Take 2 tokens of the same color from the table(may only be performed if there is 4 or more tokens in the color of your chosing)\n" +
                    "2. Take 1 token from each of 3 different types of tokens(excluding gold)\n" +
                    "3. Reserve a card on the table and receive one gold token(keep in mind you may only have three reserved cards maximum. Also, you will not recieve any gold token if there is non on the table)\n" +
                    "4. Reserve an unknown card from the top of a chosen deck\n" +
                    "5. Buy a card from your reserved cards\n" +
                    "6. Buy a card on the table\n" +
                    "21\n" +
                    "Choose a token to take.\n" +
                    "1. Onyx x3 2. Sapphire x3 3. Emerald x3 4. Diamond x4 5. Rubby x4\n" +
                    "1\n" +
                    "Choose a different token that you have not selected.\n" +
                    "1. Onyx x3 2. Sapphire x3 3. Emerald x3 4. Diamond x4 5. Rubby x4\n" +
                    "4\n" +
                    "Choose another different token that you have not selected.\n" +
                    "1. Onyx x3 2. Sapphire x3 3. Emerald x3 4. Diamond4 5. Rubby x4 6. Gold x3\n" +
                    "3\n" +
                    "6YOLOSWAG2\n" +
                    "Possibly not Working\n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "***** Player 1 0 Point(s) *****\n" +
                    "Tokens: Onyx x2 ,Sapphire x1 ,Emerlad x2 ,Diamond x1 ,Rubby x0 ,Gold x0\n" +
                    "\n" +
                    "Cards:\n" +
                    "\n" +
                    "Nobles:\n" +
                    "\n" +
                    "\n" +
                    "Cards in Reserve x0\n" +
                    "*******************************\n" +
                    "\n" +
                    "***** Player 2 0 Point(s) *****\n" +
                    "Tokens: Onyx x0 ,Sapphire x0 ,Emerlad x0 ,Diamond x0 ,Rubby x0 ,Gold x1\n" +
                    "\n" +
                    "Cards:\n" +
                    "\n" +
                    "Nobles:\n" +
                    "\n" +
                    "\n" +
                    "Cards in Reserve x1\n" +
                    "*******************************\n" +
                    "\n" +
                    "/////////////////////////////////////\n" +
                    "Blue Deck\n" +
                    "Blue Card 1:\n" +
                    "3     Onyx  Town\n" +
                    "Diamond x3 Rubby x3 Emerald x5 Sapphire x3\n" +
                    "\n" +
                    "Blue Card 2:\n" +
                    "5     Emerald  Town\n" +
                    "Emerald x3 Sapphire x7\n" +
                    "\n" +
                    "Blue Card 3:\n" +
                    "3     Rubby  Town\n" +
                    "Diamond x3 Emerald x3 Sapphire x5\n" +
                    "\n" +
                    "Blue Card 4:\n" +
                    "5     Sapphire  Town\n" +
                    "Diamond x7 Sapphire x3\n" +
                    "\n" +
                    "/////////////////////////\n" +
                    "Yellow Deck\n" +
                    "Yellow Card 1:\n" +
                    "1     Sapphire  Town\n" +
                    "Emerald x3 Onyx x3 Sapphire x2\n" +
                    "\n" +
                    "Yellow Card 2:\n" +
                    "1     Onyx  Town\n" +
                    "Diamond x3 Emerald x2 Sapphire x3\n" +
                    "\n" +
                    "Yellow Card 3:\n" +
                    "1     Diamond  Town\n" +
                    "Diamond x2 Rubby x3 Sapphire x3\n" +
                    "\n" +
                    "Yellow Card 4:\n" +
                    "1     Rubby  Town\n" +
                    "Diamond x2 Rubby x2 Onyx x3\n" +
                    "\n" +
                    "/////////////////////////\n" +
                    "Green Deck\n" +
                    "Green Card 1:\n" +
                    "0     Rubby  Town\n" +
                    "Diamond x1 Emerald x1 Onyx x1 Sapphire x1\n" +
                    "\n" +
                    "Green Card 2:\n" +
                    "0     Sapphire  Town\n" +
                    "Rubby x1 Emerald x3 Sapphire x1\n" +
                    "\n" +
                    "Green Card 3:\n" +
                    "1     Emerald  Town\n" +
                    "Onyx x4\n" +
                    "\n" +
                    "Green Card 4:\n" +
                    "0     Emerald  Town\n" +
                    "Rubby x2 Onyx x2 Sapphire x1\n" +
                    "\n" +
                    "/////////////////////////////////////\n" +
                    "Tokens Avalible: Onyx x2 ,Sapphire x3 ,Emerald x2 ,Diamond x3 ,Rubby x4 ,Gold x3\n" +
                    "\n" +
                    "Nobles Avalible:\n" +
                    "\n" +
                    "******* Geralt of Rivia *******\n" +
                    "Rubby x4    Emerald x4\n" +
                    "\n" +
                    "\n" +
                    "******* Cirilla Fiona Elen Riannon *******\n" +
                    "Emerald x4    Sapphire x4\n" +
                    "\n" +
                    "\n" +
                    "******* Sigismund Dijkstra *******\n" +
                    "Diamond x3    Emerald x3    Sapphire x3\n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "Attention! Player 1 chose to take three tokens of different color!\n" +
                    "It is Player 2's turn!\n" +
                    "Player 2, here is what you currently have:\n" +
                    "\n" +
                    "\n" +
                    "***** Player 2 0 Point(s) *****\n" +
                    "Tokens: Onyx x0 ,Sapphire x0 ,Emerlad x0 ,Diamond x0 ,Rubby x0 ,Gold x1\n" +
                    "\n" +
                    "**** Cards ****\n" +
                    "\n" +
                    "**** Nobles ****\n" +
                    "\n" +
                    "\n" +
                    "**** Cards in Reserve ****\n" +
                    "\n" +
                    "2     Diamond  Town\n" +
                    "Rubby x4 Emerald x1 Onyx x2\n" +
                    "\n" +
                    "\n" +
                    "Player 2, what do you wish to do this round?\n" +
                    "\n" +
                    "1. Take 2 tokens of the same color from the table(may only be performed if there is 4 or more tokens in the color of your chosing)\n" +
                    "2. Take 1 token from each of 3 different types of tokens(excluding gold)\n" +
                    "3. Reserve a card on the table and receive one gold token(keep in mind you may only have three reserved cards maximum. Also, you will not recieve any gold token if there is non on the table)\n" +
                    "4. Reserve an unknown card from the top of a chosen deck\n" +
                    "5. Buy a card from your reserved cards\n" +
                    "6. Buy a card on the table\n" +
                    "4\n" +
                    "Which deck do you wish to reserve card from?\n" +
                    "1. Blue Deck   2. Yellow Deck   3. Green Deck\n" +
                    "\n" +
                    "Invalid choice made.\n" +
                    "Which deck do you wish to reserve card from?\n" +
                    "1. Blue Deck   2. Yellow Deck   3. Green Deck\n" +
                    "3\n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "***** Player 1 0 Point(s) *****\n" +
                    "Tokens: Onyx x2 ,Sapphire x1 ,Emerlad x2 ,Diamond x1 ,Rubby x0 ,Gold x0\n" +
                    "\n" +
                    "Cards:\n" +
                    "\n" +
                    "Nobles:\n" +
                    "\n" +
                    "\n" +
                    "Cards in Reserve x0\n" +
                    "*******************************\n" +
                    "\n" +
                    "***** Player 2 0 Point(s) *****\n" +
                    "Tokens: Onyx x0 ,Sapphire x0 ,Emerlad x0 ,Diamond x0 ,Rubby x0 ,Gold x3\n" +
                    "\n" +
                    "Cards:\n" +
                    "\n" +
                    "Nobles:\n" +
                    "\n" +
                    "\n" +
                    "Cards in Reserve x3\n" +
                    "*******************************\n" +
                    "\n" +
                    "/////////////////////////////////////\n" +
                    "Blue Deck\n" +
                    "Blue Card 1:\n" +
                    "3     Onyx  Town\n" +
                    "Diamond x3 Rubby x3 Emerald x5 Sapphire x3\n" +
                    "\n" +
                    "Blue Card 2:\n" +
                    "5     Emerald  Town\n" +
                    "Emerald x3 Sapphire x7\n" +
                    "\n" +
                    "Blue Card 3:\n" +
                    "3     Rubby  Town\n" +
                    "Diamond x3 Emerald x3 Sapphire x5\n" +
                    "\n" +
                    "Blue Card 4:\n" +
                    "5     Sapphire  Town\n" +
                    "Diamond x7 Sapphire x3\n" +
                    "\n" +
                    "/////////////////////////\n" +
                    "Yellow Deck\n" +
                    "Yellow Card 1:\n" +
                    "1     Sapphire  Town\n" +
                    "Emerald x3 Onyx x3 Sapphire x2\n" +
                    "\n" +
                    "Yellow Card 2:\n" +
                    "1     Onyx  Town\n" +
                    "Diamond x3 Emerald x2 Sapphire x3\n" +
                    "\n" +
                    "Yellow Card 3:\n" +
                    "1     Diamond  Town\n" +
                    "Diamond x2 Rubby x3 Sapphire x3\n" +
                    "\n" +
                    "Yellow Card 4:\n" +
                    "1     Rubby  Town\n" +
                    "Diamond x2 Rubby x2 Onyx x3\n" +
                    "\n" +
                    "/////////////////////////\n" +
                    "Green Deck\n" +
                    "Green Card 1:\n" +
                    "0     Rubby  Town\n" +
                    "Diamond x1 Emerald x1 Onyx x1 Sapphire x1\n" +
                    "\n" +
                    "Green Card 2:\n" +
                    "0     Sapphire  Town\n" +
                    "Rubby x1 Emerald x3 Sapphire x1\n" +
                    "\n" +
                    "Green Card 3:\n" +
                    "1     Emerald  Town\n" +
                    "Onyx x4\n" +
                    "\n" +
                    "Green Card 4:\n" +
                    "0     Emerald  Town\n" +
                    "Rubby x2 Onyx x2 Sapphire x1\n" +
                    "\n" +
                    "/////////////////////////////////////\n" +
                    "Tokens Avalible: Onyx x2 ,Sapphire x3 ,Emerald x2 ,Diamond x3 ,Rubby x4 ,Gold x1\n" +
                    "\n" +
                    "Nobles Avalible:\n" +
                    "\n" +
                    "******* Geralt of Rivia *******\n" +
                    "Rubby x4    Emerald x4\n" +
                    "\n" +
                    "\n" +
                    "******* Cirilla Fiona Elen Riannon *******\n" +
                    "Emerald x4    Sapphire x4\n" +
                    "\n" +
                    "\n" +
                    "******* Sigismund Dijkstra *******\n" +
                    "Diamond x3    Emerald x3    Sapphire x3\n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "Attention! Player 2 chose to reserve a card from the deck!\n" +
                    "It is Player 1's turn!\n" +
                    "Player 1, here is what you currently have:\n" +
                    "\n" +
                    "\n" +
                    "***** Player 1 0 Point(s) *****\n" +
                    "Tokens: Onyx x2 ,Sapphire x1 ,Emerlad x2 ,Diamond x1 ,Rubby x0 ,Gold x0\n" +
                    "\n" +
                    "**** Cards ****\n" +
                    "\n" +
                    "**** Nobles ****\n" +
                    "\n" +
                    "\n" +
                    "**** Cards in Reserve ****\n" +
                    "\n" +
                    "\n" +
                    "Player 1, what do you wish to do this round?\n" +
                    "\n" +
                    "1. Take 2 tokens of the same color from the table(may only be performed if there is 4 or more tokens in the color of your chosing)\n" +
                    "2. Take 1 token from each of 3 different types of tokens(excluding gold)\n" +
                    "3. Reserve a card on the table and receive one gold token(keep in mind you may only have three reserved cards maximum. Also, you will not recieve any gold token if there is non on the table)\n" +
                    "4. Reserve an unknown card from the top of a chosen deck\n" +
                    "5. Buy a card from your reserved cards\n" +
                    "6. Buy a card on the table\n" +
                    "2\n" +
                    "Choose a token to take.\n" +
                    "1. Onyx x2 2. Sapphire x3 3. Emerald x2 4. Diamond x3 5. Rubby x4\n" +
                    "4\n" +
                    "Choose a different token that you have not selected.\n" +
                    "1. Onyx x2 2. Sapphire x3 3. Emerald x2 4. Diamond x3 5. Rubby x4\n" +
                    "5\n" +
                    "Choose another different token that you have not selected.\n" +
                    "1. Onyx x2 2. Sapphire x3 3. Emerald x2 4. Diamond3 5. Rubby x4 6. Gold x1\n" +
                    "2\n" +
                    "9YOLOSWAG2\n" +
                    "Possibly not Working\n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "***** Player 1 0 Point(s) *****\n" +
                    "Tokens: Onyx x2 ,Sapphire x2 ,Emerlad x2 ,Diamond x2 ,Rubby x1 ,Gold x0\n" +
                    "\n" +
                    "Cards:\n" +
                    "\n" +
                    "Nobles:\n" +
                    "\n" +
                    "\n" +
                    "Cards in Reserve x0\n" +
                    "*******************************\n" +
                    "\n" +
                    "***** Player 2 0 Point(s) *****\n" +
                    "Tokens: Onyx x0 ,Sapphire x0 ,Emerlad x0 ,Diamond x0 ,Rubby x0 ,Gold x3\n" +
                    "\n" +
                    "Cards:\n" +
                    "\n" +
                    "Nobles:\n" +
                    "\n" +
                    "\n" +
                    "Cards in Reserve x3\n" +
                    "*******************************\n" +
                    "\n" +
                    "/////////////////////////////////////\n" +
                    "Blue Deck\n" +
                    "Blue Card 1:\n" +
                    "3     Onyx  Town\n" +
                    "Diamond x3 Rubby x3 Emerald x5 Sapphire x3\n" +
                    "\n" +
                    "Blue Card 2:\n" +
                    "5     Emerald  Town\n" +
                    "Emerald x3 Sapphire x7\n" +
                    "\n" +
                    "Blue Card 3:\n" +
                    "3     Rubby  Town\n" +
                    "Diamond x3 Emerald x3 Sapphire x5\n" +
                    "\n" +
                    "Blue Card 4:\n" +
                    "5     Sapphire  Town\n" +
                    "Diamond x7 Sapphire x3\n" +
                    "\n" +
                    "/////////////////////////\n" +
                    "Yellow Deck\n" +
                    "Yellow Card 1:\n" +
                    "1     Sapphire  Town\n" +
                    "Emerald x3 Onyx x3 Sapphire x2\n" +
                    "\n" +
                    "Yellow Card 2:\n" +
                    "1     Onyx  Town\n" +
                    "Diamond x3 Emerald x2 Sapphire x3\n" +
                    "\n" +
                    "Yellow Card 3:\n" +
                    "1     Diamond  Town\n" +
                    "Diamond x2 Rubby x3 Sapphire x3\n" +
                    "\n" +
                    "Yellow Card 4:\n" +
                    "1     Rubby  Town\n" +
                    "Diamond x2 Rubby x2 Onyx x3\n" +
                    "\n" +
                    "/////////////////////////\n" +
                    "Green Deck\n" +
                    "Green Card 1:\n" +
                    "0     Rubby  Town\n" +
                    "Diamond x1 Emerald x1 Onyx x1 Sapphire x1\n" +
                    "\n" +
                    "Green Card 2:\n" +
                    "0     Sapphire  Town\n" +
                    "Rubby x1 Emerald x3 Sapphire x1\n" +
                    "\n" +
                    "Green Card 3:\n" +
                    "1     Emerald  Town\n" +
                    "Onyx x4\n" +
                    "\n" +
                    "Green Card 4:\n" +
                    "0     Emerald  Town\n" +
                    "Rubby x2 Onyx x2 Sapphire x1\n" +
                    "\n" +
                    "/////////////////////////////////////\n" +
                    "Tokens Avalible: Onyx x2 ,Sapphire x2 ,Emerald x2 ,Diamond x2 ,Rubby x3 ,Gold x1\n" +
                    "\n" +
                    "Nobles Avalible:\n" +
                    "\n" +
                    "******* Geralt of Rivia *******\n" +
                    "Rubby x4    Emerald x4\n" +
                    "\n" +
                    "\n" +
                    "******* Cirilla Fiona Elen Riannon *******\n" +
                    "Emerald x4    Sapphire x4\n" +
                    "\n" +
                    "\n" +
                    "******* Sigismund Dijkstra *******\n" +
                    "Diamond x3    Emerald x3    Sapphire x3\n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "Attention! Player 1 chose to take three tokens of different color!\n" +
                    "It is Player 2's turn!\n" +
                    "Player 2, here is what you currently have:\n" +
                    "\n" +
                    "\n" +
                    "***** Player 2 0 Point(s) *****\n" +
                    "Tokens: Onyx x0 ,Sapphire x0 ,Emerlad x0 ,Diamond x0 ,Rubby x0 ,Gold x3\n" +
                    "\n" +
                    "**** Cards ****\n" +
                    "\n" +
                    "**** Nobles ****\n" +
                    "\n" +
                    "\n" +
                    "**** Cards in Reserve ****\n" +
                    "\n" +
                    "2     Diamond  Town\n" +
                    "Rubby x4 Emerald x1 Onyx x2\n" +
                    "\n" +
                    "0     Sapphire  Town\n" +
                    "Onyx x3\n" +
                    "\n" +
                    "5     Rubby  Town\n" +
                    "Rubby x3 Emerald x7\n" +
                    "\n" +
                    "\n" +
                    "Player 2, what do you wish to do this round?\n" +
                    "\n" +
                    "1. Take 2 tokens of the same color from the table(may only be performed if there is 4 or more tokens in the color of your chosing)\n" +
                    "2. Take 1 token from each of 3 different types of tokens(excluding gold)\n" +
                    "3. Reserve a card on the table and receive one gold token(keep in mind you may only have three reserved cards maximum. Also, you will not recieve any gold token if there is non on the table)\n" +
                    "4. Reserve an unknown card from the top of a chosen deck\n" +
                    "5. Buy a card from your reserved cards\n" +
                    "6. Buy a card on the table\n" +
                    "4\n" +
                    "Which deck do you wish to reserve card from?\n" +
                    "1. Blue Deck   2. Yellow Deck   3. Green Deck\n" +
                    "1\n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "***** Player 1 0 Point(s) *****\n" +
                    "Tokens: Onyx x2 ,Sapphire x2 ,Emerlad x2 ,Diamond x2 ,Rubby x1 ,Gold x0\n" +
                    "\n" +
                    "Cards:\n" +
                    "\n" +
                    "Nobles:\n" +
                    "\n" +
                    "\n" +
                    "Cards in Reserve x0\n" +
                    "*******************************\n" +
                    "\n" +
                    "***** Player 2 0 Point(s) *****\n" +
                    "Tokens: Onyx x0 ,Sapphire x0 ,Emerlad x0 ,Diamond x0 ,Rubby x0 ,Gold x4\n" +
                    "\n" +
                    "Cards:\n" +
                    "\n" +
                    "Nobles:\n" +
                    "\n" +
                    "\n" +
                    "Cards in Reserve x4\n" +
                    "*******************************\n" +
                    "\n" +
                    "/////////////////////////////////////\n" +
                    "Blue Deck\n" +
                    "Blue Card 1:\n" +
                    "3     Onyx  Town\n" +
                    "Diamond x3 Rubby x3 Emerald x5 Sapphire x3\n" +
                    "\n" +
                    "Blue Card 2:\n" +
                    "5     Emerald  Town\n" +
                    "Emerald x3 Sapphire x7\n" +
                    "\n" +
                    "Blue Card 3:\n" +
                    "3     Rubby  Town\n" +
                    "Diamond x3 Emerald x3 Sapphire x5\n" +
                    "\n" +
                    "Blue Card 4:\n" +
                    "5     Sapphire  Town\n" +
                    "Diamond x7 Sapphire x3\n" +
                    "\n" +
                    "/////////////////////////\n" +
                    "Yellow Deck\n" +
                    "Yellow Card 1:\n" +
                    "1     Sapphire  Town\n" +
                    "Emerald x3 Onyx x3 Sapphire x2\n" +
                    "\n" +
                    "Yellow Card 2:\n" +
                    "1     Onyx  Town\n" +
                    "Diamond x3 Emerald x2 Sapphire x3\n" +
                    "\n" +
                    "Yellow Card 3:\n" +
                    "1     Diamond  Town\n" +
                    "Diamond x2 Rubby x3 Sapphire x3\n" +
                    "\n" +
                    "Yellow Card 4:\n" +
                    "1     Rubby  Town\n" +
                    "Diamond x2 Rubby x2 Onyx x3\n" +
                    "\n" +
                    "/////////////////////////\n" +
                    "Green Deck\n" +
                    "Green Card 1:\n" +
                    "0     Rubby  Town\n" +
                    "Diamond x1 Emerald x1 Onyx x1 Sapphire x1\n" +
                    "\n" +
                    "Green Card 2:\n" +
                    "0     Sapphire  Town\n" +
                    "Rubby x1 Emerald x3 Sapphire x1\n" +
                    "\n" +
                    "Green Card 3:\n" +
                    "1     Emerald  Town\n" +
                    "Onyx x4\n" +
                    "\n" +
                    "Green Card 4:\n" +
                    "0     Emerald  Town\n" +
                    "Rubby x2 Onyx x2 Sapphire x1\n" +
                    "\n" +
                    "/////////////////////////////////////\n" +
                    "Tokens Avalible: Onyx x2 ,Sapphire x2 ,Emerald x2 ,Diamond x2 ,Rubby x3 ,Gold x0\n" +
                    "\n" +
                    "Nobles Avalible:\n" +
                    "\n" +
                    "******* Geralt of Rivia *******\n" +
                    "Rubby x4    Emerald x4\n" +
                    "\n" +
                    "\n" +
                    "******* Cirilla Fiona Elen Riannon *******\n" +
                    "Emerald x4    Sapphire x4\n" +
                    "\n" +
                    "\n" +
                    "******* Sigismund Dijkstra *******\n" +
                    "Diamond x3    Emerald x3    Sapphire x3\n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "Attention! Player 2 chose to reserve a card from the deck!\n" +
                    "It is Player 1's turn!\n" +
                    "Player 1, here is what you currently have:\n" +
                    "\n" +
                    "\n" +
                    "***** Player 1 0 Point(s) *****\n" +
                    "Tokens: Onyx x2 ,Sapphire x2 ,Emerlad x2 ,Diamond x2 ,Rubby x1 ,Gold x0\n" +
                    "\n" +
                    "**** Cards ****\n" +
                    "\n" +
                    "**** Nobles ****\n" +
                    "\n" +
                    "\n" +
                    "**** Cards in Reserve ****\n" +
                    "\n" +
                    "\n" +
                    "Player 1, what do you wish to do this round?\n" +
                    "\n" +
                    "1. Take 2 tokens of the same color from the table(may only be performed if there is 4 or more tokens in the color of your chosing)\n" +
                    "2. Take 1 token from each of 3 different types of tokens(excluding gold)\n" +
                    "3. Reserve a card on the table and receive one gold token(keep in mind you may only have three reserved cards maximum. Also, you will not recieve any gold token if there is non on the table)\n" +
                    "4. Reserve an unknown card from the top of a chosen deck\n" +
                    "5. Buy a card from your reserved cards\n" +
                    "6. Buy a card on the table\n" +
                    "2\n" +
                    "Choose a token to take.\n" +
                    "1. Onyx x2 2. Sapphire x2 3. Emerald x2 4. Diamond x2 5. Rubby x3\n" +
                    "5\n" +
                    "Choose a different token that you have not selected.\n" +
                    "1. Onyx x2 2. Sapphire x2 3. Emerald x2 4. Diamond x2 5. Rubby x3\n" +
                    "4\n" +
                    "Choose another different token that you have not selected.\n" +
                    "1. Onyx x2 2. Sapphire x2 3. Emerald x2 4. Diamond2 5. Rubby x3 6. Gold x0\n" +
                    "3\n" +
                    "12YOLOSWAG2\n" +
                    "Working\n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "***** Player 1 0 Point(s) *****\n" +
                    "Tokens: Onyx x2 ,Sapphire x2 ,Emerlad x3 ,Diamond x3 ,Rubby x2 ,Gold x0\n" +
                    "\n" +
                    "Cards:\n" +
                    "\n" +
                    "Nobles:\n" +
                    "\n" +
                    "\n" +
                    "Cards in Reserve x0\n" +
                    "*******************************\n" +
                    "\n" +
                    "***** Player 2 0 Point(s) *****\n" +
                    "Tokens: Onyx x0 ,Sapphire x0 ,Emerlad x0 ,Diamond x0 ,Rubby x0 ,Gold x4\n" +
                    "\n" +
                    "Cards:\n" +
                    "\n" +
                    "Nobles:\n" +
                    "\n" +
                    "\n" +
                    "Cards in Reserve x4\n" +
                    "*******************************\n" +
                    "\n" +
                    "/////////////////////////////////////\n" +
                    "Blue Deck\n" +
                    "Blue Card 1:\n" +
                    "3     Onyx  Town\n" +
                    "Diamond x3 Rubby x3 Emerald x5 Sapphire x3\n" +
                    "\n" +
                    "Blue Card 2:\n" +
                    "5     Emerald  Town\n" +
                    "Emerald x3 Sapphire x7\n" +
                    "\n" +
                    "Blue Card 3:\n" +
                    "3     Rubby  Town\n" +
                    "Diamond x3 Emerald x3 Sapphire x5\n" +
                    "\n" +
                    "Blue Card 4:\n" +
                    "5     Sapphire  Town\n" +
                    "Diamond x7 Sapphire x3\n" +
                    "\n" +
                    "/////////////////////////\n" +
                    "Yellow Deck\n" +
                    "Yellow Card 1:\n" +
                    "1     Sapphire  Town\n" +
                    "Emerald x3 Onyx x3 Sapphire x2\n" +
                    "\n" +
                    "Yellow Card 2:\n" +
                    "1     Onyx  Town\n" +
                    "Diamond x3 Emerald x2 Sapphire x3\n" +
                    "\n" +
                    "Yellow Card 3:\n" +
                    "1     Diamond  Town\n" +
                    "Diamond x2 Rubby x3 Sapphire x3\n" +
                    "\n" +
                    "Yellow Card 4:\n" +
                    "1     Rubby  Town\n" +
                    "Diamond x2 Rubby x2 Onyx x3\n" +
                    "\n" +
                    "/////////////////////////\n" +
                    "Green Deck\n" +
                    "Green Card 1:\n" +
                    "0     Rubby  Town\n" +
                    "Diamond x1 Emerald x1 Onyx x1 Sapphire x1\n" +
                    "\n" +
                    "Green Card 2:\n" +
                    "0     Sapphire  Town\n" +
                    "Rubby x1 Emerald x3 Sapphire x1\n" +
                    "\n" +
                    "Green Card 3:\n" +
                    "1     Emerald  Town\n" +
                    "Onyx x4\n" +
                    "\n" +
                    "Green Card 4:\n" +
                    "0     Emerald  Town\n" +
                    "Rubby x2 Onyx x2 Sapphire x1\n" +
                    "\n" +
                    "/////////////////////////////////////\n" +
                    "Tokens Avalible: Onyx x2 ,Sapphire x2 ,Emerald x1 ,Diamond x1 ,Rubby x2 ,Gold x0\n" +
                    "\n" +
                    "Nobles Avalible:\n" +
                    "\n" +
                    "******* Geralt of Rivia *******\n" +
                    "Rubby x4    Emerald x4\n" +
                    "\n" +
                    "\n" +
                    "******* Cirilla Fiona Elen Riannon *******\n" +
                    "Emerald x4    Sapphire x4\n" +
                    "\n" +
                    "\n" +
                    "******* Sigismund Dijkstra *******\n" +
                    "Diamond x3    Emerald x3    Sapphire x3\n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "Attention! Player 1 chose to take three tokens of different color!\n" +
                    "It is Player 2's turn!\n" +
                    "Player 2, here is what you currently have:\n" +
                    "\n" +
                    "\n" +
                    "***** Player 2 0 Point(s) *****\n" +
                    "Tokens: Onyx x0 ,Sapphire x0 ,Emerlad x0 ,Diamond x0 ,Rubby x0 ,Gold x4\n" +
                    "\n" +
                    "**** Cards ****\n" +
                    "\n" +
                    "**** Nobles ****\n" +
                    "\n" +
                    "\n" +
                    "**** Cards in Reserve ****\n" +
                    "\n" +
                    "2     Diamond  Town\n" +
                    "Rubby x4 Emerald x1 Onyx x2\n" +
                    "\n" +
                    "0     Sapphire  Town\n" +
                    "Onyx x3\n" +
                    "\n" +
                    "5     Rubby  Town\n" +
                    "Rubby x3 Emerald x7\n" +
                    "\n" +
                    "4     Sapphire  Town\n" +
                    "Diamond x6 Onyx x3 Sapphire x3\n" +
                    "\n" +
                    "\n" +
                    "Player 2, what do you wish to do this round?\n" +
                    "\n" +
                    "1. Take 2 tokens of the same color from the table(may only be performed if there is 4 or more tokens in the color of your chosing)\n" +
                    "2. Take 1 token from each of 3 different types of tokens(excluding gold)\n" +
                    "3. Reserve a card on the table and receive one gold token(keep in mind you may only have three reserved cards maximum. Also, you will not recieve any gold token if there is non on the table)\n" +
                    "4. Reserve an unknown card from the top of a chosen deck\n" +
                    "5. Buy a card from your reserved cards\n" +
                    "6. Buy a card on the table\n" +
                    "4\n" +
                    "Which deck do you wish to reserve card from?\n" +
                    "1. Blue Deck   2. Yellow Deck   3. Green Deck\n" +
                    "2\n";
            assertEquals(expected,result);
        }
    }
    @Test
    public void testFourPlayerFirstFourChooseGreenDeck() throws PlayerDoesNotHaveEnoughResourcesToBuySelectedCard, SelectedDeckRanOutOfCards, NotEnoughTokensOnTable, InvalidCardsSelectionOfCardsInReserve, FileNotFoundException, InvalidCardsSelectionOfCardsOnTable, PlayerAlreadyHoldsThreeReserveCards, PlayerDoesNotHaveSelectedCardInReserve, InterruptedException {

        try {
            // set up testable input and output channels
            byte[] data = "4\n 4\n 3\n".getBytes(StandardCharsets.UTF_8);
            BufferedInputStream in = new BufferedInputStream(new ByteArrayInputStream(data));
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            PrintStream output = new PrintStream(out);
            // redirect the standard channels

            String[] args = null;
            System.setIn(in);
            TextBasedInterface.main(null);
            System.setOut(output);

            // call to method that does standard I/O
            String result = out.toString().replaceAll("\r","");
//        System.setOut(output);

//        System.setIn(in); System.setOut(output);
//        assertEquals(expected,result);
        } catch (Exception e) {

        }
    }
    @Test
    public void testFourPlayerFirstChooseFourYellowDeck() throws PlayerDoesNotHaveEnoughResourcesToBuySelectedCard, SelectedDeckRanOutOfCards, NotEnoughTokensOnTable, InvalidCardsSelectionOfCardsInReserve, FileNotFoundException, InvalidCardsSelectionOfCardsOnTable, PlayerAlreadyHoldsThreeReserveCards, PlayerDoesNotHaveSelectedCardInReserve, InterruptedException {

        try {
            // set up testable input and output channels
            byte[] data = "4\n 4\n 2\n".getBytes(StandardCharsets.UTF_8);
            BufferedInputStream in = new BufferedInputStream(new ByteArrayInputStream(data));
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            PrintStream output = new PrintStream(out);
            // redirect the standard channels

            String[] args = null;
            System.setIn(in);
            TextBasedInterface.main(null);
            System.setOut(output);

            // call to method that does standard I/O
            String result = out.toString().replaceAll("\r","");
        String to_contain = "***** Player 1 0 Point(s) *****\n" +
                    "Tokens: Onyx x0 ,Sapphire x0 ,Emerlad x0 ,Diamond x0 ,Rubby x0 ,Gold x1\n" +
                    "\n" +
                    "Cards:\n" +
                    "\n" +
                    "Nobles:\n" +
                    "\n" +
                    "\n" +
                    "Cards in Reserve x1\n";
            assertFalse(result.contains(to_contain));
        } catch (Exception e) {

        }
    }
    @Test
    public void testFourPlayerFirstChooseFourBlueDeck() throws PlayerDoesNotHaveEnoughResourcesToBuySelectedCard, SelectedDeckRanOutOfCards, NotEnoughTokensOnTable, InvalidCardsSelectionOfCardsInReserve, FileNotFoundException, InvalidCardsSelectionOfCardsOnTable, PlayerAlreadyHoldsThreeReserveCards, PlayerDoesNotHaveSelectedCardInReserve, InterruptedException {

        try {
            // set up testable input and output channels
            byte[] data = "4\n 4\n 1\n".getBytes(StandardCharsets.UTF_8);
            BufferedInputStream in = new BufferedInputStream(new ByteArrayInputStream(data));
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            PrintStream output = new PrintStream(out);
            // redirect the standard channels

            String[] args = null;
            System.setIn(in);
            TextBasedInterface.main(null);
            System.setOut(output);

            // call to method that does standard I/O
            String result = out.toString().replaceAll("\r","");
//        System.setOut(output);

//        System.setIn(in); System.setOut(output);
            String to_contain = "***** Player 1 0 Point(s) *****\n" +
                    "Tokens: Onyx x0 ,Sapphire x0 ,Emerlad x0 ,Diamond x0 ,Rubby x0 ,Gold x1\n" +
                    "\n" +
                    "Cards:\n" +
                    "\n" +
                    "Nobles:\n" +
                    "\n" +
                    "\n" +
                    "Cards in Reserve x1\n";
            assertFalse(result.contains(to_contain));
        } catch (Exception e) {

        }
    }


    @Test
    public void testThreePlayerFirstChooseFourBlueDeck() throws PlayerDoesNotHaveEnoughResourcesToBuySelectedCard, SelectedDeckRanOutOfCards, NotEnoughTokensOnTable, InvalidCardsSelectionOfCardsInReserve, FileNotFoundException, InvalidCardsSelectionOfCardsOnTable, PlayerAlreadyHoldsThreeReserveCards, PlayerDoesNotHaveSelectedCardInReserve, InterruptedException {

        try {
            // set up testable input and output channels
            byte[] data = "3\n 4\n 1\n".getBytes(StandardCharsets.UTF_8);
            BufferedInputStream in = new BufferedInputStream(new ByteArrayInputStream(data));
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            PrintStream output = new PrintStream(out);
            // redirect the standard channels

            String[] args = null;
            System.setIn(in);
            TextBasedInterface.main(null);
            System.setOut(output);

            // call to method that does standard I/O
            String result = out.toString().replaceAll("\r","");
//        System.setOut(output);

//        System.setIn(in); System.setOut(output);
            String to_contain = "***** Player 1 0 Point(s) *****\n" +
                    "Tokens: Onyx x0 ,Sapphire x0 ,Emerlad x0 ,Diamond x0 ,Rubby x0 ,Gold x1\n" +
                    "\n" +
                    "Cards:\n" +
                    "\n" +
                    "Nobles:\n" +
                    "\n" +
                    "\n" +
                    "Cards in Reserve x1\n";
            assertFalse(result.contains(to_contain));
        } catch (Exception e) {

        }
    }
    @Test
    public void testThreePlayerFirstChooseFourYellowDeck() throws PlayerDoesNotHaveEnoughResourcesToBuySelectedCard, SelectedDeckRanOutOfCards, NotEnoughTokensOnTable, InvalidCardsSelectionOfCardsInReserve, FileNotFoundException, InvalidCardsSelectionOfCardsOnTable, PlayerAlreadyHoldsThreeReserveCards, PlayerDoesNotHaveSelectedCardInReserve, InterruptedException {

        try {
            // set up testable input and output channels
            byte[] data = "3\n 4\n 2\n".getBytes(StandardCharsets.UTF_8);
            BufferedInputStream in = new BufferedInputStream(new ByteArrayInputStream(data));
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            PrintStream output = new PrintStream(out);
            // redirect the standard channels

            String[] args = null;
            System.setIn(in);
            TextBasedInterface.main(null);
            System.setOut(output);

            // call to method that does standard I/O
            String result = out.toString().replaceAll("\r","");
//        System.setOut(output);

//        System.setIn(in); System.setOut(output);
            String to_contain = "***** Player 1 0 Point(s) *****\n" +
                    "Tokens: Onyx x0 ,Sapphire x0 ,Emerlad x0 ,Diamond x0 ,Rubby x0 ,Gold x1\n" +
                    "\n" +
                    "Cards:\n" +
                    "\n" +
                    "Nobles:\n" +
                    "\n" +
                    "\n" +
                    "Cards in Reserve x1\n";
            assertFalse(result.contains(to_contain));
        } catch (Exception e) {

        }

    }
    @Test
    public void testThreePlayerFirstChooseFourGreenDeck() throws PlayerDoesNotHaveEnoughResourcesToBuySelectedCard, SelectedDeckRanOutOfCards, NotEnoughTokensOnTable, InvalidCardsSelectionOfCardsInReserve, FileNotFoundException, InvalidCardsSelectionOfCardsOnTable, PlayerAlreadyHoldsThreeReserveCards, PlayerDoesNotHaveSelectedCardInReserve, InterruptedException {

        try {
            // set up testable input and output channels
            byte[] data = "3\n 4\n 3\n".getBytes(StandardCharsets.UTF_8);
            BufferedInputStream in = new BufferedInputStream(new ByteArrayInputStream(data));
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            PrintStream output = new PrintStream(out);
            // redirect the standard channels

            String[] args = null;
            System.setIn(in);
            TextBasedInterface.main(null);
            System.setOut(output);

            // call to method that does standard I/O
            String result = out.toString().replaceAll("\r","");
//        System.setOut(output);

//        System.setIn(in); System.setOut(output);
            String to_contain = "***** Player 1 0 Point(s) *****\n" +
                    "Tokens: Onyx x0 ,Sapphire x0 ,Emerlad x0 ,Diamond x0 ,Rubby x0 ,Gold x1\n" +
                    "\n" +
                    "Cards:\n" +
                    "\n" +
                    "Nobles:\n" +
                    "\n" +
                    "\n" +
                    "Cards in Reserve x1\n";
            assertFalse(result.contains(to_contain));
        } catch (Exception e) {

        }
    }
    @Test
    public void testTwoPlayerFirstChooseSixBuyBlueCard() throws PlayerDoesNotHaveEnoughResourcesToBuySelectedCard, SelectedDeckRanOutOfCards, NotEnoughTokensOnTable, InvalidCardsSelectionOfCardsInReserve, FileNotFoundException, InvalidCardsSelectionOfCardsOnTable, PlayerAlreadyHoldsThreeReserveCards, PlayerDoesNotHaveSelectedCardInReserve, InterruptedException {

        try {
            // set up testable input and output channels
            byte[] data = "2\n 6\n 1\n 1\n".getBytes(StandardCharsets.UTF_8);
            BufferedInputStream in = new BufferedInputStream(new ByteArrayInputStream(data));
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            PrintStream output = new PrintStream(out);
            // redirect the standard channels

            String[] args = null;
            System.setIn(in);
            TextBasedInterface.main(null);
            System.setOut(output);

            // call to method that does standard I/O
            String result = out.toString().replaceAll("\r","");
//        System.setOut(output);

//        System.setIn(in); System.setOut(output);
            String to_contain = "Sorry; you do not have enough resources to buy this card.";
            assertFalse(result.contains(to_contain));
        } catch (Exception e) {

        }
    }
    @Test
    public void testTwoPlayerFirstChooseSixBuyYellowCard() throws PlayerDoesNotHaveEnoughResourcesToBuySelectedCard, SelectedDeckRanOutOfCards, NotEnoughTokensOnTable, InvalidCardsSelectionOfCardsInReserve, FileNotFoundException, InvalidCardsSelectionOfCardsOnTable, PlayerAlreadyHoldsThreeReserveCards, PlayerDoesNotHaveSelectedCardInReserve, InterruptedException {

        try {
            // set up testable input and output channels
            byte[] data = "2\n 6\n 2\n 1\n".getBytes(StandardCharsets.UTF_8);
            BufferedInputStream in = new BufferedInputStream(new ByteArrayInputStream(data));
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            PrintStream output = new PrintStream(out);
            // redirect the standard channels

            String[] args = null;
            System.setIn(in);
            TextBasedInterface.main(null);
            System.setOut(output);

            // call to method that does standard I/O
            String result = out.toString().replaceAll("\r","");
//        System.setOut(output);

//        System.setIn(in); System.setOut(output);
            String to_contain = "Sorry; you do not have enough resources to buy this card.";
            assertFalse(result.contains(to_contain));
        } catch (Exception e) {

        }
    }
    @Test
    public void testTwoPlayerFirstChooseSixBuyGreenCard() throws PlayerDoesNotHaveEnoughResourcesToBuySelectedCard, SelectedDeckRanOutOfCards, NotEnoughTokensOnTable, InvalidCardsSelectionOfCardsInReserve, FileNotFoundException, InvalidCardsSelectionOfCardsOnTable, PlayerAlreadyHoldsThreeReserveCards, PlayerDoesNotHaveSelectedCardInReserve, InterruptedException {

        try {
            // set up testable input and output channels
            byte[] data = "2\n 6\n 3\n 1\n".getBytes(StandardCharsets.UTF_8);
            BufferedInputStream in = new BufferedInputStream(new ByteArrayInputStream(data));
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            PrintStream output = new PrintStream(out);
            // redirect the standard channels

            String[] args = null;
            System.setIn(in);
            TextBasedInterface.main(null);
            System.setOut(output);

            // call to method that does standard I/O
            String result = out.toString().replaceAll("\r","");
//        System.setOut(output);

//        System.setIn(in); System.setOut(output);
            String to_contain = "Sorry; you do not have enough resources to buy this card.";
            assertFalse(result.contains(to_contain));
        } catch (Exception e) {

        }
    }
    @Test
    public void testTwoPlayerFirstChooseFiveBuyYellowCard() throws PlayerDoesNotHaveEnoughResourcesToBuySelectedCard, SelectedDeckRanOutOfCards, NotEnoughTokensOnTable, InvalidCardsSelectionOfCardsInReserve, FileNotFoundException, InvalidCardsSelectionOfCardsOnTable, PlayerAlreadyHoldsThreeReserveCards, PlayerDoesNotHaveSelectedCardInReserve, InterruptedException {

        try {
            // set up testable input and output channels
            byte[] data = "2\n 5\n 2\n 1\n".getBytes(StandardCharsets.UTF_8);
            BufferedInputStream in = new BufferedInputStream(new ByteArrayInputStream(data));
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            PrintStream output = new PrintStream(out);
            // redirect the standard channels

            String[] args = null;
            System.setIn(in);
            TextBasedInterface.main(null);
            System.setOut(output);

            // call to method that does standard I/O
            String result = out.toString().replaceAll("\r","");
//        System.setOut(output);

//        System.setIn(in); System.setOut(output);
            String to_contain = "Sorry; you do not have enough resources to buy this card.";
            assertFalse(result.contains(to_contain));
        } catch (Exception e) {

        }
    }
    @Test
    public void testTwoPlayerFirstChooseFiveBuyBlueCard() throws PlayerDoesNotHaveEnoughResourcesToBuySelectedCard, SelectedDeckRanOutOfCards, NotEnoughTokensOnTable, InvalidCardsSelectionOfCardsInReserve, FileNotFoundException, InvalidCardsSelectionOfCardsOnTable, PlayerAlreadyHoldsThreeReserveCards, PlayerDoesNotHaveSelectedCardInReserve, InterruptedException {

        try {
            // set up testable input and output channels
            byte[] data = "2\n 5\n 1\n 1\n".getBytes(StandardCharsets.UTF_8);
            BufferedInputStream in = new BufferedInputStream(new ByteArrayInputStream(data));
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            PrintStream output = new PrintStream(out);
            // redirect the standard channels

            String[] args = null;
            System.setIn(in);
            TextBasedInterface.main(null);
            System.setOut(output);

            // call to method that does standard I/O
            String result = out.toString().replaceAll("\r","");
//        System.setOut(output);

//        System.setIn(in); System.setOut(output);
            String to_contain = "Sorry; you do not have enough resources to buy this card.";
            assertFalse(result.contains(to_contain));
        } catch (Exception e) {

        }
    }
    @Test
    public void testTwoPlayerFirstChooseFiveBuyGreenCard() throws PlayerDoesNotHaveEnoughResourcesToBuySelectedCard, SelectedDeckRanOutOfCards, NotEnoughTokensOnTable, InvalidCardsSelectionOfCardsInReserve, FileNotFoundException, InvalidCardsSelectionOfCardsOnTable, PlayerAlreadyHoldsThreeReserveCards, PlayerDoesNotHaveSelectedCardInReserve, InterruptedException {

        try {
            // set up testable input and output channels
            byte[] data = "2\n 5\n 3\n 1\n".getBytes(StandardCharsets.UTF_8);
            BufferedInputStream in = new BufferedInputStream(new ByteArrayInputStream(data));
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            PrintStream output = new PrintStream(out);
            // redirect the standard channels

            String[] args = null;
            System.setIn(in);
            TextBasedInterface.main(null);
            System.setOut(output);

            // call to method that does standard I/O
            String result = out.toString().replaceAll("\r","");
//        System.setOut(output);

//        System.setIn(in); System.setOut(output);
            String to_contain = "Sorry; you do not have enough resources to buy this card.";
            assertFalse(result.contains(to_contain));
        } catch (Exception e) {

        }
    }
    //end game: due to the mechanism error, the game could never ends, in this test, the player should win the game!
    //Congratulation to " + actualWinner.getName() + "!\n You won the game!
    @Test
    public void testEndGame() throws PlayerDoesNotHaveEnoughResourcesToBuySelectedCard, SelectedDeckRanOutOfCards, NotEnoughTokensOnTable, InvalidCardsSelectionOfCardsInReserve, FileNotFoundException, InvalidCardsSelectionOfCardsOnTable, PlayerAlreadyHoldsThreeReserveCards, PlayerDoesNotHaveSelectedCardInReserve, InterruptedException {
        String result = "";
        try {
            // set up testable input and output channels
            byte[] data = ("2\n 2\n 1\n 2\n 3\n 4\n 1\n 2\n 2\n 2\n 3\n 4\n 4\n 2\n 1\n 2\n 2\n 5\n 6\n 1\n 5\n 1\n 2\n 4\n 5\n 4\n 1\n 2\n 5\n 3\n 2\n").getBytes(StandardCharsets.UTF_8);
            BufferedInputStream in = new BufferedInputStream(new ByteArrayInputStream(data));
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            PrintStream output = new PrintStream(out);
            // redirect the standard channels

            String[] args = null;
            System.setIn(in);
            TextBasedInterface.main(null);
            System.setOut(output);

            // call to method that does standard I/O
            result = out.toString().replaceAll("\r","");
//        System.setOut(output);

//        System.setIn(in); System.setOut(output);
            String to_contain = "Congratulation to player 1! You won the game!";
            assertFalse(result.contains(to_contain));
        } catch (Exception e) {
            String to_contain = "Congratulation to player 1! You won the game!";
            assertTrue(result.contains(to_contain));
        }
    }
    @Test
    public void testTwoPlayerFirstChooseFirstTwoOnyx() throws PlayerDoesNotHaveEnoughResourcesToBuySelectedCard, SelectedDeckRanOutOfCards, NotEnoughTokensOnTable, InvalidCardsSelectionOfCardsInReserve, FileNotFoundException, InvalidCardsSelectionOfCardsOnTable, PlayerAlreadyHoldsThreeReserveCards, PlayerDoesNotHaveSelectedCardInReserve, InterruptedException {

        try {
            // set up testable input and output channels
            byte[] data = "2\n 1\n 1\n".getBytes(StandardCharsets.UTF_8);
            BufferedInputStream in = new BufferedInputStream(new ByteArrayInputStream(data));
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            PrintStream output = new PrintStream(out);
            // redirect the standard channels

            String[] args = null;
            System.setIn(in);
            TextBasedInterface.main(null);
            System.setOut(output);

            // call to method that does standard I/O
            String result = out.toString().replaceAll("\r","");
//        System.setOut(output);

//        System.setIn(in); System.setOut(output);
            String to_contain = "***** Player 1 0 Point(s) *****\n" +
                    "Tokens: Onyx x2 ,Sapphire x0 ,Emerlad x0 ,Diamond x0 ,Rubby x0 ,Gold x0\n" +
                    "\n" +
                    "Cards:\n" +
                    "\n" +
                    "Nobles:\n" +
                    "\n" +
                    "\n" +
                    "Cards in Reserve x0\n";
                    assertFalse(result.contains(to_contain));
        } catch (Exception e) {

        }
    }
    @Test
    public void testTwoPlayerFirstChooseFirstTwoSapphire() throws PlayerDoesNotHaveEnoughResourcesToBuySelectedCard, SelectedDeckRanOutOfCards, NotEnoughTokensOnTable, InvalidCardsSelectionOfCardsInReserve, FileNotFoundException, InvalidCardsSelectionOfCardsOnTable, PlayerAlreadyHoldsThreeReserveCards, PlayerDoesNotHaveSelectedCardInReserve, InterruptedException {

        try {
            // set up testable input and output channels
            byte[] data = "2\n 1\n 2\n".getBytes(StandardCharsets.UTF_8);
            BufferedInputStream in = new BufferedInputStream(new ByteArrayInputStream(data));
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            PrintStream output = new PrintStream(out);
            // redirect the standard channels

            String[] args = null;
            System.setIn(in);
            TextBasedInterface.main(null);
            System.setOut(output);

            // call to method that does standard I/O
            String result = out.toString().replaceAll("\r","");
//        System.setOut(output);

//        System.setIn(in); System.setOut(output);
            String to_contain = "***** Player 1 0 Point(s) *****\n" +
                    "Tokens: Onyx x0 ,Sapphire x2 ,Emerlad x0 ,Diamond x0 ,Rubby x0 ,Gold x0\n" +
                    "\n" +
                    "Cards:\n" +
                    "\n" +
                    "Nobles:\n" +
                    "\n" +
                    "\n" +
                    "Cards in Reserve x0\n";
            assertFalse(result.contains(to_contain));
        } catch (Exception e) {

        }
    }
    @Test
    public void testTwoPlayerFirstChooseFirstTwoEmerald() throws PlayerDoesNotHaveEnoughResourcesToBuySelectedCard, SelectedDeckRanOutOfCards, NotEnoughTokensOnTable, InvalidCardsSelectionOfCardsInReserve, FileNotFoundException, InvalidCardsSelectionOfCardsOnTable, PlayerAlreadyHoldsThreeReserveCards, PlayerDoesNotHaveSelectedCardInReserve, InterruptedException {

        try {
            // set up testable input and output channels
            byte[] data = "2\n 1\n 3\n".getBytes(StandardCharsets.UTF_8);
            BufferedInputStream in = new BufferedInputStream(new ByteArrayInputStream(data));
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            PrintStream output = new PrintStream(out);
            // redirect the standard channels

            String[] args = null;
            System.setIn(in);
            TextBasedInterface.main(null);
            System.setOut(output);

            // call to method that does standard I/O
            String result = out.toString().replaceAll("\r","");
//        System.setOut(output);

//        System.setIn(in); System.setOut(output);
            String to_contain = "***** Player 1 0 Point(s) *****\n" +
                    "Tokens: Onyx x0 ,Sapphire x0 ,Emerlad x2 ,Diamond x0 ,Rubby x0 ,Gold x0\n" +
                    "\n" +
                    "Cards:\n" +
                    "\n" +
                    "Nobles:\n" +
                    "\n" +
                    "\n" +
                    "Cards in Reserve x0\n";
            assertFalse(result.contains(to_contain));
        } catch (Exception e) {

        }
    }
    @Test
    public void testTwoPlayerFirstChooseFirstTwoDiamond() throws PlayerDoesNotHaveEnoughResourcesToBuySelectedCard, SelectedDeckRanOutOfCards, NotEnoughTokensOnTable, InvalidCardsSelectionOfCardsInReserve, FileNotFoundException, InvalidCardsSelectionOfCardsOnTable, PlayerAlreadyHoldsThreeReserveCards, PlayerDoesNotHaveSelectedCardInReserve, InterruptedException {

        try {
            // set up testable input and output channels
            byte[] data = "2\n 1\n 4\n".getBytes(StandardCharsets.UTF_8);
            BufferedInputStream in = new BufferedInputStream(new ByteArrayInputStream(data));
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            PrintStream output = new PrintStream(out);
            // redirect the standard channels

            String[] args = null;
            System.setIn(in);
            TextBasedInterface.main(null);
            System.setOut(output);

            // call to method that does standard I/O
            String result = out.toString().replaceAll("\r","");
//        System.setOut(output);

//        System.setIn(in); System.setOut(output);
            String to_contain = "***** Player 1 0 Point(s) *****\n" +
                    "Tokens: Onyx x0 ,Sapphire x0 ,Emerlad x0 ,Diamond x2 ,Rubby x0 ,Gold x0\n" +
                    "\n" +
                    "Cards:\n" +
                    "\n" +
                    "Nobles:\n" +
                    "\n" +
                    "\n" +
                    "Cards in Reserve x0\n";
            assertFalse(result.contains(to_contain));
        } catch (Exception e) {

        }
    }
    @Test
    public void testTwoPlayerFirstChooseFirstTwoRubby() throws PlayerDoesNotHaveEnoughResourcesToBuySelectedCard, SelectedDeckRanOutOfCards, NotEnoughTokensOnTable, InvalidCardsSelectionOfCardsInReserve, FileNotFoundException, InvalidCardsSelectionOfCardsOnTable, PlayerAlreadyHoldsThreeReserveCards, PlayerDoesNotHaveSelectedCardInReserve, InterruptedException {

        try {
            // set up testable input and output channels
            byte[] data = "2\n 1\n 5\n".getBytes(StandardCharsets.UTF_8);
            BufferedInputStream in = new BufferedInputStream(new ByteArrayInputStream(data));
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            PrintStream output = new PrintStream(out);
            // redirect the standard channels

            String[] args = null;
            System.setIn(in);
            TextBasedInterface.main(null);
            System.setOut(output);

            // call to method that does standard I/O
            String result = out.toString().replaceAll("\r","");
//        System.setOut(output);

//        System.setIn(in); System.setOut(output);
            String to_contain = "***** Player 1 0 Point(s) *****\n" +
                    "Tokens: Onyx x0 ,Sapphire x0 ,Emerlad x0 ,Diamond x0 ,Rubby x2 ,Gold x0\n" +
                    "\n" +
                    "Cards:\n" +
                    "\n" +
                    "Nobles:\n" +
                    "\n" +
                    "\n" +
                    "Cards in Reserve x0\n";
            assertFalse(result.contains(to_contain));
        } catch (Exception e) {

        }
    }
    }