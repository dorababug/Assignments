import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Partitioner;

public class MyPart extends Partitioner<Text, IntWritable>{

	@Override
	public int getPartition(Text key, IntWritable value, int noOfreducers) {
		
		//return key.hashCode()%no of reducers;
		
		char ch=key.toString().toLowerCase().charAt(0);
		if(ch>=97 && ch<=122){
			return ch-96;
		}else
			return 0;
		
	}

	
	
	
}
