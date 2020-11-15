import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.*;
import java.util.Scanner;


public class contest {

	
	
    public static void main(String[] args) throws Exception {
    	/*
    	Scanner keyIn = new Scanner(System.in);

    	System.out.println("Please enter the file path to your JSON directory:");
    	String filePathJSON = keyIn.nextLine();
    	String temp = keyIn.nextLine();
    	System.out.println("Please enter the file path to your CSV file directory: ")
    	String filePathCSV = keyIn.nextLine();

    	try (FileReader reader = new FileReader(filePathJSON + "\\j"+(j+1)+".json"))
    	    
    	BufferedReader br = new BufferedReader(new FileReader(filePathCSV + "\\supplierlist"+k+".csv")); */
        
    	//variable initialization block
        String[] receipt = new String[11];
        receipt[10] = "NulL";
        String output;
        int linenum = 0;
        int exit = 0;
        
        //opening the parser
        JSONParser parser = new JSONParser();
        for (int j = 0; j<20;j++) {
        	
        	//decoding the JSON files into strings
	        try (FileReader reader = new FileReader("C:\\Users\\craig\\Downloads\\Training Json-20201115T162845Z-001\\Training_Json\\j"+(j+1)+".json")) {
	            Object obj = parser.parse(new FileReader("C:\\Users\\craig\\Downloads\\Training Json-20201115T162845Z-001\\Training_Json\\j"+(j+1)+".json"));
	            JSONArray jsonArray = (JSONArray) obj;
	            JSONObject jsonObject = (JSONObject) jsonArray.get(0);
	            Object textAnnotations = jsonObject.get("textAnnotations");
	            String description = textAnnotations.toString().substring(17);
	
	            //splitting the decoded JSON files into multiple strings. These will be compared to the CSV lists in order to determine from which company the reciept came from
	            String descriptionTwo = description.replace("\\n", " ");
	            String delimiter = "\\ ";
	            String[] keywords = descriptionTwo.split(delimiter, 11);
	            
	            for (int i = 1; i < 11; i++) {
	                receipt[(i-1)] = keywords[i];
	            }  

	            
	        }
	        //in case of input/output errors
	        catch(FileNotFoundException e) //executes if file path is incorrect
	        	{ e.printStackTrace(); 
	        	}
	        catch(IOException e) //executes if read file does not match expected file
	        	{ e.printStackTrace(); 
	        	}
	        catch(ParseException e) //executes if parsing format does not match expected format
	        	{ e.printStackTrace(); 
	        	}
	        catch(Exception e) //executes in case of general exceptions, default java exceptions
	        	{ e.printStackTrace(); 
	        	}
        

            //parsing a CSV file into Scanner class constructor
            linenum = 0;
            exit = 0;
            
            for (int k = 1; k < 3; k++)
            {
                linenum = 0;
                BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\craig\\OneDrive\\Documents\\supplierList-20201115T203043Z-001\\supplierList\\supplierlist"+k+".csv")); 
                String line = "";
                
                while ( (line = br.readLine()) != null && exit == 0) { 
                    String[] cols = line.split(",");
                    //System.out.println("File Num: "+k+" "+"Line Num: "+linenum+" "+cols[0]);
                    linenum++;
    
                    //comparison of receipt to CSV files
                    for (int l = 0; l < 56; l++) {
                    	
                    	
                    	//first concatenation (9)
                    	else if (l >= 11 && l < 20) {
	            			if ((cols[0].equalsIgnoreCase(receipt[0] + " " + receipt[l-10])) == true){
	            				output = cols[0];
	            				System.out.println("Company name: " + output +" CSV filenumber: " + k + " SIC4: " +cols[1] + " SIC 8: " + cols[2] + " Line number: " + linenum);
	            				exit = 1;
	            			}
                    	}
                    	
                    	//second concatenation (8)
                    	else if (l >= 20 && l < 28) {
	            			if ((cols[0].equalsIgnoreCase(receipt[1] + " " + receipt[l-18])) == true){
	            				output = cols[0];
	            				System.out.println("Company name: " + output +" CSV filenumber: " + k + " SIC4: " +cols[1] + " SIC 8: " + cols[2] + " Line number: " + linenum);
	            				exit = 1;
	            			}
                    	}
                    	
                    	//third concatenation (7)
                    	else if (l >= 28 && l < 35) {
	            			if ((cols[0].equalsIgnoreCase(receipt[2] + " " + receipt[l-25])) == true){
	            				output = cols[0];
	            				System.out.println("Company name: " + output +" CSV filenumber: " + k + " SIC4: " +cols[1] + " SIC 8: " + cols[2] + " Line number: " + linenum);
	            				exit = 1;
	            			}
                    	}
                    	
                    	//fourth concatenation (6)
                    	else if (l >= 35 && l < 41) {
	            			if ((cols[0].equalsIgnoreCase(receipt[3] + " " + receipt[l-31])) == true){
	            				output = cols[0];
	            				System.out.println("Company name: " + output +" CSV filenumber: " + k + " SIC4: " +cols[1] + " SIC 8: " + cols[2] + " Line number: " + linenum);
	            				exit = 1;
	            			}
                    	}
                    	
                    	//fifth concatenation (5)
                    	else if (l >= 41 && l < 46) {
	            			if ((cols[0].equalsIgnoreCase(receipt[4] + " " + receipt[l-36])) == true){
	            				output = cols[0];
	            				System.out.println("Company name: " + output +" CSV filenumber: " + k + " SIC4: " +cols[1] + " SIC 8: " + cols[2] + " Line number: " + linenum);
	            				exit = 1;
	            			}
                    	}
                    	
                    	//sixth concatenation (4)
                    	else if (l >= 46 && l < 50) {
	            			if ((cols[0].equalsIgnoreCase(receipt[5] + " " + receipt[l-40])) == true){
	            				output = cols[0];
	            				System.out.println("Company name: " + output +" CSV filenumber: " + k + " SIC4: " +cols[1] + " SIC 8: " + cols[2] + " Line number: " + linenum);
	            				exit = 1;
	            			}
                    	}
                    	
                    	//sixth concatenation (3)
                    	else if (l >= 50 && l < 53) {
	            			if ((cols[0].equalsIgnoreCase(receipt[6] + " " + receipt[l-43])) == true){
	            				output = cols[0];
	            				System.out.println("Company name: " + output +" CSV filenumber: " + k + " SIC4: " +cols[1] + " SIC 8: " + cols[2] + " Line number: " + linenum);
	            				exit = 1;
	            			}
                    	}
                    	
                    	//sixth concatenation (2)
                    	else if (l >= 53 && l < 55) {
	            			if ((cols[0].equalsIgnoreCase(receipt[7] + " " + receipt[l-45])) == true){
	            				output = cols[0];
	            				System.out.println("Company name: " + output +" CSV filenumber: " + k + " SIC4: " +cols[1] + " SIC 8: " + cols[2] + " Line number: " + linenum);
	            				exit = 1;
	            			}
                    	}
                    	
                    	//sixth concatenation (1)
                    	else if (l >= 55 && l < 56) {
	            			if ((cols[0].equalsIgnoreCase(receipt[8] + " " + receipt[l-46])) == true){
	            				output = cols[0];
	            				System.out.println("Company name: " + output +" CSV filenumber: " + k + " SIC4: " +cols[1] + " SIC 8: " + cols[2] + " Line number: " + linenum);
	            				exit = 1;
	            			}
                    	}
            			//in case company is not found
            			else if (exit != 1 && l == 10 && k == 2 && linenum == 499999) {
                        	System.out.println("company not found");
                        }
                    	
                    	//singles
                    	if (l >= 0 && l < 11) {
	            			if ((cols[0].equalsIgnoreCase(receipt[l])) == true){
	            				output = cols[0];
	            				System.out.println("Company name: " + output +" CSV filenumber: " + k + " SIC4: " +cols[1] + " SIC 8: " + cols[2] + " Line number: " + linenum);
	            				exit = 1;
	            			}
                    	}
            			
            		}


                }
                br.close();
            }
            
        //end of large FOR loop
        }
    }
}

    // Converting of CSV into array sourced from: https://www.xspdf.com/resolution/58992952.html
