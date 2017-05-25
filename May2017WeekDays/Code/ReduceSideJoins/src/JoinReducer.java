import java.io.IOException;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class JoinReducer extends Reducer<Text, Text, Text, Text>{
	String deptName="";
	String deptID="";
	

	@Override
	protected void setup(Reducer<Text, Text, Text, Text>.Context context) throws IOException, InterruptedException {
		context.write(new Text("EmpID,EmpName,EmpSal,EmpDeptID"), new Text("DeptName"));
	}
	
	@Override
	protected void reduce(Text key, Iterable<Text> values, Reducer<Text, Text, Text, Text>.Context context)
			throws IOException, InterruptedException {
		
		
		//Dept Name 
		if(key.toString().contains("_dept")){
			
			//003_dept,  pig
			deptID=key.toString().split("_")[0];
			
			for (Text val : values) {
				deptName=val.toString();
			}
		}
		
		//Emp Rec
		if(key.toString().contains("_emp")){
			
			
			for (Text val : values) {
				if(key.toString().contains(deptID)){
					context.write(val, new Text(deptName));
				}
				else{
					context.write(val, new Text("NotFound"));
				}
			}
			
			
			
			
			
			
		}
		
		
		
		
	}

}
