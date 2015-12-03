package Geo;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class ListPrimitives implements Serializable {
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

	Primitive					Liste[];
	private final int			maxsize;
	int							counter;
	static boolean				b					= false;

	public ListPrimitives(int max) {
		this.maxsize = max;
		this.Liste = new Primitive[this.getMaxsize()];
		this.counter = 0;
	}

	public void sortUmfang() {
		int n = Liste.length;
		boolean swapped;
		do {
			swapped = false;
			for (int i = 0; i < (retMaxIndex() - 1); ++i) {
				if (Liste[i].berechneUmfang() > Liste[i + 1].berechneUmfang()) {
					// Dreieckstausch
					Primitive z = Liste[i];
					Liste[i] = Liste[i + 1];
					Liste[i + 1] = z;
					swapped = true;
				} // end if
			} // end for
			n = n - 1;
		} while (swapped == true);
	}

	public void sortFlaeche() {
		int n = Liste.length;
		boolean swapped;
		do {
			swapped = false;
			for (int i = 0; i < (retMaxIndex() - 1); ++i) {
				if (Liste[i].berechneFlaeche() > Liste[i + 1].berechneFlaeche()) {
					// Dreieckstausch
					Primitive z = Liste[i];
					Liste[i] = Liste[i + 1];
					Liste[i + 1] = z;
					swapped = true;
				} // end if
			} // end for
			n = n - 1;
		} while (swapped == true);
	}

	public void addtoList(Primitive p) throws WrongArgumentException {
		if (p == null) {
			throw new WrongArgumentException();
		} else if (counter >= getMaxsize()) {
			System.out.println("Die Liste ist voll.");
		} else {
			Liste[counter++] = p;
			// System.out.println("Hinzuf�gen erfolgreich!");//Debug
		}
	}

	public void delfromList(Primitive p) {
		int j = 0;
		boolean b = false;
		for (int i = 0; i < this.getMaxsize(); i++) {
			if (Liste[i] == p) {
				Liste[i] = null;
				counter--;
				b = true;
				j = i;
				break;
			}
		}
		if (b) {
			for (int i = j; i < (this.getMaxsize() - 1); ++i) {
				Liste[i] = Liste[(i + 1)];
			}
			Liste[this.getMaxsize() - 1] = null;
		}
	}

	public void printList(Primitive[] list) {
		System.out.println("--- Liste von Primitiven ---");
		int i = 0;
		while (i < (Liste.length)) {
			if (Liste[i] == null)
				break;
			try {
				System.out.println(Liste[i].toString());
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("Bei Liste[" + i + "] ist der Wert Null");
			}
			i++;
		}
	}

	public void save(String file) {
		try {
			fileOut = new FileOutputStream(file);
			objectOut = new ObjectOutputStream(fileOut);
			try {
				objectOut.writeObject(Liste);
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
			Liste = (Primitive[]) objectIn.readObject(); // Java kann nciht von ObjectInputStream zu Fach casten...
			objectIn.close();
			fileIn.close();
		} // endtry
		catch (Exception exception_ref) {
			b = true;
			System.out.println("Exception: " + exception_ref.getClass().getName());
			System.out.println("Datei wurde nicht gefunden! \nEine neue Liste wird angelegt");
		} // endcatch
	}

	public Primitive getByIndex(int index) {
		if (this.Liste[index] == null)
			throw new MyArrayIndexOutOfBoundsException();
		else
			return this.Liste[index];
	}

	public int getMaxsize() {
		return maxsize;
	}

	public int retMaxIndex() {
		for (int i = 0; i < this.getMaxsize(); i++)
			if (Liste[i] == null)
				return i;
		return this.getMaxsize();
	}

	public void addtoList(Primitive p, boolean b) throws WrongArgumentException {
		// TODO Auto-generated method stub

	}

}
