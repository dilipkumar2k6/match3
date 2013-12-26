package match3.game;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used to represent the Grid design. This is having all properties and method to reflect
 * Grid design.
 * @author Dilip Kumar
 * @since 24-Dec-2013
 */
public class Grid {

	//Grid specification
	Specification specification;
	//Two dimensional Array of Blocks to map Grid design
	Block [][] grid;
	//Matches on playing match3 game on grid
	Matches matches = new Matches();

	//Constructor to create 2D array of blocks
	public Grid(Specification specification)
	{
		this.specification = specification;
		this.grid = new Block[specification.getGridHeight()][specification.getGridWidth()];
	}
	
	/**
	 * Initialize 2D grid by picking the random Block and value.
	 */
	public void initializeGridRandomly()
	{
		for(int i=0;i<specification.getGridHeight();i++)
		{
			for(int j=0;j<specification.getGridWidth();j++)
			{
				int blockValue = (int )(Math.random() * specification.getNumberOfBlockTypes() + 1);
				//Create Block object
				Block block = new Block(i, j, blockValue);
				grid[i][j] = block;
			}
		}
	}
	/**
	 * In Genesis10 coding exercise; the sample data is given to verify the result. This method will create Grid as per sample data to validate the result.
	 */
	public void initializeGridAsPerSampleData()
	{
		//First row
		grid[0][0] = new Block(0, 0, 2);
		grid[0][1] = new Block(0, 1, 3);
		grid[0][2] = new Block(0, 2, 1);
		grid[0][3] = new Block(0, 3, 2);
		grid[0][4] = new Block(0, 4, 1);
		
		//Second row
		grid[1][0] = new Block(1, 0, 1);
		grid[1][1] = new Block(1, 1, 3);
		grid[1][2] = new Block(1, 2, 2);
		grid[1][3] = new Block(1, 3, 1);
		grid[1][4] = new Block(1, 4, 1);
		
		//Third row
		grid[2][0] = new Block(2, 0, 1);
		grid[2][1] = new Block(2, 1, 3);
		grid[2][2] = new Block(2, 2, 2);
		grid[2][3] = new Block(2, 3, 1);
		grid[2][4] = new Block(2, 4, 1);
		
		
		//Fourth row
		grid[3][0] = new Block(3, 0, 1);
		grid[3][1] = new Block(3, 1, 3);
		grid[3][2] = new Block(3, 2, 2);
		grid[3][3] = new Block(3, 3, 1);
		grid[3][4] = new Block(3, 4, 1);
		
		
		//Fifth row
		grid[4][0] = new Block(4, 0, 2);
		grid[4][1] = new Block(4, 1, 2);
		grid[4][2] = new Block(4, 2, 2);
		grid[4][3] = new Block(4, 3, 2);
		grid[4][4] = new Block(4, 4, 1);
		
	}
	
	/**
	 * Optimized approach to apply match
	 */
	public void applyMatchOptimized()
	{
		//1. Scan each blocks horizontally. 
		scanBlocksForMatches();
		//2. Sort Matches in descending order of match size
		matches.sortMatches();
	}
	/**
	 * Optimized approach to scan blocks to find out matches.
	 */
	public void scanBlocksForMatches()
	{
		//1. Scan each blocks horizontally.
		//2. Mark block as selected if it is selected for match
		//3. If next same block is already selected then apply extra algorithm to see if need to keep this new block or need to leave this block for original match
		
		//Get Match object
		Match match= new Match();
		boolean foundMatch;		
		for(int i=0;i<specification.getGridHeight();i++)
		{
			for(int j=0;j<specification.getGridWidth();j++)
			{
				//Get current block
				Block currentBlock = grid[i][j];
				//Process this block only if it is not already processed
				if(!currentBlock.isSelectedForMatch())
				{						
					//Check if there is match at horizontal. First check if at least two more blocks exist at right side
					if(j < specification.getGridWidth() -2)
					{
						//Check horizontally
						foundMatch = scanBlocksArray(grid[i], match, j);
						if(!foundMatch)
						{
							//Check vertically. Get vertical index
							Block [] blocks = getVerticalArray(j);
							foundMatch = scanBlocksArray(blocks, match, i); //Please note; current position of Block will be as per vertical position.
						}
					}
					else
					{
						//Check vertically. Get vertical index
						Block [] blocks = getVerticalArray(j);
						foundMatch = scanBlocksArray(blocks, match, i); //Please note; current position of Block will be as per vertical position.
						
					}
					
				}
				else
				{
					//Do nothing
				}
				//Check if match is found then add it and reset it.
				if(match != null && match.getSelectedBlocks() !=null && match.getSelectedBlocks().size() > 0 )
				{
					matches.addMatche(match);
					//Rest match object
					match = null;	
					match = new Match();
				}
				
				 
			}
		}		 
	}
	
