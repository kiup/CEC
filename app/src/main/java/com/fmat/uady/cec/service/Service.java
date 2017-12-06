package com.fmat.uady.cec.service;

/**
 * Created by Bacelis on 29/11/2017.
 */

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class Service {

    private Context context;
    //Puerto
    private static final int SERVERPORT = 5000;
    //direccion servidor
    private static final String ADDRESS = "172.20.10.3";


    public Service(Context context){
        this.context = context;
    }

    public void turnOff(String pc){
        String comando = "apagar "+pc; //PAra apagar pc individual cambiar apagar_PC1 || PC2 || PC3
        MyATaskCliente myATaskYW = new MyATaskCliente();
        myATaskYW.execute(comando);
    }

    public void turnOn(String pc){
        String comando = "encender "+pc; //PAra apagar pc individual cambiar apagar_PC1 || PC2 || PC3
        MyATaskCliente myATaskYW = new MyATaskCliente();
        myATaskYW.execute(comando);
    }


    /**
     * Clase para interactuar con el servidor
     * */
    class MyATaskCliente extends AsyncTask<String,Void,String> {

        /**
         * Ventana que bloqueara la pantalla del movil hasta recibir respuesta del servidor
         * */
        ProgressDialog progressDialog;

        /**
         * muestra una ventana emergente
         * */
        @Override
        protected void onPreExecute()
        {
            super.onPreExecute();
            progressDialog = new ProgressDialog(context);
            progressDialog.setCanceledOnTouchOutside(false);
            progressDialog.setTitle("Connecting to server");
            progressDialog.setMessage("Please wait...");
            progressDialog.show();
        }

        /**
         * Se conecta al servidor y trata resultado
         * */
        @Override
        protected String doInBackground(String... values){

            try {
                //Se conecta al servidor
                InetAddress serverAddr = InetAddress.getByName(ADDRESS);
                Log.i("I/TCP Client", "Connecting...");
                Socket socket = new Socket(serverAddr, SERVERPORT);
                Log.i("I/TCP Client", "Connected to server");

                //envia peticion de cliente
                Log.i("I/TCP Client", "Send data to server");
                PrintStream output = new PrintStream(socket.getOutputStream());
                String request = values[0];
                output.println(request);

                //recibe respuesta del servidor y formatea a String
                Log.i("I/TCP Client", "Received data to server");
                InputStream stream = socket.getInputStream();
                byte[] lenBytes = new byte[256];
                stream.read(lenBytes,0,256);
                String received = new String(lenBytes,"UTF-8").trim();
                Log.i("I/TCP Client", "Received " + received);
                Log.i("I/TCP Client", "");
                //cierra conexion
                socket.close();
                return received;
            }catch (UnknownHostException ex) {
                Log.e("E/TCP Client", "" + ex.getMessage());
                return ex.getMessage();
            } catch (IOException ex) {
                Log.e("E/TCP Client", "" + ex.getMessage());
                return ex.getMessage();
            }
        }

        /**
         * Oculta ventana emergente y muestra resultado en pantalla
         * */
        @Override
        protected void onPostExecute(String value){
            progressDialog.dismiss();
            Toast.makeText(context, value, Toast.LENGTH_LONG).show();
        }
    }

}


