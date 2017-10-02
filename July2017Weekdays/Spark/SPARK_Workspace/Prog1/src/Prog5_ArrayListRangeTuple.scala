

object Prog5_ArrayListRangeTuple {
  def main(args: Array[String]): Unit = {
    
    //define first with length, assign later
    var books=new Array[String](3)
    books(0)="x"
    books(1)="y"
    books(2)="z"
    
    //Specify values at once
    var books1=Array("a","b","c")
    
    val l1:List[String] =List("a","b","c") // this is a single linked list
    println(l1.tail)
    println(l1.head)
    println(l1(0) , l1(2))  // here the index starts with 0
    
    val r1:Range= 1 to 5 
    println(r1)
    
    //IMP is Range operator is "<-", so you can iterate through list
    for(l2<-l1) {println(l2)}
    
    
    
    
    val tuple=(1,true,"ABC")
    println(tuple._1)  //index is 1, this is very IMP
    println(tuple._3)
    
    val tuple2= 1 -> true 
    // use relational operator ->  when a tuple contains Key and value info
    println(tuple2)
    println(tuple2._2)
    
    
    val map1=Map("A"-> "Android","j"->"Jython")
    println(map1("A"))
   // println( map1("z"))  // this throws exception Safe way is
    
    val zval = util.Try(map1("z")) getOrElse "Unknown"
    println(zval)
    
    
  }
}