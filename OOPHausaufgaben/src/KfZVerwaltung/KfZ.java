package KfZVerwaltung;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class KfZ {
	static Map<String, String>	kfz	= new HashMap<String, String>();

	public static void main(String[] args) {
		addLandkreis("BI", "Bielefeld");
		addLandkreis("HF", "Herford");
		addLandkreis("MI", "Minden");
		addLandkreis("HF", "Herford");
		print();
		System.out.println("Zum Landkreis Herford geh�rt das K�rzel: " + sucheLandkreis("Herford"));
		System.out.println();
		System.out.println("Zum K�rzel BI geh�rt der Landkreis: " + sucheKFZK�rzel("BI"));
		removeLandkreis("Herford");
		print();
		System.out.println();
		addLandkreis("HF", "Herford");
		print();
	}

	public static String sucheKFZK�rzel(String k�rzel) {
		Set set = kfz.entrySet();
		Iterator it = set.iterator();
		while (it.hasNext()) {
			Map.Entry me = (Map.Entry) it.next();
			if (me.getKey().equals(k�rzel))
				return me.getValue().toString();
		}
		return null;
	}

	public static String sucheLandkreis(String landkreis) {
		Set set = kfz.entrySet();
		Iterator it = set.iterator();
		while (it.hasNext()) {
			Map.Entry me = (Map.Entry) it.next();
			if (me.getValue().equals(landkreis))
				return me.getKey().toString();
		}
		return null;
	}

	public static void print() {
		Set set = kfz.entrySet();
		Iterator it = set.iterator();
		System.out.println("\nAusgabe der Hashmap");
		System.out.println("-------------------");
		while (it.hasNext()) {
			Map.Entry me = (Map.Entry) it.next();
			System.out.println("Key: " + me.getKey() + " & Value: " + me.getValue());
		}
	}

	public static void addLandkreis(String k�rzel, String landkreis) {
		if (sucheLandkreis(landkreis) == null && sucheKFZK�rzel(k�rzel) == null) {
			kfz.put(k�rzel, landkreis);
			System.out.println("Hinzugef�gt wurde: Key: " + k�rzel + " & Value: " + landkreis);
		} else
			System.out.println("\nDer Landkreis " + landkreis + "(" + k�rzel + ") ist bereits enthalten!");

	}

	public static void removeLandkreis(String landkreis) {
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
