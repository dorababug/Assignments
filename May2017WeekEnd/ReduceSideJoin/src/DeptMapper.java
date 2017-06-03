import java.io.IOException;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class DeptMapper extends Mapper<LongWritable, Text, Text, Text>{

	@Override
	protected void map(LongWritable key, Text value, Mapper<LongWritable, Text, Text, Text>.Context context)
			throws IOException, InterruptedException {
		//001,hadoop
		String[] dept=value.toString().split(",");
		String deptid=dept[0]+"_dept";
		// 001_dept, deptname
	
		context.write(new Text(deptid), new Text(dept[1]));
	
	
	}
	
	
}
