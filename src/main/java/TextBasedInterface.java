import java.io.File;

import static java.lang.System.*;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import Exceptions.*;
import Classes.*;

public class TextBasedInterface 
{
	public static void main(String[] args) throws FileNotFoundException, InterruptedException, NotEnoughTokensOnTable, InvalidCardsSelectionOfCardsOnTable, PlayerAlreadyHoldsThreeReserveCards, SelectedDeckRanOutOfCards, PlayerDoesNotHaveEnoughResourcesToBuySelectedCard, PlayerDoesNotHaveSelectedCardInReserve, InvalidCardsSelectionOfCardsInReserve
	{
		ArrayList<Cards> blueDeck = new ArrayList<Cards>();
		ArrayList<Cards> yellowDeck = new ArrayList<Cards>();
		ArrayList<Cards> greenDeck = new ArrayList<Cards>();
		
		Scanner cardsFile = new Scanner(new File("src/main/java/SplendorSet.txt"));
		Scanner sc = new Scanner(System.in);
		
		while(cardsFile.hasNextLine()){  //(int pt, ArrayList<Tokens> cost, String name, Tokens resource)
			addCards(cardsFile.nextLine().trim(), blueDeck, yellowDeck, greenDeck);
		}
		
		out.println("Welcome to Splendor! How many player(s) do you wish to have(including yourself)?");
		out.println("2. 2    3. 3.    4. 4");
		
		String t0 = sc.nextLine();
		int numP = 0;
		
		try{
			numP = Integer.parseInt(t0);
		}catch(NumberFormatException e){
			numP = 2;
		}
		
		ArrayList<Player> p = instantiatePlayers(numP);
		out.println("Check0 completed");
		ArrayList<Tokens> t = instantiateTokens(numP);
		out.println("Check1 completed");
		ArrayList<Noble> n = instantiateNobles(numP);
		out.println("Check2 completed");
		Cards[][] cot = instantiateCOT(blueDeck,yellowDeck, greenDeck);
		out.println("Check3 completed");
		
		Game g = new Game(p, blueDeck, yellowDeck, greenDeck, cot, n, t);
		out.println("check4 completed\nAwesome! lets start the game!\n\n");
		
		
		g.setPlayers(p);
		
		out.println(g);
		//out.println(p);
		
		int i = (int)(Math.random())*numP;
		int startingSpot = i;
		
		//*****TEST CASES GOES HERE*******\\
		
		
		boolean tf = false;
		boolean atf = false;
		
		do{
			out.println("It is " + g.getPlayers().get(i).getName() + "'s turn!");
			out.println(g.getPlayers().get(i).getName() + ", here is what you currently have:\n\n");
			out.println(g.getPlayers().get(i).toStringWithCardsInReserve());
			out.println(g.getPlayers().get(i).getName() + ", what do you wish to do this round?\n");
			out.println("1. Take 2 tokens of the same color from the table(may only be performed if there is 4 or more tokens in the color of your chosing)");
			out.println("2. Take 1 token from each of 3 different types of tokens(excluding gold)");
			out.println("3. Reserve a card on the table and receive one gold token(keep in mind you may only have three reserved cards maximum. Also, you will not recieve any gold token if there is non on the table)");
			out.println("4. Reserve an unknown card from the top of a chosen deck");
			out.println("5. Buy a card from your reserved cards");
			out.println("6. Buy a card on the table");
			
			String t00 = "";
			t00 = sc.nextLine();
			int choice = 1;
			
			try{
				choice = Integer.parseInt(t00);
			}catch(NumberFormatException e){
				out.println("Invalid choice made.");
				redoChoice(i, g);
			}
			
			
			
			String action = "";
			
			if(choice == 1){
				action1(i, g);
				out.println("\n\n\n\n");
				action = "Attention! Player " + (i+1) + " chose to take two tokens!";
			}else if(choice == 2){
				action2(i, g);
				out.println("\n\n\n\n");
				action = "Attention! Player " + (i+1) + " chose to take three tokens of different color!";
			}else if(choice == 3){
				action3(i, g);
				out.println("\n\n\n\n");
				action = "Attention! Player " + (i+1) + " chose to reserve a card on the table!";
			}else if(choice == 4){
				action4(i ,g);
				out.println("\n\n\n\n");
				action = "Attention! Player " + (i+1) + " chose to reserve a card from the deck!";
			}else if(choice == 5){
				action5(i, g);
				out.println("\n\n\n\n");
				action = "Attention! Player " + (i+1) + " chose to buy a card in his reserve!";
			}else if(choice == 6){
				action6(i, g);
				out.println("\n\n\n\n");
				action = "Attention! Player " + (i+1) + " chose to buy a card on the table!";
			}else if(choice == 3180){
				ArrayList<Cards> t000 = new ArrayList<Cards>();
				t000.add(new Cards("Onyx"));
				t000.add(new Cards("Onyx"));
				t000.add(new Cards("Onyx"));
				
				t000.add(new Cards("Sapphire"));
				t000.add(new Cards("Sapphire"));
				t000.add(new Cards("Sapphire"));
				
				t000.add(new Cards("Emerald"));
				t000.add(new Cards("Emerald"));
				t000.add(new Cards("Emerald"));
				
				t000.add(new Cards("Diamond"));
				t000.add(new Cards("Diamond"));
				t000.add(new Cards("Diamond"));
				
				t000.add(new Cards("Rubby"));
				t000.add(new Cards("Rubby"));
				t000.add(new Cards("Rubby"));
				
				g.getPlayers().get(i).setCards(t000);
				
			}
			
			if(nobleVisit(i, g)){
				action = "Player " + (i+1) + " also recieved a noble visit!";
			}
			
			out.println(g);
			
			out.println(action);
			
			
			
			
		tf = g.win();
		atf = g.getWinner().isEmpty();
		
		//out.println(g.getWinner());
		//out.println(i == startingSpot);
		/*for(int x=0; x<g.getPlayers().size(); x++){
			out.print(g.getPlayers().get(x).getScore() + "  ");
		}*/
		
		i++;
		
		if(i>numP-1){
			i = startingSpot;
		}
			
		}while(atf || i != startingSpot);
		
		
		
		
		Player actualWinner = g.getWinner().get(0);
		boolean tie = g.getWinner().size() > 1;
		
		for(int j=1; j<g.getWinner().size(); j++){
			if(g.getWinner().get(j).getCards().size() < actualWinner.getCards().size()){
				actualWinner = g.getWinner().get(j);
				tie = false;
			}
		}
		
		out.println("\n\n\n\n\n\n\n\n\n\n");
		
		if(!tie){
			out.println("Congratulation to " + actualWinner.getName() + "!\n You won the game!");
		}else{
			String p0 = "Congratulation to ";
			for(int y=0; y<g.getWinner().size(); y++){
				if(y == g.getWinner().size()-1){
					p0 = p0 + g.getWinner().get(y).getName();
				}else{
					p0 = p0 + g.getWinner().get(y).getName() + ", ";
				}
			}
			p0 = p0 + ", y'all had a tie!";
			out.println(p0);
		}
		
		//out.println(g.getWinner());
		
	}
	
