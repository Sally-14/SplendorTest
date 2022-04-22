package Classes;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.*;


public class MyPanel extends JPanel implements MouseListener
{
	private Game game;
	private ArrayList<Tokens> t;
	
	public MyPanel (Game g)
	{
		super();
		setSize(1600,800);
		addMouseListener(this);
		
		game = g;
		t = new ArrayList<Tokens>();
		
	}
	
	public void paint(Graphics g)
	{
		super.paintComponent(g);
		
		Font currentFont = g.getFont();
		Font newFont = currentFont.deriveFont(currentFont.getSize() * 7F);
		g.setFont(newFont);
		
		//System.out.println(game.win());
		
		if(!game.getPlayers().get(game.getCurrentPlayer()).nobleVisit(game).isEmpty()){
			game.getPlayers().get(game.getCurrentPlayer()).visit((int)(Math.random()*game.getPlayers().get(game.getCurrentPlayer()).nobleVisit(game).size()+1), game);
			repaint();
		}
		
		currentFont = g.getFont();
		newFont = currentFont.deriveFont(currentFont.getSize()/7F);
		g.setFont(newFont);
		
		g.setColor(Color.BLACK);
		
		for(int i=0; i<1601; i+=40){
			g.drawLine(i, 0, i, 800);
			g.drawString(i+"", i, 20);
		}
		
		for(int j=0; j<801; j+=40){
			g.drawLine(0, j, 1600, j);
			g.drawString(j+"", 0, j);
		}
		
		repaint();
		
		currentFont = g.getFont();
		newFont = currentFont.deriveFont(currentFont.getSize() * 2F);
		g.setFont(newFont);
		
		for(int x=160; x<=560; x+=80){
			if(x - 160 == 0){
				g.setColor(Color.BLACK);
				g.fillOval(40, x, 39, 39);
				g.drawString("x" + tokenCounts(new Tokens("Onyx"), game.getTokens()), 80, x + 40);
			}else if(x - 160 == 80){
				g.setColor(Color.BLUE);
				g.fillOval(40, x, 39, 39);
				g.drawString("x" + tokenCounts(new Tokens("Sapphire"), game.getTokens()), 80, x + 40);
			}else if(x - 160 == 160){
				g.setColor(Color.GREEN);
				g.fillOval(40, x, 39, 39);
				g.drawString("x" + tokenCounts(new Tokens("Emerald"), game.getTokens()), 80, x + 40);
			}else if(x - 160 == 240){
				g.setColor(Color.WHITE);
				g.fillOval(40, x, 39, 39);
				g.drawString("x" + tokenCounts(new Tokens("Diamond"), game.getTokens()), 80, x + 40);
			}else if(x - 160 == 320){
				g.setColor(Color.RED);
				g.fillOval(40, x, 39, 39);
				g.drawString("x" + tokenCounts(new Tokens("Rubby"), game.getTokens()), 80, x + 40);
			}else if(x - 160 == 400){
				g.setColor(Color.YELLOW);
				g.fillOval(40, x, 39, 39);
				g.drawString("x" + tokenCounts(new Tokens("Gold"), game.getTokens()), 80, x + 40);
			}   
		}
		
		
		
		
		
		currentFont = g.getFont();
		newFont = currentFont.deriveFont(currentFont.getSize() * 1.5F);
		
		for(int y=160; y<=480; y+=160){
			if(y - 160 == 0){
				g.setColor(Color.BLUE);
				g.fillRect(160, y, 80, 120);
				g.setColor(Color.WHITE);
				
				currentFont = g.getFont();
				newFont = currentFont.deriveFont(currentFont.getSize() * 1.7F);
				
				g.setFont(newFont);
				g.drawString("Blue", 160, y+80);
			}else if(y - 160 == 160){
				g.setColor(Color.YELLOW);
				g.fillRect(160, y, 80, 120);
				g.setColor(Color.WHITE);
				
				currentFont = g.getFont();
				newFont = currentFont.deriveFont(currentFont.getSize() / 1.50F);
				g.setFont(newFont);
				
				g.drawString("Yellow", 160, y+80);
			}else{
				g.setColor(Color.GREEN);
				g.fillRect(160, y, 80, 120);
				g.setColor(Color.WHITE);
				
				currentFont = g.getFont();
				newFont = currentFont.deriveFont(currentFont.getSize() * 1.07F);
				g.setFont(newFont);
				
				g.drawString("Green", 160, y+80);
			}
		}
		
		
		
		
	
		
		g.setColor(Color.GRAY);
		
		for(int a=320; a<=680; a+=120){
			for(int b=160; b<=480; b+=160){
				g.fillRect(a, b, 80, 120);  
			
				Cards c = game.getCardsOnTable()[(b-160)/160][(a-320)/120];
				
				g.setColor(c.getResource().returnColor());
				
				currentFont = g.getFont();
				newFont = currentFont.deriveFont(28F);
				g.setFont(newFont);
				
				g.fillOval(a, b, 20, 20);
				g.drawString(c.getPt()+"", a+65, b+25);
				
				currentFont = g.getFont();
				newFont = currentFont.deriveFont(15F);
				g.setFont(newFont);
				
				
				
				g.drawString("Reserve", a+12, b+50);
				g.fill3DRect(a+5 , b+55, 70, 3, true);
				g.drawString("Buy", a+28, b+75);
				
				int bc = c.blackCost();
				int wc = c.whiteCost();
				int gc = c.greenCost();
				int rc = c.redCost();
				int bluC = c.blueCost();
				
				//System.out.println(bc + " " + wc + " " + gc + " " + rc + " " + bluC);
				
				if(bc != 0){
					for(int d=0; d<bc; d++){
						g.setColor(Color.BLACK);
						g.fillOval(a, b+80, 6, 6);
						
						currentFont = g.getFont();
						newFont = currentFont.deriveFont(9F);
						g.setFont(newFont);
						
						g.drawString("x " + bc, a+10, b+80+7);
						
						newFont = currentFont.deriveFont(28F);
						g.setFont(newFont);
					}
				}
				
				if(bluC != 0){
					for(int d=0; d<bluC; d++){
						g.setColor(Color.BLUE);
						g.fillOval(a, b+86, 6, 8);
						
						currentFont = g.getFont();
						newFont = currentFont.deriveFont(9F);
						g.setFont(newFont);
						
						g.drawString("x " + bluC, a+10, b+88+7);
						
						newFont = currentFont.deriveFont(28F);
						g.setFont(newFont);
					}
				}
				
				if(gc != 0){
					for(int d=0; d<gc; d++){
						g.setColor(Color.GREEN);
						g.fillOval(a, b+96, 6, 6);
						
						currentFont = g.getFont();
						newFont = currentFont.deriveFont(9F);
						g.setFont(newFont);
						
						g.drawString("x " + gc, a+10, b+96+7);
						
						newFont = currentFont.deriveFont(28F);
						g.setFont(newFont);
					}
				}
				
				if(wc != 0){
					for(int d=0; d<wc; d++){
						g.setColor(Color.WHITE);
						g.fillOval(a, b+104, 6, 6);
						
						currentFont = g.getFont();
						newFont = currentFont.deriveFont(9F);
						g.setFont(newFont);
						
						g.drawString("x " + wc, a+10, b+104+7);
						
						newFont = currentFont.deriveFont(28F);
						g.setFont(newFont);
					}
				}
				
				if(rc != 0){
					for(int d=0; d<rc; d++){
						g.setColor(Color.RED);
						g.fillOval(a, b+112, 6, 6);
						
						currentFont = g.getFont();
						newFont = currentFont.deriveFont(9F);
						g.setFont(newFont);
						
						g.drawString("x " + rc, a+10, b+112+7);
						
						newFont = currentFont.deriveFont(28F);
						g.setFont(newFont);
					}
				}
				
				g.setColor(Color.GRAY);
				
				
			}
		}
		
		//Onyx x0 ,Sapphire x0 ,Emerlad x0 ,Diamond x0 ,Rubby x0 ,Gold x0
		
		
		
		for(int i=120; i<=600; i+=120){
			g.setColor(Color.LIGHT_GRAY);
			currentFont = g.getFont();
			newFont = currentFont.deriveFont(28F);
			g.setFont(newFont);
			
			
			Noble n = null;
			if((i-120)/120 < game.getTiles().size()){
				n = game.getTiles().get((i-120)/120);
			}else if(!game.containNoble().isEmpty()){
				for(int j=i; j<=600; j+=120){
					ArrayList<Noble> nobles = new ArrayList<Noble>(game.containNoble());
					
					if((j-120)/120 >= nobles.size()){
						break;
					}
					
					n = nobles.get((j-120)/120);
					
					g.setColor(n.getOwner().getColor());
					currentFont = g.getFont();
					newFont = currentFont.deriveFont(23F);
					g.setFont(newFont);
					
					g.drawString(n.getOwner().getName(), j, 40-15);
					g.drawRect(j-5, 35, 90, 90);
					
					
					g.setColor(Color.BLACK);
					g.drawString(3 + "", j+60, 65);
					
					g.setColor(Color.LIGHT_GRAY);
					g.fillRect(j, 40, 80, 80);
					
					currentFont = g.getFont();
					newFont = currentFont.deriveFont(9F);
					g.setFont(newFont);
					
					
					if(n.blackCost() != 0){
						g.setColor(Color.BLACK);
						g.fillOval(j, 80, 6, 6);
						
						g.drawString("x " + n.blackCost(), j+10, 86);
					}
					
					if(n.blueCost() != 0){
						g.setColor(Color.BLUE);
						g.fillOval(j, 88, 6, 6);
						
						g.drawString("x " + n.blueCost(), j+10, 94);
					}
					
					if(n.greenCost() != 0){
						g.setColor(Color.GREEN);
						g.fillOval(j, 96, 6, 6);
						
						g.drawString("x " + n.greenCost(), j+10, 102);
					}
					
					if(n.whiteCost() != 0){
						g.setColor(Color.WHITE);
						g.fillOval(j, 104, 6, 6);
						
						g.drawString("x " + n.whiteCost(), j+10, 110);
					}
					
					if(n.redCost() != 0){
						g.setColor(Color.RED);
						g.fillOval(j, 112, 6, 6);
						
						g.drawString("x " + n.redCost(), j+10, 118);
					}
					
					g.setColor(Color.GRAY);
				}
				
				break;
				
			}else{
				break;
			}
			
			g.fillRect(i, 40, 80, 80);
			
			g.setColor(Color.BLACK);
			g.drawString(3 + "", i+60, 65);
			
			
			
			currentFont = g.getFont();
			newFont = currentFont.deriveFont(9F);
			g.setFont(newFont);
			
			
			if(n.blackCost() != 0){
				g.setColor(Color.BLACK);
				g.fillOval(i, 80, 6, 6);
				
				g.drawString("x " + n.blackCost(), i+10, 86);
			}
			
			if(n.blueCost() != 0){
				g.setColor(Color.BLUE);
				g.fillOval(i, 88, 6, 6);
				
				g.drawString("x " + n.blueCost(), i+10, 94);
			}
			
			if(n.greenCost() != 0){
				g.setColor(Color.GREEN);
				g.fillOval(i, 96, 6, 6);
				
				g.drawString("x " + n.greenCost(), i+10, 102);
			}
			
			if(n.whiteCost() != 0){
				g.setColor(Color.WHITE);
				g.fillOval(i, 104, 6, 6);
				
				g.drawString("x " + n.whiteCost(), i+10, 110);
			}
			
			if(n.redCost() != 0){
				g.setColor(Color.RED);
				g.fillOval(i, 112, 6, 6);
				
				g.drawString("x " + n.redCost(), i+10, 118);
			}
			
			g.setColor(Color.GRAY);
		}
		
		
		
		
		
		
		g.setColor(Color.GRAY);

		Player currentPlayer = game.getPlayers().get(game.getCurrentPlayer());
		
		currentFont = g.getFont();
		newFont = currentFont.deriveFont(28F);
		g.setFont(newFont);
		
		g.drawString(currentPlayer.getName() + ": " + currentPlayer.getPoints() + " Points", 200, 630);

		
		int onyx = currentPlayer.blackTokens();
		int sapphire = currentPlayer.blueTokens();
		int emerald = currentPlayer.greenTokens();
		int diamond = currentPlayer.whiteTokens();
		int rubby = currentPlayer.redTokens();
		int gold = currentPlayer.yellowTokens();
		
		
		currentFont = g.getFont();
		newFont = currentFont.deriveFont(18F);
		g.setFont(newFont);
		
		
		if(game.getPlayers().get(game.getCurrentPlayer()).tooMuchTokens()){
			g.setColor(Color.RED);
			g.fillOval(522, 602, 36, 36);
			g.setColor(Color.YELLOW);
			g.fillRect(539, 604, 5, 18);
			g.fillRect(539, 630, 5, 5);
			g.setColor(Color.RED);
			g.drawString("TOKENS COUNT EXCEEDS 10! DOUBLE CLICK ON TOKEN TO DISCARD!", 560, 636);
		}
		
		
		currentFont = g.getFont();
		newFont = currentFont.deriveFont(26F);
		g.setFont(newFont);
		
		g.setColor(Color.BLACK);
		g.fillOval(600, 640, 19, 19);
		g.drawString("x " + onyx, 620, 656);
		
		g.setColor(Color.BLUE);
		g.fillOval(600, 660, 19, 19);
		g.drawString("x " + sapphire, 620, 676);
		
		g.setColor(Color.GREEN);
		g.fillOval(600, 680, 19, 19);
		g.drawString("x " + emerald, 620, 696);
		
		g.setColor(Color.RED);
		g.fillOval(600, 700, 19, 19);
		g.drawString("x " + rubby, 620, 716);
		
		g.setColor(Color.WHITE);
		g.fillOval(600, 720, 19, 19);
		g.drawString("x " + diamond, 620, 736);
		
		g.setColor(Color.YELLOW);
		g.fillOval(600, 740, 19, 19);
		g.drawString("x " + gold, 620, 756);
		
		//System.out.println(blackCards);
		
		/*ArrayList<Cards> r = new ArrayList<Cards>();
		r.add(game.getCardsOnTable()[0][0]);
		r.add(game.getCardsOnTable()[0][1]);
		r.add(game.getCardsOnTable()[0][2]);
		
		game.getPlayers().get(game.getCurrentPlayer()).setReserve(r);*/
		
		g.setColor(Color.GRAY);
		
		currentFont = g.getFont();
		newFont = currentFont.deriveFont(28F);
		g.setFont(newFont);
		
		g.drawString(currentPlayer.getName() + "'s reserve: ", 720, 670);
		
		for(int i=680; i<=920; i+=120){
	
			currentFont = g.getFont();
			newFont = currentFont.deriveFont(28F);
			g.setFont(newFont);
			
			Cards c = null;
			if((i-680)/120 < game.getPlayers().get(game.getCurrentPlayer()).getReserve().size()){
				c = game.getPlayers().get(game.getCurrentPlayer()).getReserve().get((i-680)/120);
			}else{
				break;
			}
			
			g.fillRect(i, 680, 80, 120);
			
			g.setColor(c.getResource().returnColor());
			
			g.fillOval(i, 680, 19, 19);
			g.drawString(c.getPt()+"", i+40+25, 680+25);
			
			currentFont = g.getFont();
			newFont = currentFont.deriveFont(18F);
			g.setFont(newFont);
			
			g.setColor(Color.ORANGE);
			
			g.fill3DRect(i+23, 723, 35, 20, false);
			g.drawString("Buy", i+25, 738);
			
			
			int bc = c.blackCost();
			int wc = c.whiteCost();
			int gc = c.greenCost();
			int rc = c.redCost();
			int bluC = c.blueCost();
			
			//System.out.println(bc + " " + wc + " " + gc + " " + rc + " " + bluC);
			
			if(bc != 0){
				for(int d=0; d<bc; d++){
					g.setColor(Color.BLACK);
					g.fillOval(i, 680+80, 6, 6);
					
					currentFont = g.getFont();
					newFont = currentFont.deriveFont(9F);
					g.setFont(newFont);
					
					g.drawString("x " + bc, i+8, 680+80+6);
					
					newFont = currentFont.deriveFont(28F);
					g.setFont(newFont);
				}
			}
			
			if(bluC != 0){
				for(int d=0; d<bluC; d++){
					g.setColor(Color.BLUE);
					g.fillOval(i, 680+88, 6, 6);
					
					currentFont = g.getFont();
					newFont = currentFont.deriveFont(9F);
					g.setFont(newFont);
					
					g.drawString("x " + bluC, i+8, 680+88+6);
					
					newFont = currentFont.deriveFont(28F);
					g.setFont(newFont);
				}
			}
			
			if(gc != 0){
				for(int d=0; d<gc; d++){
					g.setColor(Color.GREEN);
					g.fillOval(i, 680+96, 6, 6);
					
					currentFont = g.getFont();
					newFont = currentFont.deriveFont(9F);
					g.setFont(newFont);
					
					g.drawString("x " + gc, i+8, 680+96+6);
					
					newFont = currentFont.deriveFont(28F);
					g.setFont(newFont);
				}
			}
			
			if(wc != 0){
				for(int d=0; d<wc; d++){
					g.setColor(Color.WHITE);
					g.fillOval(i, 680+102, 6, 6);
					
					currentFont = g.getFont();
					newFont = currentFont.deriveFont(9F);
					g.setFont(newFont);
					
					g.drawString("x " + wc, i+8, 680+102+6);
					
					newFont = currentFont.deriveFont(28F);
					g.setFont(newFont);
				}
			}
			
			if(rc != 0){
				for(int d=0; d<rc; d++){
					g.setColor(Color.RED);
					g.fillOval(i, 680+110, 6, 6);
					
					currentFont = g.getFont();
					newFont = currentFont.deriveFont(9F);
					g.setFont(newFont);
					
					g.drawString("x " + rc, i+8, 680+110+6);
					
					newFont = currentFont.deriveFont(28F);
					g.setFont(newFont);
				}
			}
			
			g.setColor(Color.GRAY);
			
			
		}
		
		
		
		g.setColor(Color.GRAY);
		
		ArrayList<Cards> blackCards = currentPlayer.blackCards();
		ArrayList<Cards> blueCards = currentPlayer.blueCards();
		ArrayList<Cards> greenCards = currentPlayer.greenCards();
		ArrayList<Cards> whiteCards = currentPlayer.whiteCards();
		ArrayList<Cards> redCards = currentPlayer.redCards();
		
		int yAdj = 0;
		for(int e=0; e<blackCards.size(); e++){
			if(blackCards.size() == 0){
				break;
			}
			
			g.fillRect(0, 640+yAdj, 80, 20);
			
			g.setColor(Color.BLACK);
			g.fillOval(0, 640+yAdj, 19, 19);
			g.drawLine(0, 640+yAdj, 80, 640+yAdj);
			
			currentFont = g.getFont();
			newFont = currentFont.deriveFont(20F);
			g.setFont(newFont);
			
			g.drawString(blackCards.get(e).getPt()+"", 40+20, 658+yAdj ); 
			
			g.setColor(Color.GRAY);
			
			yAdj += 20;
			
		}
		
		yAdj = 0;
		for(int e=0; e<blueCards.size(); e++){
			if(blueCards.size() == 0){
				break;
			}
			
			g.fillRect(120, 640+yAdj, 80, 20);
			
			g.setColor(Color.BLUE);
			g.fillOval(120, 640+yAdj, 19, 19);
			g.drawLine(120, 640+yAdj, 200, 640+yAdj);
			
			currentFont = g.getFont();
			newFont = currentFont.deriveFont(20F);
			g.setFont(newFont);
			
			g.drawString(blueCards.get(e).getPt()+"", 160+20, 658+yAdj);
			
			g.setColor(Color.GRAY);
			
			yAdj += 20;
			
		}
		
		yAdj = 0;
		for(int e=0; e<greenCards.size(); e++){
			if(greenCards.size() == 0){
				break;
			}
			
			g.fillRect(240, 640+yAdj, 80, 20);
			
			g.setColor(Color.GREEN);
			g.fillOval(240, 640+yAdj, 19, 19);
			g.drawLine(240, 640+yAdj, 320, 640+yAdj);
			
			currentFont = g.getFont();
			newFont = currentFont.deriveFont(20F);
			g.setFont(newFont);
			
			g.drawString(greenCards.get(e).getPt()+"", 240+20, 658+yAdj);
			
			g.setColor(Color.GRAY);
			
			yAdj += 20;
			
		}
		
		yAdj = 0;
		for(int e=0; e<whiteCards.size(); e++){
			if(whiteCards.size() == 0){
				break;
			}
			
			g.fillRect(360, 640+yAdj, 80, 20);
			
			g.setColor(Color.WHITE);
			g.fillOval(360, 640+yAdj, 19, 19);
			g.drawLine(360, 640+yAdj, 440, 640+yAdj);
			
			currentFont = g.getFont();
			newFont = currentFont.deriveFont(20F);
			g.setFont(newFont);
			
			g.drawString(whiteCards.get(e).getPt()+"", 400+20, 658+yAdj);
			
			g.setColor(Color.GRAY);
			
			yAdj += 20;
			
		}
		
		yAdj = 0;
		for(int e=0; e<redCards.size(); e++){
			if(redCards.size() == 0){
				break;
			}
			
			g.fillRect(480, 640+yAdj, 80, 20);
			
			g.setColor(Color.RED);
			g.fillOval(480, 640+yAdj, 19, 19);
			g.drawLine(480, 640+yAdj, 560, 640+yAdj);
			
			currentFont = g.getFont();
			newFont = currentFont.deriveFont(20F);
			g.setFont(newFont);
			
			g.drawString(redCards.get(e).getPt()+"", 520+20, 658+yAdj);
			
			g.setColor(Color.GRAY);
			
			yAdj += 20;
			
		}
		
		
		/*currentFont = g.getFont();
		newFont = currentFont.deriveFont(12F);
		g.setFont(newFont);*/
		
		
		
		
		
		
		
		
		g.setColor(Color.GRAY);
		
		
		int Adj = 40;
		yAdj = 0;
		for(int i = game.getCurrentPlayer()+1; ; i++){
			if(i == game.getPlayers().size()){
				i = 0;
			}
			
			if(i == game.getCurrentPlayer()){
				break;
			}
			
			//System.out.println("WATUP");
			
			Player p = game.getPlayers().get(i);
			
			onyx = p.blackTokens();
			sapphire = p.blueTokens();
			emerald = p.greenTokens();
			diamond = p.whiteTokens();
			rubby = p.redTokens();
			gold = p.yellowTokens();
			
			
			currentFont = g.getFont();
			newFont = currentFont.deriveFont(20F);
			g.setFont(newFont);
			
			
			g.setColor(Color.BLACK);
			g.fillOval(1480, Adj, 19, 19);
			g.drawString("x" + onyx, 1500, Adj+17);
			
			g.setColor(Color.BLUE);
			g.fillOval(1480, Adj+20, 19, 19);
			g.drawString("x" + sapphire, 1500, Adj+37);
			
			g.setColor(Color.GREEN);
			g.fillOval(1480, Adj+40, 19, 19);
			g.drawString("x" + emerald, 1500, Adj+57);
			
			g.setColor(Color.RED);
			g.fillOval(1480, Adj+60, 19, 19);
			g.drawString("x" + rubby, 1500, Adj+77);
			
			g.setColor(Color.WHITE);
			g.fillOval(1480, Adj+80, 19, 19);
			g.drawString("x" + diamond, 1500, Adj+97);
			
			g.setColor(Color.YELLOW);
			g.fillOval(1480, Adj+100, 19, 19);
			g.drawString("x" + gold, 1500, Adj+117);
			
			
			
			g.setColor(Color.GRAY);
			g.drawString(p.getReserve().size() + " cards in reserve.", 1080, Adj+145);
			g.fill3DRect(840, Adj+160, 680, 5, true);
			
			
			
			
			
			
			currentFont = g.getFont();
			newFont = currentFont.deriveFont(28F);
			g.setFont(newFont);
			
			g.drawString(game.getPlayers().get(i).getName() + ": " + game.getPlayers().get(i).getScore() + " Points", 1080, Adj-10);
			
			blackCards = p.blackCards();
			blueCards = p.blueCards();
			greenCards = p.greenCards();
			whiteCards = p.whiteCards();
			redCards = p.redCards();
			
			yAdj = 0;
			for(int e=0; e<blackCards.size(); e++){
				if(blackCards.size() == 0){
					break;
				}
				
				g.fillRect(880, Adj+yAdj, 80, 20);
				
				g.setColor(Color.BLACK);
				g.fillOval(880, Adj+yAdj, 19, 19);
				g.drawLine(880, Adj+yAdj, 960, Adj+yAdj);
				
				currentFont = g.getFont();
				newFont = currentFont.deriveFont(20F);
				g.setFont(newFont);
				
				g.drawString(blackCards.get(e).getPt()+"", 948, 58+yAdj+Adj-40);
				
				g.setColor(Color.GRAY);
				
				yAdj += 20;
				
			}
			
			yAdj = 0;
			for(int e=0; e<blueCards.size(); e++){
				if(blueCards.size() == 0){
					break;
				}
				
				g.fillRect(1000, Adj+yAdj, 80, 20);
				
				g.setColor(Color.BLUE);
				g.fillOval(1000, Adj+yAdj, 19, 19);
				g.drawLine(1000, Adj+yAdj, 1080, Adj+yAdj);
				
				currentFont = g.getFont();
				newFont = currentFont.deriveFont(20F);
				g.setFont(newFont);
				
				g.drawString(blueCards.get(e).getPt()+"", 1068, 58+yAdj+Adj-40);
				
				g.setColor(Color.GRAY);
				
				yAdj += 20;
				
			}
			
			yAdj = 0;
			for(int e=0; e<greenCards.size(); e++){
				if(greenCards.size() == 0){
					break;
				}
				
				g.fillRect(1120, Adj+yAdj, 80, 20);
				
				g.setColor(Color.GREEN);
				g.fillOval(1120, Adj+yAdj, 19, 19);
				g.drawLine(1120, Adj+yAdj, 1200, Adj+yAdj);
				
				currentFont = g.getFont();
				newFont = currentFont.deriveFont(20F);
				g.setFont(newFont);
				
				g.drawString(greenCards.get(e).getPt()+"", 1188, 58+yAdj+Adj-40);
				
				g.setColor(Color.GRAY);
				
				yAdj += 20;
				
			}
			
			yAdj = 0;
			for(int e=0; e<whiteCards.size(); e++){
				if(whiteCards.size() == 0){
					break;
				}
				
				g.fillRect(1240, Adj+yAdj, 80, 20);
				
				g.setColor(Color.WHITE);
				g.fillOval(1240, Adj+yAdj, 19, 19);
				g.drawLine(1240, Adj+yAdj, 1320, Adj+yAdj);
				
				currentFont = g.getFont();
				newFont = currentFont.deriveFont(20F);
				g.setFont(newFont);
				
				g.drawString(whiteCards.get(e).getPt()+"", 1308, 58+yAdj+Adj-40);
				
				g.setColor(Color.GRAY);
				
				yAdj += 20;
				
			}
			
			yAdj = 0;
			for(int e=0; e<redCards.size(); e++){
				if(redCards.size() == 0){
					break;
				}
				
				g.fillRect(1360, Adj+yAdj, 80, 20);
				
				g.setColor(Color.RED);
				g.fillOval(1360, Adj+yAdj, 19, 19);
				g.drawLine(1360, Adj+yAdj, 1440, Adj+yAdj);
				
				currentFont = g.getFont();
				newFont = currentFont.deriveFont(20F);
				g.setFont(newFont);
				
				g.drawString(redCards.get(e).getPt()+"", 1428, 58+yAdj+Adj-40);
				
				g.setColor(Color.GRAY);
				
				yAdj += 20;
				
			}
			
			currentFont = g.getFont();
			newFont = currentFont.deriveFont(28F);
			g.setFont(newFont);
			
			
			
			
			
			
			
			Adj += 200;
			
			
		}
		
		
		currentFont = g.getFont();
		newFont = currentFont.deriveFont(currentFont.getSize() * 3F);
		g.setFont(newFont);
		
		//System.out.println(game.win());
		
		
		
		game.win();
		if(!game.getWinner().isEmpty() && game.getCurrentPlayer() == game.getStartingPlayer()){
			Player actualWinner = game.getWinner().get(0);
			boolean tie = game.getWinner().size() > 1;
			
			for(int j=1; j<game.getWinner().size(); j++){
				if(game.getWinner().get(j).getCards().size() < actualWinner.getCards().size()){
					actualWinner = game.getWinner().get(j);
					tie = false;
				}
			}
			
			if(!tie){
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				super.paintComponent(g);
				
				System.out.println("WORKING");
				
				g.setColor(new Color((int)(Math.random()*255), (int)(Math.random()*255), (int)(Math.random()*255)));
				g.drawString("CONGRATULATIONS   TO", 290, 160);
				g.drawString(/*game.getWinner().get(0).getName()*/game.getPlayers().get(0).getName() + " !!", 600, 320);
				g.drawString("You Won!!!", 575, 520);
				
				
				repaint();
				
				
				
			}
		}
		

		
		
		
	}
	
