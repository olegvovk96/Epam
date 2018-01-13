package main;

import java.util.Scanner;

public class BurrowsWheeler {
	
	private char[][] inputSymbols;
	
	private String inputString;
	
	public BurrowsWheeler(){
		Scanner sc = new Scanner(System.in);
		System.out.println("Write word for BurrowsWheelerTransform: ");
		this.inputString = sc.next();
		this.inputSymbols = new char[this.inputString.length()][this.inputString.length()];
		sc.close();
	}

	
	private void transposal(){         
			int count = 0;
			int col = 0;
			for (int j = 0; j < inputSymbols.length; j++) {
				inputSymbols[0][j] = inputString.charAt(j);
			}
			
			for (int i = 1; i < inputSymbols.length; i++) {
				for (int j = i; j < inputSymbols.length; j++) {
						inputSymbols[i][count] = inputSymbols[0][j];
						count++;
				}
				count = 0;
			}
			count = 1;
			for (int i = inputSymbols.length - 1; i > 0; i--) {
				for (int j = i; j < inputSymbols.length; j++) {
					inputSymbols[count][j] = inputSymbols[0][col];
					col++;
				}
				count++;
				col=0;
			}
	}
	
	private void sort(){
		int n = 0, col = 0, row = 0;
		char temp;
		//збільшує рядок на один, оскільки попередні рядки вже відсортовані
		while(n < inputSymbols.length){
		//порівнює символи i-рядка з усіма наступними, якщо є нижчий символ міняє рядки місцями
		for (int i = n; i < inputSymbols.length-1; i++) {
			for (int j = 0; j < inputSymbols.length; j++) {
				if(inputSymbols[row][j] < inputSymbols[i+1][j]){
					break;
				} else if(inputSymbols[row][j] > inputSymbols[i+1][j]){
						while(col < inputSymbols.length){
							temp = inputSymbols[row][col];
							inputSymbols[row][col] = inputSymbols[i+1][col];
							inputSymbols[i+1][col] = temp;
							col++;
						}
						col=0;
						break;
				}
				
			}
		}
		row++;
		n++;
		}
	}
	
	private void printLastSymbols(){
		for (int i = 0; i < inputSymbols.length; i++) {
			System.out.println(inputSymbols[i][inputSymbols.length-1]);
		}
	}
	
	public void burrowsWheelerTransorm(){
		transposal();
		sort();
		printLastSymbols();
	}
}
