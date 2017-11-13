import org.apache.spark.SparkContext
import org.apache.log4j._


object WordCount {
  def main(args: Array[String]): Unit = {
    Logger.getLogger("org").setLevel(Level.ERROR)
    val sc=new SparkContext()
   // sc.setLogLevel("ERROR")
    
   val input=sc.textFile(args(0))
   val res=input.flatMap(line=>line.split(" ")).
   map(word=>(word,1)).
   reduceByKey((v1,v2)=>v1+v2)
   res.foreach(println)
   
   
   import org.apache.hadoop.fs.FileSystem
   import org.apache.hadoop.conf.Configuration
   import org.apache.hadoop.fs.Path
   
   val hadoopConf=new Configuration
   val fs=FileSystem.get(hadoopConf);
   val path=new Path(args(1))
   if(fs.exists(path))
       fs.delete(path, true)
     
   res.saveAsTextFile(args(1))   
    
   
  }
  
}