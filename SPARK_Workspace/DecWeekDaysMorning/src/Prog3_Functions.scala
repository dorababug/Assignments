

object Prog3_Functions {
  
   def main(args: Array[String]) {
      println( printarea( areaSqare, 10) )
      println( printarea( areaCircle, 10) )
   }

   def printarea(f: Int => String, v: Int) = f(v)

   def areaSqare(x: Int) = "[" + (x * x).toString() + "]"
   import scala.math._
   def areaCircle(x: Int) = "[" + (Pi * x * x).toString() + "]"
   
}