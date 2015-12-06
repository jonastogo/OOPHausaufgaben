package Geo;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class ListPrimitives implements Serializable {

	public class PrimitiveComperatorUmfang implements Comparator<Primitive> {
		@Override
		public int compare(Primitive o1, Primitive o2) {
			double u1 = o1.berechneUmfang();
			double u2 = o2.berechneUmfang();
			if (u1 > u2) {
				return 1;
			}
			if (u2 > u1) {
				return -1;
			}
			return 0;
		}
	}

	public class PrimitiveComperatorFlaeche implements Comparator<Primitive> {
		@Override
		public int compare(Primitive o1, Primitive o2) {
			double u1 = o1.berechneFlaeche();
			double u2 = o2.berechneFlaeche();
			if (u1 > u2) {
				return -1;
			}
			if (u2 > u1) {
				return 1;
			}
			return 0;
		}
	}

	private static final long	serialVersionUID	= 8528951252002450815L;
	/*
	 * Programmieren Sie eine Klasse ListPrimitives, die in einem Array eine konstante Anzahl an Primitiven Speichern kann.
	 * Diese Klasse hat Methoden um ein nach Umfang und Fl�cheninhalt sortiertes Array zur�ckzugeben. Au�erdem enth�lt
	 * sie Methoden zum hinzuf�gen und entfernen eines Listenelements. Wenn aus dem vollen Array ein Element gel�scht
	 * wird soll ein neues hinzugef�gt werden k�nnen. Auch eine print()-Methode ist enthalten, die das Array ausgibt.
	 */

	Object						object;
	FileOutputStream			fileOut				= null;
	ObjectOutputStream			objectOut			= null;
	FileInputStream				fileIn				= null;
	ObjectInputStream			objectIn			= null;

	private final int			maxsize;
	ArrayList<Primitive>		Liste				= new ArrayList<Primitive>();

	int							counter;
	static boolean				b					= false;

	protected int getMaxSize() {
		return this.maxsize;
	}

	public ListPrimitives(int max) {
		this.maxsize = max;
		this.counter = 0;
	}

	public void sortUmfang() {
		Collections.sort(Liste, new PrimitiveComperatorUmfang());
		/*
		 * int n = Liste.size();
		 * boolean swapped;
		 * do {
		 * swapped = false;
		 * for (int i = 0; i < (retMaxIndex() - 1); ++i) {
		 * if (Liste.get(i).berechneUmfang() > Liste.get(i + 1).berechneUmfang()) {
		 * // Dreieckstausch
		 * Primitive z = Liste.get(i);
		 * Liste.set(i, Liste.get(i + 1));
		 * Liste.set(i, z);
		 * swapped = true;
		 * } // end if
		 * } // end for
		 * n = n - 1;
		 * } while (swapped == true);
		 */
	}

	public void sortFlaeche() {
		Collections.sort(Liste, new PrimitiveComperatorFlaeche());
		/*
		 * int n = Liste.size();
		 * boolean swapped;
		 * do {
		 * swapped = false;
		 * for (int i = 0; i < (retMaxIndex() - 1); ++i) {
		 * if (Liste.get(i).berechneFlaeche() > Liste.get(i + 1).berechneFlaeche()) {
		 * // Dreieckstausch
		 * Primitive z = Liste.get(i);
		 * Liste.set(i, Liste.get(i + 1));
		 * Liste.set(i, z);
		 * swapped = true;
		 * } // end if
		 * } // end for
		 * n = n - 1;
		 * } while (swapped == true);
		 */
	}

	public void addtoList(Primitive p) throws WrongArgumentException {
		if (p == null) {
			throw new WrongArgumentException();
		} else if (Liste.size() >= this.getMaxSize()) {
			System.out.println("Die Liste ist voll.");
		} else {
			Liste.add(p);
		}
	}

	public void delfromList(Primitive p) {
		Liste.remove(p);
	}

	public void printList(ArrayList<Primitive> list) {
		System.out.println("--- Liste von Primitiven ---");
		int i = 0;
		while (i < (Liste.size())) {
			if (Liste.get(i) == null)
				break;
			try {
				System.out.println(Liste.get(i).toString());
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("Bei Liste[" + i + "] ist der Wert Null");
			}
			i++;
		}
		System.out.println("--- Ende ---");
	}

	public void save(String file) {
		try {
			fileOut = new FileOutputStream(file);
			objectOut = new ObjectOutputStream(fileOut);
			this.printList(this.Liste);
			try {
				Primitive[] objectOutput = new Primitive[Liste.size()];
				for (int i = 0; i < Liste.size(); i++) {
					objectOutput[i] = Liste.get(i);
				}
				objectOut.writeObject(objectOutput);
			} // endtry
			catch (Exception exception_ref) {
				System.out.println("Exception: " + exception_ref.getClass().getName());
			} // endcatch
			objectOut.close();
			fileOut.close();
		} // endtry
		catch (Exception exception_ref) {
			System.out.println("Exception: " + exception_ref.getClass().getName());
			System.exit(-1);
		} // endcatch
	} // endmethod speichern

	public void load(String file) {
		try {
			fileIn = new FileInputStream(file);
			objectIn = new ObjectInputStream(fileIn);
			Primitive[] objectInput = (Primitive[]) objectIn.readObject();
			System.out.println(String.format("New list length: %d", objectInput.length));
			Liste = new ArrayList<Primitive>(objectInput.length); // Java kann nciht von ObjectInputStream zu Fach casten...
			Liste.ensureCapacity(objectInput.length);
			for (int i = 0; i < objectInput.length; i++) {
				Primitive p = objectInput[i];
				Liste.add(p);
			}
			objectIn.close();
			fileIn.close();
		} // endtry
		catch (Exception exception_ref) {
			exception_ref.printStackTrace();
			b = true;
			System.out.println("Exception: " + exception_ref.getClass().getName());
			System.out.println("Datei wurde nicht gefunden! \nEine neue Liste wird angelegt");
			Liste = new ArrayList<Primitive>(); // Java kann nciht von ObjectInputStream zu Fach casten...
		} // endcatch
	}

	public Primitive getByIndex(int index) {
		if (Liste.size() <= index)
			throw new MyArrayIndexOutOfBoundsException();
		if (this.Liste.get(index) == null)
			throw new MyArrayIndexOutOfBoundsException();
		else
			return this.Liste.get(index);
	}

}
