package entity;

import java.awt.Graphics;
import java.awt.Rectangle;

import game_world.Tile;
import game_world.Vector;
import resources.Resources;

public class Entity extends Rectangle{

	private static final long serialVersionUID = 1L;
	protected Vector facing;// cái hướng mà con entity đó đang hướng tới
	protected int curFrame;// ảnh hiện tại
	protected int delayTime;// đang ở ảnh 1 muốn sang ảnh 2 phải đợi 1 khoảng thời gian
	protected int frameCount;// số ảnh trong bộ animation
	protected byte imgID;// chỉ đến cái vị trí của cái ảnh trong mảng các ảnh
	protected float speed;// tốc độ
	private int curDelayTime;// 1 cái số đếm
	// delaytime = 20s // cố định sẽ không thay đổi
	// 19 curDe
	public Entity(int x, int y, Vector facing, int delayTime, int frameCount, byte imgID, float speed) {
		super(x*Tile.size, y*Tile.size, Tile.size, Tile.size);
		this.facing = facing;
		this.delayTime = delayTime;
		this.frameCount = frameCount;
		this.imgID = imgID;
		this.speed = speed;
		curDelayTime=delayTime;
	}
	
	public void OnLoop() {
		// những việc mà enity sẽ làm trong 1 vòng lặp
		// là 1 trạng thái của  game
		// lúc play thì nó sẽ tạo 1 vòng lặp vô tận đến khi ....
	}
	public void Render(Graphics g) {
		
		g.drawImage(Resources.TEXTURES.get(imgID + curFrame), x, y, width, height, null);
	}
	
	public void DecreaseTime() {
		// 
	}
	// con nào nó override thì nó ko đi qua
	public void CollisionWall(Tile tile) {
		Rectangle rectangle = this.intersection(tile);
		if(rectangle.isEmpty() || tile.GetProperty() != 1) return;
		if(rectangle.width > rectangle.height) {
			if(this.y < tile.y)
				this.y = tile.y - this.height;
			else
				this.y = tile.y + this.height;
		}
		else {
			if(this.x < tile.x)
				this.x = tile.x - this.width;
			else
				this.x = tile.x + this.width;
		}
	}
	public void SetFacing(Vector facing) {
		this.facing=facing;
		
	}
	public Vector GetFacing() {
		return facing;
	}
	public void SetCenterY(int y) {
		super.y= y - height/2;
	}
	
	public void AnimationDisplay() {
		if(curDelayTime > 0)curDelayTime--;
		else {
			curFrame = (curFrame + 1) % frameCount;
			curDelayTime=delayTime;
		}
	}
}
