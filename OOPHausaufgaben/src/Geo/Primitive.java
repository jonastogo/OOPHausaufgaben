package Geo;

import java.io.Serializable;

@SuppressWarnings("serial")
public abstract class Primitive implements Serializable {

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

}
