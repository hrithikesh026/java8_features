package com.completablefuture.demo;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;



public class RunAsyncAndSupplyAsyncDemo {
	public static void main(String[] args) throws InterruptedException, ExecutionException {
//		runAsyncMethod();
		supplyAsyncMetho();
	}

	private static void supplyAsyncMetho() throws InterruptedException, ExecutionException {
		CompletableFuture completableFuture = CompletableFuture.supplyAsync(()->{
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return "This message is printed after 1 second";
		});
		
		completableFuture.thenAccept(str->System.out.println("Printing through Consumer: "+str));
		
		completableFuture.thenRun(()->System.out.println("Completed future operation"));
		
		System.out.println(completableFuture.get());
	}

	private static void runAsyncMethod() throws InterruptedException, ExecutionException {
		CompletableFuture completableFuture = CompletableFuture.runAsync(()->{
			try {
				Thread.sleep(2000);
				System.out.println("This message is printed after 1 second");
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		});
//		if(completableFuture.cancel(false)) {
//			System.out.println("Operation cancelled");
//		}else {
//			System.out.println("Operation not cancelled");
//		}
		completableFuture.get();
	}
}
