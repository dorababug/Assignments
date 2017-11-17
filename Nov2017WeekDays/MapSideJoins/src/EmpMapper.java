import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.net.URI;
import java.util.HashMap;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class EmpMapper extends Mapper<LongWritable, Text, Text, Text>{
	
	
	HashMap<String, String> deptMap=new HashMap<String,String>();
	
	@Override
	protected void setup(Context context)
			throws IOException, InterruptedException {
		
	//the file will be copied to pwd where the Mapper or reducer runs
	URI[] paths=context.getCacheFiles();
	for (int i = 0; i < paths.length; i++) {
		System.out.println("---------added files are"+paths[i].toString());
		
	}
	
	File f=new File("dept");
	BufferedReader reader=new BufferedReader(new FileReader(f));
	try{	
		String line="";
		while((line=reader.readLine())!=null){
			//001,hadoop
			String deptId=line.split(",")[0];
			String deptName=line.split(",")[1];
			deptMap.put(deptId, deptName);
		}
	}finally{
		if(reader!=null){
			reader.close();
		}
	}
	
	
	}
	
	
	
	
	@Override
	protected void map(LongWritable key, Text value, Mapper<LongWritable, Text, Text, Text>.Context context)
			throws IOException, InterruptedException {
		//1,name,2000,001
		//Extract join key-> Dept ID
		String deptid=value.toString().split(",")[3];
		String deptName="";
		try{
			deptName=deptMap.get(deptid);
		}finally{
			deptName=(deptName==null)|| deptName=="" ? ""
					+ "not-found":deptName;
		}
		context.write(value, new Text(deptName));
	}

}
