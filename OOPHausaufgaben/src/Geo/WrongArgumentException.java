package Geo;

class WrongArgumentException extends Exception {
	// Konstruktor unserer eigenen Exception
	WrongArgumentException() {
		// Aufruf des �bergeordneten Konstruktors mit dem zu
		// erscheinenden Fehlertext
		super("Das Objekt darf nicht null sein!");
	}
}
