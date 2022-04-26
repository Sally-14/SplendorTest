package whiteBoxTest.interfaceTest;

import Classes.*;
import Interface.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;


public class MyPanelTest {


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
        players.add(player1);
        players.add(player2);
        players.add(player3);
    }

    @Test
    public void testMyPanelConstructor() {
        Game startGame = new Game(players, blueDeck, yellowDeck, greenDeck, cardsOnTable, tiles, allTokens);
        MyPanel startPanel = new MyPanel(startGame);
    }

    @Test
    public void testMyPanelPaint() {
        Game startGame = new Game(players, blueDeck, yellowDeck, greenDeck, cardsOnTable, tiles, allTokens);
        MyPanel startPanel = new MyPanel(startGame);
        startPanel.setVisible(true);
    }

    @Test
    public void testMyPanelTokenCountsNone(){
        Game startGame = new Game(players, blueDeck, yellowDeck, greenDeck, cardsOnTable, tiles, noTokens);
        MyPanel startPanel = new MyPanel(startGame);
        assertEquals(0, startPanel.tokenCounts(onyxToken, noTokens));
    }

    @Test
    public void testMyPanelTokenCountsOnyx(){
        Game startGame = new Game(players, blueDeck, yellowDeck, greenDeck, cardsOnTable, tiles, allTokens);
        MyPanel startPanel = new MyPanel(startGame);
        assertEquals(7, startPanel.tokenCounts(onyxToken, allTokens));
    }

    @Test
    public void testMyPanelTokenCountsDiamond(){
        Game startGame = new Game(players, blueDeck, yellowDeck, greenDeck, cardsOnTable, tiles, allTokens);
        MyPanel startPanel = new MyPanel(startGame);
        assertEquals(7, startPanel.tokenCounts(diamondToken, allTokens));
    }

    @Test
    public void testMyPanelTokenCountsGold(){
        Game startGame = new Game(players, blueDeck, yellowDeck, greenDeck, cardsOnTable, tiles, allTokens);
        MyPanel startPanel = new MyPanel(startGame);
        assertEquals(7, startPanel.tokenCounts(goldToken, allTokens));
    }

    @Test
    public void testMyPanelTokenCountsSapphire(){
        Game startGame = new Game(players, blueDeck, yellowDeck, greenDeck, cardsOnTable, tiles, allTokens);
        MyPanel startPanel = new MyPanel(startGame);
        assertEquals(7, startPanel.tokenCounts(sapphireToken, allTokens));
    }

    @Test
    public void testMyPanelTokenCountsEmerald(){
        Game startGame = new Game(players, blueDeck, yellowDeck, greenDeck, cardsOnTable, tiles, allTokens);
        MyPanel startPanel = new MyPanel(startGame);
        assertEquals(7, startPanel.tokenCounts(emeraldToken, allTokens));
    }

    @Test
    public void testMyPanelTokenCountsRuby(){
        Game startGame = new Game(players, blueDeck, yellowDeck, greenDeck, cardsOnTable, tiles, allTokens);
        MyPanel startPanel = new MyPanel(startGame);
        assertEquals(7, startPanel.tokenCounts(rubyToken, allTokens));
    }

    @Test
    public void testMyPanelTokenCountsPurple(){
        Tokens invalidToken = new Tokens("purple");
        Game startGame = new Game(players, blueDeck, yellowDeck, greenDeck, cardsOnTable, tiles, allTokens);
        MyPanel startPanel = new MyPanel(startGame);
        assertEquals(0, startPanel.tokenCounts(invalidToken, allTokens));
    }

    @Test
    public void testMyPanelMousePressed(){
        Game startGame = new Game(players, blueDeck, yellowDeck, greenDeck, cardsOnTable, tiles, allTokens);
        MyPanel startPanel = new MyPanel(startGame);
        JButton buttonToSimulatePress = new JButton();
        MouseEvent pressEvent = new MouseEvent(buttonToSimulatePress, MouseEvent.MOUSE_PRESSED, 10, 100, 100, 1, 1, false, 1);
        startPanel.mousePressed(pressEvent);
    }

    @Test
    public void testMyPanelMouseReleased(){
        Game startGame = new Game(players, blueDeck, yellowDeck, greenDeck, cardsOnTable, tiles, allTokens);
        MyPanel startPanel = new MyPanel(startGame);
        JButton buttonToSimulateRelease = new JButton();
        MouseEvent releaseEvent = new MouseEvent(buttonToSimulateRelease, MouseEvent.MOUSE_RELEASED, 10, 100, 100, 100, 1, false, 1);
        startPanel.mousePressed(releaseEvent);
    }

    @Test
    public void testMyPanelMouseEntered(){
        Game startGame = new Game(players, blueDeck, yellowDeck, greenDeck, cardsOnTable, tiles, allTokens);
        MyPanel startPanel = new MyPanel(startGame);
        JButton buttonToSimulateRelease = new JButton();
        MouseEvent releaseEvent = new MouseEvent(buttonToSimulateRelease, MouseEvent.MOUSE_ENTERED, 10, 100, 100, 100, 1, false, 1);
        startPanel.mousePressed(releaseEvent);
    }

    @Test
    public void testMyPanelMouseExited(){
        Game startGame = new Game(players, blueDeck, yellowDeck, greenDeck, cardsOnTable, tiles, allTokens);
        MyPanel startPanel = new MyPanel(startGame);
        JButton buttonToSimulateRelease = new JButton();
        MouseEvent releaseEvent = new MouseEvent(buttonToSimulateRelease, MouseEvent.MOUSE_EXITED, 10, 100, 100, 100, 1, false, 1);
        startPanel.mousePressed(releaseEvent);
    }

    @Test
    public void testMyPanelMouseClicked(){
        Game startGame = new Game(players, blueDeck, yellowDeck, greenDeck, cardsOnTable, tiles, allTokens);
        MyPanel startPanel = new MyPanel(startGame);
        JButton buttonToSimulateClicking = new JButton();
        MouseEvent clickEvent = new MouseEvent(buttonToSimulateClicking, MouseEvent.MOUSE_CLICKED, 10, 100, 100, 100, 1, false, 1);
        startPanel.mouseClicked(clickEvent);
    }

    @Test
    public void testMyPanelMouseClickedTwice(){
        Game startGame = new Game(players, blueDeck, yellowDeck, greenDeck, cardsOnTable, tiles, allTokens);
        MyPanel startPanel = new MyPanel(startGame);
        JButton buttonToSimulateClicking = new JButton();
        MouseEvent clickEvent = new MouseEvent(buttonToSimulateClicking, MouseEvent.MOUSE_CLICKED, 10, 100, 100, 100, 2, false, 1);
        startPanel.mouseClicked(clickEvent);
    }

    @Test
    public void testMyPanelMouseClickedTwiceNotConsumed650650(){
        Game startGame = new Game(players, blueDeck, yellowDeck, greenDeck, cardsOnTable, tiles, allTokens);
        startGame.setCurrentPlayer(0);
        Player player1 = new Player(0, allTokens, noCards, noNobles, noReserves, "player1");
        startGame.updatePlayers(player1);
        MyPanel startPanel = new MyPanel(startGame);
        JButton buttonToSimulateClicking = new JButton();
        MouseEvent clickEvent = new MouseEvent(buttonToSimulateClicking, MouseEvent.MOUSE_CLICKED, 10, 100, 650, 650, 2, false, 1);
        startPanel.mouseClicked(clickEvent);
        assertEquals(allTokens.size(), player1.getTokens().size());
    }

    @Test
    public void testMyPanelMouseClicked3030(){
        Game startGame = new Game(players, blueDeck, yellowDeck, greenDeck, cardsOnTable, tiles, allTokens);
        startGame.setCurrentPlayer(0);
        Player player1 = new Player(0, allTokens, noCards, noNobles, noReserves, "player1");
        startGame.updatePlayers(player1);
        MyPanel startPanel = new MyPanel(startGame);
        JButton buttonToSimulateClicking = new JButton();
        MouseEvent clickEvent = new MouseEvent(buttonToSimulateClicking, MouseEvent.MOUSE_CLICKED, 10, 100, 30, 30, 2, false, 1);
        startPanel.mouseClicked(clickEvent);
        assertEquals(allTokens.size(), player1.getTokens().size());
    }

    @Test
    public void testMyPanelMouseClicked1580780(){
        Game startGame = new Game(players, blueDeck, yellowDeck, greenDeck, cardsOnTable, tiles, allTokens);
        startGame.setCurrentPlayer(0);
        Player player1 = new Player(0, allTokens, noCards, noNobles, noReserves, "player1");
        startGame.updatePlayers(player1);
        MyPanel startPanel = new MyPanel(startGame);
        JButton buttonToSimulateClicking = new JButton();
        MouseEvent clickEvent = new MouseEvent(buttonToSimulateClicking, MouseEvent.MOUSE_CLICKED, 10, 100, 1580, 780, 2, false, 1);
        startPanel.mouseClicked(clickEvent);
        assertEquals(allTokens.size(), player1.getTokens().size());
    }

    @Test
    public void testMyPanelAllDifferentTrue(){
        ArrayList<Tokens>t = new ArrayList<>();
        t.add(onyxToken);
        t.add(diamondToken);

        Game startGame = new Game(players, blueDeck, yellowDeck, greenDeck, cardsOnTable, tiles, allTokens);
        startGame.setCurrentPlayer(0);
        Player player1 = new Player(0, allTokens, noCards, noNobles, noReserves, "player1");
        startGame.updatePlayers(player1);
        MyPanel startPanel = new MyPanel(startGame);

        assertTrue(startPanel.allDifferent(t));
    }

    @Test
    public void testMyPanelAllDifferentEmpty(){
        ArrayList<Tokens>t = new ArrayList<>();

        Game startGame = new Game(players, blueDeck, yellowDeck, greenDeck, cardsOnTable, tiles, allTokens);
        startGame.setCurrentPlayer(0);
        Player player1 = new Player(0, allTokens, noCards, noNobles, noReserves, "player1");
        startGame.updatePlayers(player1);
        MyPanel startPanel = new MyPanel(startGame);

        assertTrue(startPanel.allDifferent(t));
    }

    @Test
    public void testMyPanelAllDifferentDuplicate(){
        ArrayList<Tokens>t = new ArrayList<>();
        t.add(onyxToken);
        t.add(onyxToken);

        Game startGame = new Game(players, blueDeck, yellowDeck, greenDeck, cardsOnTable, tiles, allTokens);
        startGame.setCurrentPlayer(0);
        Player player1 = new Player(0, allTokens, noCards, noNobles, noReserves, "player1");
        startGame.updatePlayers(player1);
        MyPanel startPanel = new MyPanel(startGame);

        assertFalse(startPanel.allDifferent(t));
    }

    @Test
    public void testMyPanelAllDifferentDuplicateMore(){
        ArrayList<Tokens>t = new ArrayList<>();
        t.add(onyxToken);
        t.add(onyxToken);
        t.add(diamondToken);

        Game startGame = new Game(players, blueDeck, yellowDeck, greenDeck, cardsOnTable, tiles, allTokens);
        startGame.setCurrentPlayer(0);
        Player player1 = new Player(0, allTokens, noCards, noNobles, noReserves, "player1");
        startGame.updatePlayers(player1);
        MyPanel startPanel = new MyPanel(startGame);

        assertFalse(startPanel.allDifferent(t));
    }




}