	/**
	 * Scan block horizontally to find out match
	 * @param i
	 * @param j
	 * @param match
	 * @param currentBlock
	 * @return
	 */
	private boolean scanBlocksArray(Block [] blockArray , Match match, int currentBlockIndex)
	{
		
		boolean foundMatch=false;
		Block currentBlock = blockArray[currentBlockIndex];
		//Check if three horizontal block is same
		if(currentBlockIndex < blockArray.length -2)
		{
			
			Block nextBlock = blockArray[currentBlockIndex+1];
			Block nextToNextBlock = blockArray[currentBlockIndex+2];
			if(currentBlock.compareTo(nextBlock) ==0 && nextBlock.compareTo(nextToNextBlock) == 0)
			{
				boolean needToProcessNextBlock= true;
				//Check if nextBlock is ready to add or not
				if(nextBlock.isSelectedForMatch())
				{					 
					needToProcessNextBlock = needToReuseCurrentBlockForMatch(blockArray, match, currentBlockIndex+1);																					
				}
				//Check for next next block 
				boolean needToProcessNextToNextBlock= true;
				if(nextToNextBlock.isSelectedForMatch())
				{					 
					needToProcessNextToNextBlock = needToReuseCurrentBlockForMatch(blockArray, match, currentBlockIndex+2);							
				}

				//If processing is not require then exit
				if(!(needToProcessNextBlock && needToProcessNextToNextBlock))
				{
					return foundMatch;
				}
				else
				{
					//Remove from parent list based on required reuse
					if(needToProcessNextBlock)
					{
						//Remove from parent match
						removeEndBlockFromMatchedList(nextBlock);				
					}
					
					if(needToProcessNextToNextBlock)
					{
						//Remove from parent match
						removeEndBlockFromMatchedList(nextToNextBlock);				
					}
					
				}
								 
				
				foundMatch= true;
				//There is at least three match. Create Match object and add it into list			 
				match.addBlock(currentBlock);
				match.addBlock(nextBlock);
				match.addBlock(nextToNextBlock);
				//Mark all three object as selected
				currentBlock.setSelectedForMatch(true);
				nextBlock.setSelectedForMatch(true);
				nextToNextBlock.setSelectedForMatch(true);
				//Loop till next horizontal and see if if there is any match.
				//Next counter variable
				int k = currentBlockIndex+3;
				if(k  < blockArray.length)
				{
					for(;k<blockArray.length;k++)
					{
						//Get last match Object										
						Block lastMatchObj = match.getSelectedBlocks().get(match.getSelectedBlocks().size()-1);
						//Get Current Block
						currentBlock = blockArray[k];
						if(lastMatchObj.compareTo(currentBlock) ==0)
						{
							boolean needToAdd = true;
							if(currentBlock.isSelectedForMatch())
							{
								needToAdd= needToReuseCurrentBlockForMatch(blockArray, match, k);	
							}
														
							if(needToAdd)
							{
								//Remove from parent match
								removeEndBlockFromMatchedList(currentBlock);
								//Add current block into match list
								match.addBlock(currentBlock);
								//Set flag for current block 
								currentBlock.setSelectedForMatch(true);	
							}
							else
							{
								//Break the current loop
								break;
							}
						}
					}
				} 

				
				
			}
		}
		return foundMatch;
	
	}
	
	/**
	 * Check if current block needs to add into Current match or not. 
	 * @return
	 */
	boolean needToReuseCurrentBlockForMatch(Block[] blockArray, Match match, int currentBlockIndex)
	{
		boolean needToAdd= false;
		Block currentBlock = blockArray[currentBlockIndex];
		boolean atEnd = isBlockAtEndOfMatchedList(currentBlock);
		if(atEnd)
		{						
			needToAdd = true;
		}
		
		return needToAdd;
	}

	
	/**
	 * Check if block's position in match is at the end or not.
	 * @param block
	 * @return
	 */
	private boolean isBlockAtEndOfMatchedList(Block block)
	{
		boolean atEnd = false;
		
		if(matches.getAllMatches() !=null && matches.getAllMatches().size() > 0)
		{
			for(Match match : matches.getAllMatches())
			{
				//Get the position of block in given match
				if(match != null && match.getSelectedBlocks() !=null && match.getSelectedBlocks().size() > 0)
				{
					int positionOfBlock = match.getSelectedBlocks().indexOf(block);
					if(positionOfBlock == match.getSelectedBlocks().size() -1)
					{
						atEnd = true;	
					}
					
				}
			}
		}
		
		return atEnd;
	}
	
