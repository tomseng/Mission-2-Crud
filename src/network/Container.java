package network;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

public class Container {
	
	
public static void main(String[] args) throws SQLException {
		
		ServerSocket socketserver  ;
		Socket socketduserveur ;
		Crud cr1 = new Crud();
		
		ArrayList<String> nomTables = cr1.getTablesNames();
		for(String ws:nomTables)
		{
			new Crud("80", "192.168.1.93", ws);
			Registry reg = new Registry();
			String[] tab=new String[3];
			tab[0]="192.168.1.93";
			tab[1]="80";
			tab[2]=ws;
			reg.addTable(ws, tab);
			HashMap<String, String[]> m=reg.getEnregistrements();
			for(String p:m.get(ws)){
				System.out.println(p);
			}
		}	
		//TestApp();
		try {
		
			socketserver = new ServerSocket(754);
			System.out.println("Le registre écoute les connexions sur le port "  + socketserver.getLocalPort()+"...");

			socketduserveur = socketserver.accept(); 

			System.out.println("Un client s'est connecté !");
		        socketserver.close();
		        socketduserveur.close();

		}catch (IOException e) {
			e.printStackTrace();
		}
	}
	 

}
