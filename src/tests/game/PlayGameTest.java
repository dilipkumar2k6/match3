package tests.game;

import match3.game.PlayGame;

public class PlayGameTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		PlayGame game = new PlayGame();
		//game.playWithSampleData();
		game.play(5, 3, 3);

	}

}
