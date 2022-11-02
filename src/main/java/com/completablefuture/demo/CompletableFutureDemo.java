package com.completablefuture.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;

public class CompletableFutureDemo {
	public static void main(String[] args) {
		CompletableFuture<String> completableFuture = calculateAsynce();
		
		try {
			System.out.println("calling get() in completable future");
			String result = completableFuture.get();
			System.out.println(result);
			System.out.println("Thread name  = "+Thread.currentThread().getName());
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		} 
	}

	private static CompletableFuture<String> calculateAsynce() {
		CompletableFuture<String> completableFuture = new CompletableFuture<>();
		
		List<String> list = new ArrayList<>();
		list.add("one");
		list.add("two");
		list.add("three");
		
		Executors.newCachedThreadPool().submit(()->{
			try {
				Thread.sleep(2000);
				String joinStr = String.join(",", list);
				System.out.println("Thread name  = "+Thread.currentThread().getName());
				completableFuture.complete(joinStr);
				System.out.println("Completed future");
			} catch (Exception e) {
				e.printStackTrace();
			}
			return null;
		});
		return completableFuture;
	}
}
