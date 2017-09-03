
import org.apache.spark.SparkContext
import org.apache.log4j._


object Prog1 {
  def main(args: Array[String]): Unit = {
    
    Logger.getLogger("org").setLevel(Level.ERROR)
    
    val sc = new SparkContext("yarn","Sample Spark Program")
    
    val usersRDD= sc.textFile(args(0))
   // println(usersRDD.first)  
    val gender=usersRDD.map( x => ( x.split("::")(1),1))
    
  // val gender=usersRDD.map( x => x.split("::")(1))
  // gender.countByValue().foreach(println)
    
    val count=gender.reduceByKey((x,y)=> x+y)
    
    
    
    
    
    
    
  }
}