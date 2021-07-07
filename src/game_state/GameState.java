package game_state;

import java.awt.*;

public abstract class GameState {
	protected GameStateManager gameStateManager;
	protected GameState(GameStateManager state){this.gameStateManager = state;};
	
	public abstract void Loop();
	public abstract void Render(Graphics graphics);
	public abstract void KeyPressed(int keyCode);
	public abstract void KeyReleased(int keyCode);
}
