package com.lambdaandstream.demo;

import java.util.Arrays;
import java.util.List;
import java.util.function.*;
import java.util.stream.Collectors;

interface IF{
	int func(int num);
//	int func1(int num);
	default void func2(int num) {
		System.out.println(num);
	}
	static void ifStaticMethod() {
		System.out.print("Static method called");
	}
}

public class LambdaDemo {
	static void sop(Object o) {
		System.out.println(o);
	}

	public static void main(String[] args) {
		IF interfaceObject = new IF() {
			public int func(int num) {
				return num*num;
			}
		};
		interfaceObject = (num) -> num*num;
		
		Predicate<Integer> p = new Predicate<Integer>() {
			@Override
			public boolean test(Integer t) {
				return t>5;
			}
		};
		p = (num)->num>5;
		IF interfaceObject2 = num -> {return num*num;};
		
		List<Integer> myList = Arrays.asList(1,2,3,4,5,6,7,8);
//		myList.stream().filter((num)->num%2==0).forEach((n)->System.out.println(n));
		List<Integer> evenList = myList.stream().filter((num)->num%2==0).collect(Collectors.toList());
		sop(evenList);
		
		IF.ifStaticMethod();
	}
}
