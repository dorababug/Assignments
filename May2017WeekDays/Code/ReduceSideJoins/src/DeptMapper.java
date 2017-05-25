import java.io.IOException;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class DeptMapper extends Mapper<LongWritable, Text, Text, Text>{
	@Override
	protected void map(LongWritable key, Text value, Mapper<LongWritable, Text, Text, Text>.Context context)
			throws IOException, InterruptedException {
		
		//001,hadoop
		
		String[] deptrec=value.toString().split(",");
		String deptId=deptrec[0];
		
		context.write(new Text(deptId+"_dept"), new Text(deptrec[1]));
		
	}

}
