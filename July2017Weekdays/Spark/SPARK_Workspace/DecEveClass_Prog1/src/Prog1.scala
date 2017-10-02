import org.apache.spark.SparkContext
import org.apache.log4j._
import org.apache.hadoop.security.UserGroupInformation.HadoopConfiguration
import org.apache.spark.SparkConf
import org.apache.spark.sql.SparkSession



object Prog1{
  def main(args: Array[String]): Unit = {
    
    Logger.getLogger("org").setLevel(Level.ERROR)
     
   /* for(str1 <- args){
      println("Arguement is=="+str1)
    }*/
    // Driver Cores (all cores), application name
    val conf=new SparkConf();
   // val sc=new SparkContext("local[*]","MovieLense")
    val sc=new SparkContext(conf)
    
        //UserID::MovieID::Rating::Timestamp
    val ratingsRDD=sc.textFile(args(0))
    val movies=ratingsRDD.map(line => (line.split("::")(1),1));
    movies.cache();
    val countRDD=movies.reduceByKey((x,y)=>x+y)
    //Movie,no of times present
    //Sort by no of times present
    val flipCountsRDD=countRDD.map(x => (x._2,x._1)).sortByKey(false,1)
    
    import org.apache.hadoop.fs._
    val fs = org.apache.hadoop.fs.FileSystem.get(new java.net.URI("hdfs://localhost:9000/"), sc.hadoopConfiguration)
    val opPath=new org.apache.hadoop.fs.Path(args(1))
   if (fs.exists(opPath)){
        fs.delete(opPath,true) // isRecusrive= true
    }
    
    //How do you add header
    val header = sc.parallelize(Array("count - movieID"))
      
    
    
    header.union(flipCountsRDD.map(x => x._1.toString()+" - "+x._2)).repartition(1).saveAsTextFile(args(1))
  
val warehouseLocation = "file:${system:user.dir}/spark-warehouse"
val spark = SparkSession
   .builder()
   .appName("SparkSessionZipsExample")
   .config("spark.sql.warehouse.dir", warehouseLocation)
   .enableHiveSupport()
   .getOrCreate()    
    
  
    
    
    
  }
}

