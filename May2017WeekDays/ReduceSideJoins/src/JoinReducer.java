import java.io.IOException;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class JoinReducer extends Reducer<Text, Text, Text, Text>{
	
	
	String deptname="";
	String deptid="";
	
	@Override
	protected void setup(Reducer<Text, Text, Text, Text>.Context context) throws IOException, InterruptedException {
		context.write(new Text("EmpId,EmpName,EmpSal,EmpDept"), new Text("DeptName"));
	}
	@Override
	protected void reduce(Text key, Iterable<Text> values, Reducer<Text, Text, Text, Text>.Context context)
			throws IOException, InterruptedException {
		
		// 002_dept, hive
		// 002_emp, emp2,emp7
		
		if(key.toString().contains("dept")){
			for (Text val : values) {
				deptname=val.toString();
				deptid=key.toString().split("_")[0];
			}			
		}
		if(key.toString().contains("emp")){
			String emp_deptid=key.toString().split("_")[0];

			for (Text val : values) {
				
				deptname=(emp_deptid.equalsIgnoreCase(deptid))?deptname:"NotFound";
				
				
				context.write(val, new Text(deptname));				
			}			
		}
	
	
	
	}

}
