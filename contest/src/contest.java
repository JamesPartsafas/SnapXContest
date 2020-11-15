import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


public class contest {
    private static int FIRST_ELEMENT = 0;
    public static void main(String[] args) {
        JSONParser parser = new JSONParser();
        
        for (int j = 1; j<21;j++) {
	        try (FileReader reader = new FileReader("C:\\Users\\craig\\Downloads\\Training Json-20201115T162845Z-001\\Training_Json\\j"+j+".json")) {
	            Object obj = parser.parse(new FileReader("C:\\Users\\craig\\Downloads\\Training Json-20201115T162845Z-001\\Training_Json\\j"+j+".json"));
	            JSONArray jsonArray = (JSONArray) obj;
	            JSONObject jsonObject = (JSONObject) jsonArray.get(0);
	            Object textAnnotations = jsonObject.get("textAnnotations");
	            String description = textAnnotations.toString().substring(17);
	
	            
	            String descriptionTwo = description.replace("\\n", " ");
	            String delimiter = "\\ ";
	            String[] keywords = descriptionTwo.split(delimiter, 11);
	            System.out.println("JSON fil nb: "+j);
	            for (int i = 0; i < 10; i++) {
	                System.out.println(keywords[i]);
	            }  
	            System.out.println();
	            
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
        }

    }

}
