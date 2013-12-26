package match3.game;
/**
 * This class is having properties and methods for Game specifications. 
 * This object is created after taking inputs from user to design the match3 game.
 * @author Dilip Kumar
 * @since 24-Dec-2013
 *
 */
public class Specification {

	//Height of Grid
	int gridHeight;
	//Width of Grid
	int gridWidth;
	//Number of different block types needed in Grid
	int numberOfBlockTypes;
	
	//constructor
	public Specification (int gridHeight, int gridWidth, int numberOfBlockTypes)
	{
		this.gridHeight = gridHeight;
		this.gridWidth = gridWidth;
		this.numberOfBlockTypes = numberOfBlockTypes;
	}
	
	public int getGridHeight() {
		return gridHeight;
	}
	public void setGridHeight(int gridHeight) {
		this.gridHeight = gridHeight;
	}
	public int getGridWidth() {
		return gridWidth;
	}
	public void setGridWidth(int gridWidth) {
		this.gridWidth = gridWidth;
	}
	public int getNumberOfBlockTypes() {
		return numberOfBlockTypes;
	}
	public void setNumberOfBlockTypes(int numberOfBlockTypes) {
		this.numberOfBlockTypes = numberOfBlockTypes;
	}
	
	
	
}
