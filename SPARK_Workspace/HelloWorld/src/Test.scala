

object Test {
  //object Test extends App{
  def main(args: Array[String]): Unit = {
   println("hello world")
    println("***************")
   for(a <- args) println(a)
   println("***************")
   args.foreach(println)  
   
  }
  
}