package whiteBoxTest.classesTest;

import java.awt.Color;
import Classes.*;
import Exceptions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
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
    public void testPlayerTooMuchTokens10(){
        ArrayList<Tokens> cost = new ArrayList<>();
        cost.add(diamondToken);
        cost.add(sapphireToken);
        cost.add(onyxToken);
        cost.add(emeraldToken);
        cost.add(rubyToken);
        cost.add(goldToken);
        cost.add(onyxToken);
        cost.add(emeraldToken);
        cost.add(rubyToken);
        cost.add(goldToken);
        Player newPlayer = new Player(1, cost, noCards, noNobles, noReserves, "player1");
        assertFalse(newPlayer.tooMuchTokens());
    }

    @Test
    public void testPlayerTooMuchTokens(){
        Player newPlayer = new Player(1, allTokens, noCards, noNobles, noReserves, "player1");
        assertTrue(newPlayer.tooMuchTokens());
    }

    @Test
    public void testPlayerTooMuchTokensNone(){
        Player newPlayer = new Player(1, noTokens, noCards, noNobles, noReserves, "player1");
        assertFalse(newPlayer.tooMuchTokens());
    }

    @Test
    public void testPlayerTooMuchTokens11(){
        ArrayList<Tokens> cost = new ArrayList<>();
        cost.add(diamondToken);
        cost.add(sapphireToken);
        cost.add(onyxToken);
        cost.add(emeraldToken);
        cost.add(rubyToken);
        cost.add(goldToken);
        cost.add(onyxToken);
        cost.add(emeraldToken);
        cost.add(rubyToken);
        cost.add(goldToken);
        cost.add(goldToken);
        Player newPlayer = new Player(1, cost, noCards, noNobles, noReserves, "player1");
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
    @Disabled
    @Test
    public void testPlayerNobleVisitDoesNotEnoughCardsFailed(){
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
//        cost1.add(diamondToken);
        Cards diamondCard = new Cards(1, diamondCost, "dCard", diamondToken);
        cards.add(diamondCard);
        cards.add(diamondCard);

        ArrayList<Tokens> onyxCost = new ArrayList<>();
//        cost1.add(onyxToken);
        Cards onyxCard = new Cards(1, onyxCost, "oCard", onyxToken);
        cards.add(onyxCard);

        Player newPlayer1 = new Player(1, allTokens, cards, noNobles, noReserves, "player1");
        Game  newGame = new Game(players, blueDeck, yellowDeck, greenDeck, cardsOnTable, tiles, allTokens);
        newGame.updatePlayers(newPlayer1);
        newGame.setTiles(nobleList);
        assertEquals(tiles.get(0).toString(), newPlayer1.visit(1, newGame).toString());
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
    @Disabled
    @Test
    public void testPlayerVisitEnoughCardsForTwoInvalidArgument(){
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

        assertThrows(IllegalArgumentException.class, ()->{
            newPlayer.visit(3, newGame);
        });
    }

    // Failed Test: Does not handle case of no possible visiting nobles
    @Disabled
    @Test
    public void testPlayerVisitDoesNotEnoughCards(){
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
        Game  newGame = new Game(players, blueDeck, yellowDeck, greenDeck, cardsOnTable, tiles, allTokens);
        newGame.updatePlayers(newPlayer);
        newGame.setTiles(nobleList);

        newPlayer.visit(1, newGame);

        assertEquals(1, newPlayer.getScore());
    }


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
    public void testPlayerDiscardTokenHaveOtherToken() throws InvalidTokensSelection {
        Player newPlayer = new Player(1, allTokens, noCards, noNobles, noReserves, "player1");
        Game  newGame = new Game(players, blueDeck, yellowDeck, greenDeck, cardsOnTable, tiles, allTokens);

        assertEquals(diamondToken, newPlayer.discardToken(diamondToken, newGame));
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
    @Disabled
    @Test
    public void testPlayerGetOneOfEachTokensFailed() throws NotEnoughTokensOnTable {
        Player newPlayer = new Player(1, noTokens, noCards, noNobles, noReserves, "player3");
        Game  newGame = new Game(players, blueDeck, yellowDeck, greenDeck, cardsOnTable, tiles, noTokens);
        newGame.updatePlayers(newPlayer);
        newGame.setCurrentPlayer(3);
        assertThrows(NotEnoughTokensOnTable.class, ()->{
            newPlayer.getOneOfEachTokens(onyxToken, diamondToken, rubyToken, newGame);
        });
    }

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

        Player player1 = new Player(0, noTokens, noCards, noNobles, noReserves, "player4");
        startGame.updatePlayers(player1);
        startGame.setCurrentPlayer(4);
        player1.reserveCard("blue", startGame);
        assertEquals(1, player1.getTokens().size());
        assertEquals(0, startGame.getCurrentPlayer());
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
    @Disabled
    @Test
    public void testPlayerContainsAllFalseDuplicate(){
        ArrayList<Tokens> cost1 = new ArrayList<>();
        cost1.add(diamondToken);
        cost1.add(diamondToken);

        ArrayList<Tokens> cost2 = new ArrayList<>();
        cost2.add(diamondToken);

        Player player1 = new Player(0, cost2, noCards, noNobles, noReserves, "player1");
        assertFalse(player1.containsAll(cost2, cost1));
    }

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
    @Disabled
    @Test
    public void testPlayerRemoveAllFalse(){
        ArrayList<Tokens> cost1 = new ArrayList<>();
        cost1.add(diamondToken);
        cost1.add(onyxToken);

        ArrayList<Tokens> cost2 = new ArrayList<>();
        cost2.add(diamondToken);

        Player player1 = new Player(0, cost2, noCards, noNobles, noReserves, "player1");
        assertFalse(player1.removeAll(cost2, cost1));
    }


    @Test
    public void testPlayerCanBuyWithTokens(){
        ArrayList<Tokens> cost1 = new ArrayList<>();
        cost1.add(diamondToken);

        Cards diamondCard = new Cards(1, cost1, "diamond card", diamondToken);

        ArrayList<Tokens> have = new ArrayList<>();
        have.add(diamondToken);
        have.add(onyxToken);

        Player player1 = new Player(0, have, noCards, noNobles, noReserves, "player1");
        assertFalse(player1.canBuy(diamondCard));
    }

    // Failed Test: does not consider case of buying with gold token
    @Disabled
    @Test
    public void testPlayerCanBuyWithGoldTokens(){
        ArrayList<Tokens> cost1 = new ArrayList<>();
        cost1.add(diamondToken);
        cost1.add(onyxToken);

        Cards diamondCard = new Cards(1, cost1, "diamond card", diamondToken);

        ArrayList<Tokens> have = new ArrayList<>();
        have.add(diamondToken);
        have.add(goldToken);

        Player player1 = new Player(0, have, noCards, noNobles, noReserves, "player1");
        assertTrue(player1.canBuy(diamondCard));
    }

    @Test
    public void testPlayerCanBuyWithCards(){
        ArrayList<Tokens> cost1 = new ArrayList<>();
        cost1.add(diamondToken);

        Cards diamondCard = new Cards(1, cost1, "diamond card", diamondToken);

        ArrayList<Cards> haveCard = new ArrayList<>();
        haveCard.add(diamondCard);

        Player player1 = new Player(0, noTokens, haveCard, noNobles, noReserves, "player1");
        assertTrue(player1.canBuy(diamondCard));
    }

    @Test
    public void testPlayerCanBuyWithTokensAndCards(){
        ArrayList<Tokens> cost1 = new ArrayList<>();
        cost1.add(diamondToken);
        cost1.add(onyxToken);

        ArrayList<Tokens> haveToken = new ArrayList<>();
        haveToken.add(onyxToken);

        Cards diamondCard = new Cards(1, cost1, "diamond card", diamondToken);

        ArrayList<Cards> haveCard = new ArrayList<>();
        haveCard.add(diamondCard);

        Player player1 = new Player(0, haveToken, haveCard, noNobles, noReserves, "player1");
        assertTrue(player1.canBuy(diamondCard));
    }

    @Test
    public void testPlayerCanBuyWithTokensLeft(){
        ArrayList<Tokens> cost1 = new ArrayList<>();
        cost1.add(diamondToken);
        cost1.add(onyxToken);

        ArrayList<Tokens> haveToken = new ArrayList<>();
        haveToken.add(onyxToken);
        haveToken.add(diamondToken);
        haveToken.add(onyxToken);
        haveToken.add(goldToken);

        Cards diamondCard = new Cards(1, cost1, "diamond card", diamondToken);

        Player player1 = new Player(0, haveToken, noCards, noNobles, noReserves, "player1");
        assertTrue(player1.canBuy(diamondCard));
    }

    @Test
    public void testPlayerCanBuyWithYellowTokens(){
        ArrayList<Tokens> cost1 = new ArrayList<>();
        cost1.add(diamondToken);
        cost1.add(onyxToken);

        Cards diamondCard = new Cards(1, cost1, "diamond card", diamondToken);

        ArrayList<Tokens> have = new ArrayList<>();
        have.add(diamondToken);
        have.add(goldToken);

        Player player1 = new Player(0, have, noCards, noNobles, noReserves, "player1");
        assertTrue(player1.canBuyWithYellow(diamondCard));
    }

    @Test
    public void testPlayerCanBuyWithYellow2Tokens(){
        ArrayList<Tokens> cost1 = new ArrayList<>();
        cost1.add(diamondToken);
        cost1.add(onyxToken);

        Cards diamondCard = new Cards(1, cost1, "diamond card", diamondToken);

        ArrayList<Tokens> have = new ArrayList<>();
        have.add(diamondToken);
        have.add(goldToken);

        Player player1 = new Player(0, have, noCards, noNobles, noReserves, "player1");
        assertTrue(player1.canBuyWithYellow2(diamondCard).size() > 0);
    }

    @Test
    public void testPlayerCanBuyWithYellow2TokensMult(){
        ArrayList<Tokens> cost1 = new ArrayList<>();
        cost1.add(diamondToken);
        cost1.add(onyxToken);
        cost1.add(rubyToken);

        Cards diamondCard = new Cards(1, cost1, "diamond card", diamondToken);

        ArrayList<Tokens> have = new ArrayList<>();
        have.add(diamondToken);
        have.add(goldToken);
        have.add(goldToken);
        have.add(goldToken);

        Player player1 = new Player(0, have, noCards, noNobles, noReserves, "player4");
        assertTrue(player1.canBuyWithYellow2(diamondCard).size() > 0);
    }

    @Test
    public void testPlayerCanBuyWithYellow2TokensDuplicate(){
        ArrayList<Tokens> cost1 = new ArrayList<>();
        cost1.add(diamondToken);
        cost1.add(diamondToken);

        Cards diamondCard = new Cards(1, cost1, "diamond card", diamondToken);

        ArrayList<Tokens> have = new ArrayList<>();
        have.add(diamondToken);
        have.add(goldToken);

        Player player1 = new Player(0, have, noCards, noNobles, noReserves, "player1");
        assertTrue(player1.canBuyWithYellow2(diamondCard).size() > 0);
    }

    @Test
    public void testPlayerCanBuyWithYellow2TokensExtras(){
        ArrayList<Tokens> cost1 = new ArrayList<>();
        cost1.add(diamondToken);
        cost1.add(diamondToken);
        cost1.add(onyxToken);
        cost1.add(onyxToken);

        Cards diamondCard = new Cards(1, cost1, "diamond card", diamondToken);

        ArrayList<Tokens> have = new ArrayList<>();
        have.add(diamondToken);
        have.add(onyxToken);
        have.add(goldToken);
        have.add(goldToken);
        have.add(goldToken);

        Player player1 = new Player(0, have, noCards, noNobles, noReserves, "player1");
        assertTrue(player1.canBuyWithYellow2(diamondCard).size() > 0);
    }

    @Test
    public void testPlayerPlaceCardFromReserveNotInReserve() throws PlayerDoesNotHaveEnoughResourcesToBuySelectedCard, PlayerDoesNotHaveSelectedCardInReserve {
        ArrayList<Tokens> cost1 = new ArrayList<>();
        cost1.add(diamondToken);

        Cards diamondCard = new Cards(1, cost1, "diamond card", diamondToken);

        ArrayList<Cards> haveCard = new ArrayList<>();
        haveCard.add(diamondCard);

        Player player1 = new Player(0, noTokens, haveCard, noNobles, noReserves, "player1");

        Game startGame = new Game(players, blueDeck, yellowDeck, blueDeck, cardsOnTable, tiles, allTokens);
        startGame.updatePlayers(player1);

        assertThrows(PlayerDoesNotHaveSelectedCardInReserve.class, ()->{
            player1.placeCardFromReserve(diamondCard, startGame);
        });
    }

    @Test
    public void testPlayerPlaceCardFromReserveBuyWithCards() throws PlayerDoesNotHaveEnoughResourcesToBuySelectedCard, PlayerDoesNotHaveSelectedCardInReserve {
        ArrayList<Tokens> cost1 = new ArrayList<>();
        cost1.add(diamondToken);

        Cards diamondCard = new Cards(1, cost1, "diamond card", diamondToken);

        ArrayList<Cards> haveCard = new ArrayList<>();
        haveCard.add(diamondCard);

        Player player1 = new Player(0, noTokens, haveCard, noNobles, haveCard, "player1");

        Game startGame = new Game(players, blueDeck, yellowDeck, blueDeck, cardsOnTable, tiles, allTokens);
        startGame.updatePlayers(player1);
        startGame.setCurrentPlayer(0);

        assertEquals(diamondCard, player1.placeCardFromReserve(diamondCard, startGame));
        assertEquals(1, startGame.getCurrentPlayer());
        assertTrue(player1.getScore() == 1);
    }

    @Test
    public void testPlayerPlaceCardFromReserveBuyWithCardsNext() throws PlayerDoesNotHaveEnoughResourcesToBuySelectedCard, PlayerDoesNotHaveSelectedCardInReserve {
        ArrayList<Tokens> cost1 = new ArrayList<>();
        cost1.add(diamondToken);

        Cards diamondCard = new Cards(4, cost1, "diamond card", diamondToken);

        ArrayList<Cards> haveCard = new ArrayList<>();
        haveCard.add(diamondCard);

        Player player1 = new Player(0, noTokens, haveCard, noNobles, haveCard, "player4");

        Game startGame = new Game(players, blueDeck, yellowDeck, blueDeck, cardsOnTable, tiles, allTokens);
        startGame.updatePlayers(player1);
        startGame.setCurrentPlayer(4);

        assertEquals(diamondCard, player1.placeCardFromReserve(diamondCard, startGame));
        assertEquals(0, startGame.getCurrentPlayer());
        assertTrue(player1.getScore() == 4);
    }

    @Test
    public void testPlayerPlaceCardFromReserveBuyWithGold() throws PlayerDoesNotHaveEnoughResourcesToBuySelectedCard, PlayerDoesNotHaveSelectedCardInReserve {
        ArrayList<Tokens> cost1 = new ArrayList<>();
        cost1.add(diamondToken);
        cost1.add(onyxToken);

        Cards diamondCard = new Cards(1, cost1, "diamond card", diamondToken);

        ArrayList<Cards> haveCard = new ArrayList<>();
        haveCard.add(diamondCard);

        ArrayList<Tokens> haveTokens = new ArrayList<>();
        haveTokens.add(diamondToken);
        haveTokens.add(goldToken);

        Player player1 = new Player(0, haveTokens, haveCard, noNobles, haveCard, "player3");

        Game startGame = new Game(players, blueDeck, yellowDeck, blueDeck, cardsOnTable, tiles, allTokens);
        startGame.updatePlayers(player1);
        startGame.setCurrentPlayer(3);

        assertEquals(diamondCard, player1.placeCardFromReserve(diamondCard, startGame));
        assertEquals(3, startGame.getCurrentPlayer());
    }

    @Test
    public void testPlayerBuyCardOnTableCanBuy() throws InvalidCardsSelectionOfCardsInReserve, InvalidCardsSelectionOfCardsOnTable, PlayerDoesNotHaveEnoughResourcesToBuySelectedCard {
        Game startGame = new Game(players, blueDeck, yellowDeck, greenDeck, cardsOnTable, tiles, allTokens);

        Player player1 = new Player(0, allTokens, noCards, noNobles, noReserves, "player3");
        startGame.updatePlayers(player1);
        startGame.setCurrentPlayer(3);
        assertEquals(cardsOnTable[0][0], player1.buyCardOnTable(1, 1, startGame));
        assertEquals(3, startGame.getCurrentPlayer());
    }

    @Test
    public void testPlayerBuyCardOnTableDoesHaveEnoughTokens() throws SelectedDeckRanOutOfCards, PlayerDoesNotHaveEnoughResourcesToBuySelectedCard, PlayerDoesNotHaveSelectedCardInReserve, InvalidCardsSelectionOfCardsInReserve, InvalidCardsSelectionOfCardsOnTable {
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
        playerToken.add(onyxToken);

        Player player1 = new Player(1, playerToken, noCards, noNobles, noReserves, "player1");
        startGame.updatePlayers(player1);
        startGame.setCurrentPlayer(0);
        assertEquals(cardsOnTable[1][1], player1.buyCardOnTable(2, 2, startGame));
        assertEquals(1, startGame.getCurrentPlayer());
    }

    @Test
    public void testPlayerBuyCardOnTableDoesNotHaveEnoughTokens() throws SelectedDeckRanOutOfCards, PlayerDoesNotHaveEnoughResourcesToBuySelectedCard, PlayerDoesNotHaveSelectedCardInReserve {
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
        startGame.setCurrentPlayer(0);
        assertThrows(PlayerDoesNotHaveEnoughResourcesToBuySelectedCard.class, ()->{
            assertEquals(cardsOnTable[1][1], player1.buyCardOnTable(2, 2, startGame));
            assertEquals(1, startGame.getCurrentPlayer());
        });
    }

    @Test
    public void testPlayerBuyCardOnTableHaveEnoughTokensWithoutYellow() throws SelectedDeckRanOutOfCards, PlayerDoesNotHaveEnoughResourcesToBuySelectedCard, PlayerDoesNotHaveSelectedCardInReserve, InvalidCardsSelectionOfCardsInReserve, InvalidCardsSelectionOfCardsOnTable {
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
        playerToken.add(onyxToken);

        Player player1 = new Player(1, playerToken, noCards, noNobles, noReserves, "player4");
        startGame.updatePlayers(player1);
        startGame.setCurrentPlayer(4);
        assertEquals(cardsOnTable[2][1], player1.buyCardOnTable(3, 2, startGame));
        assertEquals(0, startGame.getCurrentPlayer());
    }


    @Test
    public void testPlayerBuyCardOnTableHaveEnoughTokensWithYellow() throws SelectedDeckRanOutOfCards, PlayerDoesNotHaveEnoughResourcesToBuySelectedCard, PlayerDoesNotHaveSelectedCardInReserve, InvalidCardsSelectionOfCardsInReserve, InvalidCardsSelectionOfCardsOnTable {
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

        startGame.setCurrentPlayer(1);
        Player player1 = new Player(1, playerToken, noCards, noNobles, noReserves, "player2");
        startGame.updatePlayers(player1);
        assertEquals(cardsOnTable[2][1], player1.buyCardOnTable(3, 2, startGame));
        assertEquals(2, startGame.getCurrentPlayer());
    }

    @Test
    public void testPlayerBuyCardOnTableOutOfRange() throws SelectedDeckRanOutOfCards, PlayerDoesNotHaveEnoughResourcesToBuySelectedCard, PlayerDoesNotHaveSelectedCardInReserve {
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
            player1.buyCardOnTable(4, 4, startGame);
        });
    }

    @Test
    public void testPlayerBuyCardOnTableOutOfRangeRow() throws SelectedDeckRanOutOfCards, PlayerDoesNotHaveEnoughResourcesToBuySelectedCard, PlayerDoesNotHaveSelectedCardInReserve {
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
            player1.buyCardOnTable(4, 2, startGame);
        });
    }

    @Test
    public void testPlayerBuyCardOnTableOutOfRangeCol() throws SelectedDeckRanOutOfCards, PlayerDoesNotHaveEnoughResourcesToBuySelectedCard, PlayerDoesNotHaveSelectedCardInReserve {
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
            player1.buyCardOnTable(2, 5, startGame);
        });
    }

    @Test
    public void testPlayerTokens(){
        Player newPlayer = new Player(1, allTokens, noCards, noNobles, noReserves, "player1");
        assertEquals(7, newPlayer.whiteTokens());
        assertEquals(7, newPlayer.greenTokens());
        assertEquals(7, newPlayer.blueTokens());
        assertEquals(7, newPlayer.blackTokens());
        assertEquals(7, newPlayer.redTokens());
        assertEquals(7, newPlayer.yellowTokens());
    }

    @Test
    public void testPlayerTokensNone(){
        Player newPlayer = new Player(1, noTokens, noCards, noNobles, noReserves, "player1");
        assertEquals(0, newPlayer.whiteTokens());
        assertEquals(0, newPlayer.greenTokens());
        assertEquals(0, newPlayer.blueTokens());
        assertEquals(0, newPlayer.blackTokens());
        assertEquals(0, newPlayer.redTokens());
        assertEquals(0, newPlayer.yellowTokens());
    }

    @Test
    public void testPlayerCards(){
        ArrayList<Cards> cardList = new ArrayList<>();
        Cards onyxCard = new Cards("Onyx");
        Cards sapphireCard = new Cards("Sapphire");
        Cards emeraldCard = new Cards("Emerald");
        Cards diamondCard = new Cards("Diamond");
        Cards rubyCard = new Cards("Rubby");

        cardList.add(onyxCard);
        cardList.add(onyxCard);
        cardList.add(diamondCard);
        cardList.add(diamondCard);
        cardList.add(sapphireCard);
        cardList.add(sapphireCard);
        cardList.add(emeraldCard);
        cardList.add(emeraldCard);
        cardList.add(rubyCard);
        cardList.add(rubyCard);

        Player newPlayer = new Player(1, noTokens, cardList, noNobles, noReserves, "player1");
        assertEquals(2, newPlayer.whiteCards().size());
        assertEquals(2, newPlayer.greenCards().size());
        assertEquals(2, newPlayer.blueCards().size());
        assertEquals(2, newPlayer.blackCards().size());
        assertEquals(2, newPlayer.redCards().size());
    }

    @Test
    public void testPlayerCardsEmpty(){
        Player newPlayer = new Player(1, noTokens, noCards, noNobles, noReserves, "player1");
        assertEquals(0, newPlayer.whiteCards().size());
        assertEquals(0, newPlayer.greenCards().size());
        assertEquals(0, newPlayer.blueCards().size());
        assertEquals(0, newPlayer.blackCards().size());
        assertEquals(0, newPlayer.redCards().size());
    }

    @Test
    public void testToStringPlayer(){
        Player newPlayer = new Player(1, noTokens, noCards, noNobles, noReserves, "player1");
        String expected = "***** player1 0 Point(s) *****"+
                "\n" +
                "Tokens: Onyx x0 ,Sapphire x0 ,Emerlad x0 ,Diamond x0 ,Rubby x0 ,Gold x0\n" +
                "\n" +
                "Cards:\n" +
                "\n" +
                "Nobles: \n" +
                "\n" +
                "\n" +
                "Cards in Reserve x0\n" +
                "*******************************\n\n";
        assertEquals(expected, newPlayer.toString());
    }

    @Test
    public void testToStringPlayerWithTokens(){
        ArrayList<Tokens> cost = new ArrayList<>();
        cost.add(diamondToken);
        cost.add(sapphireToken);
        cost.add(onyxToken);
        cost.add(emeraldToken);
        cost.add(rubyToken);
        cost.add(goldToken);

        ArrayList<Cards> cardList = new ArrayList<>();
        Cards onyxCard = new Cards("Onyx");
        Cards sapphireCard = new Cards("Sapphire");
        Cards emeraldCard = new Cards("Emerald");
        Cards diamondCard = new Cards("Diamond");
        Cards rubyCard = new Cards("Rubby");

        cardList.add(onyxCard);
        cardList.add(diamondCard);
        cardList.add(sapphireCard);
        cardList.add(emeraldCard);
        cardList.add(rubyCard);

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

        Player newPlayer = new Player(1, cost, cardList, tiles, cardList, "player1");
        String expected = "***** player1 9 Point(s) *****"+
                "\n" +
                "Tokens: Onyx x1 ,Sapphire x1 ,Emerlad x1 ,Diamond x1 ,Rubby x1 ,Gold x1\n" +
                "\n" +
                "Cards:\n" + "0     Onyx  HACK\n" +
                "\n" +
                "\n" +
                "0     Diamond  HACK\n" +
                "\n" +
                "\n" +
                "0     Sapphire  HACK\n" +
                "\n" +
                "\n" +
                "0     Emerald  HACK\n" +
                "\n" +
                "\n" +
                "0     Rubby  HACK\n" +
                "\n\n" +
                "Nobles: \n" + "******* noble1*******\n" +
                "   Diamond x2 \n" +
                "   ******* noble2*******\n" +
                "   Rubby x2 \n" +
                "   ******* noble3*******\n" +
                "   Sapphire x2 \n" +
                "   " +
                "\n" +
                "\n" +
                "Cards in Reserve x5\n" +
                "*******************************\n\n";
        assertEquals(expected, newPlayer.toString());
    }


    @Test
    public void testToStringPlayerWithAllDuplicates(){
        ArrayList<Tokens> cost = new ArrayList<>();
        cost.add(diamondToken);
        cost.add(sapphireToken);
        cost.add(onyxToken);
        cost.add(emeraldToken);
        cost.add(rubyToken);
        cost.add(goldToken);

        ArrayList<Cards> cardList = new ArrayList<>();
        Cards onyxCard = new Cards("Onyx");
        Cards sapphireCard = new Cards("Sapphire");
        Cards emeraldCard = new Cards("Emerald");
        Cards diamondCard = new Cards("Diamond");
        Cards rubyCard = new Cards("Rubby");

        cardList.add(onyxCard);
        cardList.add(onyxCard);
        cardList.add(diamondCard);
        cardList.add(sapphireCard);
        cardList.add(sapphireCard);
        cardList.add(emeraldCard);
        cardList.add(rubyCard);

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

        Player newPlayer = new Player(1, cost, cardList, tiles, cardList, "player1");
        String expected = "***** player1 9 Point(s) *****\n" +
                "Tokens: Onyx x1 ,Sapphire x1 ,Emerlad x1 ,Diamond x1 ,Rubby x1 ,Gold x1\n" +
                "\n" +
                "Cards:\n" +
                "0     Onyx  HACK\n" +
                "\n" +
                "0     Onyx  HACK\n" +
                "\n" +
                "\n" +
                "0     Diamond  HACK\n" +
                "\n" +
                "\n" +
                "0     Sapphire  HACK\n" +
                "\n" +
                "0     Sapphire  HACK\n" +
                "\n" +
                "\n" +
                "0     Emerald  HACK\n" +
                "\n" +
                "\n" +
                "0     Rubby  HACK\n" +
                "\n" +
                "\n" +
                "Nobles: \n" +
                "******* noble1*******\n" +
                "   Diamond x2 \n" +
                "   ******* noble2*******\n" +
                "   Rubby x2 \n" +
                "   ******* noble3*******\n" +
                "   Sapphire x2 \n" +
                "   \n" +
                "\n" +
                "Cards in Reserve x7\n" +
                "*******************************\n" +
                "\n";
        assertEquals(expected, newPlayer.toString());
    }


    @Test
    public void testToStringWithCardsInReservePlayerWithTokens(){
        ArrayList<Tokens> cost = new ArrayList<>();
        cost.add(diamondToken);
        cost.add(sapphireToken);
        cost.add(onyxToken);
        cost.add(emeraldToken);
        cost.add(rubyToken);
        cost.add(goldToken);

        ArrayList<Cards> cardList = new ArrayList<>();
        Cards onyxCard = new Cards("Onyx");
        Cards sapphireCard = new Cards("Sapphire");
        Cards emeraldCard = new Cards("Emerald");
        Cards diamondCard = new Cards("Diamond");
        Cards rubyCard = new Cards("Rubby");

        cardList.add(onyxCard);
        cardList.add(diamondCard);
        cardList.add(sapphireCard);
        cardList.add(emeraldCard);
        cardList.add(rubyCard);

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

        Player newPlayer = new Player(1, cost, cardList, tiles, cardList, "player1");
        String expected = "***** player1 9 Point(s) *****\n" +
                "Tokens: Onyx x1 ,Sapphire x1 ,Emerlad x1 ,Diamond x1 ,Rubby x1 ,Gold x1\n" +
                "\n" +
                "**** Cards ****\n" +
                "0     Onyx  HACK\n" +
                "\n" +
                "   \n" +
                "0     Diamond  HACK\n" +
                "\n" +
                "   \n" +
                "0     Sapphire  HACK\n" +
                "\n" +
                "   \n" +
                "0     Emerald  HACK\n" +
                "\n" +
                "   \n" +
                "0     Rubby  HACK\n" +
                "\n" +
                "   \n" +
                "**** Nobles ****\n" +
                "******* noble1*******\n" +
                "   Diamond x2 \n" +
                "******* noble2*******\n" +
                "   Rubby x2 \n" +
                "******* noble3*******\n" +
                "   Sapphire x2 \n" +
                "\n" +
                "\n" +
                "**** Cards in Reserve **** \n" +
                "\n" +
                "0     Onyx  HACK\n" +
                "\n" +
                "\n" +
                "0     Diamond  HACK\n" +
                "\n" +
                "\n" +
                "0     Sapphire  HACK\n" +
                "\n" +
                "\n" +
                "0     Emerald  HACK\n" +
                "\n" +
                "\n" +
                "0     Rubby  HACK\n" +
                "\n\n";
        assertEquals(expected, newPlayer.toStringWithCardsInReserve());
    }

    @Test
    public void testToStringWithCardsInReservePlayerWithTokensDuplicate(){
        ArrayList<Tokens> cost = new ArrayList<>();
        cost.add(diamondToken);
        cost.add(sapphireToken);
        cost.add(onyxToken);
        cost.add(emeraldToken);
        cost.add(rubyToken);
        cost.add(goldToken);

        ArrayList<Cards> cardList = new ArrayList<>();
        Cards onyxCard = new Cards("Onyx");
        Cards sapphireCard = new Cards("Sapphire");
        Cards emeraldCard = new Cards("Emerald");
        Cards diamondCard = new Cards("Diamond");
        Cards rubyCard = new Cards("Rubby");

        cardList.add(onyxCard);
        cardList.add(onyxCard);
        cardList.add(diamondCard);
        cardList.add(onyxCard);
        cardList.add(sapphireCard);
        cardList.add(emeraldCard);
        cardList.add(rubyCard);

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

        Player newPlayer = new Player(1, cost, cardList, tiles, cardList, "player1");
        String expected = "***** player1 9 Point(s) *****\n" +
                "Tokens: Onyx x1 ,Sapphire x1 ,Emerlad x1 ,Diamond x1 ,Rubby x1 ,Gold x1\n" +
                "\n" +
                "**** Cards ****\n" +
                "0     Onyx  HACK\n" +
                "\n" +
                "   0     Onyx  HACK\n" +
                "\n" +
                "   \n" +
                "0     Diamond  HACK\n" +
                "\n" +
                "   \n" +
                "0     Onyx  HACK\n" +
                "\n" +
                "   \n" +
                "0     Sapphire  HACK\n" +
                "\n" +
                "   \n" +
                "0     Emerald  HACK\n" +
                "\n" +
                "   \n" +
                "0     Rubby  HACK\n" +
                "\n" +
                "   \n" +
                "**** Nobles ****\n" +
                "******* noble1*******\n" +
                "   Diamond x2 \n" +
                "******* noble2*******\n" +
                "   Rubby x2 \n" +
                "******* noble3*******\n" +
                "   Sapphire x2 \n" +
                "\n" +
                "\n" +
                "**** Cards in Reserve **** \n" +
                "\n" +
                "0     Onyx  HACK\n" +
                "\n" +
                "\n" +
                "0     Onyx  HACK\n" +
                "\n" +
                "\n" +
                "0     Diamond  HACK\n" +
                "\n" +
                "\n" +
                "0     Onyx  HACK\n" +
                "\n" +
                "\n" +
                "0     Sapphire  HACK\n" +
                "\n" +
                "\n" +
                "0     Emerald  HACK\n" +
                "\n" +
                "\n" +
                "0     Rubby  HACK\n" +
                "\n" +
                "\n";
        assertEquals(expected, newPlayer.toStringWithCardsInReserve());
    }

}