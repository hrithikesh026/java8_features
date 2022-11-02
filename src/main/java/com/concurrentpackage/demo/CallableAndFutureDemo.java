package com.concurrentpackage.demo;


import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;



public class CallableAndFutureDemo {
	public static void main(String args[])  {
		ExecutorService eService = Executors.newFixedThreadPool(3);
		Future<Integer> f1 = eService.submit(new CallableExample());
		Future<Integer> f2 = eService.submit(new CallableExample());
		Future<Integer> f3 = eService.submit(new CallableExample());

		try {
			System.out.println(f1.get());
			System.out.println(f2.get());
			System.out.println(f3.get());


//			System.out.println(f1.get(10000, TimeUnit.MILLISECONDS));
//			System.out.println(f2.get(10000, TimeUnit.MILLISECONDS));
//			System.out.println(f3.get(10000, TimeUnit.MILLISECONDS));
			
			System.out.println("after complete");
			System.out.println(f1);
			System.out.println(f2);
			System.out.println(f3);
		} catch (InterruptedException | ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		eService.shutdown();
		System.out.println("End or main method");
	}
}
class CallableExample implements Callable<Integer>
{
	@Override
    public Integer call() throws Exception
    {
        // Create random number generator
        Random generator = new Random();
  
        Integer randomNumber = generator.nextInt(5);
        Thread.sleep(randomNumber * 1000);
        return randomNumber;
    }
}