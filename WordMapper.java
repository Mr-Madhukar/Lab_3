import java.io.IOException;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Reducer.Context;
public class WordMapper extends Mapper<LongWritable, Text , Text, IntWritable>{
@Override
public void map(LongWritable key , Text value , Context context )
throws IOException, InterruptedException {
String line= value.toString();
for (String word : line.split(" ")){
if (word.length() > 0) {
//context.write(new Text("total"), new IntWritable(1));
context.write(new Text(word), new IntWritable(1)); //intermediate output
}
}
}
}