package Interface;

import static java.lang.System.out;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import Exceptions.*;
import Classes.*;

public class GraphicInterface 
{
	public static void main(String[] args) throws FileNotFoundException
	{
		
		ArrayList<Cards> blueDeck = new ArrayList<Cards>();
		ArrayList<Cards> yellowDeck = new ArrayList<Cards>();
		ArrayList<Cards> greenDeck = new ArrayList<Cards>();
		
		Scanner cardsFile = new Scanner(new File("src/main/java/SplendorSet.txt"));
		Scanner sc = new Scanner(System.in);
		
		while(cardsFile.hasNextLine()){  //(int pt, ArrayList<Tokens> cost, String name, Tokens resource)
			addCards(cardsFile.nextLine().trim(), blueDeck, yellowDeck, greenDeck);
		}
		
		int numP = 2;
		
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
		
		MyFrame frame = new MyFrame("Splendor", g);
		
		
	
		
		
		
		
		
		
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
		Scanner sc = new Scanner(new File("src/main/java/Nobles.txt"));
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
