package Geo;

class WrongArgumentException extends Exception {
	// Konstruktor unserer eigenen Exception
	WrongArgumentException() {
		// Aufruf des übergeordneten Konstruktors mit dem zu
		// erscheinenden Fehlertext
		super("Das Objekt darf nicht null sein!");
	}
}
