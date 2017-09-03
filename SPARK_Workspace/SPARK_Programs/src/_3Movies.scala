import org.apache.log4j._
import org.apache.spark.sql._
import scala.util.matching.Regex
import scala.reflect.io.Path
import scala.util.Try


object _3Movies {
  def main(args: Array[String]): Unit = {
        Logger.getLogger("org").setLevel(Level.ERROR)
        
        //get new spark session to create DataFrame 
        //SparkSession is from spark SQL, lets download entire package
 var spark=SparkSession.builder.appName("Movies").master("local[*]").getOrCreate()
 
   //Load movies data set
   val moviesRDD=spark.sparkContext.textFile("/home/hadoop/Music/Classes/MovieLens-Work-SPARK/ml-1m/movies.dat")
   
   //SPARK CORE CODE
   //Q1: how many movies are there in the file
   println("Number of lines in the File",moviesRDD.count())
   //Check the same with wc movies.dat  // 3883  15672 163542 movies.dat

   //Q2: How many movies released each year
  /* **************************************
   
   def extractyear(x:String)={
          val moviename=x.split(":")(1)
          val year1=moviename.substring(moviename.indexOf("(")+1, moviename.indexOf(")"))
          (year1,1)        
        }
           
   val myear=moviesRDD.map(extractyear)
   myear.foreach(println)
   // The above will fail for 30:Shanghai Triad (Yao a yao yao dao waipo qiao) (1995):Drama
   
   ******************************* */
   
 /*  def extractname(x:String)={
          val moviename=x.split(":\\S")(1)
          println(moviename)
          val w1=x.split(":\\S")(0)
          println(w1)
          val lastchar=w1.substring(w1.length())
          println(lastchar)
          lastchar+moviename
        } */
   
   //val myear=moviesRDD.map(x=> x.split(":")(1)) doesnot work for 1739:3 Ninjas: High Noon On Mega Mountain (1998):Action|Children's
   //val myear=moviesRDD.map(x=> x.split(":\\S")(1))  // But first letter will get missed
   //val myear=moviesRDD.map(extractname)
   //myear.foreach(println)
  // println("1739:3 Ninjas: High Noon On Mega Mountain (1998):Action|Children's".split(":\\S")(1))
  // println("1739:3 Ninjas: High Noon On Mega Mountain (1998):Action|Children's".split(":\\S")(0))
   
   //////////////////////////////////////////////////////////////////////////////////////
   
   // Problem is some movies names have colon in their name.
   // for now We can collect them in separately  and handle separately
   // Separate the lines having colon more than 2 times.
   // for those having more than 2 colons , replace the second colon with some other letter
   //and combine the RDDs
   
   val moives_cleanedRDD=moviesRDD.filter { x => x.count(_ ==':')<3 }
   //moives_cleanedRDD.foreach {println }
   //moives_cleanedRDD.collect().foreach(println)
   
   
   def extractyear(x:String)={
          val moviename=x.split(":")(1)
          //val year1=moviename.substring(moviename.indexOf("(")+1, moviename.indexOf(")"))
          val pattern=new Regex("\\d{4}")
          val year1=pattern findFirstIn(moviename)
          val year2= year1 match {
            case Some(s) => s
            case None => "?"
           }
          (year2,1)        
        }
   
           
   val myear=moives_cleanedRDD.map(extractyear)
  // myear.foreach(println)
   /////////////////////////Below is the working logic
   // This gives errro that are having extra () in their name
   
  /*  val pattern=new Regex("\\d+")
    println((pattern findAllIn "Faraway, So Close (In Weiter Ferne, So Nah!) (1993)").mkString(","))
    println(pattern findFirstIn "Faraway, So Close (In Weiter Ferne, So Nah!) (1993)")
  */
   ////////////////////////////////
   println("Saving the result")
   val path: Path = Path ("/home/hadoop/yearcount")
    Try(path.deleteRecursively())
   myear.reduceByKey((x,y)=> x+y).repartition(1).sortBy(_._1).saveAsTextFile("/home/hadoop/yearcount")
   println("Saving Completed")

        
  }
}