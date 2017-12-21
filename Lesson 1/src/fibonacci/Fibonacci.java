package fibonacci;

import java.util.Scanner;

public class Fibonacci {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int countNumbers = sc.nextInt();
		printfFibonacci(countNumbers);
		sc.close();
	}
	
	
	/**
	 * This method print numbers of Fibonacci. If you reach the maximum of type Long
	 * displays the number of this item and its value. The rest of the array elements
	 * filled in with zeros.
	 */
	public static void printfFibonacci(int countNumbers){
		long[] fibonacci = new long[countNumbers];
		fibonacci[0] = fibonacci[1] = 1;
		for (int i = 2; i < countNumbers; i++) {
			fibonacci[i] = fibonacci[i - 2] + fibonacci[i - 1];
			if(fibonacci[i] < 0){
				System.out.println("Максимально допустимий елемент для типу long числа Фібоначі [" + i + "] = " + fibonacci[i-1]);
				break;
			}
		}
		for (int i = 0; i < countNumbers; i++) {
			System.out.print(fibonacci[i] + " ");
		}
	}
}
