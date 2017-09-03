import org.apache.spark.SparkContext
import org.apache.log4j.Logger
import org.apache.log4j.Level
import org.apache.spark.SparkConf


object MovieLens {
  def main(args: Array[String]): Unit = {
    
    Logger.getLogger("org").setLevel(Level.ERROR)
    
    
    //val sc= new SparkContext("local[*]","Sample Spark App")
    val sc= new SparkContext(new SparkConf())
    //val users=sc.textFile("/home/hadoop/Music/Classes/MovieLens-Work/ml-1m/users.dat")
    val users=sc.textFile(args(0))
    val occ=users.map(x => (x.split("::")(3).toInt,1))
    //occ.take(10).foreach(println)
    
    occ.reduceByKey((x,y)=> x+y ).filter(x=> x._2>300)
    .repartition(1)
    .sortBy(x=> x._2,true).saveAsTextFile(args(1))
    
    
    
 }
}