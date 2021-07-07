package entity;

import java.awt.Graphics;
import java.util.Random;
import game_world.Room;
import game_world.Tile;
import game_world.Vector;
import resources.Resources;

public class AD extends Monster {

	private static final long serialVersionUID = 1L;

	public AD(int x, int y, Vector facing, int delayTime, int frameCount, byte imgID, float speed, Room room, int hp,
			boolean freeze, int damage, int attackTime) {
		super(x, y, facing, delayTime, frameCount, imgID, (byte) 0, speed, room, hp, freeze, damage, attackTime);
		// TODO Auto-generated constructor stub
		b = new Bullet(this.x, this.y, this.facing, 20, 1, Resources.BULLET, 5, room, 2);
		m = new Missile(this.x, this.y, this.facing, 20, 1, Resources.MISSILE, 5, room, 2);
		b.SetAlive(false);
		m.SetAlive(false);
	}

	private Bullet b;
	private Missile m;

	public void OnLoop() {
		AnimationDisplay();
		super.CollisionQ();
		super.CollisionR();
		for (int i = 0; i < Room.Ysize; i++) {
			for (int j = 0; j < Room.Xsize; j++) {
				super.CollisionWall(room.GetTile(i, j));
			}
		}
		DecreaseTime();
		if (b.GetAlive())
			b.OnLoop();
		if (m.GetAlive())
			m.OnLoop();
		Escape();
	}

	public void DecreaseTime() {
		if (super.curATime > 0)
			super.curATime--;
		else {
			Attack();
			curATime = AttackTime;
		}
	}

	protected void Attack() {
		Random r = new Random();
		int ran = r.nextInt(2);
		if (ran == 0) {
			Vector v = new Vector(player.x - this.x, player.y - this.y);
			v = v.Nomalize();
			b.SetFacing(v);
			b.x = this.x;
			b.y = this.y;
			b.SetAlive(true);
			b.SetExistTime(100);
		} else {
			m.x = this.x;
			m.y = this.y;
			m.SetAlive(true);
			m.SetExistTime(100);
		}
	}

	public void Render(Graphics g) {
		super.Render(g);
		if (b.GetAlive())
			b.Render(g);
		if (m.GetAlive())
			m.Render(g);
	}

	public void Escape() {
		if (super.x % Tile.size == 0 && super.y % Tile.size == 0) {
			facing = new Vector(0, 0);
			Vector d = new Vector((float) player.x - (float) super.x, (float) player.y - (float) super.y);
			if (d.Length() < 90) {
				System.out.println("Escape");
				int i = super.y / Tile.size;
				int j = super.x / Tile.size;
				if (i > 0) {
					Tile tile = room.GetTile(i - 1, j);
					if (tile.GetProperty() != 1) {
						Vector d1 = new Vector((float) player.x - (float) tile.x, (float) player.y - (float) tile.y);
						if (d1.Length() > d.Length()) {
							d = d1;
							facing = Vector.Up;
						}
					}
				}
				if (i < Room.Ysize - 1) {
					Tile tile = room.GetTile(i + 1, j);
					if (tile.GetProperty() != 1) {
						Vector d1 = new Vector((float) player.x - (float) tile.x, (float) player.y - (float) tile.y);
						if (d1.Length() > d.Length()) {
							d = d1;
							facing = Vector.Down;
						}
					}
				}
				if (j > 0) {
					Tile tile = room.GetTile(i, j - 1);
					if (tile.GetProperty() != 1) {
						Vector d1 = new Vector((float) player.x - (float) tile.x, (float) player.y - (float) tile.y);
						if (d1.Length() > d.Length()) {
							d = d1;
							facing = Vector.Left;
						}
					}
				}
				if (j < Room.Xsize - 1) {
					Tile tile = room.GetTile(i, j + 1);
					if (tile.GetProperty() != 1) {
						Vector d1 = new Vector((float) player.x - (float) tile.x, (float) player.y - (float) tile.y);
						if (d1.Length() > d.Length()) {
							d = d1;
							facing = Vector.Right;
						}
					}
				}

			}

		}
		super.x = (int) (super.x + facing.x * speed);
		super.y = (int) (super.y + facing.y * speed);
		if (super.y < 0)
			super.y = 0;
		if (super.y > (Room.Ysize - 1) * Tile.size)
			super.y = (Room.Ysize - 1) * Tile.size;
	}
}
