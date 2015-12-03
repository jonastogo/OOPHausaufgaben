package Geo;

public class allListPrimitives extends ListPrimitives {

	public allListPrimitives(int max) {
		super(max);
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		ListPrimitives lp1 = new ListPrimitives(4);
		lp1.load("SaveList");
		if (b) {
			Circle c1 = new Circle(1, 1, 5);
			Square s1 = new Square(3, 5, 80);
			Rectangle r1 = new Rectangle(5, 5, 88, 10);
			Ellipse e1 = new Ellipse(5, 5, 3, 8);
			Circle c3 = null;
			Circle c4 = new Circle(1, 2, 4);
			// Liste erstellen
			// Primitive zur Liste hinzuf�gen
			try {
				lp1.addtoList(c3);
			} catch (WrongArgumentException e) {
				try {
					lp1.addtoList(c1);
				} catch (WrongArgumentException e2) {

					e2.printStackTrace();
				}
			}
			try {
				lp1.addtoList(s1);
			} catch (WrongArgumentException e) {

				e.printStackTrace();
			}
			try {
				lp1.addtoList(r1);
			} catch (WrongArgumentException e) {

				e.printStackTrace();
			}
			try {
				lp1.addtoList(e1);
			} catch (WrongArgumentException e) {

				e.printStackTrace();
			}
			// Volle Liste ausgeben
			lp1.printList(lp1.Liste);
			// Voller Liste etwas hinzuf�gen
			lp1.delfromList(c1);
			try {
				lp1.addtoList(c4);
			} catch (WrongArgumentException e) {

				e.printStackTrace();
			}

			System.out.println("\n### Sortierung ###");
			lp1.printList(lp1.Liste);
			System.out.println("\nSortierung nach Fl�che:");
			lp1.sortFlaeche();
			lp1.printList(lp1.Liste);
			System.out.println("\nSortierung nach Umfang:");
			lp1.sortUmfang();
			lp1.printList(lp1.Liste);
			System.out.println("\nAktuelle Liste:");
			lp1.printList(lp1.Liste);
			lp1.save("SaveList");
			System.out.println("\nNeu geladene Liste:");
			lp1.load("SaveList");
		}
		lp1.printList(lp1.Liste);
		try {
			System.out.println(lp1.getByIndex(0));
		} catch (MyArrayIndexOutOfBoundsException e) {
			e.printStackTrace();
		}
		try {
			System.out.println(lp1.getByIndex(1));
		} catch (MyArrayIndexOutOfBoundsException e) {
			e.printStackTrace();
		}
		try {
			System.out.println(lp1.getByIndex(2));
		} catch (MyArrayIndexOutOfBoundsException e) {
			e.printStackTrace();
		}
		try {
			System.out.println(lp1.getByIndex(3));
		} catch (MyArrayIndexOutOfBoundsException e) {
			e.printStackTrace();
		}
	}

}
