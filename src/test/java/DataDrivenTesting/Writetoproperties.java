package DataDrivenTesting;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class Writetoproperties {

	public static void main(String[] args) throws IOException {
		FileInputStream fis= new FileInputStream("./src/test/resources/Data.properties");
		Properties pr=new Properties();
		pr.load(fis);
		
		pr.put("subject","selenium");
		
		FileOutputStream fos=new FileOutputStream("./src/test/resources/Dta.properties");
		pr.store(fos,"Updated Successfully");
		

	}

}
