package OOPHausaufgaben.src.Mannschaft;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.GregorianCalendar;

public class Liste {

	ArrayList<Person>	list	= new ArrayList<Person>();

	public Liste() {
		list.add(new Person("jonas", "jonny", "123", "Lange Str. 25, 32051 Herford", 1995, 9, 14));
		list.add(new Person("allahu", "akbar", "024", "Enger Str. 37, 32052 Herford", 1996, 5, 8));
		list.add(new Person("max", "maxi", "023", "Kurze Str. 5, 32049 Herford", 1996, 3, 21));

	}

	@SuppressWarnings({
			"unchecked", "rawtypes"
	})
	public void sortName() {
		Collections.sort(list, new Comparator() {
			@Override
			public int compare(Object p1, Object p2) {
				String obj1 = (String) ((Person) p1).getName();
				String obj2 = (String) ((Person) p2).getName();
				if (obj1 == obj2) {
					return 0;
				}
				if (obj1 == null) {
					return -1;
				}
				if (obj2 == null) {
					return 1;
				}
				return obj1.compareTo(obj2);
			}
		});
	}

	@SuppressWarnings({
			"unchecked", "rawtypes"
	})
	public void sortSpitz() {
		Collections.sort(list, new Comparator() {
			@Override
			public int compare(Object p1, Object p2) {
				String obj1 = (String) ((Person) p1).getSpitzname();
				String obj2 = (String) ((Person) p2).getSpitzname();
				if (obj1 == obj2) {
					return 0;
				}
				if (obj1 == null) {
					return -1;
				}
				if (obj2 == null) {
					return 1;
				}
				return obj1.compareTo(obj2);
			}
		});
	}

	@SuppressWarnings({
			"rawtypes", "unchecked"
	})
	public void sortTele() {
		Collections.sort(list, new Comparator() {
			@Override
			public int compare(Object p1, Object p2) {
				String obj1 = (String) ((Person) p1).getTelefonnummer();
				String obj2 = (String) ((Person) p2).getTelefonnummer();
				if (obj1 == obj2) {
					return 0;
				}
				if (obj1 == null) {
					return -1;
				}
				if (obj2 == null) {
					return 1;
				}
				return obj1.compareTo(obj2);
			}
		});
	}

	@SuppressWarnings({
			"rawtypes", "unchecked"
	})
	public void sortBirthday() {
		Collections.sort(list, new Comparator() {
			@Override
			public int compare(Object p1, Object p2) {
				GregorianCalendar x = (GregorianCalendar) ((Person) p1).getBirthday();
				GregorianCalendar y = (GregorianCalendar) ((Person) p2).getBirthday();
				if (x.before(y))
					return -1;
				if (x.after(y))
					return 1;
				return 0;
			}
		});
	}

	public void printListe() {
		for (int i = 0; i < list.size(); i++) {
			System.out.println(String.format("%02d. ", (i + 1)) + list.get(i));
		}
	}

}
