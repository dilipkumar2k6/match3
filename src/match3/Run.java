package match3;

import match3.game.PlayGame;

public class Run {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		 
		if(args ==null || args.length !=3)
		{
		System.out.println("Sorry!! You have not provided input as per required format. Please use following format\n <height of Grid> <width of grid> <number of block types>\n You can also use following example \n 5 5 3");	
		}
		else
		{
			int height = Integer.parseInt(args[0]);
			int width = Integer.parseInt(args[1]);
			int numberOfBlockTypes = Integer.parseInt(args[2]);
			PlayGame game = new PlayGame();
			//game.playWithSampleData();
			game.play(height, width, numberOfBlockTypes);	
		}
		

	}

}
