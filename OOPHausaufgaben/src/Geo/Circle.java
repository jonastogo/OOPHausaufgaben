package Geo;

import java.io.Serializable;

public class Circle extends Primitive implements Serializable {
	private Point	Mittelpunkt;
	private Double	Radius;

	public Circle(int x, int y, double r) {
		this.Mittelpunkt = new Point(x, y);
		this.Radius = r;
		this.corner = false;
	}

	protected Double berechneUmfang() {
		double x = (2 * Math.PI * this.Radius);
		return Math.round(x * 1000) / 1000.0;
	}

	protected Double berechneFlaeche() {
		double x = (Math.PI * (Radius * Radius));
		return Math.round(x * 1000) / 1000.0;
	}

	public String toString() {
		return (String) ("Typ:\tKreis,\t\tFl�cheninhalt:\t" + berechneFlaeche() + ",\tUmfang:\t" + berechneUmfang());
	}
}
