package Geo;

public class NoCornerObjectException extends WrongArgumentException {

	private static final long	serialVersionUID	= -1092034323575457335L;

	NoCornerObjectException() {
		// Aufruf des übergeordneten Konstruktors mit dem zu
		// erscheinenden Fehlertext
		super();
		System.err.println("Dieses Objekt ist nicht eckig!");
	}
}
