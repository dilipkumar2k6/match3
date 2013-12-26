package match3.game;

import java.util.ArrayList;
import java.util.List;

/**
 * This object represnts the Match of math3 game. It has all property and methods to represent match result. 
 * @author Dilip Kumar
 * @since 24-Dec-2013
 *
 */
public class Match implements Comparable{

	//Matched block
	private List <Block> selectedBlocks;

	
	
	public void printMatch()
	{
		if(selectedBlocks !=null && selectedBlocks.size() > 0)
		{
			System.out.print("Match "+selectedBlocks.size()+": ");
			for(Block block : selectedBlocks)
			{
				System.out.print(block.getCoOrdinate());
				System.out.print("	");
			}
			System.out.println();
		}
	}
	
	
	public List<Block> getSelectedBlocks() {
		return selectedBlocks;
	}

	public void addBlock(Block block)
	{
		if(selectedBlocks ==null)
		{
			selectedBlocks = new ArrayList<Block>();
		}
		//Add block into list
		selectedBlocks.add(block);
	}


	
	/**
	 * Compare two Match objects based on the size of Match object. It will be used to sort Matches object in descending order.
	 * @param o
	 * @return
	 */
	@Override
	public int compareTo(Object o) {
		Match newMatch= (Match)o;
		if(selectedBlocks != null && newMatch.getSelectedBlocks() !=null)
		{
			if(selectedBlocks.size() > newMatch.getSelectedBlocks().size())
			{
				return -1; //This default rule is changed to sort matches in descending order.
			}
			else if(selectedBlocks.size() < newMatch.getSelectedBlocks().size())
			{
				return 1; //This default rule is changed to sort matches in descending order.
			}
		}
		return 0;
	}
	
	
	
}
