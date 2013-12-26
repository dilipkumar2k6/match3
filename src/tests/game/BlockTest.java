package tests.game;

import match3.game.Block;

public class BlockTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//Create Block object for testing
		Block block = new Block(2, 3, 5);
		//Test toString
		System.out.println(block.toString());
		//Test getCoOrdinate method
		System.out.println(block.getI());
		
		//Test compareTo
		Block secondBlock = new Block(2,3,3);
		System.out.println(block.compareTo(secondBlock));
	}

}
