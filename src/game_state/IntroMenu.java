package game_state;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import game_world.Tile;
import main.WindowManager;
import resources.Resources;

public class IntroMenu extends GameState{

	int ufoX, ufoY;
	protected IntroMenu(GameStateManager state) {
		super(state);
		// TODO Auto-generated constructor stub
		ufoX = WindowManager.WIDTH - 20;
		ufoY = WindowManager.HEIGHT/3;
	}

	@Override
	public void Loop() {
		// TODO Auto-generated method stub
		ufoX-= 4;
		if(ufoX <= 80) {
			gameStateManager.setGameStates(1, new PlayingState(gameStateManager));
			gameStateManager.setCurState(1);
		}
	}

	@Override
	public void Render(Graphics graphics) {
		// TODO Auto-generated method stub
		graphics.drawImage(Resources.TEXTURES.get(Resources.UNIVERSE), 0,0 , WindowManager.WIDTH, WindowManager.HEIGHT, null);
		graphics.drawImage(Resources.TEXTURES.get(Resources.PLANET), 10,WindowManager.HEIGHT/3 - 40, 200, 200, null);
		graphics.drawImage(Resources.TEXTURES.get(Resources.UFO), ufoX,ufoY , Tile.size, Tile.size, null);
		graphics.setColor(Color.white);
		graphics.setFont(new Font("Arial", Font.BOLD, 20));
		graphics.drawString("Đặc vụ Isra được cử đến hành tinh Pales để chiến đấu với kẻ thù", 60, WindowManager.HEIGHT*3/4);
	}
	
	@Override
	public void KeyPressed(int keyCode) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void KeyReleased(int keyCode) {
		// TODO Auto-generated method stub
		
	}

}
