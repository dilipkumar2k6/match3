package tests.game;

import match3.game.Block;
import match3.game.Match;
import match3.game.Matches;

public class MatchesTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Matches matches = new Matches();
		//Create match object
		Match match = new Match();
		match.addBlock(new Block(2, 1, 4));
		match.addBlock(new Block(1, 1, 4));
		match.addBlock(new Block(1, 2, 4));
		
		
		matches.addMatche(match);
		
		//Create match object
		match = new Match();
		match.addBlock(new Block(0, 0, 5));
		match.addBlock(new Block(1, 1, 6));
		match.addBlock(new Block(2, 2, 9));
		
		
		matches.addMatche(match);
		matches.printAllMatches();
		
	}

}
