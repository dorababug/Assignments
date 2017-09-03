import org.apache.spark.SparkConf
import org.apache.spark.SparkContext
import org.apache.log4j.Logger
import org.apache.log4j._
import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.SQLContext

object RatingsYarn {
  def main(args: Array[String]): Unit = {
    
     Logger.getLogger("org").setLevel(Level.ERROR)

    
    val conf=new SparkConf()
    //spark standalone mode
    val sc=new  SparkContext("local[*]","Ratings")
     //val sc=new  SparkContext(conf)
    
    //Create an RDD
    //UserID::MovieID::Rating::Timestamp
    //val ratingsRDD=sc.textFile(args(0))
    val ratingsRDD=sc.textFile("/home/hadoop/Music/Classes/MovieLens-Work-SPARK/ml-1m/ratings.dat")
    /// Movie id - How many times it is rated??
    val movies=ratingsRDD.map(x => (x.split("::")(1),1))
    val countRDD=movies.reduceByKey((x,y)=>x+y).sortBy(x => x._2, false, 1)
    
    //Sort the data based on count
    
   // countRDD.saveAsTextFile(args(1))
    //val spark=SparkSession.builder().appName("MovieLens").getOrCreate();
        
import org.apache.spark.sql.SparkSession

val spark = SparkSession
  .builder()
  .appName("Spark SQL")
  .getOrCreate()

 import spark.implicits._
 //The above import is for converting RDD to DF.
 import org.apache.spark.sql.types.{StructField, StringType,IntegerType}
 val fields=Array( StructField("mvid", StringType), StructField("count", IntegerType))
 import org.apache.spark.sql.types.StructType
  val schema = StructType(fields)
  import org.apache.spark.sql.Row
  val countRowRDD=countRDD.map(a => Row.fromTuple(a))
  
   val countDF = spark.createDataFrame(countRowRDD, schema)
   
   

 /*  val sqlContext=new SQLContext(sc)
 import sqlContext.implicits._
 import sqlContext._
 
 val countDF1=countRDD.toDF() */
 
 
   
    println("**** count data frame schema **")
   countDF.printSchema() 
   countDF.createOrReplaceTempView("mvcount")
   spark.sql("select * from mvcount where count>2500").show()
   
   val mvnamesRowRDD=spark.sparkContext
   .textFile("/home/hadoop/Music/Classes/MovieLens-Work-SPARK/ml-1m/movies.dat")
   .map(line => Row.fromTuple((line.split("::")(0),line.split("::")(1))))
   
   val mvfields=Array( StructField("mvid", StringType), StructField("mvname", StringType))
   val mvschema = StructType(mvfields)
   val mvDF = spark.createDataFrame(mvnamesRowRDD, mvschema)
   
   mvDF.createOrReplaceTempView("mvname")
   
   println("**** MvName table ***")
   spark.sql("select n.*,c.count from  mvname n  join  mvcount c on c.mvid=n.mvid where count>2500 order by count desc")
   .repartition(1).write.csv("/home/hadoop/Music/Classes/MovieLens-Work-SPARK/ml-1m/result")

  }
}