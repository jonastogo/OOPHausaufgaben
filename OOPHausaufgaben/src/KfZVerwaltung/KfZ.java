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
		System.out.println("Zum Landkreis Herford gehört das Kürzel: " + sucheLandkreis("Herford"));
		System.out.println();
		System.out.println("Zum Kürzel BI gehört der Landkreis: " + sucheKFZKürzel("BI"));
		removeLandkreis("Herford");
		print();
		System.out.println();
		addLandkreis("HF", "Herford");
		print();
	}

	public static String sucheKFZKürzel(String kürzel) {
		Set set = kfz.entrySet();
		Iterator it = set.iterator();
		while (it.hasNext()) {
			Map.Entry me = (Map.Entry) it.next();
			if (me.getKey().equals(kürzel))
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

	public static void addLandkreis(String kürzel, String landkreis) {
		if (sucheLandkreis(landkreis) == null && sucheKFZKürzel(kürzel) == null) {
			kfz.put(kürzel, landkreis);
			System.out.println("Hinzugefügt wurde: Key: " + kürzel + " & Value: " + landkreis);
		} else
			System.out.println("\nDer Landkreis " + landkreis + "(" + kürzel + ") ist bereits enthalten!");

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
