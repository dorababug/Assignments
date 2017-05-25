import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Partitioner;

public class AlphaPartitioner extends Partitioner<Text, IntWritable>{

	@Override
	public int getPartition(Text key, IntWritable value, int noOfReducers) {
		
		System.out.println("+++++ Inside Partitioner::"+key.toString());
		char ch=key.toString().toLowerCase().charAt(0);
		//A,a to Mm
		if(ch>=97 && ch<=109){
			return 0;
		}else if(ch>=110 && ch<=122){
			return 1;
		}else {
			return 2;
		}
	
	
	}

	
	
}
