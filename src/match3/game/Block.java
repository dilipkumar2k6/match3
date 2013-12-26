package match3.game;

/**
 * This class represent each block of grid sytem. This is having basic properties to block for each processing.
 * @author Dilip Kumar
 * @since 24-Dec-2013
 *
 */
public class Block implements Comparable{

	//Value of block	
	private int i;
	private int j;
	private int value;
	private boolean selectedForMatch;

	//Constructor
	public Block(int i, int j, int value)
	{
		this.i = i;
		this.j = j;
		this.value = value;
	}
	
	//Ovveride toString() method to print block data in user friendly.
	public String toString()
	{
		StringBuffer sb = new StringBuffer();
		sb.append("i = ");
		sb.append(i);
		sb.append(", j= ");
		sb.append(j);
		sb.append(", value = ");
		sb.append(value);
		return sb.toString();
	}
	
	//Get location of block in Grid
	public String getLocation()
	{
		StringBuffer sb = new StringBuffer();
		sb.append("{");
		sb.append(i);
		sb.append(",");
		sb.append(j);
		sb.append("}");		
		return sb.toString();
	}

	//Get co-ordinate of block in Grid. This is reverse of block location
	public String getCoOrdinate()
	{
		StringBuffer sb = new StringBuffer();
		sb.append("{");
		sb.append(j);
		sb.append(",");
		sb.append(i);
		sb.append("}");		
		return sb.toString();
	}
		
	@Override
	public int compareTo(Object o) {
		
		Block block = (Block)o;
		if(this.value ==block.getValue() )
		{
			return 0;
		}
		else if (this.value > block.getValue() )
		{
			return 1;			
		}
		else
		{
			return -1;
		}
		
		 
	}
	
	
	public int getI() {
		return i;
	}

	public void setI(int i) {
		this.i = i;
	}

	public int getJ() {
		return j;
	}

	public void setJ(int j) {
		this.j = j;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public boolean isSelectedForMatch() {
		return selectedForMatch;
	}

	public void setSelectedForMatch(boolean selectedForMatch) {
		this.selectedForMatch = selectedForMatch;
	}
	
	
	
}
