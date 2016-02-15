package com.mapreduce;

import java.io.IOException;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class IrisMapperMean  extends Mapper <LongWritable,Text,Text,Text> {
   public void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
		
			
		
      // TODO create array of string tokens from record assuming space-separated fields using split() method of String class
		String data[] = value.toString().split("\\s+");
      
     
      // TODO pull out petal length from columns var
		String petal_length = data[2];
		
     // TODO pull out flower id from columns var
		String flowerId = data[4];
		
      // TODO write output to context as key-value pair where key is 
      // flowerId and value is petal length
	  
		context.write(new Text(flowerId), new Text(petal_length));
   }
}
