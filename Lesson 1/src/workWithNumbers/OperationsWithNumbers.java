package workWithNumbers;

import java.util.Scanner;

public class OperationsWithNumbers {
	
	
	/**
	 * This method return initialized array numbers are entered from the keyboard 
	 * if this number is negative will be prompted to enter the number again.
	 */
	public int[] getArray(int n){
		int[] array = new int[n];
		Scanner sc = new Scanner(System.in);
		for (int i = 0; i < array.length; i++) {
			array[i] = sc.nextInt();
			if(array[i] < 0){
				System.out.print("Negative number is invalid, enter the number again");
				array[i] = sc.nextInt();
			}
		}
		sc.close();
		return array;
	}

	/**
	 * This method sorts the elements of the array using the Bubble method and
	 * displays a sorted array
	 */
	public void printSortedByBubbleSort(int[] array){
		int temp;
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array.length - 1; j++) {
				if(array[j] > array[j + 1]){
					temp = array[j];
					array[j] = array[j + 1];
					array[j + 1] = temp;
				}
			}
		}
		System.out.println("\nSorted by BubleSort: ");
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
	}
	
	
	/**
	 * This method finds and displays  elements of array which are divided into the previous element
	 * 
	 */
	public void printDivideAscendingNumbers(int[] array){
		System.out.println("\nDivided into the previous element:");
		for (int i = 0; i < array.length - 1; i++) {
			if(i == 0){
				System.out.print(array[i] + " ");
			}
			if(array[i+1] % array[i] == 0){
				System.out.print(array[i + 1] + " ");
			} 
		}
	}
	
	
	/** 
	 * This method converts an array of integers into an array of strings. Each tape is divided into 
	 * characters, and stores it in an array of characters. The method returns the received array of characters.
	 * 
	 */
	public char[][] convertArrayChar(int[] array, int n){
		String[] arrayString = new String[n];
		char[][] numbersOfChars = new char[n][n];
		int count = 0;
		for (int i = 0; i < arrayString.length; i++) {
			arrayString[i] = array[i]+"";
			while(count < arrayString[i].length()){
				numbersOfChars[i][count] = arrayString[i].charAt(count);
				count++;
			}
			count = 0;
		}
		return numbersOfChars;
	}
	
	/** 
	 * This method finds numbers where numbers are in ascending order and
	 * displays them on the console.
	 */
	public void printNumbersAscending(char[][] arrayChar, int[] array){
		int count = 0;
		System.out.println("Numbers where numbers are in ascending order:");
		for (int i = 0; i < arrayChar.length; i++) {
			for (int j = 0; j < arrayChar[i].length-1; j++) {
				if(arrayChar[i][j] < arrayChar[i][j+1]){
					count++;
				}		
			}
			if(count == arrayChar[i].length-1){
				System.out.print(array[i] + " ");
				count = 0;
			} else{
				count = 0;
			}
		}
	}
	
	/** 
	 * This method finds numbers that contain prime numbers and outputs them to the console.
	 */
	public void printPrimeNumbers(char[][] arrayChar, int[] array,  int length){
		boolean[][] isTruth = new boolean[length][length];
		int countIsTrue = 0;
		System.out.println("\nPrime numbers are present in such numbers:");
		for (int i = 0; i < arrayChar.length; i++) {
			for (int j = 0; j < arrayChar.length; j++) {
				if(arrayChar[i][j] == '2' || arrayChar[i][j] == '3' || arrayChar[i][j] == '5' || arrayChar[i][j] == '7'){
					isTruth[i][j] = true;
					countIsTrue++;
				} else{
					isTruth[i][j] = false;
				}
			}
			if(countIsTrue > 0){
				System.out.print(array[i] + " "); 
			}
			countIsTrue = 0;
		}
	}
	
}
