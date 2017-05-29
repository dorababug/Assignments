import java.io.IOException;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class EmpMapper extends Mapper<LongWritable, Text, Text, Text>{
	@Override
	protected void map(LongWritable key, Text value, Mapper<LongWritable, Text, Text, Text>.Context context)
			throws IOException, InterruptedException {
		
		String[] emprec=value.toString().split(",");
		String deptid=emprec[3]+"_emp";
		
		context.write(new Text(deptid), value);
		/*001_emp,  1,name,2000,001
		002_emp, 	2,name2,4000,002
		002_emp,    7,name7,4000,002
		*/
	}

}
