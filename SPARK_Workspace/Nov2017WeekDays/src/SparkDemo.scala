import org.apache.spark.SparkConf
import org.apache.spark.sql.SparkSession


object SparkDemo {
  def main(args: Array[String]): Unit = {
    //spark context
    //Spark Core-> 
    import org.apache.spark.SparkContext

    //val sprakConf=new SparkConf().set("spark.master", "local[*]").setAppName("SparkWC");
   /* val sparkConf=new SparkConf();
    val sc=new SparkContext(sparkConf)
    val inputRDD=sc.textFile(args(0));
    inputRDD.
    flatMap(line=>line.split(" ")).
    map(word=>(word,1)).
    reduceByKey((x,y)=>x+y).
    saveAsTextFile(args(1))
    println(" program Completed")*/
    
    //val sparkConf=new SparkConf()
    val sparkConf=new SparkConf().set("spark.master", "local[*]").setAppName("SparkWC");
    val spark=SparkSession.builder().config(sparkConf)
            .config("hive.exec.dynamic.partition.mode","true")
            .enableHiveSupport()
            .getOrCreate()
    /*spark.sql("""create table if not exists 
      hivepractice.emp2014 as select * from hivepractice.employee_hr 
      where year(start_date)=2014""")*/         
      
    
    
  }
    
    

  
}