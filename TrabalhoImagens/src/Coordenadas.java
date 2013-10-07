
public class Coordenadas {
	private int x;
	private int y;

	Coordenadas(int x, int y){
		this.x = x;
		this.y = y;
	}

	public int getX(){
		return x;
	}

	public int getY(){
		return y;
	}

	public boolean equals(Coordenadas coord){
		boolean ret = coord.getX() == this.x && coord.getY() == this.y;
		return ret;

	}

}
