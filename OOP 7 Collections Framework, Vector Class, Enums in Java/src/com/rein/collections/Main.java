package com.rein.collections;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

public class Main {

	public static void main(String[] args) {

		List<Integer> arrayListOne = new ArrayList<>();
		List<Integer> linkedListOne = new LinkedList<>();

		arrayListOne.add(34);
		arrayListOne.add(78);
		arrayListOne.add(55);
		arrayListOne.add(89);
		System.out.println(arrayListOne);

		linkedListOne.add(34);
		linkedListOne.add(78);
		linkedListOne.add(55);
		linkedListOne.add(89);
		System.out.println(linkedListOne);

		// The difference between a Vector and an ArrayList is that ArrayLists makes use
		// of multiple threads at the same time whereas vector uses threads one at a
		// time.
		List<Integer> vectorOne = new Vector<>();
		vectorOne.add(45);
		vectorOne.add(5);
		vectorOne.add(15);
		vectorOne.add(56);
		System.out.println(vectorOne);

	}

}
