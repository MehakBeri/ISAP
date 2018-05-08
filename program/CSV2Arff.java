import weka.core.Instances;
import java.util.*;
import weka.core.converters.ArffSaver;
import weka.core.converters.CSVLoader;
 
import java.io.File;
 
public class CSV2Arff {
  /**
   * takes 2 arguments:
   * - CSV input file
   * - ARFF output file
   */
  public static void main(String[] args) throws Exception {
	  
	Scanner sc=new Scanner(System.in);  
	System.out.print("Enter your file name to convert : ");  
	String f=sc.next(); 
	
	String writeFrom = "G:\\MS\\spring 18\\ml\\mainProject\\suicides-in-india\\"+f+".csv";
	String writeTo=f+".arff";
	
//    if (args.length != 2) {
//      System.out.println("\nUsage: CSV2Arff <input.csv> <output.arff>\n");
//      System.exit(1);
//    }
 
    // load CSV
    CSVLoader loader = new CSVLoader();
    loader.setSource(new File(writeFrom));
    Instances data = loader.getDataSet();
 
    // save ARFF
    ArffSaver saver = new ArffSaver();
    saver.setInstances(data);
    saver.setFile(new File(writeTo));
//    saver.setDestination(new File(writeTo));
    saver.writeBatch();
    System.out.println("arff file written!");
  }
}