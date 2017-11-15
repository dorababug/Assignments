import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Partitioner;

public class AlphaPartitioner extends Partitioner<Text, IntWritable>{

	@Override
	public int getPartition(Text key, IntWritable value, int noOfReducers) {
 System.out.println("********* INside Partitioner");
		//Aa-Mm -> part-r-0
		//Nn-zZ -> part-r-1
		//Rest -> part-r-2
		//Extract first letter from Key
		char ch=key.toString().toLowerCase().charAt(0);
		if(ch>=97 && ch<=109){
			return 0%noOfReducers;
		}else if(ch>=110 && ch<=122){
			return 1%noOfReducers;
		}else{
			return 2%noOfReducers;
		}
	
	}

}
