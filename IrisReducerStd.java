package com.mapreduce;

import java.io.IOException;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;


public class IrisReducerStd  extends Reducer <Text,Text,Text,Text> {
  
   float meanPetalLength;	
   float std_numerator;
   float std;
   String petalString[] = null;

   public void reduce(Text key, Iterable<Text> values, Context context) throws IOException, InterruptedException {

	   
       meanPetalLength = 0;
       std_numerator = 0;
       
       float sum = 0;

      for(Text value: values) {
         // TODO use String split() method to split value and assign to tempString
			petalString = value.toString().split("_"); 
			
         	meanPetalLength = Float.parseFloat(petalString[petalString.length - 1]);
		
			for(int i = 0; i< petalString.length - 1 ; i++){
				
				std_numerator = (float)Math.pow((Float.parseFloat(petalString[i]) - meanPetalLength),2);
				sum += std_numerator;
			}
		 
      } 
     
      // TODO calculate Standard deviation of petal length 
      	std = (float)Math.sqrt(sum/(petalString.length - 1));
      // TODO generate string output 
		String output = Float.toString(std);
      // TODO emit output to context
        context.write(key, new Text(output));


   }
}   
