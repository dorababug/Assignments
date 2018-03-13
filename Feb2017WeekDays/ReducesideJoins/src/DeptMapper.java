import java.io.IOException;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class DeptMapper extends Mapper<LongWritable, Text, Text, Text>{
	
	@Override
	protected void map(LongWritable key, Text value, Mapper<LongWritable, Text, Text, Text>.Context context)
			throws IOException, InterruptedException {
		String[] DeptRec=value.toString().split(",");
		String deptid=DeptRec[0]+"_dept";
		String deptName=DeptRec[1];
		//deptid_emp, dept name
		context.write(new Text(deptid), new Text(deptName));
		
	
	}

}
