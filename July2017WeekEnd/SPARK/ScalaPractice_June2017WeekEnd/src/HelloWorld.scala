

/*object HelloWorld extends App{
  println("Hello World")
  for(str <- args) println("arg is "+str)
  
  val v1:Int=100
  val v2=10000.0
  
  println(" value of v1="+v1)
  println(s" value of v1 is $v1")
}
*/

object HelloWorld {
  def main(args: Array[String]): Unit = {
    println("Hello World in Main method")
   // for(str <- args) println("arg is "+str)
  
    val v1:Int=100
    val v2=10000.0
  
    println(" value of v1="+v1)
    println(s" value of v1 is $v1")
    
    println("****************")
    Person.method1()
    println("****************")
    
    val s1=Student("ABC",10);
    val s2=Student("ABC",10);
      val s3=Student(age=100,name="ABC");
      
      val s4=s1.copy(name="def");
      
    println(s1.name)
    val ls= List(("s1",20),("s2",30));
    //Create a list with Student objects
    val ls_stu=ls.map(x=>Student(x._1,x._2))
    
    ls_stu.foreach(s=>println("name="+s.name))
    
    
 
    println("****************")
    
    val p1=new Person("stu1",place="Bangalore");
    val p2=new Person("stu2",50,"Bangalore2");
    val p3=new Person(place="Bangalore",name="stu3");
    println("p1 name is ="+p1.name)
     println("p1 age is ="+p1.age)
     p1.age=55;
    println("p1 age is ="+p1.age)
    //println("p1 place is ="+p1.place)
  }
  
}



class Person(val name:String,var age:Int=30, place:String){
   var salutation:String="Mr"
    println("name="+name)
    println("age="+age)
    age=20;
    println("age="+age)
    println("place="+place)
    //place="Mysore"
    println("Saluation="+salutation)
}

//Companion object::
//Object with the same name as class name and the object and class should be present
//same source code file

object Person{
  def method1(){
    println("Inside method1")
  }
}

//Case Classes
case class Student(name:String,age:Int);
    
    
    
    
    
    
    

