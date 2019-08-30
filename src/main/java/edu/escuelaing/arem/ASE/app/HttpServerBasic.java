/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.escuelaing.arem.ASE.app;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author estudiante
 */
public class HttpServerBasic {

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(8081);
        } catch (IOException e) {
            System.err.println("Could not listen on port: 35000.");
            System.exit(1);
        }
        Socket clientSocket = null;
        PrintWriter out;
        BufferedReader in;
        for (;;) {
            try {
                System.out.println("Listo para recibir ...");
                clientSocket = serverSocket.accept();
            } catch (IOException e) {
                System.err.println("Accept failed.");
                System.exit(1);
            }
            out = new PrintWriter(clientSocket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                System.out.println("Received: " + inputLine);
                if (!in.ready()) {
                    break;
                }
            }
            out.println("HTTP/1.1 200 OK");
            out.println("Content-Type: text/html" + "\r\n");
            out.println("<!DOCTYPE html>" + "\r\n");
            out.println("<html>" + "\r\n");
            out.println("<head>" + "\r\n");
            out.println("<meta charset=\"UTF-8\">" + "\r\n");
            out.println("<title>Title of the document</title>" + "\r\n");
            out.println("</head>" + "\r\n");
            out.println("<body>" + "\r\n");
            out.println("<h1>My Web Site</h1>" + "\r\n");
            out.println("</body>" + "\r\n");
            out.println("</html>" + "\r\n");
            out.flush();
        }
    }
}
