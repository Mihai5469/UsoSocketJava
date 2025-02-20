package org.example;


import java.net.InetAddress;

public class Main {
    public static void main(String[] args) {

        int port = 8080;

        SimpleServer server;

        System.out.printf("Hello and welcome!");

        for (int i = 1; i <= 5; i++) {
            System.out.println("i = " + i);
        }
    }
}