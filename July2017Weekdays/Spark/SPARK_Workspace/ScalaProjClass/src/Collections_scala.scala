

object Collections_scala extends App{
  println(" start of the program")
  val books=Array("1","2","3")
  println(books.getClass().getName())
  println(books(0))
  
  for {t1 <- books
        t2=t1 } { println(t1)
                  println("t2 Value is"+t2) }
  val l1:List[Int] = List(100,200,300,400)
  println(l1.head)
  println(l1.tail)

  println(l1(0))
  println("*************")
  for {l2<-l1} {println(l2) }
  
  val r1:Range= 1 to 50 by 5
    println(r1)
  
  val map1=Map("A"-> "Android","j"->"Jython")
    println(map1("A"))
    //println( map1("z"))  // this throws exception Safe way is
    
    val zval = util.Try(map1("z")) getOrElse "Unknown"
    println(zval)
    
  
  
  
  
}














