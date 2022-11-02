package com.concurrentpackage.demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.*;
import java.util.Vector;


class ListDecrementThread implements Runnable {
	private Semaphore listSemaphore;
	private List<Integer> list;
	public ListDecrementThread(Semaphore listSemaphore, List<Integer> list) {
		this.listSemaphore = listSemaphore;
		this.list= list;
	}
	@Override
	public void run() {
		try {
			System.out.println("ListDecrementThread Waiting for resource");
			listSemaphore.acquire();
			System.out.println("Resource acquired ListDecrementThread");
			System.out.println("List increment operation started");
			for(int i=0;i<list.size();i++) {
				list.set(i, list.get(i)-5);
				System.out.println(list.get(i));
				Thread.sleep(1000);
			}
			
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		System.out.println("ListDecrementThread released resource");
		listSemaphore.release();
	}
}
class ListIncrementThread implements Runnable {
	private Semaphore listSemaphore;
	private List<Integer> list;
	public ListIncrementThread(Semaphore listSemaphore, List<Integer> list) {
		this.listSemaphore = listSemaphore;
		this.list= list;
	}
	@Override
	public void run() {
		try {
			System.out.println("ListIncrementThread Waiting for resource");
			listSemaphore.acquire();
			System.out.println("Resource acquired by ListIncrementThread");
			System.out.println("List increment operation started");
			for(int i=0;i<list.size();i++) {
				list.set(i, list.get(i)+5);
				System.out.println(list.get(i));
				Thread.sleep(1000);
			}
			
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		System.out.println("ListIncrementThread released resource");
		listSemaphore.release();
	}
}
public class SemaphoresDemo {
public static void main(String args[]) throws InterruptedException {
		
		List<Integer> myList ;
		Collections.addAll(myList = new ArrayList<Integer>(), 1, 2, 3, 4,5,6,7,8,9);
//		Collections.addAll(myList = new Vector<Integer>(), 1, 2, 3, 4,5,6,7,8,9);
		
		Semaphore myListSemaphore = new Semaphore(2);
		Thread increThread = new Thread(new ListIncrementThread(myListSemaphore, myList));
		Thread decreThread = new Thread(new ListDecrementThread(myListSemaphore, myList));
		increThread.start();
		decreThread.start();
		decreThread.join();
		System.out.print(myList);
	}
}
