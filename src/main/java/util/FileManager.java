package util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

 

public class FileManager {
	public static void writeFile(String file,String content){
		try {
			BufferedWriter fichier = new BufferedWriter(new FileWriter(file));
			fichier.write(content);
			fichier.close();
		} catch (FileNotFoundException e) {
			
		} catch (IOException e) {
			 
			e.printStackTrace();
		}
		
	}
	public static String readFile(String file){
		
		 try {
		      String ligne ;
		      BufferedReader fichier = new BufferedReader(new FileReader(file));
		      StringBuilder sb = new StringBuilder();
		      while ((ligne = fichier.readLine()) != null) {
		         sb.append(ligne);
		      }
		      fichier.close();
		      return sb.toString();
		      
		    } catch (Exception e) {
		      return null;
		    } 
		 
	}
}
