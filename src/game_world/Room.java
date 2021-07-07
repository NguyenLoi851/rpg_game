package game_world;

import java.awt.Graphics;
import java.util.ArrayList;

import entity.*;
import resources.Resources;

public class Room {
	public static final int Xsize = 16;
	public static final int Ysize = 9;
	private Tile[][] tiles;
	private ArrayList<Enemy> entities;
	private Player player;
	public Player GetPlayer() {
		return player;
	}
	public void SetPlayer(Player player) {
		this.player = player;
	}
	public Room(byte [][] ids) {

		tiles= new Tile[Ysize][Xsize];
		
		entities = new ArrayList<Enemy>();
		
		for(int i=0;i<Ysize;i++){
			for(int j=0;j<Xsize;j++) {
		        tiles[i][j] = new Tile(ids[i][j],j,i);
			}
		}
	}
	public Tile GetTile(int i, int j) {
		return tiles[i][j];
	}
	
	public void Render(Graphics g) {
		
		for(int i=0;i<Ysize;i++) {
			for(int j=0;j<Xsize;j++) {
				g.drawImage(Resources.TEXTURES.get(tiles[i][j].getID()), tiles[i][j].x, tiles[i][j].y, tiles[i][j].width, tiles[i][j].height, null);
			}
		}
		for(Enemy entity: entities) {
			if(entity.GetAlive())
			entity.Render(g);
	
		}
	}
	public void Loop() {
		for(Enemy enemy : entities) {
			if(enemy.GetAlive())
			enemy.OnLoop();
			
		}
	}
	public ArrayList<Enemy> GetEntities() {
		return entities;
	}

	public Tile[][] GetTiles(){
		return tiles;
	}
}
