package network;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Serveur {
	public static void main(String[] zero) {
		
		ServerSocket socketserver  ;
		Socket socketduserveur ;

		try {
		
			socketserver = new ServerSocket(2016);
			socketduserveur = socketserver.accept(); 
			System.out.println("connexion d'un client !");
		        socketserver.close();
		        socketduserveur.close();

		}catch (IOException e) {
			e.printStackTrace();
		}
	}
}
