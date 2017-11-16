import java.io.IOException;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class JoinReducer extends Reducer<Text, Text, Text, Text>{
	
	String deptName="";
	String dept_deptId="";
	
	@Override
	protected void reduce(Text key, Iterable<Text> values, Reducer<Text, Text, Text, Text>.Context context)
			throws IOException, InterruptedException {
		//002_dept,<hive>
		if(key.toString().split("_")[1].equals("dept")){
			for (Text val : values) {
				deptName=val.toString();
				dept_deptId=key.toString().split("_")[0];
			}
			
		}
		//002_emp ,<emp2,emp7>
		if(key.toString().split("_")[1].equals("emp")){
			//take one emp rec
			
			//String emp_deptID=key.toString().split("_")[0];
			
			//004_emp ,<emp6,emp5>
			for (Text val : values) {
				if(key.toString().contains(dept_deptId))
				{
					context.write(val, new Text(deptName));
				}else{
					context.write(val, new Text("not-found"));
				}
			}
			
		}
		
	}

}
