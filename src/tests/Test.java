package tests;

import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class Test {

	public static void main(String[] args) {
		
		InetAddress localAdress;
		InetAddress serverAdress;
		try {

			localAdress = InetAddress.getLocalHost();
			System.out.println("L'adresse locale est : "+localAdress ); 
			
			serverAdress= InetAddress.getByName("www.thomasengels.wordpress.com");
                        System.out.println("L'adresse du serveur du site du zéro est : "+serverAdress);
		
		} catch (UnknownHostException e) {
			
			e.printStackTrace();
		}
	}
}
