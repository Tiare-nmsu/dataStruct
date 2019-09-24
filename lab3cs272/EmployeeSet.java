// Tiare Arreola Contreras
// September 15, 2019
// CS 272
// lab3

import java.util.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class EmployeeSet {

//      1 INSTANCE VARIABLES

        private Employee[] set;
        private int totalEmployed;

//      2 DEFAULT CONSTRUCTOR

        public EmployeeSet() {
        	
                final int INITIAL_CAPACITY = 10;
                totalEmployed = 0;
                set = new Employee[INITIAL_CAPACITY];
                
        }// default constructor
        
//      3 COPY CONSTRUCTOR

        public EmployeeSet(Object obj) {
        	
        		// making a new collection of the same size

                int size = ((EmployeeSet)obj).capacity();
                set = new Employee[size];
                
                // temporary employee obj to store data
                
                Employee copy;
                
                // going through array and filling it with copies

                for(int i = 0; i < capacity(); i++) {
                        copy = ((EmployeeSet)obj).set[i];
                        set[i] = copy;
                }// for
                
        }// copy constructor

//      4 SIZE: total elements

        public int size() {
        	
        		// going through array and counting initialized elements

                totalEmployed = 0;

                for(int i = 0; i < capacity(); i++) {
                        if(set[i] != null)
                                totalEmployed++;
                }// for

                return totalEmployed;
        }// size

//      5 CAPACITY: how many elements can be held

        public int capacity() {
                return set.length;
        }// capacity

//      6 ADD

        public void add(Employee a) {
        			
        		// checking for space and adding new element
        		
        		if(size() == capacity()) {
        			ensureCapacity((capacity() * 2));
        			set[size()] = new Employee(a);
        		}// if
        		else
        			set[size()] = new Employee(a);

        }// add

//      7 SEARCH

        public boolean contains(Employee a) {
        		
        		// going through array and checking for equal element
        		
        		for(int i = 0; i < size(); i++) {
        			if(set[i].equals(a) && set[i] != null)
        				return true;
        		}// for
        		
        		// element not found
        		
        		return false;
        
        }// contains

//      8 Remove

        public boolean remove(int eno) {
        	
        		// going through array and removing element
        	
        		for(int i = 0; i < size(); i++) {
        			
        			if(set[i].getNo() == eno && set[i] != null) {
        				set[i] = set[size() - 1];
    					set[size() - 1] = null;
        				return true;
        			}// if
        			
        		}// for
        		
        		// element not in array
        		
        		return false;

        }// remove

//      9 ENSURE CAPACITY

        private void ensureCapacity(int minimumCapacity) {
        	
        		// increasing capacity by copying to new array
  
                if(capacity() < minimumCapacity) {
                        Employee[] biggerArray;

                        biggerArray = new Employee[minimumCapacity];
                        System.arraycopy(set, 0, biggerArray, 0, size());
                        set = biggerArray;
                }// if

        }// ensureCapacity


//      10 addOrdered

        public void addOrdered(Employee a) {
        	
        		// ensuring capacity
        	
        		if(size() == capacity()) {
        			ensureCapacity((capacity() * 2));
        		}// if
        		
        		// if new element should be last
        		
        		if(a.getNo() > set[size() - 1].getNo()) {
        			set[size()] = new Employee(a);
        			return;
        		}// if
        		
        		// if new element should be first
        		
        		if(a.getNo() < set[0].getNo()) {
        			for(int i = (size()-1); i >= 0; i--) {
        				set[i+1] = new Employee(set[i]);
        			}// for
        			set[0] = new Employee(a);
        			return;
        		}// if
        		
        		// if new element is in between other elements
        		
        		for(int i = 1; i < size(); i++) {
        			if(set[i - 1].getNo() < a.getNo() && a.getNo() < set[i].getNo()) {
        				for(int j = (size()-1); j >= i; j--) {
            				set[j+1] = new Employee(set[j]);
            			}// for
        				set[i] = new Employee(a);
        			}// if
        		}// for

        }// addOrdered
        
        
//		PRINT HELPER FUNCTION
        
        public String toString() {
        		return Arrays.toString(set);
        }// toString
        
        
//		FILE PARSER HELPER FUNCTION
        
        public static EmployeeSet readCVS() {
        		EmployeeSet copy = new EmployeeSet();
        		String csvF = "core_dataset.csv";
        		String line = "";
        		String cvsSplit = ",";
        
        		try (BufferedReader br = new BufferedReader(new FileReader(csvF))) {
            	
        			//skipping header line
            	
        			br.readLine();
        			String header = null;
            	
        			//parsing file
            	
        			while ((line = br.readLine()) != null) {
               	
        				Employee temp = new Employee();
                	
        				// setting values in temporary employee
            	
        				String[] currLine = line.split(cvsSplit);
        				temp.setName(currLine[0]+currLine[1]);
        				temp.setNo(Integer.parseInt(currLine[2]));
        				temp.setState(currLine[3]);
        				temp.setZip(Integer.parseInt(currLine[4]));
        				temp.setAge(Integer.parseInt(currLine[6]));
            	
            	
        				// adding employees to collection
                    
        				copy.add(new Employee(temp));
        			}// while
        		}// try
        		catch (IOException e) {
        			System.out.println("Error while parsing file");
        		}//catch
        		
        		// return EmployeeSet of CVS file
        	
        		return(copy);
        		
        }// read CVS

//      11 main

        public static void main(String[] args) {
        	
        		// making coreSet collection
        	
        		EmployeeSet coreSet = new EmployeeSet(readCVS());
        		System.out.println("Testing EmployeeSet with core_dataset.csv");
        		
        		// Capacity + Size of coreSet
        		
        		System.out.println();
        		System.out.println("coreSet Capacity is:	" + coreSet.capacity());
        		System.out.println("coreSet Size is:	" + coreSet.size());
        		System.out.println();
            
        		// Test Employee set up
            
        		Employee test = new Employee();
        		test.setName("Villanueva Noah");
        		test.setNo(1111030503);
            
        		// Searching for test employee
        		
        		System.out.println("Searching for Villanueva Noah, No.1111030503");
            
        		if(coreSet.contains(test))
        			System.out.printf("Villanueva Noah Found!\n\n");
        		else
        			System.out.printf("Villanueva Noah Not Found\n\n");
            
        		// Deleting test employee from set
            
        		System.out.println("Villanueva is deleted?	" + coreSet.remove(1111030503));
        		
        		// Trying to delete again
        		
        		System.out.println("Villanueva is deleted again?	" + coreSet.remove(1111030503));
        		
        		// Capacity + Size of coreSet
                
        		System.out.println();
        		System.out.println("coreSet Capacity is:	" + coreSet.capacity());
        		System.out.println("coreSet Size is:	" + coreSet.size());
        		System.out.println();
        		
        		// Searching for test employee
        		
        		System.out.println("Searching for Villanueva Noah, No.1111030503");
            
        		if(coreSet.contains(test))
        			System.out.printf("Villanueva Noah Found\n\n");
        		else
        			System.out.printf("Villanueva Noah Not Found\n\n");
        		
        		
        		// Testing addOrdered and toString
        		
        		System.out.println();
        		EmployeeSet Numbers = new EmployeeSet();
        		System.out.println("Testing addOrdered with EmployeeSet Numbers");
        		
        		// making Numbers Employee
        		
        		Employee One = new Employee();
        		One.setNo(1);
        		Employee Two = new Employee();
        		Two.setNo(2);
        		Employee Three = new Employee();
        		Three.setNo(3);
        		Employee Four = new Employee();
        		Four.setNo(4);
        		Employee Five = new Employee();
        		Five.setNo(5);
        		Employee Six = new Employee();
        		Six.setNo(6);
        		Employee Seven = new Employee();
        		Seven.setNo(7);
        		Employee Eight = new Employee();
        		Eight.setNo(8);
        		Employee Nine = new Employee();
        		Nine.setNo(9);
        		Employee Ten = new Employee();
        		Ten.setNo(10);
        		Employee Eleven = new Employee();
        		Eleven.setNo(11);
        		
        		// adding Numbers employee normally and in ascending order
        		
        		Numbers.add(Three);
        		Numbers.add(Five);
        		Numbers.add(Seven);
        		Numbers.add(Nine);
        		
        		// checking Numbers info and elements
        		
        		System.out.println("\nAdded Employees 3, 5, 7, 9");
        		System.out.println("Numbers Capacity is:	" + Numbers.capacity());
        		System.out.println("Numbers Size is:	" + Numbers.size());
        		System.out.println();
        		System.out.println(Numbers.toString());
        		
        		// addOrder edge cases
        		
        		Numbers.addOrdered(One);
        		Numbers.addOrdered(Ten);
        		Numbers.addOrdered(Eleven);
        		
        		// checking Numbers info and elements

        		System.out.println("\naddOrdered Employees 1, 10, 11");
        		System.out.println("Numbers Capacity is:	" + Numbers.capacity());
        		System.out.println("Numbers Size is:	" + Numbers.size());
        		System.out.println();
        		System.out.println(Numbers.toString());
        		
        		// addOrder middle cases
        		
        		Numbers.addOrdered(Two);
        		Numbers.addOrdered(Four);
        		Numbers.addOrdered(Six);
        		Numbers.addOrdered(Eight);
        		
        		// checking Numbers info and elements
        		
        		System.out.println("\naddOrdered Employees 2, 4, 6, 8");
        		System.out.println("Numbers Capacity is:	" + Numbers.capacity());
        		System.out.println("Numbers Size is:	" + Numbers.size());
        		System.out.println();
        		System.out.println(Numbers.toString());
        		
        }// main

}// EmployeeSet
