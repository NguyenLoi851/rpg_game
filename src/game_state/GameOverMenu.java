package game_state;

import java.awt.*;
import java.awt.event.KeyEvent;

import main.WindowManager;
import resources.Resources;

public class GameOverMenu extends MainMenu{
	public static boolean result ;
	protected String[] gameoverMenu = {};
	private static final String WIN = "You win";
	private static final String LOSE = "You lose";
	private static final String RESTART = "Restart";
	private static final String MAINMENU = "Main menu";
	protected int selected;
	public GameOverMenu(GameStateManager gameStateManager){
		super(gameStateManager);
		this.gameoverMenu = new String[]{WIN, LOSE};
		this.optionsMenu = new String[]{RESTART, MAINMENU};
		this.selected= 0;
	}

	

	@Override
	public void Loop() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void Render(Graphics graphics) {
		// TODO Auto-generated method stub
graphics.drawImage(Resources.TEXTURES.get(Resources.BACKGROUND),0, 0, WindowManager.WIDTH, WindowManager.HEIGHT, null);
		
		graphics.setFont(new Font("Arial", Font.BOLD, 40));
		graphics.drawImage(Resources.TEXTURES.get(Resources.BUTTON), 0, 0, 800, 200, null);
		graphics.setColor(Color.WHITE);
		int index;if(result)index = 0; else index = 1;
		graphics.drawString(this.gameoverMenu[index], WindowManager.WIDTH/2 - 115, WindowManager.HEIGHT/5);
		for (int i = 0; i < this.optionsMenu.length; i++) {
			graphics.drawImage(Resources.TEXTURES.get(Resources.BUTTON_1), 0, 180 + 80 * i, 400, 80, null);
			if(i==this.selected) {
				graphics.setColor(Color.BLACK);
				graphics.drawImage(Resources.TEXTURES.get(Resources.BUTTON_1), 0, 180 + 80 * i, 500, 80, null);
			}
			else graphics.setColor(Color.WHITE);
			
			graphics.drawString(this.optionsMenu[i], 10, 235 + i * 80);
		}
		
	}

	@Override
	public void KeyPressed(int keyCode) {
		// TODO Auto-generated method stub
		switch (keyCode){
			case KeyEvent.VK_UP:
				if(this.selected > 0) this.selected --;
				break;
			case KeyEvent.VK_DOWN:
				if(this.selected < this.optionsMenu.length - 1) this.selected ++;
				break;
			case KeyEvent.VK_ENTER:
				switch (this.optionsMenu[selected]){
					case RESTART:
						gameStateManager.setGameStates(1, new PlayingState(gameStateManager));
						gameStateManager.setCurState(1);
						break;
					case MAINMENU:
						gameStateManager.blood_fall = 0;
						gameStateManager.setCurState(0);
						break;
				}
				break;
		}
		}


	@Override
	public void KeyReleased(int keyCode) {
		// TODO Auto-generated method stub
		
	}
}
