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
    	
    	Scanner keyIn = new Scanner(System.in);

    	System.out.println("Please enter the file path to your JSON directory:");
    	String filePathJSON = keyIn.nextLine();
    	String temp = keyIn.nextLine();
    	System.out.println("Please enter the file path to your CSV file directory: ");
    	String filePathCSV = keyIn.nextLine();

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
        	try (FileReader reader = new FileReader(filePathJSON + "\\j"+(j+1)+".json")) {
	            Object obj = parser.parse(new FileReader(filePathJSON + "\\j"+(j+1)+".json"));
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
                BufferedReader br = new BufferedReader(new FileReader(filePathCSV + "\\supplierlist"+k+".csv"));                 
                String line = "";
                
                while ( (line = br.readLine()) != null && exit == 0) { 
                    String[] cols = line.split(",");
 
                    linenum++;
    
                    //comparison of receipt to CSV files
                    for (int l = 0; l < 56; l++) {
                    	
                    	if (exit == 1)
                    		continue;
                    	
                    	//first concatenation (9)
                    	if (l >= 0 && l < 9) {
	            			if ((cols[0].equalsIgnoreCase(receipt[0] + " " + receipt[l+1])) == true) {
	            				output = cols[0];
	            				System.out.println("Company name: " + output +" CSV filenumber: " + k + " SIC4: " +cols[1] + " SIC 8: " + cols[2] + " Line number: " + linenum);
	            				exit = 1;
	            			}
                    	}
                    	
                    	//second concatenation (8)
                    	else if (l >= 9 && l < 17) {
	            			if ((cols[0].equalsIgnoreCase(receipt[1] + " " + receipt[l-7])) == true) {
	            				output = cols[0];
	            				System.out.println("Company name: " + output +" CSV filenumber: " + k + " SIC4: " +cols[1] + " SIC 8: " + cols[2] + " Line number: " + linenum);
	            				exit = 1;
	            			}
                    	}
                    	
                    	//third concatenation (7)
                    	else if (l >= 17 && l < 24) {
	            			if ((cols[0].equalsIgnoreCase(receipt[2] + " " + receipt[l-14])) == true) {
	            				output = cols[0];
	            				System.out.println("Company name: " + output +" CSV filenumber: " + k + " SIC4: " +cols[1] + " SIC 8: " + cols[2] + " Line number: " + linenum);
	            				exit = 1;
	            			}
                    	}
                    	
                    	//fourth concatenation (6)
                    	else if (l >= 24 && l < 30) {
	            			if ((cols[0].equalsIgnoreCase(receipt[3] + " " + receipt[l-20])) == true) {
	            				output = cols[0];
	            				System.out.println("Company name: " + output +" CSV filenumber: " + k + " SIC4: " +cols[1] + " SIC 8: " + cols[2] + " Line number: " + linenum);
	            				exit = 1;
	            			}
                    	}
                    	
                    	//fifth concatenation (5)
                    	else if (l >= 30 && l < 35) {
	            			if ((cols[0].equalsIgnoreCase(receipt[4] + " " + receipt[l-25])) == true) {
	            				output = cols[0];
	            				System.out.println("Company name: " + output +" CSV filenumber: " + k + " SIC4: " +cols[1] + " SIC 8: " + cols[2] + " Line number: " + linenum);
	            				exit = 1;
	            			}
                    	}
                    	
                    	//sixth concatenation (4)
                    	else if (l >= 35 && l < 39) {
	            			if ((cols[0].equalsIgnoreCase(receipt[5] + " " + receipt[l-29])) == true) {
	            				output = cols[0];
	            				System.out.println("Company name: " + output +" CSV filenumber: " + k + " SIC4: " +cols[1] + " SIC 8: " + cols[2] + " Line number: " + linenum);
	            				exit = 1;
	            			}
                    	}
                    	/*
                    	//sixth concatenation (3)
                    	else if (l >= 39 && l < 42) {
	            			if ((cols[0].equalsIgnoreCase(receipt[6] + " " + receipt[l-32])) == true) {
	            				output = cols[0];
	            				System.out.println("Company name: " + output +" CSV filenumber: " + k + " SIC4: " +cols[1] + " SIC 8: " + cols[2] + " Line number: " + linenum);
	            				exit = 1;
	            			}
                    	}
                    	
                    	//sixth concatenation (2)
                    	else if (l >= 42 && l < 44) {
	            			if ((cols[0].equalsIgnoreCase(receipt[7] + " " + receipt[l-34])) == true) {
	            				output = cols[0];
	            				System.out.println("Company name: " + output +" CSV filenumber: " + k + " SIC4: " +cols[1] + " SIC 8: " + cols[2] + " Line number: " + linenum);
	            				exit = 1;
	            			}
                    	}
                    	
                    	//sixth concatenation (1)
                    	else if (l >= 44 && l < 45) {
	            			if ((cols[0].equalsIgnoreCase(receipt[8] + " " + receipt[l-35])) == true) {
	            				output = cols[0];
	            				System.out.println("Company name: " + output +" CSV filenumber: " + k + " SIC4: " +cols[1] + " SIC 8: " + cols[2] + " Line number: " + linenum);
	            				exit = 1;
	            			}
                    	}*/
                    	
                    	//singles
            			else if (l >= 45 && l < 56) {
	            			if ((cols[0].equalsIgnoreCase(receipt[l-45])) == true) {
	            				output = cols[0];
	            				System.out.println("Company name: " + output +" CSV filenumber: " + k + " SIC4: " +cols[1] + " SIC 8: " + cols[2] + " Line number: " + linenum);
	            				exit = 1;
	            			}
                    	}
                    	
                    	//in case company is not found
            			else if (exit != 1 && k == 2 && linenum == 499999) {
                        	System.out.println("company not found");
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
