

object ScalaDemo {
  def main(args: Array[String]): Unit ={
    //String args[] String[] args
    println("Hello Scala")
    for(t <- args) println("argument is "+ t)
    args.foreach(t => println("argument is(function) "+ t))
    
    
    val obj=new Student(100,"Stu100","Male");
   //Print each memeber of obj 
   // println(obj.salutation);
   println( obj.getSalutation())
   obj.setSalutation("aaaa");
   println( obj.getSalutation())
   
   println(obj.id)
  //obj.id=100
    println(obj.name)
    obj.name="zzzzz"
    println(obj.name)
   
  }
  
}

class Student(val id:Int=1,var name:String="def",gender:String){
    private var salutation="Mr"
    
    println("id is"+id);
    //id=100;
    println("1 -> name is"+name);
    name="inventateq"
    println("2 -> name is"+name);
    
    println("gender is"+gender);
    
    
    def setSalutation(s:String){
      salutation=s;
    }
     def getSalutation(){
      salutation
    }
    
    
  
  
}