	public static boolean nobleVisit(int i, Game g)
	{
		Scanner sc = new Scanner(System.in);
		
		if(g.getPlayers().get(i).nobleVisit(g).size() != 0){
			System.out.println("Congratulation to Player" + (i+1) + "! You are eligible for a noble visit! Which of the noble(s) below would you like?(They all give 3 points and does not consume your resources or tokens.)");
			
			for(int r=0; r<g.getPlayers().get(i).nobleVisit(g).size(); r++){
				System.out.println("Noble " + (r+1) + "\n" + g.getPlayers().get(i).nobleVisit(g).get(r) + "\n");
			}
			
			String t1 = sc.nextLine();
			int choice0 = 1;
			
			try{
				choice0 = Integer.parseInt(t1);
			}catch(NumberFormatException e){
				System.out.println("Invalid choice.");
				nobleVisit(i, g);
			}
			
			g.getPlayers().get(i).visit(choice0, g);
			
			return true;
			
		}else{
			return false;
		}
	}
	
	public static void action1(int i, Game g) throws InterruptedException  //checked. Works for now
	{
		
		out.println("Please choose the tokens you want to take.");
		out.println("1. Onyx x" + g.getPlayers().get(i).blackTokens() + " 2. Sapphire x" + g.getPlayers().get(i).blueTokens() + " 3. Emerald x" + g.getPlayers().get(i).greenTokens() + " 4. Diamond x" + g.getPlayers().get(i).whiteTokens() + " 5. Rubby x" + g.getPlayers().get(i).redTokens());
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		int c = 1;
		
		
		try{
			c = Integer.parseInt(s);
		}catch(NumberFormatException e){
			out.println("Invalid choice made.\n");
			Thread.sleep(1000);
			action1(i, g);
		}
		
		
		if(c == 1){
			Tokens t = new Tokens("Onyx");
			try{
				g.getPlayers().get(i).getTwoTokens(t, g);
			}catch(NotEnoughTokensOnTable e){
				out.println("Sorry. There is not enough tokens on the table. Please re-enter what you want.");
				action1(i, g);
			}
		}else if(c == 2){
			Tokens t = new Tokens("Sapphire");
			try{
				g.getPlayers().get(i).getTwoTokens(t, g);
			}catch(NotEnoughTokensOnTable e){
				out.println("Sorry. There is not enough tokens on the table. Please re-enter what you want.");
				action1(i, g);
			}
		}else if(c == 3){
			Tokens t = new Tokens("Emerald");
			try{
				g.getPlayers().get(i).getTwoTokens(t, g);
			}catch(NotEnoughTokensOnTable e){
				out.println("Sorry. There is not enough tokens on the table. Please re-enter what you want.");
				action1(i, g);
			}
		}else if(c == 4){
			Tokens t = new Tokens("Diamond");
			try{
				g.getPlayers().get(i).getTwoTokens(t, g);
			}catch(NotEnoughTokensOnTable e){
				out.println("Sorry. There is not enough tokens on the table. Please re-enter what you want.");
				action1(i, g);
			}
		}else{
			Tokens t = new Tokens("Rubby");
			try{
				g.getPlayers().get(i).getTwoTokens(t, g);
			}catch(NotEnoughTokensOnTable e){
				out.println("Sorry. There is not enough tokens on the table. Please re-enter what you want.");
				action1(i, g);
			}
		}
		
		
		if(g.getPlayers().get(i).getTokens().size() >= 10){
			out.println("Your token counts have exceeded please discard until you only have 10.");
			out.println("Please discard tokens until you have only 10 tokens left.");
			discard(g.getPlayers().get(i), g);
		}
		
	}
	
