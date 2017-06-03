import java.io.IOException;
import java.util.Iterator;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class JoinReducer extends Reducer<Text,Text, Text, Text>{

	
	String deptname="";
	String deptid="";
	
	@Override
	protected void setup(Reducer<Text, Text, Text, Text>.Context context) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		context.write(new Text("EMPID,EMPNAME,EMPSAL,DEPTID"), new Text("DEPTNAME"));
	}
	@Override
	protected void reduce(Text key, Iterable<Text> values, Reducer<Text, Text, Text, Text>.Context context)
			throws IOException, InterruptedException {
		
		//001_dept, deptname
		if(key.toString().contains("dept")){
			deptid=key.toString().split("_")[0];
			for(Text val:values){
				 deptname=val.toString();
				 
			}
		}
			
		//001_emp <emp1,emp2>
		if(key.toString().contains("emp")){
			
			String emp_deptid=key.toString().split("_")[0];
			
			if(!deptid.equalsIgnoreCase(emp_deptid)){
				deptname="Not-Found";
			}
			
			
			for(Text val:values){
				context.write(val, new Text(deptname));
			}
		}
	
	}
	
	
}
