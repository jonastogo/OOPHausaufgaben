package Geo;

import java.io.Serializable;

@SuppressWarnings("serial")
public abstract class Primitive implements Serializable, Comparable<Primitive> {

	protected abstract Double berechneUmfang();

	protected abstract Double berechneFlaeche();

	protected boolean	corner;

	public String toString() {

		return "UNIMPLEMENTED U KNUB";
	}

	public String toClassString() {
		return String.format("Class: %s", this.getClass().getCanonicalName());
	}

	protected boolean isCorner() {
		return corner;
	}

	protected void setCorner(boolean corner) {
		this.corner = corner;
	}

	@Override
	public int compareTo(Primitive o) {
		if (o.berechneFlaeche() == null && this.berechneFlaeche() == null) {
			return 0;
		}
		if (this.berechneFlaeche() == null) {
			return 1;
		}
		if (o.berechneFlaeche() == null) {
			return -1;
		}
		if (this.berechneFlaeche().compareTo(o.berechneFlaeche()) == 0) {
			if (o.berechneUmfang() == null && this.berechneUmfang() == null) {
				return 0;
			}
			if (this.berechneUmfang() == null) {
				return 1;
			}
			if (o.berechneUmfang() == null) {
				return -1;
			}
			return this.berechneUmfang().compareTo(o.berechneUmfang());
		}
		return this.berechneFlaeche().compareTo(o.berechneFlaeche());

	}
}
