package matheBibliothek;

public class _main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		final int intarray[] = {22,24,20,17,10,23,4,9,19,10,17,21,01,16,19,05,00,20,01,06,14,18,20,02,01};
		Bibliothek.printArray(intarray);
		System.out.println("Bubblesort:");
		Bibliothek.bubblesort(intarray);
		Bibliothek.printArray(intarray);
		System.out.println("Average: "+ Bibliothek.getAverage(intarray));
		System.out.println("Median: " + Bibliothek.getMedian(intarray));
		System.out.println("Oberes Quartil: " + Bibliothek.getUpperQuartile(intarray));
		System.out.println("Unteres Quartil: " + Bibliothek.getLowerQuartile(intarray));
	}

}
