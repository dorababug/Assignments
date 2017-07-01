import java.io.IOException;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class JoinReducer extends Reducer<Text, Text, Text, Text>{
	
	String deptname="";
	String deptid="";
	@Override
	protected void setup(Reducer<Text, Text, Text, Text>.Context context) throws IOException, InterruptedException {
		context.write(new Text("Empid,EmpName,EmpSal,DeptId"), new Text("DeptName"));
	}
	@Override
	protected void reduce(Text key, Iterable<Text> values, Reducer<Text, Text, Text, Text>.Context context)
			throws IOException, InterruptedException {
		// 001_dept , hadoop
		
		if( key.toString().contains("dept")){
			for (Text val : values) {
				deptname=val.toString();
				deptid=key.toString().split("_")[0];
			}
		}
		// 001_emp, < e1,e4,e5>
		//take each emp, append dept name and send out
		if( key.toString().contains("emp")){
			
			for (Text val : values) {
				String emp_deptid=val.toString().split(",")[3];
				if(!emp_deptid.equalsIgnoreCase(deptid)){
					deptname="not-found";
				}
				
				context.write(val, new Text(deptname));
			}
		}
		//
		
		
	}

}
