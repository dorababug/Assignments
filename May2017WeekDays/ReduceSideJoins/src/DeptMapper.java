import java.io.IOException;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class DeptMapper extends Mapper<LongWritable, Text, Text, Text>{
	@Override
	protected void map(LongWritable key, Text value, Mapper<LongWritable, Text, Text, Text>.Context context)
			throws IOException, InterruptedException {
		
		String[] deptrec=value.toString().split(",");
		String deptid=deptrec[0]+"_dept";
		String deptname=deptrec[1];
		
		context.write(new Text(deptid), new Text(deptname));
		/*001_dept,    hadoop
		002_dept, 	   hive
		
		*/
	}

}