	public int tokenCounts(Tokens token, ArrayList<Tokens> t)
	{
		int count = 0;
		
		if(token.equals(new Tokens("Onyx"))){
			for(int i=0; i<t.size(); i++){
				if(t.get(i).equals(new Tokens("Onyx"))){
					count++;
				}
			}
		}else if(token.equals(new Tokens("Rubby"))){
			for(int i=0; i<t.size(); i++){
				if(t.get(i).equals(new Tokens("Rubby"))){
					count++;
				}
			}
		}else if(token.equals(new Tokens("Emerald"))){
			for(int i=0; i<t.size(); i++){
				if(t.get(i).equals(new Tokens("Emerald"))){
					count++;
				}
			}
		}else if(token.equals(new Tokens("Diamond"))){
			for(int i=0; i<t.size(); i++){
				if(t.get(i).equals(new Tokens("Diamond"))){
					count++;
				}
			}
		}else if(token.equals(new Tokens("Sapphire"))){
			for(int i=0; i<t.size(); i++){
				if(t.get(i).equals(new Tokens("Sapphire"))){
					count++;
				}
			}
		}else if(token.equals(new Tokens("Gold"))){
			for(int i=0; i<t.size(); i++){
				if(t.get(i).equals(new Tokens("Gold"))){
					count++;
				}
			}
		}
		
		return count;
	}
	
