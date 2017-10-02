import org.apache.spark.SparkContext
import org.apache.log4j.Logger
import org.apache.log4j.Level


object WordCount {
  def main(args: Array[String]): Unit = {
    Logger.getLogger("org").setLevel(Level.ERROR)

    //val sc=new  SparkContext("local[*]","WordCount")
    val sc=new  SparkContext()
    
    
    val inputRDD=sc.textFile(args(0))
   inputRDD.flatMap(line=>line.split(" "))
   .map(x=>(x,1))
   .reduceByKey((x,y)=>x+y)
   .saveAsTextFile(args(1))
    
    println("Program Completed")
  }
  
}