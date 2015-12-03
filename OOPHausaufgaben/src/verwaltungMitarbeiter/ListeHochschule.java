package verwaltungMitarbeiter;

public class ListeHochschule {

	Person list[];
	int counter;
	private int max = 10;

	public ListeHochschule() {
		list = new Person[max];
		counter = 0;
	}

	public boolean add(Person p) {
		if (p == null) {
			return false;
		} else if (counter >= max) {
			return false;
		} else {
			list[counter++] = p;
			return true;
		}
	}

	public void printListe() {
		String s = String.format("%20s, %10s %5s  %s %s %s","Name","Vorname","Alter", "Steuerpflichtig", "\tLohn/Gehalt", "\tTitel");
		System.out.println(s);
		for (int i = 0; i < counter; i++) {
			if (list[i] instanceof AngeProfessor || list[i] instanceof VerbeamProfessor) {
				System.out.println(String.format("%02d. ",i)+list[i]+"\t\tProf.");
			} else
				System.out.println(String.format("%02d. ",i)+list[i]);
		}
	}

}
