package whiteBoxTest;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Classes.*;
import Exceptions.*;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class GameTest {

    Tokens onyxToken;
    Tokens emeraldToken;
    Tokens sapphireToken;
    Tokens rubyToken;
    Tokens diamondToken;
    Tokens goldToken;

    ArrayList<Tokens> allTokens;
    ArrayList<Cards> blueDeck = new ArrayList<>();
    ArrayList<Cards> yellowDeck = new ArrayList<>();
    ArrayList<Cards> greenDeck = new ArrayList<>();

    Cards[][] cardsOnTable = new Cards[3][3];
    ArrayList<Noble> tiles;

    ArrayList<Tokens> noTokens = new ArrayList<>();
    ArrayList<Cards> noCards = new ArrayList<>();
    ArrayList<Noble> noNobles = new ArrayList<>();
    ArrayList<Cards> noReserves = new ArrayList<>();

    ArrayList<Player> players = new ArrayList<>();

    @BeforeEach
    public void setUpTable() {
        onyxToken = new Tokens("Onyx");
        emeraldToken = new Tokens("Emerald");
        sapphireToken = new Tokens("Sapphire");
        rubyToken = new Tokens("Rubby");
        diamondToken = new Tokens("Diamond");
        goldToken = new Tokens("Gold");

        allTokens = new ArrayList<>();
        for(int i = 0; i < 7; i++){
            allTokens.add(onyxToken);
            allTokens.add(emeraldToken);
            allTokens.add(sapphireToken);
            allTokens.add(rubyToken);
            allTokens.add(diamondToken);
            allTokens.add(goldToken);
        }

        Cards diamondCard = new Cards("Diamond");
        Cards rubyCard = new Cards("rubby");
        Cards onyxCard = new Cards("onyx");

        greenDeck.add(diamondCard);
        yellowDeck.add(diamondCard);
        blueDeck.add(diamondCard);

        greenDeck.add(rubyCard);
        yellowDeck.add(rubyCard);
        blueDeck.add(rubyCard);

        greenDeck.add(onyxCard);
        yellowDeck.add(onyxCard);
        blueDeck.add(onyxCard);

        for(int i = 0; i < 3; i ++){
            cardsOnTable[i][0] = diamondCard;
            cardsOnTable[i][1] = rubyCard;
            cardsOnTable[i][2] = onyxCard;
        }

        ArrayList<Tokens> cost1 = new ArrayList<>();
        cost1.add(diamondToken);
        cost1.add(diamondToken);
        Noble noble1 = new Noble("noble1", cost1);

        ArrayList<Tokens> cost2 = new ArrayList<>();
        cost2.add(rubyToken);
        cost2.add(rubyToken);
        Noble noble2 = new Noble("noble2", cost2);

        ArrayList<Tokens> cost3 = new ArrayList<>();
        cost3.add(sapphireToken);
        cost3.add(sapphireToken);
        Noble noble3 = new Noble("noble3", cost3);

        tiles = new ArrayList<>();
        tiles.add(noble1);
        tiles.add(noble2);
        tiles.add(noble3);

        Player player1 = new Player(0, noTokens, noCards, noNobles, noReserves, "player1");
        Player player2 = new Player(0, noTokens, noCards, noNobles, noReserves, "player2");
        Player player3 = new Player(0, noTokens, noCards, noNobles, noReserves, "player3");
        Player player4 = new Player(0, noTokens, noCards, noNobles, noReserves, "player4");
        players.add(player1);
        players.add(player2);
        players.add(player3);
        players.add(player4);
    }

    @Test
    public void testGameConstructorNoArguments() {
        Game startGame = new Game();
    }

    @Test
    public void testGameConstructorStartingArguments() {
        Game startGame = new Game(players, blueDeck, yellowDeck, greenDeck, cardsOnTable, tiles, allTokens);
    }

    @Test
    public void testGameConstructorStartingPlayers() {
        Game startGame = new Game(players, 1, 1);
    }

    @Test
    public void testGameGetStartingPlayerValid(){
        Game startGame = new Game(players, blueDeck, yellowDeck, greenDeck, cardsOnTable, tiles, allTokens);
        assertTrue(startGame.getStartingPlayer() < players.size());
    }

    @Test
    public void testGameGetStartingPlayerIsSetFromConstructor(){
        Game startGame = new Game(players, 1, 1);
        assertEquals(1, startGame.getStartingPlayer());
    }

    @Test
    public void testGameSetStartingPlayer(){
        Game startGame = new Game(players, blueDeck, yellowDeck, greenDeck, cardsOnTable, tiles, allTokens);
        startGame.setStartingPlayer(1);
        assertEquals(1, startGame.getStartingPlayer());

        startGame.setStartingPlayer(2);
        assertEquals(2, startGame.getStartingPlayer());
    }

    @Test
    public void testGameGetPreviousPlayer(){
        Game startGame = new Game(players, 2, 1);
        assertEquals(1, startGame.getPreviousPlayer());
    }

    @Test
    public void testGameGetCurrentPlayerSetFromConstructor(){
        Game startGame = new Game(players, 2, 1);
        assertEquals(2, startGame.getCurrentPlayer());
    }

    @Test
    public void testGameGetCurrentPlayerNotSetFromConstructor(){
        Game startGame = new Game(players, blueDeck, yellowDeck, greenDeck, cardsOnTable, tiles, allTokens);
        assertEquals(startGame.getStartingPlayer(), startGame.getCurrentPlayer());
    }

    @Test
    public void testGameSetCurrentPlayer(){
        Game startGame = new Game(players, 2, 1);
        startGame.setCurrentPlayer(1);
        assertEquals(1, startGame.getCurrentPlayer());
    }

    @Test
    public void testGameGetWinner(){
        Game startGame = new Game(players, 2, 1);
        assertEquals(players, startGame.getWinner());
    }

    @Test
    public void testGameSetWinner(){
        ArrayList<Player> noPlayer = new ArrayList<>();
        Game startGame = new Game(noPlayer, 2, 1);
        startGame.setWinner(players);
        assertEquals(players, startGame.getWinner());
    }

    @Test
    public void testGameGetPlayers(){
        Game startGame = new Game(players, blueDeck, yellowDeck, greenDeck, cardsOnTable, tiles, allTokens);
        assertEquals(players, startGame.getPlayers());
    }

    @Test
    public void testGameSetPlayers(){
        ArrayList<Player> noPlayer = new ArrayList<>();
        Game startGame = new Game(noPlayer, blueDeck, yellowDeck, greenDeck, cardsOnTable, tiles, allTokens);
        startGame.setPlayers(players);
        assertEquals(players, startGame.getPlayers());
    }

    @Test
    public void testGameGetBlueDeck(){
        Game startGame = new Game(players, blueDeck, yellowDeck, greenDeck, cardsOnTable, tiles, allTokens);
        assertEquals(blueDeck, startGame.getBlueDeck());
    }

    @Test
    public void testGameSetBlueDeck(){
        ArrayList<Cards>rubyblueDeck = new ArrayList<>();
        Cards rubyCard = new Cards("rubby");
        rubyblueDeck.add(rubyCard);

        Game startGame = new Game(players, rubyblueDeck, yellowDeck, greenDeck, cardsOnTable, tiles, allTokens);
        startGame.setBlueDeck(blueDeck);
        assertEquals(blueDeck, startGame.getBlueDeck());
    }

    @Test
    public void testGameGetYellowDeck(){
        Game startGame = new Game(players, blueDeck, yellowDeck, greenDeck, cardsOnTable, tiles, allTokens);
        assertEquals(yellowDeck, startGame.getYellowDeck());
    }

    @Test
    public void testGameSetYellowDeck(){
        ArrayList<Cards>rubyYellowDeck = new ArrayList<>();
        Cards rubyCard = new Cards("rubby");
        rubyYellowDeck.add(rubyCard);

        Game startGame = new Game(players, blueDeck, rubyYellowDeck, greenDeck, cardsOnTable, tiles, allTokens);
        startGame.setYellowDeck(yellowDeck);
        assertEquals(yellowDeck, startGame.getYellowDeck());
    }

    @Test
    public void testGameGetGreenDeck(){
        Game startGame = new Game(players, blueDeck, yellowDeck, greenDeck, cardsOnTable, tiles, allTokens);
        assertEquals(greenDeck, startGame.getGreenDeck());
    }

    @Test
    public void testGameSetGreenDeck(){
        ArrayList<Cards>rubygreenDeck = new ArrayList<>();
        Cards rubyCard = new Cards("rubby");
        rubygreenDeck.add(rubyCard);

        Game startGame = new Game(players, rubygreenDeck, yellowDeck, greenDeck, cardsOnTable, tiles, allTokens);
        startGame.setGreenDeck(greenDeck);
        assertEquals(greenDeck, startGame.getGreenDeck());
    }

    @Test
    public void testGameGetCardsOnTable(){
        Game startGame = new Game(players, blueDeck, yellowDeck, greenDeck, cardsOnTable, tiles, allTokens);
        assertEquals(cardsOnTable, startGame.getCardsOnTable());
    }

    @Test
    public void testGameSetCardsOnTable(){
        Cards diamondCard = new Cards("Diamond");
        Cards rubyCard = new Cards("rubby");
        Cards onyxCard = new Cards("onyx");

        Cards[][] oldCardsOnTable = new Cards[2][2];
        for(int i = 0; i < 2; i ++){
            oldCardsOnTable[i][0] = diamondCard;
            oldCardsOnTable[i][1] = rubyCard;
        }

        Game startGame = new Game(players, blueDeck, yellowDeck, greenDeck, oldCardsOnTable, tiles, allTokens);
        startGame.setCardsOnTable(cardsOnTable);
        assertEquals(cardsOnTable, startGame.getCardsOnTable());
    }

    @Test
    public void testGameGetTiles(){
        Game startGame = new Game(players, blueDeck, yellowDeck, greenDeck, cardsOnTable, tiles, allTokens);
        assertEquals(tiles, startGame.getTiles());
    }

    @Test
    public void testGameSetTiles(){
        ArrayList<Tokens> cost1 = new ArrayList<>();
        cost1.add(diamondToken);
        cost1.add(diamondToken);
        Noble noble1 = new Noble("noble1", cost1);

        ArrayList<Noble> oldTiles = new ArrayList<>();
        oldTiles.add(noble1);

        Game startGame = new Game(players, blueDeck, yellowDeck, greenDeck, cardsOnTable, oldTiles, allTokens);
        startGame.setTiles(tiles);
        assertEquals(tiles, startGame.getTiles());
    }

    @Test
    public void testGameGetTokens(){
        Game startGame = new Game(players, blueDeck, yellowDeck, greenDeck, cardsOnTable, tiles, allTokens);
        assertEquals(allTokens, startGame.getTokens());
    }

    @Test
    public void testGameSetTokens(){
        ArrayList<Tokens> oldTokens = new ArrayList<>();
        oldTokens.add(onyxToken);
        Game startGame = new Game(players, blueDeck, yellowDeck, greenDeck, cardsOnTable, tiles, oldTokens);
        startGame.setTokens(allTokens);
        assertEquals(allTokens, startGame.getTokens());
    }

    @Test
    public void testGameGetDeckBlue(){
        Game startGame = new Game(players, blueDeck, yellowDeck, greenDeck, cardsOnTable, tiles, allTokens);
        assertEquals(blueDeck, startGame.getDeck("blue"));
    }

    @Test
    public void testGameGetDeckBlueCapitalized(){
        Game startGame = new Game(players, blueDeck, yellowDeck, greenDeck, cardsOnTable, tiles, allTokens);
        assertEquals(blueDeck, startGame.getDeck("Blue"));
    }

    @Test
    public void testGameGetDeckGreen(){
        Game startGame = new Game(players, blueDeck, yellowDeck, greenDeck, cardsOnTable, tiles, allTokens);
        assertEquals(greenDeck, startGame.getDeck("green"));
    }

    @Test
    public void testGameGetDeckYellow(){
        Game startGame = new Game(players, blueDeck, yellowDeck, greenDeck, cardsOnTable, tiles, allTokens);
        assertEquals(yellowDeck, startGame.getDeck("yellow"));
    }

    //Failed Test: does not check for validity of arguments
//    @Test
//    public void testGameGetDeckInvalid(){
//        Game startGame = new Game(players, blueDeck, yellowDeck, greenDeck, cardsOnTable, tiles, allTokens);
//
//        assertThrows(IllegalArgumentException.class, ()->{
//            startGame.getDeck("purple");
//        });
//    }

    @Test
    public void testGameWhiteTokens(){
        Game startGame = new Game(players, blueDeck, yellowDeck, greenDeck, cardsOnTable, tiles, allTokens);
        assertEquals(7, startGame.whiteTokens());
    }

    @Test
    public void testGameWhiteTokensNone(){
        ArrayList<Tokens> oldTokens = new ArrayList<>();
        oldTokens.add(onyxToken);
        Game startGame = new Game(players, blueDeck, yellowDeck, greenDeck, cardsOnTable, tiles, oldTokens);
        assertEquals(0, startGame.whiteTokens());
    }

    @Test
    public void testGameGreenTokens(){
        Game startGame = new Game(players, blueDeck, yellowDeck, greenDeck, cardsOnTable, tiles, allTokens);
        assertEquals(7, startGame.greenTokens());
    }

    @Test
    public void testGameGreenTokensNone(){
        ArrayList<Tokens> oldTokens = new ArrayList<>();
        oldTokens.add(onyxToken);
        Game startGame = new Game(players, blueDeck, yellowDeck, greenDeck, cardsOnTable, tiles, oldTokens);
        assertEquals(0, startGame.greenTokens());
    }

    @Test
    public void testGameBlueTokens(){
        Game startGame = new Game(players, blueDeck, yellowDeck, greenDeck, cardsOnTable, tiles, allTokens);
        assertEquals(7, startGame.blueTokens());
    }

    @Test
    public void testGameBlueTokensNone(){
        ArrayList<Tokens> oldTokens = new ArrayList<>();
        oldTokens.add(onyxToken);
        Game startGame = new Game(players, blueDeck, yellowDeck, greenDeck, cardsOnTable, tiles, oldTokens);
        assertEquals(0, startGame.blueTokens());
    }

    @Test
    public void testGameBlackTokens(){
        Game startGame = new Game(players, blueDeck, yellowDeck, greenDeck, cardsOnTable, tiles, allTokens);
        assertEquals(7, startGame.blackTokens());
    }

    @Test
    public void testGameBlackTokensNone(){
        ArrayList<Tokens> oldTokens = new ArrayList<>();
        oldTokens.add(diamondToken);
        Game startGame = new Game(players, blueDeck, yellowDeck, greenDeck, cardsOnTable, tiles, oldTokens);
        assertEquals(0, startGame.blackTokens());
    }

    @Test
    public void testGameRedTokens(){
        Game startGame = new Game(players, blueDeck, yellowDeck, greenDeck, cardsOnTable, tiles, allTokens);
        assertEquals(7, startGame.redTokens());
    }

    @Test
    public void testGameRedTokensNone(){
        ArrayList<Tokens> oldTokens = new ArrayList<>();
        oldTokens.add(onyxToken);
        Game startGame = new Game(players, blueDeck, yellowDeck, greenDeck, cardsOnTable, tiles, oldTokens);
        assertEquals(0, startGame.redTokens());
    }

    @Test
    public void testGameYellowTokens(){
        Game startGame = new Game(players, blueDeck, yellowDeck, greenDeck, cardsOnTable, tiles, allTokens);
        assertEquals(7, startGame.yellowTokens());
    }

    @Test
    public void testGameYellowTokensNone(){
        ArrayList<Tokens> oldTokens = new ArrayList<>();
        oldTokens.add(onyxToken);
        Game startGame = new Game(players, blueDeck, yellowDeck, greenDeck, cardsOnTable, tiles, oldTokens);
        assertEquals(0, startGame.yellowTokens());
    }

    @Test
    public void testGameGetRandomBlue(){
        Cards goldCard = new Cards("gold joker");
        ArrayList<Cards> testDeck = new ArrayList<>();
        testDeck.add(goldCard);
        Game startGame = new Game(players, testDeck, yellowDeck, greenDeck, cardsOnTable, tiles, allTokens);
        assertEquals(goldCard, startGame.getRandom("blue"));
    }

    @Test
    public void testGameGetRandomGreen(){
        Cards goldCard = new Cards("gold joker");
        ArrayList<Cards> testDeck = new ArrayList<>();
        testDeck.add(goldCard);
        Game startGame = new Game(players, blueDeck, yellowDeck, testDeck, cardsOnTable, tiles, allTokens);
        assertEquals(goldCard, startGame.getRandom("green"));
    }

    @Test
    public void testGameGetRandomYellow(){
        Cards goldCard = new Cards("gold joker");
        ArrayList<Cards> testDeck = new ArrayList<>();
        testDeck.add(goldCard);
        Game startGame = new Game(players, blueDeck, testDeck, greenDeck, cardsOnTable, tiles, allTokens);
        assertEquals(goldCard, startGame.getRandom("yellow"));
    }

    @Test
    public void testGameGetRandomBlueCaptalized(){
        Cards goldCard = new Cards("gold joker");
        ArrayList<Cards> testDeck = new ArrayList<>();
        testDeck.add(goldCard);
        Game startGame = new Game(players, testDeck, yellowDeck, greenDeck, cardsOnTable, tiles, allTokens);
        assertEquals(goldCard, startGame.getRandom("Blue"));
    }

    // Failed Test: Does not check for validity of argument
//    @Test
//    public void testGameGetRandomInvalidDeck(){
//        Cards goldCard = new Cards("gold joker");
//        ArrayList<Cards> testDeck = new ArrayList<>();
//        testDeck.add(goldCard);
//        Game startGame = new Game(players, blueDeck, yellowDeck, greenDeck, cardsOnTable, tiles, allTokens);
//        assertThrows(IllegalArgumentException.class, ()->{
//            startGame.getDeck("purple");
//        });
//    }

    @Test
    public void testGameUpdatePlayers(){
        Game startGame = new Game(players, blueDeck, yellowDeck, greenDeck, cardsOnTable, tiles, allTokens);
        onyxToken = new Tokens("Onyx");
        ArrayList<Tokens> token1 = new ArrayList<>();
        token1.add(onyxToken);
        Player player1 = new Player(0, token1, noCards, noNobles, noReserves, "player1");
        startGame.updatePlayers(player1);
        assertTrue(startGame.getPlayers().contains(player1));
    }

    // Failed Test: does not check if the player being updated exists
//    @Test
//    public void testGameUpdatePlayersNewPlayer(){
//        Game startGame = new Game(players, blueDeck, yellowDeck, greenDeck, cardsOnTable, tiles, allTokens);
//        onyxToken = new Tokens("Onyx");
//        ArrayList<Tokens> token1 = new ArrayList<>();
//        token1.add(onyxToken);
//        Player player10 = new Player(0, token1, noCards, noNobles, noReserves, "player10");
//        assertThrows(IllegalArgumentException.class, ()->{
//            startGame.updatePlayers(player10);
//        });
//    }

    @Test
    public void testGameDifferentColorsFalse(){
        Game startGame = new Game(players, blueDeck, yellowDeck, greenDeck, cardsOnTable, tiles, allTokens);
        ArrayList<Tokens> sameToken = new ArrayList<>();
        sameToken.add(onyxToken);
        sameToken.add(onyxToken);
        assertFalse(startGame.differentColors(sameToken));
    }

    @Test
    public void testGameDifferentColorsTrue(){
        Game startGame = new Game(players, blueDeck, yellowDeck, greenDeck, cardsOnTable, tiles, allTokens);
        ArrayList<Tokens> sameToken = new ArrayList<>();
        sameToken.add(onyxToken);
        sameToken.add(diamondToken);
        assertTrue(startGame.differentColors(sameToken));
    }

    @Test
    public void testGameDifferentColorsOnlyOne(){
        Game startGame = new Game(players, blueDeck, yellowDeck, greenDeck, cardsOnTable, tiles, allTokens);
        ArrayList<Tokens> sameToken = new ArrayList<>();
        sameToken.add(onyxToken);
        assertTrue(startGame.differentColors(sameToken));
    }

    // Test Failed: returns false when true
//    @Test
//    public void testGameDifferentColorsMoreThanTwo(){
//        Game startGame = new Game(players, blueDeck, yellowDeck, greenDeck, cardsOnTable, tiles, allTokens);
//        ArrayList<Tokens> sameToken = new ArrayList<>();
//        sameToken.add(diamondToken);
//        sameToken.add(diamondToken);
//        sameToken.add(onyxToken);
//        assertTrue(startGame.differentColors(sameToken));
//    }

    @Test
    public void testGameContainNobleNoNoble(){
        Game startGame = new Game(players, blueDeck, yellowDeck, greenDeck, cardsOnTable, tiles, allTokens);
        assertEquals(0, startGame.containNoble().size());
    }

    @Test
    public void testGameContainNoble(){
        ArrayList<Tokens> cost1 = new ArrayList<>();
        cost1.add(diamondToken);
        cost1.add(diamondToken);
        Noble noble1 = new Noble("noble1", cost1);

        ArrayList<Noble> have1Noble = new ArrayList<>();
        have1Noble.add(noble1);

        Player player5 = new Player(0, noTokens, noCards, have1Noble, noReserves, "player1");
        players.add(player5);

        Game startGame = new Game(players, blueDeck, yellowDeck, greenDeck, cardsOnTable, tiles, allTokens);
        assertEquals(have1Noble, startGame.containNoble());
    }

    @Test
    public void testGameContainNobleMoreThanOne(){
        ArrayList<Tokens> cost1 = new ArrayList<>();
        cost1.add(diamondToken);
        cost1.add(diamondToken);
        Noble noble1 = new Noble("noble1", cost1);
        Noble noble2 = new Noble("noble2", cost1);
        Noble noble3 = new Noble("noble3", cost1);

        ArrayList<Noble> have3Noble = new ArrayList<>();
        have3Noble.add(noble1);
        have3Noble.add(noble2);
        have3Noble.add(noble3);

        Player player5 = new Player(0, noTokens, noCards, have3Noble, noReserves, "player1");
        players.add(player5);

        Game startGame = new Game(players, blueDeck, yellowDeck, greenDeck, cardsOnTable, tiles, allTokens);
        assertEquals(have3Noble, startGame.containNoble());
    }

    @Test
    public void testGameNumOfToken(){
        Game startGame = new Game(players, blueDeck, yellowDeck, greenDeck, cardsOnTable, tiles, allTokens);
        assertEquals(7, startGame.numOf(onyxToken));
        assertEquals(7, startGame.numOf(diamondToken));
        assertEquals(7, startGame.numOf(emeraldToken));
        assertEquals(7, startGame.numOf(sapphireToken));
        assertEquals(7, startGame.numOf(rubyToken));
        assertEquals(7, startGame.numOf(goldToken));
    }

    @Test
    public void testGameNumOfNoToken(){
        ArrayList<Tokens> noTokens = new ArrayList<>();
        Game startGame = new Game(players, blueDeck, yellowDeck, greenDeck, cardsOnTable, tiles, noTokens);
        assertEquals(0, startGame.numOf(onyxToken));
        assertEquals(0, startGame.numOf(diamondToken));
        assertEquals(0, startGame.numOf(emeraldToken));
        assertEquals(0, startGame.numOf(sapphireToken));
        assertEquals(0, startGame.numOf(rubyToken));
        assertEquals(0, startGame.numOf(goldToken));
    }

    @Test
    public void testGameWinTrue(){
        Game startGame = new Game(players, blueDeck, yellowDeck, greenDeck, cardsOnTable, tiles, allTokens);

        Player player1 = new Player(15, noTokens, noCards, noNobles, noReserves, "player1");
        startGame.updatePlayers(player1);
        assertTrue(startGame.win());
    }

    // Test Failed: always return true
//    @Test
//    public void testGameWinFalse(){
//        Game startGame = new Game(players, blueDeck, yellowDeck, greenDeck, cardsOnTable, tiles, allTokens);
//        assertFalse(startGame.win());
//    }

    @Test
    public void testGameCheckDiscardTrue() throws InvalidTokensSelection {
        ArrayList<Tokens> haveDiamondToken = new ArrayList<>();
        haveDiamondToken.add(diamondToken);

        Game startGame = new Game(players, blueDeck, yellowDeck, greenDeck, cardsOnTable, tiles, allTokens);

        Player player1 = new Player(1, haveDiamondToken, noCards, noNobles, noReserves, "player1");
        startGame.updatePlayers(player1);
        assertTrue(startGame.checkDiscard(player1, diamondToken));
    }

    @Test
    public void testGameCheckDiscardException() throws InvalidTokensSelection {
        Game startGame = new Game(players, blueDeck, yellowDeck, greenDeck, cardsOnTable, tiles, allTokens);

        Player player1 = new Player(1, noTokens, noCards, noNobles, noReserves, "player1");
        startGame.updatePlayers(player1);
        assertThrows(InvalidTokensSelection.class, ()->{
            startGame.checkDiscard(player1, diamondToken);
        });
    }

    @Test
    public void testGameCheckActionOneException1Card() {
        ArrayList<Tokens> haveDiamondToken = new ArrayList<>();
        haveDiamondToken.add(diamondToken);

        Game startGame = new Game(players, blueDeck, yellowDeck, greenDeck, cardsOnTable, tiles, haveDiamondToken);

        Player player1 = new Player(1, noTokens, noCards, noNobles, noReserves, "player1");
        startGame.updatePlayers(player1);
        assertThrows(NotEnoughTokensOnTable.class, ()->{
            startGame.checkActionOne(player1, diamondToken);
        });
    }

    @Test
    public void testGameCheckActionOneException2Card() {
        ArrayList<Tokens> haveDiamondToken = new ArrayList<>();
        haveDiamondToken.add(diamondToken);
        haveDiamondToken.add(diamondToken);

        Game startGame = new Game(players, blueDeck, yellowDeck, greenDeck, cardsOnTable, tiles, haveDiamondToken);

        Player player1 = new Player(1, noTokens, noCards, noNobles, noReserves, "player1");
        startGame.updatePlayers(player1);
        assertThrows(NotEnoughTokensOnTable.class, ()->{
            startGame.checkActionOne(player1, diamondToken);
        });
    }

    @Test
    public void testGameCheckActionOneException3Card() {
        ArrayList<Tokens> haveDiamondToken = new ArrayList<>();
        haveDiamondToken.add(diamondToken);
        haveDiamondToken.add(diamondToken);
        haveDiamondToken.add(diamondToken);

        Game startGame = new Game(players, blueDeck, yellowDeck, greenDeck, cardsOnTable, tiles, haveDiamondToken);

        Player player1 = new Player(1, noTokens, noCards, noNobles, noReserves, "player1");
        startGame.updatePlayers(player1);
        assertThrows(NotEnoughTokensOnTable.class, ()->{
            startGame.checkActionOne(player1, diamondToken);
        });
    }

    @Test
    public void testGameCheckActionOneTrue4Card() throws InvalidTokensSelection, NotEnoughTokensOnTable {
        ArrayList<Tokens> haveDiamondToken = new ArrayList<>();
        haveDiamondToken.add(diamondToken);
        haveDiamondToken.add(diamondToken);
        haveDiamondToken.add(diamondToken);
        haveDiamondToken.add(diamondToken);

        Game startGame = new Game(players, blueDeck, yellowDeck, greenDeck, cardsOnTable, tiles, haveDiamondToken);

        Player player1 = new Player(0, noTokens, noCards, noNobles, noReserves, "player1");
        assertTrue(startGame.checkActionOne(player1, diamondToken));
    }

    @Test
    public void testGameCheckActionOneTrue5Card() throws InvalidTokensSelection, NotEnoughTokensOnTable {
        ArrayList<Tokens> haveDiamondToken = new ArrayList<>();
        haveDiamondToken.add(diamondToken);
        haveDiamondToken.add(diamondToken);
        haveDiamondToken.add(diamondToken);
        haveDiamondToken.add(diamondToken);
        haveDiamondToken.add(diamondToken);

        Game startGame = new Game(players, blueDeck, yellowDeck, greenDeck, cardsOnTable, tiles, haveDiamondToken);

        Player player1 = new Player(0, noTokens, noCards, noNobles, noReserves, "player1");
        assertTrue(startGame.checkActionOne(player1, diamondToken));
    }

    @Test
    public void testGameCheckActionTwoTrue() throws NotEnoughTokensOnTable {
        Game startGame = new Game(players, blueDeck, yellowDeck, greenDeck, cardsOnTable, tiles, allTokens);

        Player player1 = new Player(0, noTokens, noCards, noNobles, noReserves, "player1");
        assertTrue(startGame.checkActionTwo(player1, diamondToken, onyxToken, goldToken));
    }

    // Test failed: method always returns true
//    @Test
//    public void testGameCheckActionTwoNotEnoughCardException() throws NotEnoughTokensOnTable {
//        Game noTokensGame = new Game(players, blueDeck, yellowDeck, greenDeck, cardsOnTable, tiles, noTokens);
//
//        Player player1 = new Player(0, noTokens, noCards, noNobles, noReserves, "player1");
//        assertThrows(NotEnoughTokensOnTable.class, ()->{
//            noTokensGame.checkActionTwo(player1, diamondToken, onyxToken, goldToken);
//        });
//    }
//

    // Test failed: method always returns true and does not check for same colors
//    @Test
//    public void testGameCheckActionTwoInvalidArgumentException() throws NotEnoughTokensOnTable {
//        Game noTokensGame = new Game(players, blueDeck, yellowDeck, greenDeck, cardsOnTable, tiles, noTokens);
//
//        Player player1 = new Player(0, noTokens, noCards, noNobles, noReserves, "player1");
//        assertThrows(IllegalArgumentException.class, ()->{
//            noTokensGame.checkActionTwo(player1, diamondToken, onyxToken, onyxToken);
//        });
//    }

    // Test failed: method always returns true and does not check for player trying to take gold token
//    @Test
//    public void testGameCheckActionTwoInvalidArgumentException() throws NotEnoughTokensOnTable {
//        Game noTokensGame = new Game(players, blueDeck, yellowDeck, greenDeck, cardsOnTable, tiles, noTokens);
//
//        Player player1 = new Player(0, noTokens, noCards, noNobles, noReserves, "player1");
//        assertThrows(IllegalArgumentException.class, ()->{
//            noTokensGame.checkActionTwo(player1, diamondToken, onyxToken, goldToken);
//        });
//    }

    @Test
    public void testGameCheckActionThreeTrue() throws PlayerAlreadyHoldsThreeReserveCards, InvalidCardsSelectionOfCardsOnTable {
        Game startGame = new Game(players, blueDeck, yellowDeck, greenDeck, cardsOnTable, tiles, allTokens);

        Player player1 = new Player(0, noTokens, noCards, noNobles, noReserves, "player1");
        assertTrue(startGame.checkActionThree(player1, 1, 1));
    }

    // Test Failed: card on table only have 3 row
//    @Test
//    public void testGameCheckActionThreeInvalidRowSelection() throws PlayerAlreadyHoldsThreeReserveCards, InvalidCardsSelectionOfCardsOnTable {
//        Game startGame = new Game(players, blueDeck, yellowDeck, greenDeck, cardsOnTable, tiles, allTokens);
//
//        Player player1 = new Player(0, noTokens, noCards, noNobles, noReserves, "player1");
//        assertThrows(InvalidCardsSelectionOfCardsOnTable.class, ()->{
//            startGame.checkActionThree(player1, 4, 1);
//        });
//    }

    @Test
    public void testGameCheckActionThreeInvalidColSelection() throws PlayerAlreadyHoldsThreeReserveCards, InvalidCardsSelectionOfCardsOnTable {
        Game startGame = new Game(players, blueDeck, yellowDeck, greenDeck, cardsOnTable, tiles, allTokens);

        Player player1 = new Player(0, noTokens, noCards, noNobles, noReserves, "player1");
        assertThrows(InvalidCardsSelectionOfCardsOnTable.class, ()->{
            startGame.checkActionThree(player1, 1, 5);
        });
    }

    @Test
    public void testGameCheckActionThreePlayerAlreadyHoldThreeReserveCards() throws PlayerAlreadyHoldsThreeReserveCards, InvalidCardsSelectionOfCardsOnTable {
        Game startGame = new Game(players, blueDeck, yellowDeck, greenDeck, cardsOnTable, tiles, allTokens);

        ArrayList<Cards> threeReserves = new ArrayList<>();
        Cards diamondCard = new Cards("Diamond");
        threeReserves.add(diamondCard);
        threeReserves.add(diamondCard);
        threeReserves.add(diamondCard);

        Player player1 = new Player(0, noTokens, noCards, noNobles, threeReserves, "player1");
        startGame.updatePlayers(player1);
        assertThrows(PlayerAlreadyHoldsThreeReserveCards.class, ()->{
            startGame.checkActionThree(player1, 1, 1);
        });
    }

    // Test Failed: does not throw Player Already Hold sThree Reserve Cards exception
//    @Test
//    public void testGameCheckActionThreeStringPlayerAlreadyHoldThreeReserveCards() {
//        Game startGame = new Game(players, blueDeck, yellowDeck, greenDeck, cardsOnTable, tiles, allTokens);
//
//        ArrayList<Cards> threeReserves = new ArrayList<>();
//        Cards diamondCard = new Cards("Diamond");
//        threeReserves.add(diamondCard);
//        threeReserves.add(diamondCard);
//        threeReserves.add(diamondCard);
//
//        Player player1 = new Player(0, noTokens, noCards, noNobles, threeReserves, "player1");
//        startGame.updatePlayers(player1);
//        assertThrows(PlayerAlreadyHoldsThreeReserveCards.class, ()->{
//            startGame.checkActionThree(player1, "green");
//        });
//    }
//

    @Test
    public void testGameCheckActionThreeStringEmptyBlueDeckException() throws SelectedDeckRanOutOfCards {
        ArrayList<Cards> emptyDeck = new ArrayList<>();
        Game startGame = new Game(players, emptyDeck, yellowDeck, greenDeck, cardsOnTable, tiles, allTokens);

        Player player1 = new Player(0, noTokens, noCards, noNobles, noReserves, "player1");
        startGame.updatePlayers(player1);
        assertThrows(SelectedDeckRanOutOfCards.class, ()->{
            startGame.checkActionThree(player1, "blue");
        });
    }

    @Test
    public void testGameCheckActionThreeStringEmptyGreenDeckException() throws SelectedDeckRanOutOfCards {
        ArrayList<Cards> emptyDeck = new ArrayList<>();
        Game startGame = new Game(players, blueDeck, yellowDeck, emptyDeck, cardsOnTable, tiles, allTokens);

        Player player1 = new Player(0, noTokens, noCards, noNobles, noReserves, "player1");
        startGame.updatePlayers(player1);
        assertThrows(SelectedDeckRanOutOfCards.class, ()->{
            startGame.checkActionThree(player1, "green");
        });
    }

    @Test
    public void testGameCheckActionThreeStringEmptyYellowDeckException() throws SelectedDeckRanOutOfCards {
        ArrayList<Cards> emptyDeck = new ArrayList<>();
        Game startGame = new Game(players, blueDeck, emptyDeck, greenDeck, cardsOnTable, tiles, allTokens);

        Player player1 = new Player(0, noTokens, noCards, noNobles, noReserves, "player1");
        startGame.updatePlayers(player1);
        assertThrows(SelectedDeckRanOutOfCards.class, ()->{
            startGame.checkActionThree(player1, "yellow");
        });
    }

    // Failed Test: does not check for validity of string argument
//    @Test
//    public void testGameCheckActionThreeStringIllegalArgumentException() throws SelectedDeckRanOutOfCards {
//        ArrayList<Cards> emptyDeck = new ArrayList<>();
//        Game startGame = new Game(players, blueDeck, emptyDeck, greenDeck, cardsOnTable, tiles, allTokens);
//
//        Player player1 = new Player(0, noTokens, noCards, noNobles, noReserves, "player1");
//        startGame.updatePlayers(player1);
//        assertThrows(IllegalArgumentException.class, ()->{
//            startGame.checkActionThree(player1, "purple");
//        });
//    }

    @Test
    public void testGameCheckActionThreeStringYellowDeck() throws SelectedDeckRanOutOfCards {
        ArrayList<Cards> emptyDeck = new ArrayList<>();
        Game startGame = new Game(players, blueDeck, yellowDeck, greenDeck, cardsOnTable, tiles, allTokens);

        Player player1 = new Player(0, noTokens, noCards, noNobles, noReserves, "player1");
        assertTrue(startGame.checkActionThree(player1, "yellow"));
    }

    @Test
    public void testGameCheckActionThreeStringBlueDeck() throws SelectedDeckRanOutOfCards {
        ArrayList<Cards> emptyDeck = new ArrayList<>();
        Game startGame = new Game(players, blueDeck, yellowDeck, greenDeck, cardsOnTable, tiles, allTokens);

        Player player1 = new Player(0, noTokens, noCards, noNobles, noReserves, "player1");
        assertTrue(startGame.checkActionThree(player1, "blue"));
    }

    @Test
    public void testGameCheckActionThreeStringGreenDeck() throws SelectedDeckRanOutOfCards {
        Game startGame = new Game(players, blueDeck, yellowDeck, greenDeck, cardsOnTable, tiles, allTokens);

        Player player1 = new Player(0, noTokens, noCards, noNobles, noReserves, "player1");
        assertTrue(startGame.checkActionThree(player1, "green"));
    }

    // Test failed: does not handle capitalized string
//    @Test
//    public void testGameCheckActionThreeStringGreenDeckCapitalized() throws SelectedDeckRanOutOfCards {
//        ArrayList<Cards> emptyDeck = new ArrayList<>();
//        Game startGame = new Game(players, blueDeck, yellowDeck, greenDeck, cardsOnTable, tiles, allTokens);
//
//        Player player1 = new Player(0, noTokens, noCards, noNobles, noReserves, "player1");
//        startGame.checkActionThree(player1, "Green");
//    }

    @Test
    public void testGameCheckActionFourCanBuy() throws SelectedDeckRanOutOfCards, PlayerDoesNotHaveEnoughResourcesToBuySelectedCard, PlayerDoesNotHaveSelectedCardInReserve {
        Game startGame = new Game(players, blueDeck, yellowDeck, greenDeck, cardsOnTable, tiles, allTokens);

        ArrayList<Cards> reserved = new ArrayList<>();

        ArrayList<Tokens> cost = new ArrayList<>();
        cost.add(diamondToken);
        cost.add(diamondToken);

        String  name = "mine";

        Cards diamondCard = new Cards(1, cost, name, diamondToken);
        reserved.add(diamondCard);

        Player player1 = new Player(0, cost, noCards, noNobles, reserved, "player1");
        startGame.updatePlayers(player1);
        assertTrue(startGame.checkActionFour(player1, diamondCard));
    }

    @Test
    public void testGameCheckActionFourDoesNotHaveEnoughTokens() throws SelectedDeckRanOutOfCards, PlayerDoesNotHaveEnoughResourcesToBuySelectedCard, PlayerDoesNotHaveSelectedCardInReserve {
        Game startGame = new Game(players, blueDeck, yellowDeck, greenDeck, cardsOnTable, tiles, allTokens);

        ArrayList<Cards> reserved = new ArrayList<>();

        ArrayList<Tokens> cost = new ArrayList<>();
        cost.add(diamondToken);
        cost.add(onyxToken);

        String  name = "mine";

        Cards diamondCard = new Cards(1, cost, name, diamondToken);
        reserved.add(diamondCard);

        ArrayList<Tokens> playerToken = new ArrayList<>();
        playerToken.add(diamondToken);

        Player player1 = new Player(1, playerToken, noCards, noNobles, reserved, "player1");
        startGame.updatePlayers(player1);
        assertThrows(PlayerDoesNotHaveEnoughResourcesToBuySelectedCard.class, ()->{
            startGame.checkActionFour(player1, diamondCard);
        });
    }

    @Test
    public void testGameCheckActionFourCanBuyWithYellow() throws SelectedDeckRanOutOfCards, PlayerDoesNotHaveEnoughResourcesToBuySelectedCard, PlayerDoesNotHaveSelectedCardInReserve {
        Game startGame = new Game(players, blueDeck, yellowDeck, greenDeck, cardsOnTable, tiles, allTokens);

        ArrayList<Cards> reserved = new ArrayList<>();

        ArrayList<Tokens> cost = new ArrayList<>();
        cost.add(diamondToken);
        cost.add(diamondToken);

        String  name = "mine";

        Cards diamondCard = new Cards(1, cost, name, diamondToken);
        reserved.add(diamondCard);

        ArrayList<Tokens> playerToken = new ArrayList<>();
        playerToken.add(diamondToken);
        playerToken.add(goldToken);

        Player player1 = new Player(1, playerToken, noCards, noNobles, reserved, "player1");
        startGame.updatePlayers(player1);
        assertTrue(startGame.checkActionFour(player1, diamondCard));
    }

    @Test
    public void testGameCheckActionFourDoesNotHaveCardReserved() throws SelectedDeckRanOutOfCards, PlayerDoesNotHaveEnoughResourcesToBuySelectedCard, PlayerDoesNotHaveSelectedCardInReserve {
        Game startGame = new Game(players, blueDeck, yellowDeck, greenDeck, cardsOnTable, tiles, allTokens);


        ArrayList<Tokens> cost = new ArrayList<>();
        cost.add(diamondToken);
        cost.add(onyxToken);

        String  name = "mine";

        Cards diamondCard = new Cards(1, cost, name, diamondToken);

        ArrayList<Tokens> playerToken = new ArrayList<>();
        playerToken.add(diamondToken);

        Player player1 = new Player(1, playerToken, noCards, noNobles, noReserves, "player1");
        startGame.updatePlayers(player1);
        assertThrows(PlayerDoesNotHaveSelectedCardInReserve.class, ()->{
            startGame.checkActionFour(player1, diamondCard);
        });
    }

    @Test
    public void testGameCheckActionFiveCanBuy() throws InvalidCardsSelectionOfCardsInReserve, InvalidCardsSelectionOfCardsOnTable, PlayerDoesNotHaveEnoughResourcesToBuySelectedCard {
        Game startGame = new Game(players, blueDeck, yellowDeck, greenDeck, cardsOnTable, tiles, allTokens);

        Player player1 = new Player(0, allTokens, noCards, noNobles, noReserves, "player1");
        startGame.updatePlayers(player1);
        assertTrue(startGame.checkActionFive(player1, 1, 1));
    }

    @Test
    public void testGameCheckActionFiveDoesNotHaveEnoughTokens() throws SelectedDeckRanOutOfCards, PlayerDoesNotHaveEnoughResourcesToBuySelectedCard, PlayerDoesNotHaveSelectedCardInReserve {
        Game startGame = new Game(players, blueDeck, yellowDeck, greenDeck, cardsOnTable, tiles, allTokens);

        ArrayList<Tokens> cost = new ArrayList<>();
        cost.add(diamondToken);
        cost.add(onyxToken);

        String  name = "mine";

        Cards diamondCard = new Cards(1, cost, name, diamondToken);

        cardsOnTable[1][1] = diamondCard;
        startGame.setCardsOnTable(cardsOnTable);

        Player player1 = new Player(1, noTokens, noCards, noNobles, noReserves, "player1");
        startGame.updatePlayers(player1);
        assertThrows(PlayerDoesNotHaveEnoughResourcesToBuySelectedCard.class, ()->{
            startGame.checkActionFive(player1, 2, 2);
        });
    }

    @Test
    public void testGameCheckActionFiveHaveEnoughTokensWithYellow() throws SelectedDeckRanOutOfCards, PlayerDoesNotHaveEnoughResourcesToBuySelectedCard, PlayerDoesNotHaveSelectedCardInReserve, InvalidCardsSelectionOfCardsInReserve, InvalidCardsSelectionOfCardsOnTable {
        Game startGame = new Game(players, blueDeck, yellowDeck, greenDeck, cardsOnTable, tiles, allTokens);

        ArrayList<Tokens> cost = new ArrayList<>();
        cost.add(diamondToken);
        cost.add(onyxToken);

        String  name = "mine";

        Cards diamondCard = new Cards(1, cost, name, diamondToken);

        cardsOnTable[1][1] = diamondCard;
        startGame.setCardsOnTable(cardsOnTable);

        ArrayList<Tokens> playerToken = new ArrayList<>();
        playerToken.add(diamondToken);
        playerToken.add(goldToken);

        Player player1 = new Player(1, playerToken, noCards, noNobles, noReserves, "player1");
        startGame.updatePlayers(player1);

        assertTrue(startGame.checkActionFive(player1, 2, 2));
    }

    @Test
    public void testGameCheckActionFiveOutOfRange() throws SelectedDeckRanOutOfCards, PlayerDoesNotHaveEnoughResourcesToBuySelectedCard, PlayerDoesNotHaveSelectedCardInReserve {
        Game startGame = new Game(players, blueDeck, yellowDeck, greenDeck, cardsOnTable, tiles, allTokens);

        ArrayList<Tokens> cost = new ArrayList<>();
        cost.add(diamondToken);
        cost.add(onyxToken);

        String  name = "mine";

        Cards diamondCard = new Cards(1, cost, name, diamondToken);

        cardsOnTable[1][1] = diamondCard;
        startGame.setCardsOnTable(cardsOnTable);

        Player player1 = new Player(1, noTokens, noCards, noNobles, noReserves, "player1");
        startGame.updatePlayers(player1);
        assertThrows(InvalidCardsSelectionOfCardsOnTable.class, ()->{
            startGame.checkActionFive(player1, 4, 4);
        });
    }

    @Test
    public void testGameCheckActionFiveOutOfRangeRow() throws SelectedDeckRanOutOfCards, PlayerDoesNotHaveEnoughResourcesToBuySelectedCard, PlayerDoesNotHaveSelectedCardInReserve {
        Game startGame = new Game(players, blueDeck, yellowDeck, greenDeck, cardsOnTable, tiles, allTokens);

        ArrayList<Tokens> cost = new ArrayList<>();
        cost.add(diamondToken);
        cost.add(onyxToken);

        String  name = "mine";

        Cards diamondCard = new Cards(1, cost, name, diamondToken);

        cardsOnTable[1][1] = diamondCard;
        startGame.setCardsOnTable(cardsOnTable);

        Player player1 = new Player(1, noTokens, noCards, noNobles, noReserves, "player1");
        startGame.updatePlayers(player1);
        assertThrows(InvalidCardsSelectionOfCardsOnTable.class, ()->{
            startGame.checkActionFive(player1, 4, 2);
        });
    }

    // Test Failed: does not check if column is out of range but row is in range
//    @Test
//    public void testGameCheckActionFiveOutOfRangeCol() throws SelectedDeckRanOutOfCards, PlayerDoesNotHaveEnoughResourcesToBuySelectedCard, PlayerDoesNotHaveSelectedCardInReserve {
//        Game startGame = new Game(players, blueDeck, yellowDeck, greenDeck, cardsOnTable, tiles, allTokens);
//
//        ArrayList<Tokens> cost = new ArrayList<>();
//        cost.add(diamondToken);
//        cost.add(onyxToken);
//
//        String  name = "mine";
//
//        Cards diamondCard = new Cards(1, cost, name, diamondToken);
//
//        cardsOnTable[1][1] = diamondCard;
//        startGame.setCardsOnTable(cardsOnTable);
//
//        Player player1 = new Player(1, noTokens, noCards, noNobles, noReserves, "player1");
//        startGame.updatePlayers(player1);
//        assertThrows(InvalidCardsSelectionOfCardsOnTable.class, ()->{
//            startGame.checkActionFive(player1, 2, 4);
//        });
//    }

    @Test
    public void testGameCheckActionFiveOutOfRangeNegRow() throws SelectedDeckRanOutOfCards, PlayerDoesNotHaveEnoughResourcesToBuySelectedCard, PlayerDoesNotHaveSelectedCardInReserve {
        Game startGame = new Game(players, blueDeck, yellowDeck, greenDeck, cardsOnTable, tiles, allTokens);

        ArrayList<Tokens> cost = new ArrayList<>();
        cost.add(diamondToken);
        cost.add(onyxToken);

        String  name = "mine";

        Cards diamondCard = new Cards(1, cost, name, diamondToken);

        cardsOnTable[1][1] = diamondCard;
        startGame.setCardsOnTable(cardsOnTable);

        Player player1 = new Player(1, noTokens, noCards, noNobles, noReserves, "player1");
        startGame.updatePlayers(player1);
        assertThrows(InvalidCardsSelectionOfCardsOnTable.class, ()->{
            startGame.checkActionFive(player1, -2, 2);
        });
    }

    @Test
    public void testGameCheckActionFiveOutOfRangeNegCol() throws SelectedDeckRanOutOfCards, PlayerDoesNotHaveEnoughResourcesToBuySelectedCard, PlayerDoesNotHaveSelectedCardInReserve {
        Game startGame = new Game(players, blueDeck, yellowDeck, greenDeck, cardsOnTable, tiles, allTokens);

        ArrayList<Tokens> cost = new ArrayList<>();
        cost.add(diamondToken);
        cost.add(onyxToken);

        String  name = "mine";

        Cards diamondCard = new Cards(1, cost, name, diamondToken);

        cardsOnTable[1][1] = diamondCard;
        startGame.setCardsOnTable(cardsOnTable);

        Player player1 = new Player(1, noTokens, noCards, noNobles, noReserves, "player1");
        startGame.updatePlayers(player1);
        assertThrows(InvalidCardsSelectionOfCardsOnTable.class, ()->{
            startGame.checkActionFive(player1, 2, -2);
        });
    }

    // Test Failed: NullPointerException
//    @Test
//    public void testGameToStringEmpty(){
//        Game startGame = new Game();
//        String expected = "/////////////////////////////////////\n" +
//                "     Blue Deck\n"  +
//                "/////////////////////////\n" +
//                "     Yellow Deck\n" +
//                "/////////////////////////\n" +
//                "     Green Deck\n" +
//                "/////////////////////////////////////\n" +
//                "Tokens Avalible: " + "Onyx x" + '0' +
//                " ,Sapphire x" + "0" + " ,Emerald x" + "0" +
//                " ,Diamond x" + "0" +" ,Rubby x" + "0" + " ,Gold x" +
//                "0" + "\n\n" + "Nobles Avalible: \n\n";
//        assertEquals(expected, startGame.toString());
//    }

    @Test
    public void testGameToStringWithPlayer(){

        Cards[][] cardsOnTable4 = new Cards[3][4];

        Cards diamondCard = new Cards("Diamond");
        Cards rubyCard = new Cards("rubby");
        Cards onyxCard = new Cards("onyx");

        for(int i = 0; i < 3; i ++){
            cardsOnTable4[i][0] = diamondCard;
            cardsOnTable4[i][1] = rubyCard;
            cardsOnTable4[i][2] = onyxCard;
            cardsOnTable4[i][3] = rubyCard;
        }

        Game startGame = new Game(players, blueDeck, yellowDeck, greenDeck, cardsOnTable4, tiles, allTokens);

        String expected = players.get(0).toString() + players.get(1).toString() + players.get(3).toString() +
                "/////////////////////////////////////\n" +
                "     Blue Deck\n"  +
                "/////////////////////////\n" +
                "     Yellow Deck\n" +
                "/////////////////////////\n" +
                "     Green Deck\n" +
                "/////////////////////////////////////\n" +
                "Tokens Avalible: " + "Onyx x" + '0' +
                " ,Sapphire x" + "0" + " ,Emerald x" + "0" +
                " ,Diamond x" + "0" +" ,Rubby x" + "0" + " ,Gold x" +
                "0" + "\n\n" + "Nobles Avalible: \n\n";

        System.out.println(startGame.toString());
    }

}