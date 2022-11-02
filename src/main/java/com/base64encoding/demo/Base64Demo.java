package com.base64encoding.demo;

import java.io.UnsupportedEncodingException;
import java.util.Base64;

public class Base64Demo {
	public static void main(String[] args) throws UnsupportedEncodingException {
		simpleEncodingAndDecoding();
		urlEncodingAndDecoding();
		mimeEncodingAndDecoding();
	}

	private static void mimeEncodingAndDecoding() throws UnsupportedEncodingException {
		final String textDate = "Java8 base64 encoding-decoding!!!";
		String encodedText = Base64.getMimeEncoder().encodeToString(textDate.getBytes("UTF-8"));
		System.out.println(encodedText);
		
		byte[] decodedArr =	 Base64.getMimeDecoder().decode(encodedText);
		String decodedText = new String(decodedArr, "UTF-8");
		
		System.out.println(decodedText);
	}

	private static void urlEncodingAndDecoding() throws UnsupportedEncodingException {
		final String textDate = "Java8 base64 encoding-decoding!!!";
		String encodedText = Base64.getUrlEncoder().encodeToString(textDate.getBytes("UTF-8"));
		System.out.println(encodedText);
		
		byte[] decodedArr =	 Base64.getUrlDecoder().decode(encodedText);
		String decodedText = new String(decodedArr, "UTF-8");
		
		System.out.println(decodedText);
	}

	private static void simpleEncodingAndDecoding() throws UnsupportedEncodingException {
		final String textDate = "Java8 base64 encoding-decoding!!!";
		String encodedText = Base64.getEncoder().encodeToString(textDate.getBytes("UTF-8"));
		System.out.println(encodedText);
		
		byte[] decodedArr = Base64.getDecoder().decode(encodedText);
		String decodedText = new String(decodedArr, "UTF-8");
		
		System.out.println(decodedText);
	}

}
