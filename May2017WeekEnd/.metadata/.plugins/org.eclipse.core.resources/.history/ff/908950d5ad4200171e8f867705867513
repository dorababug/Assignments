import java.io.IOException;

import org.apache.commons.math3.analysis.function.Floor;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class EReducer extends Reducer<IntWritable, Text, Text,Text>{

	@Override
	protected void setup(Context context)
			throws IOException, InterruptedException {
		context.write(new Text("YEAR"), new Text("AvgFile\tAvgCalc"));
	}
	
	@Override
	protected void reduce(IntWritable key, Iterable<Text> values, Context context)
			throws IOException, InterruptedException {
		//Q1 -> Year\tMinConsumption\tMaxConsumption
		
		int minYear=9999;
		int maxYear=-9999;
		
		int totalYear=0;
		int i=0;
		int avgf=0;
		//1979,23,23,2,43,24,25,26,26,26,26,25,26,25
		//year, <23-month ... 25-avg>
		
		for(Text val:values){
		 if(val.toString().contains("month")){	
			int mConsumption=Integer.parseInt(val.toString().split("-")[0]);
			
			i=i+1;
			totalYear=totalYear+mConsumption;
				
		 }
		 if(val.toString().contains("avg")){
			 avgf=Integer.parseInt(val.toString().split("-")[0]);
		 }
			
		}
		
		double avgC=(totalYear/i);
		
		context.write(new Text(key.toString()), new Text(avgf+"\t"+avgC));
		
		
		
		
	}
	
	
	
}
