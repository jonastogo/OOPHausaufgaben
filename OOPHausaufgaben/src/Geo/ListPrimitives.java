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

	private static final long	serialVersionUID	= 8528951252002450815L;
	/**
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

	@SuppressWarnings({
			"unchecked", "rawtypes"
	})
	public void sortUmfang() {
		Collections.sort(Liste, new Comparator() {
			@Override
			public int compare(Object o1, Object o2) {
				double u1 = (double) ((Primitive) o1).berechneUmfang();
				double u2 = (double) ((Primitive) o2).berechneUmfang();
				if (u1 > u2) {
					return 1;
				}
				if (u2 > u1) {
					return -1;
				}
				return 0;
			}
		});
	}

	@SuppressWarnings({
			"unchecked", "rawtypes"
	})
	public void sortFlaeche() {
		Collections.sort(Liste, new Comparator() {
			@Override
			public int compare(Object o1, Object o2) {
				double u1 = (double) ((Primitive) o1).berechneFlaeche();
				double u2 = (double) ((Primitive) o2).berechneFlaeche();
				if (u1 > u2) {
					return -1;
				}
				if (u2 > u1) {
					return 1;
				}
				return 0;
			}
		});
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
