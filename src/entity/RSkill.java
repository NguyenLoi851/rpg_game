package entity;

import game_world.Vector;

public class RSkill extends QSkill {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public RSkill(int x, int y, Vector facing, int delayTime, int frameCount, byte imgID, float speed) {
		super(x, y, facing, delayTime, frameCount, imgID, speed);
		// TODO Auto-generated constructor stub
		ExistTime = 0;
	}

	public void Move() {
		super.x += (int) facing.x * speed;
		super.y += (int) facing.y * speed;
	}

	public void DecreaseTime() {
		super.DecreaseTime();
		super.damage += 5;
		super.width += 1;
		super.height += 1;
	}

	public void OnLoop() {
		super.OnLoop();
		Move();
	}
}
