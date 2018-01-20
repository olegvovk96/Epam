package main;

import java.util.ArrayList;
import java.util.List;



public class OddPredicate implements UnaryPredicate<Integer> {

	@Override
	public boolean test(Integer i) {
		return i % 2 != 0;
	}
	
	
	public static void main(String[] args) {
		List<Integer> numbers = new ArrayList<>();
		for (int i = 0; i < 20; i++) {
			numbers.add(i);
		}
		System.out.println(Algoritm.countlf(numbers, new OddPredicate()));
	}
}