	public static void discard(Player p, Game g)  //checked. Works for now
	{
		
		out.println("Choose a token to discard.");
		out.println("1. Onyx x" + p.blackTokens() + " 2. Sapphire x" + p.blueTokens() + " 3. Emerald x" + p.greenTokens() + " 4. Diamond x" + p.whiteTokens() + " 5. Rubby x" + p.redTokens() + " 6. Gold x" + p.yellowTokens());
		
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		int c = 1;
		
		try{
			c = Integer.parseInt(s);
		}catch(NumberFormatException e){
			out.println("Invalid choice made.\n");
			discard(p, g);
		}
		
		if(c == 1){
			try{
				p.discardToken(new Tokens("Onyx"), g);
				out.println(true);
			}catch(InvalidTokensSelection e){
				out.println("Invalid choice made. You do not have any Onyx.");
				discard(p, g);
			}
		}else if(c == 2){
			try{
				p.discardToken(new Tokens("Sapphire"), g);
			}catch(InvalidTokensSelection e){
				out.println("Invalid choice made. You do not have any Sapphire.");
				discard(p, g);
			}
		}else if(c == 3){
			try{
				p.discardToken(new Tokens("Emerald"), g);
			}catch(InvalidTokensSelection e){
				out.println("Invalid choice made. You do not have any Emerald.");
				discard(p, g);
			}
		}else if(c == 4){
			try{
				p.discardToken(new Tokens("Diamond"), g);
			}catch(InvalidTokensSelection e){
				out.println("Invalid choice made. You do not have any Diamond.");
				discard(p, g);
			}
		}else if(c == 5){
			try{
				p.discardToken(new Tokens("Rubby"), g);
			}catch(InvalidTokensSelection e){
				out.println("Invalid choice made. You do not have any Rubby.");
				discard(p, g);
			}
		}else{
			try{
				p.discardToken(new Tokens("Gold"), g);
			}catch(InvalidTokensSelection e){
				out.println("Invalid choice made. You do not have any Gold.");
				discard(p, g);
			}
		}
		
		
		if(p.getTokens().size() > 10){
			discard(p, g);
		}
		
		
	}
	
