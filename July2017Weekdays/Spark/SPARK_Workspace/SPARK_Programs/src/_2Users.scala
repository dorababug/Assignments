import org.apache.spark.SparkContext
import org.apache.log4j._


object _2Users {
  def main(args: Array[String]): Unit = {
    // users data
    //UserID::Gender::Age::Occupation::Zip-code
    
    //Set Log Level to ERRORS from org.apache.log4j.Logger
     Logger.getLogger("org").setLevel(Level.ERROR)
    //Create Spark COntext instance
    
        val sc = new SparkContext("local[*]", "RatingsCounter")
        
       //Ratings Data contains UserID::MovieID::Rating::Timestamp
        val lines = sc.textFile("/home/hadoop/Music/Classes/MovieLens-Work-SPARK/ml-1m/users.dat")
        
        println(lines.count)
        
        val lmap=lines.map(x => x.toString().split("::"))
        
        val lflatmap=lines.flatMap(x => x.toString().split("::"))
       //-----------------------------
        //count by gender
        val pairlines=lines.map(x => (x.toString().split("::")(1), 1))
        val res=pairlines.reduceByKey( (x, y) => x + y )
           res.collect()
     // flip keys and values 
         val flipres = pairlines.map( x => (x._2, x._1) )
    
    
  }
}