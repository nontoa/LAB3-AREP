/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.escuelaing.arem.ASE.app;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author estudiante
 */
public class HttpServer {

    private static ServerSocket serverSocket = null;

    private static boolean continuar = true;

    private static Socket clientSocket = null;

    public static void main(String[] args) throws IOException {

        try {
            serverSocket = new ServerSocket(8081);
            int counter = 0;
            while (continuar) {
                counter++;
                System.out.println("Listo para recibir ... " + counter);
                clientSocket = serverSocket.accept();
                String path = getPageRequest(clientSocket.getInputStream());
                if (path.equals("/html1")) {
                    html1(clientSocket.getOutputStream());
                } else if (path.equals("/html2")) {
                    html2(clientSocket.getOutputStream());
                } else if (path.equals("/image1")) {
                    image1(clientSocket.getOutputStream());
                } else if (path.equals("/image2")) {
                    image2(clientSocket.getOutputStream());
                } else if (path.equals("/image3")) {
                    image3(clientSocket.getOutputStream());
                } else if (path.equals("/image4")) {
                    image4(clientSocket.getOutputStream());
                } else if (path.equals("/css1")) {
                    css1(clientSocket.getOutputStream());
                }
                clientSocket.close();
            }
        } catch (IOException e) {
            System.err.println("Could not listen on port: 35000.");
            System.exit(1);
        } finally {
            serverSocket.close();
        }
    }

    public static String getPageRequest(InputStream is) throws IOException {
        is.mark(0);
        BufferedReader in = new BufferedReader(new InputStreamReader(is));
        String inputLine = null;
        while ((inputLine = in.readLine()) != null) {
            if (!in.ready()) {
                break;
            }
            if (inputLine.contains("GET")) {
                String[] get = inputLine.split(" ");
                return get[1];
            }
            break;
        }
        return "path";
    }

    // HTML
    public static void html1(OutputStream os) {
        PrintWriter response = new PrintWriter(os, true);
        response.println("HTTP/1.1 200 OK");
        response.println("Content-Type: text/html" + "\r\n");
        response.println("<!DOCTYPE html>" + "\r\n");
        response.println("<html>" + "\r\n");
        response.println("<head>" + "\r\n");
        response.println("<meta charset=\"UTF-8\">" + "\r\n");
        response.println("<title>Title of the document</title>" + "\r\n");
        response.println("</head>" + "\r\n");
        response.println("<body>" + "\r\n");
        response.println("<h1>My Web Site</h1>" + "\r\n");
        response.println("</body>" + "\r\n");
        response.println("</html>" + "\r\n");
        response.flush();
        response.close();
    }

    public static void html2(OutputStream os) {
        PrintWriter response = new PrintWriter(os, true);
        response.println("HTTP/1.1 200 OK");
        response.println("Content-Type: text/html" + "\r\n");
        response.println("<!DOCTYPE html>" + "\r\n");
        response.println("<html>" + "\r\n");
        response.println("<head>" + "\r\n");
        response.println("<meta charset=\"UTF-8\">" + "\r\n");
        response.println("<title>Cómo hacer una página web con HTML</title>" + "\r\n");
        response.println("</head>" + "\r\n");
        response.println("<body>" + "\r\n");
        response.println("<h1>Cómo hacer una página web con HTML</h1>" + "\r\n");
        response.println("<p> En el post de hoy voy a enseñarte <strong>cómo hacer una página web con HTML</strong>, pero antes …</p>" + "\r\n");
        response.println("<h2>Conceptos básicos sobre páginas web</h2>" + "\r\n");
        response.println("<p>¿Cuál es entonces la diferencia entre una página web y un sitio web?…</p>" + "\r\n");
        response.println("<h3>Diferencias entre una página web y un sitio web</h3>" + "\r\n");
        response.println("<p>Una <a href=”https://es.wikipedia.org/wiki/P%C3%A1gina_web”>página web</a> es un <strong>único documento electrónico</strong> que…</p>" + "\r\n");
        response.println("</body>" + "\r\n");
        response.println("</html>" + "\r\n");
        response.flush();
        response.close();
    }

