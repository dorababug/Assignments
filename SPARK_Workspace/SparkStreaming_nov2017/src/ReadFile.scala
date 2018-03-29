import org.apache.spark.sql.SparkSession
import org.apache.log4j.Logger
import org.apache.log4j.Level


object ReadFile {
  def main(args: Array[String]): Unit = {
            Logger.getLogger("org").setLevel(Level.ERROR)

     var spark=SparkSession.
 builder.
 appName("Movies1").
 master("local[*]").
 getOrCreate()
 
 spark.read.parquet("/home/hadoop/INPUT/strOut").show()
 
  }
}