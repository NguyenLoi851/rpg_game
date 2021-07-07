package entity;

import game_world.Room;
import game_world.Vector;
import resources.Resources;

public class Ghost extends Monster{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public Ghost(int x, int y, Vector facing, int delayTime, int frameCount, byte imgID, byte attackID, float speed, Room room, int hp,
			boolean freeze, int damage, int attackTime) {
		super(x,y,facing, delayTime, frameCount, imgID, attackID, speed, room, hp, freeze, damage, attackTime);
		// TODO Auto-generated constructor stub
		invisibleTime = 200;
		
	}
	private int invisibleTime;
	public void DecreaseTime() {
		super.DecreaseTime();
		if(invisibleTime>0)
		invisibleTime--;
		else invisibleTime=200;
		// 0- 100 mà 100-200 thường
	}
	public void OnLoop() {
		AnimationDisplay();
		DecreaseTime();
		super.CollisionPlayer();
		super.Move();
		if(invisibleTime > 100) {
			super.CollisionQ();
			super.CollisionR();
			for(int i=0;i<Room.Ysize;i++) {
				for(int j=0;j<Room.Xsize;j++) {
					super.CollisionWall(room.GetTile(i, j));
				}
			}	
		}else {
			imgID = Resources.GHOST_INVISIBLE;
			frameCount = 2;
		}
	}
}
