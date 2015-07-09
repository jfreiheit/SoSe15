package sose15.vorbereitungen.generics;

public class PairMain {

	public static void main(String[] args) {
		Pair<Double> p1 = new Pair<>(3.0, 4.0);
		Pair<Double> p2 = new Pair<>(5.0, 9.0);
		System.out.println(p1);
		System.out.println(p2);
		System.out.println(p1.sum(p2));
		
		Pair<Integer> p3 = new Pair<>(3, 4);
		Pair<Integer> p4 = new Pair<>(5, 9);
		System.out.println(p3);
		System.out.println(p4);
		System.out.println(p3.sum(p4));

	}

}
