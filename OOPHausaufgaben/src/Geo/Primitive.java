package Geo;

import java.io.Serializable;

public abstract class Primitive implements Serializable {
	protected abstract Double berechneUmfang();

	protected abstract Double berechneFlaeche();

	public String toString(){
		return "";
	}

	boolean	corner;

}
