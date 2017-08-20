package com.inv;

public class HelloWorld {
	int val = 10;

	public static void main(String[] args) {
		System.out.println("Hello World");
		//System.out.println("I value is::: "+i);
		
		for (int i = 0; i < args.length; i++) {
			System.out.println("Hello::::"+args[i]);
		}
		for (int i = 0; i < args.length; i++) {
			System.out.println(i+"th Arg is ::::"+args[i]);
		}

		HelloWorld obj1=new HelloWorld();
		obj1.printValue();
		System.out.println("I value is "+obj1.val);
	}
	
	public void printValue() {
		System.out.println("I value is::: "+val);
		
	}

}
