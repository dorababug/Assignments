import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Partitioner;

public class AlphaPartitioner extends Partitioner<Text, IntWritable>{

	@Override
	public int getPartition(Text key, IntWritable value, int noOfReducers) {
		
		
		System.out.println("++++++++++++++++++I am inside Partitioner");
		//A-M or a-m should go to part-r-0
		//n-z or N-Z go to part-r-1
		//others part-r-2
		
		char ch = key.toString().toLowerCase().charAt(0);
		if((ch >=97 && ch<=109) ){
			return 0%noOfReducers;
		}else if(ch >=110 && ch<=122){
			return 1%noOfReducers;
		}else
			return 2%noOfReducers;
		
		
		
		
		
		
		
		
	}

}
