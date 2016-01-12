package matheBibliothek;

public class Bibliothek {

	/*
	 * (gibt array[] auf der Console aus Verzichten Sie auf die Benutzung
	 * der Klasse Arrays)
	 */
	public static void printArray(final int array[]) {
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
		System.out.println();
	}

	/* (soll den Durchschnitt aller Zahlen aus array[] zur�ckgeben) */
	public static double getAverage(final int array[]) {
		double sum = 0;
		for (int i = 0; i < array.length; i++) {
			sum = sum + array[i];
		}
		return (sum / array.length);
	}

	/* (liefert den Median von array[]) */
	public static double getMedian(final int array[]) {
		double median;
		if (array.length % 2 != 0) {
			median = array[array.length / 2];
			return median;
		} else
			median = (array[array.length / 2 - 1] + array[array.length / 2]) / 2;
		return median;
	}

	/* (liefert das obere Quartil von array[]) */
	public static int getUpperQuartile(final int array[]) {
		int uQuartil = 0;
		bubblesort(array);
		uQuartil = (int) (array[(int) ((array.length * 3) / 4)]);
		// DEBUG System.out.println(array[(int) ((array.length*3)/4)]);
		return uQuartil;
	}

	/* (liefert das untere Quartil von array[]) */
	public static int getLowerQuartile(final int array[]) {
		int lQuartil = 0;
		bubblesort(array);
		lQuartil = (int) (array[array.length / 4]);
		return lQuartil;
	}

	// bubblesort
	public static void bubblesort(final int array[]) {
		int n = array.length;
		boolean swapped;
		do {
			swapped = false;
			for (int i = 0; i < n - 1; ++i) {
				if (array[i] > array[i + 1]) {
					// Dreieckstausch
					int z = array[i];
					array[i] = array[i + 1];
					array[i + 1] = z;
					swapped = true;
				} // end if
			} // end for
			n = n - 1;
		} while (swapped == true);
	}
}