	public static void action2(int p, Game g) throws NotEnoughTokensOnTable
	{
		Scanner sc = new Scanner(System.in);
		int choice1 = 1;
		int choice2 = 2;
		int choice3 = 3;
		
		out.println("Choose a token to take.");
		out.println("1. Onyx x" + g.blackTokens() + " 2. Sapphire x" + g.blueTokens() + " 3. Emerald x" + g.greenTokens() + " 4. Diamond x" + g.whiteTokens() + " 5. Rubby x" + g.redTokens());
		String s = sc.nextLine();
		try{
			choice1 = Integer.parseInt(s);
		}catch(NumberFormatException e){
			choice1 = 1;
		}
		Tokens t1 = returnTokens(choice1);
		
		out.println("Choose a different token that you have not selected.");
		out.println("1. Onyx x" + g.blackTokens() + " 2. Sapphire x" + g.blueTokens() + " 3. Emerald x" + g.greenTokens() + " 4. Diamond x" + g.whiteTokens() + " 5. Rubby x" + g.redTokens());
		s = sc.nextLine();
		try{
			choice2 = Integer.parseInt(s);
		}catch(NumberFormatException e){
			choice2 = 2;
		}
		Tokens t2 = returnTokens(choice2);
		if(choice2 == choice1){
			out.println("Invalid choice. You have chosen this token already.");
			action2(p, g);
		}
		
		out.println("Choose another different token that you have not selected.");
		out.println("1. Onyx x" + g.blackTokens() + " 2. Sapphire x" + g.blueTokens() + " 3. Emerald x" + g.greenTokens() + " 4. Diamond" + g.whiteTokens() + " 5. Rubby x" + g.redTokens() + " 6. Gold x" + g.yellowTokens());
		s = sc.nextLine();
		try{
			choice3 = Integer.parseInt(s);
		}catch(NumberFormatException e){
			choice3 = 3;
		}
		Tokens t3 = returnTokens(choice3);
		if(choice2 == choice1 || choice2 == choice3){
			out.println("Invalid choice. You have chosen this token already.");
			action2(p, g);
		}
		
		
		try{
			g.getPlayers().get(p).getOneOfEachTokens(t1, t2, t3, g);
		}catch(NotEnoughTokensOnTable e){
			out.println("Invalid choice. There is not enough token of your choosing on the table");
			action2(p, g);
		}
	
	}
	
	public static void action3(int p, Game g) throws InvalidCardsSelectionOfCardsOnTable   //roll 1:blue deck; roll 2: yellow deck; roll 3: green deck;
, PlayerAlreadyHoldsThreeReserveCards, InterruptedException, NotEnoughTokensOnTable, SelectedDeckRanOutOfCards, PlayerDoesNotHaveEnoughResourcesToBuySelectedCard, PlayerDoesNotHaveSelectedCardInReserve, InvalidCardsSelectionOfCardsInReserve
	{
		Scanner sc = new Scanner(System.in);
		String t = "";
		int choiceColor = 1;
		int choiceCardNum = 1;
		
		out.println("Which type of card do you wish to reserve?");
		out.println("1. Blue   2. Yellow   3. Green");
		t = sc.nextLine();
		
		try{
			choiceColor = Integer.parseInt(t);
		}catch(NumberFormatException e){
			out.println("Invalid choice made.");
			action3(p, g);
		}
		
		out.println("Which card do you wish to reserve?");
		if(choiceColor == 1){
			out.println("1. Blue Card 1 *** 2. Blue Card 2 *** 3. Blue Card 3");
			t = sc.nextLine();
			
			try{
				choiceCardNum = Integer.parseInt(t);
			}catch(NumberFormatException e){
				out.println("Invalid choice made.");
				action3(p, g);
			}
		}else if(choiceColor == 2){
			out.println("1. Yellow Card 1 *** 2. Yellow Card 2 *** 3. Yellow Card 3");
			t = sc.nextLine();
			
			try{
				choiceCardNum = Integer.parseInt(t);
			}catch(NumberFormatException e){
				out.println("Invalid choice made.");
				action3(p, g);
			}
		}if(choiceColor == 3){
			out.println("1. Green Card 1 *** 2. Green Card 2 *** 3. Green Card");
			t = sc.nextLine();
			
			try{
				choiceCardNum = Integer.parseInt(t);
			}catch(NumberFormatException e){
				out.println("Invalid choice made.");
				action3(p, g);
			}
		}
		
		try{	
			g.getPlayers().get(p).reserveCard(choiceColor, choiceCardNum, g);
		}catch(InvalidCardsSelectionOfCardsOnTable e){
			out.println("Sorry. That is a invalid position.");
			redoChoice(p, g);
		}catch(PlayerAlreadyHoldsThreeReserveCards e){
			out.println("Sorry; you already have three cards in reserve");
			redoChoice(p, g);
		}
		
	}
	
