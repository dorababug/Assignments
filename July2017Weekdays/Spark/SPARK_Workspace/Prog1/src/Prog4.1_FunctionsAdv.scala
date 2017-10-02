import java.awt.datatransfer.Transferable


object Prog6_FunctionsAdv extends App{
  
  
  // function syntax : def <fn_name>{param name: type ..} = { expression - returns value}
  // You must use = before the expression
  def squareNum(x:Int):Int ={ x*x }
  println(squareNum(10))
  
  //FUnctions take other functions as params:
  //Below takes two ints and does some transformation.
  def functionIp(x:Int, f: Int => Int) :Int ={f(x)}
  println(functionIp(50, squareNum))
  val res=functionIp(4, squareNum)
  println(res)
  
  //LET us use LAMBDA fn/Annymousfn/Functional literal
  //Declare function without a name to it.
  
  println( functionIp(2, x => x * x* x))   // x is transformed into x*x
  println( functionIp(9990, x => x / 10))
  
  //Multiline expression
  println( functionIp(2, x => {val y=x*2; y*y }) ) // here last line is ret val
  
  
}