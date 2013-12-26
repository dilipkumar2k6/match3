package match3.game;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * This class represent the all matches as per result of match3 game.
 * 
 * @author Dilip Kumar
 * @since 24-Dec-2013
 * 
 */
public class Matches {

	private List<Match> allMatches;

	/**
	 * Print All matches.
	 */
	public void printAllMatches() {
		System.out.println("\nMatch Results:");
		if (allMatches != null && allMatches.size() > 0) {

			for (Match match : allMatches) {
				if(match.getSelectedBlocks() !=null && match.getSelectedBlocks().size() > 2)
				{
					match.printMatch();
				}
			}
		}
		else
		{
			System.out.println("Sorry!! No matches found.");
		}
	}
	
	/**
	 * Sort matches as per size of match in descending order.
	 */
	public void sortMatches()
	{
		Collections.sort(allMatches);
	}
	
	public void removeUnusedBlocks()
	{
		//iterate each match
		if(allMatches !=null && allMatches.size() > 0)
		{
			for(int i = 0; i < allMatches.size() ; i++)
			{
				Match match = allMatches.get(i);
				//Get list of matches matching with Block value
			}
			
		}
	}
	
	public List<Match> getAllMatches() {
		return allMatches;
	}

	public void addMatche(Match match) {

		if (allMatches == null) {
			allMatches = new ArrayList<Match>();
		}
		// Add block into list
		allMatches.add(match);
	}

}
