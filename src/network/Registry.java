package network;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Registry {
	//List<String> listeEnregistrements = new ArrayList<>();
    private static HashMap<String, String[]> enregistrements;

    public static String TestApp() {
        HashMap<String, String[]> enregistrements = new HashMap<String, String[]>();
        //faire une hashmap
		return null;
        
    } 
	 
	public HashMap<String, String[]> getEnregistrements() {
		return enregistrements;
	}

	public void setEnregistrements(HashMap<String, String[]> enregistrements) {
		this.enregistrements = enregistrements;
	}

	public String readRecords(){
				return null; 
	}

	
	public static void main(String[] zero) {
		
		ServerSocket socketserver  ;
		Socket socketduserveur ;
				
		//TestApp();
		try {
			
		
			socketserver = new ServerSocket(4485);
			System.out.println("Le registre �coute les connexions sur le port "  + socketserver.getLocalPort()+"...");

			socketduserveur = socketserver.accept(); 

			System.out.println("connexion d'un client !");
		        socketserver.close();
		        socketduserveur.close();

		}catch (IOException e) {
			e.printStackTrace();
		}
	}
}
