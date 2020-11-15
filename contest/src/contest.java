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
        
        
        try (FileReader reader = new FileReader("C:\\Users\\craig\\Downloads\\Training Json-20201115T162845Z-001\\Training_Json\\j4.json")) {
            Object obj = parser.parse(new FileReader("C:\\Users\\craig\\Downloads\\Training Json-20201115T162845Z-001\\Training_Json\\j4.json"));
            JSONArray jsonArray = (JSONArray) obj;
            JSONObject jsonObject = (JSONObject) jsonArray.get(0);
            Object textAnnotations = jsonObject.get("textAnnotations");
            String description = textAnnotations.toString().substring(17);
            System.out.println(description);
            
            
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