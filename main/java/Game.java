import java.util.ArrayList;
import static java.lang.System.*;
import java.util.Arrays;

public class Game 
{
	private static final Exception InvalidActionException = null;
	private ArrayList<Player> players;
	private ArrayList<Cards> blueDeck;
	private ArrayList<Cards> yellowDeck;
	private ArrayList<Cards> greenDeck;
	private Cards[][] cardsOnTable; //roll 1:blue deck; roll 2: yellow deck; roll 3: green deck;
	private ArrayList<Noble> tiles;
	private ArrayList<Tokens> tokens;
	private ArrayList<Player> winner;
	private int StartingPlayer;
	private int CurrentPlayer;
	
	
	public Game(ArrayList<Player> players, ArrayList<Cards> blueDeck,
			ArrayList<Cards> yellowDeck, ArrayList<Cards> greenDeck,
			Cards[][] cardsOnTable, ArrayList<Noble> tiles,
			ArrayList<Tokens> tokens) {
		super();
		this.players = players;
		this.blueDeck = blueDeck;
		this.yellowDeck = yellowDeck;
		this.greenDeck = greenDeck;
		this.cardsOnTable = cardsOnTable;
		this.tiles = tiles;
		this.tokens = tokens;
		winner = new ArrayList<Player>();
		StartingPlayer = (int)(Math.random()*players.size());
		CurrentPlayer = StartingPlayer;
	}
	
	public Game() {
		super();
	}
	
	public Game(ArrayList<Player> winner, int currentPlayer, int startingPlayer)
	{
		this.winner = winner;
		this.CurrentPlayer = currentPlayer;
		this.StartingPlayer = startingPlayer;
	}

	public int getStartingPlayer() {
		return StartingPlayer;
	}



	public void setStartingPlayer(int startingPlayer) {
		StartingPlayer = startingPlayer;
	}


	public int getPreviousPlayer()
	{
		return CurrentPlayer - 1;
	}

	public int getCurrentPlayer() {
		return CurrentPlayer;
	}



	public void setCurrentPlayer(int currentPlayer) {
		CurrentPlayer = currentPlayer;
	}



	public ArrayList<Player> getWinner() {
		return winner;
	}


	public void setWinner(ArrayList<Player> winner) {
		this.winner = winner;
	}


	public ArrayList<Player> getPlayers() {
		return players;
	}


	public void setPlayers(ArrayList<Player> players) {
		this.players = players;
	}


	public ArrayList<Cards> getBlueDeck() {
		return blueDeck;
	}


	public void setBlueDeck(ArrayList<Cards> blueDeck) {
		this.blueDeck = blueDeck;
	}


	public ArrayList<Cards> getYellowDeck() {
		return yellowDeck;
	}


	public void setYellowDeck(ArrayList<Cards> yellowDeck) {
		this.yellowDeck = yellowDeck;
	}


	public ArrayList<Cards> getGreenDeck() {
		return greenDeck;
	}


	public void setGreenDeck(ArrayList<Cards> greenDeck) {
		this.greenDeck = greenDeck;
	}


	public Cards[][] getCardsOnTable() {
		return cardsOnTable;
	}


	public void setCardsOnTable(Cards[][] cardsOnTable) {
		this.cardsOnTable = cardsOnTable;
	}


	public ArrayList<Noble> getTiles() {
		return tiles;
	}


	public void setTiles(ArrayList<Noble> tiles) {
		this.tiles = tiles;
	}


	public ArrayList<Tokens> getTokens() {
		return tokens;
	}


	public void setTokens(ArrayList<Tokens> tokens) {
		this.tokens = tokens;
	}
	
	public ArrayList<Cards> getDeck(String desiredDeck)
	{
		if(desiredDeck.contains("blue")){
			return blueDeck;
		}else if(desiredDeck.contains("green")){
			return greenDeck;
		}else{
			return yellowDeck;
		}
	}
	
	public int whiteTokens()
	{
		int r = 0;
		for(int i=0; i<tokens.size(); i++){
			if(tokens.get(i).toString().equalsIgnoreCase("Diamond"))
				r++;
		}
		
		//out.println(r);
		
		return r;
	}
	
	public int greenTokens()
	{
		int r = 0;
		for(int i=0; i<tokens.size(); i++){
			if(tokens.get(i).toString().equalsIgnoreCase("Emerald"))
				r++;
		}
		
		//out.println(r);
		
		return r;
	}
	
	public int blueTokens()
	{
		int r = 0;
		for(int i=0; i<tokens.size(); i++){
			if(tokens.get(i).toString().equalsIgnoreCase("Sapphire"))
				r++;
		}
		
		//out.println(r);
		
		return r;
	}
	