	public static void action4(int p, Game g) throws SelectedDeckRanOutOfCards  //Reserve random card from the chosen deck  //roll 1:blue deck; roll 2: yellow deck; roll 3: green deck;
	{
		Scanner sc = new Scanner(System.in);
		
		out.println("Which deck do you wish to reserve card from?");
		out.println("1. Blue Deck   2. Yellow Deck   3. Green Deck");
		
		String t = sc.nextLine();
		int choice = 1;
		
		try{
			choice = Integer.parseInt(t);
		}catch(NumberFormatException e){
			out.println("Invalid choice made.");
			action4(p, g);
		}
		
		if(choice == 1){
			try{
				g.getPlayers().get(p).reserveCard("blue", g);
			}catch(SelectedDeckRanOutOfCards e){
				out.println("The deck you chose ran out of cards. Please choose another one.");
				action4(p, g);
			}
		}else if(choice == 2){
			try{
				g.getPlayers().get(p).reserveCard("yellow", g);
			}catch(SelectedDeckRanOutOfCards e){
				out.println("The deck you chose ran out of cards. Please choose another one.");
				action4(p, g);
			}
		}else if(choice == 3){
			try{
				g.getPlayers().get(p).reserveCard("green", g);
			}catch(SelectedDeckRanOutOfCards e){
				out.println("The deck you chose ran out of cards. Please choose another one.");
				action4(p, g);
			}
		}
	}
	
	public static void action5(int p, Game g) throws PlayerDoesNotHaveEnoughResourcesToBuySelectedCard, PlayerDoesNotHaveSelectedCardInReserve //buy a card from your reserved cards
, InterruptedException, NotEnoughTokensOnTable, InvalidCardsSelectionOfCardsOnTable, PlayerAlreadyHoldsThreeReserveCards, SelectedDeckRanOutOfCards, InvalidCardsSelectionOfCardsInReserve
	{
		Scanner sc = new Scanner(System.in);
		
		if(g.getPlayers().get(p).getReserve().size() == 0){
			out.println("You do not have any cards in reserve. Please choose another option");
			redoChoice(p, g);
			return;
		}
		
		String r = "";
		out.println("Which card do you wish to buy?");
		
		r = r + "**** Cards in Reserve **** \n\n";
		
		for(int i = 1; i<=g.getPlayers().get(p).getReserve().size(); i++){
			r = r + "Card " + i + ": \n" + g.getPlayers().get(p).getReserve().get(i-1) + "\n";
		}
		
		out.println(r);
		
		String t = sc.nextLine();
		int choice = 1;
		
		try{
			choice = Integer.parseInt(t);
		}catch(NumberFormatException e){
			out.println("Invalid choice made.");
			action5(p, g);
		}
		
		if(choice == 1){
			try{
				g.getPlayers().get(p).placeCardFromReserve(g.getPlayers().get(p).getReserve().get(0), g);
			}catch(PlayerDoesNotHaveEnoughResourcesToBuySelectedCard e){
				out.println("Sorry. You do not have enough resources to buy the selected card");
				redoChoice(p, g);
			}
		}else if(choice == 2){
			try{
				g.getPlayers().get(p).placeCardFromReserve(g.getPlayers().get(p).getReserve().get(1), g);
			}catch(PlayerDoesNotHaveEnoughResourcesToBuySelectedCard e){
				out.println("Sorry. You do not have enough resources to buy the selected card");
				redoChoice(p, g);
			}
		}else if(choice == 3){
			try{
				g.getPlayers().get(p).placeCardFromReserve(g.getPlayers().get(p).getReserve().get(2), g);
			}catch(PlayerDoesNotHaveEnoughResourcesToBuySelectedCard e){
				out.println("Sorry. You do not have enough resources to buy the selected card");
				redoChoice(p, g);
			}
		}
		
	}
	
