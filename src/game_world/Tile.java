package game_world;

import java.awt.Rectangle;

import resources.Resources;

public class Tile extends Rectangle{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private byte id;
	public static final int size = 50;
	private byte prop;
	// 0: None
	// 1: Wall
	// 2: Water
	public Tile(byte id,int x,int y) {
		super(x * size, y * size, size, size);
		this.id = id;
		if(id== Resources.WALL || id==Resources.STONE || id== Resources.TREE)prop=1;
		else if(id >=Resources.WALL1 && id<=Resources.WALL21)prop = 1;
		else if(id==Resources.WATER || id==Resources.DIRT)prop=2;
		else prop=0;
	}
	public byte GetProperty() {
		return prop;
	}
	public byte getID() {
		return id;
	}
}
