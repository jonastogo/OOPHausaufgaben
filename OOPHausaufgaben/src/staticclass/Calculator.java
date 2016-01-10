package staticclass;

public class Calculator {

	private Operation	operation;

	public class Operation {
		public Operation() {}

		public double PLUS(double x, double y) {
			return (x + y);
		}

		public double MINUS(double x, double y) {
			return (x - y);
		}

		public double DIVIDE(double x, double y) {
			return (x / y);
		}

		public double TIMES(double x, double y) {
			return (x * y);
		}
	}

	public Calculator() {
		this.operation = new Operation();
	}

	public static void main(String[] args) {
		Calculator calc = new Calculator();
		System.out.println(calc.operation.PLUS(4, 7));
		System.out.println(calc.operation.MINUS(4, 7));
		System.out.println(calc.operation.DIVIDE(4, 7));
		System.out.println(calc.operation.TIMES(4, 7));
	}
}

/**
 * non-static nested class vs. static nested class
 * 
 * Eine nicht-statische geschachtelte Klasse (innere Klasse) hat vollen Zugriff auf die Attribute und Methoden der top-level Klasse.
 * 
 * Eine statische geschachtelte Klasse hat keine Referenz zu einer Instanz und kann somit keine nicht-statischen Methoden der top-level Klasse
 * aufrufen und hat auch keinen Zugriff auf nicht-statische Attribute der top-level Klasse.
 * 
 * In diesem Fall ist es egal ob die geschachtelte Klasse statisch oder nicht ist.
 * 
 * Geschachtelte Klassen werden benutzt wenn sie nur in der umschließenden Klasse benötigt werden.
 * Wenn sie auch in anderen Klassen benätigt wird, muss eine neue Top-Level Klasse erstellt werden.
 */
