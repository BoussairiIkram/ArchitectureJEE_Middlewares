package org.example.ws;

import jakarta.xml.ws.Endpoint;

public class ServerJWS {
    public static void main(String[] args) {
        Endpoint.publish("http://0.0.0.0:9191/", new BanqueService());
        System.out.println("web service dépoyé sur http://0.0.0.0:9191/ ");
    }
}
