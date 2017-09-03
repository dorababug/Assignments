

object Prog3_ConditionalOps {
  
  def main(args: Array[String]): Unit = {
    
    // IF, WHILE, FOR , TRY, MATCH : except while all reuslts in some value
    //hence while and dowhile are loops where as all others are expressions.
    //since they are expressions they supports functional approach as well
    
  if(1>2) println("True Here") else println("False")
  val i:Int = if (true) 1 else 3
  println(i)
  
  
  
  val number=args(0).toInt   //Here it is not Square brackets, parenthesis
  number match {
    case 1 => println("One")
    case 2 => println("two")
    case 3 => println("three")
    case _ => println("OTHRS")
  }
  
  // FOR Comprehension: this is very powerful control structure of scala
  // We can iterate over collections using FOR
  //Provides filtering options  hence Can generate new collections
  
  // Left arrow is called generator, it creates temp variable 
  for (x <- 0 to 20 by 5){
    val square=x*x
    println(square)
  }
  
  
  val l1:List[String] =List("a","b","c")
  for( l2 <- l1){
      println("The value l2 is:::"+l2)
      println(l2.getClass.getSimpleName)
  }
  
  // we can use FILTERS in FOR expression, that will tell when you do not want
  // to iterate through the entire collection
  for( l2 <- l1
        if l2.contains("b")){
      println("The value l2 is:::"+l2)
      println(l2.getClass.getSimpleName)
  }
  // You can do VARIABLE BINDING in for expression. i.e you can define 
  //variables inside for expression and reuse them
  // In this case we use {} instead of ()
  // This is useful when you want to transform elements in your collection
  //while looping through them
  for{ l2 <- l1
        t1=l2.toUpperCase()}{
      println(" t1 is:::"+t1)
  }
  
  // YIELDING - in for expression can be used to generate new collections
       val l2:List[String] =List("a","b","c","b")  
   var t2=for{ l3 <- l2
        if l3.contains("b") }   yield l3
    println(" Value of t2 is "+t2)
        
  
  
  var j=10
  while(j>0){
    println("...."+j)
    j-=1
  }
}
}