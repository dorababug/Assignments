import org.apache.spark.SparkConf
import org.apache.spark.SparkContext
import org.apache.spark.sql._
import org.apache.log4j._



object _5Movies {
  def main(args: Array[String]): Unit = {
    
   Logger.getLogger("org").setLevel(Level.ERROR)
   val sc = new SparkContext("local[*]", "RatingsCounter")
   val sqlContext = new SQLContext(sc)

        // this is used to implicitly convert an RDD to a DataFrame.
   import sqlContext.implicits._
   val ratingsRDD = sc.textFile("/home/hadoop/Music/Classes/MovieLens-Work-SPARK/ml-1m/ratings.dat")
     
    def loadRatings(x:String)={
     val y=x.split("::")
      (y(0),y(1),y(2).toInt)      
    }
    
   
     val ratingsDF=ratingsRDD.map(loadRatings).toDF("userid","movieid","rating")
    ratingsDF.take(10).foreach(println)
    
    import org.apache.spark.sql.functions._
    val avg=ratingsDF.groupBy("movieid").avg("rating").sort(desc("avg(rating)"))
    avg.take(100).foreach(println)
    
    println("----------------------------------------")
    
    ratingsDF.createOrReplaceTempView("movies")
    
    val avgRatings= sqlContext.sql("select * from (select movieid,avg(rating) as avgrating,count(movieid) cnt from movies group by movieid) t where cnt>20 order by avgrating desc  limit 100")
    avgRatings.show()
    
    
  }
}