import org.apache.spark.SparkContext
import org.apache.spark.SparkContext._
import org.apache.spark.SparkConf

object SimpleSBTDemo {
  def main(args: Array[String]) {
    val logFile = "/home/hadoop/YARNBOX/spark-2.0.2-bin-hadoop2.7/README.md" // Should be some file on your system
    val conf = new SparkConf().setAppName("Simple Application").setMaster("local[2]")
    val sc = new SparkContext(conf)
    val logData = sc.textFile(logFile, 2).cache()
    val numAs = logData.filter(line => line.contains("Spark")).count()
    val numBs = logData.filter(line => line.contains("Apache")).count()
    println(s"Lines with a: $numAs, Lines with b: $numBs")
    sc.stop()
  }
}
