//import org.apache.log4j.Logger
import org.apache.log4j._
import org.apache.spark.SparkContext
import org.joda.time.DateTime
import org.apache.spark.sql.SQLContext


object _1Ratings {
  
  def main(args: Array[String]): Unit = {
    
    //Set Log Level to ERRORS from org.apache.log4j.Logger
     Logger.getLogger("org").setLevel(Level.ERROR)
    //Create Spark COntext instance
    
        val sc = new SparkContext("local[*]", "RatingsCounter")
        
       //Ratings Data contains UserID::MovieID::Rating::Timestamp
        val lines = sc.textFile("/home/hadoop/Music/Classes/MovieLens-Work-SPARK/ml-1m/ratings.dat")
        
        println(lines.count)
        
        //Question 1:
        //How many Distinct Users are in Ratings data set?
        val userRDD=lines.map(x => x.toString().split("::")(0))
        val distinctUsrCount=userRDD.distinct.count
        println(s" Distinct Users in the data are ::: $distinctUsrCount" )
        
        //Similarly How many distinct movies
        //Print  distinct ratings?
        val ratings=lines.map(x => x.toString().split("::")(2)).distinct().collect
        
        for(x<-ratings) println(x)
        
        //------------------------------------------
        
        //Question: How many movis got 1, how many movies got 2
        //Count movies by rating
        val ratingsRDD=lines.map(x => x.toString().split("::")(2))
        val result=ratingsRDD.countByValue()
        
        result.foreach(println)
        
        println(result.getClass())  //Hash map
        
         val resultSorted = result.toSeq.sortBy(_._1)
        
         resultSorted.foreach(println)
        println("________________________________________________________")
        //order the results
        //google - convert epoch Timestamp  in seconds since the epoch time
        //below Not correct
       // val stri = new DateTime(978302109/1000L).toDateTime.toString("yyyy/MM/dd")
       // println(stri)
        
        // Question : Each user How many ratings given
        
        
          
  }
  
}