package edu.escuelaing.arem.ASE.app;

import java.io.*;
import java.net.*;

/**
 *
 * @author Nicolas Nontoa.
 */
public class URLReader {

	public static void main(String[] args) throws Exception {
    
		URL facebook = new URL("http://www.facebook.com/");
		try (BufferedReader reader = new BufferedReader(new InputStreamReader(facebook.openStream()))) {
			String inputLine = null;
			while ((inputLine = reader.readLine()) != null) {
				System.out.println(inputLine);
			}			
			System.out.println(facebook.getAuthority()+"\n");
			System.out.println(facebook.getProtocol()+"\n");
			System.out.println(facebook.getPath()+"\n");
			System.out.println(facebook.getHost()+"\n");
			System.out.println(facebook.getPort()+"\n");
			System.out.println(facebook.getQuery()+"\n");
			System.out.println(facebook.getFile()+"\n");
			System.out.println(facebook.getRef()+"\n");
		} catch (IOException x) {
			System.err.println(x);
		}
	}
}
