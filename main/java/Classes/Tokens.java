package Classes;

import java.awt.Color;


public class Tokens implements Comparable
{
	private String color;

	public Tokens(String color) {
		super();
		this.color = color;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}
	
	public Color returnColor()
	{
		if(color.equalsIgnoreCase("Onyx")){
			return Color.BLACK;
		}else if(color.equalsIgnoreCase("Emerald")){
			return Color.GREEN;
		}else if(color.equalsIgnoreCase("Diamond")){
			return Color.WHITE;
		}else if(color.equalsIgnoreCase("Rubby")){
			return Color.RED;
		}else if(color.equalsIgnoreCase("Sapphire")){
			return Color.BLUE;
		}else{
			return Color.yellow;
		}
	}
	
	public String toString()
	{
		return color;
	}
	
	public boolean equals(Object o)
	{
		Tokens t = (Tokens)o;
		return color.trim().equalsIgnoreCase(t.getColor().trim());
	}
	
	public int compareTo(Object o)
	{
		Tokens t = (Tokens)o;
		return color.compareTo(t.getColor());
	}


}
