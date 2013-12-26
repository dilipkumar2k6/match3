package tests.game;

import match3.game.Block;
import match3.game.Grid;
import match3.game.Specification;

public class GridTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//Sepcifiction of Grid
		Specification specification = new Specification(5, 5, 5);
		//Create Grid
		Grid grid = new Grid(specification);
		//Create random grid 
		grid.initializeGridRandomly();
		//Print Grid
		grid.printInputGrid();
		System.out.println("---------------------");
		Block block = grid.getGrid()[0][3];
		block.setSelectedForMatch(true);
		
		grid.printResultGrid();
		
	}

}
