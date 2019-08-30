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
import java.util.StringTokenizer;

/**
 *
 * @author estudiante
 */
public class SocketOpServidor {

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(8081);
        } catch (IOException e) {
            System.err.println("Could not listen on port: 35000.");
            System.exit(1);
        }
        Socket clientSocket = null;
        try {
            clientSocket = serverSocket.accept();
        } catch (IOException e) {
            System.err.println("Accept failed.");
            System.exit(1);
        }
        PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
        BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        String inputLine, outputLine, funcion;
        funcion = "coseno";
        while ((inputLine = in.readLine()) != null) {
            StringTokenizer st = new StringTokenizer(inputLine);
            String temp = st.nextToken();
            double val = 0.0;
            outputLine = "Respuesta ";
            if (isNumeric(temp) == true) {
                if (funcion.equals("coseno")) {
                    Double fa = Double.parseDouble(temp);
                    val = Math.cos(fa);
                    outputLine += val;
                } else if (funcion.equals("seno")) {
                    Double fa = Double.parseDouble(temp);
                    val = Math.sin(fa);
                    outputLine += val;
                } else {
                    Double fa = Double.parseDouble(temp);
                    val = Math.tan(fa);
                    outputLine += val;
                }
            } else {
                if (temp.equals("fun:sin")) {
                    funcion = "seno";
                    outputLine += "funcion acutal seno";
                } else if (temp.equals("fun:cos") || temp.equals("fun:")) {
                    funcion = "coseno";
                    outputLine += "funcion acutal coseno";
                } else if (temp.equals("fun:tan")) {
                    funcion = "tangente";
                    outputLine += "funcion acutal tangente";
                }
            }
            out.println(outputLine);
            if (temp.equals("Bye")) {
                break;
            }
        }
        out.close();
        in.close();
        clientSocket.close();
        serverSocket.close();
    }

    public static boolean isNumeric(String cadena) {

        boolean resultado;

        try {
            Integer.parseInt(cadena);
            resultado = true;
        } catch (NumberFormatException excepcion) {
            resultado = false;
        }

        return resultado;
    }
}
