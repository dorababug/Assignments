package com.inv;

public class HelloWorld extends Parent_ex{
	// class variables
	int i = 10;
	String name="Hadoop";

	public static void main(String[] args) {
		// args variable stores the command line arguments
		System.out.println("Hello world" + " - Welcome to Java");
		for (int i = 0; i < args.length; i++) {
			System.out.println(i + "th argument is=" + args[i]);
		}
		
		Parent_ex obj1=new Parent_ex();
		System.out.println("parent variables:"+obj1.name);
		obj1.method1();
		
		HelloWorld obj2=new HelloWorld();
		System.out.println("parent variables:"+obj2.name);
		obj2.method1();
		obj2.method2();
		
		
	}
	
	public void method1(){
		System.out.println("****I am in HelloWord, name is"+name);
	}

}

