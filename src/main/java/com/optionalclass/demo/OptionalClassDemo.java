package com.optionalclass.demo;

import java.util.Optional;

public class OptionalClassDemo {

	public static void main(String[] args) {
		String str = "My String";
		Optional<String> optionalStr = Optional.ofNullable(str);
		
		System.out.println("IsPresent = "+optionalStr.isPresent());
		System.out.println("orElse = "+optionalStr.orElse("Empty optional"));
		optionalStr.stream().forEach(System.out::println);
		
		optionalStr.ifPresent(myString -> System.out.println(myString.toUpperCase()));
		
	}

}
