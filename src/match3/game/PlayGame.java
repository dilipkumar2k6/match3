package match3.game;
/**
 * This class is having steps to play Match3 game. It takes care of initialization of grid, find out match, print input array, match and result.
 * @author Dilip Kumar
 * @since 24-Dec-2013
 *
 */
public class PlayGame {

	/**
	 * Play match3 game.
	 */
	public void play(int height, int width, int numberOfBlockTypes)
	{
		//Create Specification object
		Specification gameSpecification = new Specification(height, width, numberOfBlockTypes);		
		//Create Grid object
		Grid grid = new Grid(gameSpecification);
		grid.initializeGridRandomly();
		//Apply Algorithm to find out matches
		grid.applyMatchOptimized();
		//Print Input Grid
		grid.printInputGrid();
		//Print match result
		grid.matches.printAllMatches();
		//Print Result
		grid.printResultGrid();
	}
	
	public void playWithSampleData()
	{
		int height = 5;
		int width = 5;
		int numberOfBlockTypes =3;
		//Create Specification object
		Specification gameSpecification = new Specification(height, width, numberOfBlockTypes);		
		//Create Grid object
		Grid grid = new Grid(gameSpecification);
		grid.initializeGridAsPerSampleData();
		//Apply Algorithm to find out matches
		grid.applyMatchOptimized();
		//Print Input Grid
		grid.printInputGrid();
		//Print match result
		grid.matches.printAllMatches();
		//Print Result
		grid.printResultGrid();
	}
	
}
