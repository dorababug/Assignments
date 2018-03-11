import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class Q1Reducer extends Reducer<IntWritable, Text, Text, Text>{
	int i=0;
	int minTemp;
	String minTempYears="";
	String maxTempYears="";
	int maxTemp;
	@Override
	protected void reduce(IntWritable key, Iterable<Text> values, Context context)
			throws IOException, InterruptedException {
		if(i==0){
			i=1;
			minTemp=key.get();
			for (Text val:values) {
				minTempYears=minTempYears+val.toString()+",";
			}
		}
		maxTempYears="";
		maxTemp=key.get();
		for (Text val:values) {
			maxTempYears=maxTempYears+val.toString()+",";
		}
	}

	@Override
	protected void cleanup(Reducer<IntWritable, Text, Text, Text>.Context context)
			throws IOException, InterruptedException {
		context.write(new Text("minTemp"), new Text(minTemp+"\t"+minTempYears));
		context.write(new Text("maxTemp"), new Text(maxTemp+"\t"+maxTempYears));
	
	}
}
