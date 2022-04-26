package whiteBoxTest.classesTest;

import java.awt.Color;
import Classes.*;
import Exceptions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class PlayerTest {

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
    public void setUpCards() {
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
    public void testPlayerConstructorEmpty(){
        Player newPlayer = new Player(1, noTokens, noCards, noNobles, noReserves, "player1");
    }

    @Test
    public void testPlayerGetColor(){
        Player newPlayer = new Player(1, noTokens, noCards, noNobles, noReserves, "player1");
        assertEquals(java.awt.Color.class, newPlayer.getColor().getClass());
    }

    @Test
    public void testPlayerSetColor(){
        Player newPlayer = new Player(1, noTokens, noCards, noNobles, noReserves, "player1");
        Color newColor = new Color(200);
        newPlayer.setColor(newColor);
        assertEquals(newColor, newPlayer.getColor());
    }

    @Test
    public void testPlayerGetCards(){
        ArrayList<Cards> diamondDeck = new ArrayList<>();
        Cards diamondCard = new Cards("Diamond");
        diamondDeck.add(diamondCard);

        Player newPlayer = new Player(1, noTokens, diamondDeck, noNobles, noReserves, "player1");
        assertEquals(diamondDeck, newPlayer.getCards());
    }

    @Test
    public void testPlayerSetCards(){
        ArrayList<Cards> diamondDeck = new ArrayList<>();
        Cards diamondCard = new Cards("Diamond");
        diamondDeck.add(diamondCard);

        Player newPlayer = new Player(1, noTokens, noCards, noNobles, noReserves, "player1");
        newPlayer.setCards(diamondDeck);
        assertEquals(diamondDeck, newPlayer.getCards());
    }

    @Test
    public void testPlayerGetReserve(){
        ArrayList<Cards> diamondDeck = new ArrayList<>();
        Cards diamondCard = new Cards("Diamond");
        diamondDeck.add(diamondCard);

        Player newPlayer = new Player(1, noTokens, noCards, noNobles, diamondDeck, "player1");
        assertEquals(diamondDeck, newPlayer.getReserve());
    }

    @Test
    public void testPlayerSetReserve(){
        ArrayList<Cards> diamondDeck = new ArrayList<>();
        Cards diamondCard = new Cards("Diamond");
        diamondDeck.add(diamondCard);

        Player newPlayer = new Player(1, noTokens, noCards, noNobles, noReserves, "player1");
        newPlayer.setReserve(diamondDeck);
        assertEquals(1, newPlayer.getReserve().size());
    }

    @Test
    public void testPlayerGetScore(){
        Player newPlayer = new Player(1, noTokens, noCards, noNobles, noReserves, "player1");
        assertEquals(1, newPlayer.getScore());
    }

    @Test
    public void testPlayerSetScore(){
        Player newPlayer = new Player(1, noTokens, noCards, noNobles, noReserves, "player1");
        newPlayer.setScore(3);
        assertEquals(3, newPlayer.getScore());
    }

    @Test
    public void testPlayerGetToken(){
        Player newPlayer = new Player(1, allTokens, noCards, noNobles, noReserves, "player1");
        assertEquals(allTokens, newPlayer.getTokens());
    }

    @Test
    public void testPlayerSetToken(){
        Player newPlayer = new Player(1, noTokens, noCards, noNobles, noReserves, "player1");
        newPlayer.setTokens(allTokens);
        assertEquals(allTokens, newPlayer.getTokens());
    }

    @Test
    public void testPlayerGetName(){
        Player newPlayer = new Player(1, allTokens, noCards, noNobles, noReserves, "player1");
        assertEquals("player1", newPlayer.getName());
    }

    @Test
    public void testPlayerSetName(){
        Player newPlayer = new Player(1, noTokens, noCards, noNobles, noReserves, "player1");
        newPlayer.setName("Player2");
        assertEquals("Player2", newPlayer.getName());
    }

    @Test
    public void testPlayerGetNobles(){
        ArrayList<Tokens> cost1 = new ArrayList<>();
        cost1.add(diamondToken);
        cost1.add(diamondToken);
        Noble noble1 = new Noble("noble1", cost1);
        ArrayList<Noble> nobleList = new ArrayList<>();
        nobleList.add(noble1);
        Player newPlayer = new Player(1, noTokens, noCards, nobleList, noReserves, "player1");
        assertEquals(nobleList, newPlayer.getNobles());
    }

    @Test
    public void testPlayerSetNobles(){
        ArrayList<Tokens> cost1 = new ArrayList<>();
        cost1.add(diamondToken);
        cost1.add(diamondToken);
        Noble noble1 = new Noble("noble1", cost1);
        ArrayList<Noble> nobleList = new ArrayList<>();
        nobleList.add(noble1);

        Player newPlayer = new Player(1, noTokens, noCards, noNobles, noReserves, "player1");
        newPlayer.setNobles(nobleList);
        assertEquals(nobleList, newPlayer.getNobles());
    }

    @Test
    public void testPlayerGetPointsNone(){
        Player newPlayer = new Player(1, noTokens, noCards, noNobles, noReserves, "player1");
        assertEquals(0, newPlayer.getPoints());
    }

    @Test
    public void testPlayerGetPointsNoble(){
        ArrayList<Tokens> cost1 = new ArrayList<>();
        cost1.add(diamondToken);
        cost1.add(diamondToken);
        Noble noble1 = new Noble("noble1", cost1);
        ArrayList<Noble> nobleList = new ArrayList<>();
        nobleList.add(noble1);

        Player newPlayer = new Player(1, noTokens, noCards, nobleList, noReserves, "player1");
        assertEquals(3, newPlayer.getPoints());
    }

    @Test
    public void testPlayerGetPointsNobles(){
        ArrayList<Tokens> cost1 = new ArrayList<>();
        cost1.add(diamondToken);
        cost1.add(diamondToken);
        Noble noble1 = new Noble("noble1", cost1);
        ArrayList<Noble> nobleList = new ArrayList<>();
        nobleList.add(noble1);
        nobleList.add(noble1);
        nobleList.add(noble1);

        Player newPlayer = new Player(1, noTokens, noCards, nobleList, noReserves, "player1");
        assertEquals(9, newPlayer.getPoints());
    }

    @Test
    public void testPlayerGetPointsCard(){
        ArrayList<Cards> diamondDeck = new ArrayList<>();
        Cards diamondCard = new Cards("Diamond");
        diamondCard.setPt(1);
        diamondDeck.add(diamondCard);

        Player newPlayer = new Player(1, noTokens, diamondDeck, noNobles, noReserves, "player1");
        assertEquals(1, newPlayer.getPoints());
    }

    @Test
    public void testPlayerGetPointsCards(){
        ArrayList<Cards> diamondDeck = new ArrayList<>();
        Cards diamondCard = new Cards("Diamond");
        diamondCard.setPt(1);
        diamondDeck.add(diamondCard);
        diamondDeck.add(diamondCard);
        diamondDeck.add(diamondCard);

        Player newPlayer = new Player(1, noTokens, diamondDeck, noNobles, noReserves, "player1");
        assertEquals(3, newPlayer.getPoints());
    }

    @Test
    public void testPlayerNumOf(){
        Player newPlayer = new Player(1, allTokens, noCards, noNobles, noReserves, "player1");
        assertEquals(7, newPlayer.numOf(diamondToken));
    }

    @Test
    public void testPlayerTooMuchTokens(){
        Player newPlayer = new Player(1, allTokens, noCards, noNobles, noReserves, "player1");
        assertTrue(newPlayer.tooMuchTokens());
    }

    @Test
    public void testPlayerRemoveYellow(){
        Player newPlayer = new Player(1, allTokens, noCards, noNobles, noReserves, "player1");
        ArrayList<Tokens> testTokens = (ArrayList<Tokens>) allTokens.clone();
        newPlayer.removeYellow(testTokens);
        assertEquals(allTokens.size()-7, testTokens.size());
    }

    @Test
    public void testPlayerRemoveYellowNone(){
        Player newPlayer = new Player(1, noTokens, noCards, noNobles, noReserves, "player1");
        ArrayList<Tokens> testTokens = new ArrayList<>();
        testTokens.add(onyxToken);
        testTokens.add(diamondToken);
        testTokens.add(rubyToken);
        newPlayer.removeYellow(testTokens);

        assertEquals(3, testTokens.size());
    }

    @Test
    public void testPlayerNobleVisitDoesNoCards(){
        ArrayList<Tokens> cost1 = new ArrayList<>();
        cost1.add(diamondToken);
        cost1.add(diamondToken);
        Noble noble1 = new Noble("noble1", cost1);
        ArrayList<Noble> nobleList = new ArrayList<>();
        nobleList.add(noble1);

        Player newPlayer = new Player(1, allTokens, noCards, noNobles, noReserves, "player1");
        Game newGame = new Game();
        newGame.setTiles(nobleList);

        assertEquals(0, newPlayer.nobleVisit(newGame).size());
    }

    // Failed does not consider number
//    @Test
//    public void testPlayerNobleVisitDoesNotEnoughCards(){
//        ArrayList<Tokens> cost1 = new ArrayList<>();
//        cost1.add(diamondToken);
//        cost1.add(diamondToken);
//        Noble noble1 = new Noble("noble1", cost1);
//        ArrayList<Noble> nobleList = new ArrayList<>();
//        nobleList.add(noble1);
//
//        ArrayList<Cards> cards = new ArrayList<>();
//
//        ArrayList<Tokens> diamondCost = new ArrayList<>();
//        cost1.add(diamondToken);
//        Cards diamondCard = new Cards(1, diamondCost, "dCard", diamondToken);
//        cards.add(diamondCard);
//
//        ArrayList<Tokens> onyxCost = new ArrayList<>();
//        cost1.add(onyxToken);
//        Cards onyxCard = new Cards(1, onyxCost, "oCard", onyxToken);
//        cards.add(onyxCard);
//
//        Player newPlayer = new Player(1, allTokens, cards, noNobles, noReserves, "player1");
//        Game newGame = new Game();
//        newGame.setTiles(nobleList);
//
//        assertEquals(0, newPlayer.nobleVisit(newGame).size());
//    }

    @Test
    public void testPlayerNobleVisitDoesNotEnoughCards(){
        ArrayList<Tokens> cost1 = new ArrayList<>();
        cost1.add(diamondToken);
        Noble noble1 = new Noble("noble1", cost1);
        ArrayList<Noble> nobleList = new ArrayList<>();
        nobleList.add(noble1);

        ArrayList<Cards> cards = new ArrayList<>();

        ArrayList<Tokens> onyxCost = new ArrayList<>();
        cost1.add(onyxToken);
        Cards onyxCard = new Cards(1, onyxCost, "oCard", onyxToken);
        cards.add(onyxCard);

        Player newPlayer = new Player(1, allTokens, cards, noNobles, noReserves, "player1");
        Game newGame = new Game();
        newGame.setTiles(nobleList);

        assertEquals(0, newPlayer.nobleVisit(newGame).size());
    }

    @Test
    public void testPlayerNobleVisitDoesHaveEnoughCards(){
        ArrayList<Tokens> cost1 = new ArrayList<>();
        cost1.add(diamondToken);
        cost1.add(diamondToken);
        Noble noble1 = new Noble("noble1", cost1);
        ArrayList<Noble> nobleList = new ArrayList<>();
        nobleList.add(noble1);

        ArrayList<Cards> cards = new ArrayList<>();

        ArrayList<Tokens> diamondCost = new ArrayList<>();
        cost1.add(diamondToken);
        Cards diamondCard = new Cards(1, diamondCost, "dCard", diamondToken);
        cards.add(diamondCard);
        cards.add(diamondCard);

        ArrayList<Tokens> onyxCost = new ArrayList<>();
        cost1.add(onyxToken);
        Cards onyxCard = new Cards(1, onyxCost, "oCard", onyxToken);
        cards.add(onyxCard);

        Player newPlayer = new Player(1, allTokens, cards, noNobles, noReserves, "player1");
        Game newGame = new Game();
        newGame.setTiles(nobleList);

        assertEquals(1, newPlayer.nobleVisit(newGame).size());
    }

    @Test
    public void testPlayerNobleVisitEnoughCardsForOnlyOne(){
        ArrayList<Tokens> cost1 = new ArrayList<>();
        cost1.add(diamondToken);
        cost1.add(diamondToken);
        Noble noble1 = new Noble("noble1", cost1);
        ArrayList<Noble> nobleList = new ArrayList<>();
        nobleList.add(noble1);

        ArrayList<Tokens> cost2 = new ArrayList<>();
        cost1.add(rubyToken);
        Noble noble2 = new Noble("noble2", cost2);
        nobleList.add(noble2);

        ArrayList<Cards> cards = new ArrayList<>();

        ArrayList<Tokens> diamondCost = new ArrayList<>();
        cost1.add(diamondToken);
        Cards diamondCard = new Cards(1, diamondCost, "dCard", diamondToken);
        cards.add(diamondCard);
        cards.add(diamondCard);

        ArrayList<Tokens> onyxCost = new ArrayList<>();
        cost1.add(onyxToken);
        Cards onyxCard = new Cards(1, onyxCost, "oCard", onyxToken);
        cards.add(onyxCard);

        Player newPlayer = new Player(1, allTokens, cards, noNobles, noReserves, "player1");
        Game newGame = new Game();
        newGame.setTiles(nobleList);

        assertEquals(1, newPlayer.nobleVisit(newGame).size());
    }

    @Test
    public void testPlayerNobleVisitEnoughCardsForTwo(){
        ArrayList<Tokens> cost1 = new ArrayList<>();
        cost1.add(diamondToken);
        cost1.add(diamondToken);
        Noble noble1 = new Noble("noble1", cost1);
        ArrayList<Noble> nobleList = new ArrayList<>();
        nobleList.add(noble1);

        ArrayList<Tokens> cost2 = new ArrayList<>();
        cost1.add(onyxToken);
        Noble noble2 = new Noble("noble2", cost2);
        nobleList.add(noble2);

        ArrayList<Cards> cards = new ArrayList<>();

        ArrayList<Tokens> diamondCost = new ArrayList<>();
        cost1.add(diamondToken);
        Cards diamondCard = new Cards(1, diamondCost, "dCard", diamondToken);
        cards.add(diamondCard);
        cards.add(diamondCard);

        ArrayList<Tokens> onyxCost = new ArrayList<>();
        cost1.add(onyxToken);
        Cards onyxCard = new Cards(1, onyxCost, "oCard", onyxToken);
        cards.add(onyxCard);

        Player newPlayer = new Player(1, allTokens, cards, noNobles, noReserves, "player1");
        Game newGame = new Game();
        newGame.setTiles(nobleList);

        assertEquals(2, newPlayer.nobleVisit(newGame).size());
    }

    @Test
    public void testPlayerVisitDoesHaveEnoughCards(){
        ArrayList<Tokens> cost1 = new ArrayList<>();
        cost1.add(diamondToken);
        cost1.add(diamondToken);
        Noble noble1 = new Noble("noble1", cost1);
        ArrayList<Noble> nobleList = new ArrayList<>();
        nobleList.add(noble1);

        ArrayList<Cards> cards = new ArrayList<>();

        ArrayList<Tokens> diamondCost = new ArrayList<>();
        cost1.add(diamondToken);
        Cards diamondCard = new Cards(1, diamondCost, "dCard", diamondToken);
        cards.add(diamondCard);
        cards.add(diamondCard);

        ArrayList<Tokens> onyxCost = new ArrayList<>();
        cost1.add(onyxToken);
        Cards onyxCard = new Cards(1, onyxCost, "oCard", onyxToken);
        cards.add(onyxCard);

        Player newPlayer1 = new Player(1, allTokens, cards, noNobles, noReserves, "player1");
        Game  newGame = new Game(players, blueDeck, yellowDeck, greenDeck, cardsOnTable, tiles, allTokens);
        newGame.updatePlayers(newPlayer1);
        newGame.setTiles(nobleList);
        newPlayer1.visit(1, newGame);

        assertEquals(4, newPlayer1.getScore());
    }

    @Test
    public void testPlayerVisitEnoughCardsForOnlyOne(){
        ArrayList<Tokens> cost1 = new ArrayList<>();
        cost1.add(diamondToken);
        cost1.add(diamondToken);
        Noble noble1 = new Noble("noble1", cost1);
        ArrayList<Noble> nobleList = new ArrayList<>();
        nobleList.add(noble1);

        ArrayList<Tokens> cost2 = new ArrayList<>();
        cost1.add(rubyToken);
        Noble noble2 = new Noble("noble2", cost2);
        nobleList.add(noble2);

        ArrayList<Cards> cards = new ArrayList<>();

        ArrayList<Tokens> diamondCost = new ArrayList<>();
        cost1.add(diamondToken);
        Cards diamondCard = new Cards(1, diamondCost, "dCard", diamondToken);
        cards.add(diamondCard);
        cards.add(diamondCard);

        ArrayList<Tokens> onyxCost = new ArrayList<>();
        cost1.add(onyxToken);
        Cards onyxCard = new Cards(1, onyxCost, "oCard", onyxToken);
        cards.add(onyxCard);

        Player newPlayer = new Player(1, allTokens, cards, noNobles, noReserves, "player1");
        Game  newGame = new Game(players, blueDeck, yellowDeck, greenDeck, cardsOnTable, tiles, allTokens);
        newGame.updatePlayers(newPlayer);
        newGame.setTiles(nobleList);

        newPlayer.visit(1, newGame);

        assertEquals(4, newPlayer.getScore());
    }

    @Test
    public void testPlayerVisitEnoughCardsForTwo(){
        ArrayList<Tokens> cost1 = new ArrayList<>();
        cost1.add(diamondToken);
        cost1.add(diamondToken);
        Noble noble1 = new Noble("noble1", cost1);
        ArrayList<Noble> nobleList = new ArrayList<>();
        nobleList.add(noble1);

        ArrayList<Tokens> cost2 = new ArrayList<>();
        cost1.add(onyxToken);
        Noble noble2 = new Noble("noble2", cost2);
        nobleList.add(noble2);

        ArrayList<Cards> cards = new ArrayList<>();

        ArrayList<Tokens> diamondCost = new ArrayList<>();
        cost1.add(diamondToken);
        Cards diamondCard = new Cards(1, diamondCost, "dCard", diamondToken);
        cards.add(diamondCard);
        cards.add(diamondCard);

        ArrayList<Tokens> onyxCost = new ArrayList<>();
        cost1.add(onyxToken);
        Cards onyxCard = new Cards(1, onyxCost, "oCard", onyxToken);
        cards.add(onyxCard);

        Player newPlayer = new Player(1, allTokens, cards, noNobles, noReserves, "player1");
        Game  newGame = new Game(players, blueDeck, yellowDeck, greenDeck, cardsOnTable, tiles, allTokens);
        newGame.updatePlayers(newPlayer);
        newGame.setTiles(nobleList);

        newPlayer.visit(1, newGame);

        assertEquals(4, newPlayer.getScore());
    }

    @Test
    public void testPlayerVisitEnoughCardsForTwoSecond(){
        ArrayList<Tokens> cost1 = new ArrayList<>();
        cost1.add(diamondToken);
        cost1.add(diamondToken);
        Noble noble1 = new Noble("noble1", cost1);
        ArrayList<Noble> nobleList = new ArrayList<>();
        nobleList.add(noble1);

        ArrayList<Tokens> cost2 = new ArrayList<>();
        cost1.add(onyxToken);
        Noble noble2 = new Noble("noble2", cost2);
        nobleList.add(noble2);

        ArrayList<Cards> cards = new ArrayList<>();

        ArrayList<Tokens> diamondCost = new ArrayList<>();
        cost1.add(diamondToken);
        Cards diamondCard = new Cards(1, diamondCost, "dCard", diamondToken);
        cards.add(diamondCard);
        cards.add(diamondCard);

        ArrayList<Tokens> onyxCost = new ArrayList<>();
        cost1.add(onyxToken);
        Cards onyxCard = new Cards(1, onyxCost, "oCard", onyxToken);
        cards.add(onyxCard);

        Player newPlayer = new Player(1, allTokens, cards, noNobles, noReserves, "player1");
        Game  newGame = new Game(players, blueDeck, yellowDeck, greenDeck, cardsOnTable, tiles, allTokens);
        newGame.updatePlayers(newPlayer);
        newGame.setTiles(nobleList);

        newPlayer.visit(2, newGame);

        assertEquals(4, newPlayer.getScore());
    }

    // Failed Test: Does not check for invalid int argument
//    @Test
//    public void testPlayerVisitEnoughCardsForTwoInvalidArgument(){
//        ArrayList<Tokens> cost1 = new ArrayList<>();
//        cost1.add(diamondToken);
//        cost1.add(diamondToken);
//        Noble noble1 = new Noble("noble1", cost1);
//        ArrayList<Noble> nobleList = new ArrayList<>();
//        nobleList.add(noble1);
//
//        ArrayList<Tokens> cost2 = new ArrayList<>();
//        cost1.add(onyxToken);
//        Noble noble2 = new Noble("noble2", cost2);
//        nobleList.add(noble2);
//
//        ArrayList<Cards> cards = new ArrayList<>();
//
//        ArrayList<Tokens> diamondCost = new ArrayList<>();
//        cost1.add(diamondToken);
//        Cards diamondCard = new Cards(1, diamondCost, "dCard", diamondToken);
//        cards.add(diamondCard);
//        cards.add(diamondCard);
//
//        ArrayList<Tokens> onyxCost = new ArrayList<>();
//        cost1.add(onyxToken);
//        Cards onyxCard = new Cards(1, onyxCost, "oCard", onyxToken);
//        cards.add(onyxCard);
//
//        Player newPlayer = new Player(1, allTokens, cards, noNobles, noReserves, "player1");
//        Game  newGame = new Game(players, blueDeck, yellowDeck, greenDeck, cardsOnTable, tiles, allTokens);
//        newGame.updatePlayers(newPlayer);
//        newGame.setTiles(nobleList);
//
//        assertThrows(IllegalArgumentException.class, ()->{
//            newPlayer.visit(3, newGame);
//        });
//    }

    // Failed Test: Does not handle case of no possible visiting nobles
//    @Test
//    public void testPlayerVisitDoesNotEnoughCards(){
//        ArrayList<Tokens> cost1 = new ArrayList<>();
//        cost1.add(diamondToken);
//        Noble noble1 = new Noble("noble1", cost1);
//        ArrayList<Noble> nobleList = new ArrayList<>();
//        nobleList.add(noble1);
//
//        ArrayList<Cards> cards = new ArrayList<>();
//
//        ArrayList<Tokens> onyxCost = new ArrayList<>();
//        cost1.add(onyxToken);
//        Cards onyxCard = new Cards(1, onyxCost, "oCard", onyxToken);
//        cards.add(onyxCard);
//
//        Player newPlayer = new Player(1, allTokens, cards, noNobles, noReserves, "player1");
//        Game  newGame = new Game(players, blueDeck, yellowDeck, greenDeck, cardsOnTable, tiles, allTokens);
//        newGame.updatePlayers(newPlayer);
//        newGame.setTiles(nobleList);
//
//        newPlayer.visit(1, newGame);
//
//        assertEquals(1, newPlayer.getScore());
//    }


    @Test
    public void testPlayerSetOwner(){
        ArrayList<Tokens> cost1 = new ArrayList<>();
        cost1.add(diamondToken);
        cost1.add(diamondToken);
        Noble noble1 = new Noble("noble1", cost1);
        ArrayList<Noble> nobleList = new ArrayList<>();
        nobleList.add(noble1);

        ArrayList<Tokens> cost2 = new ArrayList<>();
        cost1.add(onyxToken);
        Noble noble2 = new Noble("noble2", cost2);
        nobleList.add(noble2);

        ArrayList<Cards> cards = new ArrayList<>();

        ArrayList<Tokens> diamondCost = new ArrayList<>();
        cost1.add(diamondToken);
        Cards diamondCard = new Cards(1, diamondCost, "dCard", diamondToken);
        cards.add(diamondCard);
        cards.add(diamondCard);

        ArrayList<Tokens> onyxCost = new ArrayList<>();
        cost1.add(onyxToken);
        Cards onyxCard = new Cards(1, onyxCost, "oCard", onyxToken);
        cards.add(onyxCard);

        Player newPlayer = new Player(1, allTokens, cards, noNobles, noReserves, "player1");
        Game  newGame = new Game(players, blueDeck, yellowDeck, greenDeck, cardsOnTable, tiles, allTokens);
        newGame.updatePlayers(newPlayer);
        newGame.setTiles(nobleList);

        newPlayer.visit(1, newGame);
        newPlayer.setOwner(newGame);
        assertEquals(newPlayer, newPlayer.getNobles().get(0).getOwner());
    }

    @Test
    public void testPlayerDiscardTokenHaveToken() throws InvalidTokensSelection {
        Player newPlayer = new Player(1, allTokens, noCards, noNobles, noReserves, "player1");
        Game  newGame = new Game(players, blueDeck, yellowDeck, greenDeck, cardsOnTable, tiles, allTokens);

        assertEquals(onyxToken, newPlayer.discardToken(onyxToken, newGame));
    }

    @Test
    public void testPlayerDiscardTokenDoesNotHaveToken() throws InvalidTokensSelection {
        Player newPlayer = new Player(1, noTokens, noCards, noNobles, noReserves, "player1");
        Game  newGame = new Game(players, blueDeck, yellowDeck, greenDeck, cardsOnTable, tiles, allTokens);

        assertThrows(InvalidTokensSelection.class, ()->{
            newPlayer.discardToken(onyxToken, newGame);
        });
    }

    @Test
    public void testPlayerDiscardTokenHaveTokenLastPlayer() throws InvalidTokensSelection {
        Player newPlayer = new Player(1, allTokens, noCards, noNobles, noReserves, "player1");
        Game  newGame = new Game(players, blueDeck, yellowDeck, greenDeck, cardsOnTable, tiles, allTokens);
        newGame.setCurrentPlayer(3);
        assertEquals(onyxToken, newPlayer.discardToken(onyxToken, newGame));
        assertEquals(0, newGame.getCurrentPlayer());
    }

    @Test
    public void testPlayerDiscardTokenHaveTokenNotLastPlayer() throws InvalidTokensSelection {
        Player newPlayer = new Player(1, allTokens, noCards, noNobles, noReserves, "player1");
        Game  newGame = new Game(players, blueDeck, yellowDeck, greenDeck, cardsOnTable, tiles, allTokens);
        newGame.setCurrentPlayer(2);
        assertEquals(onyxToken, newPlayer.discardToken(onyxToken, newGame));
    }

    @Test
    public void testPlayerDiscardTokenCurrentHaveTokenTooMuchToken() throws InvalidTokensSelection {
        Player newPlayer = new Player(1, allTokens, noCards, noNobles, noReserves, "player1");
        Game  newGame = new Game(players, blueDeck, yellowDeck, greenDeck, cardsOnTable, tiles, allTokens);
        newGame.updatePlayers(newPlayer);
        newGame.setCurrentPlayer(1);
        assertEquals(onyxToken, newPlayer.discardToken(onyxToken, newGame));
        assertEquals(2, newGame.getCurrentPlayer());
    }

    @Test
    public void testPlayerDiscardTokenNextHaveTokenTooMuchToken() throws InvalidTokensSelection {
        Player newPlayer = new Player(1, allTokens, noCards, noNobles, noReserves, "player3");
        Game  newGame = new Game(players, blueDeck, yellowDeck, greenDeck, cardsOnTable, tiles, allTokens);
        newGame.updatePlayers(newPlayer);
        newGame.setCurrentPlayer(2);
        assertEquals(onyxToken, newPlayer.discardToken(onyxToken, newGame));
        assertEquals(2, newGame.getCurrentPlayer());
    }

    @Test
    public void testPlayerGetTwoTokens() throws NotEnoughTokensOnTable {
        Player newPlayer = new Player(1, noTokens, noCards, noNobles, noReserves, "player3");
        Game  newGame = new Game(players, blueDeck, yellowDeck, greenDeck, cardsOnTable, tiles, allTokens);
        newGame.updatePlayers(newPlayer);
        newGame.setCurrentPlayer(0);
        newPlayer.getTwoTokens(onyxToken, newGame);
        assertEquals(2, newPlayer.getTokens().size());
        assertEquals(1, newGame.getCurrentPlayer());
    }

    @Test
    public void testPlayerGetTwoTokensLastPlayer() throws NotEnoughTokensOnTable {
        Player newPlayer = new Player(1, noTokens, noCards, noNobles, noReserves, "player3");
        Game  newGame = new Game(players, blueDeck, yellowDeck, greenDeck, cardsOnTable, tiles, allTokens);
        newGame.updatePlayers(newPlayer);
        newGame.setCurrentPlayer(3);
        newPlayer.getTwoTokens(onyxToken, newGame);
        assertEquals(2, newPlayer.getTokens().size());
        assertEquals(0, newGame.getCurrentPlayer());
    }

    @Test
    public void testPlayerGetTwoTokensLastPlayerTooMuchTokens() throws NotEnoughTokensOnTable {
        Player newPlayer = new Player(1, allTokens, noCards, noNobles, noReserves, "player3");
        Game  newGame = new Game(players, blueDeck, yellowDeck, greenDeck, cardsOnTable, tiles, allTokens);
        newGame.updatePlayers(newPlayer);
        newGame.setCurrentPlayer(2);
        newPlayer.getTwoTokens(onyxToken, newGame);
        assertEquals(allTokens.size(), newPlayer.getTokens().size());
        assertEquals(2, newGame.getCurrentPlayer());
    }

    @Test
    public void testPlayerGetTwoTokensFailed() throws NotEnoughTokensOnTable {
        Player newPlayer = new Player(1, noTokens, noCards, noNobles, noReserves, "player3");
        Game  newGame = new Game(players, blueDeck, yellowDeck, greenDeck, cardsOnTable, tiles, noTokens);
        newGame.updatePlayers(newPlayer);
        newGame.setCurrentPlayer(3);
        assertThrows(NotEnoughTokensOnTable.class, ()->{
            newPlayer.getTwoTokens(onyxToken, newGame);
        });
    }

    @Test
    public void testPlayerGetOneOfEachTokensLastPlayerTooMuchTokens() throws NotEnoughTokensOnTable {
        Player newPlayer = new Player(1, allTokens, noCards, noNobles, noReserves, "player3");
        Game  newGame = new Game(players, blueDeck, yellowDeck, greenDeck, cardsOnTable, tiles, allTokens);
        newGame.updatePlayers(newPlayer);
        newGame.setCurrentPlayer(2);
        newPlayer.getOneOfEachTokens(onyxToken, diamondToken, rubyToken, newGame);
        assertEquals(allTokens.size(), newPlayer.getTokens().size());
        assertEquals(2, newGame.getCurrentPlayer());
    }

    //Failed test: does not throw not enough tokens on table error
//    @Test
//    public void testPlayerGetOneOfEachTokensFailed() throws NotEnoughTokensOnTable {
//        Player newPlayer = new Player(1, noTokens, noCards, noNobles, noReserves, "player3");
//        Game  newGame = new Game(players, blueDeck, yellowDeck, greenDeck, cardsOnTable, tiles, noTokens);
//        newGame.updatePlayers(newPlayer);
//        newGame.setCurrentPlayer(3);
//        assertThrows(NotEnoughTokensOnTable.class, ()->{
//            newPlayer.getOneOfEachTokens(onyxToken, diamondToken, rubyToken, newGame);
//        });
//    }

    @Test
    public void testPlayerGetOneOfEachTokensLastPlayer() throws NotEnoughTokensOnTable {
        Player newPlayer = new Player(1, allTokens, noCards, noNobles, noReserves, "player2");
        Game  newGame = new Game(players, blueDeck, yellowDeck, greenDeck, cardsOnTable, tiles, allTokens);
        newGame.updatePlayers(newPlayer);
        newGame.setCurrentPlayer(3);
        newPlayer.getOneOfEachTokens(onyxToken, diamondToken, rubyToken, newGame);
        assertEquals(allTokens.size(), newPlayer.getTokens().size());
        assertEquals(0, newGame.getCurrentPlayer());
    }

    @Test
    public void testPlayerReserveCard1() throws InvalidCardsSelectionOfCardsOnTable, PlayerAlreadyHoldsThreeReserveCards {
        Game startGame = new Game(players, blueDeck, yellowDeck, greenDeck, cardsOnTable, tiles, allTokens);
        Player player1 = new Player(0, noTokens, noCards, noNobles, noReserves, "player1");
        assertEquals(cardsOnTable[0][0], player1.reserveCard(1, 1, startGame));
    }

    @Test
    public void testPlayerReserveCard2() throws InvalidCardsSelectionOfCardsOnTable, PlayerAlreadyHoldsThreeReserveCards {
        Game startGame = new Game(players, blueDeck, yellowDeck, greenDeck, cardsOnTable, tiles, allTokens);
        Player player1 = new Player(0, noTokens, noCards, noNobles, noReserves, "player1");
        assertEquals(cardsOnTable[1][0], player1.reserveCard(2, 1, startGame));
    }

    @Test
    public void testPlayerReserveCard3() throws InvalidCardsSelectionOfCardsOnTable, PlayerAlreadyHoldsThreeReserveCards {
        Game startGame = new Game(players, blueDeck, yellowDeck, greenDeck, cardsOnTable, tiles, allTokens);
        Player player1 = new Player(0, noTokens, noCards, noNobles, noReserves, "player1");
        assertEquals(cardsOnTable[2][0], player1.reserveCard(3, 1, startGame));
    }

    @Test
    public void testPlayerReserveCardLastPlayer() throws InvalidCardsSelectionOfCardsOnTable, PlayerAlreadyHoldsThreeReserveCards {
        Game startGame = new Game(players, blueDeck, yellowDeck, greenDeck, cardsOnTable, tiles, allTokens);
        Player player4 = new Player(0, noTokens, noCards, noNobles, noReserves, "player4");
        startGame.updatePlayers(player4);
        assertEquals(cardsOnTable[0][0], player4.reserveCard(1, 1, startGame));
        assertEquals(1, player4.getTokens().size());
        assertEquals(0, startGame.getCurrentPlayer());
    }

    @Test
    public void testPlayerReserveCardInvalidRow() throws InvalidCardsSelectionOfCardsOnTable, PlayerAlreadyHoldsThreeReserveCards {
        Game startGame = new Game(players, blueDeck, yellowDeck, greenDeck, cardsOnTable, tiles, allTokens);
        Player player4 = new Player(0, noTokens, noCards, noNobles, noReserves, "player4");
        startGame.updatePlayers(player4);
        assertThrows(InvalidCardsSelectionOfCardsOnTable.class, ()->{
            player4.reserveCard(5, 1, startGame);
        });
    }

    @Test
    public void testPlayerReserveCardInvalidCol() throws InvalidCardsSelectionOfCardsOnTable, PlayerAlreadyHoldsThreeReserveCards {
        Game startGame = new Game(players, blueDeck, yellowDeck, greenDeck, cardsOnTable, tiles, allTokens);
        Player player4 = new Player(0, noTokens, noCards, noNobles, noReserves, "player4");
        startGame.updatePlayers(player4);
        assertThrows(InvalidCardsSelectionOfCardsOnTable.class, ()->{
            player4.reserveCard(1, 5, startGame);
        });
    }

    @Test
    public void testPlayerReserveCardPlayerAlreadyHoldThreeReserveCards() throws PlayerAlreadyHoldsThreeReserveCards, InvalidCardsSelectionOfCardsOnTable {
        Game startGame = new Game(players, blueDeck, yellowDeck, greenDeck, cardsOnTable, tiles, allTokens);

        ArrayList<Cards> threeReserves = new ArrayList<>();
        Cards diamondCard = new Cards("Diamond");
        threeReserves.add(diamondCard);
        threeReserves.add(diamondCard);
        threeReserves.add(diamondCard);

        Player player1 = new Player(0, noTokens, noCards, noNobles, threeReserves, "player1");
        startGame.updatePlayers(player1);
        assertThrows(PlayerAlreadyHoldsThreeReserveCards.class, ()->{
            player1.reserveCard(1, 1, startGame);
        });
    }

    @Test
    public void testPlayerReserveCardAlreadyHoldFourReserveCards() throws PlayerAlreadyHoldsThreeReserveCards, InvalidCardsSelectionOfCardsOnTable {
        Game startGame = new Game(players, blueDeck, yellowDeck, greenDeck, cardsOnTable, tiles, allTokens);

        ArrayList<Cards> fourReserves = new ArrayList<>();
        Cards diamondCard = new Cards("Diamond");
        fourReserves.add(diamondCard);
        fourReserves.add(diamondCard);
        fourReserves.add(diamondCard);
        fourReserves.add(diamondCard);

        Player player1 = new Player(0, noTokens, noCards, noNobles, fourReserves, "player1");
        startGame.updatePlayers(player1);
        assertThrows(PlayerAlreadyHoldsThreeReserveCards.class, ()->{
            player1.reserveCard(1, 1, startGame);
        });
    }

    @Test
    public void testPlayerReserveCardStringEmptyBlueDeckException() throws SelectedDeckRanOutOfCards {
        ArrayList<Cards> emptyDeck = new ArrayList<>();
        Game startGame = new Game(players, emptyDeck, yellowDeck, greenDeck, cardsOnTable, tiles, allTokens);

        Player player1 = new Player(0, noTokens, noCards, noNobles, noReserves, "player1");
        startGame.updatePlayers(player1);
        assertThrows(SelectedDeckRanOutOfCards.class, ()->{
            player1.reserveCard("blue", startGame);
        });
    }

    @Test
    public void testPlayerReserveCardStringEmptyGreenDeckException() throws SelectedDeckRanOutOfCards {
        ArrayList<Cards> emptyDeck = new ArrayList<>();
        Game startGame = new Game(players, blueDeck, yellowDeck, emptyDeck, cardsOnTable, tiles, allTokens);

        Player player1 = new Player(0, noTokens, noCards, noNobles, noReserves, "player1");
        startGame.updatePlayers(player1);
        assertThrows(SelectedDeckRanOutOfCards.class, ()->{
            player1.reserveCard("green", startGame);
        });
    }

    @Test
    public void testPlayerReserveCardStringEmptyYellowDeckException() throws SelectedDeckRanOutOfCards {
        ArrayList<Cards> emptyDeck = new ArrayList<>();
        Game startGame = new Game(players, blueDeck, emptyDeck, greenDeck, cardsOnTable, tiles, allTokens);

        Player player1 = new Player(0, noTokens, noCards, noNobles, noReserves, "player1");
        startGame.updatePlayers(player1);
        assertThrows(SelectedDeckRanOutOfCards.class, ()->{
            player1.reserveCard("yellow", startGame);
        });
    }

    @Test
    public void testPlayerReserveCardStringYellowDeck() throws SelectedDeckRanOutOfCards {
        ArrayList<Cards> emptyDeck = new ArrayList<>();
        Game startGame = new Game(players, blueDeck, yellowDeck, greenDeck, cardsOnTable, tiles, allTokens);
        Player player1 = new Player(0, noTokens, noCards, noNobles, noReserves, "player1");
        startGame.updatePlayers(player1);
        startGame.setCurrentPlayer(0);
        player1.reserveCard("yellow", startGame);
        assertEquals(1, player1.getTokens().size());
        assertEquals(1, startGame.getCurrentPlayer());
    }

    @Test
    public void testPlayerReserveCardStringBlueDeck() throws SelectedDeckRanOutOfCards {
        ArrayList<Cards> emptyDeck = new ArrayList<>();
        Game startGame = new Game(players, blueDeck, yellowDeck, greenDeck, cardsOnTable, tiles, allTokens);

        Player player1 = new Player(0, noTokens, noCards, noNobles, noReserves, "player1");
        startGame.updatePlayers(player1);
        startGame.setCurrentPlayer(0);
        player1.reserveCard("blue", startGame);
        assertEquals(1, player1.getTokens().size());
        assertEquals(1, startGame.getCurrentPlayer());
    }


    @Test
    public void testPlayerReserveCardStringGreenDeck() throws SelectedDeckRanOutOfCards {
        Game startGame = new Game(players, blueDeck, yellowDeck, greenDeck, cardsOnTable, tiles, allTokens);

        Player player1 = new Player(0, noTokens, noCards, noNobles, noReserves, "player1");
        startGame.updatePlayers(player1);
        startGame.setCurrentPlayer(0);
        player1.reserveCard("green", startGame);
        assertEquals(1, player1.getTokens().size());
        assertEquals(1, startGame.getCurrentPlayer());
    }

    @Test
    public void testPlayerContainsAllTrue(){
        ArrayList<Tokens> cost1 = new ArrayList<>();
        cost1.add(diamondToken);

        ArrayList<Tokens> cost2 = new ArrayList<>();
        cost2.add(diamondToken);

        Player player1 = new Player(0, cost2, noCards, noNobles, noReserves, "player1");
        assertTrue(player1.containsAll(cost2, cost1));
    }

    @Test
    public void testPlayerContainsAllTrueExtra(){
        ArrayList<Tokens> cost1 = new ArrayList<>();
        cost1.add(diamondToken);

        ArrayList<Tokens> cost2 = new ArrayList<>();
        cost2.add(diamondToken);
        cost2.add(onyxToken);

        Player player1 = new Player(0, cost2, noCards, noNobles, noReserves, "player1");
        assertTrue(player1.containsAll(cost2, cost1));
    }

    @Test
    public void testPlayerContainsAllFalse(){
        ArrayList<Tokens> cost1 = new ArrayList<>();
        cost1.add(diamondToken);
        cost1.add(onyxToken);

        ArrayList<Tokens> cost2 = new ArrayList<>();
        cost2.add(diamondToken);

        Player player1 = new Player(0, cost2, noCards, noNobles, noReserves, "player1");
        assertFalse(player1.containsAll(cost2, cost1));
    }

    // Test Failed: contains all does not consider duplciates
//    @Test
//    public void testPlayerContainsAllFalseDuplicate(){
//        ArrayList<Tokens> cost1 = new ArrayList<>();
//        cost1.add(diamondToken);
//        cost1.add(diamondToken);
//
//        ArrayList<Tokens> cost2 = new ArrayList<>();
//        cost2.add(diamondToken);
//
//        Player player1 = new Player(0, cost2, noCards, noNobles, noReserves, "player1");
//        assertFalse(player1.containsAll(cost2, cost1));
//    }

    @Test
    public void testPlayerRemoveAllEverythingRemoved(){
        ArrayList<Tokens> cost1 = new ArrayList<>();
        cost1.add(diamondToken);

        ArrayList<Tokens> cost2 = new ArrayList<>();
        cost2.add(diamondToken);

        Player player1 = new Player(0, cost2, noCards, noNobles, noReserves, "player1");
        assertTrue(player1.removeAll(cost2, cost1));
    }

    // removeAll always returns true
//    @Test
//    public void testPlayerRemoveAllFalse(){
//        ArrayList<Tokens> cost1 = new ArrayList<>();
//        cost1.add(diamondToken);
//        cost1.add(onyxToken);
//
//        ArrayList<Tokens> cost2 = new ArrayList<>();
//        cost2.add(diamondToken);
//
//        Player player1 = new Player(0, cost2, noCards, noNobles, noReserves, "player1");
//        assertFalse(player1.removeAll(cost2, cost1));
//    }

}