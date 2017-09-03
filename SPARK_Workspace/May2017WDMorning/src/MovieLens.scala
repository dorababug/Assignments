import org.apache.spark.SparkContext
import org.apache.spark.SparkConf
import org.apache.log4j.Logger
import org.apache.log4j._
import org.apache.spark.sql.SparkSession


object MovieLens {
  def main(args: Array[String]): Unit = {
    
   // val conf=new SparkConf().set(key, value)
    
    Logger.getLogger("org").setLevel(Level.ERROR);
    
   // val sc=new SparkContext("local[*]","MovieLens")
     val sc=new SparkContext()
     
     val spark=SparkSession
     .builder()
     .master("local[*]")
     .appName("MovileLens")
     .enableHiveSupport()
     .getOrCreate()
     
     
     
     
   // val mvRDD=sc.textFile("/home/hadoop/Music/Classes/MovieLens-Work/ml-1m/movies.dat")
      val mvRDD=sc.textFile(args(0))
      val mvDS=spark.read.text(path)
    //1::Toy Story (1995)::Animation|Children's|Comedy
    
    val extractYear=(line:String)=>{
      val year=line.substring(line.lastIndexOf('(')+1, line.lastIndexOf(')'))
      //println(year)
      (year,1)      
    }
   
    // println(extractYear("1::Toy Story (1995)::Animation|Children's|Comedy"))
   
    val movieyears=mvRDD.map(extractYear)    
    //movieyears.reduceByKey((x,y)=>x+y).sortBy(x=>x._2,false,1).foreach(println)
    movieyears.reduceByKey((x,y)=>x+y).sortBy(x=>x._2,false,1).saveAsTextFile(args(1))
    
    println("----Program COmpleted---")
    
    
  }
}

/*object MovieLens1 extends App{
  
}*/