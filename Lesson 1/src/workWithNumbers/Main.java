package workWithNumbers;

public class Main {

	public static void main(String[] args) {
		OperationsWithNumbers operation = new OperationsWithNumbers();
		int length = 5;
		
		int[] array = new int[length];
		char[][] convertToArrayChart = new char[length][length];
		
		array = operation.getArray(length);
		
		convertToArrayChart = operation.convertArrayChar(array, length);
		operation.printNumbersAscending(convertToArrayChart, array);
		
		operation.printPrimeNumbers(convertToArrayChart, array, length);
		operation.printDivideAscendingNumbers(array);
		operation.printSortedByBubbleSort(array);
		
	}

}
