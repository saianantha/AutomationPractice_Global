package info.reusables;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class GlobalSettingsConfig {
	private static Properties global_properties = null;
	
	public static Properties getInstance() {
		if(global_properties != null) {
			if(global_properties.isEmpty()) {
				System.out.println("Global settings properties file is empty");
			}
			return global_properties;
		}
		
		try {
			
			File file = new File(System.getProperty("user.dir")
					+ File.separator + "src" + File.separator + "test"
					+ File.separator + "resources" + File.separator + "testproperties" + File.separator + "globalSettings.properties");
			FileInputStream inputStream = new FileInputStream(file);
			global_properties = new Properties();
			global_properties.load(inputStream);
			inputStream.close();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return global_properties;
		
	}
	
	

}
