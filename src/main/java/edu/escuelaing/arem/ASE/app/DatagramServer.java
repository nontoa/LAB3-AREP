/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.escuelaing.arem.ASE.app;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author estudiante
 */
public class DatagramServer implements Runnable {

    DatagramSocket socket;

    public DatagramServer() {
        try {
            socket = new DatagramSocket(4565);
        } catch (SocketException ex) {
            Logger.getLogger(DatagramServer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void main(String[] args) {
        DatagramServer ds = new DatagramServer();
        ds.run();
    }

    @Override
    public void run() {
        for (;;) {
            byte[] buf = new byte[256];
            try {
                DatagramPacket packet = new DatagramPacket(buf, buf.length);
                socket.receive(packet);
                String dString = new Date().toString();
                buf = dString.getBytes();
                InetAddress address = packet.getAddress();
                int port = packet.getPort();
                packet = new DatagramPacket(buf, buf.length, address, port);
                socket.send(packet);
                Thread.sleep(5000);
            } catch (IOException ex) {
                Logger.getLogger(DatagramServer.class.getName()).log(Level.SEVERE, null, ex);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
