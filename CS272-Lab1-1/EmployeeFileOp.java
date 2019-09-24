// August 30, 2019
// CS272 - Lab 1
// Tiare Arreola Contreras
// Purpose: to extract data from a csv file and write data to another csv file

// imported libraries

import java.io.*;
import java.util.Scanner;

// EmployeeFileOp

public class EmployeeFileOp {
	
	// data arrays to hold info
	
	static String Name[] = new String[304];
	static String Number[] = new String[304];
	static String State[] = new String[304];
	static String Zip[] = new String[304];
	static String Age[] = new String[304];
	static String Sex[] = new String[304];
	
	// main function calling read() & write()

	public static void main(String[] args) {
		read();
		write();
	}
	
	// read function

	public static void read(){
		
		// file to read from using scanner

		File dataSet = new File ("core_dataset.csv");
		
		try{
			
			Scanner dataScan = new Scanner(dataSet);
			
			int linenum = 0;
			
			// read from file while there is next line
			
			while(dataScan.hasNextLine()) {
				
				// index from comma to comma
				
				int startIndex;
				int endIndex;
				
				// variable to hold line string and initializing index
				
				String line = dataScan.nextLine();
				startIndex = line.indexOf(",");
				
				// beginning to extract name
				
				if(linenum == 0) {
					Name[linenum] = line.substring(0, startIndex + 1);
				}
				else {
					startIndex = line.indexOf(",", startIndex + 1);
					Name[linenum] = line.substring(0, startIndex + 1);
				}
				
				// number extraction
				
				endIndex = line.indexOf(",", startIndex + 1);
				Number[linenum] = line.substring(startIndex + 1, endIndex);
				
				// state extraction
				
				startIndex = endIndex;
				endIndex = line.indexOf(",", startIndex + 1);
				State[linenum] = line.substring(startIndex, endIndex);

				// zip extraction
				
				startIndex = endIndex;
				endIndex = line.indexOf(",", startIndex + 1);
				Zip[linenum] = line.substring(startIndex, endIndex);
				
				// date of birth skipping
				
				startIndex = endIndex;
				endIndex = line.indexOf(",", startIndex + 1);

				// age extraction
				
				startIndex = endIndex;
				endIndex = line.indexOf(",", startIndex + 1);
				Age[linenum] = line.substring(startIndex, endIndex);
				
				// sex extraction
				
				startIndex = endIndex;
				endIndex = line.indexOf(",", startIndex + 1);
				Sex[linenum] = line.substring(startIndex, endIndex);
				
				// index for data arrays
				
				linenum = linenum + 1;
				
			}//while
			
			dataScan.close();
			
		}//try
		catch(FileNotFoundException e) {
			e.printStackTrace();
		}//catch
		
	}//read
	
	// write function
	
	public static void write(){
		
		// array to store age in int type

		int ageNum[] = new int[304];
		
		// string to hold only the age without the comma
		
		String ageString;
	
		try{
			// using file writer to write
			
			FileWriter young = new FileWriter(new File("young_employee.csv"));
			
			// for loop to store age as an int
			
			for(int i = 1; i < 302; i++) {
				
				StringBuilder age = new StringBuilder(Age[i]);
				age.deleteCharAt(0);
				ageString = age.toString();
				
				ageNum[i] = Integer.parseInt(ageString);
				
			}// for
			
			// printing row 0 for header
			
			young.write(Name[0]); 
			young.write(Number[0]);
			young.write(State[0]);
			young.write(Zip[0]);
			young.write(Age[0]);
			young.write(Sex[0]);
			young.write("\n");
			
			// for loop to search for specific age and write to file
			
			for(int i = 1; i < 302; i++) {
				
				if(ageNum[i] <= 30) {
					
					young.write(Name[i]); 
					young.write(Number[i]);
					young.write(State[i]);
					young.write(Zip[i]);
					young.write(Age[i]);
					young.write(Sex[i]);
					young.write("\n");
					
				}// if
			}//for
			
			// closing writer and flushing data
			
			young.close();

		}//try
		catch (IOException e) {
			e.printStackTrace();
		}//catch

	}// write
	
}// EmployeeFileOp
