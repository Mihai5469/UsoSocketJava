package org.example;

import java.io.*;
import java.net.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Classe che crea un semplice server
 *
 * @version 20/02/2025
 */
public class SimpleServer {

    private int port;
    private InetAddress ip;

    private ServerSocket server;

    public SimpleServer(InetAddress ip, int port) {
        this.ip = ip;
        this.port = port;
        if (!startServer()) {
            System.out.println("Errore durante la creazione del server");
        }
    }

    public int getPort() {
        return port;
    }

    public InetAddress getIp() {
        return ip;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public void setIp(InetAddress ip) {
        this.ip = ip;
    }

    /**
     * Metodo che fa partire il server
     *
     * @return true or false
     */
    private boolean startServer() {
        try {
            this.server = new ServerSocket(this.port);
        } catch (IOException e) {
            System.out.println(e.getMessage());
            return false;
        }
        System.out.println("Il server e stato creato con successo");
        return true;
    }

    /**
     * Metodo che fa che il server sia in attesa di un client
     */
    public void runServer() {
        while (true) {
            System.out.println("Server in attesa di richieste");
            try {
                Socket s1 = server.accept();
                System.out.println("Client connesso");

                //Preparazione dello stream si output -> risposta per il client
                //######################################################################################################
                LocalDate data = LocalDate.now();
                //System.out.println(data);
                DateTimeFormatter formatData = DateTimeFormatter.ofPattern("dd-MM-yyyy");

                String dataFormatata = formatData.format(data);

                //System.out.println("La data formatata: " + dataFormatata);


                //######################################################################################################
                OutputStream s1out = s1.getOutputStream();
                BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(s1out));

                bw.write("Benvenuto sul server. Oggi è il " + dataFormatata + "\n");

                bw.close();
                s1.close();

                System.out.println("Connessione terminata");

            } catch (IOException e) {
                System.out.println(e.getMessage());
            }


        }

    }


}
