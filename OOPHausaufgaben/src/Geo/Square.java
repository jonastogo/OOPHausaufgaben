package Geo;

import java.io.Serializable;

public class Square extends Primitive implements Serializable {
	private Point	Startpunkt;
	private Double	Laenge;

	public Square(int x, int y, double l) {
		this.Startpunkt = new Point(x, y);
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
		return (String) ("Typ:\tQuadrat,\tFl�cheninhalt:\t" + berechneFlaeche() + ",\tUmfang:\t" + berechneUmfang());
	}

}
