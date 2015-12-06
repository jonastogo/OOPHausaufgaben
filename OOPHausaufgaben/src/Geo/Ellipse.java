package Geo;

import java.io.Serializable;

public class Ellipse extends Primitive implements Serializable {
	/**
	 * 
	 */
	private static final long	serialVersionUID	= 1L;
	private Point				Mittelpunkt;
	private Double				Halbachse1;
	private Double				Halbachse2;

	public Ellipse(int x, int y, double ha1, double ha2) {
		this.setMittelpunkt(new Point(x, y));
		this.Halbachse1 = ha1;
		this.Halbachse2 = ha2;
		this.corner = false;
	}

	protected Double berechneUmfang() {
		double x = (Math.PI * (this.Halbachse1 + this.Halbachse2));
		return Math.round(x * 1000) / 1000.0;
	}

	protected Double berechneFlaeche() {
		double x = (Math.PI * this.Halbachse1 * this.Halbachse2);
		return Math.round(x * 1000) / 1000.0;
	}

	public String toString() {
		return (String) ("Typ:\tEllipse,\tFlächeninhalt:\t" + berechneFlaeche() + ",\tUmfang:\t" + berechneUmfang());
	}

	public Point getMittelpunkt() {
		return Mittelpunkt;
	}

	public void setMittelpunkt(Point mittelpunkt) {
		Mittelpunkt = mittelpunkt;
	}
}
