import java.io.IOException;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.mapreduce.Job;
public class WordCount {
public static void main(String[] args) throws IOException
{
if (args.length != 2) {
System.out.printf(
"Usage: WordCount <input dir> <output dir>\n");
System.exit(-1);
}
@SuppressWarnings("deprecation")
Job job = new Job();
job.setJarByClass(WordCount.class); //entry point
job.setJobName("Word Count");
FileInputFormat.setInputPaths(job,new Path(args[0]));
FileOutputFormat.setOutputPath(job,new Path(args[1]));
job.setMapperClass(WordMapper.class);
job.setReducerClass(WordReducer.class);
job.setOutputKeyClass(Text.class);
job.setOutputValueClass(IntWritable.class);
boolean success =false;
try {
success = job.waitForCompletion(true); //start job
} catch (ClassNotFoundException e) {
// TODO Auto-generated catch block
e.printStackTrace();
} catch (InterruptedException e) {
// TODO Auto-generated catch block
e.printStackTrace();
}
System.exit(success ? 0:1);
}
}