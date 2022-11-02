package com.lambdaandstream.demo;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.lang.Math.*;
public class Stream {
	static void sop(Object o) {
		System.out.println(o);
	}

	public static void main(String[] args) {
		List<Integer> myList = Arrays.asList(1,2,3,4,5,6,6,7,8);
		
		//toList
		sop("To List "+myList.stream()
				.collect(Collectors.toList()));
		
		//toMap
		sop("To map "+myList.stream().distinct()
				.collect(Collectors.toMap(num->num, num->num.toString())));


		
		//toSet
		sop("To List "+myList.stream()
				.collect(Collectors.toSet()));
		
		//partitioningby
		sop("Partitioning" + myList.stream()
									.collect(Collectors.partitioningBy(num->num%2==0)));
		
		//grouping
		sop("group by" + myList.stream()
									.collect(Collectors.groupingBy(num->num%3)));
		
		//finding max
		sop("Max = "+ myList.stream()
								.reduce(0, (max, num)->max = Math.max(max,num)));
	}
}
