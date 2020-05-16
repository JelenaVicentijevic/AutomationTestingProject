package utility;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;

public class TxtRead {
	
	// Method reads txt.file and returns value for sent key
	public static String readText(String locatorName) {
		
		String filePath = "Locators.txt";
		HashMap<String, String> map = new HashMap<String, String>();
		
		try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
			String line;
			while ((line = reader.readLine()) != null) {
				String[] parts = line.split(":", 2);
				if (parts.length >= 2) {
					String key = parts[0];
					String value = parts[1];
					map.put(key, value);
				} 
			}
			return map.get(locatorName);
		} catch (Exception e) {
			e.printStackTrace();
			return "";
		}
	}

}
