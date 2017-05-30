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
	
	
	HashMap<String, String> dept_map=new HashMap<String,String>();
	
	
	@Override
	protected void setup(Mapper<LongWritable, Text, Text, Text>.Context context)
			throws IOException, InterruptedException {
		
		URI[] files=context.getCacheFiles();
		for (int i = 0; i < files.length; i++) {
			System.out.println("FIles added are "+files[i].toString());
		}
		
		File file=new File("dept");
		
		BufferedReader reader=new BufferedReader(new FileReader(file));
		
		try {
			
			String line="";
			
			while((line=reader.readLine())!=null){
				String deptid=line.split(",")[0];
				String deptname=line.split(",")[1];
				dept_map.put(deptid.trim(), deptname.trim());
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
		
		String[] emprec=value.toString().split(",");
		String deptid=emprec[3];
		String deptname="";
		try{
			 deptname=dept_map.get(deptid.trim());

		}finally{
			deptname=(deptname==null||deptname.equals(""))?"not-found":deptname;
		}
		
		context.write(value, new Text(deptname));
		/*001_emp,  1,name,2000,001
		002_emp, 	2,name2,4000,002
		002_emp,    7,name7,4000,002
		*/
	}

}