	public void mousePressed(MouseEvent e)
	{	}
	
	public void mouseReleased(MouseEvent e)
	{	
		
	}
	
	public void mouseClicked(MouseEvent e)
	{	
		// get the x and y where the mouse was clicked
		
		//System.out.println(game.getPlayers().get((game.getCurrentPlayer())).getName());
		
		//e.consume();
		
		int x;
		int y;
		
		if(game.getPlayers().get(game.getCurrentPlayer()).tooMuchTokens()){
			if(e.getClickCount() == 2 && !e.isConsumed()){
				e.consume();
				
				x = e.getX();
				y = e.getY();
				
				System.out.println(x + " " + y + "Hola");
				
				if(x >= 600 && x <= 680 && y >= 640 && y <= 659){
					try {
						game.getPlayers().get(game.getCurrentPlayer()).discardToken(new Tokens("Onyx"), game);
					} catch (InvalidTokensSelection e1) {
						repaint();
					}
				}else if(x >= 600 && x <= 680 && y >= 660 && y <= 679){
					try {
						game.getPlayers().get(game.getCurrentPlayer()).discardToken(new Tokens("Sapphire"), game);
					} catch (InvalidTokensSelection e1) {
						// TODO Auto-generated catch block
						repaint();
					}
				}else if(x >= 600 && x <= 680 && y >= 679 && y <= 699){
					try {
						game.getPlayers().get(game.getCurrentPlayer()).discardToken(new Tokens("Emerald"), game);
					} catch (InvalidTokensSelection e1) {
						// TODO Auto-generated catch block
						repaint();
					}
				}else if(x >= 600 && x <= 680 && y >= 699 && y <= 719){
					try {
						game.getPlayers().get(game.getCurrentPlayer()).discardToken(new Tokens("Rubby"), game);
					} catch (InvalidTokensSelection e1) {
						// TODO Auto-generated catch block
						repaint();
					}
				}else if(x >= 600 && x <= 680 && y >= 719 && y <= 739){
					try {
						game.getPlayers().get(game.getCurrentPlayer()).discardToken(new Tokens("Diamond"), game);
					} catch (InvalidTokensSelection e1) {
						// TODO Auto-generated catch block
						repaint();
					}
				}else if(x >= 600 && x <= 680 && y >= 739 && y <= 679){
					try {
						game.getPlayers().get(game.getCurrentPlayer()).discardToken(new Tokens("Gold"), game);
					} catch (InvalidTokensSelection e1) {
						// TODO Auto-generated catch block
						repaint();
					}
				}
				
				
				
	
				
			}
		}
		
		
		
		
		if(e.getButton() == e.BUTTON3){
			e.consume();

			x = e.getX();
			y = e.getY();
			System.out.println(x + " " + y);

			if(x >= 40 && x <= 120 && y > 160 && y < 200){
				t.add(new Tokens("Onyx"));
				//System.out.println(t);
				repaint();
			}else if(x >= 40 && x <= 120 && y > 240 && y < 280){
				t.add(new Tokens("Sapphire"));
				//System.out.println(t);
				repaint();
			}else if(x >= 40 && x <= 120 && y > 320 && y < 360){
				t.add(new Tokens("Emerald"));
				//System.out.println(t);
				repaint();
			}else if(x >= 40 && x <= 120 && y > 400 && y < 440){
				t.add(new Tokens("Diamond"));
				repaint();
			}else if(x >= 40 && x <= 120 && y > 480 && y < 520){
				t.add(new Tokens("Rubby"));
				repaint();
			}
			
			if(t.size() == 3 && allDifferent(t)){
				try {
					game.getPlayers().get(game.getCurrentPlayer()).getOneOfEachTokens(t.get(0), t.get(1), t.get(2), game);
					t.clear();
				} catch (NotEnoughTokensOnTable e1) {
					repaint();
				}
			}else if(t.size() >= 3 && !allDifferent(t)){
				t.clear();
			}
		}
		
		
		
		
		
		
		
		
		
		
		
		
		if(e.getClickCount() == 2 && !e.isConsumed() && !game.getPlayers().get(game.getCurrentPlayer()).tooMuchTokens()){
			
		     e.consume();
		     x = e.getX();
			 y = e.getY();
			 
			 System.out.println(x + " " + y + " " + "hi");
			 
			 ArrayList<Cards> cc = game.getPlayers().get(game.getCurrentPlayer()).getCards();
			 
			 if(x >= 40 && x <= 120 && y > 160 && y < 200){
				 try {
					game.getPlayers().get(game.getCurrentPlayer()).getTwoTokens(new Tokens("Onyx"), game);
				} catch (NotEnoughTokensOnTable e1) {
					// TODO Auto-generated catch block
					System.out.println(e1.getStackTrace());
					repaint();
				}
			 }else if(x >= 40 && x <= 120 && y > 240 && y < 280){
				 try {
					game.getPlayers().get(game.getCurrentPlayer()).getTwoTokens(new Tokens("Sapphire"), game);
				} catch (NotEnoughTokensOnTable e1) {
					// TODO Auto-generated catch block
					repaint();
				}
			 }else if(x >= 40 && x <= 120 && y > 320 && y < 360){
				 try {
					game.getPlayers().get(game.getCurrentPlayer()).getTwoTokens(new Tokens("Emerald"), game);
				} catch (NotEnoughTokensOnTable e1) {
					// TODO Auto-generated catch block
					repaint();
				}
			 }else if(x >= 40 && x <= 120 && y > 400 && y < 440){
				 try {
					game.getPlayers().get(game.getCurrentPlayer()).getTwoTokens(new Tokens("Diamond"), game);
				} catch (NotEnoughTokensOnTable e1) {
					// TODO Auto-generated catch block
					repaint();
				}
			 }else if(x >= 40 && x <= 120 && y > 480 && y < 520){
				 try {
					game.getPlayers().get(game.getCurrentPlayer()).getTwoTokens(new Tokens("Rubby"), game);
				} catch (NotEnoughTokensOnTable e1) {
					// TODO Auto-generated catch block
					repaint();
				}
			 }
			 
			 //e.consume();
			 
			 if(x <= 40 && y <= 40){
				 ArrayList<Cards> c = new ArrayList<Cards>(cc);
				 c.add(new Cards("Onyx"));
				 c.add(new Cards("Sapphire"));
				 c.add(new Cards("Emerald"));
				 c.add(new Cards("Diamond"));
				 c.add(new Cards("Rubby"));
				 
				 
				 
				 game.getPlayers().get(game.getCurrentPlayer()).setCards(c);
				 
				 repaint();
			 }
			 
			 
			 if(x >= 1560 && y >= 760){
				 System.out.println(x + " " + y + " " + "ho");
				 for(int i=0; i<game.getPlayers().size(); i++){
					 cc = new ArrayList<Cards>(game.getPlayers().get(i).getCards());
					 cc.add(new Cards("Onyx"));
					 cc.add(new Cards("Sapphire"));
					 cc.add(new Cards("Emerald"));
					 cc.add(new Cards("Diamond"));
					 cc.add(new Cards("Rubby"));
					 
					 game.getPlayers().get(i).setCards(cc);
					 
					 //System.out.println(game.getPlayers().get(i).getCards());
					 
					 
				 }
				 
				 repaint();
			 }
			 
			 if(x > 320 && x < 400){
				 if(y < 218 && y > 160){
					try {
						game.getPlayers().get(game.getCurrentPlayer()).reserveCard(1, 1, game);
						repaint();
					} catch (InvalidCardsSelectionOfCardsOnTable
							| PlayerAlreadyHoldsThreeReserveCards e1) {
						// TODO Auto-generated catch block

						repaint();
					}
					
				 }else if(y > 218 && y < 280){
					 try {
						game.getPlayers().get(game.getCurrentPlayer()).buyCardOnTable(1, 1, game);
						repaint();
					} catch (PlayerDoesNotHaveEnoughResourcesToBuySelectedCard
							| InvalidCardsSelectionOfCardsInReserve
							| InvalidCardsSelectionOfCardsOnTable e1) {
						// TODO Auto-generated catch block

						repaint();
					}
				 }
				 
				 
				 
				 else if(y > 320 && y < 378 ){
					 try {
						game.getPlayers().get(game.getCurrentPlayer()).reserveCard(2, 1, game);
						repaint();
					} catch (InvalidCardsSelectionOfCardsOnTable
							| PlayerAlreadyHoldsThreeReserveCards e1) {
						// TODO Auto-generated catch block

						repaint();
					}
				 }else if(y > 378 && y < 440){
					 try {
						game.getPlayers().get(game.getCurrentPlayer()).buyCardOnTable(2, 1, game);
						repaint();
					} catch (PlayerDoesNotHaveEnoughResourcesToBuySelectedCard
							| InvalidCardsSelectionOfCardsInReserve
							| InvalidCardsSelectionOfCardsOnTable e1) {
						// TODO Auto-generated catch block

						repaint();
					}
				 }
				 
				 
				 
				 else if(y > 480 && y < 538){
					 try {
						game.getPlayers().get(game.getCurrentPlayer()).reserveCard(3, 1, game);
						repaint();
					} catch (InvalidCardsSelectionOfCardsOnTable
							| PlayerAlreadyHoldsThreeReserveCards e1) {
						// TODO Auto-generated catch block

						repaint();
					}
				 }else if(y > 538 && y < 600){
					 try {
						game.getPlayers().get(game.getCurrentPlayer()).buyCardOnTable(3, 1, game);
						repaint();
					} catch (PlayerDoesNotHaveEnoughResourcesToBuySelectedCard
							| InvalidCardsSelectionOfCardsInReserve
							| InvalidCardsSelectionOfCardsOnTable e1) {
						// TODO Auto-generated catch block
						
						System.out.println(e1);
						
						repaint();
						
					}
				 }
			 }
			 
			 
			 if(x > 440 && x < 520){
				 if(y < 218 && y > 160){
						try {
							game.getPlayers().get(game.getCurrentPlayer()).reserveCard(1, 2, game);
							repaint();
						} catch (InvalidCardsSelectionOfCardsOnTable
								| PlayerAlreadyHoldsThreeReserveCards e1) {
							// TODO Auto-generated catch block

							repaint();
						}
						
					 }else if(y > 218 && y < 280){
						 try {
							game.getPlayers().get(game.getCurrentPlayer()).buyCardOnTable(1, 2, game);
							repaint();
						} catch (PlayerDoesNotHaveEnoughResourcesToBuySelectedCard
								| InvalidCardsSelectionOfCardsInReserve
								| InvalidCardsSelectionOfCardsOnTable e1) {
							// TODO Auto-generated catch block

							repaint();
						}
					 }
					 
					 
					 
					 else if(y > 320 && y < 378 ){
						 try {
							game.getPlayers().get(game.getCurrentPlayer()).reserveCard(2, 2, game);
							repaint();
						} catch (InvalidCardsSelectionOfCardsOnTable
								| PlayerAlreadyHoldsThreeReserveCards e1) {
							// TODO Auto-generated catch block

							repaint();
						}
					 }else if(y > 378 && y < 440){
						 try {
							game.getPlayers().get(game.getCurrentPlayer()).buyCardOnTable(2, 2, game);
							repaint();
						} catch (PlayerDoesNotHaveEnoughResourcesToBuySelectedCard
								| InvalidCardsSelectionOfCardsInReserve
								| InvalidCardsSelectionOfCardsOnTable e1) {
							// TODO Auto-generated catch block

							repaint();
						}
					 }
					 
					 
					 
					 else if(y > 480 && y < 538){
						 try {
							game.getPlayers().get(game.getCurrentPlayer()).reserveCard(3, 2, game);
							repaint();
						} catch (InvalidCardsSelectionOfCardsOnTable
								| PlayerAlreadyHoldsThreeReserveCards e1) {
							// TODO Auto-generated catch block

							repaint();
						}
					 }else if(y > 538 && y < 600){
						 try {
							game.getPlayers().get(game.getCurrentPlayer()).buyCardOnTable(3, 2, game);
							repaint();
						} catch (PlayerDoesNotHaveEnoughResourcesToBuySelectedCard
								| InvalidCardsSelectionOfCardsInReserve
								| InvalidCardsSelectionOfCardsOnTable e1) {
							// TODO Auto-generated catch block
							
							System.out.println(e1);
							
							repaint();
						}
					 }
			 }
			 
			 if(x > 560 && x < 640){
				 if(y < 218 && y > 160){
						try {
							game.getPlayers().get(game.getCurrentPlayer()).reserveCard(1, 3, game);
							repaint();
						} catch (InvalidCardsSelectionOfCardsOnTable
								| PlayerAlreadyHoldsThreeReserveCards e1) {
							// TODO Auto-generated catch block

							repaint();
						}
						
					 }else if(y > 218 && y < 280){
						 try {
							game.getPlayers().get(game.getCurrentPlayer()).buyCardOnTable(1, 3, game);
							repaint();
						} catch (PlayerDoesNotHaveEnoughResourcesToBuySelectedCard
								| InvalidCardsSelectionOfCardsInReserve
								| InvalidCardsSelectionOfCardsOnTable e1) {
							// TODO Auto-generated catch block

							repaint();
						}
					 }
					 
					 
					 
					 else if(y > 320 && y < 378 ){
						 try {
							game.getPlayers().get(game.getCurrentPlayer()).reserveCard(2, 3, game);
							repaint();
						} catch (InvalidCardsSelectionOfCardsOnTable
								| PlayerAlreadyHoldsThreeReserveCards e1) {
							// TODO Auto-generated catch block

							repaint();
						}
					 }else if(y > 378 && y < 440){
						 try {
							game.getPlayers().get(game.getCurrentPlayer()).buyCardOnTable(2, 3, game);
							repaint();
						} catch (PlayerDoesNotHaveEnoughResourcesToBuySelectedCard
								| InvalidCardsSelectionOfCardsInReserve
								| InvalidCardsSelectionOfCardsOnTable e1) {
							// TODO Auto-generated catch block

							repaint();
						}
					 }
					 
					 
					 
					 else if(y > 480 && y < 538){
						 try {
							game.getPlayers().get(game.getCurrentPlayer()).reserveCard(3, 3, game);
							repaint();
						} catch (InvalidCardsSelectionOfCardsOnTable
								| PlayerAlreadyHoldsThreeReserveCards e1) {
							// TODO Auto-generated catch block

							repaint();
						}
					 }else if(y > 538 && y < 600){
						 try {
							game.getPlayers().get(game.getCurrentPlayer()).buyCardOnTable(3, 3, game);
							repaint();
						} catch (PlayerDoesNotHaveEnoughResourcesToBuySelectedCard
								| InvalidCardsSelectionOfCardsInReserve
								| InvalidCardsSelectionOfCardsOnTable e1) {
							// TODO Auto-generated catch block
							
							System.out.println(e1);
							
							repaint();
						}
					 }
			 }
			 
			 if(x > 680 && x < 760){
				 if(y < 218 && y > 160){
						try {
							game.getPlayers().get(game.getCurrentPlayer()).reserveCard(1, 4, game);
							repaint();
						} catch (InvalidCardsSelectionOfCardsOnTable
								| PlayerAlreadyHoldsThreeReserveCards e1) {
							// TODO Auto-generated catch block

							repaint();
						}
						
					 }else if(y > 218 && y < 280){
						 try {
							game.getPlayers().get(game.getCurrentPlayer()).buyCardOnTable(1, 4, game);
							repaint();
						} catch (PlayerDoesNotHaveEnoughResourcesToBuySelectedCard
								| InvalidCardsSelectionOfCardsInReserve
								| InvalidCardsSelectionOfCardsOnTable e1) {
							// TODO Auto-generated catch block

							repaint();
						}
					 }
					 
					 
					 
					 else if(y > 320 && y < 378 ){
						 try {
							game.getPlayers().get(game.getCurrentPlayer()).reserveCard(2, 4, game);
							repaint();
						} catch (InvalidCardsSelectionOfCardsOnTable
								| PlayerAlreadyHoldsThreeReserveCards e1) {
							// TODO Auto-generated catch block

							repaint();
						}
					 }else if(y > 378 && y < 440){
						 try {
							game.getPlayers().get(game.getCurrentPlayer()).buyCardOnTable(2, 4, game);
							repaint();
						} catch (PlayerDoesNotHaveEnoughResourcesToBuySelectedCard
								| InvalidCardsSelectionOfCardsInReserve
								| InvalidCardsSelectionOfCardsOnTable e1) {
							// TODO Auto-generated catch block

							repaint();
						}
					 }
					 
					 
					 
					 else if(y > 480 && y < 538){
						 try {
							game.getPlayers().get(game.getCurrentPlayer()).reserveCard(3, 4, game);
							repaint();
						} catch (InvalidCardsSelectionOfCardsOnTable
								| PlayerAlreadyHoldsThreeReserveCards e1) {
							// TODO Auto-generated catch block

							repaint();
						}
					 }else if(y > 538 && y < 600){
						 try {
							game.getPlayers().get(game.getCurrentPlayer()).buyCardOnTable(3, 4, game);
							repaint();
						} catch (PlayerDoesNotHaveEnoughResourcesToBuySelectedCard
								| InvalidCardsSelectionOfCardsInReserve
								| InvalidCardsSelectionOfCardsOnTable e1) {
							// TODO Auto-generated catch block
							
							System.out.println(e1);
							
							repaint();
						}
					 }
			 }
			 
			 
			 if(y >= 680){
				 if(game.getPlayers().get(game.getCurrentPlayer()).getReserve().size() >= 1 && x >= 680 && x <= 760){
					 try {
						game.getPlayers().get(game.getCurrentPlayer()).placeCardFromReserve(game.getPlayers().get(game.getCurrentPlayer()).getReserve().get(0), game);
					} catch (PlayerDoesNotHaveEnoughResourcesToBuySelectedCard
							| PlayerDoesNotHaveSelectedCardInReserve e1) {
						// TODO Auto-generated catch block
						repaint();
					}
				 }else if(game.getPlayers().get(game.getCurrentPlayer()).getReserve().size() >= 2 && x >= 800 && x <= 880){
					 try {
						game.getPlayers().get(game.getCurrentPlayer()).placeCardFromReserve(game.getPlayers().get(game.getCurrentPlayer()).getReserve().get(1), game);
					} catch (PlayerDoesNotHaveEnoughResourcesToBuySelectedCard
							| PlayerDoesNotHaveSelectedCardInReserve e1) {
						// TODO Auto-generated catch block
						repaint();
					}
				 }else if(game.getPlayers().get(game.getCurrentPlayer()).getReserve().size() >= 3 && x >= 920 && x <= 1000){
					 try {
						game.getPlayers().get(game.getCurrentPlayer()).placeCardFromReserve(game.getPlayers().get(game.getCurrentPlayer()).getReserve().get(2), game);
					} catch (PlayerDoesNotHaveEnoughResourcesToBuySelectedCard
							| PlayerDoesNotHaveSelectedCardInReserve e1) {
						// TODO Auto-generated catch block
						repaint();
					}
				 }
			 }
			 
			 if(x > 160 && x < 240){
				 if(y > 160 && y < 280){
					 try {
						game.getPlayers().get(game.getCurrentPlayer()).reserveCard("blue", game);
					} catch (SelectedDeckRanOutOfCards e1) {
						// TODO Auto-generated catch block
						repaint();
					}
				 }else if(y > 320 && y < 440){
					 try {
						game.getPlayers().get(game.getCurrentPlayer()).reserveCard("yellow", game);
					} catch (SelectedDeckRanOutOfCards e1) {
						// TODO Auto-generated catch block
						repaint();
					}
				 }else if(y > 480 && y < 600){
					 try {
						game.getPlayers().get(game.getCurrentPlayer()).reserveCard("green", game);
					} catch (SelectedDeckRanOutOfCards e1) {
						// TODO Auto-generated catch block
						repaint();
					}
				 }
			 }
		     
			 
			 //handle double click event.
		}
		
		
		
		
		repaint();
		
	
	}
	
	
	
	public void mouseEntered(MouseEvent e)
	{	}
	
	public void mouseExited(MouseEvent e)
	{	}
	
	public boolean allDifferent(ArrayList<Tokens> t)
	{
		boolean r = true;
		
		for(int i=0; i<t.size()-1; i++){
			if(t.get(i).equals(t.get(i+1))){
				r = false;
			}
		}
		
		return r;
	}
}