package main;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;


public class AlignRight {
	
	private static List<String> readText(){
		Scanner sc = new Scanner(System.in);
		System.out.println("Write text: ");
		String inputText = sc.nextLine();
		List<String> list = new ArrayList<>();
		while(!inputText.equals("")){
			list.add(inputText);
			inputText = sc.nextLine();
		}
		sc.close();
		return list;
	}
	
	private static String[] alignRight(List<String> lines){
		Iterator<String> iterator = lines.iterator();
		int max = 0;
		int count = 0;
		StringBuilder str = new StringBuilder();
		String[] receivedText = new String[lines.size()];
		while (iterator.hasNext()) {
			String line = (String) iterator.next();
			if(max < line.length()){
				max = line.length();
			}
		}
		for (String line : lines) {
			int numberSpaces = max - line.length();
			for (int i = 0; i <= numberSpaces; i++) {
				str.append(" ");
			}
			str.append(line);
			receivedText[count] = str.toString();
			str.delete(0, str.length());
			count++;
		}		
		return receivedText;
	}
	
	public static List<String> getReadText(){
		return readText();
	} 
	
	public static void getAlignRight(List<String> lines){
		String[] result = alignRight(lines);
		for (int i = 0; i < result.length; i++) {
			System.out.println(result[i]);
		}
	}
}
