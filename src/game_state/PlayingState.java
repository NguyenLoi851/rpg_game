package game_state;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;

import conversation.Conversation;
import entity.Player;
import game_world.*;
import main.WindowManager;
import resources.Resources;

public class PlayingState extends GameState{
	private World world;
	private Player player;
	private int timeToGameOver = 50;
	boolean p = true;
	boolean inConversation = false;
	Conversation conversation;
	public PlayingState(GameStateManager gameStateManager) {
		super(gameStateManager);
		player = new Player(7, 7, 2, 2, Resources.PLAYER, 1);
		world = new World(player);
		p = true;
		if(gameStateManager.blood_fall>0) {
			this.inConversation=true;
			String[] sentences = new String[]{
				"Chuyện gì vừa xảy ra vậy ???",
				"Sao mình lại về chỗ này ???"
			};
			byte[] imgIDs = new byte[] {
					Resources.PLAYER,
					Resources.PLAYER
			};
			this.conversation = new Conversation(150, imgIDs, sentences);
		}else {
			this.inConversation=true;
			String[] sentences = new String[]{
				"Lũ Pales khốn kiếp",
				"Ta sẽ tiêu diệt các ngươi",
				"Giỏi vào mà ăn"
			};
			byte[] imgIDs = new byte[] {
					Resources.PLAYER,
					Resources.PLAYER,
					Resources.MONSTER
			};
			this.conversation = new Conversation(150, imgIDs, sentences);
		}
	}
	@Override
	public void Loop() {
		// TODO Auto-generated method stub
		if(!inConversation) {
		world.ChangeRoom();
		if(world.GetCur() == World.count - 1) {
			if(p) {
				if(!GameOverMenu.result) {
				gameStateManager.blood_fall = 0;
				
				if(player.x<=Tile.size*4) {
					this.inConversation=true;
					String[] sentences = new String[]{
						"Sao ngươi không tấn công bọn ta",
						"Tôi không muốn ai phải đổ máu nữa",
						"Cuộc chiến này quá phi nghĩa",
						"Chúng ta làm hòa nhé",
						"Hi hi, mình đồng ý",
						"Mãi bên nhau bạn nhé <3"
					};
					byte[] imgIDs = new byte[] {
							Resources.AD,
							Resources.PLAYER,
							Resources.PLAYER,
							Resources.PLAYER,
							Resources.AD,
							Resources.AD
					};
					this.conversation = new Conversation(150, imgIDs, sentences);
					GameOverMenu.result=true;
				}
				}else {
					gameStateManager.setCurState(4);
				}
			}
			else {
				gameStateManager.blood_fall++;
				gameStateManager.setGameStates(1, new PlayingState(gameStateManager));
				gameStateManager.setCurState(1);
				return;
			}
		}
		if(player.getHp()>0) {
		Room room = world.GetCurrentRoom();
		room.Loop();
		player.OnLoop();
		}
		else {
			timeToGameOver--;
			if(timeToGameOver==0) {
				GameOverMenu.result=false;
				gameStateManager.blood_fall=0;
				gameStateManager.setCurState(3);
			}
		}
		}else {
			if(conversation!=null) {
				conversation.OnLoop();
				if(conversation.GetState()==3)this.inConversation=false;
			}
		}
	}

	@Override
	public void Render(Graphics g) {
		// TODO Auto-generated method stub
		world.GetCurrentRoom().Render(g);
		
		if(MainMenu.getLevel() == 2)
		g.drawImage(Resources.TEXTURES.get(Resources.DARK),(int)player.getCenterX() - 1000, 
			(int)player.getCenterY() - 1000, 2000, 2000, null);
		player.Render(g);
		if(gameStateManager.blood_fall>0 && world.GetCur()<World.count-1) {
			if(gameStateManager.blood_fall<=5)
			g.drawImage(Resources.TEXTURES.get(Resources.BLOOD_FALL), 0,
			gameStateManager.blood_fall*60 - 300 , WindowManager.WIDTH, WindowManager.HEIGHT, null);
			else
				g.drawImage(Resources.TEXTURES.get(Resources.BLOOD_FALL), 0,
						0 , WindowManager.WIDTH, WindowManager.HEIGHT, null);
		}
		if(this.inConversation) {
			if(conversation!=null)conversation.Display(g);
		}
		g.setColor(Color.WHITE);
		g.setFont(new Font("arial", Font.PLAIN, 15));
		g.drawImage(Resources.TEXTURES.get(Resources.HEART), 10, 0, Tile.size *2/5, Tile.size*2/5, null);
		g.drawImage(Resources.TEXTURES.get(Resources.MANA), 10, 25, Tile.size*2/5, Tile.size*2/5, null);
		g.drawImage(Resources.TEXTURES.get(Resources.ARMOR), 10, 50, Tile.size*2/5, Tile.size*2/5, null);
		g.drawImage(Resources.TEXTURES.get(Resources.ULTI), 10, 75, Tile.size*2/5, Tile.size*2/5, null);
		g.drawImage(Resources.TEXTURES.get(Resources.HEARTB), 40, 5, player.getHp() * 5, Tile.size*1/5, null);
		g.drawImage(Resources.TEXTURES.get(Resources.MANAB), 40, 30, player.getMp() * 5, Tile.size*1/5, null);
		g.drawImage(Resources.TEXTURES.get(Resources.ARMORB), 40, 55, player.getDef()*5, Tile.size*1/5, null);
		g.drawImage(Resources.TEXTURES.get(Resources.ULTIB), 40, 80, player.getRTime()/5, Tile.size*1/5, null);
	}

	@Override
	public void KeyPressed(int keyCode) {
		// TODO Auto-generated method stub
		switch(keyCode) {
		
		case KeyEvent.VK_DOWN:
			if(!this.inConversation) {
			player.SetMove(true);
			player.SetFacing(Vector.Down);
			}
			break;
		case KeyEvent.VK_LEFT:
			if(!this.inConversation) {
			player.SetMove(true);
			player.SetFacing(Vector.Left);
			}
			break;
		case KeyEvent.VK_RIGHT: 
			if(!this.inConversation) {
			player.SetMove(true);
			player.SetFacing(Vector.Right);
			}
			break;
		case KeyEvent.VK_UP:
			if(!this.inConversation) {
			player.SetMove(true);
			player.SetFacing(Vector.Up);
			}
			break;
		case KeyEvent.VK_Q: 
			if(!this.inConversation) {
			p = false;
			player.AttackQ();
			}
			break;
		case KeyEvent.VK_R:
			if(!this.inConversation) {
			p = false;
			player.AttackR();
			}
			break;
		case KeyEvent.VK_P:	
			gameStateManager.setCurState(2);
			break;
		case KeyEvent.VK_ENTER:
			if(this.inConversation) {
				if(conversation!=null)conversation.ChangeSentence();
			}
			break;
		}
		
	}

	@Override
	public void KeyReleased(int keyCode) {
		// TODO Auto-generated method stub
		switch(keyCode) {
		case KeyEvent.VK_UP:
			player.SetMove(false);
			break;
		case KeyEvent.VK_DOWN:
			player.SetMove(false);
			break;
		case KeyEvent.VK_LEFT:
			player.SetMove(false);
			break;
		case KeyEvent.VK_RIGHT:
			player.SetMove(false);
			break;
		}
	}

}
