package com.lambdaandstream.demo;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;




public class SpringProjectApplication {
	static void sop(Object o) {
		System.out.println(o);
	}
	
	static Map<String, Integer> getMap(){
		Map<String, Integer> numberMap = new HashMap<>();
		numberMap.put("monday", 1);
		numberMap.put("tuesday", 2);
		numberMap.put("thursday", 4);
		numberMap.put("friday", 5);
		numberMap.put("saturday", 6);
		numberMap.put("sun", 7);
		numberMap.put("wednesday", 3);
		return numberMap;
	}

	public static void main(String[] args) {
//		SpringApplication.run(SpringProjectApplication.class, args);
		
		List<Integer> myList = Arrays.asList(1,2,3,4,5,6,7,8);
		Map<String, Integer> numberMap = getMap();
		

		iterateUsingForEach(numberMap);
		
		getAndGetOrDefault(numberMap);
		
		//put and put if absent
		putAndPutIfAbsent(numberMap);
		
		//replace
		replaceAll(numberMap);
		
		//compute
		sop("compute = "+numberMap.compute("tuesday", (key,value)->(value*value)));
		
		sop("Filtered List = "+myList.stream().filter(num -> num>5).collect(Collectors.toList()));
		
		sop("Reduce(Sum of integers) = " + myList.stream().reduce(0, (sum,num)-> {
			return num+sum;
			}));
		
	}

	private static void replaceAll(Map<String, Integer> numberMap) {
		numberMap.replaceAll((key,value)->key.length());
		numberMap.forEach((key, value)-> sop(key+" = "+value));
	}

	private static void putAndPutIfAbsent(Map<String, Integer> numberMap) {
		numberMap.putIfAbsent("monday", 2);
		sop("After put if absent");
		numberMap.forEach((key, value)-> sop(key+" = "+value));
		numberMap.put("monday", 2);
		sop("After put\n");
		numberMap.forEach((key, value)-> sop(key+" = "+value));
	}

	private static void getAndGetOrDefault(Map<String, Integer> numberMap) {
		//get and getordefault
		sop("getOrDefault");
		sop(numberMap.getOrDefault("not a key", 0));
		sop("get");
		sop(numberMap.get("not a key"));
	}

	private static void iterateUsingForEach(Map<String, Integer> numberMap) {
		sop("Iterating map using foreach");
		numberMap.forEach((key, value)-> sop("key="+key+",value="+value));
	}

}
