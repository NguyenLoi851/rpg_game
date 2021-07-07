package entity;

import java.awt.Graphics;
import java.awt.Rectangle;

import game_world.Room;
import game_world.Tile;
import game_world.Vector;
import resources.Resources;

public class Player extends Entity {
	public Player(int x, int y, int delayTime, int frameCount, byte imgID, float speed) {
		super(x, y, Vector.Up, delayTime, frameCount, imgID, speed);
		// TODO Auto-generated constructor stub
		hp = 20;
		mp = 10;
		def = 0;
		QTime = 0;
		RTime = 0;
		freezeTime = 0;
		damTime = 0;
		q = new QSkill(0, 0, Vector.Up, 1, 1, Resources.Q, 0);
		r = new RSkill(0, 0, Vector.Up, 1, 1, Resources.R, 10);
	}

	private static final long serialVersionUID = 1L;
	private int hp;
	private int mp;
	private int def;
	private int QTime;
	private int RTime;
	private int damTime;
	private QSkill q;
	private RSkill r;
	private int freezeTime;
	private Room room;
	private boolean move = false;

	public void Move() {
		if (move) {

			super.x = (int) (super.x + facing.x * speed);
			super.y = (int) (super.y + facing.y * speed);
		}
	}

	@Override
	public void DecreaseTime() {

		if (QTime > 0)
			QTime--;
		if (RTime > 0)
			RTime--;
		if (freezeTime > 0)
			freezeTime--;
		if (damTime > 0)
			damTime--;// thời gian giữa 2 lần bị trừ máu

	}

	public void AttackQ() {
		if (QTime == 0) {

			QTime = 10;
			q.SetExistTime(5);// thời gian tồn tại trên màn hình(10 vòng lặp)
			q.SetTransform(new Vector(this.x + facing.x * this.height, this.y + facing.y * this.width),
					new Vector(Tile.size, Tile.size));
			q.SetFacing(this.facing);
		}
	}

	public void AttackR() {
		if (mp > 0) {
			if (RTime == 0) {
				RTime = 500;
				mp--;
				r.SetExistTime(50);
				r.SetTransform(new Vector(this.x + facing.x * this.height, this.y + facing.y * this.width),
						new Vector(Tile.size, Tile.size));
				r.SetFacing(this.facing);// = hướng của player
			}
		}

	}

	public QSkill GetQPos() {
		return q;
	}

	public RSkill GetRPos() {
		return r;
	}

	public void TakeHP(int amount) {
		if (amount > 0) {
			this.hp += amount;
		} else {
			damTime = 30;
			if (def > 0) {
				hp += amount / def;
				def--;
			} else
				hp += amount;

			if (hp < 0) {
				hp = 0;
			}
		}
	}

	public void TakeMP(int amount) {
		this.mp += amount;
		if (mp < 0) {
			mp = 0;
		}
	}

	public void TakeDef(int amount) {
		this.def += amount;
		if (def < 0) {
			def = 0;
		}
	}

	public void OnLoop() {
		if (move)
			AnimationDisplay();
		DecreaseTime();
		for (int i = 0; i < Room.Ysize; i++) {
			for (int j = 0; j < Room.Xsize; j++) {
				super.CollisionWall(room.GetTile(i, j));
				CollisionWater(room.GetTile(i, j));
			}
		}
		if (freezeTime == 0) {
			frameCount = 2;
			Move();
		}
		q.OnLoop();
		r.OnLoop();
	}

	public void Render(Graphics g) {
		if (freezeTime == 0) {
			if (facing.Equals(Vector.Up)) {
				imgID = Resources.PLAYER_BACK;
			} else if (facing.Equals(Vector.Down)) {
				imgID = Resources.PLAYER;
			} else if (facing.Equals(Vector.Left)) {
				imgID = Resources.PLAYER_LEFT;
			} else if (facing.Equals(Vector.Right)) {
				imgID = Resources.PLAYER_RIGHT;
			}
		}
		super.Render(g);
		if (damTime > 0)
			g.drawImage(Resources.TEXTURES.get(Resources.BLOOD), this.x, this.y, Tile.size, Tile.size, null);
		q.Render(g);
		r.Render(g);
	}

	public void SetRoom(Room room) {
		this.room = room;
	}

	public void SetFreezeTime(int time) {
		freezeTime = time;
		imgID = Resources.PLAYER_ICE;
		frameCount = 1;
	}

	public void CollisionWater(Tile tile) {
		Rectangle rectangle = this.intersection(tile);
		if (rectangle.isEmpty())
			return;
		if (tile.GetProperty() == 2) {
			speed = 1;
			return;
		}
		speed = 5;
	}

	public Vector GetFacing() {
		return facing;
	}

	public void SetMove(boolean move) {
		this.move = move;
	}

	public int getHp() {
		return hp;
	}

	public int getMp() {
		return mp;
	}

	public int getDef() {
		return def;
	}

	public int getQTime() {
		return QTime;
	}

	public int getRTime() {
		return RTime;
	}
}
