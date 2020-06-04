import java.util.ArrayList;

public class Cards implements Comparable
{
	private int pt;
	private ArrayList<Tokens> cost;
	private Tokens resource;
	private String name;
	
	public Cards(int pt, ArrayList<Tokens> cost, String name, Tokens resource)
	{
		this.pt = pt;
		this.cost = cost;
		this.name = name;
		this.resource = resource;
	}
	
	public Cards(String resource)
	{
		this.resource = new Tokens(resource);
		pt = 0;
		cost = new ArrayList<Tokens>();
		name = "HACK";
	}
	
	public Tokens getResource() {
		return resource;
	}

	public void setResource(Tokens token) {
		resource = token;
	}

	public int getPt() {
		return pt;
	}

	public void setPt(int pt) {
		this.pt = pt;
	}

	public ArrayList<Tokens> getCost() {
		return cost;
	}

	public void setCost(ArrayList<Tokens> cost) {
		this.cost = cost;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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
		r = r + pt + "     " + resource + "  " + name + "\n";
		
		int whiteCost = whiteCost();
		int redCost = redCost();
		int greenCost = greenCost();
		int blackCost = blackCost();
		int blueCost = blueCost();
		
		if(whiteCost != 0){
			r = r + "Diamond x" + whiteCost + " ";
		}
		
		if(redCost != 0){
			r = r + "Rubby x" + redCost + " ";
		}
		
		if(greenCost != 0){
			r = r + "Emerald x" + greenCost + " ";
		}
		
		if(blackCost != 0){
			r = r + "Onyx x" + blackCost + " ";
		}
		
		if(blueCost != 0){
			r = r+ "Sapphire x" + blueCost + " ";
		}
		
		r = r + "\n";
		
		return r;
	}
	
	
	
	public int compareTo(Object o)
	{
		Cards c = (Cards)o;
		if(c.getResource() != resource){
			if(c.getName() != name){
				return pt - c.getPt();
			}else{
				return name.compareTo(c.getName());
			}
		}else{
			return resource.compareTo(c.getResource());
		}
	}

}
