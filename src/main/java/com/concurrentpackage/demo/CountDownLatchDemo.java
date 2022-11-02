package com.concurrentpackage.demo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;

class myThread implements Runnable {
	private CountDownLatch cdl;
	private List<Integer> list;
	public myThread(CountDownLatch cdl, List<Integer> list) {
		this.cdl = cdl;
		this.list= list;
		new Thread(this).start();
	}
	@Override
	public void run() {
		for(int i=0;i<list.size();i++) {
			list.set(i, null);
			cdl.countDown();
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println(list);
	}
}

public class CountDownLatchDemo {
	public static void main(String args[]){
		
		List<Integer> myList ;
		Collections.addAll(myList = new ArrayList<Integer>(), 1, 2, 3, 4,5,6,7,8,9);
//		Collections.addAll(myList = new Vector<Integer>(), 1, 2, 3, 4,5,6,7,8,9);
		CountDownLatch cdl = new CountDownLatch(5);
		new myThread(cdl, myList);
		System.out.println("Waiting");
		try {
			cdl.await();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("after countdown = " + myList);
	}
}