	public static void action6(int p, Game g) throws PlayerDoesNotHaveEnoughResourcesToBuySelectedCard, InvalidCardsSelectionOfCardsInReserve //buy a card on the table
, InterruptedException, NotEnoughTokensOnTable, InvalidCardsSelectionOfCardsOnTable, PlayerAlreadyHoldsThreeReserveCards, SelectedDeckRanOutOfCards, PlayerDoesNotHaveSelectedCardInReserve
	{
		Scanner sc = new Scanner(System.in);
		String t = "";
		int choiceColor = 1;
		int choiceCardNum = 1;
		
		out.println("Which type of card do you wish to reserve?");
		out.println("1. Blue   2. Yellow   3. Green");
		t = sc.nextLine();
		
		try{
			choiceColor = Integer.parseInt(t);
		}catch(NumberFormatException e){
			out.println("Invalid choice made.");
			action6(p, g);
		}
		
		out.println("Which card do you wish to reserve?");
		if(choiceColor == 1){
			out.println("1. Blue Card 1 *** 2. Blue Card 2 *** 3. Blue Card 3 *** 4. Blue Card 4");
			t = sc.nextLine();
			
			try{
				choiceCardNum = Integer.parseInt(t);
			}catch(NumberFormatException e){
				out.println("Invalid choice made.");
				action6(p, g);
			}
		}else if(choiceColor == 2){
			out.println("1. Yellow Card 1 *** 2. Yellow Card 2 *** 3. Yellow Card 3 *** 4. Yellow Card 4");
			t = sc.nextLine();
			
			try{
				choiceCardNum = Integer.parseInt(t);
			}catch(NumberFormatException e){
				out.println("Invalid choice made.");
				action6(p, g);
			}
		}if(choiceColor == 3){
			out.println("1. Green Card 1 *** 2. Green Card 2 *** 3. Green Card *** 4. Green Card 4");
			t = sc.nextLine();
			
			try{
				choiceCardNum = Integer.parseInt(t);
			}catch(NumberFormatException e){
				out.println("Invalid choice made.");
				action6(p, g);
			}
		}
		
		try{	
			g.getPlayers().get(p).buyCardOnTable(choiceColor, choiceCardNum, g);
		}catch(InvalidCardsSelectionOfCardsOnTable e){
			out.println("Sorry. That is a invalid position.");
			action6(p, g);
			return;
		}catch(PlayerDoesNotHaveEnoughResourcesToBuySelectedCard e){
			out.println("Sorry; you do not have enough resources to buy this card.");
			redoChoice(p ,g);
			return;
		}
		
		
		
	}
	
	public static Tokens returnTokens(int n)
	{
		if(n == 1){
			return new Tokens("Onyx");
		}else if(n == 2){
			return new Tokens("Sapphire");
		}else if(n == 3){
			return new Tokens("Emerald");
		}else if(n == 4){
			return new Tokens("Diamond");
		}else{
			return new Tokens("Rubby");
		}
	}

	public static void redoChoice(int i, Game g) throws InterruptedException, NotEnoughTokensOnTable, InvalidCardsSelectionOfCardsOnTable, PlayerAlreadyHoldsThreeReserveCards, SelectedDeckRanOutOfCards, PlayerDoesNotHaveEnoughResourcesToBuySelectedCard, PlayerDoesNotHaveSelectedCardInReserve, InvalidCardsSelectionOfCardsInReserve
	{
		out.println("1. Take 2 tokens of the same color from the table(may only be performed if there is 4 or more tokens in the color of your chosing)");
		out.println("2. Take 1 token from each of 3 different types of tokens(excluding gold)");
		out.println("3. Reserve a card on the table and receive one gold token(keep in mind you may only have three reserved cards maximum. Also, you will not recieve any gold token if there is non on the table)");
		out.println("4. Reserve an unknown card from the top of a chosen deck");
		out.println("5. Buy a card from your reserved cards");
		out.println("6. Buy a card on the table");
		
		Scanner sc = new Scanner(System.in);
		String t = sc.nextLine();
		int choice = 1;
		
		try{
			choice = Integer.parseInt(t);
		}catch(NumberFormatException e){
			out.println("Invalid choice made.");
			redoChoice(i, g);
		}
		
		String action = "";
		
		if(choice == 1){
			action1(i, g);
			out.println("\n\n\n\n");
			action = "Attention! Player " + (i+1) + " chose to take two tokens!";
		}else if(choice == 2){
			action2(i, g);
			out.println("\n\n\n\n");
			action = "Attention! Player " + (i+1) + " chose to take three tokens of different color!";
		}else if(choice == 3){
			action3(i, g);
			out.println("\n\n\n\n");
			action = "Attention! Player " + (i+1) + " chose to reserve a card on the table!";
		}else if(choice == 4){
			action4(i ,g);
			out.println("\n\n\n\n");
			action = "Attention! Player " + (i+1) + " chose to reserve a card from the deck!";
		}else if(choice == 5){
			action5(i, g);
			out.println("\n\n\n\n");
			action = "Attention! Player " + (i+1) + " chose to buy a card in his reserve!";
		}else if(choice == 6){
			action6(i, g);
			out.println("\n\n\n\n");
			action = "Attention! Player " + i + " chose to buy a card on the table!";
		}
		
		out.println(action);
	}
	
