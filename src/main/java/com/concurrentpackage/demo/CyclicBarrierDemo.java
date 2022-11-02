package com.concurrentpackage.demo;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CyclicBarrierDemo {
	public static void main(String args[]) {
		ExecutorService es = Executors.newFixedThreadPool(3);
		CyclicBarrier cBarrier = new CyclicBarrier(3);
		es.execute(new DemoThread(1000, "Thread 1",cBarrier));
		es.execute(new DemoThread(2000, "Thread 2",cBarrier));
		es.execute(new DemoThread(3000, "Thread 3",cBarrier));
		System.out.println("Main method ended");
	}
}
class DemoThread implements Runnable{
	private int milliseconds;
	private String threadName;
	private CyclicBarrier cBarrier;
	public DemoThread(int milliseconds, String threadName, CyclicBarrier cb) {
		this.milliseconds = milliseconds;
		this.threadName =threadName;
		this.cBarrier = cb;
	}
	@Override
	public void run() {
		try {
			
			System.out.println("Started "+threadName+" thread");
			Thread.sleep(milliseconds);
			System.out.println(threadName+ " Reached barrier");
			cBarrier.await();
			System.out.println(threadName+ " Crossed barrier");
			
		} catch (InterruptedException| BrokenBarrierException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
