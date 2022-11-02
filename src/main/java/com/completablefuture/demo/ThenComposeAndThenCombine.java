package com.completablefuture.demo;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class ThenComposeAndThenCombine {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
//		thenComposeMethod();
		thenCombineMethod();
	}

	private static void thenCombineMethod() throws InterruptedException, ExecutionException {
		CompletableFuture<String> completableFuture 
		  = CompletableFuture.supplyAsync(() -> {
			  System.out.println("First operation started");
			  try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			  return "Hello";
		  })
		    .thenCombine(CompletableFuture.supplyAsync(
		      () -> {
		    	  System.out.println("Second Operation started");
		    	  
		    	  return "World";
		      }), (s1, s2) -> s1.toUpperCase() + s2.toUpperCase());
		
		System.out.println(completableFuture.get());
	}

	private static void thenComposeMethod() throws InterruptedException, ExecutionException {
		CompletableFuture<String> completableFuture;
		completableFuture = CompletableFuture.supplyAsync(() -> {
			System.out.println("First operation started");
			return "Hello";
		});
		CompletableFuture<String> completableFuture2;
		completableFuture2 = completableFuture
								.thenCompose(s -> CompletableFuture.supplyAsync(() -> s + " World"));
		
		System.out.println(completableFuture2.get());
	}

}