    // IMAGENES
    public static void image1(OutputStream os) {
        PrintWriter response = new PrintWriter(os, true);
        response.println("HTTP/1.1 200 OK");
        response.println("Content-Type: text/html" + "\r\n");
        response.println("<!DOCTYPE html>" + "\r\n");
        response.println("<html>" + "\r\n");
        response.println("<head>" + "\r\n");
        response.println("<meta charset=\"UTF-8\">" + "\r\n");
        response.println("<title>Index</title>" + "\r\n");
        response.println("</head>" + "\r\n");
        response.println("<body>" + "\r\n");
        response.println("<img src=\"https://c.stocksy.com/a/p8M600/z9/1515083.jpg\"></img>" + "\r\n");
        response.println("</body>" + "\r\n");
        response.println("</html>" + "\r\n");
        response.flush();
        response.close();
    }

    public static void image2(OutputStream os) {
        PrintWriter response = new PrintWriter(os, true);
        response.println("HTTP/1.1 200 OK");
        response.println("Content-Type: text/html" + "\r\n");
        response.println("<!DOCTYPE html>" + "\r\n");
        response.println("<html>" + "\r\n");
        response.println("<head>" + "\r\n");
        response.println("<meta charset=\"UTF-8\">" + "\r\n");
        response.println("<title>Index</title>" + "\r\n");
        response.println("</head>" + "\r\n");
        response.println("<body>" + "\r\n");
        response.println("<img src=\"http://www.yamaha.com/YECDealerMedia/adgraphs/logos/nyamaha.jpg\"></img>" + "\r\n");
        response.println("</body>" + "\r\n");
        response.println("</html>" + "\r\n");
        response.flush();
        response.close();
    }

    public static void image3(OutputStream os) {
        PrintWriter response = new PrintWriter(os, true);
        response.println("HTTP/1.1 200 OK");
        response.println("Content-Type: text/html" + "\r\n");
        response.println("<!DOCTYPE html>" + "\r\n");
        response.println("<html>" + "\r\n");
        response.println("<head>" + "\r\n");
        response.println("<meta charset=\"UTF-8\">" + "\r\n");
        response.println("<title>Index</title>" + "\r\n");
        response.println("</head>" + "\r\n");
        response.println("<body>" + "\r\n");
        response.println("<img src=\"http://www.yamaha.com/YECDealerMedia/adgraphs/logos/nvideocd.jpg\"></img>" + "\r\n");
        response.println("</body>" + "\r\n");
        response.println("</html>" + "\r\n");
        response.flush();
        response.close();
    }

    public static void image4(OutputStream os) {
        PrintWriter response = new PrintWriter(os, true);
        response.println("HTTP/1.1 200 OK");
        response.println("Content-Type: text/html" + "\r\n");
        response.println("<!DOCTYPE html>" + "\r\n");
        response.println("<html>" + "\r\n");
        response.println("<head>" + "\r\n");
        response.println("<meta charset=\"UTF-8\">" + "\r\n");
        response.println("<title>Index</title>" + "\r\n");
        response.println("</head>" + "\r\n");
        response.println("<body>" + "\r\n");
        response.println("<img src=\"http://chandra.harvard.edu/photo/2017/arp299/arp299.jpg\"></img>" + "\r\n");
        response.println("</body>" + "\r\n");
        response.println("</html>" + "\r\n");
        response.flush();
        response.close();
    }

    // CSS
    public static void css1(OutputStream os) {
        PrintWriter response = new PrintWriter(os, true);
        response.println("HTTP/1.1 200 OK");
        response.println("Content-Type: text/css" + "\r\n");
        response.println("p {" + "\r\n");
        response.println("color: red;" + "\r\n");
        response.println("width: 500px;" + "\r\n");
        response.println(" border: 1px solid black;" + "\r\n");
        response.println("}" + "\r\n");
        response.flush();
        response.close();

    }

    public static void writeRequest(InputStream is) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(is));
        String inputLine = null;
        while ((inputLine = in.readLine()) != null) {
            if (!in.ready()) {
                break;
            }
            System.out.println("Received: " + inputLine);
        }
    }
}
