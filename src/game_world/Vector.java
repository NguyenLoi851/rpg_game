package game_world;

public class Vector {
	public float x;
	public float y;
	public Vector(float x, float y) {
		this.x=x;
		this.y=y;
	}
	public static final Vector Up = new Vector(0,-1);
	public static final Vector Down = new Vector(0,1);
	public static final Vector Right = new Vector(1,0);
	public static final Vector Left = new Vector(-1,0);
	public Vector Nomalize() {
		float dis = Length();
		return new Vector(x/dis,y/dis);
	}public float Length() {
		return (float) Math.sqrt(x*x+y*y);
	}
	public boolean Equals(Vector other) {
        return Math.abs(x-other.x)<0.001 && Math.abs(y-other.y)<0.001;
    }
	}
