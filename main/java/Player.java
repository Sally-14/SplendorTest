import java.awt.Color;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
public class Player 
{
	private int score;
	private ArrayList<Tokens> tokens;
	private ArrayList<Cards> cards;
	private ArrayList<Cards> reserve;
	private ArrayList<Noble> nobles;
	private Color color;
	private String name;
	

	public Player(int score, ArrayList<Tokens> tokens, ArrayList<Cards> cards, ArrayList<Noble> nobles,
			ArrayList<Cards> reserve, String name) {
		super();
		this.score = score;
		this.tokens = tokens;
		this.cards = cards;
		this.reserve = reserve;
		this.name = name;
		this.nobles = nobles;
		color = new Color((int)(Math.random()*155+100), (int)(Math.random()*155+100), (int)(Math.random()*155));
		
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public ArrayList<Cards> getCards() {
		return cards;
	}

	public void setCards(ArrayList<Cards> cards) {
		this.cards = cards;
	}

	public ArrayList<Cards> getReserve() {
		return reserve;
	}

	public void setReserve(ArrayList<Cards> reserve) {
		this.reserve = reserve;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public ArrayList<Tokens> getTokens() {
		return tokens;
	}

	public void setTokens(ArrayList<Tokens> tokens) {
		this.tokens = tokens;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public ArrayList<Noble> getNobles() {
		return nobles;
	}

	public void setNobles(ArrayList<Noble> nobles) {
		this.nobles = nobles;
	}
	
	public int getPoints()
	{
		int r = 0;
		for(int i=0; i<cards.size(); i++){
			r += cards.get(i).getPt();
		}
		
		for(int i=0; i<nobles.size(); i++){
			r += nobles.get(i).getPt();
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
	
	public boolean tooMuchTokens()
	{
		return tokens.size() > 10;
	}
	
	/*public boolean removeAll(ArrayList<Tokens> have, ArrayList<Tokens> cost)
	{
		for(int i=0; i<cost.size(); i++){
			if(!have.isEmpty() && (have.contains(cost.get(i)) || have.contains(new Tokens("Gold")))){
				System.out.println("WTF");
				if(!have.remove(cost.get(i))){
					have.remove(new Tokens("Gold"));
				}
			}else{
				System.out.println(have);
				System.out.println(cost);
				System.out.println(have.contains(cost.get(i)));
				System.out.println("GTFO");
				return false;
			}
		}
		
		return true;
	}*/
	
	
	

	
	public void removeYellow(ArrayList<Tokens> t)
	{
		for(int i=0; i<t.size(); i++){
			if(t.get(i).equals(new Tokens("Gold"))){
				t.remove(i);
			}
		}
	}
	
	
	
	public ArrayList<Noble> nobleVisit(Game game)
	{
		ArrayList<Noble> possibles = new ArrayList<Noble>();
		
		ArrayList<Tokens> have = new ArrayList<Tokens>();
		ArrayList<Noble> nobles1 = game.getTiles(); 
		
		for(int i=0; i<cards.size(); i++){
			have.add(cards.get(i).getResource());
		}
		
		for(int i = 0; i<nobles1.size(); i++){
			if(have.containsAll(nobles1.get(i).getCost())){
				possibles.add(nobles1.get(i));
			}
		}
		
		//System.out.println(have);
		//System.out.println(possibles);
		
		return possibles;
		
	}
	
	public Noble visit(int index, Game game)
	{
		ArrayList<Noble> nobles1 = nobleVisit(game);
		ArrayList<Noble> nobles2 = nobles;
		
		nobles2.add(nobles1.get(index-1));
		
		setNobles(nobles2);
		setOwner(game);
		
		ArrayList<Noble> nobles3 = new ArrayList<Noble>(game.getTiles());
		nobles3.remove(nobles1.get(index-1));
		game.setTiles(nobles3);
		
		setScore(score+3);
		
		return nobles1.get(index-1);
	}
	
	public void setOwner(Game game)
	{
		for(int i=0; i<nobles.size(); i++){
			nobles.get(i).setOwner(this);
		}
		
		game.updatePlayers(this);
	}

	public Tokens discardToken(Tokens t1, Game game) throws InvalidTokensSelection
	{
		if(game.checkDiscard(this, t1)){
			for(int i=0; i<tokens.size(); i++){
				if(tokens.get(i).getColor().equals(t1.getColor())){
					tokens.remove(i);
					break;
				}
			}
		}
		
		
		
		ArrayList<Tokens> nt = game.getTokens();
		nt.add(t1);
		game.setTokens(nt);
		
		int currentPlayer = new Integer(game.getCurrentPlayer());
		//System.out.println(game.getCurrentPlayer());
		if(currentPlayer + 1 >= game.getPlayers().size()){
			currentPlayer = 0;
		}else{
			currentPlayer++;
		}
		
		if(!game.getPlayers().get(game.getCurrentPlayer()).tooMuchTokens()){
			game.setCurrentPlayer(currentPlayer);
		}
		
		return t1;
	}
	
	public void getTwoTokens(Tokens desired, Game game) throws NotEnoughTokensOnTable  //Action 1
	{
		if(game.checkActionOne(this, desired)){
			tokens.add(desired);
			tokens.add(desired);
			
			ArrayList<Tokens> nt = game.getTokens();
			
			//System.out.println(desired);
			//System.out.println(nt.remove(new Tokens("Sapphire")));
			//System.out.println(nt.remove(new Tokens("Sapphire")));
			
			int counter = 0;
			for(int i = 0; i<nt.size(); i++){
				if(nt.get(i).getColor().equals(desired.getColor()) && counter < 2){
					nt.remove(i);
					counter++;
				}
			}
			
			
			Collections.sort(nt);
			//System.out.println(nt);
			game.setTokens(nt);
			game.updatePlayers(this);
			
			int currentPlayer = new Integer(game.getCurrentPlayer());
			//System.out.println(game.getCurrentPlayer());
			if(currentPlayer + 1 >= game.getPlayers().size()){
				currentPlayer = 0;
			}else{
				currentPlayer++;
			}
			
			System.out.println(tokens.size() + "YOLOSWAG");
			
			if(game.getPlayers().get(game.getCurrentPlayer()).tooMuchTokens()){
				System.out.println("Working");
				return;
			}else{
				System.out.println("Possibly not working");
				game.setCurrentPlayer(currentPlayer);
			}
				
			
				
		}
	
	}
	
	public void getOneOfEachTokens(Tokens d1, Tokens d2, Tokens d3, Game game) throws NotEnoughTokensOnTable  //Action 2
	{
		if(game.checkActionTwo(this, d1, d2, d3)){
			tokens.add(d1);
			tokens.add(d2);
			tokens.add(d3);
			
			ArrayList<Tokens> nt = new ArrayList<Tokens>(game.getTokens());
			
			/*int counter = 0;
			
			for(int i=0; i<game.getTokens().size(); i++){
				if(game.getTokens().get(i).getColor().equals(d1.getColor()) && counter <= 3 ){
					nt.remove(i);
					counter++;
				}else if(game.getTokens().get(i).getColor().equals(d2.getColor()) && counter <= 3){
					nt.remove(i);
					counter++;
				}else if(game.getTokens().get(i).getColor().equals(d3.getColor()) && counter <= 3){
					nt.remove(i);
					counter++;
				}
			}*/
			
			/*System.out.println(d1 + " " + d2 + " " + d3);
			System.out.println(nt.get(2));
			System.out.println(nt.get(2).equals(d1));
			System.out.println(nt);*/
			
			Collections.sort(nt);
			
			nt.remove(d1);
			nt.remove(d2);
			nt.remove(d3);
			
			//System.out.println(nt);
			//System.out.println(d1 + " " + d2 + " " + d3);
			
			game.setTokens(nt);
			game.updatePlayers(this);
			
			System.out.println(tokens.size() + "YOLOSWAG2");

			
			int currentPlayer = new Integer(game.getCurrentPlayer());
			if(currentPlayer + 1 >= game.getPlayers().size()){
				currentPlayer = 0;
			}else{
				currentPlayer++;
			}
			
			
			if(game.getPlayers().get(game.getCurrentPlayer()).tooMuchTokens()){
				System.out.println("Working");
				return;
			}else{
				System.out.println("Possibly not Working");
				game.setCurrentPlayer(currentPlayer);
			}
			
		}
	}
	
	public Cards reserveCard(int rol, int col, Game game) throws InvalidCardsSelectionOfCardsOnTable, PlayerAlreadyHoldsThreeReserveCards //Action 3      //roll 1:blue deck; roll 2: yellow deck; roll 3: green deck;
	{
		Cards cd = null;
		if(game.checkActionThree(this, rol, col)){
			cd = game.getCardsOnTable()[rol-1][col-1];
			reserve.add(cd);
			if(game.getTokens().contains(new Tokens("Gold"))){
				tokens.add(new Tokens("Gold"));
				game.getTokens().remove(new Tokens("Gold"));
			}
			
			int currentPlayer = game.getPlayers().indexOf(this);
			if(currentPlayer + 1 >= game.getPlayers().size()){
				currentPlayer = 0;
			}else{
				currentPlayer++;
			}
			
			game.setCurrentPlayer(currentPlayer);
		}
		
		Cards[][] c = game.getCardsOnTable();
		
		
		if(rol == 1){
			c[rol-1][col-1] = game.getRandom("blue");
		}else if(rol == 2){
			c[rol-1][col-1] = game.getRandom("yellow");
		}else if(rol == 3){
			c[rol-1][col-1] = game.getRandom("green");
		}
		
		game.setCardsOnTable(c);
		
		return cd;
		
	}
	
	public Cards reserveCard(String deckDesired, Game game) throws SelectedDeckRanOutOfCards  //Also Action 3
	{
		Cards c = null;
		
		if(game.checkActionThree(this, deckDesired)){
			c = game.getRandom(deckDesired);
			
			if(game.getTokens().contains(new Tokens("Gold"))){
				tokens.add(new Tokens("Gold"));
				game.getTokens().remove(new Tokens("Gold"));
			}
			
			reserve.add(c);
			
			ArrayList<Cards> cd = game.getDeck(deckDesired);
			cd.remove(c);
			
			if(deckDesired.contains("blue")){
				game.setBlueDeck(cd);
			}else if(deckDesired.contains("yellow")){
				game.setYellowDeck(cd);
			}else{
				game.setGreenDeck(cd);
			}
			
			int currentPlayer = game.getPlayers().indexOf(this);
			if(currentPlayer + 1 >= game.getPlayers().size()){
				currentPlayer = 0;
			}else{
				currentPlayer++;
			}
			
			game.setCurrentPlayer(currentPlayer);
				
		}
		
		return c;
	}
	
	public boolean containsAll(ArrayList<Tokens> have, ArrayList<Tokens> cost)
	{
		boolean b = true;
		for(int i=0; i<cost.size(); i++){
			if(!have.contains(cost.get(i))){
				b = false;
				break;
			}
		}
		
		return b;
	}
	
	public boolean removeAll(ArrayList<Tokens> have, ArrayList<Tokens> cost)
	{
		boolean b = true;
		for(int i=0; i<cost.size(); i++){
			if(have.contains(cost.get(i))){
				have.remove(cost.get(i));
			}
		}
		
		return b;
	}
	
	public boolean canBuy(Cards desired)
	{
		ArrayList<Tokens> cost = new ArrayList<Tokens>(desired.getCost());
		ArrayList<Tokens> have = new ArrayList<Tokens>();
		
		for(int i=0; i<cards.size(); i++){
			have.add(cards.get(i).getResource());
		}
		
		//System.out.println(have);
		//System.out.println(cost);
		
		have.addAll(tokens);
		
		//System.out.println(have);
		
		//System.out.println(cost);
		//System.out.println(have);
		
		boolean bs = true;
		
		bs = containsAll(have, cost);
		
		//System.out.println(have.containsAll(cost));
		
		//System.out.println(bs);
		
		have.removeAll(cost);
		
		//System.out.println(have);
		
		//System.out.println(have.isEmpty());
		//System.out.println(have);
		
		if(have.size() == 0 && bs){
			//System.out.println("SDFSDFSDF");
			return true;
		}
		
		for(int i=0; i<have.size(); i++){
			if(have.get(i).equals(new Tokens("Gold"))){
				have.remove(new Tokens("Gold"));
			}
		}
		
		/*System.out.println(have.size());
		System.out.println(have.size() == 0);
		System.out.println(bs);
		System.out.println(((have.size() == 0) && bs));*/
		
		
		
		return ((have.size() == 0) && bs);
		
	}
	
	public boolean canBuyWithYellow(Cards desired)
	{
		ArrayList<Tokens> cost = new ArrayList<Tokens>(desired.getCost());
		ArrayList<Tokens> have = new ArrayList<Tokens>();
		ArrayList<Tokens> gold = new ArrayList<Tokens>();
		ArrayList<Tokens> resource = new ArrayList<Tokens>();
		ArrayList<Tokens> temp = new ArrayList<Tokens>();
		
		for(int i=0; i<cards.size(); i++){
			resource.add(cards.get(i).getResource());
		}
		
		have.addAll(tokens);
		
		for(int i=0; i<have.size(); i++){
			if(have.get(i).equals(new Tokens("Gold"))){
				have.remove(new Tokens("Gold"));
				gold.add(new Tokens("Gold"));
			}
		}
		
		
		ArrayList<Tokens> costAfter = new ArrayList<Tokens>(desired.getCost());
		
		System.out.println(costAfter);
		System.out.println(have);
		Collections.sort(resource);
		System.out.println(resource);
		
		removeAll(costAfter, resource);
		
		System.out.println(costAfter);
		//System.out.println(have);
		
		for(int i=have.size()-1; i>=0; i--){
			if(costAfter.contains(have.get(i))){
				costAfter.remove(have.get(i));
				temp.add(have.get(i));
				have.remove(i);
			}
		}
		
		//System.out.println(have);
		//System.out.println(costAfter);
		
		if(costAfter.size() != 0){
			//System.out.println(costAfter);
			//System.out.println(gold);
			return costAfter.size() <= gold.size();   //*** FOR TEST PURPOSES ***\\
		}
		
		return true;
		
		/*
		removeAll(costAfter, have);
		boolean c = removeAll(have, cost);
		
		if(costAfter.size() == have.size()){
			return true;
		}else{
			return false;
		}*/
		
		
	}
	
	public ArrayList<Tokens> canBuyWithYellow2(Cards desired)
	{
		ArrayList<Tokens> cost = new ArrayList<Tokens>(desired.getCost());
		ArrayList<Tokens> have = new ArrayList<Tokens>();
		ArrayList<Tokens> gold = new ArrayList<Tokens>();
		ArrayList<Tokens> resource = new ArrayList<Tokens>();
		ArrayList<Tokens> temp = new ArrayList<Tokens>();
		
		for(int i=0; i<cards.size(); i++){
			resource.add(cards.get(i).getResource());
		}
		
		have.addAll(tokens);
		
		for(int i=0; i<have.size(); i++){
			if(have.get(i).equals(new Tokens("Gold"))){
				have.remove(new Tokens("Gold"));
				gold.add(new Tokens("Gold"));
			}
		}
		
		
		ArrayList<Tokens> costAfter = new ArrayList<Tokens>(desired.getCost());
		
		removeAll(costAfter, resource);
		
		for(int i=have.size()-1; i>=0; i--){
			if(costAfter.contains(have.get(i))){
				costAfter.remove(have.get(i));
				temp.add(have.get(i));
				have.remove(i);
			}
		}
		
		System.out.println(costAfter);
		
		if(costAfter.size() != 0 && gold.size() >= costAfter.size()){
			for(int i=0; i<costAfter.size(); i++){
				if(gold.remove(new Tokens("Gold"))){
					temp.add(new Tokens("Gold"));
				}
			}
		}
		
		//System.out.println(temp);
		return temp;
		
	}
	
	public Cards placeCardFromReserve(Cards desired, Game game) throws PlayerDoesNotHaveEnoughResourcesToBuySelectedCard, PlayerDoesNotHaveSelectedCardInReserve  //Action 4
	{
		if(game.checkActionFour(this, desired)){
			boolean can = false;
			boolean canYellow = false;
			
			cards.add(desired);
			reserve.remove(desired);
			int s = getPoints();
			setScore(s);
			game.updatePlayers(this);
			
			ArrayList<Tokens> cby = new ArrayList<Tokens>();
			
			if(canBuy(desired)){
				//System.out.println("HIHIHIHIHIHIHIHIHIH");
				can = true;
				//System.out.println();
				removeAll(tokens, desired.getCost());
			}else if(canBuyWithYellow(desired)){
				//System.out.println("LOLOLOLOLOLOLOOLOLOLOL");
				cby = canBuyWithYellow2(desired);
				System.out.println(cby);
				//System.out.println();
				removeAll(tokens, cby);
				//System.out.println(cby);
				canYellow = true;
			}
			
			ArrayList<Tokens> t = game.getTokens();

			if(can){
				//System.out.println("HEYHEYHEYHEYHEYHEYHEYHEY");
				//System.out.println();
				t.addAll(desired.getCost());
			}else if(canYellow){
				//System.out.println("YOYOYOYOYOYOYOYOYOYO");
				//System.out.println(cby);
				//System.out.println();
				t.addAll(cby);
				//System.out.println(t);
			}
			
			game.setTokens(t);
			
			int currentPlayer = game.getPlayers().indexOf(this);
			if(currentPlayer + 1 >= game.getPlayers().size()){
				currentPlayer = 0;
			}else{
				currentPlayer++;
			}
			
			game.setCurrentPlayer(currentPlayer);
			
			return desired;
			
			
		}
		
		
		
		return null;
	}
	
	public Cards buyCardOnTable(int rol, int col, Game game) throws PlayerDoesNotHaveEnoughResourcesToBuySelectedCard, InvalidCardsSelectionOfCardsInReserve  //Action 5
, InvalidCardsSelectionOfCardsOnTable
	{
		Cards cd = null;
		boolean can = false;
		boolean canYellow = false;
		ArrayList<Tokens> cby = new ArrayList<Tokens>();
		
		if(game.checkActionFive(this, rol, col)){
			cd = game.getCardsOnTable()[rol-1][col-1];
			cards.add(cd);
			int s = getPoints();
			setScore(s);
			System.out.println(s);
			game.updatePlayers(this);
			
			if(canBuy(cd)){
				//System.out.println("HIHIHIHIHIHIHIHIHIH");
				can = true;
				//System.out.println();
				tokens.removeAll(cd.getCost());
			}else if(canBuyWithYellow(cd)){
				//System.out.println("LOLOLOLOLOLOLOOLOLOLOL");
				cby = canBuyWithYellow2(cd);
				//System.out.println(cby);
				//System.out.println();
				tokens.removeAll(cby);
				//System.out.println(tokens);
				canYellow = true;
			}
			
			int currentPlayer = game.getPlayers().indexOf(this);
			if(currentPlayer + 1 >= game.getPlayers().size()){
				currentPlayer = 0;
			}else{
				currentPlayer++;
			}
			
			game.setCurrentPlayer(currentPlayer);
			
		}
		
		Cards[][] c = game.getCardsOnTable();
		
		
		if(rol == 1){
			c[rol-1][col-1] = game.getRandom("blue");
		}else if(rol == 2){
			c[rol-1][col-1] = game.getRandom("yellow");
		}else if(rol == 3){
			c[rol-1][col-1] = game.getRandom("green");
		}
		
		game.setCardsOnTable(c);
		
		ArrayList<Tokens> t = game.getTokens();

		if(can){
			//System.out.println("HEYHEYHEYHEYHEYHEYHEYHEY");
			//System.out.println();
			t.addAll(cd.getCost());
		}else if(canYellow){
			//System.out.println("YOYOYOYOYOYOYOYOYOYO");
			//System.out.println(cby);
			//System.out.println();
			t.addAll(cby);
			//System.out.println(t);
		}
		
		game.setTokens(t);
		
		return cd;
	}
	
	public int whiteTokens()
	{
		int r = 0;
		for(int i=0; i<tokens.size(); i++){
			if(tokens.get(i).toString().equalsIgnoreCase("Diamond")){
				r++;
			}
		}
		
		return r;
	}
	
	public int greenTokens()
	{
		int r = 0;
		for(int i=0; i<tokens.size(); i++){
			if(tokens.get(i).toString().equalsIgnoreCase("Emerald")){
				r++;
			}
		}
		
		return r;
	}
	
	public int blueTokens()
	{
		int r = 0;
		for(int i=0; i<tokens.size(); i++){
			if(tokens.get(i).toString().equalsIgnoreCase("Sapphire")){
				r++;
			}
		}
		
		return r;
	}
	
	public int blackTokens()
	{
		int r = 0;
		for(int i=0; i<tokens.size(); i++){
			if(tokens.get(i).toString().equalsIgnoreCase("Onyx")){
				r++;
			}
		}
		
		return r;
	}
	
	public int redTokens()
	{
		int r = 0;
		for(int i=0; i<tokens.size(); i++){
			if(tokens.get(i).toString().equalsIgnoreCase("Rubby")){
				r++;
			}
		}
		
		return r;
	}
	
	public int yellowTokens()
	{
		int r = 0;
		for(int i=0; i<tokens.size(); i++){
			if(tokens.get(i).toString().equalsIgnoreCase("Gold")){
				r++;
			}
		}
		
		return r;
	}
	
	public ArrayList<Cards> blackCards()
	{
		ArrayList<Cards> c = new ArrayList<Cards>();
		
		for(int i=0; i<cards.size(); i++){
			if(cards.get(i).getResource().equals(new Tokens("Onyx"))){
				c.add(cards.get(i));
			}
		}
		
		return c;
	}
	
	public ArrayList<Cards> blueCards()
	{
		ArrayList<Cards> c = new ArrayList<Cards>();
		
		for(int i=0; i<cards.size(); i++){
			if(cards.get(i).getResource().equals(new Tokens("Sapphire"))){
				c.add(cards.get(i));
			}
		}
		
		return c;
	}
	
	public ArrayList<Cards> greenCards()
	{
		ArrayList<Cards> c = new ArrayList<Cards>();
		
		for(int i=0; i<cards.size(); i++){
			if(cards.get(i).getResource().equals(new Tokens("Emerald"))){
				c.add(cards.get(i));
			}
		}
		
		return c;
	}
	
	public ArrayList<Cards> whiteCards()
	{
		ArrayList<Cards> c = new ArrayList<Cards>();
		
		for(int i=0; i<cards.size(); i++){
			if(cards.get(i).getResource().equals(new Tokens("Diamond"))){
				c.add(cards.get(i));
			}
		}
		
		return c;
	}
	
	public ArrayList<Cards> redCards()
	{
		ArrayList<Cards> c = new ArrayList<Cards>();
		
		for(int i=0; i<cards.size(); i++){
			if(cards.get(i).getResource().equals(new Tokens("Rubby"))){
				c.add(cards.get(i));
			}
		}
		
		return c;
	}
	
	@SuppressWarnings("unchecked")
	public String toString()
	{
		Collections.sort(cards);
		String r = "";
		
		r = r + "***** " + name + " " + getPoints() + " Point(s) *****\n"; //10 space on left side and 7 on the right
		r = r + "Tokens: " + "Onyx x" + blackTokens() + " ,Sapphire x" + blueTokens() + " ,Emerlad x" + greenTokens() + " ,Diamond x" + whiteTokens() + " ,Rubby x" + redTokens() + " ,Gold x" + yellowTokens() + "\n\n";
		//r = r + tokens.toString();
		
		r = r + "Cards:\n"; 
		for(int i=0; i<cards.size(); i++){
			r = r + cards.get(i); //3 spaces;
			if(i+1 != cards.size() && cards.get(i+1).getResource() != cards.get(i).getResource()){
				r = r + "\n";
			}
		}
		
		r = r + "\n";
		
		r = r + "Nobles: \n";
		for(int i = 0; i<nobles.size(); i++){
			r = r + nobles.get(i) + "   ";
		}
		
		r = r + "\n\n";
		
		r = r + "Cards in Reserve x" + reserve.size() + "\n";
		
		r = r + "*******************************\n\n";  //31 *
		
		return r;
	}

	public String toStringWithCardsInReserve()
	{
		Collections.sort(cards);
		String r = "";
		
		r = r + "***** " + name + " " + getPoints() + " Point(s) *****\n"; //10 space on left side and 7 on the right
		r = r + "Tokens: " + "Onyx x" + blackTokens() + " ,Sapphire x" + blueTokens() + " ,Emerlad x" + greenTokens() + " ,Diamond x" + whiteTokens() + " ,Rubby x" + redTokens() + " ,Gold x" + yellowTokens() + "\n\n";
		//r = r + tokens.toString();
		
		r = r + "**** Cards ****\n"; 
		for(int i=0; i<cards.size(); i++){
			r = r + cards.get(i)+"   "; //3 spaces;
			if(i+1 != cards.size() && cards.get(i+1).getResource() != cards.get(i).getResource()){
				r = r + "\n";
			}
		}
		
		r = r + "\n";
		
		r = r + "**** Nobles ****\n";
		for(int i = 0; i<nobles.size(); i++){
			r = r + nobles.get(i);
		}
		
		r = r + "\n\n";
		
		r = r + "**** Cards in Reserve **** \n\n";
		
		for(int i = 0; i<reserve.size(); i++){
			r = r + reserve.get(i) + "\n";
		}
		
		return r;
	}

	
}
