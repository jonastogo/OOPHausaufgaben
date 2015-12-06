package Geo;

import java.io.Serializable;

public class Point implements Serializable {
	/**
	 * 
	 */
	private static final long	serialVersionUID	= 1L;
	private int					X;
	private int					Y;

	public Point(int x, int y) {
		this.X = x;
		this.Y = y;
	}

	public int getX() {
		return X;
	}

	public void setX(int x) {
		X = x;
	}

	public int getY() {
		return Y;
	}

	public void setY(int y) {
		Y = y;
	}

}
