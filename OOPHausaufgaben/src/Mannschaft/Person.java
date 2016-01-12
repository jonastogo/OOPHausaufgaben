package OOPHausaufgaben.src.Mannschaft;

import java.util.GregorianCalendar;

public class Person {
	private String				name;
	private String				spitzname;
	private String				telefonnummer;
	private String				adresse;
	private GregorianCalendar	birthday;

	public Person(String name, String spitzname, String telefonnummer, String adresse, int year, int month, int day) {
		this.name = name;
		this.spitzname = spitzname;
		this.telefonnummer = telefonnummer;
		this.adresse = adresse;
		this.birthday = new GregorianCalendar(year, month, day);
	}

	public boolean equals(Person p) {
		if (p == null)
			return false;

		if (p == this)
			return true;

		if (!p.getClass().equals(getClass()))
			return false;

		Person that = (Person) p;

		return this.telefonnummer.equals(that.telefonnummer) && this.name.equals(that.name);
	}

	public int hashCode() {
		return (31 + ((telefonnummer == null) ? 0 : telefonnummer.hashCode())) * 31 + ((name == null) ? 0 : name.hashCode());
	}

	protected String getName() {
		return name;
	}

	protected void setName(String name) {
		this.name = name;
	}

	protected String getSpitzname() {
		return spitzname;
	}

	protected void setSpitzname(String spitzname) {
		this.spitzname = spitzname;
	}

	protected String getTelefonnummer() {
		return telefonnummer;
	}

	protected void setTelefonnummer(String telefonnummer) {
		this.telefonnummer = telefonnummer;
	}

	protected String getAdresse() {
		return adresse;
	}

	protected void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	protected GregorianCalendar getBirthday() {
		return birthday;
	}

	protected void setBirthday(GregorianCalendar birthday) {
		this.birthday = birthday;
	}

	public String toString() {
		return "[Name: " + name + " | Spitzname: " + spitzname + " | Telefon: " + telefonnummer + " | Adresse: " + adresse + " | Geburtstag: " + getBirthday().get(GregorianCalendar.DATE) + "." + getBirthday().get(GregorianCalendar.MONTH) + "." + getBirthday().get(GregorianCalendar.YEAR) + "]";
	}
}
