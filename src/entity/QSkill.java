package entity;

import game_world.Vector;

public class QSkill extends Entity{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public QSkill(int x, int y,Vector facing, int delayTime, int frameCount, byte imgID, float speed) {
		super(x,y,facing, delayTime, frameCount, imgID, speed);
		// TODO Auto-generated constructor stub
		damage = 5;
		ExistTime = 0;
	}
	protected int damage;
	protected int ExistTime;
	public void DecreaseTime() {
		super.DecreaseTime();
		if(ExistTime > 0) ExistTime--;
	}
	public void OnLoop() {
		if(ExistTime == 0)
			{
				SetTransform(new Vector(0,0), new Vector(0,0));
				return;
			}
		DecreaseTime();

		
	}
	public int GetDamage() {
		return damage;
	}public void SetExistTime(int time) {
		ExistTime = time;
	}public void SetTransform(Vector pos, Vector size) {
		super.x = (int)pos.x;
		super.y = (int)pos.y;
		super.width= (int)size.x;
		super.height = (int)size.y;
	}	
}
