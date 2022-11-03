package com.concurrentpackage.demo;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentHashMapDemo {
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
	public static void main(String args[]) {
		ConcurrentHashMap<String, Integer> chm = new ConcurrentHashMap<>(getMap());
		
		new ConcurrentHashmapThread(chm, "A");
		new ConcurrentHashmapThread(chm, "B");
		new ConcurrentHashmapThread(chm, "C");
		new ConcurrentHashmapThread(chm, "D");
		System.out.println(chm);
		
		chm.forEach(4, (key,value)-> System.out.println(key +" = "+value));  
 	}
}

class ConcurrentHashmapThread implements Runnable{
	private ConcurrentHashMap<String, Integer> chm;
	private String threadName;
	public ConcurrentHashmapThread(ConcurrentHashMap<String, Integer> chm, String threadName) {
		this.chm = chm;
		this.threadName = threadName;
		new Thread(this).start();
	}
	@Override
	public void run() {
		chm.put("monday", chm.get("monday")+10);
		System.out.println("thread "+threadName+" completed");
	}
	
}

