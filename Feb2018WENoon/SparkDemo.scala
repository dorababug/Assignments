import org.apache.spark.SparkConf
import org.apache.spark.SparkConf
import org.apache.spark.SparkContext
import org.apache.spark.sql.SparkSession
import scala.io.Source
import org.apache.log4j.Logger
import org.apache.log4j.Level


object SparkDemo {
  def main(args: Array[String]): Unit = {
          Logger.getLogger("org").setLevel(Level.ERROR)
    
    val conf=new SparkConf().setMaster("local[*]")
    .set("spark.app.name","Sample Spark Core Demo")
    
    val sc=new SparkContext(conf)
    
    val spark=SparkSession.builder()
    .enableHiveSupport()
    .appName("spark demo")
    .config(conf)
    .config("spark.app.name","Sample Spark Core Demo")
    .getOrCreate()

     /*for (line <- Source.fromFile(args(0)).getLines) {
        println(line)
        spark.sql(line).show()
    }
  */
    
    println(Source.fromFile(args(0)).mkString)
    
    val arr=Source.fromFile(args(0)).mkString.split(";")
    for(a <- arr){
      println(a)
    }
  
  
  }
  
}