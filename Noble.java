import java.util.ArrayList;

public class Noble 
{
	private String name;
	private final int pt = 3;
	private ArrayList<Tokens> cost;
	private Player owner;
	
	public Noble(String name, ArrayList<Tokens> cost) {
		super();
		this.name = name;
		this.cost = cost;
	}

	public Player getOwner() {
		return owner;
	}

	public void setOwner(Player owner) {
		this.owner = owner;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPt() {
		return pt;
	}

	public ArrayList<Tokens> getCost() {
		return cost;
	}

	public void setCost(ArrayList<Tokens> cost) {
		this.cost = cost;
	}
	
	public int whiteCost()
	{
		int r = 0;
		for(int i=0; i<cost.size(); i++){
			if(cost.get(i).toString().equals("Diamond"))
				r++;
		}
		
		return r;
	}
	
	public int greenCost()
	{
		int r = 0;
		for(int i=0; i<cost.size(); i++){
			if(cost.get(i).toString().equals("Emerald"))
				r++;
		}
		
		return r;
	}
	
	public int blueCost()
	{
		int r = 0;
		for(int i=0; i<cost.size(); i++){
			if(cost.get(i).toString().equals("Sapphire"))
				r++;
		}
		
		return r;
	}
	
	public int blackCost()
	{
		int r = 0;
		for(int i=0; i<cost.size(); i++){
			if(cost.get(i).toString().equals("Onyx"))
				r++;
		}
		
		return r;
	}
	
	public int redCost()
	{
		int r = 0;
		for(int i=0; i<cost.size(); i++){
			if(cost.get(i).toString().equals("Rubby"))
				r++;
		}
		
		
		return r;
	}
	
	public String toString()
	{
		String r = "";
		r = r + "******* " + name + "*******" + "\n"; // 5 starss on both side
		
		int whiteCost = whiteCost();
		int redCost = redCost();
		int greenCost = greenCost();
		int blackCost = blackCost();
		int blueCost = blueCost();
		
	
		if(whiteCost != 0){
			r += "   Diamond x" + whiteCost + " ";
		}
		
		if(redCost != 0){
			r += "   Rubby x" + redCost + " ";
		}
		
		if(greenCost != 0){
			r += "   Emerald x" + greenCost + " ";
		}
		
		if(blackCost != 0){
			r += "   Onyx x" + blackCost + " ";
		}
		
		if(blueCost != 0){
			r += "   Sapphire x" + blueCost + " ";
		}
		
		r = r + "\n";
		
		return r;
		
	}

}
