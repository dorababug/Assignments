spark.sql("""select 
split(value,'::')[0] as mvid,
split(value,'::')[1] as mvname,
substring(split(value,'::')[1],length(split(value,'::')[1])-4 , 4) as year 
from movies_ip """).createOrReplaceTempView("movies");

spark.sql("""select 
split(value,'::')[0] as usrid,
split(value,'::')[1] as mvid,
split(value,'::')[2] as rating
from ratings_ip """).createOrReplaceTempView("ratings");

spark.sql("select mvid,round(avg(rating),2) as avgrating from ratings group by mvid").createOrReplaceTempView("avg_ratings");

spark.sql("""select m.mvid,m.mvname,r.avgrating
from movies m 
join avg_ratings r on m.mvid=r.mvid 
where m.year=2000 order by avgrating desc """).repartition(1).write.mode("overwrite").saveAsTable("hivepractice.mvTop200");
