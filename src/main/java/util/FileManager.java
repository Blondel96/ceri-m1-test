package util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

 

public class FileManager {
	public static void writeFile(String file,String content) throws IOException{
		 
			BufferedWriter fichier = new BufferedWriter(new FileWriter(file));
			fichier.write(content);
			fichier.close();
	 
		
	}
	public static String readFile(String file) throws IOException{
		
 
		      String ligne ;
		      BufferedReader fichier = new BufferedReader(new FileReader(file));
		      StringBuilder sb = new StringBuilder();
		      while ((ligne = fichier.readLine()) != null) {
		         sb.append(ligne);
		      }
		      fichier.close();
		      return sb.toString();
		      
		     
		 
	}
}
