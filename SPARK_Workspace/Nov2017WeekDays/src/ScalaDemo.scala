
//object ScalaDemo extends App{
object ScalaDemo {
  def main(args: Array[String]): Unit ={
   
    //String args[] String[] args
    println("Hello Scala")
    for(t <- args) println("argument is "+ t)
    args.foreach(t => println("argument is(function) "+ t))
    
    
    val stu1=new Student(100,"Stu100","Male");
   //Print each memeber of obj 
   // println(obj.salutation);
   println(stu1.id)
  // stu1.id="1000"
   println( stu1.name)
   stu1.name="stu101"
   stu1.setName("stu102")
   println( stu1.name)
   println(stu1.salutation1)
   stu1.salutation1="abc"
   println(stu1.salutation1)
    // println(stu1.salutation)
   
   //simulate static members in Scala
   //companion object
   println(Student.className)
      
   val stu2=new Student(100,"Male");
   println(stu2.id)
    println(stu2.name)
    
    println("-----------------------")
    val p1=Person(1,"p1","Mr")
    val p2=p1.copy(id=2)
    println(p1==p2)
  }
  
}

case class Person(id:Int,name:String,gender:String)


class Student(val id:Int,var name:String,gender:String){
    private var salutation="Mr"
     var salutation1="Mr"
    println("id is"+id);
    println("1 -> name is"+name);
    println("gender is"+gender);
    println("salutation is"+salutation);
    //val only getter
    //var both getter/setter
    //no val/var-> dont create
    //private val/var -> prevents the methods getting generated
    
    def setName( str:String): Unit={
      name=str;      
    }    
    
    //auxiliary constructor
    def this( id:Int,gender:String)={
      this(id,Student.def_name,gender)
    }
}
//companion object
object Student{
  var className:String ="class1"
  var def_name:String ="11111111"
  println("Inside companion object"+className)
}



