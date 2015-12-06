package Geo;

public class rListPrimitives extends ListPrimitives {
	private static final long	serialVersionUID	= 7425180503553493881L;

	public rListPrimitives(int max) {
		super(max);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void delfromList(Primitive p) {
		Liste.remove(p);
	}

	@Override
	public void addtoList(Primitive p) throws WrongArgumentException {
		if (p == null) {
			throw new WrongArgumentException();
		} else if (counter >= this.getMaxSize()) {
			System.out.println("Die Liste ist voll.");
		} else if (p.corner == false) {
			Liste.add(p);
		} else
			throw new NoRoundObjectException();
		// System.out.println("Hinzufügen erfolgreich!");//Debug
		System.err.println(p.getClass().getName() + " ist: " + p.corner);
	}

	public static void main(String[] args) {
		rListPrimitives rlp1 = new rListPrimitives(4);
		rlp1.load("SaveRoundList");
		if (b) {
			Circle c1 = new Circle(1, 1, 4);
			Ellipse e1 = new Ellipse(5, 5, 3, 8);
			Circle c2 = new Circle(1, 1, 5);
			Ellipse e2 = new Ellipse(3, 2, 4, 7);
			Circle c3 = null;
			Square s1 = new Square(3, 5, 81);
			System.out.println(((Primitive) s1).corner);
			System.out.println("S1 ist: " + s1.corner);
			// Liste erstellen
			// Primitive zur Liste hinzufügen
			try {
				rlp1.addtoList(s1);
			} catch (WrongArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				rlp1.addtoList(c3);
			} catch (WrongArgumentException e) {
				try {
					rlp1.addtoList(c1);
				} catch (WrongArgumentException e21) {
					// TODO Auto-generated catch block
					e21.printStackTrace();
				}
				e.printStackTrace();
			}
			try {
				rlp1.addtoList(e1);
			} catch (WrongArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				rlp1.addtoList(c2);
			} catch (WrongArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				rlp1.addtoList(e2);
			} catch (WrongArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			// Volle Liste ausgeben
			rlp1.printList(rlp1.Liste);
			// Voller Liste etwas hinzufügen
			rlp1.delfromList(c1);

			System.out.println("### Sortierung ###");
			rlp1.printList(rlp1.Liste);
			rlp1.sortFlaeche();

			rlp1.printList(rlp1.Liste);
			rlp1.sortUmfang();
			System.out.println("\nAktuelle Liste:");
			rlp1.printList(rlp1.Liste);
			rlp1.save("SaveRoundList");
			System.out.println("\nNeu geladene Liste:");
			rlp1.load("SaveRoundList");
		}
		rlp1.printList(rlp1.Liste);
		try {
			System.out.println(rlp1.getByIndex(0));
		} catch (MyArrayIndexOutOfBoundsException e) {
			e.printStackTrace();
		}
		try {
			System.out.println(rlp1.getByIndex(1));
		} catch (MyArrayIndexOutOfBoundsException e) {
			e.printStackTrace();
		}
		try {
			System.out.println(rlp1.getByIndex(2));
		} catch (MyArrayIndexOutOfBoundsException e) {
			e.printStackTrace();
		}
		try {
			System.out.println(rlp1.getByIndex(3));
		} catch (MyArrayIndexOutOfBoundsException e) {
			e.printStackTrace();
		}

	}

	public static boolean getCorner(Primitive p) {
		return p.corner;
	}
}
