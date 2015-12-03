package Geo;

import java.io.Serializable;

public class Rectangle extends Primitive implements Serializable {
	private Point	Startpunkt;
	private Double	Laenge;
	private Double	Breite;

	public Rectangle(int x, int y, double l, double b) {
		this.Startpunkt = new Point(x, y);
		this.Laenge = l;
		this.Breite = b;
		this.corner = true;
	}

	protected Double berechneUmfang() {
		double x = (2 * this.Laenge + 2 * this.Breite);
		return Math.round(x * 1000) / 1000.0;
	}

	protected Double berechneFlaeche() {
		double x = (this.Laenge * this.Breite);
		return Math.round(x * 1000) / 1000.0;
	}

	public String toString() {
		return (String) ("Typ:\tRechteck,\tFl�cheninhalt:\t" + berechneFlaeche() + ",\tUmfang:\t" + berechneUmfang());
	}

}
