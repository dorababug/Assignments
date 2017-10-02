import java.sql.{Connection,DriverManager}

object ScalaJDBC {
  def main(args: Array[String]): Unit = {
   //Import Mysql COnnector
  //import java.sql.{Connection,DriverManager}
  val url="jdbc:mysql://localhost:3306/mysql"
  val driver="com.mysql.jdbc.Driver"
  val username="root"
  val password="root"
  var connection:Connection= null
  
  try{
      Class.forName(driver)
      connection=DriverManager.getConnection(url,username,password)
      val statement=connection.createStatement()
      val rs=statement.executeQuery("select host,user,password from mysql.user")
      while(rs.next) {
        val host=rs.getString("host")
        val user=rs.getString("user")
        println("host= %s, user= %s".format(host,user))
       }
    } catch{
      case e:Exception => e.printStackTrace
    }
    connection.close
  }
  
}