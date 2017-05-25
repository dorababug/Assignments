import java.io.IOException;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.InputFormat;
import org.apache.hadoop.mapred.InputSplit;
import org.apache.hadoop.mapred.JobConf;
import org.apache.hadoop.mapred.RecordReader;
import org.apache.hadoop.mapred.Reporter;

public class CustomInputFormat implements InputFormat{

	@Override
	public RecordReader<Text, Text> getRecordReader(InputSplit arg0, JobConf arg1, Reporter arg2) throws IOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public InputSplit[] getSplits(JobConf arg0, int arg1) throws IOException {
		// TODO Auto-generated method stub
		return null;
	}

}
