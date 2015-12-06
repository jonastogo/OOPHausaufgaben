package Geo;

class WrongArgumentException extends Exception {
	/**
	 * 
	 */
	private static final long	serialVersionUID	= 1L;

	// Konstruktor unserer eigenen Exception
	WrongArgumentException() {
		// Aufruf des übergeordneten Konstruktors mit dem zu
		// erscheinenden Fehlertext
		super("Das Objekt darf nicht null sein!");
	}
}
