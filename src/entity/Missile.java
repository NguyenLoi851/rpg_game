package entity;

import game_world.Room;
import game_world.Vector;

public class Missile extends Bullet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public Missile(int x, int y,Vector facing, int delayTime, int frameCount, byte imgID, float speed, Room room, int damage) {
		super(x,y,facing, delayTime, frameCount, imgID, speed, room, damage);
		// TODO Auto-generated constructor stub
	}
	public void Move() {
		facing = new Vector(player.x-this.x, player.y-this.y);
		facing = facing.Nomalize();
		super.Move();
	}
	public void OnLoop() {
		Move();
		super.DecreaseTime();
		super.CollisionPlayer();
	}
}