	public static Cards[][] instantiateCOT(ArrayList<Cards> blueDeck, ArrayList<Cards> yellowDeck, ArrayList<Cards> greenDeck)
	{
		Cards[][] cot = new Cards[3][4]; //roll 1:blue deck; roll 2: yellow deck; roll 3: green deck;
		for(int i=0; i<3; i++){
			for(int j=0; j<4; j++){
				if(i == 0){
					int r = (int)(Math.random()*blueDeck.size());
					cot[i][j] = blueDeck.get(r);
				}else if(i==1){
					int r = (int)(Math.random()*yellowDeck.size());
					cot[i][j] = yellowDeck.get(r);
				}else{
					int r = (int)(Math.random()*blueDeck.size());
					cot[i][j] = greenDeck.get(r);
				}
			}
		}
		
		return cot;
		
	}
	
	public static ArrayList<Tokens> instantiateTokens(int numP)
	{
		ArrayList<Tokens> t = new ArrayList<Tokens>();
		if(numP == 4){
			for(int i=1; i<=7; i++){
				t.add(new Tokens("Rubby"));
				t.add(new Tokens("Sapphire"));
				t.add(new Tokens("Onyx"));
				t.add(new Tokens("Emerald"));
				t.add(new Tokens("Diamond"));
				if(i<5){
					t.add(new Tokens("Gold"));
				}
				//out.println(t);
			}
		}else if(numP == 3){
			for(int i=1; i<=5; i++){
				t.add(new Tokens("Rubby"));
				t.add(new Tokens("Sapphire"));
				t.add(new Tokens("Onyx"));
				t.add(new Tokens("Emerald"));
				t.add(new Tokens("Diamond"));
				if(i<5){
					t.add(new Tokens("Gold"));
				}
				}
		}else{
			for(int i=1; i<=4; i++){
				t.add(new Tokens("Rubby"));
				t.add(new Tokens("Sapphire"));
				t.add(new Tokens("Onyx"));
				t.add(new Tokens("Emerald"));
				t.add(new Tokens("Diamond"));
				if(i<5){
					t.add(new Tokens("Gold"));
				}
			}
		}
		
		return t;
	
	
	}
	
	public static ArrayList<Noble> instantiateNobles(int numP) throws FileNotFoundException
	{
		ArrayList<Noble> r = new ArrayList<Noble>();
		Scanner sc = new Scanner(new File("Nobles.txt"));
		while(sc.hasNextLine()){
			String[] info = sc.nextLine().split(" ");
			String name = "";
			ArrayList<Tokens> cost = new ArrayList<Tokens>();
			int i = 0;
			while(i<info.length && info[i].charAt(0) >= 65){
				name = name + info[i] + " ";
				i++;
			}
			
			for(int j=i; j<info.length; j++){
				String t = info[j];
				String c = t.substring(1);
				//out.println(j + " " + info.length);
				int num = Integer.parseInt(t.charAt(0)+"");
				//out.println(c);
				//for(int k=0; k<num; k++){
					if(c.equalsIgnoreCase("R")){
						addTokens(cost, num, new Tokens("Rubby"));
						//out.println(num);
					}else if(c.equalsIgnoreCase("G")){
						addTokens(cost, num, new Tokens("Emerald"));
					}else if(c.equalsIgnoreCase("BLU")){
						addTokens(cost, num, new Tokens("Sapphire"));
					}else if(c.equalsIgnoreCase("BLA")){
						addTokens(cost, num, new Tokens("Onyx"));
					}else if(c.equalsIgnoreCase("W")){
						addTokens(cost, num, new Tokens("Diamond"));
					}
				//}
			}
			
			Noble noble = new Noble(name, cost);
			//out.println(noble);
			//out.println(cost);
			r.add(noble);
			
			
		}
		
		int n = 0;
		
		if(numP == 4){
			for(int i=0; i<5; i++){
				r.remove((int)(Math.random()*(10-n)));
				n++;
			}
		}else if(numP == 3){
			for(int i=0; i<6; i++){
				r.remove((int)(Math.random()*(10-n)));
				n++;
			}
		}else{
			for(int i=0; i<7; i++){
				r.remove((int)(Math.random()*(10-n)));
				n++;
			}
		}
		
		return r;
	}
	
