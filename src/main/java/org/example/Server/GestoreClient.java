package org.example.Server;

import java.io.BufferedWriter;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class GestoreClient extends Thread{
    private Socket socket;

    public GestoreClient(Socket socket){
        this.socket = socket;
    }




    @Override
    public void run() {
        System.out.println("E partito il Thread: " + Thread.currentThread().getName());

        try{
            OutputStream out = socket.getOutputStream();
            BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(out));

            wr.write("Sei connesso al thread: " + Thread.currentThread().getName());

            wr.close();

        }
        catch (Exception e){
            System.err.println(e.getMessage());
        }



    }
}
