package KfZVerwaltung;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class KfZ {
	private Map<String, String>	kfz	= new HashMap<String, String>();

	public static void main(String[] args) {

		KfZ kfz = new KfZ();
	}

	public KfZ() {
		addLandkreis("BI", "Bielefeld");
		addLandkreis("HF", "Herford");
		addLandkreis("MI", "Minden");
		addLandkreis("HF", "Herford");
		print();
		System.out.println("Zum Landkreis Herford gehoert das Kuerzel: " + sucheLandkreis("Herford"));
		System.out.println();
		System.out.println("Zum Kuerzel BI gehoert der Landkreis: " + sucheKFZKuerzel("BI"));
		removeLandkreis("Herford");
		print();
		System.out.println();
		addLandkreis("HF", "Herford");
		print();
	}

	public String sucheKFZKuerzel(String kuerzel) {
		Set set = kfz.entrySet();
		Iterator it = set.iterator();
		while (it.hasNext()) {
			Map.Entry me = (Map.Entry) it.next();
			if (me.getKey().equals(kuerzel))
				return me.getValue().toString();
		}
		return null;
	}

	public String sucheLandkreis(String landkreis) {
		Set set = kfz.entrySet();
		Iterator it = set.iterator();
		while (it.hasNext()) {
			Map.Entry me = (Map.Entry) it.next();
			if (me.getValue().equals(landkreis))
				return me.getKey().toString();
		}
		return null;
	}

	public void print() {
		Set set = kfz.entrySet();
		Iterator it = set.iterator();
		System.out.println("\nAusgabe der Hashmap");
		System.out.println("-------------------");
		while (it.hasNext()) {
			Map.Entry me = (Map.Entry) it.next();
			System.out.println("Key: " + me.getKey() + " & Value: " + me.getValue());
		}
	}

	public void addLandkreis(String kuerzel, String landkreis) {
		if (sucheLandkreis(landkreis) == null && sucheKFZKuerzel(kuerzel) == null) {
			kfz.put(kuerzel, landkreis);
			System.out.println("Hinzugefuegt wurde: Key: " + kuerzel + " & Value: " + landkreis);
		} else
			System.out.println("\nDer Landkreis " + landkreis + "(" + kuerzel + ") ist bereits enthalten!");

	}

	public void removeLandkreis(String landkreis) {
		String gesucht = sucheLandkreis(landkreis);
		if (gesucht != null) {
			for (String key : kfz.keySet()) {
				if (key.equals(gesucht)) {
					kfz.remove(gesucht);
				}
			}
		} else
			System.out.println("\n" + landkreis + " war nie vorhanden!");
	}

}
