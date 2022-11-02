package com.parallelsort.demo;

import java.util.Arrays;
import java.util.stream.Collectors;

public class ParallelSortDemo {
	public static void main(String args[]) {
		int intArray[] = new int[]{10,9,8,7,6,5,4,3,2,1} ;
		Arrays.parallelSort(intArray);
		System.out.println(Arrays.stream(intArray).boxed().collect(Collectors.toList()));
	}
}
