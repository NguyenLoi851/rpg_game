package conversation;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import game_world.Tile;
import main.WindowManager;
import resources.Resources;

public class Conversation {
	private int state;
	private int y = WindowManager.HEIGHT;
	private int height;
	private byte[] imgIDs;
	private String[] sentences;
	private int currentSentence;
	public Conversation(int height, byte[] imgIDs, String[] sentences) {
		this.height = height;
		state = 0;
		this.imgIDs = new byte[imgIDs.length];
		this.sentences = new String[sentences.length];
		for(int i=0;i<imgIDs.length;i++) {
			this.imgIDs[i] = imgIDs[i];
			this.sentences[i]= sentences[i];
		}
		this.currentSentence = 0;
	}
	public int GetState() {
		return state;
	}
	
	public void Enter() {
		
		if(y<=WindowManager.HEIGHT-height) {
			state = 1;
		}
		else y-=2;
	}
	public void Exit() {
		
			if(y>=WindowManager.HEIGHT)
				state = 3;
			else y+=2;
	}
	private void DisplaySentence(Graphics g) {
		if(currentSentence< imgIDs.length) {
			g.setColor(Color.WHITE);
		g.drawImage(Resources.TEXTURES.get(imgIDs[this.currentSentence]), 10, y + height/10, 2*Tile.size, 2*Tile.size, null);
		g.setFont(new Font("Arial", Font.ROMAN_BASELINE, 30));
		g.drawString(sentences[this.currentSentence], 10+ 3 * Tile.size, y+height/2);
		
		}
		
	}
	public void ChangeSentence() {
		if(state ==1)
		this.currentSentence++;
		if(currentSentence>= imgIDs.length)state = 2;
	}
	public void Display(Graphics g) {
		g.drawImage(Resources.TEXTURES.get(Resources.BUTTON), 0, y, WindowManager.WIDTH, height, null);
		if(state ==1)DisplaySentence(g);
	}
	public void OnLoop() {
		if(state == 0)Enter();
		else if(state == 2)Exit();
	}
}
