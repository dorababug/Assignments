import org.apache.spark.SparkContext
import org.apache.spark.SparkContext._
import org.apache.spark.SparkConf

object SparkWordCount {
  def main(args: Array[String]): Unit = {
    
    val sc = new SparkContext(new SparkConf().setAppName("Spark Count"))
    
    // read in text file and split each document into words
    val tokenized = sc.textFile("file:///home/hadoop/h1.txt").flatMap(_.split(" "))

    // count the occurrence of each word
    val wordCounts = tokenized.map((_, 1)).reduceByKey(_ + _)

        // count characters
    val charCounts = wordCounts.flatMap(_._1.toCharArray).map((_, 1)).reduceByKey(_ + _)

    System.out.println(charCounts.collect().mkString(", "))
    
  }
}