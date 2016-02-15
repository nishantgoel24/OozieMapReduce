package com.mapreduce;

import java.io.IOException;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class IrisMapperStd  extends Mapper <LongWritable,Text,Text,Text> {
   public void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
   
		
	      // TODO create array of string tokens from record assuming space-separated fields using split() method of String class
			String dataArray[] = value.toString().split("\\s+");
	      
	     
		 // TODO pull out flower id from columns var
			String flowerId = dataArray[0];
		
		// TODO pull out petal length from columns var
			String values = dataArray[1];
			
	    // TODO write output to context as key-value pair where key is 
	    // flowerId and value is petal length
		  
			context.write(new Text(flowerId), new Text(values));
	   
	   
   }
}