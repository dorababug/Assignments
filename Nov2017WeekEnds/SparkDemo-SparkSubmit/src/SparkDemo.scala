import org.apache.spark.SparkConf
import org.apache.spark.sql.SparkSession


object SparkDemo {
  def main(args: Array[String]): Unit = {
    
    val conf=new SparkConf();
    //conf.set("master","local[*]")
    val spark=SparkSession.builder()
    .master("local[*]")
              .config(conf)
              .config("hive.exec.dynamic.partition.mode", "nonstrict")
              .enableHiveSupport()
              .getOrCreate()
     val sc=spark.sparkContext
     
     
     val moviesRDD=sc.textFile(args(0))
        .map(line=>line.replace("::", "%"))
        .map(line=>(line.split("%")(0),line.split("%")(1),line.split("%")(2)))
        
               
     
     import spark.implicits._ 
     moviesRDD.toDF("mvid","mvname","genres")
     .createOrReplaceTempView("movies")
     spark.sql("select * from movies").show()
    spark.sql("create table movielens.movies as select * from movies").show()

     sc.stop()
     spark.stop()
     
      
    
  }
}