package com.fmat.uady.cec.WakeOnLan;

/**
 * Created by M on 27/11/2017.
 */
import android.content.Context;
import android.widget.Toast;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class WakeOnLan {
    public static final int PORT = 9;
    public static String wol(String ip, String mac){
        if (mac == null) {
            return "Hubo un error con la mac";
        }
        try {
            byte[] macBytes = getMacBytes(mac);
            byte[] bytes = new byte[6 + 16 * macBytes.length];
            for (int i = 0; i < 6; i++) {
                bytes[i] = (byte) 0xff;
            }
            for (int i = 6; i < bytes.length; i += macBytes.length) {
                System.arraycopy(macBytes, 0, bytes, i, macBytes.length);
            }
            InetAddress address = InetAddress.getByName(ip);
            DatagramPacket packet = new DatagramPacket(bytes, bytes.length, address, 9);
            DatagramSocket socket = new DatagramSocket();
            socket.send(packet);
            socket.close();
        }
        catch (Exception e) {
            return "Ocurrio un error al ejecutar el WOL";
        }
        return "El WOL se ejecuto con éxito";
    }


    private static byte[] getMacBytes(String mac) throws IllegalArgumentException {
        byte[] bytes = new byte[6];
        try {
            String hex;
            for (int i = 0; i < 6; i++) {
                hex = mac.substring(i*2, i*2+2);
                bytes[i] = (byte) Integer.parseInt(hex, 16);
            }
        }
        catch (NumberFormatException e) {
        }
        return bytes;
    }

    public static String getIPBrodcast(String mac){
        String ip = "255.255.255.255";

        return ip;
    }


}


