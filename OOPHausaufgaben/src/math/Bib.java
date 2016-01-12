package math;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

public class Bib {
	public static final int	MAX	= 25;

	public static void sort(final int array[]) {
		int size = array.length;
		int swap = 0;
		boolean swapped = false;
		do {
			swapped = false;
			for (int i = 0; i < size - 1; ++i) {
				if (array[i] > array[i + 1]) {
					swap = array[i];
					array[i] = array[i + 1];
					array[i + 1] = swap;
					swapped = true;
				}
			}
			size--;
		} while (swapped);
	}

	public static int[] subArray(int[] array, int from, int to) {
		int[] retVal;
		if (array == null || from > array.length || to > array.length) {
			return null;
		}

		retVal = new int[to];
		int j = 0;
		for (int i = from; i < to; i++) {
			retVal[j++] = array[i];
		}

		return retVal;
	}

	public static void sortWithOutput(final int array[]) {
		int size = array.length;
		int swap = 0;
		boolean swapped = false;
		do {
			swapped = false;
			for (int i = 0; i < size - 1; ++i) {
				if (array[i] > array[i + 1]) {
					System.out.print(array[i] + "," + array[i + 1] + "; ");
					swap = array[i];
					array[i] = array[i + 1];
					array[i + 1] = swap;
					swapped = true;
				}
			}
			System.out.println();
			size--;
			printArray(array);
		} while (swapped);
	}

	public static void printArray(final int array[]) {
		for (int i : array) {
			System.out.print(String.format("%02d ", i));
		}
		System.out.println();
		try {
			(new InputStreamReader(System.in)).read();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static double getAverage(final int array[]) {
		double retVal = 0.0;
		for (int i = 0; i < array.length; i++) {
			retVal += array[i];
		}

		return retVal / array.length;
	}

	public static double getMedian(final int array[]) {
		double median = 0.0;
		if (array.length < 2) {
			median = array[0];
		}
		int size = array.length;
		if (array.length % 2 == 0) {
			System.out.println("unterer Median: " + array[size / 2 - 1] + "  oberer Median: " + array[size / 2]);
			median = (array[size / 2 - 1] + array[size / 2]);
			median /= 2;
		} else {
			median = array[size / 2];
		}
		return median;
	}

	public static double getOberesQuartil(final int array[]) {
		sort(array);
		return getMedian(subArray(array, array.length / 2, array.length - 1));
	}

	public static double getUnteresQuartil(final int array[]) {
		sort(array);
		if (array.length % 2 == 0) {
			int to = (array.length / 2) - 1;
			return getMedian(subArray(array, 0, (to)));
		} else {
			int to = (array.length / 2);
			return getMedian(subArray(array, 0, (to)));
		}

	}

	public static void main(String[] args) {
		Random rnd = new Random();
		int array[] = new int[MAX];
		for (int i = 0; i < MAX; i++) {
			array[i] = rnd.nextInt(MAX);
		}

		// printArray(array);
		// System.out.println("Sortiert:");
		// sort(array);
		// printArray(array);
		// System.out.println("Average: "+getAverage(array));
		// System.out.println("Median: " + getMedian(array));
		// System.out.println("Median: ");
		// System.out.println("Median: ");

		int array2[] = {
				22, 24, 20, 17, 10, 23, 4, 9, 19, 10, 17, 21, 01, 16, 19, 5, 0, 20, 1, 6, 14, 18, 20, 2, 1
		};
		printArray(array2);
		sort(array2);
		System.out.println("oberes Quartil: " + Bib.getOberesQuartil(array2));
		System.out.println("oberes Quartil: " + Bib.getUnteresQuartil(array2));

	}

}
