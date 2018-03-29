import org.apache.spark.SparkConf
import org.apache.spark.SparkContext
import org.apache.log4j.Logger
import org.apache.log4j.Level


object SparkDemo {
  def main(args: Array[String]): Unit = {
    
    
      Logger.getLogger("org").setLevel(Level.ERROR)
    
    //spark conf'
    //using conf -> spark context
    val conf=new SparkConf() //.set("spark.master", "Local[*]")
    .set("spark.app.name", "Spark DEMO")
    .setMaster("local[*]")
    val sc=new SparkContext(conf)
    
   println("Start of Program")
    val inputRDD=sc.textFile(args(0))
    inputRDD.flatMap(line=>line.split(" "))
    .map(word => (word,1))
    .reduceByKey((x,y)=>x+y)
    .saveAsTextFile(args(1))
    println("Program is completed")
    
  }
}