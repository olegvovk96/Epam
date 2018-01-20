package main;

import java.util.Collection;

public final class Algoritm {
	public static <T> int countlf(Collection<T> c, UnaryPredicate<T> p){
		int count = 0;
		for (T lists : c) {
			if(p.test(lists))
				count++;
		}
		return count;
	}
}
