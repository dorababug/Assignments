import org.apache.spark.SparkContext
import org.apache.log4j._


object _4Movies {
    def main(args: Array[String]): Unit = {
      
     Logger.getLogger("org").setLevel(Level.ERROR)
      
      val sc=new SparkContext("local[*]", "Movies Data set")
      val ratingsRDD = sc.textFile("/home/hadoop/Music/Classes/MovieLens-Work-SPARK/ml-1m/ratings.dat")
      
      //UserID::MovieID::Rating::Timestamp
      
      def extract_movie(x:String)={
       
       val movieID=x.split("::")(1)
       (movieID,1)   
       
     }
      
      
      val movieID=ratingsRDD.map(extract_movie)
      // val movieID=ratingsRDD.map(x=> (x.split("::")(1),1)
      //movieID.take(10).foreach(println)
      
      val countMovies=movieID.reduceByKey((x,y)=> x+y )
      
      //countMovies.take(10).foreach(println)
      
      val top10=countMovies.sortBy(_._2, false, 1).take(10)
      top10.foreach(println)
     
      
      val movieData=sc.textFile("/home/hadoop/Music/Classes/MovieLens-Work-SPARK/ml-1m/movies.dat")
      val movieName=movieData.map(x=> (x.split(":")(0),x.split(":")(1)))
          movieName.take(10).foreach(println)
          
         val jnd= countMovies.join( movieName)
         println("-------------------------")
         jnd.take(10).foreach(println)
         println("-------------------------")
         val jnd_sorted=jnd.sortBy(_._2._1, false, 1)
         jnd_sorted.take(10).foreach(println)
      
      
    }
    
  
  
}