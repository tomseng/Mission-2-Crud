package network;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Registry {
	//List<String> listeEnregistrements = new ArrayList<>();
    private HashMap<String, String[]> enregistrements;
    
    
	 
	public HashMap<String, String[]> getEnregistrements() {
		return enregistrements;
	}
	
	public Object[][] getEnregistrementsToObjects() {
		Object[][] retour=new Object[enregistrements.size()][];
		int i=0;
		for(String key:enregistrements.keySet()){
			for(int j=0; j<enregistrements.get(key).length; j++){
				retour[i][j]=enregistrements.get(key)[j];
			}
			i++;
		}
		return retour;
	}
	public void addTable(String nomTable, String[] Ipport){
		enregistrements.put(nomTable, Ipport);
	}

	public Registry() {
		super();
		enregistrements=new HashMap<String, String[]>();
		// TODO Auto-generated constructor stub
	}

	public Registry(HashMap<String, String[]> enregistrements) {
		super();
		this.enregistrements = enregistrements;
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
