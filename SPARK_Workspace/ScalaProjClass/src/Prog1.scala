

object Prog1 {
  
    def main(args: Array[String]): Unit = {
    //statement
      //expression
      val x=10;
      
      println({
        x
        x+100000
      } )
      //Assign function to a variable
    val y={
        x
        x+100000
        x*200
      }
      println(s"y valye $y")
      
      // Assign function to a method
      def squareInt(x:Int):Int = { x*x }
      
      println(squareInt(2))
     val z=squareInt(100)
     
     //How to pass a function to another function
     
     def ops(z:Int, f:Int => Int) = { f(z)}
      
      println(ops(30,squareInt))
      println(ops(2, x => x*x*x))
      
      println( ops(2, x => {val y=x*2; y*y }) )
       
      
      
      
      
      
      
      
     
     
      
      
      
      
    
  }
  
  
  
}