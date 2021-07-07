package game_state;


import main.WindowManager;
import resources.Resources;

import java.awt.*;
import java.awt.event.KeyEvent;


public class MainMenu extends GameState{
	
	protected String[] optionsMenu = {};
	protected String[] levelMenu = {};
	private static final String START_GAME ="Start";
	private static final String QUIT_GAME = "Quit";
	private static final String LEVEL_GAME = "Level: ";
    private static final String EASY_GAME = "Easy";
    private static final String HARD_GAME = "Hard";
    private static final String VERY_HARD_GAME = "Very Hard";
    private static final String LABEL = "Isra vs Pales";
 	protected int selected;
 	private static int level;
 	
 	public MainMenu(GameStateManager gameStateManager) {
		super(gameStateManager);
		this.optionsMenu= new String[]{START_GAME, LEVEL_GAME, QUIT_GAME};
		this.levelMenu = new String[]{ EASY_GAME, HARD_GAME, VERY_HARD_GAME};
		this.selected = 0;
		level = 0;
	}
	public static int getLevel() {
		return level;
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
		//graphics.drawImage(Resources.TEXTURES.get(Resources.HEART), 0, 0, 800, 200, null);
		graphics.setColor(Color.WHITE);
		graphics.drawString(LABEL, WindowManager.WIDTH/2 - 115, WindowManager.HEIGHT/5);
	
		for(int i=0; i<this.optionsMenu.length; i++){
			graphics.drawImage(Resources.TEXTURES.get(Resources.BUTTON_1), 0, 180 + 80 * i, 400, 80, null);
			
			if(i==this.selected) {
				graphics.setColor(Color.BLACK);
				graphics.drawImage(Resources.TEXTURES.get(Resources.BUTTON_1), 0, 180 + 80 * i, 500, 80, null);
			}
			else graphics.setColor(Color.WHITE);
			
			graphics.drawString(this.optionsMenu[i], 10, 235 + i * 80);
			if(i==1){
				 graphics.drawString(this.levelMenu[level], 130, 235 + i * 80);		
			}
		}
	}
	
	@Override
	public void KeyPressed(int keyCode) {
		// TODO Auto-generated method stub
		switch (keyCode) {
			case KeyEvent.VK_UP:
				if(this.selected > 0) this.selected --;
				break;
			case KeyEvent.VK_DOWN:
				if(this.selected < this.optionsMenu.length - 1) this.selected ++;
				break;
			case KeyEvent.VK_ENTER:
				switch (this.optionsMenu[selected]){
					case START_GAME:
						gameStateManager.setGameStates(5, new IntroMenu(gameStateManager));
						gameStateManager.setCurState(5);
						break;
					case QUIT_GAME:
						System.exit(0);
						break;
					case LEVEL_GAME:
						level++;
						if(level == 3)level = 0;
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
