

object Prog2_objectclass {
    def main(args: Array[String]): Unit = {
    args.foreach(println)
    
    val area=new Area(10,20)
    println(area.calcArea(20, 40))
  }
    
}
class Area(val length:Int,val breadth:Int ){
  var l1:Int =length
  var b1:Int =breadth
  def calcArea(l:Int,b:Int): Int ={
    (l1+l) * (b1+b)
  }
}

