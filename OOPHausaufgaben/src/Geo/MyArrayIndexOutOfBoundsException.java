package Geo;

public class MyArrayIndexOutOfBoundsException extends ArrayIndexOutOfBoundsException {
	/**
	 * 
	 */
	private static final long	serialVersionUID	= 1L;

	// Konstruktor unserer eigenen Exception
	MyArrayIndexOutOfBoundsException() {
		// Aufruf des �bergeordneten Konstruktors mit dem zu
		// erscheinenden Fehlertext
		super("An dieser Stelle in der Liste steht null!\n Dort darf nicht null stehen!");
	}
}
