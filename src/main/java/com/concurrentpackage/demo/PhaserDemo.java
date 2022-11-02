package com.concurrentpackage.demo;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Phaser;



public class PhaserDemo {
	public static void main(String args[]) {
		ExecutorService eService = Executors.newFixedThreadPool(4);
		Phaser phaser = new Phaser(3);
		eService.execute(new ParserDemoThread(1000, "Thread 1", phaser));
		eService.execute(new ParserDemoThread(2000, "Thread 2", phaser));
		eService.execute(new ParserDemoThread(3000, "Thread 3", phaser));
		phaser.awaitAdvance(0);
		System.out.println("Main function ended");
	}
	
}
class ParserDemoThread implements Runnable{
	private int milliseconds;
	private String threadName;
	private Phaser phaser;
	public ParserDemoThread(int milliseconds, String threadName, Phaser phaser) {
		this.milliseconds = milliseconds;
		this.threadName =threadName;
		this.phaser = phaser;
	}
	@Override
	public void run() {
		try {
			
			System.out.println("Started "+threadName+" thread");
			Thread.sleep(milliseconds);
			System.out.println(threadName+ " Reached phase");
			phaser.arrive();
			System.out.println("Arrived at "+phaser.getArrivedParties());
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(threadName+ " Crossed phase");
	}
	
}
