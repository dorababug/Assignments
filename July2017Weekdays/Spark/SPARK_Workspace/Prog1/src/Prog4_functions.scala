

object Prog4_functions {
  def main(args: Array[String]): Unit = {
      
    //1) functions without args:
    def hello() = {   "Hello World" } // REPL hello: ()String
    // = is separator b/n method signature and method body.
    //Invoke the above by using hello or hello()
    
    println(hello)
    println(hello())    
    args.foreach ( println) // the arguments given are hi welcome to scala functional programming
    args.foreach { println} // the arguments given are hi welcome to scala functional programming
    
    //Functions with parameters
    def square=(i:Int)=>{i*i}    //  => is way to create functions
    // Int => String is equivalent to Function[Int, String] 
    // thiis takes Int and returns a string
    println("Square of 100 is"+square(100))
    
    val f:Function[Int,String] = myInt =>"My Int:"+myInt.toString
    println(f(10))
    //the above is same as
    val f1: Int => String = myInt => "My Int:"+myInt.toString
    
    def add(x: Int, y: Int):Int = {x+y}
    println("Add two values::"+ add(20,30))
  }
    
}

