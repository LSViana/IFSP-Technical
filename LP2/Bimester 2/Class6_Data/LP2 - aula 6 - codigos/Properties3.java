package aula4;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Date;
import java.util.Properties;

public class Properties3 {

	public static void main(String args[]) throws Exception {
	    
		Properties propriedades = new Properties();

		propriedades.put("ultimo acesso", new Date().toString());
		
		propriedades.put("usuario", "romario");
		
		propriedades.put("senha", "12345");

	    FileOutputStream out = new FileOutputStream("usuario.properties");
	    
	    propriedades.storeToXML(out, new Date().toString() );

	    FileInputStream in = new FileInputStream("usuario.properties");

	    propriedades.loadFromXML(in);
	    
	    propriedades.list( System.out );
	    
	 }

}
