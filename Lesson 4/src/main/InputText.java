package main;

import java.util.Scanner;

public class InputText {
	
	private static String readText(){
		Scanner sc = new Scanner(System.in);
		System.out.println("Write text: ");
		String inputText = sc.nextLine();
		StringBuilder receivedText = new StringBuilder();
		while(!inputText.equals("")){
			receivedText = receivedText.append(inputText);
			inputText = sc.nextLine();
		}
		sc.close();
		return receivedText.toString();
	}
	
	// Метод видаляє будь-яку кількість символів, що повторюються підряд у стрічці
	private static String textWithoutRepeatedCharacters(String inputText){
		StringBuilder receivedText = new StringBuilder();
		for (int i = 0; i < inputText.length()-1; i++) {
			if(inputText.charAt(i) == inputText.charAt(i+1)){
				continue;
			} else{
				receivedText.append(inputText.charAt(i));
			}
		}
		return receivedText.toString();
	}
	
	public static String getReadText(){
		return readText();
	}
	
	public static void getTextWithoutRepeatedCharacters(String inputText){
		String textWithoutDoubling = textWithoutRepeatedCharacters(inputText);
		System.out.println(textWithoutDoubling);
	}
}
