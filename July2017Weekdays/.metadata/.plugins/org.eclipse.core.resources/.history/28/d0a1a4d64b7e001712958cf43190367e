import java.io.IOException;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class Q1Mapper extends Mapper<LongWritable, Text, Text, Text>{
		@Override
		protected void map(LongWritable key, Text value, Context context)
				throws IOException, InterruptedException {
			//value?? 1979,23,23,2,43,24,25,26,26,26,26,25,26,25
			/// Identify elements from line
			// elements are delimted by comma
			//convert Hadoop types into java types :: Text.toString, IntWritable.get()
			String vals[]=value.toString().split(",");
			String year=vals[0];
			
			int max=-9999;
			int min=9999;
			
			//Jan to Dec 23,23,2,43,24,25,26,26,26,26,25,26, leave the last avg field
			for(int i=1;i<vals.length-1;i++){
				
				int c=Integer.parseInt(vals[i]);
				
				//min value
				if(min>c){
					min=c;   //23-> 2 yes					
				}
				if(max<c){
					max=c;
				}				
				
			}
			
			context.write(new Text(year), new Text(min+"\t"+max));
			
		
		}

}
