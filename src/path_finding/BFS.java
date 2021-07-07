package path_finding;
import java.util.Queue;
import java.util.ArrayDeque;

import game_world.Tile;
import game_world.Vector;

public class BFS {
	private Tile[][] tiles;
	public BFS(Tile[][] tiles) {
		System.out.println(tiles.length + "---" + tiles[0].length);
		this.tiles = new Tile[tiles.length][tiles[0].length];
		for(int i = 0;i< tiles.length;i++) {
			for(int j=0;j<tiles[i].length;j++) {
				this.tiles[i][j] = tiles[i][j];
			}
		}
	}
	public Vector FindNextNode(int sx, int sy, int tx, int ty) {
		if(sx==tx && sy==ty) return new Vector(0,0);
		
		boolean[][] visit = new boolean[tiles.length][tiles[0].length];
		
		for(int i=0;i<tiles.length;i++) {
			for(int j=0;j<tiles[0].length;j++) {
				visit[i][j]=false;
			}
		}
		
		Queue<Tile> queue = new ArrayDeque<Tile>();
		queue.add(tiles[tx][ty]);
		visit[tx][ty] = true;
		int curx = tx;
		int cury = ty;
		
		
		while(queue.size()>0) {
			Tile curTile = queue.remove();
			curx = curTile.y/Tile.size;
			cury = curTile.x/Tile.size;
			
			if(curx>0) {
				if(!visit[curx-1][cury] && tiles[curx-1][cury].GetProperty()!=1) {
					visit[curx-1][cury]= true;
					if(curx-1==sx && cury == sy) {
						System.out.println("o");
						return Vector.Down;
					}
					
					queue.add(tiles[curx-1][cury]);
				}
			}
			if(curx<tiles.length-1) {
				if(!visit[curx+1][cury] && tiles[curx+1][cury].GetProperty()!=1) {
					visit[curx+1][cury]= true;
					if(curx+1==sx && cury == sy) {
						System.out.println("o");
						return Vector.Up;
					}
					queue.add(tiles[curx+1][cury]);
				}
			}
			if(cury>0) {
				if(!visit[curx][cury-1] && tiles[curx][cury-1].GetProperty()!=1) {
					visit[curx][cury-1]= true;
					if(curx==sx && cury-1 == sy) {
						System.out.println("o");
						return Vector.Right;
					}
					queue.add(tiles[curx][cury-1]);
				}
			}
			if(cury<tiles[0].length-1) {
				if(!visit[curx][cury+1] && tiles[curx][cury+1].GetProperty()!=1) {
					visit[curx][cury+1]= true;
					if(curx==sx && cury+1 == sy) {
						System.out.println("o");
						return Vector.Left;
					}
					queue.add(tiles[curx][cury+1]);
				}
			}
		}
		System.out.println("Default");
		return Vector.Up;
	}
}