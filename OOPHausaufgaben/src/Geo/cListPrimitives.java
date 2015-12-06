package Geo;

public class cListPrimitives extends ListPrimitives {

	private static final long	serialVersionUID	= 571115171014032883L;

	public cListPrimitives(int max) {
		super(max);
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
		} else if (p.corner == true) {
			Liste.add(p);
		} else
			throw new NoRoundObjectException();
	}

	public static void main(String[] args) {
		System.out.println("CornerList");
		cListPrimitives clp1 = new cListPrimitives(4);
		clp1.load("SaveCornerList.txt");
		Square s1 = new Square(3, 5, 81);
		Rectangle r1 = new Rectangle(5, 5, 88, 10);
		Square s2 = new Square(3, 5, 80);
		Rectangle r2 = new Rectangle(5, 5, 80, 11);
		Square s3 = null;
		if (b) {
			// Liste erstellen
			// Primitive zur Liste hinzuf�gen
			try {
				clp1.addtoList(s3);
			} catch (WrongArgumentException e) {
				try {
					clp1.addtoList(s1);
				} catch (WrongArgumentException e21) {

					e21.printStackTrace();
				}
				System.out.println("Das Objekt darf nicht null sein!");
			}
			try {
				clp1.addtoList(r1);
			} catch (WrongArgumentException e) {

				e.printStackTrace();
			}
			try {
				clp1.addtoList(s2);
			} catch (WrongArgumentException e) {

				e.printStackTrace();
			}
			try {
				clp1.addtoList(r2);
			} catch (WrongArgumentException e) {

				e.printStackTrace();
			}
			// Volle Liste ausgeben
			clp1.printList(clp1.Liste);
			// Voller Liste etwas hinzuf�gen
			clp1.delfromList(s1);
			clp1.printList(clp1.Liste);
			try {
				clp1.addtoList(s1);
			} catch (WrongArgumentException e21) {

				e21.printStackTrace();
			}

			System.out.println("### Sortierung ###");
			clp1.printList(clp1.Liste);
			clp1.sortFlaeche();

			clp1.printList(clp1.Liste);
			clp1.sortUmfang();
			System.out.println("\nAktuelle Liste:");
			clp1.printList(clp1.Liste);
			clp1.save("SaveCornerList.txt");
			System.out.println("\nNeu geladene Liste:");
			clp1.load("SaveCornerList.txt");
		}
		try {
			clp1.addtoList(s1);
		} catch (WrongArgumentException e21) {

			e21.printStackTrace();
		}

		clp1.printList(clp1.Liste);
		try {
			System.out.println(clp1.getByIndex(0));
		} catch (MyArrayIndexOutOfBoundsException e) {

		}
		try {
			System.out.println(clp1.getByIndex(1));
		} catch (MyArrayIndexOutOfBoundsException e) {

		}
		try {
			System.out.println(clp1.getByIndex(2));
		} catch (MyArrayIndexOutOfBoundsException e) {

		}
		try {
			System.out.println(clp1.getByIndex(3));
		} catch (MyArrayIndexOutOfBoundsException e) {

		}
		clp1.save("SaveCornerList.txt");
	}
}
