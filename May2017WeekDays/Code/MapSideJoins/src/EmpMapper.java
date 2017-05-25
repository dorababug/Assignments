import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URI;
import java.util.HashMap;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class EmpMapper extends Mapper<LongWritable, Text, Text, Text>{
	
	private static HashMap<String,String> DeptMap=new HashMap<String,String>();
	
	
	@Override
	protected void setup(Mapper<LongWritable, Text, Text, Text>.Context context)
			throws IOException, InterruptedException {
		
		URI[] uri=context.getCacheFiles();
		for (int i = 0; i < uri.length; i++) {
			System.out.println("Addedfiles are:::"+uri[i].toString());
		}
		
		
		File file=new File("dept");
		BufferedReader reader=new BufferedReader(new FileReader(file));
		String lineString="";
		try{
			while((lineString = reader.readLine())!=null){
				String deptTable[]=lineString.split(",");
				
				// put it into hash Map
				DeptMap.put(deptTable[0].trim(), deptTable[1].trim());
				
			}
			} finally{
				if(reader!=null){
					reader.close();
				}
			}
		
	}
	
	@Override
	protected void map(LongWritable key, Text value, Mapper<LongWritable, Text, Text, Text>.Context context)
			throws IOException, InterruptedException {
		
		//1,name,2000,001
		
		String[] emprec=value.toString().split(",");
		String deptId=emprec[3];
		String deptName="";
		try{
			deptName=DeptMap.get(deptId);
			}finally{
				deptName= deptName==null? "Not-Found" : deptName ;
			}
		
		
		context.write(value,new Text(deptName));
		
	}

}
