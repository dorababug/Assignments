 
import org.apache.commons.lang.StringUtils;
import org.apache.hadoop.hive.ql.exec.UDF;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.hive.ql.exec.Description;
import org.apache.hadoop.hive.ql.udf.UDFType;

@Description(
	name = "Salute_add", 
	value = "_FUNC_(gender, name) - Adds salutation", 
	extended = "This function will return salutation and name"
)
@UDFType(deterministic = true, stateful = false)
public class Salute_add extends UDF {
   public Text evaluate(String str) {
      return str == null ? null : new Text("Mr. "+str);
   }
   public Text evaluate(String gender,String name) {
	   
	   if(gender.equalsIgnoreCase("male")){
			String str=	"Mr. " + name;
			return name == null ? null : new Text(str);
	   }else
		   return name == null ? null : new Text("Mrs. "+ name);
	   
      //return name == null ? null : new Text(str);
   }
   /*public static void main(String[] args) {
	   Salute_add obj=new Salute_add();
	  System.out.println("++++"+obj.evaluate("Inventateq"));
	  System.out.println("++++"+obj.evaluate("female","Inventateq"));
}*/
}