	public static void addCards(String temp, ArrayList<Cards> bd, ArrayList<Cards> yd, ArrayList<Cards> gd)
	{
		String[] info = temp.split(" ");
		
		String deck = info[0];
		String name = instantiateName(info[1]);
		Tokens resource = instantiateResource(info[2]);
		int pt = Integer.parseInt(info[3]);
		ArrayList<Tokens> cost = new ArrayList<Tokens>();
		
		for(int i=4; i<info.length; i++){
			String t = info[i];
			//out.println(t);
			String c = info[i].substring(1);
			int num = Integer.parseInt(t.charAt(0)+"");
			//out.println(num);
			//for(int j=0; j<num; j++){
				if(c.equalsIgnoreCase("R")){
					addTokens(cost, num, new Tokens("Rubby"));
					//out.println(j);
				}else if(c.equalsIgnoreCase("G")){
					addTokens(cost, num, new Tokens("Emerald"));
				}else if(c.equalsIgnoreCase("BLU")){
					addTokens(cost, num, new Tokens("Sapphire"));
				}else if(c.equalsIgnoreCase("BLA")){
					addTokens(cost, num, new Tokens("Onyx"));
				}else if(c.equalsIgnoreCase("W")){
					addTokens(cost, num, new Tokens("Diamond"));
				}
			//}
		}
		
		//out.println(cost);
		
		Cards c = new Cards(pt, cost, name, resource);
		
		if(deck.equalsIgnoreCase("B")){
			bd.add(c);
		}else if(deck.equals("Y")){
			yd.add(c);
		}else{
			gd.add(c);
		}
	}
	
	public static ArrayList<Player> instantiatePlayers(int num) //(int score, ArrayList<Tokens> tokens, ArrayList<Cards> cards, ArrayList<Noble> nobles, ArrayList<Cards> reserve, String name)
	{
		ArrayList<Player> p = new ArrayList<Player>();
		for(int i=0; i<num; i++){
			ArrayList<Tokens> t = new ArrayList<Tokens>();
			ArrayList<Cards> c = new ArrayList<Cards>();
			ArrayList<Noble> nobles = new ArrayList<Noble>();
			ArrayList<Cards> r = new ArrayList<Cards>();
			
			
			p.add(new Player(0, t, c, nobles, r, "Player " + (i + 1)));
		}
		
		return p;
	}
	
	public static void addTokens(ArrayList<Tokens> r, int num, Tokens t)
	{
		for(int i=0; i<num; i++){
			r.add(t);
		}
	}
	
	public static Tokens instantiateResource(String c)
	{
		if(c.equalsIgnoreCase("R")){
			return new Tokens("Rubby");
		}else if(c.equalsIgnoreCase("E")){
			return new Tokens("Emerald");
		}else if(c.equalsIgnoreCase("S")){
			return new Tokens("Sapphire");
		}else if(c.equalsIgnoreCase("O")){
			return new Tokens("Onyx");
		}else if(c.equalsIgnoreCase("D")){
			return new Tokens("Diamond");
		}else{
			return null;
		}
	}
	
	public static String instantiateName(String n)
	{
		if(n.equalsIgnoreCase("M")){
			return "Mine";
		}else if(n.equalsIgnoreCase("ME")){
			return "Merchant";
		}else if(n.equalsIgnoreCase("T")){
			return "Transports";
		}else if(n.equalsIgnoreCase("S")){
			return "Shops";
		}else{
			return "Town";
		}
	}

}
