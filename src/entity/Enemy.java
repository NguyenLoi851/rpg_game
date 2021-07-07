package entity;


import java.awt.Graphics;

import game_world.Room;
import game_world.Vector;
import resources.Resources;

public class Enemy extends Entity{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public Enemy(int x, int y,Vector facing, int delayTime, int frameCount, byte imgID, float speed, Room room) {
		super(x,y,facing, delayTime, frameCount, imgID, speed);
		// TODO Auto-generated constructor stub
		this.room= room;
		this.player = room.GetPlayer();
	}
	
	private boolean alive = true;
	public void SetAlive(boolean alive) {
		this.alive=alive;
	}public boolean GetAlive() {
		return alive;
	}
	protected Room room;
	protected Player player;
	public void CollisionPlayer() {
		
	}public void CollisionQ() {
		
	}public void CollisionR() {
		
	}
	
}
