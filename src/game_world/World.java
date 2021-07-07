package game_world;

import entity.AD;
import entity.Enemy;
import entity.Ghost;
import entity.Item;
import entity.Monster;
import entity.Obstacle;
import entity.Player;
import game_state.GameStateManager;
import game_state.MainMenu;
import resources.Resources;

public class World {
	public static final int count = 6;
	private Room[] rooms;
	private Player player;
	private int curRoom = 0;

	public World(Player player) {
		System.out.print("Init World\n");

		rooms = new Room[] {
				// 0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15
				new Room(new byte[][] { { 58, 58, 58, 58, 58, 69, 59, 0, 0, 60, 69, 69, 69, 58, 58, 58 },
						{ 58, 58, 58, 58, 59, 0, 2, 2, 2, 0, 0, 0, 0, 60, 69, 58 },
						{ 58, 58, 69, 59, 0, 0, 2, 2, 2, 0, 0, 0, 0, 0, 0, 71 },
						{ 58, 59, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 71 },
						{ 70, 0, 0, 0, 2, 2, 2, 2, 0, 0, 0, 0, 0, 51, 52, 58 },
						{ 70, 0, 0, 0, 2, 2, 61, 57, 55, 0, 0, 0, 51, 58, 58, 58 },
						{ 58, 53, 0, 0, 0, 0, 0, 0, 0, 0, 51, 52, 58, 58, 58, 58 },
						{ 58, 58, 53, 0, 0, 0, 0, 0, 0, 51, 58, 58, 58, 58, 58, 58 },
						{ 58, 58, 58, 52, 52, 52, 52, 52, 52, 58, 58, 58, 58, 58, 58, 58 } }),

				new Room(new byte[][] { { 58, 58, 58, 58, 58, 69, 59, 0, 60, 69, 69, 58, 58, 58, 58, 58 },
						{ 58, 58, 58, 69, 59, 0, 0, 0, 0, 0, 0, 60, 69, 69, 58, 58 },
						{ 58, 69, 59, 0, 0, 0, 0, 2, 2, 0, 0, 0, 0, 0, 60, 58 },
						{ 70, 0, 0, 0, 0, 2, 2, 2, 2, 0, 63, 0, 0, 0, 0, 71 },
						{ 70, 0, 0, 6, 0, 2, 2, 2, 2, 2, 67, 0, 0, 0, 51, 58 },
						{ 58, 52, 53, 0, 0, 0, 2, 2, 0, 0, 62, 0, 0, 0, 71, 58 },
						{ 58, 58, 58, 52, 53, 0, 0, 0, 0, 0, 0, 0, 0, 51, 58, 58 },
						{ 58, 58, 58, 58, 58, 53, 0, 0, 0, 0, 0, 51, 52, 58, 58, 58 },
						{ 58, 58, 58, 58, 58, 58, 53, 0, 0, 51, 52, 58, 58, 58, 58, 58 } }),

				new Room(new byte[][] { { 58, 58, 58, 58, 58, 69, 69, 69, 69, 69, 69, 69, 59, 0, 60, 58 },
						{ 58, 58, 58, 69, 59, 0, 0, 0, 0, 0, 0, 0, 2, 2, 2, 71 },
						{ 58, 69, 59, 0, 0, 0, 2, 2, 2, 0, 0, 0, 0, 0, 61, 58 },
						{ 70, 0, 0, 0, 0, 68, 2, 2, 2, 0, 0, 2, 2, 0, 0, 71 },
						{ 70, 0, 0, 0, 0, 2, 2, 2, 2, 2, 0, 0, 0, 0, 51, 58 },
						{ 58, 52, 53, 0, 0, 0, 2, 2, 0, 0, 68, 0, 0, 0, 71, 58 },
						{ 58, 58, 58, 52, 53, 0, 0, 0, 0, 0, 0, 0, 0, 51, 58, 58 },
						{ 58, 58, 58, 58, 58, 53, 0, 0, 0, 0, 0, 51, 52, 58, 58, 58 },
						{ 58, 58, 58, 58, 58, 58, 53, 0, 51, 52, 52, 58, 58, 58, 58, 58 } }),

				new Room(new byte[][] { { 58, 58, 58, 58, 58, 69, 59, 0, 0, 0, 60, 58, 58, 58, 58, 58 },
						{ 58, 58, 58, 69, 59, 0, 0, 0, 0, 0, 0, 62, 0, 60, 69, 58 },
						{ 58, 58, 59, 0, 0, 0, 0, 61, 55, 0, 0, 0, 0, 0, 0, 71 },
						{ 58, 59, 0, 0, 51, 52, 53, 0, 0, 0, 61, 55, 0, 0, 0, 71 },
						{ 70, 0, 0, 0, 71, 58, 70, 0, 0, 0, 0, 0, 0, 51, 52, 58 },
						{ 70, 0, 0, 0, 60, 69, 59, 0, 0, 0, 0, 0, 51, 58, 58, 58 },
						{ 58, 53, 0, 0, 0, 0, 0, 68, 0, 0, 63, 0, 60, 69, 58, 58 },
						{ 58, 58, 53, 0, 0, 63, 0, 0, 0, 51, 70, 0, 0, 0, 71, 58 },
						{ 58, 58, 58, 52, 52, 58, 52, 52, 52, 58, 58, 52, 53, 0, 71, 58 } }),

				new Room(new byte[][] { { 58, 58, 58, 58, 58, 69, 69, 69, 69, 69, 69, 58, 59, 0, 71, 58 },
						{ 58, 58, 58, 58, 59, 0, 2, 2, 2, 2, 0, 62, 0, 0, 60, 58 },
						{ 58, 58, 58, 59, 0, 0, 2, 2, 2, 2, 0, 0, 68, 0, 0, 71 },
						{ 58, 59, 0, 0, 63, 0, 0, 0, 0, 2, 2, 0, 0, 0, 0, 71 },
						{ 70, 0, 0, 51, 70, 2, 0, 2, 0, 2, 0, 0, 0, 0, 0, 71 },
						{ 70, 0, 0, 60, 69, 59, 0, 0, 0, 0, 68, 0, 0, 68, 0, 71 },
						{ 58, 53, 0, 0, 0, 0, 0, 68, 2, 0, 0, 0, 0, 0, 51, 58 },
						{ 58, 58, 53, 0, 0, 63, 2, 2, 2, 2, 0, 0, 0, 0, 71, 58 },
						{ 58, 58, 58, 52, 52, 58, 53, 0, 0, 0, 51, 52, 52, 52, 58, 58 } }),
				new Room(new byte[][] { { 58, 58, 58, 58, 58, 69, 69, 69, 69, 69, 69, 58, 58, 58, 58, 58 },
						{ 58, 58, 58, 69, 59, 0, 0, 0, 0, 0, 0, 60, 69, 69, 58, 58 },
						{ 58, 69, 59, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 60, 58 },
						{ 70, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 71 },
						{ 70, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 51, 58 },
						{ 58, 52, 53, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 71, 58 },
						{ 58, 58, 58, 52, 53, 0, 0, 0, 0, 0, 0, 0, 0, 0, 71, 58 },
						{ 58, 58, 58, 58, 58, 53, 0, 0, 0, 0, 0, 51, 53, 0, 71, 58 },
						{ 58, 58, 58, 58, 58, 58, 52, 52, 52, 52, 52, 58, 70, 0, 71, 58 } }), };

		System.out.print("Init World_1\n");
		this.player = player;
		for (Room room : rooms) {
			room.SetPlayer(player);
		}
		player.SetRoom(rooms[0]);
		if (MainMenu.getLevel() == 0) {
			// room 0
			rooms[0].GetEntities().add(new Enemy(3, 7, Vector.Up, 0, 0, Resources.UFO, 0, rooms[0]));
			rooms[0].GetEntities().add(new Monster(4, 2, Vector.Up, 2, 2, Resources.MONSTER, Resources.MONSTER_ATTACK,
					1, rooms[0], 10, false, 1, 20));
			rooms[0].GetEntities().add(new Monster(10, 2, Vector.Up, 2, 2, Resources.MONSTER, Resources.MONSTER_ATTACK,
					1, rooms[0], 10, false, 1, 20));

			// room 1
			// rooms[1].GetEntities().add(new Monster(3, 2, Vector.Up, 2, 2,
			// Resources.MONSTER, Resources.MONSTER_ATTACK, 2, rooms[1], 10, true, 1, 20));
			rooms[1].GetEntities().add(new AD(12, 3, Vector.Up, 2, 2, Resources.AD, 0, rooms[1], 1, true, 0, 100));
			rooms[1].GetEntities().add(new Item(14, 3, 0, 0, Resources.ITEM, 0, rooms[1]));
			// room 2

			rooms[2].GetEntities().add(new AD(5, 1, Vector.Up, 2, 2, Resources.AD, 0, rooms[2], 1, true, 0, 200));
			rooms[2].GetEntities().add(new AD(13, 5, Vector.Up, 2, 2, Resources.AD, 0, rooms[2], 1, false, 0, 200));
			rooms[2].GetEntities().add(new Monster(11, 2, Vector.Up, 2, 2, Resources.MONSTER, Resources.MONSTER_ATTACK,
					1, rooms[2], 10, false, 1, 20));
			// room 3

			// rooms[3].GetEntities().add(new Ghost(2, 3, Vector.Up, 2, 2,
			// Resources.GHOST,Resources.GHOST_ATTACK, 2, rooms[3], 10, false, 1, 200));
			rooms[3].GetEntities().add(new AD(9, 1, Vector.Up, 2, 2, Resources.AD, 0, rooms[3], 1, false, 0, 50));
			rooms[3].GetEntities().add(new Item(2, 6, 0, 0, Resources.ITEM, 0, rooms[3]));
			// room 4

			rooms[4].GetEntities().add(new Obstacle(11, 5, Vector.Up, 2, 1, Resources.OBSTACLE, 5, rooms[4],
					// new Vector(11*Tile.size, 4*Tile.size),
					// new Vector(11*Tile.size, 7*Tile.size),
					new Vector(rooms[4].GetTile(3, 3).x, rooms[4].GetTile(3, 3).y),
					new Vector(rooms[4].GetTile(3, 14).x, rooms[4].GetTile(3, 14).y), 10));

			rooms[4].GetEntities().add(new Obstacle(11, 5, Vector.Up, 2, 1, Resources.OBSTACLE, 5, rooms[4],
					// new Vector(11*Tile.size, 4*Tile.size),
					// new Vector(11*Tile.size, 7*Tile.size),
					new Vector(rooms[4].GetTile(4, 11).x, rooms[4].GetTile(4, 11).y),
					new Vector(rooms[4].GetTile(7, 11).x, rooms[4].GetTile(7, 11).y), 10));
			// public Enemy(int x, int y,Vector facing, int delayTime, int frameCount, byte
			// imgID, float speed, Room room)
			rooms[5].GetEntities().add(new Enemy(3, 3, Vector.Up, 0, 0, Resources.AD, 0, rooms[5]));
			// rooms[4].GetEntities().add(new Ghost(5, 3, Vector.Up, 2, 2,
			// Resources.GHOST,Resources.GHOST_ATTACK, 5, rooms[4], 10, false, 1, 20));
		} else {
			// room 0
			rooms[0].GetEntities().add(new Enemy(3, 7, Vector.Up, 0, 0, Resources.UFO, 0, rooms[0]));
			rooms[0].GetEntities().add(new Monster(4, 2, Vector.Up, 2, 2, Resources.MONSTER, Resources.MONSTER_ATTACK,
					2, rooms[0], 10, false, 3, 20));
			rooms[0].GetEntities().add(new Monster(10, 2, Vector.Up, 2, 2, Resources.MONSTER, Resources.MONSTER_ATTACK,
					2, rooms[0], 10, false, 3, 20));

			// room 1
			rooms[1].GetEntities().add(new Monster(3, 2, Vector.Up, 2, 2, Resources.F_MONSTER, Resources.MONSTER_ATTACK,
					2, rooms[1], 10, true, 3, 20));
			rooms[1].GetEntities().add(new AD(12, 3, Vector.Up, 2, 2, Resources.AD, 1, rooms[1], 1, true, 0, 150));
			rooms[1].GetEntities().add(new Item(14, 3, 0, 0, Resources.ITEM, 0, rooms[1]));
			// room 2

			rooms[2].GetEntities().add(new AD(5, 1, Vector.Up, 2, 2, Resources.AD, 3, rooms[2], 1, true, 0, 150));
			rooms[2].GetEntities().add(new AD(13, 5, Vector.Up, 2, 2, Resources.AD, 3, rooms[2], 1, false, 0, 150));
			rooms[2].GetEntities().add(new Monster(11, 2, Vector.Up, 20, 2, Resources.F_MONSTER,
					Resources.MONSTER_ATTACK, 2, rooms[2], 10, true, 3, 150));
			// room 3

			rooms[3].GetEntities().add(new Ghost(2, 3, Vector.Up, 2, 2, Resources.GHOST, Resources.GHOST_ATTACK, 2,
					rooms[3], 10, false, 3, 150));
			rooms[3].GetEntities().add(new AD(9, 1, Vector.Up, 2, 2, Resources.AD, 5, rooms[3], 1, false, 0, 50));
			rooms[3].GetEntities().add(new Item(2, 6, 0, 0, Resources.ITEM, 0, rooms[3]));
			// room 4

			rooms[4].GetEntities().add(new Obstacle(11, 5, Vector.Up, 2, 1, Resources.OBSTACLE, 5, rooms[4],
					// new Vector(11*Tile.size, 4*Tile.size),
					// new Vector(11*Tile.size, 7*Tile.size),
					new Vector(rooms[4].GetTile(3, 3).x, rooms[4].GetTile(3, 3).y),
					new Vector(rooms[4].GetTile(3, 14).x, rooms[4].GetTile(3, 14).y), 10));

			rooms[4].GetEntities().add(new Obstacle(11, 5, Vector.Up, 2, 1, Resources.OBSTACLE, 5, rooms[4],
					// new Vector(11*Tile.size, 4*Tile.size),
					// new Vector(11*Tile.size, 7*Tile.size),
					new Vector(rooms[4].GetTile(4, 11).x, rooms[4].GetTile(4, 11).y),
					new Vector(rooms[4].GetTile(7, 11).x, rooms[4].GetTile(7, 11).y), 10));

			rooms[4].GetEntities().add(new Ghost(5, 3, Vector.Up, 2, 2, Resources.GHOST, Resources.GHOST_ATTACK, 2,
					rooms[4], 10, false, 1, 20));
			rooms[5].GetEntities().add(new Enemy(3, 3, Vector.Up, 0, 0, Resources.AD, 0, rooms[5]));
		}

	}

	public void ChangeRoom() {
		if (player.getCenterY() < rooms[curRoom].GetTile(0, 0).y) {
			curRoom++;
			if (curRoom == count) {
				return;
			}
			player.SetCenterY(Tile.size * Room.Ysize - player.height);
			player.SetRoom(rooms[curRoom]);
			player.GetRPos().SetExistTime(0);
		}
		if (player.getCenterY() > rooms[curRoom].GetTile(Room.Ysize - 1, 0).y + Tile.size) {
			curRoom--;
			player.SetCenterY(player.height);
			player.SetRoom(rooms[curRoom]);
			player.GetRPos().SetExistTime(0);
		}
	}

	public Room GetCurrentRoom() {
		return rooms[curRoom];
	}

	public Room[] GetRooms() {
		return rooms;
	}

	public int GetCur() {
		return curRoom;
	}

}
