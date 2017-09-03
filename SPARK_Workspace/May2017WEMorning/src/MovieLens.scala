import org.apache.spark.SparkConf
import org.apache.spark.SparkContext
import org.apache.spark.sql.SparkSession
import org.apache.log4j.Logger
import org.apache.log4j.Level._



object MovieLens {
  def main(args: Array[String]): Unit = {
    
    Logger.getLogger("org").setLevel(ERROR)
    
    //val conf= new SparkConf().set(key, value)
    val sc=new SparkContext("local[*]","Movie Lens Demo")
    //val sc=new SparkContext()
    
  
      
    //spark.sparkContext
    //2. Top twenty rated movies 
    //(Condition : The movie should be rated/viewed by at 
    //least 40 users)
    //val ratingsRDD=sc.textFile("/home/hadoop/Music/Classes/MovieLens-Work-SPARK/ml-1m/ratings.dat")
    val ratingsRDD=sc.textFile(args(0))
   /* println("++++ First:::"+ratingsRDD.first)
    println("++COunt:::"+ratingsRDD.count)
    */
    //1::1193::5::978300760
 /*   ratingsRDD
    .map(l=>   (l.split("::")(1),l.split("::")(2).toInt)    ) //(1193,5)
    .groupByKey()   // (1193 ,iterable(5,4,5,3......10ppl)
    .filter(x=>x._2.size > 40) // 
    .map(x=>(x._1,((x._2.sum)/x._2.size).toInt,x._2.size)  ) //already calculated result
    .repartition(1).sortBy(x=>x._2,false) //sort based in avg rating
    .sortBy(x=>x._3,false) //sort based on no of viers
    .take(20).foreach(println) //display top 20 movies.
    
 */   
     val spark=SparkSession
              .builder()
              .enableHiveSupport()
              .getOrCreate()
    
              
    val ratings=ratingsRDD
    .map(l=>   (l.split("::")(1),l.split("::")(2).toInt)    )
    
    val ratingsDF=spark.createDataFrame(ratings).toDF("mvid","rating")
    ratingsDF.createOrReplaceTempView("t_ratings")
  /*  spark.sql("select mvid,cast (avg(rating) as int) as avgrating,count(mvid) as noofviews from t_ratings group by mvid having count(mvid) > 40 order by avgrating desc,noofviews desc")
    .take(20).foreach(println)
   */ 
    import spark.implicits._
    //spark.read.textFile("/home/hadoop/Music/Classes/MovieLens-Work-SPARK/ml-1m/movies.dat")
      spark.read.textFile(args(1))
                 .map(x=>(x.split("::")(0),x.split("::")(1)))
                 .toDF("mvid","mvname")
                 .createOrReplaceTempView("t_movies")
        
   spark.sql("create  table hivepractice.out1(c1 String,c2 String,c3 String,c4 String) USING hive")
   spark.sql("create  table hivepractice.out1 as select t_ratings.mvid,cast (avg(rating) as int) as avgrating,count(t_ratings.mvid) as noofviews,mvname from t_ratings left join t_movies on t_ratings.mvid=t_movies.mvid group by t_ratings.mvid,mvname having count(t_ratings.mvid) > 40 order by avgrating desc,noofviews desc  ")
   //.rdd.repartition(1).saveAsTextFile(args(2))
      
   println("++++++++ Program Completed")
    
   
              
          
    
  }
}