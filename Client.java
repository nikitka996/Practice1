package com.company;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Client {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        String ip = "127.0.0.1";
        int port = 8000;

        try (
                Socket echoSocket = new Socket(ip, port);

                PrintWriter out = new PrintWriter(echoSocket.getOutputStream(), true);
                BufferedReader in = new BufferedReader(new InputStreamReader(echoSocket.getInputStream()));
        ) {

            while (true) {
                String input = sc.nextLine();
                out.println(input);
                System.out.println("Result = " + in.readLine());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}