	public int blackTokens()
	{
		int r = 0;
		for(int i=0; i<tokens.size(); i++){
			if(tokens.get(i).toString().equalsIgnoreCase("Onyx"))
				r++;
		}
		
		//out.println(r);
		
		return r;
	}
	
	public int redTokens()
	{
		int r = 0;
		for(int i=0; i<tokens.size(); i++){
			if(tokens.get(i).toString().equalsIgnoreCase("Rubby"))
				r++;
		}
		
		//out.println(r);
		
		return r;
	}
	
	public int yellowTokens()
	{
		int r = 0;
		for(int i=0; i<tokens.size(); i++){
			if(tokens.get(i).toString().equalsIgnoreCase("Gold"))
				r++;
		}
		
		//out.println(r);
		
		return r;
	}
	
	public Cards getRandom(String desiredDeck)   //enter blue, yellow, or green. NOTHING ELSE REMEMBER
	{
		if(desiredDeck.equalsIgnoreCase("blue")){
			int r = (int)(Math.random()*blueDeck.size());
			return blueDeck.get(r);
		}else if(desiredDeck.equalsIgnoreCase("green")){
			int r = (int)(Math.random()*greenDeck.size());
			return greenDeck.get(r);
		}else{
			int r = (int)(Math.random()*yellowDeck.size());
			return yellowDeck.get(r);
		}
	}
	
	public void updatePlayers(Player p)
	{
		for(int i = 0; i<players.size(); i++){
			if(players.get(i).getName() == p.getName()){
				players.set(i, p);
			}
		}
	}
	
	public boolean differentColors(ArrayList<Tokens> t)
	{
		boolean r = true;
		
		for(int i=0; i<t.size()-1; i++){
			if(t.get(i).equals(t.get(i+1))){
				r = false;
			}
		}
		
		return r;
	}
	
	public ArrayList<Noble> containNoble()
	{
		ArrayList<Noble> r = new ArrayList<Noble>();
		
		for(int i=0; i<players.size(); i++){
			if(!players.get(i).getNobles().isEmpty()){
				r.addAll(players.get(i).getNobles());
			}
		}
		
		return r;
	}
	
	public int numOf(Tokens token)
	{
		int r = 0;
		for(int i=0; i<tokens.size(); i++){
			if(tokens.get(i).getColor() == token.getColor())
				r++;
		}
		
		return r;
	}
	
	



	public boolean win()
	{
		boolean t = false;
		
		for(int i = 0; i<players.size(); i++){
			if(players.get(i).getScore() >= 15 && !winner.contains(players.get(i))){
				winner.add(players.get(i));
			}
				//System.out.println(winner);
				t = true;
		}
		
		return t;
		
	}
	
	public boolean checkDiscard(Player p, Tokens t1) throws InvalidTokensSelection
	{
		boolean tf = false;
		for(int i=0; i<p.getTokens().size(); i++){
			if(p.getTokens().get(i).getColor().equals(t1.getColor())){
				tf = true;
			}
		}
		
		if(tf){
			return true;
		}else{
			throw new InvalidTokensSelection();
		}
		
		
			
	}
	
	public boolean checkActionOne(Player p, Tokens target) throws NotEnoughTokensOnTable //Action 1 = take two tokens
	{
		if(numOf(target) >= 4){
			return true;
		}else{
			throw new NotEnoughTokensOnTable();
		}
	}
	
	public boolean checkActionTwo(Player p, Tokens t1, Tokens t2, Tokens t3) throws NotEnoughTokensOnTable  //Action 2 = take 1 tokens of 3 colors
	{
		ArrayList<Tokens> r = new ArrayList<Tokens>();
		r.add(t1);
		r.add(t2);
		r.add(t3);
		
		ArrayList<Tokens> rt = new ArrayList<Tokens>(tokens);
		
		boolean tf = true;
		
		/*
		for(int i=0; i<p.getTokens().size(); i++){
			if(!tokens.get(i).getColor().equals(t1.getColor()) || !tokens.get(i).getColor().equals(t2.getColor()) || !tokens.get(i).getColor().equals(t3.getColor())){
				tf = false;
			}
		}*/
		
		
		
		if(tf){
			return true;
		}else{
			throw new NotEnoughTokensOnTable();
		}
	}
	
