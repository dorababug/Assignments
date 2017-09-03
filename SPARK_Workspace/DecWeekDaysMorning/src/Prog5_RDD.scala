import org.apache.log4j._

import org.apache.spark._


object Prog5_RDD {
  def main(args: Array[String]): Unit = {
    
  
  Logger.getLogger("org").setLevel(Level.ERROR)
  val sc = new SparkContext("local[*]", "RatingsCounter")
  
  
  }
  
}