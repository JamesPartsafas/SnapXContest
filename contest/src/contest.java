import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class contest {
	public static void main(String[] args) {

        JSONParser parser = new JSONParser();
 

        try (FileReader reader = new FileReader("C:\\Users\\craig\\OneDrive\\Desktop\\j1.json"))
        
        {     
		Object obj = parser.parse(new FileReader("C:\\\\Users\\\\craig\\\\OneDrive\\\\Desktop\\\\j1.json"));
            	JSONArray jsonList = (JSONArray) obj;
            	System.out.println(jsonList);
            
            
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
	}
}
