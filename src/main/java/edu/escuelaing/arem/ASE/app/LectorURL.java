package edu.escuelaing.arem.ASE.app;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

/**
 *
 * @author Nicolas Nontoa.
 */
public class LectorURL {
    public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
                String datos="";
		String userURL= in.readLine();
		
	    	URL page = new URL("https://www."+userURL);
	    
	    	try (BufferedReader reader = new BufferedReader(new InputStreamReader(page.openStream()))) {
			String inputLine = null;
			while ((inputLine = reader.readLine()) != null) {
				datos+=inputLine;
			}
		} catch (IOException x) {
			System.err.println(x);
		}
		
    		BufferedWriter bw = null;
	    	FileWriter fw = null;

	    try {
		File file = new File("resultado.html");
		// Si el archivo no existe, se crea!
		if (!file.exists()) {
		    file.createNewFile();
		}
		// flag true, indica adjuntar informacion al archivo.
		fw = new FileWriter(file.getAbsoluteFile(), true);
		bw = new BufferedWriter(fw);
		bw.write(datos);
	    } catch (IOException e) {
		e.printStackTrace();
	    } finally {
	        try {
                //Cierra instancias de FileWriter y BufferedWriter.
	            if (bw != null)
	                bw.close();
	            if (fw != null)
	                fw.close();
	        } catch (IOException ex) {
	            ex.printStackTrace();
	        }
	    }
	}
}
