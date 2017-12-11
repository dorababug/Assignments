package com.inv;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URI;
import java.util.HashMap;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class EmpMapper extends Mapper<LongWritable, Text, Text, Text> {
	HashMap<String, String> deptMap = new HashMap<String, String>();

	@Override
	protected void setup(Mapper<LongWritable, Text, Text, Text>.Context context)
			throws IOException, InterruptedException {
		URI[] files = context.getCacheFiles();
		for (int i = 0; i < files.length; i++) {
			System.out.println("*** FIles added are" + files[i].toString());
		}

		File f = new File("dept");
		String line = "";
		BufferedReader reader = new BufferedReader(new FileReader(f));
		try {
			while ((line = reader.readLine()) != null) {
				String deptid = line.split(",")[0];
				String deptname = line.split(",")[1];
				deptMap.put(deptid, deptname);
			}
		} finally {
			if (reader != null) {
				reader.close();
			}
		}

	}

	@Override
	protected void map(LongWritable key, Text value, Mapper<LongWritable, Text, Text, Text>.Context context)
			throws IOException, InterruptedException {
		// 1,name,2000,001
		String deptid = value.toString().split(",")[3];
		String deptname = " ";
		try {
			deptname = deptMap.get(deptid);
		} finally {
			deptname = (deptname == null) ? "Not-Found" : deptname;

		}

		// value contains emp rec
		context.write(value, new Text(deptname));

	}

}
