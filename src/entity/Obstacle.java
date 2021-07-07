package entity;

import java.awt.Rectangle;

import game_world.Room;
import game_world.Vector;

public class Obstacle extends Enemy{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public Obstacle(int x,int y,Vector facing, int delayTime, int frameCount, byte imgID, float speed, Room room, Vector tag1, Vector tag2, int damage) {
		super(x, y, facing, delayTime, frameCount, imgID, speed, room);
		// TODO Auto-generated constructor stub
		this.tag1=tag1;
		this.tag2=tag2;
		this.damage=damage;
	}

	private Vector tag1;
	private Vector tag2;
	private boolean cur = false;
	private int damage;
	public void Move() {
		if(cur) {
			facing = new Vector(tag1.x- this.x, tag1.y-this.y);
		}else {
			facing = new Vector(tag2.x-this.x, tag2.y-this.y);
		}
		if(facing.Length()<0.5) {
			cur=!cur;
		}
		facing = facing.Nomalize();
		this.x += (int)(facing.x * speed);
		this.y += (int)(facing.y * speed);
	}
	
	public void OnLoop() {
		Move();
		CollisionPlayer();
	}
	
	public void CollisionPlayer() {
		Rectangle r = this.intersection(player);
		if(r.isEmpty() || r.width * r.height < 20)return;
		player.TakeHP(-damage);
		SetAlive(false);
	}
}
