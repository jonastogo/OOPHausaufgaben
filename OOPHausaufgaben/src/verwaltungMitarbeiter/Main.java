package verwaltungMitarbeiter;

public class Main {

	public static void main(String[] args) {
		ListeHochschule  lh = new ListeHochschule();
		StudHilfskraft studiHiwi = new StudHilfskraft("Student", "Hiwi", "Hafenstr. 32", "Minden", 32427, 3,9, 1993,10);
		WissHilfskraft wissHiwi = new WissHilfskraft("Wiss", "Hiwi", "Hafenstr. 32", "Minden", 32427, 10, 10, 1989,10);
		AngeMitarbeiter ang = new AngeMitarbeiter("Angestellter", "Wimi", "Am KLeinen Kamp 42", "Bad Salzuflen", 32107, 17, 10, 1981, 3000.00,false);
		AngeMitarbeiter beam = new AngeMitarbeiter("Beamter", "Wimi", "Am KLeinen Kamp 42", "Bad Salzuflen", 32107, 17, 10, 1981, 3000.00,false);
		AngeProfessor angProf = new AngeProfessor("Angestellter", "Professor", "Am KLeinen Kamp 42", "Bad Salzuflen", 32107, 17, 10, 1968, 5000.00,false);
		AngeProfessor angProf2 = new AngeProfessor("Angestellter2", "Professor2", "Am KLeinen Kamp 42", "Bad Salzuflen", 32107, 17, 10, 1975, 5000.00,true);
		VerbeamProfessor verbProf = new VerbeamProfessor("Verbeamteter", "Professor", "Am KLeinen Kamp 42", "Bad Salzuflen", 32107, 17, 10, 1975, 5000.00);
		Lehrbeauftragter lehr = new Lehrbeauftragter("Lehrbeauftragter", "Hiwi","Hafenstr. 32", "Minden", 32427, 3,9, 1993,8, 23);
		VerbeamMitarbeiter verbAng = new VerbeamMitarbeiter("Verbeamteter", "Angestellter", "Am KLeinen Kamp 42", "Bad Salzuflen", 32107, 17, 10, 1975, 5000.00);

		
		lh.add(studiHiwi);
		lh.add(wissHiwi);
		lh.add(ang);
		lh.add(beam);
		lh.add(angProf);
		lh.add(angProf2);
		lh.add(verbProf);
		lh.add(lehr);
		lh.add(verbAng);
		
		lh.printListe();
		
		System.out.println("Counter: "+Person.getCounter());
	}

}
