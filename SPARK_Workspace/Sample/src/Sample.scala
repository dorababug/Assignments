

object Sample {
  def main(args: Array[String]): Unit = {
    
    val obj1=new abc("10","20")
    println(obj1.f2)
     println(obj1.f1)
    obj1.f1="1000"
     println(obj1.f1)
     //obj1.f2="1000"
    
    
  }
  
}
class abc(var f1:String, val f2:String);