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
        JSONParser parser = new JSONParser();
        String[] receipt = new String[11];
        receipt[10] = "NulL";
        
        for (int j = 0; j<20;j++) {
        	
	        try (FileReader reader = new FileReader("C:\\Users\\craig\\Downloads\\Training Json-20201115T162845Z-001\\Training_Json\\j"+(j+1)+".json")) {
	            Object obj = parser.parse(new FileReader("C:\\Users\\craig\\Downloads\\Training Json-20201115T162845Z-001\\Training_Json\\j"+(j+1)+".json"));
	            JSONArray jsonArray = (JSONArray) obj;
	            JSONObject jsonObject = (JSONObject) jsonArray.get(0);
	            Object textAnnotations = jsonObject.get("textAnnotations");
	            String description = textAnnotations.toString().substring(17);
	
	            
	            String descriptionTwo = description.replace("\\n", " ");
	            String delimiter = "\\ ";
	            String[] keywords = descriptionTwo.split(delimiter, 11);
	            
	            for (int i = 1; i < 11; i++) {
	                receipt[(i-1)] = keywords[i];
	            }  

	            
	        }
	        catch(FileNotFoundException e) 
	        	{ e.printStackTrace(); 
	        	}
	        catch(IOException e) 
	        	{ e.printStackTrace(); 
	        	}
	        catch(ParseException e) 
	        	{ e.printStackTrace(); 
	        	}
	        catch(Exception e) 
	        	{ e.printStackTrace(); 
	        	}
        

            //parsing a CSV file into Scanner class constructor
            int linenum = 0;
            int exit = 0;
            for (int k = 1; k < 3; k++)
            {
                linenum = 0;
                BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\craig\\OneDrive\\Documents\\supplierList-20201115T203043Z-001\\supplierList\\supplierlist"+k+".csv")); 
                String line = "";
                
                while ( (line = br.readLine()) != null && exit == 0) { 
                    String[] cols = line.split(",");
                    //System.out.println("File Num: "+k+" "+"Line Num: "+linenum+" "+cols[0]);
                    linenum++;
    
                    
                    for (int l = 0; l < 11; l++) {
            			if ((cols[0].equalsIgnoreCase(receipt[l])) == true){
            				String output = cols[0];
            				System.out.println("Company name: " + output +" CSV filenumber: " + k + " SIC4: " +cols[1] + " SIC 8: " + cols[2] + " Line number: " + linenum);
            				exit = 1;
            			}
            			else if (exit != 1 && l == 10 && k == 2 && linenum == 499999) {
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
