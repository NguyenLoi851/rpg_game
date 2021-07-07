package entity;

import java.awt.Rectangle;
import java.util.Random;

import game_world.Room;
import game_world.Vector;

public class Item extends Enemy{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public Item(int x, int y,int delayTime, int frameCount, byte imgID, float speed, Room room) {
		super(x,y,Vector.Up, delayTime, frameCount, imgID, speed, room);
		// TODO Auto-generated constructor stub
	}
	public void CollisionPlayer() {
		Rectangle r = this.intersection(player);
		if(r.isEmpty())return;
		Random ran= new Random();
		int i = ran.nextInt(3);
		switch(i) {
		case 0: player.TakeHP(5);
		case 1: player.TakeMP(5);
		case 2: player.TakeDef(5);
		}
		SetAlive(false);
	}
	public void OnLoop() {
		CollisionPlayer();
	}
}
