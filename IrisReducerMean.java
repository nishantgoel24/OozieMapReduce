package com.mapreduce;

import java.io.IOException;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;


public class IrisReducerMean  extends Reducer <Text,Text,Text,Text> {
  
   float tempPetalLength;
   float totalPetalLength;
   float meanPetalLength;	
   StringBuffer sb = null;

   public void reduce(Text key, Iterable<Text> values, Context context) throws IOException, InterruptedException {

     
	   
       tempPetalLength = 0;
       totalPetalLength = 0;
       meanPetalLength = 0;
       sb = new StringBuffer();
       float count = 0;

      for(Text value: values) {
         // TODO use String split() method to split value and assign to tempString
			String petalString = value.toString(); 
			
         // TODO convert tempString elements to petal length vars
			tempPetalLength = Float.parseFloat(petalString);
			
			sb.append(tempPetalLength);
			sb.append("_");
         // TODO calculate running totals for petal length for use in calculation of means
			
			totalPetalLength += tempPetalLength;
			
         // TODO increment counter for use in calculation of means
			count += 1.0;
      } 
     
      // TODO calculate mean petal length 
			meanPetalLength = totalPetalLength/count;
			sb.append(meanPetalLength);
      // TODO generate string output 
		   String output = sb.toString();

      // TODO emit output to context
      context.write(key, new Text(output));

   }
}