	/**
	 * Remove block located at end of match from match list
	 * @param block
	 * @return
	 */
	private void removeEndBlockFromMatchedList(Block block)
	{
		//Create newMatch. If needed then new Match will be created which will be added back to match list
		Match newMatch = new Match();
		List <Block> toRemoveAll = new ArrayList<Block>(); 
		if(matches.getAllMatches() !=null && matches.getAllMatches().size() > 0)
		{
			for(Match match : matches.getAllMatches())
			{
				//Get the position of block in given match
				if(match != null && match.getSelectedBlocks() !=null && match.getSelectedBlocks().size() > 0)
				{
					int positionOfBlock = match.getSelectedBlocks().indexOf(block);
					if(positionOfBlock !=-1)
					{
						//Change flag
						block.setSelectedForMatch(false);
						//If three or more blocks still exist after given Block then create separate Match object and append into match list
						for(int i=positionOfBlock ; i <match.getSelectedBlocks().size();i++)
						{
							
							if(i != positionOfBlock && (match.getSelectedBlocks().size() - (positionOfBlock + 1) ) <= 3)
							{
								newMatch.addBlock(match.getSelectedBlocks().get(i));	
							} 						 
							
							//Add to Remove (can't remove here bcz it will throw exception)
							toRemoveAll.add(match.getSelectedBlocks().get(i));						
						}
						
						 //Remove All
						match.getSelectedBlocks().removeAll(toRemoveAll);	
					}
					
					
					
				}
			}
		}
		//Check if new match needs to be added or not.
		if(newMatch.getSelectedBlocks() != null &&  newMatch.getSelectedBlocks().size() > 0)
		{
			matches.addMatche(newMatch);
		}
		
		 
	}
	
	/**
	 * Get vertical array for given column index j
	 * @param j
	 * @return
	 */
	private Block [] getVerticalArray(int j)
	{
		Block [] blocks = new Block[specification.getGridHeight()];
		for(int i=0; i < specification.getGridHeight(); i ++)
		{
			blocks[i]=grid[i][j];	
		}
		
		return blocks;
	}
	
		/**
	 * This is core algorithm which find out the matches and update the grid.
	 */
	public void applyMatch()
	{
		//1. Scan horizontally
		for(int i=0;i<specification.getGridHeight();i++)
		{
			Block [] blocks = grid[i];
			//Scan this row
			scanBlocksForMatches(blocks);
		}
		//2. Scan vertically
		for(int j=0;j<specification.getGridWidth();j++)
		{
			Block [] blocks = new Block[specification.getGridHeight()];
			for(int i=0; i < specification.getGridHeight(); i ++)
			{
				blocks[i]=grid[i][j];	
			}
			//Scan this row
			scanBlocksForMatches(blocks);
		}
		//3. Sort Matches in descending order of match size
		matches.sortMatches();
	}
	/**
	 * Scan blocks to find out the matches.
	 * @param blocks
	 */
	public void scanBlocksForMatches(Block [] blocks)
	{
		//Get Match object
		Match match=null;
		if(blocks !=null && blocks.length > 0)
		{
			for(int i =0; i <blocks.length ; i++)
			{
				//compare current block to immediate next block. (Ignore this comparison for last block)
				if(i != blocks.length - 1)
				{
					Block currentBlock= blocks[i];
					Block nextBlock = blocks[i+1];
					//Compare value of these two blocks. If it is same then this can be probable match
					if(currentBlock.compareTo(nextBlock) == 0)
					{
							//Set block status as selected
							currentBlock.setSelectedForMatch(true);
							nextBlock.setSelectedForMatch(true);
							
							//Value is matched therefore this can be probable match. Add into match object
							if(match == null)
							{
								match = new Match();
								//Add both current and next matched block
								match.addBlock(currentBlock);
								match.addBlock(nextBlock);
								//Add this match object into matches list.
								matches.addMatche(match);
							}
							else
							{
								//Here can be two cases. 
								//1. This match is same as previous matched block. In this case simply add block into match 
								//2. This match is new compare to previous match. In this add match into list and create new match to track this newly found match
								
								//Get last matched block
								Block lastMatchedBlock = match.getSelectedBlocks().get(match.getSelectedBlocks().size() -1);
								//Compare lastMatchedBlock with current match
								if(currentBlock.compareTo(lastMatchedBlock) ==0)
								{
									//This match is same as existing match
									//Only add next block
									match.addBlock(nextBlock);
								}
								else
								{
									//This match is different compare to existing match. Therefore create new match object to trace it.
									
									match = new Match();
									//Add both current and next matched block
									match.addBlock(currentBlock);
									match.addBlock(nextBlock);
									//Add this match into match list
									matches.addMatche(match);
								}

							}												
					}
				}
			}
		}
	}
	
	/**
	 * Need to run extra logic to remove block
	 */
	
	
	/**
	 * Print Grid in result format
	 */
	private void print(boolean printResult)
	{
		for(int i=0;i<specification.getGridHeight();i++)
		{
			for(int j=0;j<specification.getGridWidth();j++)
			{
				 //Get block
				Block block = grid[i][j];
				if(printResult && block.isSelectedForMatch())
				{
					System.out.print("X");
				}
				else
				{
					System.out.print(block.getValue());					
				}
				System.out.print(" ");	
				
			}
			//Print line break
			System.out.println();
		}
	}
	
	
	/**
	 * Print Grid data
	 */
	public void printInputGrid()
	{
		System.out.println("Input Grid:");
		print(false);
	}
	/**
	 * Print result grid.
	 */
	public void printResultGrid()
	{
		System.out.println("\nOutput Grid:");
		print(true);
	}

	public Block[][] getGrid() {
		return grid;
	}

	public void setGrid(Block[][] grid) {
		this.grid = grid;
	}

	public Specification getSpecification() {
		return specification;
	}

	public void setSpecification(Specification specification) {
		this.specification = specification;
	}
	
	
}
