package Geo;

import java.io.Serializable;

public class Square extends Primitive implements Serializable {
	/**
	 * 
	 */
	private static final long	serialVersionUID	= 1L;
	private Point				Startpunkt;
	private Double				Laenge;

	public Square(int x, int y, double l) {
		this.setStartpunkt(new Point(x, y));
		this.Laenge = l;
		this.corner = true;
	}

	protected Double berechneUmfang() {
		double x = (4 * this.Laenge);
		return Math.round(x * 1000) / 1000.0;
	}

	protected Double berechneFlaeche() {
		double x = (this.Laenge * this.Laenge);
		return Math.round(x * 1000) / 1000.0;
	}

	public String toString() {
		return (String) ("Typ:\tQuadrat,\tFlächeninhalt:\t" + berechneFlaeche() + ",\tUmfang:\t" + berechneUmfang());
	}

	public Point getStartpunkt() {
		return Startpunkt;
	}

	public void setStartpunkt(Point startpunkt) {
		Startpunkt = startpunkt;
	}
}
