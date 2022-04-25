
package blackBoxTest;

import Interface.*;
import Classes.*;
import Exceptions.*;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.nio.charset.StandardCharsets;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class testTextBasedInterface {
    // if choose the whenever select the same
    @Test
    public void testRepeatedToken() throws PlayerDoesNotHaveEnoughResourcesToBuySelectedCard, SelectedDeckRanOutOfCards, NotEnoughTokensOnTable, InvalidCardsSelectionOfCardsInReserve, FileNotFoundException, InvalidCardsSelectionOfCardsOnTable, PlayerAlreadyHoldsThreeReserveCards, PlayerDoesNotHaveSelectedCardInReserve, InterruptedException {
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
        String expected = "";
//        String expected = "Welcome to Splendor! How many player(s) do you wish to have(including yourself)?\n" +
//                "2. 2    3. 3.    4. 4\n" +
//                "2\n" +
//                "Check0 completed\n" +
//                "Check1 completed\n" +
//                "Check2 completed\n" +
//                "Check3 completed\n" +
//                "check4 completed\n" +
//                "Awesome! lets start the game!\n" +
//                "\n" +
//                "\n" +
//                "***** Player 1 0 Point(s) *****\n" +
//                "Tokens: Onyx x0 ,Sapphire x0 ,Emerlad x0 ,Diamond x0 ,Rubby x0 ,Gold x0\n" +
//                "\n" +
//                "Cards:\n" +
//                "\n" +
//                "Nobles:\n" +
//                "\n" +
//                "\n" +
//                "Cards in Reserve x0\n" +
//                "*******************************\n" +
//                "\n" +
//                "***** Player 2 0 Point(s) *****\n" +
//                "Tokens: Onyx x0 ,Sapphire x0 ,Emerlad x0 ,Diamond x0 ,Rubby x0 ,Gold x0\n" +
//                "\n" +
//                "Cards:\n" +
//                "\n" +
//                "Nobles:\n" +
//                "\n" +
//                "\n" +
//                "Cards in Reserve x0\n" +
//                "*******************************\n" +
//                "\n" +
//                "/////////////////////////////////////\n" +
//                "Blue Deck\n" +
//                "Blue Card 1:\n" +
//                "4     Diamond  Town\n" +
//                "Diamond x3 Rubby x3 Onyx x6\n" +
//                "\n" +
//                "Blue Card 2:\n" +
//                "5     Sapphire  Town\n" +
//                "Diamond x7 Sapphire x3\n" +
//                "\n" +
//                "Blue Card 3:\n" +
//                "5     Rubby  Town\n" +
//                "Rubby x3 Emerald x7\n" +
//                "\n" +
//                "Blue Card 4:\n" +
//                "4     Diamond  Town\n" +
//                "Diamond x3 Rubby x3 Onyx x6\n" +
//                "\n" +
//                "/////////////////////////\n" +
//                "Yellow Deck\n" +
//                "Yellow Card 1:\n" +
//                "2     Rubby  Town\n" +
//                "Diamond x1 Emerald x2 Sapphire x4\n" +
//                "\n" +
//                "Yellow Card 2:\n" +
//                "2     Sapphire  Town\n" +
//                "Diamond x2 Rubby x1 Onyx x4\n" +
//                "\n" +
//                "Yellow Card 3:\n" +
//                "3     Emerald  Town\n" +
//                "Emerald x6\n" +
//                "\n" +
//                "Yellow Card 4:\n" +
//                "2     Rubby  Town\n" +
//                "Diamond x3 Onyx x5\n" +
//                "\n" +
//                "/////////////////////////\n" +
//                "Green Deck\n" +
//                "Green Card 1:\n" +
//                "0     Rubby  Town\n" +
//                "Diamond x1 Emerald x1 Onyx x1 Sapphire x2\n" +
//                "\n" +
//                "Green Card 2:\n" +
//                "0     Sapphire  Town\n" +
//                "Emerald x2 Onyx x2\n" +
//                "\n" +
//                "Green Card 3:\n" +
//                "0     Rubby  Town\n" +
//                "Diamond x2 Rubby x2\n" +
//                "\n" +
//                "Green Card 4:\n" +
//                "0     Emerald  Town\n" +
//                "Diamond x1 Rubby x1 Onyx x2 Sapphire x1\n" +
//                "\n" +
//                "/////////////////////////////////////\n" +
//                "Tokens Avalible: Onyx x4 ,Sapphire x4 ,Emerald x4 ,Diamond x4 ,Rubby x4 ,Gold x4\n" +
//                "\n" +
//                "Nobles Avalible:\n" +
//                "\n" +
//                "******* G Mine S *******\n" +
//                "Diamond x1    Rubby x2    Emerald x2\n" +
//                "\n" +
//                "\n" +
//                "******* G Mine S *******\n" +
//                "Diamond x1    Rubby x1    Emerald x1    Onyx x1\n" +
//                "\n" +
//                "\n" +
//                "******* G Mine E *******\n" +
//                "Rubby x3\n" +
//                "\n" +
//                "\n" +
//                "******* G Mine E *******\n" +
//                "Rubby x2    Onyx x2    Sapphire x1\n" +
//                "\n" +
//                "\n" +
//                "******* G Mine E *******\n" +
//                "Diamond x1    Rubby x1    Onyx x1    Sapphire x1\n" +
//                "\n" +
//                "\n" +
//                "******* G Mine E *******\n" +
//                "Diamond x1    Rubby x1    Onyx x2    Sapphire x1\n" +
//                "\n" +
//                "\n" +
//                "******* G Mine E *******\n" +
//                "Diamond x1    Emerald x1    Sapphire x3\n" +
//                "\n" +
//                "\n" +
//                "******* G Mine E *******\n" +
//                "Rubby x2    Sapphire x2\n" +
//                "\n" +
//                "\n" +
//                "******* G Mine E *******\n" +
//                "Diamond x2    Sapphire x1\n" +
//                "\n" +
//                "\n" +
//                "******* G Mine R *******\n" +
//                "Diamond x4\n" +
//                "\n" +
//                "\n" +
//                "******* G Mine R *******\n" +
//                "Diamond x2    Rubby x2\n" +
//                "\n" +
//                "\n" +
//                "******* G Mine R *******\n" +
//                "Diamond x1    Emerald x1    Onyx x1    Sapphire x1\n" +
//                "\n" +
//                "\n" +
//                "******* G Mine R *******\n" +
//                "Diamond x1    Emerald x1    Onyx x1    Sapphire x2\n" +
//                "\n" +
//                "\n" +
//                "******* G Mine R *******\n" +
//                "Diamond x2    Emerald x1    Onyx x1\n" +
//                "\n" +
//                "\n" +
//                "******* G Mine R *******\n" +
//                "Emerald x1    Sapphire x2\n" +
//                "\n" +
//                "\n" +
//                "******* G Mine R *******\n" +
//                "Diamond x1    Rubby x1    Onyx x3\n" +
//                "\n" +
//                "\n" +
//                "******* G Mine R *******\n" +
//                "Diamond x3\n" +
//                "\n" +
//                "\n" +
//                "******* G Mine D *******\n" +
//                "Emerald x4\n" +
//                "\n" +
//                "\n" +
//                "******* G Mine D *******\n" +
//                "Diamond x3    Onyx x1    Sapphire x1\n" +
//                "\n" +
//                "\n" +
//                "******* G Mine D *******\n" +
//                "Rubby x1    Emerald x2    Onyx x1    Sapphire x1\n" +
//                "\n" +
//                "\n" +
//                "******* G Mine D *******\n" +
//                "Onyx x2    Sapphire x2\n" +
//                "\n" +
//                "\n" +
//                "******* G Mine D *******\n" +
//                "Sapphire x3\n" +
//                "\n" +
//                "\n" +
//                "******* G Mine D *******\n" +
//                "Rubby x1    Emerald x1    Onyx x1    Sapphire x1\n" +
//                "\n" +
//                "\n" +
//                "******* G Mine D *******\n" +
//                "Rubby x2    Onyx x1\n" +
//                "\n" +
//                "\n" +
//                "******* G Mine D *******\n" +
//                "Emerald x2    Onyx x1    Sapphire x2\n" +
//                "\n" +
//                "\n" +
//                "******* G Mine O *******\n" +
//                "Sapphire x4\n" +
//                "\n" +
//                "\n" +
//                "******* G Mine O *******\n" +
//                "Diamond x2    Rubby x2    Sapphire x2\n" +
//                "\n" +
//                "\n" +
//                "******* G Mine O *******\n" +
//                "Diamond x1    Rubby x1    Emerald x1    Sapphire x2\n" +
//                "\n" +
//                "\n" +
//                "******* G Mine O *******\n" +
//                "Emerald x3\n" +
//                "\n" +
//                "\n" +
//                "******* G Mine O *******\n" +
//                "Rubby x3    Emerald x1    Onyx x1\n" +
//                "\n" +
//                "\n" +
//                "******* G Mine O *******\n" +
//                "Diamond x2    Emerald x2\n" +
//                "\n" +
//                "\n" +
//                "******* G Mine O *******\n" +
//                "Rubby x1    Emerald x2\n" +
//                "\n" +
//                "\n" +
//                "******* G Mine O *******\n" +
//                "Diamond x1    Rubby x1    Emerald x1    Sapphire x1\n" +
//                "\n" +
//                "\n" +
//                "******* Y Merchant S *******\n" +
//                "Sapphire x6\n" +
//                "\n" +
//                "\n" +
//                "******* Y Merchant S *******\n" +
//                "Diamond x2    Rubby x1    Onyx x4\n" +
//                "\n" +
//                "\n" +
//                "******* Y Merchant S *******\n" +
//                "Sapphire x5\n" +
//                "\n" +
//                "\n" +
//                "******* Y Transports S *******\n" +
//                "Diamond x3    Sapphire x3\n" +
//                "\n" +
//                "\n" +
//                "******* Y Transports S *******\n" +
//                "Emerald x3    Onyx x3    Sapphire x2\n" +
//                "\n" +
//                "\n" +
//                "******* Y Transports S *******\n" +
//                "Rubby x3    Emerald x2    Sapphire x2\n" +
//                "\n" +
//                "\n" +
//                "******* Y Transports E *******\n" +
//                "Emerald x6\n" +
//                "\n" +
//                "\n" +
//                "******* Y Transports E *******\n" +
//                "Emerald x3    Sapphire x3\n" +
//                "\n" +
//                "\n" +
//                "******* Y Transports E *******\n" +
//                "Emerald x5\n" +
//                "\n" +
//                "\n" +
//                "******* Y Merchant E *******\n" +
//                "Diamond x4    Onyx x1    Sapphire x2\n" +
//                "\n" +
//                "\n" +
//                "******* Y Merchant E *******\n" +
//                "Diamond x2    Onyx x2    Sapphire x3\n" +
//                "\n" +
//                "\n" +
//                "******* Y Merchant E *******\n" +
//                "Diamond x3    Rubby x3    Emerald x2\n" +
//                "\n" +
//                "\n" +
//                "******* Y Merchant R *******\n" +
//                "Rubby x6\n" +
//                "\n" +
//                "\n" +
//                "******* Y Merchant R *******\n" +
//                "Onyx x5\n" +
//                "\n" +
//                "\n" +
//                "******* Y Merchant R *******\n" +
//                "Diamond x3    Onyx x5\n" +
//                "\n" +
//                "\n" +
//                "******* Y Transports R *******\n" +
//                "Diamond x1    Emerald x2    Sapphire x4\n" +
//                "\n" +
//                "\n" +
//                "******* Y Transports R *******\n" +
//                "Diamond x2    Rubby x2    Onyx x3\n" +
//                "\n" +
//                "\n" +
//                "******* Y Transports R *******\n" +
//                "Rubby x2    Onyx x3    Sapphire x3\n" +
//                "\n" +
//                "\n" +
//                "******* Y Merchant D *******\n" +
//                "Diamond x6\n" +
//                "\n" +
//                "\n" +
//                "******* Y Merchant D *******\n" +
//                "Rubby x5    Onyx x3\n" +
//                "\n" +
//                "\n" +
//                "******* Y Merchant D *******\n" +
//                "Rubby x5\n" +
//                "\n" +
//                "\n" +
//                "******* Y Transports D *******\n" +
//                "Rubby x4    Emerald x1    Onyx x2\n" +
//                "\n" +
//                "\n" +
//                "******* Y Transports D *******\n" +
//                "Diamond x2    Rubby x3    Sapphire x3\n" +
//                "\n" +
//                "\n" +
//                "******* Y Transports D *******\n" +
//                "Rubby x2    Emerald x3    Onyx x2\n" +
//                "\n" +
//                "\n" +
//                "******* Y Merchant O *******\n" +
//                "Onyx x6\n" +
//                "\n" +
//                "\n" +
//                "******* Y Merchant O *******\n" +
//                "Rubby x3    Emerald x5\n" +
//                "\n" +
//                "\n" +
//                "******* Y Merchant O *******\n" +
//                "Diamond x5\n" +
//                "\n" +
//                "\n" +
//                "******* Y Transports O *******\n" +
//                "Rubby x2    Emerald x4    Sapphire x1\n" +
//                "\n" +
//                "\n" +
//                "******* Y Transports O *******\n" +
//                "Diamond x3    Emerald x3    Onyx x2\n" +
//                "\n" +
//                "\n" +
//                "******* Y Transports O *******\n" +
//                "Diamond x3    Emerald x2    Sapphire x3\n" +
//                "\n" +
//                "\n" +
//                "******* B Town S *******\n" +
//                "Diamond x7    Sapphire x3\n" +
//                "\n" +
//                "\n" +
//                "******* B Town S *******\n" +
//                "Diamond x6    Onyx x3    Sapphire x3\n" +
//                "\n" +
//                "\n" +
//                "******* B Shop S *******\n" +
//                "Diamond x7    Sapphire x3\n" +
//                "\n" +
//                "\n" +
//                "******* B Shop S *******\n" +
//                "Diamond x3    Rubby x3    Emerald x3    Onyx x5\n" +
//                "\n" +
//                "\n" +
//                "******* B Town E *******\n" +
//                "Emerald x3    Sapphire x7\n" +
//                "\n" +
//                "\n" +
//                "******* B Shop E *******\n" +
//                "Sapphire x7\n" +
//                "\n" +
//                "\n" +
//                "******* B Shop E *******\n" +
//                "Diamond x3    Emerald x3    Sapphire x6\n" +
//                "\n" +
//                "\n" +
//                "******* B Town E *******\n" +
//                "Diamond x5    Rubby x3    Onyx x3    Sapphire x3\n" +
//                "\n" +
//                "\n" +
//                "******* B Town R *******\n" +
//                "Rubby x3    Emerald x7\n" +
//                "\n" +
//                "\n" +
//                "******* B Town R *******\n" +
//                "Rubby x3    Emerald x6    Sapphire x3\n" +
//                "\n" +
//                "\n" +
//                "******* B Shop R *******\n" +
//                "Emerald x7\n" +
//                "\n" +
//                "\n" +
//                "******* B Shop R *******\n" +
//                "Diamond x3    Emerald x3    Sapphire x5\n" +
//                "\n" +
//                "\n" +
//                "******* B Shop D *******\n" +
//                "Diamond x3    Onyx x7\n" +
//                "\n" +
//                "\n" +
//                "******* B Town D *******\n" +
//                "Diamond x3    Rubby x3    Onyx x6\n" +
//                "\n" +
//                "\n" +
//                "******* B Town D *******\n" +
//                "Onyx x7\n" +
//                "\n" +
//                "\n" +
//                "******* B Shop D *******\n" +
//                "Rubby x5    Emerald x3    Onyx x3    Sapphire x3\n" +
//                "\n" +
//                "\n" +
//                "******* B Town O *******\n" +
//                "Rubby x7    Onyx x3\n" +
//                "\n" +
//                "\n" +
//                "******* B Shop O *******\n" +
//                "Rubby x6    Emerald x3    Onyx x3\n" +
//                "\n" +
//                "\n" +
//                "******* B Shop O *******\n" +
//                "Rubby x7\n" +
//                "\n" +
//                "\n" +
//                "******* B Town O *******\n" +
//                "Diamond x3    Rubby x3    Emerald x5    Sapphire x3\n" +
//                "\n" +
//                "\n" +
//                "\n" +
//                "It is Player 1's turn!\n" +
//                "Player 1, here is what you currently have:\n" +
//                "\n" +
//                "\n" +
//                "***** Player 1 0 Point(s) *****\n" +
//                "Tokens: Onyx x0 ,Sapphire x0 ,Emerlad x0 ,Diamond x0 ,Rubby x0 ,Gold x0\n" +
//                "\n" +
//                "**** Cards ****\n" +
//                "\n" +
//                "**** Nobles ****\n" +
//                "\n" +
//                "\n" +
//                "**** Cards in Reserve ****\n" +
//                "\n" +
//                "\n" +
//                "Player 1, what do you wish to do this round?\n" +
//                "\n" +
//                "1. Take 2 tokens of the same color from the table(may only be performed if there is 4 or more tokens in the color of your chosing)\n" +
//                "2. Take 1 token from each of 3 different types of tokens(excluding gold)\n" +
//                "3. Reserve a card on the table and receive one gold token(keep in mind you may only have three reserved cards maximum. Also, you will not recieve any gold token if there is non on the table)\n" +
//                "4. Reserve an unknown card from the top of a chosen deck\n" +
//                "5. Buy a card from your reserved cards\n" +
//                "6. Buy a card on the table\n" +
//                "2\n" +
//                "Choose a token to take.\n" +
//                "1. Onyx x4 2. Sapphire x4 3. Emerald x4 4. Diamond x4 5. Rubby x4\n" +
//                "2\n" +
//                "Choose a different token that you have not selected.\n" +
//                "1. Onyx x4 2. Sapphire x4 3. Emerald x4 4. Diamond x4 5. Rubby x4\n" +
//                "3\n" +
//                "Choose another different token that you have not selected.\n" +
//                "1. Onyx x4 2. Sapphire x4 3. Emerald x4 4. Diamond4 5. Rubby x4 6. Gold x4\n" +
//                "3\n" +
//                "Invalid choice. You have chosen this token already.\n" +
//                "Choose a token to take.\n" +
//                "1. Onyx x4 2. Sapphire x4 3. Emerald x4 4. Diamond x4 5. Rubby x4\n" +
//                "4\n" +
//                "3YOLOSWAG2\n" +
//                "Possibly not Working\n" +
//                "6YOLOSWAG2\n" +
//                "Possibly not Working\n" +
//                "9YOLOSWAG2\n" +
//                "Possibly not Working\n" +
//                "12YOLOSWAG2\n" +
//                "Working\n" +
//                "15YOLOSWAG2\n" +
//                "Working\n" +
//                "\n" +
//                "\n" +
//                "\n" +
//                "\n" +
//                "\n" +
//                "***** Player 1 0 Point(s) *****\n" +
//                "Tokens: Onyx x3 ,Sapphire x4 ,Emerlad x5 ,Diamond x2 ,Rubby x1 ,Gold x0\n" +
//                "\n" +
//                "Cards:\n" +
//                "\n" +
//                "Nobles:\n" +
//                "\n" +
//                "\n" +
//                "Cards in Reserve x0\n" +
//                "*******************************\n" +
//                "\n" +
//                "***** Player 2 0 Point(s) *****\n" +
//                "Tokens: Onyx x0 ,Sapphire x0 ,Emerlad x0 ,Diamond x0 ,Rubby x0 ,Gold x0\n" +
//                "\n" +
//                "Cards:\n" +
//                "\n" +
//                "Nobles:\n" +
//                "\n" +
//                "\n" +
//                "Cards in Reserve x0\n" +
//                "*******************************\n" +
//                "\n" +
//                "/////////////////////////////////////\n" +
//                "Blue Deck\n" +
//                "Blue Card 1:\n" +
//                "4     Diamond  Town\n" +
//                "Diamond x3 Rubby x3 Onyx x6\n" +
//                "\n" +
//                "Blue Card 2:\n" +
//                "5     Sapphire  Town\n" +
//                "Diamond x7 Sapphire x3\n" +
//                "\n" +
//                "Blue Card 3:\n" +
//                "5     Rubby  Town\n" +
//                "Rubby x3 Emerald x7\n" +
//                "\n" +
//                "Blue Card 4:\n" +
//                "4     Diamond  Town\n" +
//                "Diamond x3 Rubby x3 Onyx x6\n" +
//                "\n" +
//                "/////////////////////////\n" +
//                "Yellow Deck\n" +
//                "Yellow Card 1:\n" +
//                "2     Rubby  Town\n" +
//                "Diamond x1 Emerald x2 Sapphire x4\n" +
//                "\n" +
//                "Yellow Card 2:\n" +
//                "2     Sapphire  Town\n" +
//                "Diamond x2 Rubby x1 Onyx x4\n" +
//                "\n" +
//                "Yellow Card 3:\n" +
//                "3     Emerald  Town\n" +
//                "Emerald x6\n" +
//                "\n" +
//                "Yellow Card 4:\n" +
//                "2     Rubby  Town\n" +
//                "Diamond x3 Onyx x5\n" +
//                "\n" +
//                "/////////////////////////\n" +
//                "Green Deck\n" +
//                "Green Card 1:\n" +
//                "0     Rubby  Town\n" +
//                "Diamond x1 Emerald x1 Onyx x1 Sapphire x2\n" +
//                "\n" +
//                "Green Card 2:\n" +
//                "0     Sapphire  Town\n" +
//                "Emerald x2 Onyx x2\n" +
//                "\n" +
//                "Green Card 3:\n" +
//                "0     Rubby  Town\n" +
//                "Diamond x2 Rubby x2\n" +
//                "\n" +
//                "Green Card 4:\n" +
//                "0     Emerald  Town\n" +
//                "Diamond x1 Rubby x1 Onyx x2 Sapphire x1\n" +
//                "\n" +
//                "/////////////////////////////////////\n" +
//                "Tokens Avalible: Onyx x1 ,Sapphire x0 ,Emerald x0 ,Diamond x2 ,Rubby x3 ,Gold x4\n" +
//                "\n" +
//                "Nobles Avalible:\n" +
//                "\n" +
//                "******* G Mine S *******\n" +
//                "Diamond x1    Rubby x2    Emerald x2\n" +
//                "\n" +
//                "\n" +
//                "******* G Mine S *******\n" +
//                "Diamond x1    Rubby x1    Emerald x1    Onyx x1\n" +
//                "\n" +
//                "\n" +
//                "******* G Mine E *******\n" +
//                "Rubby x3\n" +
//                "\n" +
//                "\n" +
//                "******* G Mine E *******\n" +
//                "Rubby x2    Onyx x2    Sapphire x1\n" +
//                "\n" +
//                "\n" +
//                "******* G Mine E *******\n" +
//                "Diamond x1    Rubby x1    Onyx x1    Sapphire x1\n" +
//                "\n" +
//                "\n" +
//                "******* G Mine E *******\n" +
//                "Diamond x1    Rubby x1    Onyx x2    Sapphire x1\n" +
//                "\n" +
//                "\n" +
//                "******* G Mine E *******\n" +
//                "Diamond x1    Emerald x1    Sapphire x3\n" +
//                "\n" +
//                "\n" +
//                "******* G Mine E *******\n" +
//                "Rubby x2    Sapphire x2\n" +
//                "\n" +
//                "\n" +
//                "******* G Mine E *******\n" +
//                "Diamond x2    Sapphire x1\n" +
//                "\n" +
//                "\n" +
//                "******* G Mine R *******\n" +
//                "Diamond x4\n" +
//                "\n" +
//                "\n" +
//                "******* G Mine R *******\n" +
//                "Diamond x2    Rubby x2\n" +
//                "\n" +
//                "\n" +
//                "******* G Mine R *******\n" +
//                "Diamond x1    Emerald x1    Onyx x1    Sapphire x1\n" +
//                "\n" +
//                "\n" +
//                "******* G Mine R *******\n" +
//                "Diamond x1    Emerald x1    Onyx x1    Sapphire x2\n" +
//                "\n" +
//                "\n" +
//                "******* G Mine R *******\n" +
//                "Diamond x2    Emerald x1    Onyx x1\n" +
//                "\n" +
//                "\n" +
//                "******* G Mine R *******\n" +
//                "Emerald x1    Sapphire x2\n" +
//                "\n" +
//                "\n" +
//                "******* G Mine R *******\n" +
//                "Diamond x1    Rubby x1    Onyx x3\n" +
//                "\n" +
//                "\n" +
//                "******* G Mine R *******\n" +
//                "Diamond x3\n" +
//                "\n" +
//                "\n" +
//                "******* G Mine D *******\n" +
//                "Emerald x4\n" +
//                "\n" +
//                "\n" +
//                "******* G Mine D *******\n" +
//                "Diamond x3    Onyx x1    Sapphire x1\n" +
//                "\n" +
//                "\n" +
//                "******* G Mine D *******\n" +
//                "Rubby x1    Emerald x2    Onyx x1    Sapphire x1\n" +
//                "\n" +
//                "\n" +
//                "******* G Mine D *******\n" +
//                "Onyx x2    Sapphire x2\n" +
//                "\n" +
//                "\n" +
//                "******* G Mine D *******\n" +
//                "Sapphire x3\n" +
//                "\n" +
//                "\n" +
//                "******* G Mine D *******\n" +
//                "Rubby x1    Emerald x1    Onyx x1    Sapphire x1\n" +
//                "\n" +
//                "\n" +
//                "******* G Mine D *******\n" +
//                "Rubby x2    Onyx x1\n" +
//                "\n" +
//                "\n" +
//                "******* G Mine D *******\n" +
//                "Emerald x2    Onyx x1    Sapphire x2\n" +
//                "\n" +
//                "\n" +
//                "******* G Mine O *******\n" +
//                "Sapphire x4\n" +
//                "\n" +
//                "\n" +
//                "******* G Mine O *******\n" +
//                "Diamond x2    Rubby x2    Sapphire x2\n" +
//                "\n" +
//                "\n" +
//                "******* G Mine O *******\n" +
//                "Diamond x1    Rubby x1    Emerald x1    Sapphire x2\n" +
//                "\n" +
//                "\n" +
//                "******* G Mine O *******\n" +
//                "Emerald x3\n" +
//                "\n" +
//                "\n" +
//                "******* G Mine O *******\n" +
//                "Rubby x3    Emerald x1    Onyx x1\n" +
//                "\n" +
//                "\n" +
//                "******* G Mine O *******\n" +
//                "Diamond x2    Emerald x2\n" +
//                "\n" +
//                "\n" +
//                "******* G Mine O *******\n" +
//                "Rubby x1    Emerald x2\n" +
//                "\n" +
//                "\n" +
//                "******* G Mine O *******\n" +
//                "Diamond x1    Rubby x1    Emerald x1    Sapphire x1\n" +
//                "\n" +
//                "\n" +
//                "******* Y Merchant S *******\n" +
//                "Sapphire x6\n" +
//                "\n" +
//                "\n" +
//                "******* Y Merchant S *******\n" +
//                "Diamond x2    Rubby x1    Onyx x4\n" +
//                "\n" +
//                "\n" +
//                "******* Y Merchant S *******\n" +
//                "Sapphire x5\n" +
//                "\n" +
//                "\n" +
//                "******* Y Transports S *******\n" +
//                "Diamond x3    Sapphire x3\n" +
//                "\n" +
//                "\n" +
//                "******* Y Transports S *******\n" +
//                "Emerald x3    Onyx x3    Sapphire x2\n" +
//                "\n" +
//                "\n" +
//                "******* Y Transports S *******\n" +
//                "Rubby x3    Emerald x2    Sapphire x2\n" +
//                "\n" +
//                "\n" +
//                "******* Y Transports E *******\n" +
//                "Emerald x6\n" +
//                "\n" +
//                "\n" +
//                "******* Y Transports E *******\n" +
//                "Emerald x3    Sapphire x3\n" +
//                "\n" +
//                "\n" +
//                "******* Y Transports E *******\n" +
//                "Emerald x5\n" +
//                "\n" +
//                "\n" +
//                "******* Y Merchant E *******\n" +
//                "Diamond x4    Onyx x1    Sapphire x2\n" +
//                "\n" +
//                "\n" +
//                "******* Y Merchant E *******\n" +
//                "Diamond x2    Onyx x2    Sapphire x3\n" +
//                "\n" +
//                "\n" +
//                "******* Y Merchant E *******\n" +
//                "Diamond x3    Rubby x3    Emerald x2\n" +
//                "\n" +
//                "\n" +
//                "******* Y Merchant R *******\n" +
//                "Rubby x6\n" +
//                "\n" +
//                "\n" +
//                "******* Y Merchant R *******\n" +
//                "Onyx x5\n" +
//                "\n" +
//                "\n" +
//                "******* Y Merchant R *******\n" +
//                "Diamond x3    Onyx x5\n" +
//                "\n" +
//                "\n" +
//                "******* Y Transports R *******\n" +
//                "Diamond x1    Emerald x2    Sapphire x4\n" +
//                "\n" +
//                "\n" +
//                "******* Y Transports R *******\n" +
//                "Diamond x2    Rubby x2    Onyx x3\n" +
//                "\n" +
//                "\n" +
//                "******* Y Transports R *******\n" +
//                "Rubby x2    Onyx x3    Sapphire x3\n" +
//                "\n" +
//                "\n" +
//                "******* Y Merchant D *******\n" +
//                "Diamond x6\n" +
//                "\n" +
//                "\n" +
//                "******* Y Merchant D *******\n" +
//                "Rubby x5    Onyx x3\n" +
//                "\n" +
//                "\n" +
//                "******* Y Merchant D *******\n" +
//                "Rubby x5\n" +
//                "\n" +
//                "\n" +
//                "******* Y Transports D *******\n" +
//                "Rubby x4    Emerald x1    Onyx x2\n" +
//                "\n" +
//                "\n" +
//                "******* Y Transports D *******\n" +
//                "Diamond x2    Rubby x3    Sapphire x3\n" +
//                "\n" +
//                "\n" +
//                "******* Y Transports D *******\n" +
//                "Rubby x2    Emerald x3    Onyx x2\n" +
//                "\n" +
//                "\n" +
//                "******* Y Merchant O *******\n" +
//                "Onyx x6\n" +
//                "\n" +
//                "\n" +
//                "******* Y Merchant O *******\n" +
//                "Rubby x3    Emerald x5\n" +
//                "\n" +
//                "\n" +
//                "******* Y Merchant O *******\n" +
//                "Diamond x5\n" +
//                "\n" +
//                "\n" +
//                "******* Y Transports O *******\n" +
//                "Rubby x2    Emerald x4    Sapphire x1\n" +
//                "\n" +
//                "\n" +
//                "******* Y Transports O *******\n" +
//                "Diamond x3    Emerald x3    Onyx x2\n" +
//                "\n" +
//                "\n" +
//                "******* Y Transports O *******\n" +
//                "Diamond x3    Emerald x2    Sapphire x3\n" +
//                "\n" +
//                "\n" +
//                "******* B Town S *******\n" +
//                "Diamond x7    Sapphire x3\n" +
//                "\n" +
//                "\n" +
//                "******* B Town S *******\n" +
//                "Diamond x6    Onyx x3    Sapphire x3\n" +
//                "\n" +
//                "\n" +
//                "******* B Shop S *******\n" +
//                "Diamond x7    Sapphire x3\n" +
//                "\n" +
//                "\n" +
//                "******* B Shop S *******\n" +
//                "Diamond x3    Rubby x3    Emerald x3    Onyx x5\n" +
//                "\n" +
//                "\n" +
//                "******* B Town E *******\n" +
//                "Emerald x3    Sapphire x7\n" +
//                "\n" +
//                "\n" +
//                "******* B Shop E *******\n" +
//                "Sapphire x7\n" +
//                "\n" +
//                "\n" +
//                "******* B Shop E *******\n" +
//                "Diamond x3    Emerald x3    Sapphire x6\n" +
//                "\n" +
//                "\n" +
//                "******* B Town E *******\n" +
//                "Diamond x5    Rubby x3    Onyx x3    Sapphire x3\n" +
//                "\n" +
//                "\n" +
//                "******* B Town R *******\n" +
//                "Rubby x3    Emerald x7\n" +
//                "\n" +
//                "\n" +
//                "******* B Town R *******\n" +
//                "Rubby x3    Emerald x6    Sapphire x3\n" +
//                "\n" +
//                "\n" +
//                "******* B Shop R *******\n" +
//                "Emerald x7\n" +
//                "\n" +
//                "\n" +
//                "******* B Shop R *******\n" +
//                "Diamond x3    Emerald x3    Sapphire x5\n" +
//                "\n" +
//                "\n" +
//                "******* B Shop D *******\n" +
//                "Diamond x3    Onyx x7\n" +
//                "\n" +
//                "\n" +
//                "******* B Town D *******\n" +
//                "Diamond x3    Rubby x3    Onyx x6\n" +
//                "\n" +
//                "\n" +
//                "******* B Town D *******\n" +
//                "Onyx x7\n" +
//                "\n" +
//                "\n" +
//                "******* B Shop D *******\n" +
//                "Rubby x5    Emerald x3    Onyx x3    Sapphire x3\n" +
//                "\n" +
//                "\n" +
//                "******* B Town O *******\n" +
//                "Rubby x7    Onyx x3\n" +
//                "\n" +
//                "\n" +
//                "******* B Shop O *******\n" +
//                "Rubby x6    Emerald x3    Onyx x3\n" +
//                "\n" +
//                "\n" +
//                "******* B Shop O *******\n" +
//                "Rubby x7\n" +
//                "\n" +
//                "\n" +
//                "******* B Town O *******\n" +
//                "Diamond x3    Rubby x3    Emerald x5    Sapphire x3\n" +
//                "\n" +
//                "\n" +
//                "\n" +
//                "Attention! Player 1 chose to take three tokens of different color!\n" +
//                "It is Player 2's turn!\n" +
//                "Player 2, here is what you currently have:\n" +
//                "\n" +
//                "\n" +
//                "***** Player 2 0 Point(s) *****\n" +
//                "Tokens: Onyx x0 ,Sapphire x0 ,Emerlad x0 ,Diamond x0 ,Rubby x0 ,Gold x0\n" +
//                "\n" +
//                "**** Cards ****\n" +
//                "\n" +
//                "**** Nobles ****\n" +
//                "\n" +
//                "\n" +
//                "**** Cards in Reserve ****\n" +
//                "\n" +
//                "\n" +
//                "Player 2, what do you wish to do this round?\n" +
//                "\n" +
//                "1. Take 2 tokens of the same color from the table(may only be performed if there is 4 or more tokens in the color of your chosing)\n" +
//                "2. Take 1 token from each of 3 different types of tokens(excluding gold)\n" +
//                "3. Reserve a card on the table and receive one gold token(keep in mind you may only have three reserved cards maximum. Also, you will not recieve any gold token if there is non on the table)\n" +
//                "4. Reserve an unknown card from the top of a chosen deck\n" +
//                "5. Buy a card from your reserved cards\n" +
//                "6. Buy a card on the table\n";


        // call to method that does standard I/O
        String result = out.toString().replaceAll("\r","");
        System.setOut(output);

//        System.setIn(in); System.setOut(output);
        assertEquals(expected,result);
    }
}