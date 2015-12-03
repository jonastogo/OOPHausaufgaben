package Geo;

import java.io.Serializable;

public class Point implements Serializable {
	private int	X;
	private int	Y;

	public Point(int x, int y) {
		this.X = x;
		this.Y = y;
	}
}
