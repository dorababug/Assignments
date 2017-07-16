import java.io.IOException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.conf.Configured;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.compress.GzipCodec;
import org.apache.hadoop.io.compress.SnappyCodec;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.util.Tool;
import org.apache.hadoop.util.ToolRunner;

public class WordCountDriver extends Configured implements Tool {

	@Override
	public int run(String[] arg0) throws Exception {
		
		for (int i = 0; i < arg0.length; i++) {
			System.out.println("Argument in RUN METHOD--"+i+"   is::::"+arg0[i]);
		}
		
		
//		Configuration conf=new Configuration();
		
		Configuration conf=this.getConf();
		conf.set("mapreduce.job.name", "GREP Conf Example");
		
		conf.set("mapreduce.output.fileoutputformat.compress", "true");
		//conf.set("mapreduce.ouput.fileouputformat.compress.codec", "org.apache.hadoop.io.compress.SnappyCodec");
		
		conf.set("mapreduce.map.output.compress", "true");
		
		Job job=Job.getInstance(conf);
		
		
		job.setJarByClass(WordCountDriver.class);
		job.setMapperClass(WordCountMapper.class);
		//job.setReducerClass(WordCountReducer.class);
		Path outFile=new Path(arg0[1]);
		
		FileSystem fs=FileSystem.get(conf);
		if(fs.exists(outFile)){
			fs.delete(outFile, true);
		}
		
		job.setOutputKeyClass(Text.class);
		job.setOutputValueClass(NullWritable.class);
		
		FileInputFormat.addInputPath(job, new Path(arg0[0]));
		FileInputFormat.setInputDirRecursive(job, true);
		FileOutputFormat.setOutputPath(job, new Path(arg0[1]));
		
		//FileOutputFormat.setCompressOutput(job, true);
		//FileOutputFormat.setOutputCompressorClass(job, SnappyCodec.class);
		
		boolean status=job.waitForCompletion(true);
		return status?0:1;
		
		
		
	}

	

	
	public static void main(String[] args) throws Exception {
		
		
		for (int i = 0; i < args.length; i++) {
			System.out.println("Argument in MAIN--"+i+"   is::::"+args[i]);
		}
		int result=ToolRunner.run(new WordCountDriver(), args);
		System.exit(result);
	
	}
		
		
	
}






