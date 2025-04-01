/*File Processing with Try-with-Resources & Custom Exception
Problem Statement:
Write a program that reads data from a file and processes it. The file contains integers, and the program should calculate the sum of these numbers. Implement exception handling for the following:
•	FileNotFoundException (if the file does not exist).
•	NumberFormatException (if a line in the file contains non-numeric data).
•	Create a custom exception (EmptyFileException) that is thrown if the file is empty.
•	Use Try-with-Resources to ensure proper resource management.*/
import java.util.*;
import java.io.*;

class EmptyFileException extends Exception {
	public EmptyFileException(String msg) {
		super(msg);
	}
}

public class Main {
	public static void main(String[] args) throws IOException {
	  Scanner sc = new Scanner(System.in);
	    try{
	        System.out.println("Enter file Path: ");
	        String filePath = sc.nextLine();
	        
	        int sum = calculateSum(filePath);
	        System.out.println("Sum of numbers in the file: " + sum);
	    } catch(FileNotFoundException e){
	        System.err.println("Error: File Not Found. Please Check the Path.");
	    } catch(NumberFormatException e){
	        System.err.println("Error: Invalid data format. File contains non-integer values.");
	    } catch(EmptyFileException e){
	        System.err.println("Error: An I/O error occured while reading the file.");
	    } finally{
	        sc.close();
	    }
	}
	
	public static int calculateSum(String filePath) throws IOException, EmptyFileException{
	    int sum = 0;
	    boolean isEmpty = true;
	    
	    try(BufferedReader reader = new BufferedReader(new FileReader(filePath))){
	        String line;
	        while((line = reader.readLine()) != null){
	            line = line.trim();
	            
	            if(!line.isEmpty()){
	                isEmpty = false;
	                sum += Integer.parseInt(line);
	            }
	        }
	    }
	    
	    if(isEmpty){
	        throw new EmptyFileException("File is Empty. cannot calculate the sum.");
	    }
	    
	    return sum;
	}
}
/*numbers.txt  10 20 30 40*/
