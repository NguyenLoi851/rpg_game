package game_state;

import java.awt.*;

public class GameStateManager {
	private GameState[] gameStates;
	private int curState;
	public static int blood_fall = 0;

	public GameStateManager() {
		gameStates = new GameState[] { new MainMenu(this), null, new PauseMenu(this), new GameOverMenu(this),
				new DaoLyMenu(this), null };
		curState = 0;
	}

	public void Loop() {

		gameStates[curState].Loop();
	}

	public void Render(Graphics graphics) {
		gameStates[curState].Render(graphics);
	}

	public void KeyPressed(int keyCode) {

		gameStates[curState].KeyPressed(keyCode);
	}

	public void KeyReleased(int keyCode) {

		gameStates[curState].KeyReleased(keyCode);
	}

	public int getCurState() {
		return curState;
	}

	public void setCurState(int curState) {
		this.curState = curState;
	}

	public GameState getGameStates(int curState) {
		return gameStates[curState];
	}

	public void setGameStates(int curState, GameState gameState) {
		this.gameStates[curState] = gameState;
	}
}