	public boolean checkActionThree(Player p, int rol, int col) throws InvalidCardsSelectionOfCardsOnTable  //Action 3 = take a reserve card and a wild card token(yellow)
, PlayerAlreadyHoldsThreeReserveCards
	{
		if(rol-1 <= 3 && col-1 <= 3 && rol-1 >= 0 && col-1 >= 0){
			if(p.getReserve().size() < 3){
				return true;
			}else{
				throw new PlayerAlreadyHoldsThreeReserveCards();
			}
		}else{
			throw new InvalidCardsSelectionOfCardsOnTable();
		}
	}
	
	public boolean checkActionThree(Player p, String d) throws SelectedDeckRanOutOfCards  //this will handle when player wish to draw a card from the deck and reserve it
	{
		if(d.contains("blue") || d.contains("green") || d.contains("yellow")){
			if(p.getReserve().size() <= 3){
				if(d.contains("blue") && !blueDeck.isEmpty()){
					return true;
				}else if(d.contains("green") && !greenDeck.isEmpty()){
					return true;
				}else if(d.contains("yellow") && !yellowDeck.isEmpty()){
					return true;
				}
			}
		}
		
		throw new SelectedDeckRanOutOfCards();
	}
	
	public boolean checkActionFour(Player p, Cards desired) throws PlayerDoesNotHaveEnoughResourcesToBuySelectedCard  //Action 4 = place(buy) a card from your reserve cards
, PlayerDoesNotHaveSelectedCardInReserve
	{
		if(p.getReserve().contains(desired)){
			if(p.canBuy(desired)){
				System.out.println("WOW");
				return true;
			}else if(p.canBuyWithYellow(desired)){
				System.out.println("RAPE");
				return true;
			}else{
				throw new PlayerDoesNotHaveEnoughResourcesToBuySelectedCard();
			}
		}else{
			throw new PlayerDoesNotHaveSelectedCardInReserve();
		}
	}
	
	public boolean checkActionFive(Player p, int rol, int col) throws PlayerDoesNotHaveEnoughResourcesToBuySelectedCard  //Action 5 = directly purchase a card on the table
, InvalidCardsSelectionOfCardsInReserve, InvalidCardsSelectionOfCardsOnTable
	{
		if(rol-1 <= 2 && col-1 <= 3 && rol-1 >= 0 && col-1 >= 0){
			if(p.canBuy(cardsOnTable[rol-1][col-1])){
				//System.out.println("Hi");
				return true;
			}else if(p.canBuyWithYellow(cardsOnTable[rol-1][col-1])){
				//System.out.println("Hello");
				return true;
			}else{
				throw new PlayerDoesNotHaveEnoughResourcesToBuySelectedCard();
			}
		}else{
			throw new InvalidCardsSelectionOfCardsOnTable();
		}
	}
	
	
	
	public String toString()
	{
		
		String r = ""; 
		
		for(int i=0; i<players.size(); i++){
			r = r + players.get(i) ;  //3 spaces
		}
		
		r = r + "/////////////////////////////////////\n";  //37
		
		String blue = "";
		for(int i=1; i<5; i++){
			blue = blue + "Blue Card " + i + ": \n" + cardsOnTable[0][i-1] + "\n";
		}
		
		String yellow = "";
		for(int i=1; i<5; i++){
			yellow =  yellow + "Yellow Card " + i + ": \n" + cardsOnTable[1][i-1] + "\n";
		}
		
		String green = "";
		for(int i=1; i<5; i++){
			green =  green + "Green Card " + i + ": \n" + cardsOnTable[2][i-1] + "\n";
		}
		
		r = r + "     Blue Deck\n" + blue + "/////////////////////////\n";
		r = r + "     Yellow Deck\n" + yellow + "/////////////////////////\n";
		r = r + "     Green Deck\n" + green + "/////////////////////////////////////\n";
		
		
		r = r + "Tokens Avalible: " + "Onyx x" + blackTokens() + " ,Sapphire x" + blueTokens() + " ,Emerald x" + greenTokens() + " ,Diamond x" + whiteTokens() + " ,Rubby x" + redTokens() + " ,Gold x" + yellowTokens() + "\n\n";
		r = r + "Nobles Avalible: \n\n";
		
		for(int i=0; i<tiles.size(); i++){
			r = r + tiles.get(i).toString() + "\n\n";
		}
		
		
		return r;
		
	}
	
	
	
	
	
	
	
	
	
	
	
	/*public void turn(int starting, int action, Tokens desired /*add more if neccessary)
	{
		//putting winner checking in UI
		if(action == 1){
			action1(players.get(starting), action, desired);
			return;
		}
	}
	
	public void action1(Player p, int action, Tokens desired) //get two tokens
	{
		if(action == 1){
			p.getTwoTokens(desired);
		}
	}*/
	
	
	
	
	
	
	
	
	
	
	
	
	
}
